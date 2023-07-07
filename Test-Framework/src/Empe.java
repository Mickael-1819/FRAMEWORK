package model2;

import etu1819.annotation.Urls;
import etu1819.framework.ModelView;

public class Empe {
    @Urls(url = "emp-myMethod")
   public ModelView Inscrire(){
        ModelView mv = new ModelView();
        mv.setView("emp-list.jsp");
        return mv;
    }   

}