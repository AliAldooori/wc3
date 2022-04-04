package wc;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
public class Customer {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "customer_id")
    private int customerId;
    @Basic
    @Column(name = "förnamn")
    private String förnamn;
    @Basic
    @Column(name = "efternamn")
    private String efternamn;
    @Basic
    @Column(name = "födelsedatum")
    private String födelsedatum;
    @Basic
    @Column(name = "telefonnummer")
    private String telefonnummer;


    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getFörnamn() {
        return förnamn;
    }

    public void setFörnamn(String förnamn) {
        this.förnamn = förnamn;
    }

    public String getEfternamn() {
        return efternamn;
    }

    public void setEfternamn(String efternamn) {
        this.efternamn = efternamn;
    }

    public String getFödelsedatum() {
        return födelsedatum;
    }

    public void setFödelsedatum(String födelsedatum) {
        this.födelsedatum = födelsedatum;
    }

    public String getTelefonnummer() {
        return telefonnummer;
    }

    public void setTelefonnummer(String telefonnummer) {
        this.telefonnummer = telefonnummer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return customerId == customer.customerId && Objects.equals(förnamn, customer.förnamn) && Objects.equals(efternamn, customer.efternamn) && Objects.equals(födelsedatum, customer.födelsedatum) && Objects.equals(telefonnummer, customer.telefonnummer);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId=" + customerId +
                ", förnamn='" + förnamn + '\'' +
                ", efternamn='" + efternamn + '\'' +
                ", födelsedatum='" + födelsedatum + '\'' +
                ", telefonnummer='" + telefonnummer + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerId, förnamn, efternamn, födelsedatum, telefonnummer);
    }
}
