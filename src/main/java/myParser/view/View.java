package myParser.view;

import myParser.controller.Controller;
import myParser.vo.Vacancy;

import java.util.List;

/**
 * Created by Admin on 08.06.2017.
 */
public interface View {
    void update(List<Vacancy> vacancies);
    void setController(Controller controller);
}
