package montirgol;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ShapeContainer  {
	
	ArrayList<IShape> a=new ArrayList<>();
	
	public void add(IShape s) {
		a.add(s);
	}
	public void sortByArea() {
		Collections.sort(a, new Sortbya());
		
	}
	public void sortByPerimeter() {
		
		Collections.sort(a, new Sortbyp());
	}
	
	public void tostring (){
		
		for(int i=0 ;i<a.size();i++) {
			System.out.println((i+1)+": "+"primeter:" +a.get(i).getPerimeter() +"," +"area: "+ a.get(i).getArea());
		}
	}


}

    class Sortbyp implements Comparator<IShape>{
	
	

	@Override
	public int compare(IShape o1, IShape o2) {
		
		return (int)(o1.getPerimeter()-o2.getPerimeter());
	}

	
}


    class Sortbya implements Comparator<IShape>{

	@Override
	public int compare(IShape o1, IShape o2) {
		
		return (int)(o1.getArea()-o2.getArea());
	}
	
	
	
}