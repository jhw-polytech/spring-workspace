package di.collection;

import java.util.List;

/*
 * 집합객체에 대한 의존성을 공부한다.
 * 
 */

public class ListAddress {


	private List<String> address;
	private List<Integer> numbers;

	public ListAddress() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public ListAddress(List<Integer> numbers, List<String> address) {
		super();
		this.address = address;
		this.numbers = numbers;
	}


	public ListAddress(List<String> address) {
		super();
		this.address = address;
	}

	public List<String> getAddress() {
		return address;
	}

	public void setAddress(List<String> address) {
		this.address = address;
	}


	public List<Integer> getNumbers() {
		return numbers;
	}


	public void setNumbers(List<Integer> numbers) {
		this.numbers = numbers;
	}
	
}
