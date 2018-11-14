package Tester;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import myMath.Monom;

class TestMonom {

	@Test
	void testMonomDoubleInt() {
		int tempPow = -6;
		double tempCof = 9;
		Monom a = new Monom(tempCof, tempPow);
		if (a.get_power() < 0) {
			fail("the power need to be grater than 0 it's: " + a.get_power());
		}
	}

	@Test
	void testMonomMonom() {
		Monom a = new Monom(10, 5);
		Monom b = new Monom(a);

		b.Add(new Monom(5, 5));

		if (a.isEquals(b)) {
			fail("b shold be a deep copy of a, not a pointer");
		}
	}

	@Test
	void testAddSamePowPositivCof() {
		Monom a = new Monom(10, 5);

		Monom aOriginal = new Monom(a);
		Monom samePowToa = new Monom(5, 5);

		a.Add(samePowToa);

		assertEquals(aOriginal.get_coefficient() + samePowToa.get_coefficient(), a.get_coefficient(),
				"you have problem with add Monom in same pow test");

	}

	@Test
	void testAddSamePowNegativeCof() {
		Monom a = new Monom(10, 5);
		Monom aOriginal = new Monom(a);
		Monom samePowToaneg = new Monom(-5, 5);
		a.Add(samePowToaneg);

		assertEquals(aOriginal.get_coefficient() + samePowToaneg.get_coefficient(), a.get_coefficient(),
				"you have problem with add Monom in same pow Negative Monom");
	}

	@Test
	void testAddDiffPowPositiveCod() {
		Monom a = new Monom(10, 5);
		Monom aOriginal = new Monom(a);
		Monom difPowToa = new Monom(5, 9);
		a.Add(difPowToa);

		assertNotEquals(aOriginal.get_coefficient() + difPowToa.get_coefficient(), a.get_coefficient(),
				"you have problem with add Monom in diffrent pow Positive Monom");
	}

	@Test
	void testAddDiffPowNegtiveCod() {
		Monom a = new Monom(10, 5);
		Monom aOriginal = new Monom(a);
		Monom difPowToaneg = new Monom(-5, 9);
		a.Add(difPowToaneg);

		assertNotEquals(aOriginal.get_coefficient() + difPowToaneg.get_coefficient(), a.get_coefficient(),
				"you have problem with add Monom in diffrent pow negative Monom");
	}

	@Test
	void testMultiplySamePowDifCof() {
		Monom a = new Monom(10, 5);

		Monom aOriginal = new Monom(a);
		Monom samePowToa = new Monom(5, 5);
		a.Multiply(samePowToa);
		assertEquals(aOriginal.get_coefficient() * samePowToa.get_coefficient(), a.get_coefficient(),
				"you have problom multiply Monom with same power but diffrent cof (problom at cof)");
		assertEquals(aOriginal.get_power() + samePowToa.get_power(), a.get_power(),
				"you have problom multiply Monom with same power but diffrent cof (problom at pow)");

	}

	@Test
	void testMultiplySamePowdSameCof() {
		Monom a = new Monom(10, 5);

		Monom aOriginal = new Monom(a);
		Monom samePowsamecofToa = new Monom(10, 5);
		a.Multiply(samePowsamecofToa);
		assertEquals(aOriginal.get_coefficient() * samePowsamecofToa.get_coefficient(), a.get_coefficient(),
				"you have problom multiply Monom with same power same cof (problom at cof)");
		assertEquals(aOriginal.get_power() + samePowsamecofToa.get_power(), a.get_power(),
				"you have problom multiply Monom with same power same cof (problom at pow)");

	}

	@Test
	void testMultiplyDifPowDifCof() {
		Monom a = new Monom(10, 5);

		Monom aOriginal = new Monom(a);
		Monom difPowdifcofToa = new Monom(5, 4);
		a.Multiply(difPowdifcofToa);
		assertEquals(aOriginal.get_coefficient() * difPowdifcofToa.get_coefficient(), a.get_coefficient(),
				"you have problom multiply Monom with dif power and diffrent cof (problom at cof)");
		assertEquals(aOriginal.get_power() + difPowdifcofToa.get_power(), a.get_power(),
				"you have problom multiply Monom with dif power and diffrent cof (problom at pow)");

	}

	@Test
	void testMultiplyPowZeroDifCof() {
		Monom a = new Monom(10, 5);

		Monom aOriginal = new Monom(a);
		Monom zeroPowdifcofToa = new Monom(5, 0);
		a.Multiply(zeroPowdifcofToa);
		assertEquals(aOriginal.get_coefficient() * zeroPowdifcofToa.get_coefficient(), a.get_coefficient(),
				"you have problom multiply Monom with zero power but diffrent cof (problom at cof)");
		assertEquals(aOriginal.get_power() + zeroPowdifcofToa.get_power(), a.get_power(),
				"you have problom multiply Monom with zero power but diffrent cof (problom at pow)");

	}

	@Test
	void testMultiplyPowZeroSameCof() {
		Monom a = new Monom(10, 5);
		Monom aOriginal = new Monom(a);
		Monom zeroPowsamecofToa = new Monom(10, 0);
		a.Multiply(zeroPowsamecofToa);
		assertEquals(aOriginal.get_coefficient() * zeroPowsamecofToa.get_coefficient(), a.get_coefficient(),
				"you have problom multiply Monom with zero power and same cof (problom at cof)");
		assertEquals(aOriginal.get_power() + zeroPowsamecofToa.get_power(), a.get_power(),
				"you have problom multiply Monom with zero power and same cof (problom at pow)");

	}

	@Test
	void testFwithPlusX() {
		Monom a = new Monom(10, 5);
		double x = 7;
		double y = a.f(x);
		assertEquals((Math.pow(x, a.get_power())) * (a.get_coefficient()), y,
				"you have problem in function f with plus x");
	}

	void testFwithNegativX() {
		Monom a = new Monom(10, 5);
		double x = -7;
		double y = a.f(x);
		assertEquals((Math.pow(x, a.get_power())) * (a.get_coefficient()), y,
				"you have problem in function f with negativ x");
	}

	void testFwithZeroX() {
		Monom a = new Monom(10, 5);
		double x = 0;
		double y = a.f(x);
		assertEquals(0, y, "you have problem in function f with zero x");
	}

	@Test
	void testDerivative() {
		Monom a = new Monom(10, 5);
		Monom aOriginal = new Monom(a);
		Monom aderivative = a.derivative();
		assertEquals(aOriginal.get_power() * aOriginal.get_coefficient(), aderivative.get_coefficient(),
				"you have problem with Derivateive (on  the cof side)");
		assertEquals(aOriginal.get_power() - 1, aderivative.get_power(),
				"you have problem with Derivateive (on the power side)");
	}

	@Test
	void testGet_coefficient() {
		Monom a = new Monom(0.154646, 6);
		assertEquals(0.154646, a.get_coefficient());
	}

	@Test
	void testGet_power() {
		Monom a = new Monom(0.154646, 6);
		assertEquals(6, a.get_power());

	}

	@Test
	void testIsEquals() {
		Monom a = new Monom(0.154646, 6);
		Monom b = new Monom(a);

		assertEquals(true, a.isEquals(b));
	}
}
