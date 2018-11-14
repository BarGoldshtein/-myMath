package myMath;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

/**
 * This class represents a Polynom with add, multiply functionality, it also
 * should support the following: 1. Riemann's Integral:
 * https://en.wikipedia.org/wiki/Riemann_integral 2. Finding a numerical value
 * between two values (currently support root only f(x)=0). 3. Derivative
 * 
 * @author Boaz
 * @param Mtp: Monom to Polynom an Array list that will hold all the Monoms and
 *        will "Make" an Polynom
 */
public class Polynom implements Polynom_able {

	// ********** add your code below ***********
	ArrayList<Monom> Mtp = new ArrayList<>();

	/**
	 * the default constructor that get nothing. the constructor build an empty
	 * Polynom (as we already knows as the Zero Polynom)
	 */
	public Polynom() {

	}

	/**
	 * An function that get an String and convert it to an Object type Polynom. the
	 * function will check if the string is legal and use only legal one.
	 * 
	 * @param       flag:will let us know if after we check if any char at String
	 *              "good" is not acceptable we break the check (then in the if
	 *              count will not be at size of "Poly").
	 * @param       Poly: the String that we get into the function.
	 * @param       good: is an String with all the acceptable chars for a
	 *              Polynom(its will help us test if "poly" is an a "good" String.
	 * @param count : will count every good Char we get in the String "Poly".
	 * @param       PolySplit: a array of the String "Poly" that all of them are
	 *              split of the string by "+".
	 * @param       PolySplitMin: a array of the String PolySplit Strings that all
	 *              of them are split of the string by "-".
	 * @param       cof:represent the coefficient of "x".
	 * @param       pow:represent the power of "x".
	 * @param       temp:tempory Monom that we will add to the new Polynom.
	 * 
	 */
	public Polynom(String Poly) {
		if (Poly.length() == 0) {

			return;
		} else {
			try {
				boolean flag = false;
				int count = 0;
				String good = "0123456789*+-.^xX";
				for (int i = 0; i < Poly.length(); i++) {
					for (int j = 0; j < good.length(); j++) {
						if (Poly.charAt(i) == good.charAt(j)) {
							flag = true;
							count++;
							break;
						}
						if (!flag && j == good.length() - 1) {
							i = Poly.length();
						}
					}
					flag = false;
				}
				if (count != Poly.length()) {
					throw new Exception("The Polynom should be from the form: a1*x^b1 + a2*x^b3 + ... + an*x^bn");
				} else {
					Poly.toLowerCase();
					String[] PolySplit = Poly.split("[+]");
					double cof = 0;
					int pow = 0;
					for (int i = 0; i < PolySplit.length; i++) {
						String[] PolySplitMin = PolySplit[i].split("(?=-)");
						for (int j = 0; j < PolySplitMin.length; j++) {
							if (PolySplitMin[j].contains("x") && PolySplitMin[j].contains("^")) {
								String[] PolySplitXpSpaces = PolySplitMin[j].split("[*x^]");
								String[] PolySplitXp = cleanEmptySpaces(PolySplitXpSpaces);
								if (PolySplitXp.length > 1) {
									if (PolySplitXp[0].equals("-")) {
										cof = -1;
										pow = Integer.parseInt(PolySplitXp[1]);
									} else {
										cof = Double.parseDouble(PolySplitXp[0]);
										pow = Integer.parseInt(PolySplitXp[1]);
									}
								} else {
									cof = 1;
									pow = Integer.parseInt(PolySplitXp[0]);
								}
							} else if (PolySplitMin[j].contains("x") && PolySplitMin[j].length() > 1) {
								String[] PolySplitXp = PolySplitMin[j].split("[x]");
								cleanEmptySpaces(PolySplitXp);
								cof = Double.parseDouble(PolySplitXp[0]);
								pow = 1;
							} else if (PolySplitMin[j].contains("x")) {
								cof = 1;
								pow = 1;
							} else {
								cof = Double.parseDouble(PolySplitMin[j]);
								pow = 0;
							}
							Monom temp = new Monom(cof, pow);
							this.add(temp);
						}
					}
					this.cleanUp();
				}
			} catch (Exception e) {
				System.err.println(e);
			}
		}
	}

	/**
	 * This function getting an "x" and give back "y".
	 * 
	 * @param x: with this double we will get the value of "y".
	 * @param ans: will represent the "y" of the "x" we got.
	 * @return the function returning the value of "y".
	 */
	@Override
	public double f(double x) {
		double ans = 0;
		for (int i = 0; i < this.Mtp.size(); i++) {
			ans += this.Mtp.get(i).f(x);
		}
		return ans;
	}

	/**
	 * This function getting an Polynom and adding it to a Polynom.
	 * @param p1: an Polynom that i get for adding it to and existent Polynom.
	 * @param itr: iterator we a use to move over the Polynom "p1".
	 * @param temp:will help to hold the Monoms from "p1".
	 * 
	 */
	@Override
	public void add(Polynom_able p1) {
		Iterator<Monom> itr = p1.iteretor();
		Monom temp;
		while (itr.hasNext()) {
			temp = itr.next();
			this.add(temp);
		}
		this.cleanUp();
	}

	/**
	 * This function getting an Monom and add it to an Polynom.
	 * @param m1:an Monom that we got for adding it to an Polynom.
	 */
	@Override
	public void add(Monom m1) {
		for (int i = 0; i < this.Mtp.size(); i++) {
			if (this.Mtp.get(i).Add(m1)) {
				return;
			}
		}
		this.Mtp.add(m1);
		this.cleanUp();
	}

	/**
	 * this function will get an Polynom and subtract it from the Polynom that
	 * called the function
	 * @param itr:the iterator(pointer) that move over the the Polynom.
	 * @param negativer: an Monom that is (-1) for multiply the Monoms of p1 so when
	 *        we add it to the original Polymon its will substract from it.
	 * @param temp: this Monom will hold the data that the pointer point on.
	 * @param m: deep copy of the data that Monom temp holds
	 */
	@Override
	public void substract(Polynom_able p1) {
		Iterator<Monom> itr = p1.iteretor();
		Monom negativer = new Monom(-1, 0);
		while (itr.hasNext()) {
			Monom temp = itr.next();
			Monom m = new Monom(temp);
			m.Multiply(negativer);
			this.add(m);
		}
		this.cleanUp();

	}

	/**
	 * this function getting an Polynom and multiply it with another Polynom.
	 * 
	 * @param p1: is the Polynom that we need to multiply the original Polynom with.
	 * @param itr:the iterator(pointer) that move over the the Polynom.
	 * @param tempPoly: will hold the result of the multiply.
	 * @param tempPoly2:will be deep copy of the original Polynom and we will use it
	 *        to multiply with "p1".
	 * @param m: Monom that will hold the data the pointer point on.
	 */
	@Override
	public void multiply(Polynom_able p1) {
		Iterator<Monom> itr = p1.iteretor();
		Polynom tempPoly = new Polynom();
		while (itr.hasNext()) {
			Polynom tempPoly2 = new Polynom(this.toString());
			Monom m = itr.next();
			tempPoly2.multiply(m);
			tempPoly.add(tempPoly2);
		}
		this.Mtp = tempPoly.Mtp;
		this.cleanUp();
	}

	/**
	 * this function will check if two Polynoms are the same one.
	 * 
	 * @param p1:the Polynom that we need to check with.
	 * @param itr: the iterator(pointer) that move over the the Polynom.
	 * @param flag: will be true if all the Monoms of the Polynoms are the same,
	 *        else will be false
	 * @param count:will count the how much Monoms there is in p1 . if count==the
	 *        original Polynom size that means that they are both at the same size.
	 * @param temp: will hold the data that the pointer point on.
	 * @return true if the Polynoms are the same else false
	 * 
	 */

	@Override
	public boolean equals(Polynom_able p1) {
		Iterator<Monom> itr = p1.iteretor();
		boolean flag = true;
		int count = 0;
		while (itr.hasNext()) {
			itr.next();
			count++;
		}
		if (this.Mtp.size() == count) {
			Monom temp;
			itr = null;// remove??
			itr = p1.iteretor();
			int index = 0;
			while (itr.hasNext()) {
				temp = itr.next();
				if (this.Mtp.get(index).isEquals(temp)) {
					flag = true;
					index++;
				} else {
					return false;
				}
			}
		} else {
			flag = false;
		}
		return flag;
	}

	/**
	 * this function its checking if the polynom is the zero Polynom. the defention
	 * of zero Polynom:http://mathworld.wolfram.com/ZeroPolynomial.html .
	 * 
	 * @return true or false according to the check if the the Polynom is the zero
	 *         one.
	 */
	@Override
	public boolean isZero() {
		if (this.Mtp.size() == 0) {
			return true;
		}
		return false;
	}

	/**
	 * this function will get x0,x1 and an epsilon will give us the root of the Polynom between them 
	 * at an offset of epsilon.
	 * @param x0: the first x we get in the function.
	 * @param x1:the second x we get in the function.
	 * @param eps:the offset we need to work by.
	 * @param mid:represent the value of the mid point between x0,x1.
	 * @param temp: help us to set x0 as bigger then x1.
	 * @return mid which represent the value of the mid point between x0,x1.
	 */

	@Override
	public double root(double x0, double x1, double eps) {
		double mid = 0;
		if (f(x0) * f(x1) <= 0) {
			if (x1 > x0) {
				double temp = x1;
				x1 = x0;
				x0 = temp;
			}
			if (x1 == x0) {
				return x0;
			}
			if (this.Mtp.get(0).get_coefficient() > 0) {
				mid = (x1 + x0) / 2;
				if (Math.abs(this.f(mid)) > eps) {
					if (f(mid) > 0) {
						return this.root(mid, x1, eps);
					} else if (this.f(mid) < 0) {
						return this.root(x0, mid, eps);
					} else {
						return mid;
					}
				} 
			}
			if (this.Mtp.get(0).get_coefficient() < 0) {
				mid = (x1 + x0) / 2;
				if (Math.abs(this.f(mid)) > eps) {
					if (f(mid) > 0) {
						return this.root(x0, mid, eps);
					} else if (this.f(mid) < 0) {
						return this.root(mid, x1, eps);
					}
				}
			}
		}
		return mid;
	}

	/**
	 * this function will perform a deep copy of Polynom.
	 * 
	 * @param temp: an Polynom that will represent our new Monom from the copy .
	 * @param tempMonom: will be a new Monom that we will add to our new Polynom
	 *        again its will be deep copy of the original Monom.
	 * @return the new Polynom after we add to it all the deep copy Monoms of the
	 *         original one
	 */

	@Override
	public Polynom_able copy() {
		if (this.Mtp.size() == 0) {

		}
		Polynom temp = new Polynom();
		for (int i = 0; i < this.Mtp.size(); i++) {
			Monom tempMonom = new Monom(this.Mtp.get(i).get_coefficient(), this.Mtp.get(i).get_power());
			temp.add(tempMonom);
		}
		temp.cleanUp();
		return temp;
	}

	/**
	 * this function will take the Polynom and create an new Polynom and fill it
	 * with the derivative of the original one.
	 * 
	 * @param itr: iterator we a use to move over the our Polynom(the one who called
	 *        the function).
	 * @param Poly: the new Polynom that will hold the Original Polynom after we
	 *        derivative it.
	 * @param temp: a new Monom that will hold the data that we got from what the
	 *        pointer is pointing on(the iterator).
	 * @return we return the new Polynom after we create it according to the
	 *         derivative of the original one.
	 */

	@Override
	public Polynom_able derivative() {
		Iterator<Monom> itr = this.iteretor();
		Polynom poly = new Polynom();
		Monom temp = new Monom();
		while (itr.hasNext()) {
			temp = itr.next();
			temp = temp.derivative();
			poly.add(temp);
		}
		poly.cleanUp();
		return poly;
	}

	/**
	 * this function will get x0,x1,eps the function will calculate the area between
	 * x0 to x1 using squares that each square is at the size of eps.
	 * 
	 * @param x0:the first x (we used it as x of a point).
	 * @param x1:the second x (same as the first one we used it as x of a point).
	 * @param eps: the size of the squares (only width not the height).
	 * @param sumOfArea: will hold the size of area between x0 to x1.
	 * @param numOfSquares: an int that will hold how much squares we have.
	 * @param temp:will hold the minimum between x0,x1.
	 * @param yTemp: will be the y of any given x(point)
	 * @param Area: the area of any given square according to its high and width.
	 * @return sumOfArea if x0!=x1 because if its is the area between them is 0.
	 */

	@Override
	public double area(double x0, double x1, double eps) {
		double sumOfArea = 0;
		try {
			if (eps < 0) {
				throw new Exception("epsilon must be a positive number, and it's " + eps);
			}

			if (x1 > x0) {
				int numOfSquares = (int) Math.ceil((x1 - x0) / eps);
				double temp = x0;
				for (int i = 0; i < numOfSquares; i++) {
					double yTemp = this.f(temp);
					double Area = Math.abs(yTemp * eps);
					sumOfArea += Area;
					temp += eps;
				}

			} else if (x0 > x1) {
				int numOfSquares = (int) Math.ceil((x0 - x1) / eps);
				double temp = x1;
				for (int i = 0; i < numOfSquares; i++) {
					double yTemp = this.f(temp);
					double Area = Math.abs(yTemp * eps);
					sumOfArea += Area;
					temp += eps;
				}

			} else {
				return sumOfArea;
			}

		} catch (Exception e) {
			System.err.println(e);
		}

		return sumOfArea;
	}

	/**
	 * this function will take the Polynom and export it into String.
	 * 
	 * @param Poly: an empty String that we fill in with the Monoms from the
	 *        Polynom.
	 * @return the String Poly if the Polynom is not empty else returning String
	 *         "0.0".
	 */

	public String toString() {
		if (this.Mtp.size() > 0) {
			String Poly = "";
			if (this.Mtp.get(0).get_coefficient() < 0) {
				Poly += this.Mtp.get(0).toString();
			} else {
				Poly += this.Mtp.get(0).toString();
			}
			for (int i = 1; i < this.Mtp.size(); i++) {
				if (this.Mtp.get(i).get_coefficient() < 0) {
					Poly += this.Mtp.get(i).toString();
				} else {
					Poly += "+" + this.Mtp.get(i).toString();
				}
			}
			return Poly;
		} else {
			return "0.0";

		}
	}

	/**
	 * this function will create an pointer that will help us move over an Array of
	 * Monoms will be called (Polynom).
	 * 
	 * @param itr:the pointer to move the Array.
	 * @return the pointer.
	 */

	@Override
	public Iterator<Monom> iteretor() {
		Iterator<Monom> itr = Mtp.iterator();

		return itr;
	}
	// ****************** Private Methods and Data *****************

	/**
	 * this function get an Monom and multiply it with the Polynom
	 * 
	 * @param m1:the Monom we get for the multiply
	 * @param itr:will be the iterator for moving on mtp(MonomtoPolynom) Array list
	 *        .
	 * @param temp:an Monom that will hold the data which the pointer(iterator)
	 *        point on
	 */

	private void multiply(Monom m1) {
		Iterator<Monom> itr = this.iteretor();
		Monom temp;
		while (itr.hasNext()) {
			temp = itr.next();
			temp.Multiply(m1);
		}
	}

	/**
	 * this function will take the Polynom and remove any Monom that equals to zero.
	 * 
	 * @see we used Collections.sort to sort the Polynom according to the powers of
	 *      the Monoms. the source we used:
	 *      https://www.geeksforgeeks.org/collections-sort-java-examples/
	 */
	private void cleanUp() {
		for (int i = 0; i < this.Mtp.size();) {
			if (this.Mtp.get(i).get_coefficient() == 0.0) {
				this.Mtp.remove(i);
			} else {
				i++;
			}
		}
		Collections.sort(this.Mtp, new Monom_Comperator());
	}

	/**
	 * this function will erase any empty spaces in the String.
	 * 
	 * @param str:the String put in the function for the cleaning.
	 * @param counter:count the non-empty spaces.
	 * @param strNoSpaces:a String in the size of "counter" its will host the new
	 *        String we will give back.
	 * @param index: will help us check when we got to the size of "strNoSpaces".
	 * @return the new String we build "strNoSpaces" that is a String with no empty
	 *         spaces.
	 * 
	 */
	private String[] cleanEmptySpaces(String[] str) {
		int counter = 0;
		for (int i = 0; i < str.length; i++) {
			if (!(str[i].equals(""))) {
				counter++;
			}
		}
		String[] strNoSpaces = new String[counter];
		int index = 0;
		while (index < strNoSpaces.length) {
			for (int i = 0; i < str.length; i++) {
				if (!(str[i].equals(""))) {
					strNoSpaces[index] = str[i];
					index++;
				}
			}
		}
		return strNoSpaces;
	}
}
