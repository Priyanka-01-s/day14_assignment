package data_structures;

import java.util.Deque;
import java.util.LinkedList;

public class Q5_PalindromeQueue {

	public static void main(String [] args) {
		Deque<Character> queue=new LinkedList<>();
		String input="radar";
		for(char ch:input.toCharArray()) {
			queue.addFirst(ch);
		}
		System.out.println(queue);
		for(char ch:input.toCharArray()) {
			char c=queue.removeFirst();
			if(ch != c) {
				System.out.println("Not palindrome");
				return;
			}
		}
		System.out.println("palindrome");
		
	}
}
