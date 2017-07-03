package com.afinalstone.example04_single;

public class Main {

	public static void main(String[] args) {
		testLazyBones();
		testHunger();
		testThreadStudent();
	}

	private static void testLazyBones(){
		Student_lazybones s1= Student_lazybones.getInstance();
		System.out.println(s1.hashCode());

		Student_lazybones s2= Student_lazybones.getInstance();
		System.out.println(s2.hashCode());
	}

	private static void testHunger(){
		Student_hunger ss1= Student_hunger.getInstance();
		System.out.println(ss1.hashCode());

		Student_hunger ss2= Student_hunger.getInstance();
		System.out.println(ss2.hashCode());
	}

	private static void testThreadStudent(){
		for (int i = 0; i < 3; i++) {
			new ThreadStudent().start();
		}
	}
}
