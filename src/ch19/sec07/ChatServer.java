package ch19.sec07;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.json.JSONObject;

public class ChatServer {

	ServerSocket serverSocket; // 소켓 필드
	ExecutorService threadPool = Executors.newFixedThreadPool(100); // 100개 스레드 관리를 위한 스레드풀 생성
	Map<String, SocketClient> chatRoom = Collections.synchronizedMap(new HashMap<>()); // synchronizedMap(): 동기화된 Map을 반환 
	 
//	@Override
//	public String toString() {
//		return "serverSocket: " + serverSocket + ", threadPool: " + threadPool+ ", chatRoom: " + chatRoom;
//	}

	// 메소드: 서버 시작
	public void start() throws IOException {
		serverSocket = new ServerSocket(50001);
		System.out.println("[서버] 시작됨");
		
		Thread thread = new Thread(() -> {
			try {
				while(true) {
					Socket socket = serverSocket.accept(); // 클라이언트 연결요청 수락 
					SocketClient sc = new SocketClient(this, socket); // 연결 수락 후 SocketClient 생성(this는 ChatServer 객체)
				}
			} catch (IOException e) {
			}
		});
		thread.start(); // 쓰레드 실행
	}
	
	// 메소드: 채팅방에 새로운 참가자 추가
	public void addSocketClient(SocketClient socketClient) {
		String key = socketClient.chatName + "@" + socketClient.clientIp;
		chatRoom.put(key, socketClient); // Map<String, SocketClient> chatRoom: 키와 값으로 채팅룸 관리  
		System.out.println("입장: "+ key);
		System.out.println("현재 채칭자 수: "+ chatRoom.size() + "\n");
		
	}
	// 메소드: 채팅방에 참가자 제거
	public void removeSocketClient(SocketClient socketClient) {
		String key = socketClient.chatName + "@" + socketClient.clientIp;
		chatRoom.remove(key);
		System.out.println("나감: "+ key);
		System.out.println("현재 채칭자 수: "+ chatRoom.size() + "\n");
		
	}
	
	// 메소드: 모든 클라이언트에게 메시지 보냄
	public void sentToAll(SocketClient sender, String message) { // sender - chatServer: ch19.sec07.ChatServer@1e6c1be0, socket: Socket[addr=127.0.0.1/127.0.0.1,port=4296,localport=50001], dis: java.io.DataInputStream@aafc91, dos: java.io.DataOutputStream@e6d02f4, clientIp: 127.0.0.1, chatName: 세번째
		JSONObject root = new JSONObject();
		root.put("clientIp", sender.clientIp);
		root.put("chatName", sender.chatName);
		root.put("message", message);
		String json = root.toString();
		
		Collection<SocketClient> socketClients = chatRoom.values(); // socketClients - [chatServer: ch19.sec07.ChatServer@1e6c1be0, socket: Socket[addr=127.0.0.1/127.0.0.1,port=4273,localport=50001], dis: java.io.DataInputStream@5fc4c52a, dos: java.io.DataOutputStream@1114ad89, clientIp: 127.0.0.1, chatName: 하이, chatServer: ch19.sec07.ChatServer@1e6c1be0, socket: Socket[addr=127.0.0.1/127.0.0.1,port=4284,localport=50001], dis: java.io.DataInputStream@431ab0d1, dos: java.io.DataOutputStream@4ddd46c2, clientIp: 127.0.0.1, chatName: 테스트]
		for(SocketClient sc : socketClients) {
			if(sc == sender) continue;
			sc.send(json);
		}
	}
	
	// 메소드: 서버 종료
	public void stop() {
		try {
			serverSocket.close();
			threadPool.shutdownNow();
			chatRoom.values().stream().forEach(sc -> sc.close());
			System.out.println("[서버] 종료됨");
		} catch (IOException e) {
		}
	}
	
	public static void main(String[] args) {
		try {
			ChatServer chatServer = new ChatServer();
			chatServer.start();
			
			System.out.println("-----------------------------------------------------------------");
			System.out.println("서버를 종료하려면 q를 입력하고 Enter");
			System.out.println("-----------------------------------------------------------------");
			
			Scanner scanner = new Scanner(System.in);
			while(true) {
				String key = scanner.nextLine();
				if(key.equals("q")) break;
			}
			scanner.close();
			chatServer.stop();
		} catch (IOException e) {
			System.out.println("[서버] " + e.getMessage());
		}
	}
	
	
}
 