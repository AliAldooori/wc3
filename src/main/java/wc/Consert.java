package wc;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Consert {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "consert_id")
    private int consertId;
    @Basic
    @Column(name = "artistnamn")
    private String artistnamn;
    @Basic
    @Column(name = "datum")
    private String datum;
    @Basic
    @Column(name = "biljettpris")
    private String biljettpris;

    @ManyToMany(cascade = CascadeType.ALL , fetch = FetchType.EAGER)
    @JoinColumn ( name = "arena")
    private List<Arena> arena = new ArrayList<>() ;

    public int getConsertId() {
        return consertId;
    }

    public void setConsertId(int consertId) {
        this.consertId = consertId;
    }

    public String getArtistnamn() {
        return artistnamn;
    }

    public void setArtistnamn(String artistnamn) {
        this.artistnamn = artistnamn;
    }

    public String getDatum() {
        return datum;
    }

    public void setDatum(String datum) {
        this.datum = datum;
    }

    public String getBiljettpris() {
        return biljettpris;
    }

    public void setBiljettpris(String biljettpris) {
        this.biljettpris = biljettpris;
    }

    public List<Arena> getArena() {
        return arena;
    }

    public void setArena(List<Arena> arena) {
        this.arena = arena;
    }

    @Override
    public String toString() {
        return "Consert{" +
                "consertId=" + consertId +
                ", artistnamn='" + artistnamn + '\'' +
                ", datum='" + datum + '\'' +
                ", biljettpris='" + biljettpris + '\'' +
                ", arena=" + arena +
                '}';
    }
}



