package wc;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Address {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "adress_id")
    private int adressId;
    @Basic
    @Column(name = "gata")
    private String gata;
    @Basic
    @Column(name = "husnummer")
    private String husnummer;
    @Basic
    @Column(name = "postnummer")
    private String postnummer;
    @Basic
    @Column(name = "ort")
    private String ort;


    public int getAdressId() {
        return adressId;
    }

    public void setAdressId(int adressId) {
        this.adressId = adressId;
    }

    public String getGata() {
        return gata;
    }

    public void setGata(String gata) {
        this.gata = gata;
    }

    public String getHusnummer() {
        return husnummer;
    }

    public void setHusnummer(String husnummer) {
        this.husnummer = husnummer;
    }

    public String getPostnummer() {
        return postnummer;
    }

    public void setPostnummer(String postnummer) {
        this.postnummer = postnummer;
    }

    public String getOrt() {
        return ort;
    }

    public void setOrt(String ort) {
        this.ort = ort;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return adressId == address.adressId && Objects.equals(gata, address.gata) && Objects.equals(husnummer, address.husnummer) && Objects.equals(postnummer, address.postnummer) && Objects.equals(ort, address.ort);
    }

    @Override
    public String toString() {
        return "Address{" +
                "adressId=" + adressId +
                ", gata='" + gata + '\'' +
                ", husnummer='" + husnummer + '\'' +
                ", postnummer='" + postnummer + '\'' +
                ", ort='" + ort + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(adressId, gata, husnummer, postnummer, ort);
    }
}
