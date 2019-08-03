package entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@NamedQueries({
        @NamedQuery(
                name = "find_by_name",
                query ="select s from Produs s where name = :name"
        ),
        @NamedQuery(
                name = "update_produs_identified_by_id",
                query = "update Produs p set name  = : name where id = : id"
        )
})
@Entity
@Table(name="produs")
public class Produs implements Serializable {

    private static final String PRODUS_SEQUENCE = "produs_id_seq";

    public Produs() {
    }

    public static String getProdusSequence() {
        return PRODUS_SEQUENCE;
    }



    @Id
    @SequenceGenerator(name = "produs_generator", sequenceName = PRODUS_SEQUENCE)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "produs_generator")
    private int id;

    @Column(name = "name", unique = true, length = 10)
    private String name;



    @Column(name="price")
    private int price;


    @Column(name="expireDate")
    private Date expireDate;

    @OneToOne(cascade = CascadeType.ALL,mappedBy = "produs")
    private Descriere descriere;

    public Descriere getDescriere() {
        return descriere;
    }

    public void setDescriere(Descriere descriere) {
        this.descriere = descriere;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Date getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(Date expireDate) {
        this.expireDate = expireDate;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Produs{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", expireDate=" + expireDate +
                '}';
    }

}