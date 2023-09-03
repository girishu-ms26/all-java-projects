
public class StudentTest {
	public static void main(String[]args) {

	Student s1 = new Student("Tulasi",22,'A','F',100,80,10);	
	
	System.out.println(s1.toString()+"  "+"Total Marks "+s1.total(s1.sub1,s1.sub2,s1.sub3)+" Percentage "+s1.percentage(s1.sub1,s1.sub2,s1.sub3));
	
	
	}
}