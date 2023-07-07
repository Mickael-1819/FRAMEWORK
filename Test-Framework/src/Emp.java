package model.societe;

import etu1819.annotation.Urls;
import etu1819.framework.ModelView;
import java.util.Vector;

public class Emp {
    String nom;

    public Emp(){

    }

    public void embaucher(){}
   
    @Urls(url = "getAllEmp")
    public ModelView getAll(){
        ModelView mv = new ModelView();
          // vue destinatrice
          mv.setView("emp-list.jsp");

          //elements de donnees a passer a la vue
          Vector<Emp> liste = new Vector<Emp>();
          Emp e = new Emp(),
              e2 =  new Emp(),
              e3 =  new Emp();
  
          e.setNom("Lili");
          e2.setNom("Nato");
          e3.setNom("Miki");
          liste.add(e);
          liste.add(e2);
          liste.add(e3);
  
          // ajout de la liste aux donnees a passer
          mv.addItem("liste", liste);
  
          return mv;
      }
      
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}