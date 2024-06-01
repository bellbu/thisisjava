package ch17.sec04.exam02;

import java.util.Arrays;
import java.util.stream.IntStream;

public class StreamExample {

	public static void main(String[] args) {
		int[] intArray = {1, 2, 3, 4, 5};
		IntStream intStream = Arrays.stream(intArray);
		intStream.forEach(item -> System.out.println(item + ","));
		System.out.println();
	}
 
}
