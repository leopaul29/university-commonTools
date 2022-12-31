package string;

import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * 
 * insererTexte a la ligne, X ligne
 * supprimerText a la ligne, X ligne
 * remplacer a la ligne, X ligne
 * supprimer a la ligne, X ligne
 * compter le nombre de ligne de code 
 * 
 * @author LeoPaul
 *
 */
public class Utils {

	public static String obtenirLigneApres(String indice, String contenu) {

		// Verfifier que l'indice existe
		//
		if(!indiceExist(indice, contenu)) return null;

		/* Obtenir le numero du premier caractère
		 *  de la premiere occurence de l'indice
		 *  dans le texte contenu
		 */
		int bloc = contenu.indexOf(indice);

		/* Déclarer un nombre qui correspond au dernier caractère
		 * de la premiere occurence de l'indice
		 * dans le texte contenu
		 */
		int bloc2 = bloc + indice.length();

		// Déclarer un string qui récupère le contenu de la ligne
		//
		String contenu_ligne = "";

		// Parcourir chaque caractère apres l'indice jusqu'au saut de ligne
		//
		for(int i = bloc2; contenu.charAt(i+1) != '\n'; i++)

			// Ajouter chaque caractère au string
			//
			contenu_ligne += contenu.charAt(i);

		// Renvoyer le contenu de la ligne apres l'indice
		//
		return contenu_ligne;
	}

	// ---										 Méthode obtenirLigneAPartir
	//
	/**
	 * Obtenir ligne a partir.
	 * Obtenir la ligne avec la première occurence de l'indice.
	 *
	 * @param indice the indice
	 * @param total the total
	 * @return the string
	 */
	public static String obtenirLigneAPartir(String indice, String total) {

		// Verfifier que le texte total contient l'indice
		//
		if(!indiceExist(indice, total)) return null;

		/* Obtenir le numero du premier caractere
		 *  de la premiere occurence de l'indice
		 *  dans le texte total
		 */
		int bloc = total.indexOf(indice);

		// Déclarer un string qui recupere le contenu de la ligne
		//
		String contenu_ligne = "";

		// Parcourir chaque caractere a partir de l'indice jusqu'au saut de ligne
		//
		for(int i = bloc; total.charAt(i+1) != '\n'; i++)

			// Ajouter chaque caractere au string
			//
			contenu_ligne+=total.charAt(i);

		// Renvoyer le contenu de la ligne apres l'indice
		//
		return contenu_ligne;
	}

	// ---										Méthode indiceExist
	//
	/**
	 * Indice exist.
	 * Vérifier que l'indice est dans le contenu.
	 *
	 * @param indice the indice
	 * @param contenu the contenu
	 * @return true, if successful
	 */
	public static boolean indiceExist(String indice, String contenu) {

		// Vérifier les paramètres
		//
		if(!verifierString(indice) || !verifierString(contenu)) return false;

		// Verfifier que le texte contenu contient l'indice
		//
		return contenu.indexOf(indice) >= 0;
	}

	// ---										 Méthode obtenirLigneContient
	//
	/**
	 * Obtenir ligne contient.
	 * Obtenir la ligne qui contient la première occurence de l'indice.
	 *
	 * @param indice the indice
	 * @param contenu the contenu
	 * @return the string
	 */
	public static String obtenirLigneContient(String indice, String contenu) {

		// Verfifier que l'indice existe
		//
		if(!indiceExist(indice, contenu) || nombreLigne(contenu) == -1) return null;

		// Parcourir chaque ligne du contenu
		//
		for(int i = 1; i <= nombreLigne(contenu); i++) {

			// Obtenir le contenu de la ligne parcouru
			//
			String contenuLigneN = obtenirLigneNumero(i, contenu);

			// Ajouter la ligne si elle contient l'indice
			//
			if(indiceExist(indice, contenuLigneN)) return contenuLigneN;
		}

		return null;
	}

	// ---										 Méthode obtenirPremiereLigne
	//
	/**
	 * obtenir premiere ligne.
	 * Obtenir la première ligne du contenu.
	 *
	 * @param contenu the contenu
	 * @return the string
	 */
	public static String obtenirPremiereLigne(String contenu) {

		// Vérfifier que le contenu n'est pas vide
		//
		if(!verifierString(contenu)) return null;

		// Déclarer un string qui récupère le contenu de la ligne
		//
		String contenu_ligne = ""; // Important pour les autres méthodes !!!

		// Parcourir chaque caractère jusqu'au saut de ligne
		//
		for(int i = 0; contenu.charAt(i+1) != '\n'; i++)

			// Ajouter chaque caractère au string
			//
			contenu_ligne += contenu.charAt(i);

		// Renvoyer le contenu de la premiere ligne
		//
		return contenu_ligne;
	}

	// ---										 Méthode obtenirLigneNumero
	//
	/**
	 * Obtenir ligne numero.
	 * Obtenir le numero de la ligne demandée dans le contenu.
	 *
	 * @param numeroLigne the numero ligne
	 * @param contenu the contenu
	 * @return the string
	 */
	public static String obtenirLigneNumero(int numeroLigne, String contenu) {

		/* Verfifier que le contenu n'est pas vide,
		 * que le numero de ligne n'est pas inferieur ou égale à 0,
		 * que le nombre de ligne soit superieur à -1
		 */
		if(!verifierString(contenu) || numeroLigne <= 0 || nombreLigne(contenu) == -1) return null;

		// Vérifier si le numero de ligne est égale à 1
		//
		if(numeroLigne == 1) return obtenirPremiereLigne(contenu);

		// Déclarer un numero de ligne parcourus
		//
		int numLigneParcouru = 1;

		do {
			// Incrémenter le nombre de ligne parcourus
			//
			numLigneParcouru ++;

			// Obtenir l'index de la prochaine ligne à parcourir
			//
			int firstLigneLength = obtenirPremiereLigne(contenu).length() + 2;

			// Redéfinir le contenu sans la première ligne
			//
			contenu = contenu.substring(firstLigneLength);

			// Vérifier si la ligne parcouru est la ligne demandée
			//
			if(numLigneParcouru == numeroLigne) return obtenirPremiereLigne(contenu);

			// Vérifier si le contenu est vide
			//
			if(contenu.isEmpty()) return null;

		} while(true);

	}

	// ---										 Méthode ligneExiste
	//
	/**
	 * Ligne existe.
	 * Vérifie si la ligne existe dans le contenu.
	 *
	 * @param numeroLigne the numero ligne
	 * @param contenu the contenu
	 * @return true, if successful
	 */
	public static boolean ligneExiste(int numeroLigne, String contenu) {

		// Vérifier si la ligne demandée n'est pas null
		//
		return obtenirLigneNumero(numeroLigne, contenu) != null;
	}

	// ---										 Méthode obtenirLignesContient
	//
	/**
	 * Obtenir lignes contient.
	 * Obtenir les lignes qui contiennent l'indice dans le contenu.
	 *
	 * @param indice the indice
	 * @param contenu the contenu
	 * @return the array list
	 */
	public static ArrayList<String> obtenirLignesContient(String indice, String contenu) {

		// Verfifier que l'indice existe
		//
		if(!indiceExist(indice, contenu) || nombreLigne(contenu) == -1) return null;

		// Déclarer un resultat
		//
		ArrayList<String> resultat = new ArrayList<String>();

		// Parcourir chaque ligne du contenu
		//
		for(int i = 1; i < nombreLigne(contenu); i++) {

			// Obtenir le contenu de la ligne parcouru
			//
			String contenuLigneN = obtenirLigneNumero(i, contenu);

			// Ajouter la ligne si elle contient l'indice
			//
			if(indiceExist(indice, contenuLigneN)) resultat.add(contenuLigneN);
		}

		// Renvoyer le resultat
		//
		return resultat;
	}

	// ---										 Méthode nombreLigne
	//
	/**
	 * Nombre ligne.
	 * Obtenir le nombre de lignes du contenu.
	 *
	 * @param contenu the contenu
	 * @return the int
	 */
	public static int nombreLigne(String contenu) {

		// Verfifier si le contenu n'est pas vide
		//
		if(!verifierString(contenu)) return -1;

		// Déclarer un numero de ligne parcourus
		//
		int numLigneParcouru = 0;

		do {
			// Incrémenter le nombre de ligne parcourus
			//
			numLigneParcouru ++;

			// Obtenir l'index de la prochaine ligne à parcourir
			//
			int firstLigneLength = obtenirPremiereLigne(contenu).length() + 2;

			// Redéfinir le contenu sans la première ligne
			//
			contenu = contenu.substring(firstLigneLength);

			// Renvoyer le nombre de ligne si le contenu est vide
			//
			if(contenu.isEmpty()) return numLigneParcouru;

		}while(true);

	}

	// ---										 Méthode obtenirLigneNumeraux
	//
	/**
	 * Obtenir ligne numeraux.
	 * Obtenir la liste des lignes demandée par numéro
	 *
	 * @param liste_ligne the liste_ligne
	 * @param contenu the contenu
	 * @return the array list
	 */	
	public static ArrayList<String> obtenirLigneNumeraux(ArrayList<Integer> liste_ligne, String contenu) {

		// Verfifier si le contenu n'est pas vide
		//
		if(!verifierString(contenu) || liste_ligne == null) return null;

		// Déclarer un résultat
		//
		ArrayList<String> resultat = new ArrayList<String>();

		// Parcourir la liste de lignes demandées
		//
		for(int i = 0; i < liste_ligne.size(); i++) {

			// Obtenir la ligne demandée
			//
			int numeroligne = liste_ligne.get(i);

			// Vérifier que la ligne existe
			//
			if(ligneExiste(numeroligne, contenu))

				// Ajouter le contenu de la ligne
				//
				resultat.add(obtenirLigneNumero(numeroligne, contenu));
		}

		// Renvoyer la liste de resultat
		//
		return resultat;
	}

	// ---										 Méthode obtenirLignesContientS
	//
	/**
	 * Obtenir lignes contient s.
	 * Obtenir la liste des lignes qui contiennent les indices recherchés
	 *
	 * @param liste_indice the liste_indice
	 * @param contenu the contenu
	 * @return the hash map
	 */
	public static HashMap<String, ArrayList<String>> obtenirLignesContientS(ArrayList<String> liste_indice, String contenu) {

		// Verfifier si le contenu n'est pas vide
		//
		if(!verifierString(contenu) || liste_indice == null) return null;

		// Déclarer un résultat
		//
		HashMap<String, ArrayList<String>> resultat = new HashMap<String, ArrayList<String>>();

		// Parcourir la liste d'indice
		//
		for(int i = 0; i < liste_indice.size(); i++) {

			// Obtenir l'indice de la liste
			//
			String indice = liste_indice.get(i);

			// Vérifier si l'indice est null ou vide, passer au prochain indice
			//
			if(indice == null || indice.isEmpty()) continue;

			// Obtenir les lignes qui contiennent l'indice
			//
			ArrayList<String> contenuIndice = obtenirLignesContient(indice, contenu);

			// Ajouter au HashMap la liste d'indice avec en clé l'indice
			//
			resultat.put(indice, contenuIndice);
		}

		// Renvoyer le resultat
		//
		return resultat;
	}

	// ---										 Méthode obtenirCouleurs
	//
	/**
	 * Obtenir couleurs.
	 * Obtenir les couleurs d'un contenu
	 *
	 * @param contenu the contenu
	 * @return the array list
	 */
	public static ArrayList<Color> obtenirCouleurs(String contenu) {

		// Verfifier si le contenu n'est pas vide
		//
		if(!verifierString(contenu)) return null;

		// Déclarer un résultat
		//
		ArrayList<Color> liste_couleur = new ArrayList<Color>();

		// Déclarer l'indice à rechercher
		//
		String indice = "java.awt.Color[";

		// Parcourir chaque ligne du contenu
		//
		for(int i = 1; i <= nombreLigne(contenu); i++) {

			// Obtenir le contenu de la ligne parcouru
			//
			String contenuLigneN = obtenirLigneNumero(i, contenu);

			// Ajouter la ligne si elle contient l'indice
			//
			while(indiceExist(indice, contenuLigneN)) {

				// Obtenir la couleur de la ligne
				//
				Color couleur = obtenirCouleurLigne(indice, contenuLigneN);

				// Vérifier que la couleur n'est pas null
				//
				if(couleur != null)

					// Ajouter la couleur à la liste
					//
					liste_couleur.add(couleur);

				// Recuperer le numero du char apres la couleur ajouté
				//
				int ind = contenuLigneN.indexOf(indice)+indice.length();

				// Recuperer la ligne sans la couleur précédente
				//
				contenuLigneN = contenuLigneN.substring(ind);
			}
		}

		// Renvoyer la liste de couleur
		//
		return liste_couleur;
	}

	// ---										Méthode obtenirCouleurLigne
	//
	/**
	 * Obtenir couleur ligne.
	 * Obtenir la couleur a une ligne
	 *
	 * @param indice the indice
	 * @param couleurLigne the couleur ligne
	 * @return the color
	 */
	public static Color obtenirCouleurLigne(String indice, String couleurLigne) {

		// Obtenir String apres l'indice java.awt.Color[
		//
		String couleur = couleurLigne.substring(couleurLigne.indexOf(indice) + indice.length());

		// Obtenir String au format [r=xxx,g=xxx,b=xx]
		//
		couleur = couleur.substring(0, couleur.indexOf(']') + 1);

		// Renvoyer la couleur
		//
		return obtenirCouleur(couleur);

	}

	// ---										Méthode obtenirCouleur
	//
	/**
	 * Obtenir couleur.
	 * Obtenir couleur depuis l'indice [r=xxx,g=xxx,b=xxx]
	 *
	 * @param couleur the couleur
	 * @return the color
	 */
	public static Color obtenirCouleur(String couleur) {

		// Vérifier que l'indice n'est pas vide
		//
		if(!verifierString(couleur)) return null;

		// --- Necessite indice : [r=xxx,g=xxx,b=xxx] --- \\

		// Obtenir le numero du rouge
		//
		int red = Integer.valueOf(couleur.substring(2, couleur.indexOf(",g=")));

		// Obtenir le numero du vert
		//		
		int green = Integer.valueOf(couleur.substring(couleur.indexOf(",g=")+3, couleur.indexOf(",b=")));

		// Obtenir le numero du bleu
		//
		int blue = Integer.valueOf(couleur.substring(couleur.indexOf(",b=")+3, couleur.indexOf(']')));

		// Renvoyer la nouvelle couleur créée
		//
		return new Color(red,green,blue);
	}
	
	public static ArrayList<String> obtenirToutesLignes(String contenu) {

		// Vérifier le paramètre
		//
		if(!verifierString(contenu)) return null;

		// Déclarer la liste des lignes
		//
		ArrayList<String> resultat = new ArrayList<String>();

		// Parcourir chaque ligne du contenu
		//
		for(int i = 1; i <= nombreLigne(contenu); i++)

			// Ajouter à la liste chaque ligne du contenu
			//
			resultat.add(obtenirLigneNumero(i, contenu));

		// Renvoyer le resultat
		//
		return resultat;
	}
	
	public static boolean verifierString(String str_a_verifier) {

		// Vérifier si la String est null
		//
		if(str_a_verifier == null) return false;

		//Vérifier si la String est vide
		//
		if(str_a_verifier.isEmpty()) return false;

		return true;
	}

	// ---										Méthode contientJJMMAAAA
	//
	/**
	 * Contient jjmmaaaa.
	 * Vérifie si la ligne contient une date au format JJ/MM/AAAA
	 *
	 * @param contenu the contenu
	 * @return true, if successful
	 */
	public static boolean contientJJMMAAAA(String contenu) {

		// Récupérer le premier "/"
		//
		int index1 = contenu.indexOf("/");
		if(index1 == -1) return false;

		// Récupérer le deuxième "/"
		//
		String index2 = contenu.charAt(index1+3) + "";
		if(!index2.equals("/")) return false;

		// Vérifier que l'annee est complète
		//
		String index3 = contenu.charAt(index1+7) + "";
		if(index3.isEmpty()) return false;

		return true;
	}

	// ---										Méthode obtenirJJMMAAAA
	//
	/**
	 * Obtenir jjmmaaaa.
	 * Obtenir la date au format JJ/MM/AAAA
	 *
	 * @param contenu the contenu
	 * @return the string
	 */
	public static String obtenirJJMMAAAA(String contenu) {

		// Vérifier que le contenu contient bien la date
		//
		if(!contientJJMMAAAA(contenu)) return null;

		// Repérer le premier "/"
		//
		int index1 = contenu.indexOf("/");
		if(index1 == -1) return null;

		// Repérer le deuxième "/"
		//
		String index2 = contenu.charAt(index1+3) + "";
		if(!index2.equals("/")) return null;

		// Récupérer la date format JJ/MM/AAAA
		//
		return contenu.substring((index1 - 2), (index1 + 8));
	}

	// ---										Méthode obtenirJour
	//
	/**
	 * Obtenir jour.
	 * Obtenir le numero du jour de la date au format JJ/MM/AAAA
	 *
	 * @param contenu the contenu
	 * @return the int
	 */
	public static int obtenirJour(String contenu) {

		// Récupérer la date format JJ/MM/AAAA
		//
		String date = obtenirJJMMAAAA(contenu);

		// Récupérer les 2 premiers chiffres
		//
		String indexH1 = date.charAt(0) + "";
		String indexH2 = date.charAt(1) + "";

		// Obtenir et renvoyer le jour
		//
		String jour = indexH1 + indexH2;
		return Integer.valueOf(jour);
	}

	// ---										Méthode obtenirMois
	//
	/**
	 * Obtenir mois.
	 * Obtenir le numero du mois de la date au format JJ/MM/AAAA
	 *
	 * @param contenu the contenu
	 * @return the int
	 */
	public static int obtenirMois(String contenu) {

		// Récupérer la date format JJ/MM/AAAA
		//
		String date = obtenirJJMMAAAA(contenu);

		// Récupérer les 2 chiffres du milieu
		//
		String indexM1 = date.charAt(3) + "";
		String indexM2 = date.charAt(4) + "";

		// Obtenir et renvoyer le mois
		//
		String mois = indexM1 + indexM2;
		return Integer.valueOf(mois);
	}

	// ---										Méthode obtenirAnnee
	//
	/**
	 * Obtenir annee.
	 * Obtenir le numero de l'année de la date au format JJ/MM/AAAA
	 *
	 * @param contenu the contenu
	 * @return the int
	 */
	public static int obtenirAnnee(String contenu) {

		// Récupérer la date format JJ/MM/AAAA
		//
		String date = obtenirJJMMAAAA(contenu);

		// Récupérer les 4 derniers chiffres
		//
		String indexA1 = date.charAt(6) + "";
		String indexA2 = date.charAt(7) + "";
		String indexA3 = date.charAt(8) + "";
		String indexA4 = date.charAt(9) + "";

		// Obtenir et renvoyer l'annee
		//
		String annee = indexA1 + indexA2 + indexA3 + indexA4;
		return Integer.valueOf(annee);
	}

	// ---										Méthode trierJJMMAAAA
	//
	/**
	 * Trier jjmmaaaa.
	 * Trier une liste de date de la plus vieille à la plus récente
	 *
	 * @param ligneDate the ligne date
	 * @return the array list
	 */
	public static ArrayList<String> trierJJMMAAAA(ArrayList<String> ligneDate) {

		// Déclarer une liste de résultat
		//
		ArrayList<String> resultat = new ArrayList<String>();
		ArrayList<String> ligneDate_bis = ligneDate;
		int nbTour = 0;

		// Parcourir les années
		//
		for(int annee = 2014; annee<2017; annee++) {

			// Parcourir les mois
			//
			for(int mois = 0; mois<13; mois++) {

				// Parcourir les jours
				//
				for(int jour = 0; jour<32; jour++) {

					// Parcourir la liste de date
					//
					for(int i = 0; i<ligneDate_bis.size(); i++) {
						nbTour ++;

						// Obtenir la date
						//
						String date = obtenirJJMMAAAA(ligneDate_bis.get(i));

						// Obtenir l'année, le mois et le jours de la date
						//
						int l_annee = obtenirAnnee(date);
						int le_mois = obtenirMois(date);
						int le_jour = obtenirJour(date);

						// Comparer les années, mois et jours
						//
						if(l_annee == annee)
							if(le_mois == mois)
								if(le_jour == jour) {

									// Ajouter a la liste de résultat
									//
									resultat.add(ligneDate_bis.get(i));
									ligneDate_bis.remove(i);
								}
					}
				}
			}
		}
		System.out.println("nbTour :"+nbTour);
		return resultat;
	}

	//------
	/*public static ArrayList<String> trier2(ArrayList<String>ligneDate) {
		
		ArrayList<Timestamp> triage_date = new ArrayList<Timestamp>();
		HashMap<Timestamp, String> triage = new HashMap<Timestamp, String>();
		ArrayList<String> ligneDate_bis = ligneDate;

		for(int i = 0; i<ligneDate_bis.size(); i++) {
			
			String date = obtenirJJMMAAAA(ligneDate_bis.get(i));
			
			Timestamp d = new Timestamp(obtenirAnnee(date), 
					obtenirMois(date), 
					obtenirJour(date), 0, 0, 0, 0);
			
			triage_date.add(d);
			triage.put(d, ligneDate.get(i));
		}
		
		Collections.sort(triage_date);
		
		for(int j = 0; j<triage_date.size(); j++) {
			
			
		}
	}*/

	// ---										Méthode contientHMS
	//
	/**
	 * Contient hms.
	 * Vérifie si la ligne contient une date au format HH:MM:SS
	 *
	 * @param contenu the contenu
	 * @return true, if successful
	 */
	public static boolean contientHMS(String contenu) {

		// Récupérer le premier ":"
		//
		int index1 = contenu.indexOf(":");
		if(index1 == -1) return false;

		// Récupérer le deuxième ":"
		//
		String index2 = contenu.charAt(index1+3) + "";
		if(!index2.equals(":")) return false;

		// Vérifier que les secondes sont complètes
		//
		String index3 = contenu.charAt(index1+3) + "";
		if(index3.isEmpty()) return false;

		return true;
	}

	// ---										Méthode obtenirHMS
	//
	/**
	 * Obtenir hms.
	 * 
	 *
	 * @param contenu the contenu
	 * @return the string
	 */
	public static String obtenirHMS(String contenu) {

		// Vérifier que le contenu contient bien la date
		//
		if(!contientHMS(contenu)) return null;

		// Repérer le premier ":"
		//
		int index1 = contenu.indexOf(":");
		if(index1 == -1) return null;

		// Repérer le deuxième ":"
		//
		String index2 = contenu.charAt(index1+3) + "";
		if(!index2.equals(":")) return null;

		// Récupérer la date format HH:MM:SS
		//
		return contenu.substring((index1 - 2), (index1 + 6));
	}

	// ---										Méthode obtenirSeconde
	//
	public static int obtenirSeconde(String contenu) {

		// Récupérer la date format HH:MM:SS
		//
		String date = obtenirHMS(contenu);

		// Récupérer les 2 derniers chiffres
		//
		String indexS1 = date.charAt(6) + "";
		String indexS2 = date.charAt(7) + "";

		// Obtenir et renvoyer les secondes
		//
		String secondes = indexS1 + indexS2;
		return Integer.valueOf(secondes);
	}

	// ---										Méthode obtenirMinute
	//
	public static int obtenirMinute(String contenu) {

		// Récupérer la date format HH:MM:SS
		//
		String date = obtenirHMS(contenu);

		// Récupérer les 2 chiffres du milieu
		//
		String indexM1 = date.charAt(3) + "";
		String indexM2 = date.charAt(4) + "";

		// Obtenir et renvoyer les minutes
		//
		String minutes = indexM1 + indexM2;
		return Integer.valueOf(minutes);
	}

	// ---										Méthode obtenirHeure
	//
	public static int obtenirHeure(String contenu) {

		// Récupérer la date format HH:MM:SS
		//
		String date = obtenirHMS(contenu);

		// Récupérer les 2 premier chiffres
		//
		String indexH1 = date.charAt(0) + "";
		String indexH2 = date.charAt(1) + "";

		// Obtenir et renvoyer les heures
		//
		String heures = indexH1 + indexH2;
		return Integer.valueOf(heures);
	}

	// ---										Méthode trierS
	//
	public static ArrayList<String> trierS(ArrayList<String> ligneDate) {

		ArrayList<String> resultat = new ArrayList<String>();
		ArrayList<String> ligneDate_bis = ligneDate;

		for(int i = 0; i<60; i++) {

			for(int j = 0; j<ligneDate_bis.size(); j++) {

				String HMS = obtenirHMS(ligneDate_bis.get(j));

				int seconde = obtenirSeconde(HMS);

				if(seconde == i) {
					resultat.add(ligneDate_bis.get(j));
					ligneDate_bis.remove(j);
				}
			}
		}

		return resultat;
	}

	// ---										Méthode trierM
	//
	public static ArrayList<String> trierM(ArrayList<String> ligneDate) {

		ArrayList<String> resultat = new ArrayList<String>();
		ArrayList<String> ligneDate_bis = ligneDate;

		for(int i = 0; i<60; i++) {

			for(int j = 0; j<ligneDate_bis.size(); j++) {

				String HMS = obtenirHMS(ligneDate_bis.get(j));

				int minutes = obtenirMinute(HMS);

				if(minutes == i) {
					resultat.add(ligneDate_bis.get(j));
					ligneDate_bis.remove(j);
				}
			}
		}

		return resultat;
	}

	// ---										Méthode trierH
	//
	public static ArrayList<String> trierH(ArrayList<String> ligneDate) {

		ArrayList<String> resultat = new ArrayList<String>();
		ArrayList<String> ligneDate_bis = ligneDate;

		for(int i = 0; i<24; i++) {

			for(int j = 0; j<ligneDate_bis.size(); j++) {

				String HMS = obtenirHMS(ligneDate_bis.get(j));

				int heures = obtenirHeure(HMS);

				if(heures == i) {
					resultat.add(ligneDate_bis.get(j));
					ligneDate_bis.remove(j);
				}
			}
		}

		return resultat;
	}

	// ---										Méthode trierHMS
	//
	public static ArrayList<String> trierHMS(ArrayList<String> ligneDate) {

		// Déclaration des variables
		//
		ArrayList<String> resultat = new ArrayList<String>();
		ArrayList<String> ligneDate_bis = ligneDate;

		// Trier par heures
		//
		for(int h = 0; h<24; h++) {
			
			// Trier par minutes
			//
			for(int m = 0; m<60; m++) {
				
				// Trier par secondes
				//
				for(int s = 0; s<60; s++) {

					// Parcourir la liste de date
					//
					for(int i = 0; i<ligneDate_bis.size(); i++) {
						
						// Obtenir la date
						//
						String HMS = obtenirHMS(ligneDate.get(i));

						// Obtenir l'heure, les minutes et les secondes
						//
						int heure = obtenirHeure(HMS);
						int minute = obtenirMinute(HMS);
						int seconde = obtenirSeconde(HMS);

						// Comparer les heures, minutes, secondes
						//
						if(heure == h)
							if(minute == m)
								if(seconde == s) {
									
									// Ajouter la ligne
									//
									resultat.add(ligneDate_bis.get(i));
									
									// La ligne la ligne
									//
									ligneDate_bis.remove(i);
								}
					}
				}
			}
		}
		//System.out.println("nbTour :"+nbTour); -> 345.600
		return resultat;
	}
}
