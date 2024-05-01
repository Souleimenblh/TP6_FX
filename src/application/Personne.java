package application;

public class Personne {
	
	
	private String prenom;
	private String nom;
	private String email;
	
	public Personne(String prenom, String nom, String email) {
		super();
		this.prenom = prenom;
		this.nom = nom;
		this.email = email;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Personne [prenom=" + prenom + ", nom=" + nom + ", email=" + email + "]";
	}
	
	
	
	

}
