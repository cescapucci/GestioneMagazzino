package gestione.salvataggio;
import gestione.prodotti.*;

import java.io.*;

public class Serializzazione implements Serializable
{
    public Serializzazione() {
    }

    public void salvaProdotti (Magazzino magazzino) throws java.io.IOException{
    	try 
    	{
	        ObjectOutputStream stream = new ObjectOutputStream(new FileOutputStream("prodotti.bin"));
	        stream.writeObject(magazzino);
	        stream.close();
    	}
    	catch(Exception eccezione) {}
    }

    public Magazzino caricaProdotti () throws java.io.IOException{
    	Magazzino carica = new Magazzino();
    	try {
        ObjectInputStream stream = new ObjectInputStream(new FileInputStream("prodotti.bin"));
                carica = (Magazzino)stream.readObject();
                stream.close();
        }
        catch(Exception e){
        	System.out.println("Errore " + e.getMessage());
        	
        }
  
        return carica;
    }

}
