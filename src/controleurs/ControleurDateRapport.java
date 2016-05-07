package controleurs;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import modeles.ModeleListeRapports;
import modeles.ModeleTabVisiteurs;
import modeles.Rapport;
import vues.VueDateRapport;

public class ControleurDateRapport implements ActionListener {

	private VueDateRapport vue ;	
	
	public ControleurDateRapport(VueDateRapport vue){
		System.out.println("ControleurDateRapport::ControleurDateRapport()") ;
		this.vue = vue;
		ecouter();
	}
	
	public void ecouter(){
		System.out.println("ControleurDateRapport::ecouter()") ;
		this.vue.getbValider().addActionListener(this);
		this.vue.getbAnnuler().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("ControleurDateRapport::actionPerformed()") ;
		Object source = e.getSource();
		
		if(source == this.vue.getbAnnuler()){
			JOptionPane.showMessageDialog(this.vue, 
					  "Opération annulée",
					  "Annulation", 
					  JOptionPane.ERROR_MESSAGE);
			this.vue.dispose();
		}
		else if(source == this.vue.getbValider()){
			int mois = this.vue.getCbMois().getSelectedIndex()+1;
			int annee = (int) this.vue.getCbAnnee().getSelectedItem() ;
			ModeleListeRapports modele = new ModeleListeRapports();
			for(Rapport unRapport : modele.getTab(this.vue.getVis_matricule() ,mois, annee)){
				System.out.println(unRapport.toString());
			}
			this.vue.getVue().creerVueRapport(this.vue.getVis_matricule(), mois, annee);
			this.vue.getVue().changerVue("Rapport");
			this.vue.dispose();
		}
		
	}
}
