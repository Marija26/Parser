package myParser.model;

import myParser.view.View;
import myParser.vo.Vacancy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Admin on 08.06.2017.
 */
public class Model {

    View view;
    Provider[] providers;

    public Model(View view, Provider... providers) {
        if (view ==null|| providers == null) {
            throw new IllegalArgumentException();
        }
        this.view = view;
        this.providers = providers;
    }


    public void selectCity(String city){
        List<Vacancy> vacancies = new ArrayList<>();

        for (Provider provider : providers) {
            vacancies.addAll(provider.getJavaVacancies(city));
        }

        view.update(vacancies);
    }

}
