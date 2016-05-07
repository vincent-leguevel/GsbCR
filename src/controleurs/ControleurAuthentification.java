package controleurs;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import modeles.Delegue;
import modeles.ModeleDelegue;
import vues.VueAuthentification;
import vues.VueGsb;

public class ControleurAuthentification implements ActionListener {
	
	private VueAuthentification vue ;
	private ModeleDelegue visiteurBdd = new ModeleDelegue() ;
		
	public ControleurAuthentification(VueAuthentification vue){
		super() ;
		System.out.println("ControleurAuthentification::ControleurAuthentification()") ;
		this.vue = vue ;
		this.enregistrerEcouteur() ;
	}
	
	private void enregistrerEcouteur(){
		System.out.println("ControleurAuthentification::enregistrerEcouteur()") ;
		this.vue.getbConnecter().addActionListener(this) ;
		this.vue.getbAnnuler().addActionListener(this) ;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("ControleurAuthentification::actionPerformed()") ;
		Object sourceEvt = e.getSource() ;
		if(sourceEvt == this.vue.getbConnecter()) {
			String nom = this.vue.getTfLogin().getText();
			String mdp = new String(this.vue.getPfMDP().getPassword());
			if(!mdp.isEmpty() && !nom.isEmpty()){				
				Delegue delegue = visiteurBdd.connexionDelegue(nom, mdp);				
				if(delegue != null){
					this.vue.dispose();
					new VueGsb(delegue) ;				
				} 
				else if(delegue == null){
					JOptionPane.showMessageDialog(this.vue, 
							"Vos identifiants de connexion n'ont pas été reconnus",
							"Echec de l'authentification", JOptionPane.ERROR_MESSAGE);
				}
			}
			else{
				JOptionPane.showMessageDialog(this.vue, 
						  "Vos identifiants de connexion doivent être renseignés",
						  "Echec de l'authentification", 
						  JOptionPane.WARNING_MESSAGE);
			}
		}
		else if(e.getSource() == this.vue.getbAnnuler()) {
			this.vue.initialiser();
		}
	}
	
}
