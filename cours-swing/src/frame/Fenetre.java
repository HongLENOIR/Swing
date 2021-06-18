package frame;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import dao.PersonnelDao;
import model.Personne;

public class Fenetre extends JFrame implements ActionListener { // une class interface

	JLabel nomLabel = new JLabel("Nom");
	JTextField nomText = new JTextField();
	
	JLabel prenomLabel = new JLabel("PréNom");
	JTextField prenomText = new JTextField();
	
	JButton bouton = new JButton("Afficher");
	
	public Fenetre()  {
		this.setSize(500, 500); // setSize défini dans JFrame, this pourrait etre supprimer en raison sans opscure
		setVisible(true);
		setTitle("First frame"); // cliquer > pour paraitre le fenetre
		
		// 'Bounds' indique les parametres (l'emplacement) dans la fenetre
		nomLabel.setBounds(20, 20, 100, 20);
		nomText.setBounds(150, 20, 100, 20 );
		
		prenomLabel.setBounds(20, 50, 100, 20);
		prenomText.setBounds(150, 50, 100, 20);
		
		
		bouton.setBounds(150, 400, 200, 20);
		add(nomLabel); 
		// 'add' attache les composants dans la fenetre;
		add(nomLabel);
		add(nomText);
		add(prenomLabel);
		add(prenomText);
		add(bouton);
		setLayout(null); // dans swing, 'setLayout' déplace sur la fenetre   
		
		
		// 3 etapes, cliquer 'bouton' +recuper les textes + afficher les text 
		bouton.addActionListener(this); // ce bouton ajoute à l'écouteur cette action 'this'
	}

	@Override
	public void actionPerformed(ActionEvent e) { // cette méthode exécute juste quand on clique le bouton
		String nom = nomText.getText(); // tous ses proprieties pas seulement le text saisi
		String prenom = prenomText.getText();
		
		Personne personne = new Personne(nom, prenom);
		PersonnelDao dao = new PersonnelDao();
		dao.save(personne);
		
		
		JOptionPane.showMessageDialog(null, "personne ajoutée avec succès"); 
		
		// window
	}

}
