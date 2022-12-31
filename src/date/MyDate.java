package date;

import java.util.ArrayList;
import java.util.Date;

// TODO: Auto-generated Javadoc
/**
 * The Class MyDate.
 * 
 * Version V0_0_0 : Obtenir tous les champs de la date
 * 
 * Version V1_0_0 : Correction de la V0_0_0 pour le chiffre
 * 					ex : 2 minutes >>> 02 minutes
 * 
 * Version V2_0_0 : Obtenir plusieurs format de date
 * 
 * Version V3_0_0 : Calcul / Comparaison / Utilisation de durée
 * 
 * @author LeoPaul
 *
 */
public class MyDate {

	// ---										Attributs
	//
	/** The date. */
	private Date date;

	/** The liste_mois. */
	private ArrayList<String> liste_mois;

	/** The liste_jours. */
	private ArrayList<String> liste_jours;

	// ---									Constructeur par defaut
	//
	/**
	 * Instantiates a new my date.
	 */
	public MyDate() {

		this.date = new Date();

		this.liste_mois = creerListe_mois();

		this.liste_jours = creerListe_jours();
	}

	// ---										Getter & Setter
	//
	/**
	 * Gets the date.
	 *
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * Sets the date.
	 *
	 * @param date the new date
	 */
	public void setDate(Date date) {
		this.date = date;
	}

	/**
	 * Gets the liste_mois.
	 *
	 * @return the liste_mois
	 */
	public ArrayList<String> getListe_mois() {
		return liste_mois;
	}

	/**
	 * Sets the liste_mois.
	 *
	 * @param liste_mois the new liste_mois
	 */
	public void setListe_mois(ArrayList<String> liste_mois) {
		this.liste_mois = liste_mois;
	}

	/**
	 * Gets the liste_jours.
	 *
	 * @return the liste_jours
	 */
	public ArrayList<String> getListe_jours() {
		return liste_jours;
	}

	/**
	 * Sets the liste_jours.
	 *
	 * @param liste_jours the new liste_jours
	 */
	public void setListe_jours(ArrayList<String> liste_jours) {
		this.liste_jours = liste_jours;
	}

	// ---										Méthode getAnnees
	//
	/**
	 * Gets the annees.
	 *
	 * @return the annees
	 */
	public int getAnnees() {

		return getDate().getYear() + 1900;
	}

	// ---										Méthode getHeures
	//
	/**
	 * Gets the heures.
	 *
	 * @return the heures
	 */
	public String getHeures() {

		int laHeure = getDate().getHours();

		if(laHeure <= 9) return "0" + laHeure;

		return "" + laHeure;
	}

	// ---										Méthode getMinutes
	//
	/**
	 * Gets the minutes.
	 *
	 * @return the minutes
	 */
	public String getMinutes() {

		int laMinute = getDate().getMinutes();

		if(laMinute <= 9) return "0" + laMinute;

		return "" + laMinute;
	}

	// ---										Méthode getSecondes
	//
	/**
	 * Gets the secondes.
	 *
	 * @return the secondes
	 */
	public String getSecondes() {

		int laSeconde = getDate().getSeconds();

		if(laSeconde <= 9) return "0" + laSeconde;

		return "" + laSeconde;
	}

	// ---										Méthode getNumeroJour
	//
	/**
	 * Gets the numero jour.
	 *
	 * @return the numero jour
	 */
	public String getNumeroJour() {

		int laDate = getDate().getDate();

		if(laDate <= 9) return "0" + laDate;

		return "" + laDate;
	}

	// ---										Méthode getMois
	//
	/**
	 * Gets the mois.
	 *
	 * @return the mois
	 */
	public String getMois() {

		int num_mois = getDate().getMonth();

		return getListe_mois().get(num_mois);
	}

	// ---										Méthode getNumMois
	//
	/**
	 * Gets the num mois.
	 *
	 * @return the num mois
	 */
	public String getNumMois() {

		int leMois = getDate().getMonth() + 1;

		if(leMois <= 9) return "0" + leMois;

		return "" + leMois;
	}

	// ---										Méthode getJours
	//
	/**
	 * Gets the jours.
	 *
	 * @return the jours
	 */
	public String getJours() {

		int num_jours = getDate().getDay();

		return getListe_jours().get(num_jours);
	}

	// ---										Méthode getNumJour
	//
	/**
	 * Gets the num jour.
	 *
	 * @return the num jour
	 */
	public String getNumJour() {

		int leJour = getDate().getDay();

		if(leJour <= 9) return "0" + leJour;

		return "" + leJour;
	}

	// ---										Méthode creerListe_mois
	//
	/**
	 * Creer liste_mois.
	 *
	 * @return the array list
	 */
	public ArrayList<String> creerListe_mois() {

		ArrayList<String> liste_mois = new ArrayList<String>();

		liste_mois.add("Janvier");
		liste_mois.add("Fevrier");
		liste_mois.add("Mars");
		liste_mois.add("Avril");
		liste_mois.add("Mai");
		liste_mois.add("Juin");
		liste_mois.add("Juillet");
		liste_mois.add("Aout");
		liste_mois.add("Septembre");
		liste_mois.add("Octobre");
		liste_mois.add("Novembre");
		liste_mois.add("Decembre");

		return liste_mois;
	}

	// ---										Méthode creerListe_jours
	//
	/**
	 * Creer liste_jours.
	 *
	 * @return the array list
	 */
	public ArrayList<String> creerListe_jours() {

		ArrayList<String> liste_jours = new ArrayList<String>();

		liste_jours.add("Dimanche");
		liste_jours.add("Lundi");
		liste_jours.add("Mardi");
		liste_jours.add("Mercredi");
		liste_jours.add("Jeudi");
		liste_jours.add("Vendredi");
		liste_jours.add("Samedi");

		return liste_jours;
	}

	// ---										Méthode formatJJMMAAA
	//
	/**
	 * Format jjmmaaa.
	 *
	 * @return the string
	 */
	public String formatJJMMAAA() {

		return getNumeroJour() + "/" + getNumMois() + "/" + getAnnees();
	}

	// ---										Méthode formatHHMMSS
	//
	/**
	 * Format hhmmss.
	 *
	 * @return the string
	 */
	public String formatHHMMSS() {

		return getHeures() + ":" + getMinutes() + ":" + getSecondes();
	}

	// ---										Méthode formatJJMMAAAA_HHMMSS
	//
	/**
	 * Format jjmmaaaa_ hhmmss.
	 *
	 * @return the string
	 */
	public String formatJJMMAAAA_HHMMSS() {

		return formatJJMMAAA() + " " + formatHHMMSS();
	}

	// ---										Méthode contientJJMMAAAA
	//
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
	public static ArrayList<String> trierJJMMAAAA(ArrayList<String> ligneDate) {

		ArrayList<String> resultat = new ArrayList<String>();
		ArrayList<String> ligneDate_bis = ligneDate;
		int nbTour = 0;
		
		for(int annee = 2014; annee<2017; annee++) {

			for(int mois = 0; mois<13; mois++) {

				for(int jour = 0; jour<32; jour++) {

					for(int i = 0; i<ligneDate_bis.size(); i++) {
						nbTour ++;
						String date = obtenirJJMMAAAA(ligneDate_bis.get(i));

						int l_annee = obtenirAnnee(date);
						int le_mois = obtenirMois(date);
						int le_jour = obtenirJour(date);

						if(l_annee == annee)
							if(le_mois == mois)
								if(le_jour == jour) {
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

	// ---										Méthode contientHMS
	//
	public static boolean contientHMS(String contenu) {

		int index1 = contenu.indexOf(":");
		if(index1 == -1) return false;
		String index2 = contenu.charAt(index1+3) + "";
		if(!index2.equals(":")) return false;
		String index3 = contenu.charAt(index1+5) + "";
		if(index3.isEmpty()) return false;
		return true;
	}

	// ---										Méthode obtenirHMS
	//
	public static String obtenirHMS(String contenu) {

		if(!contientHMS(contenu)) return null;

		int index1 = contenu.indexOf(":");
		if(index1 == -1) return null;
		String index2 = contenu.charAt(index1+3) + "";
		if(!index2.equals(":")) return null;

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

		ArrayList<String> resultat = new ArrayList<String>();
		ArrayList<String> ligneDate_bis = ligneDate;

		for(int h = 0; h<24; h++) {

			for(int m = 0; m<60; m++) {

				for(int s = 0; s<60; s++) {

					for(int i = 0; i<ligneDate_bis.size(); i++) {

						String HMS = obtenirHMS(ligneDate.get(i));

						int heure = obtenirHeure(HMS);
						int minute = obtenirMinute(HMS);
						int seconde = obtenirSeconde(HMS);

						if(heure == h)
							if(minute == m)
								if(seconde == s) {
									resultat.add(ligneDate_bis.get(i));
									ligneDate_bis.remove(i);
								}
					}
				}
			}
		}
		//System.out.println("nbTour :"+nbTour); -> 345.600
		return resultat;
	}

	// ---										Méthode toString
	//
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {

		return getJours() + " " + getNumeroJour() + " " + getMois() + " " + getAnnees() + " à " + getHeures() + ":" + getMinutes() + ":" + getSecondes();
	}
}
