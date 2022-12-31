package system;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import string.StringTools;

public class SerialiseText {

	public static boolean enregistrerSous(String nomFichier, String contenu) {

		if(StringTools.isEmptyString(nomFichier)) return false;

		File fichier = new File(nomFichier);
		if(fichier.isDirectory()) return false;

		String nouveau_contenu = contenu.replace("\n", "\r\n");

		// Si le fichier n'existe pas
		//
		if(!fichier.exists()) {

			try {

				// Création du fichier
				//
				fichier.createNewFile();
				System.out.println("Création du fichier : \"" + fichier.getName() + "\"");

			} catch (IOException e) {
				System.out.printf("Impossible de créer le fichier : \"" + fichier.getName() + "\"");
				return false;
			}
		}

		// Création un flux d'écriture
		//
		PrintWriter ecriture = null;

		try {

			// Ouvrir un flux d'écriture
			//
			ecriture = new PrintWriter(new BufferedWriter(new FileWriter(fichier)));

			// Ecrire le contenu dans le fichier
			//
			ecriture.println(nouveau_contenu);

		} catch (IOException e) {
			System.out.println("Erreur lors de l'écriture dans le fichier : \"" + fichier.getName() + "\"");
			return false;

		} finally{

			// Fermer le flux
			//
			ecriture.close();
		}

		// Le fichier a était enregistré
		//
		System.out.println("Enregristrement du fichier \"" + fichier.getName() + "\" effectué");
		return true;
	}

	public static boolean enregistrer(String nomFichier, String contenu) {

		// Vérifier les paramètres
		//
		if(StringTools.isEmptyString(nomFichier) || StringTools.isEmptyString(contenu)) return false;

		// Création de l'objet File
		//
		File fichier = new File(nomFichier);

		// Vérifier que le fichier n'est pas un répertoire
		//
		if(fichier.isDirectory()) return false;

		// Création du nouveau contenu
		//
		String nouveau_contenu = contenu.replace("\n", "\r\n");

		// Si le fichier n'existe pas
		//
		if(!fichier.exists()){

			try {

				// Création du fichier
				//
				fichier.createNewFile();
				System.out.println("Création du fichier : \"" + fichier.getName() + "\"");

			} catch (IOException e) {
				System.out.printf("Impossible de creer le fichier : \"" + fichier.getName() + "\"");
				return false;
			}
		}

		// Création un flux d'écriture
		//
		BufferedWriter ecriture = null;

		try { 

			// Ouvrir un flux d'écriture
			//
			ecriture = new BufferedWriter(new FileWriter(nomFichier, true));

			// Ecrire le contenu dans le fichier
			//
			ecriture.write(nouveau_contenu + "\r\n");

		} catch (IOException e) {
			System.out.println("Erreur lors de l'ecriture dans le fichier : \"" + fichier.getName() + "\"");
			return false;

		} finally{

			// Fermer le flux
			//
			try {
				ecriture.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		// Le fichier a était enregistré
		//
		System.out.println("Enregristrement du fichier \"" + fichier.getName() + "\" effectué");
		return true;
	}
	
	public static String charger(String nomFichier) {

		// Vérifier les paramètres
		//
		if(StringTools.isEmptyString(nomFichier)) return null;

		// Création de l'objet File
		//
		File fichier = new File(nomFichier);

		// Vérifier que le fichier n'est pas un répertoire
		//
		if(fichier.isDirectory()) return null;

		// Création d'un string pour accueillir le contenu du fichier
		//
		String contenuFichier = new String();

		// Création d'un flux de lecture
		//
		BufferedReader lecture = null;

		try {

			// Ouvrir un flux de lecture
			//
			lecture = new BufferedReader(new FileReader(nomFichier));

			// Création d'un string pour accueillir chaque lignes du fichier
			//
			String s = new String();

			// Tant que la ligne n'est pas vide
			//
			while((s = lecture.readLine()) != null) {

				// Vérifier que la ligne ne soit pas vide
				//
				if(s!=null)

					// Ajouter au contenu la ligne
					//
					contenuFichier += s+"\r\n";
			}

		} catch (IOException e) {
			System.out.println("Erreur sur la lecture du fichier : \"" + nomFichier + "\"");
			System.out.println(e);
			return null;

		} finally {

			// Fermer le flux
			//
			try {
				lecture.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		// Renvoyer le contenu du fichier texte
		//
		System.out.println("Chargement du fichier \"" + fichier.getName() + "\" effectué");
		return contenuFichier;
	}
}
