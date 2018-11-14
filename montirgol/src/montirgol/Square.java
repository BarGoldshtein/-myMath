package montirgol;

public class Square implements IShape{

	double rib;
	
	public Square (double r) {
		this.setrib(r);
	}
	
	private void setrib (double r) {
		this.rib=r;
	}
	
	private double getrib() {
		return this.rib;
	}
	
	
	@Override
	public double getPerimeter() {
		//4*rib
		return 4*(this.getrib());
		
	
	}

	@Override
	public double getArea() {
		//rib*rib
		return (this.getrib())*(this.getrib());
	}
	

}
