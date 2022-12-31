package test;

/**
 * 
 * 
 */

import java.io.FileInputStream;
import java.io.FileNotFoundException;


// TODO: Auto-generated Javadoc
/**
 * La  Class Son.
 */
public class Son {
    
    /** Le fichier. */
    private String fichier;
    
    /** Le play. */
//    private Player play;
	private FileInputStream f; 

    
    
    /**
     * Constructeur de son.
     *
     * @param filename Constructeur
     */
    public Son(String filename) {
        this.fichier = filename;

		try {
			f = new FileInputStream(fichier);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
            }
    
    /**
     * Cette méthode permet d'arreter un son en cour.
     */
//    public void close() { if (play != null) play.close(); }

    /**
     * 
     * Cette méthide permet de lire une fois un son.
     * 
     */
    public void jouerUnefois() {
        try {
           
//            play = new Player(f);
        }
        catch (Exception e) {
            System.out.println("Probleme au niveau du " + fichier);
            System.out.println(e);
        }

        // On lance le son dans un thread
        //
        new Thread() {
            public void run() {
//                try { play.play(); }
//                catch (Exception e) { System.out.println(e); }
                
//                close();
            }
        }.start();

    }


}
