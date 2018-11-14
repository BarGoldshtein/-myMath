
public class Student {
	int id;
	String name;
	Student next;
	Student prev;
	
	public Student(String name ,int id) {
		this.id=id;
		this.name=name;


	}
	public String tostring() {
		String a="name: "+name;
		String b="id: "+id;
		return a+b;
	}
	public Student getnext() {
	return next;
}
	public void setnext(Student next) {
	this.next=next;
	}
	
	public Student getperv() {
		return prev;
	}
	
	public void setprev(Student prev) {
		this.prev=prev;
	}
}
