package controleurs;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import modeles.ModeleTabPraticiens;
import modeles.Praticien;
import vues.VuePraticiens;

public class ControleurTabPraticiens implements ActionListener {

	private VuePraticiens vue ;
	private ModeleTabPraticiens modele ;
	private List<Praticien> tabPraticiens ;
	
	public ControleurTabPraticiens(VuePraticiens vue) {
		super() ;
		System.out.println("ControleurTabPraticiens::ControleurTabPraticiens()") ;
		this.vue = vue ;
		this.enregistrerEcouteur() ;		
	}
	
	private void enregistrerEcouteur(){
		System.out.println("ControleurTabPraticiens::enregistrerEcouteur()") ;
		this.vue.getbCoefNotoriete().addActionListener(this) ;
		this.vue.getbCoefConfiance().addActionListener(this) ;
		this.vue.getbTempsEcoule().addActionListener(this) ;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("ControleurTabPraticiens::actionPerformed()") ;		
		Object sourceEvt = e.getSource() ;
		if(sourceEvt == this.vue.getbCoefNotoriete()) {
			
			modele = new ModeleTabPraticiens(1) ;
			this.vue.getTabPraticiens().setModel(modele);
			modele.actualiser();
		}
		else if(sourceEvt == this.vue.getbCoefConfiance()) {
			modele = new ModeleTabPraticiens(2) ;
			this.vue.getTabPraticiens().setModel(modele);
			modele.actualiser();
		}
		else if(sourceEvt == this.vue.getbTempsEcoule()) {
			modele = new ModeleTabPraticiens(3) ;
			this.vue.getTabPraticiens().setModel(modele);
			modele.actualiser();
		}
	}
	
	
	
}
