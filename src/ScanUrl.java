import java.net.URL;
import java.util.Scanner;

public class ScanUrl {
    private Scanner insertUrl = new Scanner(System.in);
    private String url;

    public String scanUrl()  {
        System.out.println("inserir-url-aqui");
        url = insertUrl.nextLine();

        return url;
    }

}
