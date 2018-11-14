
public class Course {
	int id;
	String name;
	double point;
	int grade;

	public Course(int id,String name,double point) {
		this.id =id;
		this.name=name;
		this.point=point;
		
	}
	public String toString() {
		String a=("id: "+id);
		String b=("name: "+name);
		String c=("point: "+point);
		return a+b+c;
		
	}

	
	}


