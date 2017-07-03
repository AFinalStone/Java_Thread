package com.afinalstone.example04_single;

//¶öººÊ½
public class Student_hunger {
	private static Student_hunger s=new Student_hunger();
	
	private Student_hunger() {
	}
	
	public static Student_hunger getInstance()
	{
		return s;
	}
}
