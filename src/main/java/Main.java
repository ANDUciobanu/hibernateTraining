import DAO.DaoDescriere;
import DAO.ProdusOpperation;
import entity.Descriere;
import entity.Produs;

import java.util.Arrays;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Produs produs=new Produs();
       // produs.setId(952);
        produs.setName("mere");
        produs.setPrice(10);
        produs.setExpireDate(new Date(System.currentTimeMillis()));

        Produs produs1=new Produs();
        produs1.setName("Rosii");
        produs1.setPrice(12);
        produs1.setExpireDate(new Date(System.currentTimeMillis()));

        Produs produs2=new Produs();
        produs2.setName("Ardei");
        produs2.setPrice(99);
        produs2.setExpireDate(new Date(System.currentTimeMillis()));

        Produs produs3=new Produs();
        produs3.setName("Banane");
        produs3.setPrice(1);
        produs3.setExpireDate(new Date(System.currentTimeMillis()));


        ProdusOpperation produsOpperation=new ProdusOpperation();
        //produsOpperation.insertProdus(produs);

      //  produsOpperation.updateProdus(produs);

//        produsOpperation.deleteProdus(253);
//        produsOpperation.deleteProdus(254);
//       produsOpperation.deleteProdus(303);

        //System.out.println(produsOpperation.getProdus(202));

      //  produsOpperation.insertProduse(Arrays.asList(produs,produs1,produs2,produs3));
      // System.out.println(produsOpperation.getProduscByName("rosii"));
      //  produsOpperation.updateProdusById(produs);

        //+DESCRIERE
        Descriere descriere=new Descriere();
        descriere.setCuloare("rosu");
        descriere.setConditiiDePastrare("uscat");
        descriere.setStoc(3);
        produs.setDescriere(descriere);
        descriere.setProdus(produs);

        Descriere descriere1=new Descriere();
        descriere1.setCuloare("verde");
        descriere1.setConditiiDePastrare("umed");
        descriere1.setStoc(10);
        produs1.setDescriere(descriere1);
        descriere1.setProdus(produs1);

        Descriere descriere2=new Descriere();
        descriere2.setCuloare("mov");
        descriere2.setConditiiDePastrare("palet");
        descriere2.setStoc(7);
        produs2.setDescriere(descriere2);
        descriere2.setProdus(produs2);

        Descriere descriere3=new Descriere();
        descriere3.setCuloare("mov");
        descriere3.setConditiiDePastrare("palet");
        descriere3.setStoc(7);
        produs3.setDescriere(descriere3);
        descriere3.setProdus(produs3);

       // produsOpperation.insertProduse(Arrays.asList(produs,produs1,produs2,produs3));
     // produsOpperation.insertProdus(produs1);
        DaoDescriere daoDescriere=new DaoDescriere();
        System.out.println(daoDescriere.getDescriere(2));

    }
}
