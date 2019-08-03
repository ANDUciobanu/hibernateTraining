package entity;
import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name ="descriere")



public class Descriere implements Serializable {

    private static final String DESCRIERE_SEQUENCE = "descriere_id_seq";

    public Descriere() {
    }

    @Id
    @SequenceGenerator(name = "descriere_generator", sequenceName = DESCRIERE_SEQUENCE)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "descriere_generator")
    private int id;


    @Column(name="stoc")
    private int stoc;

    @Column(name="conditiiDePastrare")
    private String conditiiDePastrare;

    @OneToOne
    @JoinColumn(name ="produs_id")
    private Produs produs;



    public Produs getProdus() {
        return produs;
    }

    public void setProdus(Produs produs) {
        this.produs = produs;
    }

    public void setCuloare(String culoare) {
        this.culoare = culoare;
    }

    public String getCuloare() {
        return culoare;
    }


    public String getConditiiDePastrare() {
        return conditiiDePastrare;
    }

    public void setConditiiDePastrare(String conditiiDePastrare) {
        this.conditiiDePastrare = conditiiDePastrare;
    }

    public int getStoc() {
        return stoc;
    }

    public void setStoc(int stoc) {
        this.stoc = stoc;
    }

    @Override
    public String toString() {
        return "Descriere{" +
                "id=" + id +
                ", stoc=" + stoc +
                ", conditiiDePastrare='" + conditiiDePastrare + '\'' +
                ", produs=" + produs +
                ", culoare='" + culoare + '\'' +
                '}';
    }

    private String culoare;




}




