package myParser.model;

import myParser.vo.Vacancy;

import java.util.List;

/**
 * Created by Admin on 05.06.2017.
 */
public interface Strategy {
     List<Vacancy> getVacancies(String searchString);


}
