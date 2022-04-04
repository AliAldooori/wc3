package wc;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Arena {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "arena_id")
    private int arenaId;
    @Basic
    @Column(name = "arena_name")
    private String arenaName;
    @Basic
    @Column(name = "inomhus_utomhus")
    private Boolean inomhusUtomhus;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn (name = "adress_id")
    private Address arena_adress;

    public int getArenaId() {
        return arenaId;
    }

    public void setArenaId(int arenaId) {
        this.arenaId = arenaId;
    }

    public Arena getArenaName() {
        return getArenaName();
    }

    public void setArenaName(String arenaName) {
        this.arenaName = arenaName;
    }

    public Address getArena_adress() {
        return arena_adress;
    }

    public void setArena_adress(Address arena_adress) {
        this.arena_adress = arena_adress;
    }

    public Boolean getInomhusUtomhus() {
        return inomhusUtomhus;
    }

    public void setInomhusUtomhus(Boolean inomhusUtomhus) {
        this.inomhusUtomhus = inomhusUtomhus;
    }

    @Override
    public String toString() {
        return "Arena{" +
                "arenaId=" + arenaId +
                ", arenaName='" + arenaName + '\'' +
                ", inomhusUtomhus=" + inomhusUtomhus +
                ", arena_adress=" + arena_adress +
                '}';
    }
}





