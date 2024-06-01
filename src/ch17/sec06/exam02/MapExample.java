package ch17.sec06.exam02;

import java.util.Arrays;
import java.util.List;

public class MapExample {
	public static void main(String[] args) {
		List<String> list2 = Arrays.asList("10, 20, 30","40, 50");
        
		list2.stream()
			.flatMapToInt(data -> {
				String[] strArr = data.split(",");
				int[] intArr = new int[strArr.length];
				for (int i = 0; i < strArr.length; i++) {
					intArr[i] = Integer.parseInt(strArr[i].trim());
					System.out.println(intArr[i]);
				}
				return Arrays.stream(intArr);
			});
		
		
		
		
		
		
		
		
		
	}
}
