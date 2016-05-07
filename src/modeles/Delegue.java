package modeles;

public class Delegue {

	private String vis_matricule;
	private String vis_nom;
	private String vis_prenom;
	private String vis_adresse;
	private String vis_cp;
	private String vis_ville;
	private String vis_dateembauche;
	private String reg_code;
	
	public Delegue(String vis_matricule, String vis_nom, String vis_prenom,
			String vis_adresse, String vis_cp, String vis_ville,
			String vis_dateembauche) {
		super();
		this.vis_matricule = vis_matricule;
		this.vis_nom = vis_nom;
		this.vis_prenom = vis_prenom;
		this.vis_adresse = vis_adresse;
		this.vis_cp = vis_cp;
		this.vis_ville = vis_ville;
		this.vis_dateembauche = vis_dateembauche;
	}
	
	public Delegue(String vis_matricule,String vis_nom, String vis_prenom, String reg_code) {
		super();
		this.vis_matricule = vis_matricule;
		this.vis_nom = vis_nom;
		this.vis_prenom = vis_prenom;
		this.reg_code = reg_code ;
	}

	public String getVis_matricule() {
		return vis_matricule;
	}

	public void setVis_matricule(String vis_matricule) {
		this.vis_matricule = vis_matricule;
	}

	public String getVis_nom() {
		return vis_nom;
	}

	public void setVis_nom(String vis_nom) {
		this.vis_nom = vis_nom;
	}

	public String getVis_prenom() {
		return vis_prenom;
	}

	public void setVis_prenom(String vis_prenom) {
		this.vis_prenom = vis_prenom;
	}

	public String getVis_adresse() {
		return vis_adresse;
	}

	public void setVis_adresse(String vis_adresse) {
		this.vis_adresse = vis_adresse;
	}

	public String getVis_cp() {
		return vis_cp;
	}

	public void setVis_cp(String vis_cp) {
		this.vis_cp = vis_cp;
	}

	public String getVis_ville() {
		return vis_ville;
	}

	public void setVis_ville(String vis_ville) {
		this.vis_ville = vis_ville;
	}

	public String getVis_dateembauche() {
		return vis_dateembauche;
	}

	public void setVis_dateembauche(String vis_dateembauche) {
		this.vis_dateembauche = vis_dateembauche;
	}

	public String getReg_code() {
		return reg_code;
	}

	public void setReg_code(String reg_code) {
		this.reg_code = reg_code;
	}

	@Override
	public String toString() {
		return "Visiteur [vis_matricule=" + vis_matricule + ", vis_nom="
				+ vis_nom + ", vis_prenom=" + vis_prenom + ", vis_adresse="
				+ vis_adresse + ", vis_cp=" + vis_cp + ", vis_ville="
				+ vis_ville + ", vis_dateembauche=" + vis_dateembauche + "]";
	}
	
//	
	
	
	
}
