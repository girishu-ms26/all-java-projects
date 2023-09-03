
public class Student {
	public String name;
	public int age;
	public char section;
	public char gender;
	public int sub1;
	public int sub2;
	public int sub3;
	
	public Student(String name, int age, char section, char gender, int sub1, int sub2, int sub3) {
		super();
		this.name = name;
		this.age = age;
		this.section = section;
		this.gender = gender;
		this.sub1 = sub1;
		this.sub2 = sub2;
		this.sub3 = sub3;
	}


	public int total(int sub1,int sub2,int sub3) {
		int total = sub1+sub2+sub3;
		return total;
	}
	
	public double percentage(int sub1,int sub2,int sub3) {
		double total = sub1+sub2+sub3;
		double percentage = (total/300)*100;
		return percentage;
	}


	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + ", section=" + section + ", gender=" + gender + ", sub1="
				+ sub1 + ", sub2=" + sub2 + ", sub3=" + sub3 + "]";
	}
	
	

}

