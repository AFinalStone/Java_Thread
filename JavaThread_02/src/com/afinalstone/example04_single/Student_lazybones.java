package com.afinalstone.example04_single;

//¿¡∫∫ Ω
public class Student_lazybones {

	private static Student_lazybones s=null;
	
	private Student_lazybones() {
	}
	
	public synchronized static Student_lazybones getInstance()
	{
		if(s==null)
		{
			s=new Student_lazybones();
		}
		return s;
	}

}
