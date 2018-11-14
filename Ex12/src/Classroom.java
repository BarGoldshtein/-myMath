
public class Classroom {
	Student head;
	Student tail;
	int size;


	public void add(Student s) {
		if(head==null) {
			s= new Student(s.name,s.id);
			head=s;
			tail=s;
		}
		else {
			tail.setnext(s);
			s.setprev(tail);
			tail=s; 
		}
		size++;
	}
	public void removefrist(Student s) {
		if(head!=null) {
			if(size==1) {
				head=null;
				tail=null;
			}
			else {
				head=head.getnext();
				head.setprev(null);
			}

		}
		size--;
	}


public void search(Student s) {
	if(head==s) {
		return 
	}
}
}