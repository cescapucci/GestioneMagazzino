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

	/**
	 * costruttore di default
	 * @param marca
	 * @param modello
	 * @param seriale
	 * @param quantità
	 * @param prezzo
	 * @param descrizioneProdotto
	 * @param etàMinima
	 * @param mesiGaranzia
	 */

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

	/**
	 * costruttore di copia
	 * @param p1
	 */
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

	/**
	 * ritorna la marca
	 * @return marca
	 */
	public String getMarca()
	{
		return marca;
	}

	/**
	 * setta la marca
	 * @param marca
	 */
	public void setMarca(String marca)
	{
		this.marca = marca;
	}

	/**
	 * ritorna il modello
	 * @return modello
	 */
	public String getModello()
	{
		return modello;
	}

	/**
	 * setta il modello
	 * @param modello
	 */
	public void setModello(String modello)
	{
		this.modello = modello;
	}

	/**
	 * ritorna il seriale
	 * @return seriale
	 */
	public String getSeriale()
	{
		return seriale;
	}

	/**
	 * setta il seriale
	 * @param seriale
	 */
	public void setSeriale(String seriale)
	{
		this.seriale = seriale;
	}

	/**
	 * ritorna la quantità
	 * @return quantità
	 */
	public int getQuantità()
	{
		return quantità;
	}

	/**
	 * setta la quantità
	 * @param quantità
	 */
	public void setQuantità(int quantità)
	{
		this.quantità = quantità;
	}

	/**
	 * ritorna il prezzo
	 * @return prezzo
	 */
	public double getPrezzo()
	{
		return prezzo;
	}

	/**
	 * setta il prezzo
	 * @param prezzo
	 */
	public void setPrezzo(double prezzo)
	{
		this.prezzo = prezzo;
	}

	/**
	 * ritorna la disponibilità
	 * @return disponibilità
	 */
	public boolean isDisponibilità()
	{	if(quantità > 0)
		disponibilità = true;
		return disponibilità;
	}
	
	/*public void setDisponibilità(boolean disponibilità) {
		this.disponibilità = disponibilità;
	}*/

	/**
	 * ritorna la descrizione del prdodotto
	 * @return prodotto
	 */
	public String getDescrizioneProdotto()
	{
		return descrizioneProdotto;
	}

	/**
	 * setta la descrizione del prodotto
	 * @param descrizioneProdotto
	 */
	public void setDescrizioneProdotto(String descrizioneProdotto)
	{
		this.descrizioneProdotto = descrizioneProdotto;
	}

	/**
	 * ritorna l'età minima
	 * @return etàmi nima
	 */
	public int getEtàMinima()
	{
		return etàMinima;
	}

	/**
	 * setta l'età minima
	 * @param etàMinima
	 */
	public void setEtàMinima(int etàMinima)
	{
		this.etàMinima = etàMinima;
	}

	/**
	 * ritorna i mesi di garnazia
	 * @return mesi di garanzia
	 */
	public int getMesiGaranzia()
	{
		return mesiGaranzia;
	}

	/**
	 * setta i mesi di garanzia
	 * @param mesiGaranzia
	 */
	public void setMesiGaranzia(int mesiGaranzia)
	{
		this.mesiGaranzia = mesiGaranzia;
	}

}
