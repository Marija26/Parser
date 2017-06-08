package myParser.model;

import myParser.vo.Vacancy;

import java.util.List;

/**
 * Created by Admin on 05.06.2017.
 */
public class Provider {
    Strategy strategy;
    public Provider(Strategy strategy){
        this.strategy = strategy;
    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    List<Vacancy> getJavaVacancies(String searchString){
        return strategy.getVacancies(searchString);
    }
}
