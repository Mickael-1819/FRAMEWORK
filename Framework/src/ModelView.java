package etu1819.framework;

import java.util.HashMap;

public class ModelView{
    String view;
    HashMap<String, Object> data = new HashMap<String, Object>();


    public ModelView(String view) {
        this.setView(view);
    }
    public ModelView() {
    }
 // _ _ _ Methods _ _ _
 public void addItem(String key, Object value){
    this.data.put(key, value);
}
    // _ _ _ get set 


    public String getView() {
        return view;
    }

    public void setView(String view) {
        this.view = view;
    }
    public HashMap<String, Object> getData() {
        return data;
    }


    public void setData(HashMap<String, Object> data) {
        this.data = data;
    }

}