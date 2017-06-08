package myParser.controller;

import myParser.model.Model;
import myParser.model.Provider;

import java.util.Arrays;

/**
 * Created by Admin on 05.06.2017.
 */
public class Controller {
    Model model;
    public Controller(Model model){
        if(model==null){
            throw new IllegalArgumentException();
        }
        this.model = model;
    }
   public void onCitySelect(String cityName){
        model.selectCity(cityName);
   }
}
