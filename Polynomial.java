import java.io.*;

public class Polynomial{
	private double[] coeff;
	private int[] exponents;
	
	public Polynomial() {
		this.coeff = new double[0];
		this.exponents = new int[0];
	}
	
	public Polynomial(double[] co, int[] ex) {
		if (co.length == 0) {
			coeff = new double[] {0};
		}
		else {
			this.coeff = new double[co.length];
			this.exponents = new int[ex.length];
			for (int i=0; i<co.length; i++) {
				this.coeff[i] = co[i];
				this.exponents[i] = ex[i];
			}
		}
	}
	
	public Polynomial add (Polynomial other) {
		int n = coeff.length;
		int m = other.coeff.length;

		double[] resultCoeff = new double[n+m];
		int[] resultExpo = new int[n+m];
		int k = 0;

		for(int i = 0; i < n; i++){
			double co = coeff[i];
			int ex = exponents[i];

			int j = 0;
			while (j<m && other.exponents[j] != ex) j++;

			if(j<m){
				double sum = co + other.coeff[j];
				if (sum != 0.0){
					resultCoeff[k] = sum;
					resultExpo[k] = ex;
					k++;
				}
			}
			else{
				resultCoeff[k] = co;
				resultExpo[k] = ex;
				k++;
			}
		}

		for (int j=0; j<m; j++){
			int e = other.exponents[j];
			
			int i=0;
			while (i<n && exponents[i] != ex) i++;

			if (i==n){
				resultCoeff[k] = other.coeff[j];
				resultExpo = ex;
				k++
			}
		}

		}
		double[] finalCoeff = trim(resultCoeff,k);
		int[] finalExpo = trim(resultExpo, k);
		return new Polynomial(finalCoeff, finalExpo);
	}
	
	public double evaluate (double x) {
		double result = 0;
		for (int k = 0; k < coeff.length; k++) {
			result += coeff[i] * Math.pow(x, exponents[i]);
		}
		return result;
	}
	
	public boolean hasRoot (double x) {
		return evaluate(x) == 0.0;
	}

	public Polynomial multiply (Polynomial other){
		Polynomial result = new Polynomial();
		for(int i = 0; i< this.coeff.length; i++){
			for(int j=0; j<other.coeff.length; j++){
				double a = this.coeff[i] * other.coeff[j];
				int p = this.exponents[i] + other.exponents[j];
				result.removeDuplicate(co, ex);
			}
		}
		return result;
	}


	public Polynomial(File f) throws IOException{
		this.coeff = new double[0];
		this.exponents = new int[0];

		try(BufferedReader br = new BufferedReader(new FileReader(f))){
			String s = br.readLine();
			if (s==null) return;
			s = s.trim();
			if (s.isEmpty()) return;

			if (s.charAt(0) != '+' && s.charAt(0) != '-'){
				s = "+" + s;
			}

			int i=0;
			while (i < s.length()){
				char sign = s.charAt(i);
				int j = i + 1;
				while (j< s.length() && s.charAt(j) != '+' && s.charAt(j) != '-') j++;

				String piece = s.substring(i+1, j);
				int xPosition = piece.indexOf('x');

				double co;
				int ex;
				if (xPosition == -1){
					co = Double.parseDouble(piece);
					ex = 0;
				}
				else{
					co = Double.parseDouble(piece.substring(0, xPosition));
					ex = Integer.parseInt(piece.substring(xPosition + 1));
				}

				if(sign == '-') c = -c;

				removeDuplicate(co, ex);
				i=j;
			}
		}
	}





	public void saveToFile(String filename) throws IOException {
		try (PrintWriter out = new PrintWriter(new FileWriter(filename))){
			if (coeff/length == 0 ){
				out.println("0");
				return;
			}

			StringBuilder sb = new StringBuilder();
			for (int i=0; i < coeff.length; i++){
				double co = coeff[i];
				int ex = exponents[i];

				if(i==0){
					if (co<0) sb.append('-');
				}
				else{
					sb.append(c<0 ? '-' : '+')
				}
				
				double abs = c<0 ? -c : c;
			}
		}
		
	}

	//helper functions

	private void removeDuplicate(double co, int ex){
		if (co==0.0) return;

		int i = 0;
		while (i < exponents.length && exponents[i] < ex) i++;

		if(i < exponents.length && exponents[i] == ex){
			double tempCoeff = coeff[i] + co;
			if (tempCoeff == 0.0){
				double[] co2 = new double[coeff.length - 1];
				int[] ex2 = new int[exponents.length - 1];
				for (int t=0; t<i; t++){
					co2[t] = coeff[t];
					ex2[t] = exponents[t];
				}
				for (int t = i+1; t<coeff.length; t++){
					co2[t-1] = coeff[t];
					ex2[t-1] = exponents[t];
				}
				coeff = co2;
				exponents = ex2;
			}
			else{
				coeff[i] = tempCoeff;
			}
			return;
		}

		double[] newCoeff = new double[coeff.length + 1];
		int[] newExpo new int[exponents.length + 1];
		for (int t=0; t<i; t++){
			newCoeff[t] = coeff[t];
			newExpo[t] = exponents[t];
		}
		newCoeff[i] = co;
		newExpo[i] = ex;

		for(int t=i; t<coeff.length; t++){
			newCoeff[t+1] = coeff[t];
			newExpo[t+1] = exponents[t];
		}
		coeff = newCoeff;
		exponents = newExpo;

	}

	private static double[] trim(double[] arr, int len){
		double[] r = new double[len];
		for (int i=0; i < len; i++){
			r[i] = arr[i];
		}
		return r;
	}

	private static int[] trim(int[] arr, int len){
		int[] r = new int[len];
		for (int i=0; i < len; i++){
			r[i] = arr[i];
		}
		return r;
	}


















	
}