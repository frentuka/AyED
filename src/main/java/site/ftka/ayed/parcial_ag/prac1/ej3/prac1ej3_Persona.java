package site.ftka.ayed.parcial_ag.prac1.ej3;

public abstract class prac1ej3_Persona {

	private String nombre, apellido, email;

	public String getNombre() {
		return this.nombre;
	}

	public String getApellido() {
		return this.apellido;
	}

	public String getEmail() {
		return this.email;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String tusDatos() {
		return "Nombre y apellido: " + this.getNombre() + " " + this.getApellido() + "\n"
				+ "Email: " + this.getEmail() + "\n";
	}
}