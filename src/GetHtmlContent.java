import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class GetHtmlContent {
    private URL website;
    private BufferedReader readUrlContent;
    private StringBuilder htmlContent;
    private String line;

    public String getPage(String urlBrowser) throws IOException {
        website = new URL(urlBrowser);
        readUrlContent = new BufferedReader(new InputStreamReader(website.openStream()));
        htmlContent = new StringBuilder();

        while ((line = readUrlContent.readLine()) != null) {
            htmlContent.append(line).append("\n");
        }

        readUrlContent.close();

        return htmlContent.toString();
    }
}
