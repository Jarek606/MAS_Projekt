package test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import biblioteka.Ksiazka;
import objectplus.ObjectPlus;

public class main {
	
	final static String extension = "extension_test.bin";

	public static void main(String[] args) throws Exception {
		 try {
				// Odczytaj ekstensje ze strumienia
				ObjectInputStream in = new ObjectInputStream(new FileInputStream(extension));
				ObjectPlus.odczytajEkstensje(in);
				in.close();	
			 } catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 
		 
		 //kod
		 //Ksiazka k = new Ksiazka("Opowieœci z narni", "C.S. Lewis", 564);
		 
		 for (Object o : ObjectPlus.obiektyEkstensji(Ksiazka.class)){
			 System.out.println(o);
		 }
		 
		 
		 
		 
		 try {
	  			// Zapisz ekstensje do strumienia
	  			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(extension));
	  			ObjectPlus.zapiszEkstensje(out);
	  			out.close();
	  		} catch (FileNotFoundException e) {
	  			e.printStackTrace();
	  		} catch (IOException e) {
	  			e.printStackTrace();
	  		}

	}

}
