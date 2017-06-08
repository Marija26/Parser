package myParser;

import myParser.controller.Controller;
import myParser.model.HHStrategy;
import myParser.model.Model;
import myParser.model.Provider;
import myParser.view.HtmlView;

/**
 * Created by Admin on 05.06.2017.
 */
public class Agregator {
    public static void main(String[] args) {
        HHStrategy hhStrategy = new HHStrategy();
        Provider providerHH = new Provider(hhStrategy);
        HtmlView htmlView = new HtmlView();
        Model model = new Model(htmlView, providerHH);
        htmlView.setController(new Controller(model));
        htmlView.userCitySelectEmulationMethod();

    }


}





