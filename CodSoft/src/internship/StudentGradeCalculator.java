package internship;

import java.util.Scanner;

class StudentGradeCalculator {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		
		System.out.print("Please Enter Number of Subjects : ");
		int subCount = sc.nextInt();
		int[] marks = new int[subCount];
		int sum = 0, average = 0;
		boolean fail = false;
		
		for (int i = 0; i < subCount; i++) {
			int mark = getMark(i);
			marks[i]=mark;
			if(marks[i]<40)
				fail = true;
			sum+=marks[i];
		}
		average = sum/subCount;
		if(sum!=0 && average!=0) {
			System.out.println("Total marks : "+ sum + " out of " +(100*subCount));
			System.out.println("Percentage is : "+average+"%");
			if(fail==true)
				System.out.println("==F Grade==");
			else if(average<=50)
				System.out.println("==E Grade==");
			else if(average<=55)
				System.out.println("==D Grade==");
			else if(average<=60)
				System.out.println("==D+ Grade==");
			else if(average<=65)
				System.out.println("==C Grade==");
			else if(average<=70)
				System.out.println("==C+ Grade==");
			else if(average<=75)
				System.out.println("==B Grade==");
			else if(average<=80)
				System.out.println("==B+ Grade==");
			else if(average<=90)
				System.out.println("==A Grade==");
			else if(average<=100)
				System.out.println("==A+ Grade==");
		}

	}

	static int getMark(int i) {
		System.out.print("Enter " + (i+1) + " Subject Mark(out of 100) : ");
		int mark = sc.nextInt();
		if(mark>100||mark<0) {
			System.out.println("Please Enter Mark out of 100");
			getMark(i);
		}
		return mark;
	}

}
