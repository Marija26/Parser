package myParser.view;

import myParser.controller.Controller;
import myParser.vo.Vacancy;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * Created by Admin on 08.06.2017.
 */
public class HtmlView implements View {
    private final String filePath = "./src/main/java/" + this.getClass().getPackage().getName().replace('.', '/') + "/vacancies.html";
    Controller controller;

    @Override
    public void update(List<Vacancy> vacancies) {
        String newVacanciesFile = getUpdatedFileContent(vacancies);
        updateFile(newVacanciesFile);
    }

    @Override
    public void setController(Controller controller) {
        this.controller = controller;
    }
    private String getUpdatedFileContent(List<Vacancy> vacancies)
    {
        String content;

        try
        {
            Document document = getDocument();
            Element element = document.getElementsByClass("template").first();
            Element cloneElement = element.clone();
            cloneElement.removeClass("template");
            cloneElement.removeAttr("style");


            document.select("tr[class=vacancy]").remove();

            for (Vacancy vacancy: vacancies){
                Element nextCloneElement = cloneElement.clone();
                nextCloneElement.getElementsByClass("city").first().text(vacancy.getCity());
                nextCloneElement.getElementsByClass("companyName").first().text(vacancy.getCompanyName());
                nextCloneElement.getElementsByClass("salary").first().text(vacancy.getSalary());
                nextCloneElement.getElementsByTag("a").first()
                        .text(vacancy.getTitle())
                        .attr("href", vacancy.getUrl());
                element.before(nextCloneElement.outerHtml());
            }
            content = document.html();
        }
        catch (IOException e)
        {
            e.printStackTrace();
            content = "Some exception occurred";
        }


        return content;
    }
    protected Document getDocument() throws IOException{
        return Jsoup.parse(new File(filePath),"UTF-8");
    }
    private void updateFile(String s)
    {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));
            writer.write(s);
            writer.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void userCitySelectEmulationMethod()
    {
        controller.onCitySelect("Kiev");
    }

}
