package com.msg.java8;

public class Dragon {
	static int total=0; int food; String name;
	
	public Dragon(String name){
		this.name = name;
	}
	 
	public static int totalCount(){
		 return total;
	}
	
	public String feed(){
		food++;
		if (food<3) return "Still Hungry!";
		return "Full";
	}
	
	public void dracarys(){
		System.out.println("FIRE");
	}
}
