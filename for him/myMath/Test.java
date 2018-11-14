package myMath;

public class Test {

	public static void main( String [] args) {
		
		String pol1="-3.0x^3-6";
		String pol2="13.5x^5+2x^4-3x^2+x+1";
		Polynom pol1p=new Polynom (pol1);
		Polynom pol2p=new Polynom (pol2);
		System.out.println("String to Polynom test:");
		System.out.println("you should see: -3.0x^3-6.0 : "+pol1p);
		System.out.println("you should see:13.5x^5+2.0x^4-3.0x^2+1.0x+1.0 : " + pol2p);
		
		
		System.out.println("add test:");
		pol1p.add(pol2p);
		System.out.println("you should see: 13.5x^5+2x^4-3x^3-3x^2+x-5 : " +pol1p );
		
		
		
		double t=pol1p.area(-2, 8, 0.000001);
		System.out.println("Area");
		System.out.println(t);
		t=pol1p.root(0, 2, 0.0000000001);
		System.out.println("root");
		System.out.println(t);
		
	}
}
