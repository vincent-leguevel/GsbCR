package controleurs;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.* ;

import javax.swing.JOptionPane;

import vues.VueAPropos;
import vues.VueAuthentification;
import vues.VueGsb;
import vues.VueVisiteurs;

public class ControleurGsb implements ActionListener {

	private VueGsb vue ;
	
	public ControleurGsb(VueGsb vue) {
		super();
		System.out.println("ControleurGsb::ControleurLocavek()") ;
		this.vue = vue ;
		this.enregistrerEcouteur();
	}
	
	public VueGsb getVuePrincipale() {
		return this.vue ;
	}

	public void setVuePrincipales(VueGsb vue) {
		this.vue = vue ;
	}
	
	private void enregistrerEcouteur(){
		System.out.println("ControleurGsb::enregistrerEcouteur()") ;

		this.vue.getItemQuitter().addActionListener(this);
		this.vue.getItemDeconnecter().addActionListener(this);
		this.vue.getItemConsulterRapport().addActionListener(this) ;
		this.vue.getItemVisualiserPraticiens().addActionListener(this) ;
		this.vue.getItemAide().addActionListener(this) ;
		this.vue.getItemAPropos().addActionListener(this) ;
		this.vue.getItemVisualiserPraticiens().addActionListener(this);
		this.vue.getItemConsulterRapport().addActionListener(this) ;
		this.vue.getItemAccueil().addActionListener(this) ;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("ControleurGsb::actionPerformed()") ;
		Object sourceEvt = e.getSource() ;
		if(sourceEvt == this.vue.getItemAccueil()) {
			vue.changerVue("Accueil");
		}
		if(sourceEvt == this.vue.getItemQuitter()) {
			System.exit(0) ;
		}
		else if(sourceEvt == this.vue.getItemDeconnecter()) {
			this.vue.dispose() ;
			new VueAuthentification() ;
		}
		else if(sourceEvt == this.vue.getItemVisualiserPraticiens()){
			vue.changerVue("Praticiens") ;
		}
		else if(sourceEvt == this.vue.getItemAPropos()) {
			new VueAPropos() ;
		}
		else if(sourceEvt == this.vue.getItemConsulterRapport()) {
			vue.changerVue("Visiteurs") ;
		}
		
	}
		
	
}
