package ch19.sec03.exam01;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServerExample {
	private static ServerSocket serverSocket = null;

	public static void main(String[] args) {
		startServer();
							
		Scanner scanner = new Scanner(System.in);
		
		while(true) {
			String key = scanner.nextLine();
			if(key.toLowerCase().equals("q")) {
				break;
			}
		}
		
		scanner.close();
		
		stopServer();
	}
	
	public static void startServer() {
		
		Thread thread = new Thread() {
			
			@Override
			public void run() {
				try {
					serverSocket = new ServerSocket(50001);
					System.out.println("[서버] 시작됨");
					
					while(true) {
						System.out.println("\n [서버] 연결 요청 기다림\n");
						Socket socket = serverSocket.accept();
					
						InetSocketAddress isa = (InetSocketAddress) socket.getRemoteSocketAddress();  // getRemoteSocketAddress : IP와 PORT번호 얻기 위함
						System.out.println("[서버] " + "ip번호: " + isa.getHostName() + " / port번호: " +isa.getPort() + "의 연결 요청을 수락함");
						
						socket.close();
						System.out.println("[서버] " + isa.getHostName() + "의 연결을 끊음");
					}
					
				}catch (IOException e){
					System.out.println("[서버] " + e.getMessage());
					
				}
			}
			
		};
		
		thread.start();
		
	}
	
	public static void stopServer() {
		try {
			serverSocket.close();
			System.out.println("[서버] 종료됨 ");
			
		} catch(IOException e1) {
			
		}
	}

}
