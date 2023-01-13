package gestione.salvataggio;
import gestione.prodotti.*;

import java.io.*;

public class Serializzazione implements Serializable
{
    public Serializzazione() {
    }

    public void salvaProdotti (Magazzino magazzino) throws IOException{
        ObjectOutputStream stream = new ObjectOutputStream(new FileOutputStream("prodotti.bin"));
        for (int i=0; i< magazzino.getDIMENSIONE(); i++){
            stream.writeObject(magazzino.getProdotto(i));
        }
        stream.close();
    }

    public Magazzino caricaProdotti () throws IOException{
        ObjectInputStream stream = new ObjectInputStream(new FileInputStream("volumi.bin"));
        Magazzino carica = new Magazzino();
        //try{
            for (int i=0; i< carica.getDIMENSIONE(); i++){
               // carica.aggiungiProdotto((Prodotto)stream.readObject(),i);

            }
        //}
        //catch(ClassNotFoundException exception){

        //}
        stream.close();
        return carica;
    }

}
