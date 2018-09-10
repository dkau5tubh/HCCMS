package com.hccms.beans;

public class Demo {
	public static void main(String[] args) {
		String str="P22Y";
		String str1=str.replaceAll("[A-Z]", "");
		System.out.println(str);
		System.out.println(str1);
	}

}
