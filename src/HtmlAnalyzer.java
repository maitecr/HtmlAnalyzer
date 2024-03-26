import java.net.URL;

public class HtmlAnalyzer {

    public static void main(String[] args) {

        try {
            String url = "http://hiring.axreng.com/internship/example1.html";

            URL website = new URL(url);
            System.out.println(website);

            Connected connected = new Connected();
             if(connected.isConnected(url)) {
                 GetHtmlContent getHtmlContent = new GetHtmlContent();
                 String htmlContent = getHtmlContent.getPage(website);
                 //  System.out.println(htmlContent);
             } else {
                 System.out.println("URL connection error");
             }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
