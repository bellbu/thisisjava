package ch12.sec04;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Properties;
import java.util.Set;

public class GetPropertyExample {

	public static void main(String[] args) {
		String osName = System.getProperty("os.name");
		String userName = System.getProperty("user.name");
		String userHome = System.getProperty("os.home");
		System.out.println("osName: "+osName);
		System.out.println("userName: "+userName);
		System.out.println("userHome: "+userHome);

		System.out.println("---------------------------");
		System.out.println(" key: value");
		System.out.println("---------------------------");
		Properties props = System.getProperties();
		Set keys = props.keySet();
		
		for(Object objKey : keys) {
			String key = (String) objKey;
			String value = System.getProperty(key);
			System.out.printf("%-40s: %s\n",key,value);
		}
		
		Date now = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
		String strNow = sdf.format(now);
		System.out.println("현재시간 : "+strNow);
		
		LocalDateTime now2 = LocalDateTime.now();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy.MM.dd a HH:mm:ss");
		System.out.println("현재시간: "+now2.format(dtf));
		
	}

}
