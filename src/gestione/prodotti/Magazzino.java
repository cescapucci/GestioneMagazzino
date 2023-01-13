package gestione.prodotti;
import com.diogonunes.jcolor.AnsiFormat;
import static com.diogonunes.jcolor.Ansi.colorize;
import static com.diogonunes.jcolor.Attribute.*;
import gestione.salvataggio.Serializzazione;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Scanner;


public class Magazzino implements Serializable
{
	private final int DIMENSIONE = 10;
	private Prodotto prodotti[];

	//colori
	AnsiFormat errore = new AnsiFormat(RED_TEXT(),BRIGHT_BLACK_BACK(), BOLD());
	AnsiFormat immettiDati = new AnsiFormat(BRIGHT_CYAN_TEXT());
	AnsiFormat corretto = new AnsiFormat(BRIGHT_GREEN_TEXT(),WHITE_BACK());

	/**
	 * costruttore di default
	 */
	public Magazzino ()
	{
		prodotti = new Prodotto [DIMENSIONE];
	}

	/**
	 * costruttore di copia
	 * @param m1
	 */
	public Magazzino(Magazzino m1)
	{
		prodotti = new Prodotto[DIMENSIONE];
		try 
		{
			for(int i = 0; i < DIMENSIONE; i++ ) 
			{
				if(m1.getProdotto(i) != null)
					prodotti[i] = m1.getProdotto(i);
			}
		}
		catch(NullPointerException eccezione) 
		{
			System.out.println(colorize("Vuoto\n", errore));
		}
	}


	/**
	 * Restituisce il prodotto di una posizione specifica
	 * @param posizione
	 * @return un prodotto
	 */
	public Prodotto getProdotto(int posizione)
	{
		if(posizione > 0 && posizione < DIMENSIONE)
			return new Prodotto (prodotti[posizione]);
	
		else
			return null;
	}

	/**
	 * Restituiste la dimensione
	 * @return la dimensione
	 */
	public int getDIMENSIONE()
	{
		return DIMENSIONE;
	}

	/**
	 * aggiunge un prodotto nell'array dei prodotti. Stampa se lo ha aggiunto o no
	 * @param marca
	 * @param modello
	 * @param seriale
	 * @param quantità
	 * @param prezzo
	 * @param descrizioneProdotto
	 * @param etàMinima
	 * @param mesiGaranzia
	 * @param posizione
	 */
	public void aggiungiProdotto(String marca, String modello, String seriale, int quantità, double prezzo,
					 String descrizioneProdotto, int etàMinima, int mesiGaranzia, int posizione)
	{
		Prodotto p1 = new Prodotto(marca,modello,seriale,quantità,prezzo,descrizioneProdotto,etàMinima,mesiGaranzia);
		boolean trova = false;
		for(int i = 0; i < DIMENSIONE; i++)
		{
			try
			{
				if(prodotti[i].getSeriale().equals(seriale))
				{
					trova = true;
					prodotti[i].setQuantità(prodotti[i].getQuantità() + quantità );
					System.out.println(System.out.println(colorize("Prodotto aggiornato di quantità\n", corretto));
				}else
					trova = false;

			}
			catch(ArrayIndexOutOfBoundsException exception) {}
			catch(NullPointerException exception){}
		}
		if (trova == false)
		{
			if(prodotti[posizione] != null)
				System.out.println(colorize("Spazio occupato\n", errore));

			else if(posizione < 0 && posizione > DIMENSIONE)
				System.out.println(colorize("posizione non valida\n", errore));

			else
			{
				prodotti[posizione] = new Prodotto(p1);
				System.out.println(colorize("Prodotto aggiunto\n", corretto));
			}
		}
	}

	/**
	 * aggiunge il prodotto passato per riferimento nella posizione richiesta
	 * @param p1
	 * @param posizione
	 */
	public void aggiungiProdotto(Prodotto p1,int posizione)
	{
		try {
			if(prodotti[posizione] != null){
				prodotti[posizione] = new Prodotto(p1);
				System.out.println(colorize("Prodotto aggiunto\n", corretto));

			}
			else
				System.out.println(colorize("Spazio occupato\n", errore));
		}
		catch(ArrayIndexOutOfBoundsException exception) {
			System.out.println(colorize("posizione non valida\n", errore));
		}

	}

	/**
	 * rimuove il prodotto che si vuole rimuovere e stampa se lo ha rimosso o no
	 * @param cerca
	 */
	public void rimuoviProdotto(String cerca)
	{
		boolean trova = false,quantitàMetodoRimuovi = true;
		for(int i = 0; i < DIMENSIONE; i++) {
			try
			{
				if(prodotti[i].getSeriale().equals(cerca))
				{
					if(prodotti[i].getQuantità() > 1 && prodotti[i].getQuantità() > quantitàMetodoRimuovi)
					{
						prodotti[i].setQuantità(prodotti[i].getQuantità() - quantitàMetodoRimuovi );
						trova = true;
					}
					else if(prodotti[i].getQuantità() < quantitàMetodoRimuovi)
					{
						System.out.println(Colorize("Impossibile eliminare più di " + prodotti[i].getQuantità() +
								" prodotti\n"),errore);
						trova = false;
						quantitàMetodoRimuovi = false;
					}else
					{
						prodotti[i] = null;
						trova = true;
						quantitàMetodoRimuovi = true;
					}
				}else
					trova = false;
			}
			catch(ArrayIndexOutOfBoundsException exception) {}
			catch(NullPointerException exception) {}
		}
		if (trova == true && quantitàMetodoRimuovi == true)
			System.out.println(Colorize("Prodotto Rimosso\n"),corretto);
		else if(trova == false && quantitàMetodoRimuovi == true)
			System.out.println(colorize("Prodotto non trovato\n", errore));
	}
	
	/*public void modificaProdotto(Prodotto p1,Prodotto p2) 
	{
		try
		{
			for(int i = 0; i < DIMENSIONE; i++)
				if(p1.getSeriale().equals(prodotti[i].getSeriale()))
				{
					prodotti[i] = new Prodotto(p2);
					System.out.println("Prodotto Modificato");
				}
				else
					System.out.println("Prodotto Non Trovato");
		}
		catch(ArrayIndexOutOfBoundsException exception) {}
		catch(NullPointerException exception) {}
	}*/

	/**
	 * modifica il prodotto che si vuole modificare, permette di cambiare 1 o più attributi. Stampa
	 * se ha modificato o no
	 * @param cerca
	 */
	public void modificaProdotto(String cerca)
	{
		boolean trova = false;
		for(int i = 0; i < DIMENSIONE; i++) {
			try {
				if(cerca.equals(prodotti[i].getSeriale())) {
					Scanner in = new Scanner(System.in);

					// print menu

					boolean quit = false;

					int scelta;

					while(!quit) {
						System.out.println("#1 Modifica marca");
						System.out.println("#2 Modifica modello");
						System.out.println("#3 Modifica seriale");
						System.out.println("#4 Modifica quantità");
						System.out.println("#5 Modifica prezzo");
						System.out.println("#6 Modifica descrizione");
						System.out.println("#7 Modifica età minima");
						System.out.println("#8 Modifica mesi garanzia");
						System.out.println("#0 esci\n");
						System.out.print("Scegli cosa modificare: ");
						scelta = in.nextInt();
						String clear = in.nextLine();

						switch (scelta) {
							case 1:
								System.out.println("Immetti nuova marca ");
								String marca = in.nextLine();
								prodotti[i].setMarca(marca);
								System.out.println(Colorize("Modifica effettuata\n"),corretto);
								break;
							case 2:
								System.out.println("Immetti nuovo modello ");
								String modello = in.nextLine();
								prodotti[i].setModello(modello);
								System.out.println(Colorize("Modifica effettuata\n"),corretto);
								break;
							case 3:
								System.out.println("Immetti nuovo seriale ");
								String seriale = in.nextLine();
								prodotti[i].setSeriale(seriale);
								System.out.println(Colorize("Modifica effettuata\n"),corretto);
								break;
							case 4:
								System.out.println("Immetti nuova quantità ");
								int quantità = in.nextInt();
								prodotti[i].setQuantità(quantità);
								System.out.println(Colorize("Modifica effettuata\n"),corretto);
								break;
							case 5:
								System.out.println("Immetti nuovo prezzo ");
								double prezzo = in.nextDouble();
								prodotti[i].setPrezzo(prezzo);
								System.out.println(Colorize("Modifica effettuata\n"),corretto);
								break;

							case 6:
								System.out.println("Immetti nuova descrizione ");
								String descrizioneProdotto = in.nextLine();
								prodotti[i].setDescrizioneProdotto(descrizioneProdotto);
								System.out.println(Colorize("Modifica effettuata\n"),corretto);
								break;
							case 7:
								System.out.println("Immetti nuova età minima ");
								int etàMinima = in.nextInt();
								prodotti[i].setEtàMinima(etàMinima);
								System.out.println(Colorize("Modifica effettuata\n"),corretto);
								break;
							case 8:
								System.out.println("Immetti nuova garanzia ");
								int mesiGaranzia = in.nextInt();
								prodotti[i].setMesiGaranzia(mesiGaranzia);
								System.out.println(Colorize("Modifica effettuata\n"),corretto);
								break;
							case 0:
								quit = true;
								break;

							default:
								System.out.println(Colorize("Scegli un numero valido\n"),errore);
						}

					}

				}else
					System.out.println(Colorize("Prodotto Non Trovato\n"),errore);
			}

			catch(ArrayIndexOutOfBoundsException exception) {}
			catch(NullPointerException exception) {}
		}
	}

	/**
	 * visualizza a video il prodotto che si vuole ricercare o segnala che non
	 * è stato trovato
	 * @param ricerca
	 */
	public void visualizzaProdotto(String ricerca)
	{
		boolean trova = false;
		int j = 0;
		for(int i = 0; i < DIMENSIONE; i++) {
			try {
				if(prodotti[i].getSeriale().equals(ricerca)) {
					trova = true;
					j = i;
				}else
					trova = false;
			}
			catch(NullPointerException exception) {}
			catch(ArrayIndexOutOfBoundsException exception) {}
		}
		if(trova == true) {
			System.out.println("Posizione " + j + " : " + "\nMarca = " + getProdotto(j).getMarca() + " ");
			System.out.println("Modello = " + getProdotto(j).getModello() + " ");
			System.out.println("Seriale = " + getProdotto(j).getSeriale() + " ");
			System.out.println("Quantità = " + getProdotto(j).getQuantità() + " ");
			System.out.println("Prezzo = " + getProdotto(j).getPrezzo() + " Euro ");
			System.out.println("Disponibilità = " + getProdotto(j).isDisponibilità() + " ");
			System.out.println("Descrizione = " + getProdotto(j).getDescrizioneProdotto() + " ");
			System.out.println("Età minima utilizzo = " + getProdotto(j).getEtàMinima() + " ");
			System.out.println("Mesi di garanzia = " + getProdotto(j).getMesiGaranzia() + "\n");

		}else
			System.out.println(colorize("Prodotto non trovato\n"),errore);
	}

}