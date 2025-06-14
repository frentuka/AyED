package site.ftka.ayed.modulo_ag.prac1.ej3;

public class prac1ej3_Profesor extends prac1ej3_Persona {

	private String catedra, facultad;

	public String getCatedra() {
		return catedra;
	}

	public String getFacultad() {
		return facultad;
	}

	public void setCatedra(String catedra) {
		this.catedra = catedra;
	}

	public void setFacultad(String facultad) {
		this.facultad = facultad;
	}

	@Override
	public String tusDatos() {
		return super.tusDatos()
				+ "Facultad: " + this.getFacultad() + "\n"
				+ "Cátedra: " + this.getCatedra() + "\n";
	}
}