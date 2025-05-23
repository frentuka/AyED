package site.ftka.ayed.parcial_ag.prac1.ej3;

public class prac1ej3_Estudiante extends prac1ej3_Persona {

	private String comision, direccion;

	public String getComision() {
		return comision;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setComision(String comision) {
		this.comision = comision;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	@Override
	public String tusDatos() {
		return super.tusDatos()
		        + "Dirección: " + this.getDireccion() + "\n"
				+ "Comisión: " + this.getComision() + "\n";
	}
}