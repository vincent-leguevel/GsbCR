package modeles;

public class Rapport {

	private String vis_matricule;
	private int rap_num;
	private int pra_num;
	private String rap_bilan;
	private String rap_date_visite;
	private int rap_coeff_confiance;
	private String rap_date_redaction;
	private String rap_motif;
	
	public Rapport(){
		super();
		System.out.println("Rapport::Rapport");
	}

	public String getVis_matricule() {
		return vis_matricule;
	}

	public void setVis_matricule(String vis_matricule) {
		this.vis_matricule = vis_matricule;
	}

	public int getRap_num() {
		return rap_num;
	}

	public void setRap_num(int rap_num) {
		this.rap_num = rap_num;
	}

	public int getPra_num() {
		return pra_num;
	}

	public void setPra_num(int pra_num) {
		this.pra_num = pra_num;
	}

	public String getRap_bilan() {
		return rap_bilan;
	}

	public void setRap_bilan(String rap_bilan) {
		this.rap_bilan = rap_bilan;
	}

	public String getRap_date_visite() {
		return rap_date_visite;
	}

	public void setRap_date_visite(String rap_date_visite) {
		this.rap_date_visite = rap_date_visite;
	}

	public int getRap_coeff_confiance() {
		return rap_coeff_confiance;
	}

	public void setRap_coeff_confiance(int rap_coeff_confiance) {
		this.rap_coeff_confiance = rap_coeff_confiance;
	}

	public String getRap_date_redaction() {
		return rap_date_redaction;
	}

	public void setRap_date_redaction(String rap_date_redaction) {
		this.rap_date_redaction = rap_date_redaction;
	}

	public String getRap_motif() {
		return rap_motif;
	}

	public void setRap_motif(String rap_motif) {
		this.rap_motif = rap_motif;
	}

	@Override
	public String toString() {
		return "Rapport [vis_matricule=" + vis_matricule + ", rap_num=" + rap_num + ", pra_num=" + pra_num
				+ ", rap_bilan=" + rap_bilan + ", rap_date_visite=" + rap_date_visite + ", rap_coeff_confiance="
				+ rap_coeff_confiance + ", rap_date_redaction=" + rap_date_redaction + ", rap_motif=" + rap_motif + "]";
	}	
}
