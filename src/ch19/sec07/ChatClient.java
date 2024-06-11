package ch19.sec07;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

import org.json.JSONObject;

public class ChatClient {
	Socket socket;
	DataInputStream dis;
	DataOutputStream dos;
	String chatName;

	@Override
	public String toString() {
		return "socket: " + socket + ", dis: " + dis+ ", dos: " + dos + ", chatName: " + chatName;
	}

	public void connect() throws IOException {
		socket = new Socket("localhost", 50001); // 서버 소켓 연결
		dis = new DataInputStream(socket.getInputStream());
		dos = new DataOutputStream(socket.getOutputStream());
		System.out.println("[클라이언트] 서버에 연결됨");
	}
	
	public void receive() { // JSON 메시지를 받기
		Thread thread = new Thread(() -> {
			try {
				while(true) { // 계속 반복적으로 읽고 출력함
					String json = dis.readUTF(); // DataInputStream dis 데이터 있어야 동작하는 것 같음
					JSONObject root = new JSONObject(json);
					String clientIp = root.getString("clientIp");
					String chatName = root.getString("chatName");
					String message = root.getString("message");
					System.out.println("<" + chatName + "@" + clientIp + "> " + message);
				}
			} catch (Exception e) {
				System.out.println("[클라이언트] 서버 연결 끊김");
				System.exit(0);
			}
		});
		thread.start();
	}
	
	// JSON 메시지 보내기
	public void send(String json) throws IOException {
		dos.writeUTF(json);
		dos.flush();
	}
	
	// 연결 끊기
	public void unconnect() throws IOException {
		socket.close();
	}
	
	public static void main(String[] args) {
		try {
			ChatClient chatClient = new ChatClient();
			chatClient.connect(); // 서버 연결
			
			Scanner scanner = new Scanner(System.in); // System.in 은 사용자로부터 입력을 받기 위한 입력 스트림
			System.out.print("대화명 입력: ");
			chatClient.chatName = scanner.nextLine();  // nextLine(): 개행을 기준으로 한 줄을 읽음
			
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("command", "incoming");
			jsonObject.put("data", chatClient.chatName);
			String json = jsonObject.toString();
			chatClient.send(json); // 채팅방 입장("incoming")
			
			chatClient.receive(); // 채팅방 메시지 받기
			
			System.out.println("-----------------------------------------------------------------");
			System.out.println("보낼 메시지를 입력하고 Enter");
			System.out.println("채팅을 종료하려면 q를 입력하고 Enter");
			System.out.println("-----------------------------------------------------------------");
			
			// 채팅 보내기 or 종료
			while(true) {
				String message = scanner.nextLine();
				
				if(message.toLowerCase().equals("q")) {
					break;
				} else {
					jsonObject = new JSONObject();
					jsonObject.put("command", "message");
					jsonObject.put("data", message);
					json = jsonObject.toString();
					chatClient.send(json); // 서버로 JSON 메시지 보내기("message")
				}
			}
			scanner.close();
			chatClient.unconnect();
		} catch (Exception e) {
			System.out.println("[클라이언트] 서버 연결 안됨");
		}
	}
}
