
package myMath;
/**
 * This class represents a simple "Monom" of shape a*x^b, where a is a real number and a is an integer (summed a none negative), 
 * see: https://en.wikipedia.org/wiki/Monomial 
 * The class implements function and support simple operations as: construction, value at x, derivative, add and multiply. 
 * @author Boaz
 *
 */
public class Monom implements function{

	public Monom(double a, int b){
		this.set_coefficient(a);
		this.set_power(b);
	}
	public Monom(Monom ot) {
		this(ot.get_coefficient(), ot.get_power());
	}
	// ***************** add your code below **********************
	public double get_coefficient() {
		return this._coefficient;
	}

	public int get_power() {
		return this._power;
	}


	//****************** Private Methods and Data *****************

	private void set_coefficient(double a){
		this._coefficient = a;
	}
	private void set_power(int p) {
		this._power = p;
	}

	private double _coefficient; 
	private int _power;
	@Override
	public double f(double x) {
		double ans=x;
		/*int pwr=get_power();
		for(int i=0;i<pwr;i++) {
			ans=ans*x;
		}
		ans=get_coefficient()*ans;*/

		ans=Math.pow(x, this.get_power());
		ans=ans*this._coefficient;

		return ans;
	}

	public Monom derivative(Monom m) {
		Monom ans =m;
		if(m.get_power()==0) {
			ans._coefficient=0;
		}
		else {
			ans._coefficient=m._power*m._coefficient;
			ans._power--;

		}
		Monom mon=new Monom(m.get_coefficient(),ans.get_power());
		return mon;
	}




	public void add(Monom b) {
		if(this.get_power()==b.get_power()) {
			this._coefficient=this._coefficient+b._coefficient;

		}


	}



	public void multiply( Monom b) {
		this._coefficient=this._coefficient*b._coefficient;
		this._power=this._power+b._power;


	}


}
