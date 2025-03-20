package site.ftka.ayed.prac1.ej5;

public class prac1ej5_Tupla {
	private int max;
	private int min;
	double avg;

	public int getMax() {
		return max;
	}

	public int getMin() {
		return min;
	}

	public double getAvg() {
		return avg;
	}

	public void setMax(int max) {
		this.max = max;
	}

	public void setMin(int min) {
		this.min = min;
	}

	public void setAvg(double avg) {
		this.avg = avg;
	}

	public prac1ej5_Tupla(int max, int min, double avg) {
		this.max = max;
		this.min = min;
		this.avg = avg;
	}
}
