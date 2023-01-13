package gestione.prodotti;


import java.io.Serializable;
import java.util.Arrays;
import java.util.Scanner;



public class Magazzino implements Serializable
{
	private final int DIMENSIONE = 10;
	private Prodotto prodotti[];

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
			System.out.println("Vuoto");
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

	public void aggiungiProdotto(Prodotto p1,int posizione)
	{	
		try {	
			if(prodotti[posizione] != null){
				prodotti[posizione] = new Prodotto(p1);
				System.out.println("Prodotto Aggiunto\n");
				
			}
			else
				System.out.println("Spazio Occupato\n");
		}
		catch(ArrayIndexOutOfBoundsException exception) {
			System.out.println("Posizione non valida");
		}
			
	}
	
	public void aggiungiProdotto(String marca, String modello, String seriale, int quantità, double prezzo, String descrizioneProdotto, int etàMinima, int mesiGaranzia, int posizione)
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
					System.out.println("Prodotto aggiornato \n");
				}else
					trova = false;
				
			}
			catch(ArrayIndexOutOfBoundsException exception) {}
			catch(NullPointerException exception){}
		}
		if (trova == false) 
		{
			if(prodotti[posizione] != null)
				System.out.println("Spazio Occupato\n");
				
			else if(posizione < 0 && posizione > DIMENSIONE) 
				System.out.println("Posizione non valida");
					
			else 
			{
				prodotti[posizione] = new Prodotto(p1);
				System.out.println("Prodotto Aggiunto");
			}	
		}
	}
	
	public void rimuoviProdotto(String cerca,int quantità) 
	{
		boolean trova = false,quant = true;
			for(int i = 0; i < DIMENSIONE; i++) {
				try
				{
					if(prodotti[i].getSeriale().equals(cerca))
					{
						if(prodotti[i].getQuantità() > 1 && prodotti[i].getQuantità() > quantità)
						{
							prodotti[i].setQuantità(prodotti[i].getQuantità() - quantità );
							trova = true;
						}
						else if(prodotti[i].getQuantità() < quantità)
						{
							System.out.println("Impossibile eliminare più di " + prodotti[i].getQuantità() + " prodotti\n");
							trova = false;
							quant = false;
						}else 
						{
							prodotti[i] = null;
							trova = true;
							quant = true;
						}
					}else
						trova = false;
				}
				catch(ArrayIndexOutOfBoundsException exception) {}
				catch(NullPointerException exception) {}
			}
			if (trova == true && quant == true)
				System.out.println("Prodotto Rimosso\n");
			else if(trova == false && quant == true)
				System.out.println("Prodotto Non Trovato\n");
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
					    System.out.println("#0 esci\n");
				        System.out.print("Scegli cosa modificare: ");
				        scelta = in.nextInt();
				        String clear = in.nextLine();
				        switch (scelta) 
				        {
					        case 1: 
					        	System.out.println("Immetti nuova marca ");
					        	String marca = in.nextLine();
					        	prodotti[i].setMarca(marca);
					        	System.out.println("Modifica effettuata\n");
					        	break;
					        case 2: 
					        	System.out.println("Immetti nuovo modello ");
					        	String modello = in.nextLine();
					        	prodotti[i].setModello(modello);
					        	System.out.println("Modifica effettuata\n\n");
					        	break;
					        case 3: 
					        	System.out.println("Immetti nuovo seriale ");
					        	String seriale = in.nextLine();
					        	prodotti[i].setSeriale(seriale);
					        	System.out.println("Modifica effettuata\n");
					        	break;
					        case 4: 
					        	System.out.println("Immetti nuova quantità ");
					        	int quantità = in.nextInt();
					        	prodotti[i].setQuantità(quantità);
					        	System.out.println("Modifica effettuata\n");
					        	break;
					        case 5: 
					        	System.out.println("Immetti nuovo prezzo ");
					        	double prezzo = in.nextDouble();
					        	prodotti[i].setPrezzo(prezzo);
					        	break;
					        
					        case 6: 
					        	System.out.println("Immetti nuova descrizione ");
					        	String descrizioneProdotto = in.nextLine();
					        	prodotti[i].setDescrizioneProdotto(descrizioneProdotto);
					        	System.out.println("Modifica effettuata\n");
					        	break;
					        case 7: 
					        	System.out.println("Immetti nuova età minima ");
					        	int etàMinima = in.nextInt();
					        	prodotti[i].setEtàMinima(etàMinima);
					        	System.out.println("Modifica effettuata\n");
					        	break;
					        case 8: 
					        	System.out.println("Immetti nuova garanzia ");
					        	int mesiGaranzia = in.nextInt();
					        	prodotti[i].setMesiGaranzia(mesiGaranzia);
					        	System.out.println("Modifica effettuata\n");
					        	break;
					        case 0:
				                quit = true;
				                break;
	
				            default:
				                System.out.println("scegli un numero valido \n");
				        }
					        	
					 }
				
				}else
					System.out.println("Prodotto Non Trovato\n\n");
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
					System.out.println("Mesi di garanzia = " + getProdotto(j).getMesiGaranzia() + "\n");

	             }else
	            	 System.out.println("Prodotto non trovato\n");
	}

	@Override
	public String toString() 
	{
		return "Magazzino{" +
				"prodotti=" + Arrays.toString(prodotti) +
				'}';
	}
}