package gestione.prodotti;

import gestione.salvataggio.Serializzazione;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main
{
    public static void main (String[] args) throws java.io.IOException
    {
	    Magazzino magazzino = new Magazzino();
	    Serializzazione serializzazione = new Serializzazione();
	    String marca,modello,seriale,descrizione_prodotto;
		int quantità,età_minima,mesi_garanzia,quantità1;
		double prezzo;
	    magazzino = serializzazione.caricaProdotti();  //carico (spero) a inizio programma
	
	    //menu
	    Scanner in = new Scanner(System.in);
	    boolean quit = false;
	    int scelta;
	    // print menu
	
		    System.out.println("#1 aggiungi prodotti");
		    System.out.println("#2 rimuovi prodotti");
		    System.out.println("#3 modifica prodotti");
		    System.out.println("#4 visualizza prodotti");
		    System.out.println("#0 esci\n");
		try {
		do {
	        System.out.print("Scegli un opzione: ");
	       
		        scelta = in.nextInt();
		        String clear = in.nextLine();
		        
		        switch (scelta) 
		        {
		            case 1:
		                System.out.println("Hai scelto l'opzione #1");
		                System.out.print("Immetti marca ");
		                marca = in.nextLine();
		                System.out.println("");
		                
		                System.out.print("Immetti modello ");
		                modello = in.nextLine();
		                System.out.println("");
		                
		                System.out.print("Immetti seriale ");
		                seriale = in.nextLine();
		                System.out.println("");
		                
		                System.out.print("Immetti quantità ");
		                quantità = in.nextInt();
		                System.out.println("");
		                
		                System.out.print("Immetti prezzo ");
		                prezzo = in.nextFloat();
		                System.out.println("");
		                
		                clear = in.nextLine();
		                System.out.print("Immetti descrizione prodotto ");
		                descrizione_prodotto = in.nextLine();
		                System.out.println("");
		                
		                System.out.print("Immetti età minima ");
		                età_minima = in.nextInt();
		                System.out.println("");
		                
		                System.out.print("Immetti mesi garanzia ");
		                mesi_garanzia = in.nextInt();
		                System.out.println("");
		                
		                System.out.print("Immetti posizione prodotto ");
		                int posizione = in.nextInt();
		                
		               // magazzino.aggiungiProdotto(marca,modello,seriale,quantità,prezzo,descrizione_prodotto,età_minima,mesi_garanzia, posizione);
		                //magazzino.aggiungiProdotto("apple","bmw","ss",1,5,"ok",5,5,7);
		                magazzino.aggiungiProdotto("aplple","bmmw","ss",11,45,"ok",57,51,3);
		                break;
		
		            case 2:
		                System.out.println("Hai scelto l'opzione #2");
		                System.out.print("Immetti seriale ");
		                seriale = in.nextLine();
		                System.out.print("Immetti quantità prodotti da rimuovere ");
		                quantità1 = in.nextInt();
		                magazzino.rimuoviProdotto(seriale,quantità1);
		                //
		                break;
		
		            case 3:
		                System.out.println("Hai scelto l'opzione  #3");
		                System.out.print("Immetti seriale ");
		                seriale = in.nextLine();
		                magazzino.modificaProdotto(seriale);
		                break;
		
		            case 4:
		                System.out.println("Hai scelto l'opzione  #4");
		                System.out.print("Immetti seriale ");
		                String ricerca = in.nextLine();
		                magazzino.visualizzaProdotto(ricerca);
		                	
		                break;
		
		            case 0:
		 
		                quit = true;
		                serializzazione.salvaProdotti(magazzino);
		                break;
		
		            default:
		                System.out.println("Scegli un numero valido\n");
		       }
	        
		
	    } while (!quit);
    }
	    catch(NoSuchElementException c) {
        	System.out.println("Errore ");
        }
	
	    System.out.println("arrivederci :)");
	
    }
}