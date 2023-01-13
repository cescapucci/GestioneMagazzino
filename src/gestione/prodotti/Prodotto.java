package gestione.prodotti;


import java.io.Serializable;

public class Prodotto implements Serializable
{
	private String marca;
	private String modello;
	private String seriale;
	private int quantità;
	private double prezzo;
	private boolean disponibilità;
	private String descrizioneProdotto;
	private int etàMinima;
	private int mesiGaranzia;
	
	public Prodotto(String marca, String modello, String seriale, int quantità, double prezzo, String descrizioneProdotto, int etàMinima, int mesiGaranzia) 
	{
		setMarca(marca);
		setModello(modello);
		setSeriale(seriale);
		setQuantità(quantità);
		setPrezzo(prezzo);
		//setDisponibilità(disponibilità);
		setDescrizioneProdotto(descrizioneProdotto);
		setEtàMinima(etàMinima);
		setMesiGaranzia(mesiGaranzia);
	}
	
	public Prodotto(Prodotto p1)
	{
		setMarca(p1.getMarca());
		setModello(p1.getModello());
		setSeriale(p1.getSeriale());
		setQuantità(p1.getQuantità());
		setPrezzo(p1.getPrezzo());
		setDescrizioneProdotto(p1.getDescrizioneProdotto());
		setEtàMinima(p1.getEtàMinima());
		setMesiGaranzia(p1.getMesiGaranzia());
	}
	
	public String getMarca() 
	{
		return marca;
	}
	
	public void setMarca(String marca) 
	{
		this.marca = marca;
	}
	
	public String getModello()
	{
		return modello;
	}
	
	public void setModello(String modello) 
	{
		this.modello = modello;
	}
	
	public String getSeriale() 
	{
		return seriale;
	}
	
	public void setSeriale(String seriale) 
	{
		this.seriale = seriale;
	}
	
	public int getQuantità() 
	{
		return quantità;
	}
	
	public void setQuantità(int quantità) 
	{
		this.quantità = quantità;
	}
	
	public double getPrezzo() 
	{
		return prezzo;
	}
	
	public void setPrezzo(double prezzo)
	{
		this.prezzo = prezzo;
	}
	
	public boolean isDisponibilità()
	{	if(quantità > 0)
			disponibilità = true;
		return disponibilità;
	}
	
	/*public void setDisponibilità(boolean disponibilità) {
		this.disponibilità = disponibilità;
	}*/
	
	public String getDescrizioneProdotto() 
	{
		return descrizioneProdotto;
	}
	
	public void setDescrizioneProdotto(String descrizioneProdotto) 
	{
		this.descrizioneProdotto = descrizioneProdotto;
	}
	
	public int getEtàMinima() 
	{
		return etàMinima;
	}
	
	public void setEtàMinima(int etàMinima) 
	{
		this.etàMinima = etàMinima;
	}
	
	public int getMesiGaranzia()
	{
		return mesiGaranzia;
	}
	
	public void setMesiGaranzia(int mesiGaranzia)
	{
		this.mesiGaranzia = mesiGaranzia;
	}

}
