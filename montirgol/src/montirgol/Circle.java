package montirgol;

public class Circle implements IShape {
	
	double raduis;
	
	public Circle (double r) {
		this.setraduis(r);
	}
	
	
	private void setraduis(double r) {
		this.raduis=r;
	}
	
	private double getraduis() {
		return this.raduis;
	}

	@Override
	public double getPerimeter() {
		//2pi*raduis
		
		
		return Math.PI*2*this.getraduis();
	}

	@Override
	public double getArea() {
		//pi*raduis*raduis
		return Math.PI*(this.getraduis())*(this.getraduis());
	}

}
