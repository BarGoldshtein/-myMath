package Tester;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import myMath.Monom;
import myMath.Polynom;

class TestPolynom {

	
	@Test
	void testPolynomString() {
		String PolyString="2.0x^4+3.0x^3-4.0x^2-1.0x^1-0";
		Monom a = new Monom(2,4);
		Monom b = new Monom(3,3);
		Monom c = new Monom(-4,2);
		Monom d = new Monom(-1,1);
		
		Polynom Poly=new Polynom(PolyString);
		Polynom PolyMun = new Polynom();
		PolyMun.add(a);
		PolyMun.add(b);
		PolyMun.add(c);
		PolyMun.add(d);
		
		assertTrue(PolyMun.equals(Poly));
	}

	@Test
	void testF() {
		String PolyString="2.0x^4+3.0x^3-4.0x^2-1.0x^1-0";
		Polynom poly = new Polynom(PolyString);
		double y=0;
		double x=-6;
		for(int i=0; i<poly.Mtp.size(); i++) {
			y+=poly.Mtp.get(i).f(x);											
		}
		assertEquals(y, poly.f(x));
	}

	@Test
	void testAddPolynom_able() {
		String PolyString="2.0x^4+3.0x^3-4.0x^2-1.0x^1-0";
		Polynom Poly = new Polynom(PolyString);
		String PolyStringadd="5.0x^8+2.0x^6-7.0x^3-1.0x^2-1.0x^1";
		Polynom Polyadd = new Polynom(PolyStringadd);
		String PolyStringAdded = "5.0x^8+2.0x^6+2.0x^4-4.0x^3-5.0x^2-2.0x^1";
		Polynom PolyAdded = new Polynom(PolyStringAdded);
		Poly.add(Polyadd);
		assertTrue(PolyAdded.equals(Poly));
	}


	@Test
	void testSubstract() {
		String PolyString="2.0x^4+3.0x^3-4.0x^2-1.0x^1-0";
		Polynom Poly = new Polynom(PolyString);
		String PolyStringsubstract="5.0x^8+2.0x^6-7.0x^3-1.0x^2-1.0x^1";
		Polynom Polysub = new Polynom(PolyStringsubstract);
		String PolyStringsubstracted = "-5x^8-2.0x^6+2.0x^4+10.0x^3-3.0x^2";
		Polynom Polysubtracted = new Polynom(PolyStringsubstracted);
		Poly.substract(Polysub);
		assertTrue(Polysubtracted.equals(Poly));
		
	}

	@Test
	void testMultiply() {
		String PolyString="2.0x^4+3.0x^3-4.0x^2-1.0x^1-0";
		Polynom Poly = new Polynom(PolyString);
		String PolyStringMulty="5.0x^8+2.0x^6-7.0x^3-1.0x^2-1.0x^1";
		Polynom Polymult = new Polynom(PolyStringMulty);
		String PolyStringMultyped = "10x^12+15x^11-16x^10+x^9-8x^8-16x^7-23x^6+23x^5+8x^4+5x^3+x^2";
		Polynom Polysubtracted = new Polynom(PolyStringMultyped);
		Poly.multiply(Polymult);
		assertTrue(Polysubtracted.equals(Poly));
	}

	@Test
	void testEqualsPolynom_able() {
		String PolyString="2.0x^4+3.0x^3-4.0x^2-1.0x^1-0";
		Polynom Poly = new Polynom(PolyString);
		String PolyStringequals="2.0x^4+3.0x^3-4.0x^2-1.0x^1-0";
		Polynom Polyequals = new Polynom(PolyStringequals);
		assertTrue(Polyequals.equals(Poly));
	}
	
	@Test
     void testIsZero() {
		String PolyStringZero="0x^4+0x^3-0x^2-0x^1-0";
		Polynom PolyZero = new Polynom(PolyStringZero);
		assertTrue(PolyZero.isZero());

   }

	@Test
	void testRoot() {
		String PolyString="2.0x^4+3.0x^3-4.0x^2-1.0x^1-0";
		Polynom Poly = new Polynom(PolyString);
		double ans=Poly.root(0, 2, 0.1);
		assertEquals(1, ans);
		
	}

	@Test
	void testCopy() {
		String PolyString="2.0x^4+3.0x^3-0x^2-1.0x^1-0";
		Polynom Poly = new Polynom(PolyString);
		Polynom Polycopy=new Polynom();
		Polycopy=(Polynom)Poly.copy();
		assertTrue(Poly.equals(Polycopy));
		
	}

	@Test
	void testDerivative() {
		String PolyString="2.0x^4+3.0x^3-4.0x^2-1.0x^1-0";
		Polynom Poly = new Polynom(PolyString);
		String PolyStringderivative="8.0x^3+9.0x^2-8.0x^1-1.0x^0";
		Polynom Polyder= new Polynom(PolyStringderivative);
		Polynom Polyderr=new Polynom();
		Polyderr=(Polynom)Poly.derivative();
		assertTrue(Polyderr.equals(Polyder));
	}

	@Test
	void testArea() {
		String PolyString="2.0x^4+3.0x^3-4.0x^2-1.0x^1-0";
		Polynom Poly = new Polynom(PolyString);
		System.out.println(Poly.area(1, 10, 0.0001));
		assertEquals(Math.floor(46117.35),Math.ceil(Poly.area(1, 10, 0.000001)));
     }
}
