package myParser.model;

import myParser.model.vo.Vacancy;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.List;

/**
 * Created by Admin on 05.06.2017.
 */
public class HHStrategy implements Strategy{
    public final static String URL_FORMAT = "http://hh.ua/search/vacancy?text=java+%s&page=%d";

    protected Document getDocument(String searchString, int page) throws IOException {
        String url = String.format(URL_FORMAT, searchString, page);
        Document document = Jsoup.connect(url).userAgent("").referrer("none").get();

        return document;
    }

    public List<Vacancy> getVacancies(String searchString) {
        return null;
    }
}
