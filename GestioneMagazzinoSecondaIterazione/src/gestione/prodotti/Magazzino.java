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
	public Magazzino ()
	{
		prodotti = new Prodotto [DIMENSIONE];
		
	}
	
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
			System.out.println(colorize("Vuoto", errore));
		}
	}
	
	public Prodotto getProdotto(int posizione) 
	{
		if(posizione > 0 && posizione < DIMENSIONE)
			return new Prodotto (prodotti[posizione]);
	
		else
			return null;
	}

	public int getDIMENSIONE() 
	{
		return DIMENSIONE;
	}

	public void aggiungiProdotto(String marca, String modello, String seriale, int quantità, double prezzo, String descrizioneProdotto, int etàMinima, int mesiGaranzia, int posizione) {
		Prodotto p1 = new Prodotto (marca,modello,seriale,quantità,prezzo,descrizioneProdotto,etàMinima,mesiGaranzia);
		try 
		{	
			if(prodotti[posizione] == null) 
			{
				prodotti[posizione] = new Prodotto(p1);
				System.out.println(colorize("Prodotto aggiunto", corretto));
				
			}else
				System.out.println(colorize("Spazio occupato", errore));
		}
		catch(ArrayIndexOutOfBoundsException exception) 
		{
			System.out.println(colorize("posizione non valida", errore));
		}	
	}

	public void rimuoviProdotto(String cerca) 
	{
		boolean trova = true;
			for(int i = 0; i < DIMENSIONE; i++) {
				try
				{
					if(prodotti[i].getSeriale().equals(cerca))
					{
						prodotti[i] = null;
						trova = true;
					}
					else
						trova = false;
				}
				catch(ArrayIndexOutOfBoundsException exception) {}
				catch(NullPointerException exception) {}
			}
			if (trova == true)
				System.out.println(colorize("Prodotto rimosso", corretto));
			else
				System.out.println(colorize("Prodotto non trovato", errore));
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
	
	public void modificaProdotto(String cerca) 
	{
		boolean trova = false;
		for(int i = 0; i < DIMENSIONE; i++) 
		{
			try
			{
				if(cerca.equals(prodotti[i].getSeriale()))
				{
					Scanner in = new Scanner(System.in);
	
				    // print menu
			
				    boolean quit = false;
	
				    int scelta;
	
				    while(!quit) 
				    {
			    	  	System.out.println("#1 Modifica marca");
					    System.out.println("#2 Modifica modello");
					    System.out.println("#3 Modifica seriale");
					    System.out.println("#4 Modifica quantità");
					    System.out.println("#5 Modifica prezzo");
					    System.out.println("#6 Modifica descrizione");
					    System.out.println("#7 Modifica età minima");
					    System.out.println("#8 Modifica mesi garanzia");
					    System.out.println("#0 esci");
				        System.out.print("Scegli cosa modificare: ");
				        scelta = in.nextInt();
				        String clear = in.nextLine();
				        switch (scelta) 
				        {
					        case 1:
								System.out.println(colorize("Immetti nuova marca ", immettiDati));
					        	String marca = in.nextLine();
					        	prodotti[i].setMarca(marca);
					        	break;
					        case 2:
								System.out.println(colorize("Immetti nuovo modello ", immettiDati));
					        	String modello = in.nextLine();
					        	prodotti[i].setModello(modello);
					        	break;
					        case 3:
								System.out.println(colorize("Immetti nuovo seriale ", immettiDati));
					        	String seriale = in.nextLine();
					        	prodotti[i].setSeriale(seriale);
					        	break;
					        case 4:
								System.out.println(colorize("Immetti nuova quantità ", immettiDati));
					        	int quantità = in.nextInt();
					        	prodotti[i].setQuantità(quantità);
					        	break;
					        case 5:
								System.out.println(colorize("Immetti nuovo prezzo ", immettiDati));
					        	double prezzo = in.nextDouble();
					        	prodotti[i].setPrezzo(prezzo);
					        	break;
					        
					        case 6:
								System.out.println(colorize("Immetti nuova descrizione ", immettiDati));
					        	String descrizioneProdotto = in.nextLine();
					        	prodotti[i].setDescrizioneProdotto(descrizioneProdotto);
					        	break;
					        case 7:
								System.out.println(colorize("Immetti nuova età minima ", immettiDati));
					        	int etàMinima = in.nextInt();
					        	prodotti[i].setEtàMinima(etàMinima);
					        	break;
					        case 8:
								System.out.println(colorize("Immetti nuova garanzia ", immettiDati));
					        	int mesiGaranzia = in.nextInt();
					        	prodotti[i].setMesiGaranzia(mesiGaranzia);
					        	break;
					        case 0:
				                quit = true;
				                break;
	
				            default:
								System.out.println(colorize("Scegli un numero valido", errore));
				        }
					        	
					 }
				
				}else
					System.out.println(colorize("Prodotto non trovato", errore));
			}

			catch(ArrayIndexOutOfBoundsException exception) {}
			catch(NullPointerException exception) {}
		}
	}
	
	public void visualizzaProdotto(String ricerca) 
	{
		boolean trova = false;
		int j = 0;
		for(int i = 0; i < DIMENSIONE; i++) 
		{
			try 
			{
				if(prodotti[i].getSeriale().equals(ricerca))
	            {
	            	trova = true;
	            	j = i;
	            }else 
	            	trova = false;
			}
			catch(NullPointerException exception) {}
			catch(ArrayIndexOutOfBoundsException exception) {}
		}
	             if(trova == true) 
	             {
	            	System.out.println("Posizione " + j + " : " + "\nMarca = " + getProdotto(j).getMarca() + " ");
					System.out.println("Modello = " + getProdotto(j).getModello() + " ");
					System.out.println("Seriale = " + getProdotto(j).getSeriale() + " ");
					System.out.println("Quantità = " + getProdotto(j).getQuantità() + " ");
					System.out.println("Prezzo = " + getProdotto(j).getPrezzo() + " Euro ");
					System.out.println("Disponibilità = " + getProdotto(j).isDisponibilità() + " ");
					System.out.println("Descrizione = " + getProdotto(j).getDescrizioneProdotto() + " ");
					System.out.println("Età minima utilizzo = " + getProdotto(j).getEtàMinima() + " ");
					System.out.println("Mesi di garanzia = " + getProdotto(j).getMesiGaranzia() + " ");

	             }else
					 System.out.println(colorize("Prodotto non trovato", errore));
	}

	@Override
	public String toString() 
	{
		return "Magazzino{" +
				"prodotti=" + Arrays.toString(prodotti) +
				'}';
	}
}