package system;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import string.StringTools;

public class SerialiseXml {

	/**
	 * Encoder to xml.
	 * Encoder un objet en XML
	 *
	 * @param object the object
	 * @param nomFichier the nom fichier
	 * @return true, if successful
	 */
	public static boolean encoderToXML(Object object, String nomFichier) {

		// V�rifier les param�tres
		//
		if(StringTools.isEmptyString(nomFichier) || object == null) return false;

		// Ouvrir l'encodeur vers le fichier
		//
		XMLEncoder encoder = null;

		try {

			// Serialisation de l'objet
			//
			encoder = new XMLEncoder(new FileOutputStream(nomFichier));
			System.out.println("Cr�ation du fichier : \"" + nomFichier + "\"");

			// Ecrire dans le fichier
			//
			encoder.writeObject(object);
			encoder.flush();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.printf("Impossible de cr�er le fichier : \"" + nomFichier + "\"");
			e.printStackTrace();
			return false;

		} finally {

			// Fermer l'encodeur
			//
			encoder.close();
		}

		// Le fichier a �tait enregistr�
		//
		System.out.println("Enregristrement du fichier \"" + nomFichier + "\" effectu�");
		return true;
	}

	// --- 										M�thode decoderFromFichier
	//
	/**
	 * Decoder from xml.
	 * Decoder un fichier XML pour obtenir l'objet qu'il contient
	 *
	 * @param nomFichier the nom fichier
	 * @return the object
	 */
	public static Object decoderFromXML(String nomFichier) {

		// V�rifier les param�tres
		//
		if(StringTools.isEmptyString(nomFichier)) return null;

		// D�clarer un objet d'accueille du contenu XML
		//
		Object object = null;

		// Ouvrir le decodeur
		//
		XMLDecoder decoder = null;

		try {

			// De-Serialisation de l'objet
			//
			decoder = new XMLDecoder(new FileInputStream(nomFichier));

			// Obtenir l'objet encod�
			//
			object = decoder.readObject();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Erreur sur la lecture du fichier : \"" + nomFichier + "\"");
			e.printStackTrace();

		} finally {

			// fermeture du decodeur
			//
			decoder.close();
		}

		// Renvoyer l'objet
		//
		System.out.println("Chargement du fichier \"" + nomFichier + "\" effectu�");
		return object;
	}

}
