import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class GetHtmlContent {

    public String getPage(URL urlBrowser) throws IOException {
        BufferedReader readUrlContent = new BufferedReader(new InputStreamReader(urlBrowser.openStream()));
        StringBuilder htmlContent = new StringBuilder();
        String line;

        while ((line = readUrlContent.readLine()) != null) {
            htmlContent.append(line).append("\n");
        }

        readUrlContent.close();

        return htmlContent.toString();

    }

}
