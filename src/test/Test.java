package test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Test {

	public static void main(String[] args) {

		String toto = "toto\ne";

		ecrireString("toto.txt", toto);
		System.out.println(lireString("toto.txt"));
	}

	public static String lireString(String path) {
		String ligne;
		StringBuilder res = new StringBuilder();
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(path));
			while ((ligne = br.readLine()) != null) {
				res.append(ligne + "\n");
			}
			br.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return res.toString();
	}

	public static void ecrireString(String path, String contains) {
		try {
			PrintWriter p = new PrintWriter(new FileWriter(path));
			p.write(contains);
			p.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
