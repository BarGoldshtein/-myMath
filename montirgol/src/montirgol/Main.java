package montirgol;

import java.util.Arrays;
import java.util.Collections;

public class Main {

	public static void main(String[] args) {
		ShapeContainer sha=new ShapeContainer();
	 
		for(int i=0;i<100;i++) {
			int s=(int)(Math.random()*2);
			if(s==0) {
				sha.add(new Square(Math.random()*100));
			}
			else {
				sha.add(new Square(Math.random()*100));
			}
			
	
		}
		
		sha.sortByPerimeter();
		sha.tostring();
		

	}

}
