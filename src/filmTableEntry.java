import javafx.beans.property.SimpleStringProperty;

/**
 * Created by David Derichs on 14.01.2018.
 */
public class filmTableEntry {    private final SimpleStringProperty jahr;
    private final SimpleStringProperty laenge;
    private final SimpleStringProperty fsk;
    private final SimpleStringProperty titelDE;
    private final SimpleStringProperty titelEN;
    private final SimpleStringProperty sprache;
    private final SimpleStringProperty darsteller;


    public filmTableEntry(Film film){
        this.jahr = new SimpleStringProperty(Integer.toString(film.getJahr()));
        this.laenge = new SimpleStringProperty(Integer.toString(film.getLaenge()));
        this.fsk = new SimpleStringProperty(Integer.toString(film.getFsk()));
        this.titelDE = new SimpleStringProperty(film.getTitelDE());
        this.titelEN = new SimpleStringProperty(film.getTitelEN());
        this.sprache = new SimpleStringProperty(film.getSprache());
        this.darsteller = new SimpleStringProperty(film.getDarsteller());
    }

    public String getJahr() {
        return jahr.get();
    }

    public SimpleStringProperty jahrProperty() {
        return jahr;
    }

    public void setJahr(String jahr) {
        this.jahr.set(jahr);
    }

    public String getLaenge() {
        return laenge.get();
    }

    public SimpleStringProperty laengeProperty() {
        return laenge;
    }

    public void setLaenge(String laenge) {
        this.laenge.set(laenge);
    }

    public String getFsk() {
        return fsk.get();
    }

    public SimpleStringProperty fskProperty() {
        return fsk;
    }

    public void setFsk(String fsk) {
        this.fsk.set(fsk);
    }

    public String getTitelDE() {
        return titelDE.get();
    }

    public SimpleStringProperty titelDEProperty() {
        return titelDE;
    }

    public void setTitelDE(String titelDE) {
        this.titelDE.set(titelDE);
    }

    public String getTitelEN() {
        return titelEN.get();
    }

    public SimpleStringProperty titelENProperty() {
        return titelEN;
    }

    public void setTitelEN(String titelEN) {
        this.titelEN.set(titelEN);
    }

    public String getSprache() {
        return sprache.get();
    }

    public SimpleStringProperty spracheProperty() {
        return sprache;
    }

    public void setSprache(String sprache) {
        this.sprache.set(sprache);
    }

    public String getDarsteller() {
        return darsteller.get();
    }

    public SimpleStringProperty darstellerProperty() {
        return darsteller;
    }

    public void setDarsteller(String darsteller) {
        this.darsteller.set(darsteller);
    }
}
