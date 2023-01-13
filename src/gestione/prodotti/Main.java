package gestione.prodotti;

import gestione.colori.AnsiFormat;
import gestione.salvataggio.Serializzazione;

import java.util.Scanner;

import static gestione.colori.Ansi.colorize;
import static gestione.colori.Attribute.*;

public class Main
{
    public static void main (String[] args) throws java.io.IOException
    {
	    Magazzino magazzino = new Magazzino();
	    Serializzazione serializzazione = new Serializzazione();
	    String marca,modello,seriale,descrizione_prodotto;
		int quantità,età_minima,mesi_garanzia;
		double prezzo;
	    //magazzino = serializzazione.caricaMagazzino();  //carico (spero) a inizio programma
	
	    //menu
	    Scanner in = new Scanner(System.in);
	
	    //ansi format che definiscono i vari stili
		AnsiFormat menu = new AnsiFormat(BRIGHT_BLUE_TEXT(), BOLD());
		AnsiFormat opzione = new AnsiFormat(BRIGHT_CYAN_TEXT(),BRIGHT_BLACK_BACK(), BOLD());
		AnsiFormat errore = new AnsiFormat(RED_TEXT(),BRIGHT_BLACK_BACK(), BOLD());
		AnsiFormat immettiDati = new AnsiFormat(BRIGHT_CYAN_TEXT());

	
	    boolean quit = false;
	
	    int scelta;
	
	    do
	    {
			System.out.println("\n");
			System.out.println(colorize("#1 aggiungi prodotti", menu));
			System.out.println(colorize("#2 rimuovi prodotti", menu));
			System.out.println(colorize("#3 modifica prodotti", menu));
			System.out.println(colorize("#4 visualizza prodotti", menu));
			System.out.println(colorize("#0 esci", menu));
			System.out.println(colorize("Scegli un opzione: ", menu));
	        scelta = in.nextInt();
	        String clear = in.nextLine();
	        switch (scelta) 
	        {
	            case 1:
					System.out.println(colorize("Hai scelto l'opzione #1", opzione));
					System.out.println(colorize("Immetti marca", immettiDati));
	                marca = in.nextLine();
	                System.out.println("");

					System.out.println(colorize("Immetti modello", immettiDati));
	                modello = in.nextLine();
	                System.out.println("");

					System.out.println(colorize("Immetti Seriale", immettiDati));
	                seriale = in.nextLine();
	                System.out.println("");

					System.out.println(colorize("Immetti quantità", immettiDati));
	                quantità = in.nextInt();
	                System.out.println("");

					System.out.println(colorize("Immetti prezzo", immettiDati));
	                prezzo = in.nextFloat();
	                System.out.println("");
	                
	                clear = in.nextLine();
					System.out.println(colorize("Immetti descrizione prodotto", immettiDati));
	                descrizione_prodotto = in.nextLine();
	                System.out.println("");

					System.out.println(colorize("Immetti età minima", immettiDati));
	                età_minima = in.nextInt();
	                System.out.println("");

					System.out.println(colorize("Immetti mesi garanzia", immettiDati));
	                mesi_garanzia = in.nextInt();
	                System.out.println("");

					System.out.println(colorize("Immetti posizione prodotto", immettiDati));
	                int posizione = in.nextInt();
	                magazzino.aggiungiProdotto(marca,modello,seriale,quantità,prezzo,descrizione_prodotto,età_minima,mesi_garanzia, posizione);
	                /*magazzino.aggiungiProdotto("apple","bmw","ss",10,5,"ok",5,5,7);
	                magazzino.aggiungiProdotto("aplple","bmmw","hm",11,45,"ok",57,51,3);*/
	                break;
	
	            case 2:
					System.out.println(colorize("Hai scelto l'opzione #2", opzione));
					System.out.println(colorize("Immetti Seriale", immettiDati));
	                seriale = in.nextLine();
					System.out.println(colorize("Immetti Quantità", immettiDati));
					quantità = Integer.parseInt(in.nextLine());
	                magazzino.rimuoviProdotto(seriale,quantità);
	                //
	                break;
	
	            case 3:
					System.out.println(colorize("Hai scelto l'opzione #3", opzione));
					System.out.println(colorize("Immetti Seriale", immettiDati));
	                seriale = in.nextLine();
	                magazzino.modificaProdotto(seriale);
	                break;
	
	            case 4:
					System.out.println(colorize("Hai scelto l'opzione #4", opzione));
					System.out.println(colorize("Immetti Seriale", immettiDati));
	                String ricerca = in.nextLine();
	                magazzino.visualizzaProdotto(ricerca);
	                	
	                break;
	
	            case 0:
	                quit = true;
	                break;
	
	            default:
					System.out.println(colorize("scegli un numero valido", errore));
	       }
	
	    } while (!quit);

		System.out.println(colorize("arrivederci :)", menu));
    }
}