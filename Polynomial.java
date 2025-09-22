public class Polynomial{
	private double[] coeff;
	
	public Polynomial() {
		coeff = new double[] {0};
	}
	
	public Polynomial(double[] x) {
		if (x.length == 0) {
			coeff = new double[] {0};
		}
		else {
			coeff = new double[x.length];
			for (int i=0; i<x.length; i++) {
				coeff [i] = x[i];
			}
		}
	}
	
	public Polynomial add (Polynomial other) {
		int max = Math.max (coeff.length, other.coeff.length);
		double[] sum = new double[max];
		for (int j=0; j<max; j++) {
			double c1=0;
			if(j<coeff.length) {
				c1 = coeff[j];
			}
			double c2=0;
			if(j<other.coeff.length) {
				c2 = other.coeff[j];
			}
			sum[j] = c1+c2;
		}
		return new Polynomial(sum);
	}
	
	public double evaluate (double x) {
		double result = 0;
		for (int k = coeff.length-1; k>=0; k--) {
			result = result * x + coeff[k];
		}
		return result;
	}
	
	public boolean hasRoot (double x) {
		return evaluate(x) == 0.0;
	}
	
}
