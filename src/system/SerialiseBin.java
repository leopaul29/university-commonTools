package system;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import string.StringTools;

public class SerialiseBin {

	/**
	 * store
	 * @param config
	 * @param nom_fichier
	 * @return
	 */
	public static boolean store (Object config, String nom_fichier ) { 

		if (config == null || StringTools.isEmptyString(nom_fichier)) return false;

		String nomFichier= nom_fichier + ".conf";

		// Construire un fichier logique et le fichier physique associe
		//
		FileOutputStream f= null;

		try {
			f= new FileOutputStream(nomFichier);

		} catch (FileNotFoundException e) {
			System.out.printf("Impossible d'enregistrer le fichier : \"" + nomFichier + "\"");
			return false;
		}

		// Construire un flux de sortie base sur le fichier logique
		//
		ObjectOutputStream out= null;

		try {
			out= new ObjectOutputStream(f);

		} catch (IOException e) {

			try {
				f.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			System.out.printf("Impossible d'enregistrer le fichier : \"" + nomFichier + "\"");
			return false;
		}

		// Serialiser la configuration dans le flux de sortie
		//
		try {
			out.writeObject(config);

		} catch (IOException e) {

			try {
				out.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			System.out.printf("Impossible d'enregistrer le fichier : \"" + nomFichier + "\"");
			return false;
		}

		// Fermer le flux et le fichier d'entree
		//
		try {
			out.close();
			f.close();

		} catch (IOException e) {
			System.out.printf("Impossible d'enregistrer le fichier : \"" + nomFichier + "\"");
			return false;
		}

		// Resultat
		//
		System.out.println("Enregistrement du fichier \"" + nomFichier + "\" : OK");
		return true;
	}

	// ---										Méthode load
	//
	/**
	 * Load.
	 * Obtenir un objet à partir d'un .conf
	 *
	 * @param nameFile 
	 * @return the object
	 */
	public static Object load (String nameFile) {

		if(StringTools.isEmptyString(nameFile)) return null;

		String nomFichier= nameFile + ".conf";

		// Construire un fichier logique correspondant
		//
		FileInputStream f= null;

		try {
			f= new FileInputStream(nomFichier);

		} catch (Exception e) {
			System.out.println("Erreur(1) sur la lecture du fichier : \"" + nomFichier + "\"");
			return null;
		}

		// Construire un flux d'entree base sur le fichier logique
		//
		ObjectInputStream in= null;

		try {
			in= new ObjectInputStream(f);

		} catch (Exception e) {

			try {
				f.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			System.out.println("Erreur(2) sur la lecture du fichier : \"" + nomFichier + "\"");
			return null;
		}

		// Acquerir et deserialiser le flux d'entree
		//
		Object resultat;

		try {
			resultat = in.readObject();

		} catch (Exception e) {

			try {
				in.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			System.out.println("Erreur(3) sur la lecture du fichier : \"" + nomFichier + "\"");
			return null;
		}

		// Fermer le flux et le fichier d'entree
		//
		try {
			in.close();
			f.close();
		}
		catch (Exception e) {
			System.out.println("Erreur sur la fermeture des flux");
			return false;
		}

		// Visualiser la reussite de l'operation dans la console
		//    
		System.out.println("Chargement du fichier " + nomFichier + " : OK");
		return resultat;
	}
}
