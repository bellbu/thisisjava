package ch18.sec03.exam02;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class ReadExample {

	public static void main(String[] args) {
	
			try {
				InputStream is = new FileInputStream("C:/JavaTest/test3.db");
				
				byte[] data = new byte[100];
				
				while(true) {
					int num = is.read(data); // is 에서 읽은 바이트를 매개값으로 주어진 data 배열에 저장 후 읽은 바이트 수를 리턴
					if(num == -1) break;
					for(int i = 0; i < num; i++) {
						System.out.println(data[i]);
					}
				}
				
				is.close();
				
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}

	}

}
