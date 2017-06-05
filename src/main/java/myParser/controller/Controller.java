package myParser.controller;

import myParser.model.Provider;

import java.util.Arrays;

/**
 * Created by Admin on 05.06.2017.
 */
public class Controller {

    private Provider[] providers;

    public Controller(Provider[] providers) {
        this.providers = providers;
        if(this.providers == null){
            throw new IllegalArgumentException();
        }
    }

    @Override
    public String toString() {
        return "Controller{" +
                "providers=" + Arrays.toString(providers) +
                '}';
    }
}
