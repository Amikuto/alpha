package per.ami.alpha.pojo.dto;

public class InfoPageTestData {

    public static InfoPage infoPage() {
        return new InfoPage("testurl", "broke");
    }

    public static String infoPageString() {
        return new InfoPage("testurl", "broke").toString();
    }
}
