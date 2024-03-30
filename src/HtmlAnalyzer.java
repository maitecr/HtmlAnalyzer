import java.io.IOException;

public class HtmlAnalyzer {
    public static void main(String[] args) {
        Connected connected = new Connected();
        GetHtmlContent getHtmlContent = new GetHtmlContent();
        AnalyzingHtmlContent analyzingHtmlContent = new AnalyzingHtmlContent();
        ScanUrl scanUrl = new ScanUrl();
        String result = "";
        String url = scanUrl.scanUrl();

        try {
            if(connected.isConnected(url)){
                 String htmlContent = getHtmlContent.getPage(url);
                 result = analyzingHtmlContent.analyzingHtmlContent(htmlContent);
                System.out.println(result);
                 //System.out.println(htmlContent);
            } else {
                 System.out.println("URL connection error");
            }
        } catch (Exception e) {
            //e.printStackTrace();
            return;
        }
    }
}
