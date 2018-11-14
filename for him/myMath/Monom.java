
package myMath;

/**
 * This class represents a simple "Monom" of shape a*x^b, where a is a real
 * number and a is an integer (summed a none negative), see:
 * https://en.wikipedia.org/wiki/Monomial The class implements function and
 * support simple operations as: construction, value at x, derivative, add and
 * multiply.
 * 
 * @author Boaz
 *
 */
public class Monom implements function {

	private double _coefficient; 
	private int _power;

	public Monom(double a, int b) {

		this.set_coefficient(a);
		this.set_power(b);
	}

	public Monom(Monom ot) {
		this(ot.get_coefficient(), ot.get_power());

	}

	// ***************** add your code below **********************
	public Monom(){

	}
	/**
	 * this function will get an Monom and will add it to the Monom who called it.
	 * @param  toAdd: the Monom we wants to add.
	 * @return true if succeed with adding the Monom or false if we didn't succeed .
	 */
	public boolean Add (Monom toAdd) {
		if (this._power == toAdd._power) {
			set_coefficient(this._coefficient + toAdd._coefficient);
			return true;
		}
		return false;
	}

	/**
	 * this function will get an Monom and will multiply it to the Monom who called it.
	 * @param  multIn: the Monom we wants to multiply.
	 */

	public void Multiply(Monom multIn) {
		set_power(this._power+multIn._power);
		set_coefficient(this._coefficient*multIn._coefficient);
	}


	/**
	 * this function will get an "x" and return the value of its "y" (we looked upon the function f as its was an point in graph).
	 * @param  x: the double we get to represent as value of x in a point.  
	 * @return the value of y in a point .
	 */

	public double f(double x) {
		double y = this.get_coefficient() * Math.pow(x, this.get_power());
		return y;
	}

	/**
	 * this function will take the Monom and create an new Monom and fill it with the derivative of the original one.
	 * @param  der_fx: is a new Monom that we will fill with the derivative of the original Monom.
	 * @return der_fx after we fill it with the derivative of the original Monom .
	 */
	public Monom derivative() {
		Monom der_fx;
		if (this._power != 0) {
			der_fx = new Monom(this._coefficient * this._power, this._power - 1);
		} else {
			der_fx = new Monom(0, 0);
		}
		return der_fx;
	}

	/**
	 * this function will take an Monom and produce a String according  to it.
	 * @return String that will present the Monom .
	 */
	public String toString() {
		return _coefficient + "x^" + _power;
	}

	public double get_coefficient() {
		return this._coefficient;
	}

	public int get_power() {
		return this._power;
	}

	/**
	 * this function will test if two Monom are the same. 
	 * @param m1:is an Monom that we want to test if he is equals to the Monom who called the function.
	 * @return true if both equals or false if not.
	 */
	public boolean isEquals(Monom m1) {
		if(m1.get_coefficient()==this.get_coefficient() && m1.get_power()==this.get_power()) {
			return true;
		}

		return false;
	}
	// ****************** Private Methods and Data *****************

	private void set_coefficient(double a) {
		this._coefficient = a;
	}

	private void set_power(int p) {
		this._power = p;
	}

}