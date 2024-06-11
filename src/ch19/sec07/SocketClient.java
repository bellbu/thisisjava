package ch19.sec07;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

import org.json.JSONObject;

public class SocketClient {

	ChatServer chatServer;
	Socket socket;
	DataInputStream dis;
	DataOutputStream dos;
	String clientIp;
	String chatName;
	
	public SocketClient(ChatServer chatServer, Socket socket) {

		try {
			this.chatServer = chatServer;
			this.socket = socket;
			this.dis = new DataInputStream(socket.getInputStream());
			this.dos = new DataOutputStream(socket.getOutputStream());
			InetSocketAddress isa = (InetSocketAddress) socket.getRemoteSocketAddress(); // InetSocketAddress 타입으로 캐스팅하는 이유는 아래의 .getHostName() 메소드 사용하기 위해서
			this.clientIp = isa.getHostName();
			receive();
		} catch (IOException e) {
		}
		
	}
	
	// 클라이언트에게 받는 메시지 처리
	public void receive() {
		chatServer.threadPool.execute(() -> {
			try {
				while(true) {
					String receiveJosn = dis.readUTF(); // chatClient에서 dos.writeUTF(json) 메시지 보낸 경우 동작함
					JSONObject jsonObject = new JSONObject(receiveJosn);
					String command = jsonObject.getString("command");
					
					switch(command) {
						case "incoming": // 입장
							this.chatName = jsonObject.getString("data");
							chatServer.sentToAll(this, "들어오셨습니다.");
							chatServer.addSocketClient(this);
							break;
						case "message": // 메세지 보냄
							String message = jsonObject.getString("data");
							chatServer.sentToAll(this, message);
							break;
					}
				}
			} catch (Exception e) {
				chatServer.sentToAll(this, "나가셨습니다.");
				chatServer.removeSocketClient(this);
			}
		});
	}
	
	// 클라이언트에게 보내는 메소드
	public void send(String json) {
		try {
			dos.writeUTF(json);
			dos.flush();
		} catch (IOException e) {
		}
	}
	
	public void close() {
		try {
			socket.close();
		} catch (Exception e) {
		}
	}

	@Override
	public String toString() {
		return"chatServer: " + chatServer + ", socket: " + socket + ", dis: " + dis + ", dos: " + dos + ", clientIp: " + clientIp + ", chatName: " + chatName;
	}
	
	
}
