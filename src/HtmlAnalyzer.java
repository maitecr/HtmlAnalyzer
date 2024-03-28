import java.net.URL;

public class HtmlAnalyzer {
    public static void main(String[] args) {

        try {
            //String url = "http://hiring.axreng.com/internship/example1.html";
            ScanUrl scanUrl = new ScanUrl();
            String url = scanUrl.scanUrl();



            Connected connected = new Connected();

            if(connected.isConnected(url)){
                 GetHtmlContent getHtmlContent = new GetHtmlContent();
                 String htmlContent = getHtmlContent.getPage(url);
                // System.out.println(htmlContent);
                // System.out.println(htmlContent.length());


            } else {
                 System.out.println("URL connection error");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
