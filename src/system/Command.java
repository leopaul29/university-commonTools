package system;

import java.io.File;

import string.StringTools;

public class Command {

	/**
	 * ls
	 * @param directory
	 */
	public static void ls(String directory) {

		if(StringTools.isEmptyString(directory)) return;

		File dir = new File(directory);
		int nbFiles = 0;

		if(dir.isDirectory()) {
			for(File nom : dir.listFiles()) {
				nbFiles ++;

				// S'il s'agit d'un dossier, on ajoute un "/"
				System.out.print(((nom.isDirectory()) ? nom.getName() + "/" : nom.getName()) + "\t\t");

				// Tout les 4 fichiers affiché, on saute une ligne dans l'affichage
				if((nbFiles % 4) == 0) {
					System.out.print("\n");
				}
			}
			System.out.println("\nNumber file(s) : " + nbFiles);
		} else { 
			System.out.println("\"" + directory + "\" is not a directory.");
		}
	}

	/**
	 * ls -l
	 * @param directory
	 */
	public static void lsL(String directory) {

		if(StringTools.isEmptyString(directory)) return;

		File dir = new File(directory);
		int nombre_fichier = 0;

		if(dir.isDirectory()) {

			System.out.println(dir.getName() + "/ :");

			for(File nom : dir.listFiles()){

				//S'il s'agit d'un dossier, on ajoute un "/"
				System.out.print(((nom.isDirectory()) ? nom.getName()+"/" : nom.getName()) + "\n");

				nombre_fichier ++;
			}
			System.out.println("\nNumber file(s) : " + nombre_fichier);
		} else {
			System.out.println("\"" + directory + "\" is not a directory.");
		}
	}

	/**
	 * ls -r
	 * @param directory
	 */
	public static void lsR(String directory) {

		if(StringTools.isEmptyString(directory)) return;

		File dir = new File(directory);

		if(dir.isDirectory()) {
			for(File nom : dir.listFiles()){

				// S'il s'agit d'un dossier, on ajoute un "/"
				System.out.print(((nom.isDirectory()) ? nom.getName() + "/" : nom.getName()) + "\t");

				// S'il s'agit d'un dossier, je rappelle le "ls"
				if(nom.isDirectory()) { 
					lsR(nom.getAbsolutePath());
				}
			}
			System.out.println("");
		} else {
			System.out.println("\"" + directory + "\" is not a directory.");
		}
	}



}
