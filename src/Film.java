/**
 * Die Klasse stellt das Film Objekt mit ihren Methoden bereit. 
 */
public class Film 
{
	/*
	 * Hir stehen die Klassenvariablen	
	 */
	//Jahr der Veröffentlichung
	private  int jahr = 1871;
	// Länge des Films
	private int laenge = -1;
	// Alters begrenzung
	private  int fsk = -1;
	// Deutscher Titel des Films
	private  String titelDE;
	//Englischer Titel des Films
	private  String titelEN;
	//Sprache des Films
	private  String sprache;
	// Wichtige Darsteller
	private  String darsteller;
	// Kanal: Farbe oder s/w
	private	 String farbe; 
	//Variable für regie
	private String regie;
	//Genre für den Film
	private String genere;
	//Variable für den Produzenten
	private String produzent;
	//Variable für das Studio
	private String studio;
	//Land
	private String land;
	//Land für die Bewertung
	private int bewertung;
	
/*Ende der Klassen Variablen -----------------------------------------*/
	/*Hir beginnen die Methoden
	 * 
	 */
	/**
	 * Der Konstruktor für die Klasse {@link #Items(String, int, int, int, String, String)}
	 * @param nameDE
	 * @param nameEN  
	 * @param jahr
	 * @param fsk
	 * @param laenge
	 * @param sprache
	 * @param besatzung
	 * @throws FilmDatenException  
	 */
	public Film(String nameDE, String nameEN, int jahr, String regie,String produzent, String studio, String land, int fsk, int laenge, String sprache,String darsteller, String kanal, String genere, int bewertung) throws FilmDatenException   
	{
		titelDE = nameDE;
		titelEN = nameEN;
		this.jahr = jahr;
		this.laenge = laenge;
		this.sprache = sprache;
		this.fsk = fsk;
		this.darsteller = darsteller;
		this.farbe = kanal;
		this.regie = regie;
		this.genere = genere;
		this.produzent = produzent;
		this.land = land;
		this.studio = studio;
		this.bewertung = bewertung;
		
		try
		{
			this.setFsk(fsk);
			this.setTitelDE(nameDE);
			this.setTitelEN(nameEN);
			this.setLaenge(laenge);
			this.setJahr(jahr);
			this.setSprache(sprache);
			this.setDarsteller(darsteller);
			this.setFarbe(kanal);
			this.setRegie(regie);
			this.setGenere(genere);
			this.setProduzent(produzent);
			this.setStudio(studio);
			this.setLand(land);
			this.setBewertung(bewertung);
		}
		catch(FilmDatenException ex)
		{
			throw new FilmDatenException();
		}	
	}
	
	/**
	 * Set Methode für den Deutschen Titel des Films
	 * @param name
	 */
	public void setTitelDE(String nameDE) throws FilmDatenException
	{
		if(nameDE.length() < 2) 
		{
			System.err.println("Der Name des deutschen Titels ist zu klein!!");
			throw new FilmDatenException();
		}
		else if(nameDE.length() > 45)
		{
			System.out.println("Der Name des deutschen Titel ist zu groß!!");
			throw new FilmDatenException();
		}
		else this.titelDE = nameDE;
	}
	/**
	 * get Methode für den Titel
	 * @return titelDE 
	 */
	public String getTitelDE()
	{
		return titelDE;
	}
	/**
	 * Set Methode für den Deutschen Titel des Films
	 * @param name
	 */
	public void setTitelEN(String nameEN) throws FilmDatenException
	{
		if(nameEN.length() < 2) 
		{
			System.err.println("Der Name des englischen Titels ist zu klein!!");
			throw new FilmDatenException();
		}
		else if(nameEN.length() > 45)
		{
			System.out.println("Der Name des englischen Titel ist zu groß!!");
			throw new FilmDatenException();
		}
		else this.titelEN = nameEN;
	}
	/**
	 * get Methode für den Titel
	 * @return titelEN 
	 */
	public String getTitelEN()
	{
		return titelEN;
	}
	/**
	 * Set Methode für Jahr
	 * @param jahr
	 */
	public void setJahr(int jahr) throws FilmDatenException
	{
		if (jahr >= 1900) this.jahr = jahr;
		else 
		{
			System.out.println("Das Datum ist Flasch!!!,\n "
							  + "gebe ein Datum größer als 1899 ein.");
			throw new FilmDatenException();	
		}
	}
	/**
	 * Get Methode für jahr
	 * @return jahr gibt das Jahr zurück
	 */
	public int getJahr()
	{
		return jahr;
	}
	/**
	 * Stellt eine set Methode füer die Laenge des Filmes zur verfügung
	 * @param laenge
	 */
	public void setLaenge(int laenge) throws FilmDatenException
	{	
		if (laenge > 0) this.laenge = laenge;
		else 
		{
			System.err.println("Gege einen gültigen Wert größer als 0 ein!!!");
			throw new FilmDatenException();
		}
	}
	/**
	 * Get Methode für die Länge
	 * @return laenge
	 */
	public int getLaenge()
	{
		return laenge;
	}
	/**
	 * Stellt die Set Methode für Sprache zur verfügung
	 * @param sprache
	 */
	public void setSprache(String sprache) throws FilmDatenException
	{
		if(sprache.length() < 4) 
		{
			System.err.println("Der Text ist zukein gebe. Eine Sprache ein, die mehr als 3 Buchstaben besitzt!!!");
			throw new FilmDatenException();
		}
		else if(sprache.length() > 25)
		{
			System.out.println("Der Text ist zu groß. Gebe eine Sprache ein, die weniger als 25 Buchstaben hat.");
			throw new FilmDatenException();
		}
		else this.sprache = sprache;
	}
	/**
	 *Get Methode für Sprache 
	 * @return
	 */
	public String getSprache()
	{
		return sprache;
	}
	/**
	 * Stellt die Set Methode für Besatzung 
	 * @param besatzung
	 */
	public void setDarsteller(String darsteller) throws FilmDatenException
	{
		if(darsteller.length() < 4) 
		{
			System.err.println("Der Name des Darstellers ist zu klein. Gegbe eine anderen Namen an, der mehr als 3 Buchstaben besitzt!!!");
			throw new FilmDatenException();
		}
		else if(darsteller.length() > 25)
		{
			System.err.println("Der Name des Darstellers ist zu groß. Gegbe eine anderen Namen an, der weniger als 25 Buchstaben hat.");
			throw new FilmDatenException();
		}
		else this.darsteller = darsteller;
	}
	/**
	 * Get Methode für Besatzung
	 * @return besatzung 
	 */
	public String getDarsteller()
	{
		return darsteller;
	}
	public void setRegie(String regie) throws FilmDatenException
	{
		if(regie.length() > 3 ) this.regie = regie;
		else
		{
			System.err.println("Regiename ist zu klein. Es müssen mehr als 3 Buchstaben sein!!");
			throw new FilmDatenException();
		}	
	}
	public String getRegie()
	{
		return this.regie;
	}
	public void setProduzent(String produzent) throws FilmDatenException
	{
		if(produzent.length() > 3 ) this.produzent = produzent;
		else
		{
			System.err.println("Der Name des Produzenten ist zu klein. Es müssen mehr als 3 Buchstaben sein!!");
			throw new FilmDatenException();
		}	
	}
	public String getProduzent() 
	{
		return this.produzent;
	}
	public void setStudio(String studio) throws FilmDatenException
	{
		if(studio.length() > 3 ) this.studio = studio;
		else
		{
			System.err.println("Der Name des Studios ist zu klein. Es müssen mehr als 3 Buchstaben sein!!");
			throw new FilmDatenException();
		}
	}
	
	public String getStudio()
	{
		return this.studio;
	}
	public void setLand(String land) throws FilmDatenException
	{
		if(land.length() > 3 ) this.land = land;
		else
		{
			System.err.println("Der Name des Landes ist zu klein. Es müssen mehr als 3 Buchstaben sein!!");
			throw new FilmDatenException();
		}
	}
	public String getLand()
	{
		return this.land;
	}
	/**
	 * Set Methode fuer FSK. Diese Methode vergleicht  mit if und else if, ob 
	 * die eingegebene Zahl auch der FSK entspricht. 
	 * @param fsk
	 * @throws FilmDatenException 
	 */
	public void setFsk(int fsk) throws FilmDatenException 
	{
		if(fsk == 0) this.fsk = fsk;
		else if (fsk == 6)  this.fsk = fsk;
		else if (fsk == 12) this.fsk = fsk;
		else if (fsk == 16) this.fsk = fsk;
		else if (fsk == 18) this.fsk = fsk;
		else
		{
			System.err.println("Fehler!!! in setFSK "+"Der Wert: "+fsk+" ist kein Gültigerwert");
			throw new FilmDatenException();
		}
	}
	public int getFsk()
	{
		return this.fsk;
	}
	/**
	 * Set Methode für die Farbe. Prüft ob es ein s/w oder Farbe ist.
	 */
	public void setFarbe(String kanal) throws FilmDatenException
	{
		
		if(kanal == "s/w")
		{
			this.farbe = kanal;
		}
		else if(kanal == "S/W")
		{
			this.farbe = kanal;
		}
		else if(kanal == "farbe")
		{
			this.farbe = kanal;
		}	
		else if(kanal == "Farbe")
		{
			this.farbe = kanal;
		}
		else
		{
			System.err.println("Keine richtige Angabe. Gebe s/w oder farbe ein.");
			throw new FilmDatenException();
		}
	}
	public String getFarbe()
	{
		return this.farbe;
	}
	public void setGenere(String genere) throws FilmDatenException
	{
		if(genere.length() > 3 ) this.genere = genere;
		else
		{
			System.out.println("Genere ist zu klein. Es müssen mehr als 3 Buchstaben sein!!");
			throw new FilmDatenException();
		}
	}
	public String getGenere()
	{
		return this.genere;
	}
	/**
	 * Set Methode für die Bewertung.
	 * Die Bewertung geht von 0 bis 10 Punkte.
	 * @param bewertung
	 */
	public void setBewertung(int bewertung) throws FilmDatenException
	{
		if (bewertung >= 0 && bewertung <= 10) this.bewertung = bewertung;
		else
		{
			System.err.println("Es muss eine Zahl von 0 bis 10 sein!!");
			throw new FilmDatenException();
		}
	}
	public int getBewertung()
	{
		return this.bewertung;
	}
/*Hir enden die Paramete für den Datentype Film	
*-----------------------------------------------------------------------------*/
	/**
	 * Die Überschreibene equals() Methode
	 * 
	 */
	
	public void toStringVoid()
	{
		System.out.print(toString());
	}
	@Override
	public String toString() {
		return "Jahr: " + jahr +"\n"+ "Laenge: " + laenge +" min."+"\n"+"FSK: " + fsk +"\n"+ "deutscher Titel: " + titelDE +"\n"+ 
				"englischer Titel: " + titelEN +"\n"+ "Sprache: " + sprache + "\n"+"Darsteller: " + darsteller +"\n"+ "Farbe: " + farbe +"\n"+ 
				"Regie: "+ regie +"\n"+ "Genere: " + genere + "\n"+"Produzent: " + produzent +"\n"+ "Studio: " + studio +"\n"+ "Land: " + land
				+"\n" +"Bewertung: " + bewertung;
	}

	public boolean equals(Object m) 
	{
		//Hir wird Objekt zu Film gekastet und zu f2 zugewiesen
		Film m2 =(Film)m; 
		/*Die if Bedingung prüft, ob die Einzelnen bestandteile gleich sind.
		 * Titel muss mit .equals verglichen werden, weil Tiel String(Objekt) ist
		 */
		if(this.titelDE.equals(m2.getTitelDE()) && this.titelEN.equals(m2.getTitelEN()) 
		   && this.laenge == m2.getLaenge() && this.jahr == m2.getJahr())
		  	return true;
			return false;
	}
	/**
	 * Diese Methode prüft ob die Filme gleich sind. 
	 * Sie greift dabei auf die Methode {@link #equals(Object)} zurück
	 * 
	 * @param m1 erster Film
	 * @param m2 zweiter Film
	 */
	public void equalsMovie(Film m1, Film m2)
	{
		if((m1.equals(m2))) System.err.println("Die Filme sind gleich");
		else 
		{
			System.out.println("Die Filme sind nicht die selben");
			return;
		}
	}
	/**
	 * Verändert den Aktuellen deutschen Namens eines Titels
	 * @param neuerTitel
	 * @return true
	 */
	public boolean updateTitelDE(String neuerTitel) throws FilmDatenException
	{
		if(neuerTitel.equals(titelDE)) 
		{
			System.err.println("Der Titel stimmt mit dem alten Titel überein.");
			throw new FilmDatenException();
		}
		else if(neuerTitel.length() < 2) 
		{
			System.err.println("Der neue Titel ist zu klein!");
			throw new FilmDatenException();
		}
		else if(neuerTitel.length() > 45)
		{
			System.err.println("Der neue Titel ist zu groß!");
			throw new FilmDatenException();
		}
		this.titelDE = neuerTitel;
		return true;	
	}
	/**
	 * Verändert den Aktuellen englischen Namens eines Titels
	 * @param neuerTitel
	 * @return
	 */
	public boolean updateTitelEN(String neuerTitel) throws FilmDatenException 
	{
		if(neuerTitel.equals(titelEN)) 
		{
			System.err.println("Der Titel stimmt mit dem alten Titel überein!");
			throw new FilmDatenException();
		}
		else if(neuerTitel.length() < 2) 
		{
			System.err.println("Der neue Titel ist zu klein!");
			throw new FilmDatenException();
		}
		else if(neuerTitel.length() > 45)
		{
			System.err.println("Der neue Titel ist zu groß!");
			throw new FilmDatenException();
		}
		this.titelEN = neuerTitel;
		return true;
	}

}