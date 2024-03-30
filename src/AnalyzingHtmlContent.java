import java.util.ArrayDeque;
import java.util.Deque;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AnalyzingHtmlContent {
    private String[] lines;
    private Pattern openTagPattern = Pattern.compile("<([a-zA-Z]+)>");
    private Pattern closeTagPattern = Pattern.compile("<\\/([^>]+)>");
    private Deque<String> htmlPile = new ArrayDeque<>();
    private String contentResult = "";
    private String tagNameOpen = "";
    private String tagNameClose = "";
    private int resultDepthPile =  0;
    private int depthPile = 0;

    public String analyzingHtmlContent(String htmlContent) {
        lines = htmlContent.toString().split("\\n");

        for(int l = 0; l < lines.length; l++) {
            Matcher matchOpenTagPattern = openTagPattern.matcher(lines[l]);
            Matcher matchCloseTagPattern = closeTagPattern.matcher(lines[l]);

            if (matchOpenTagPattern.find()) {
                tagNameOpen = matchOpenTagPattern.group(1);
                htmlPile.push(tagNameOpen);
            } else if (matchCloseTagPattern.find()) {
                tagNameClose = matchCloseTagPattern.group(1);
                if (!htmlPile.element().toString().equals((tagNameClose).toString())) {
                    contentResult = "malformed HTML";
                    break;
                }
                htmlPile.pop();
            } else {
                depthPile = htmlPile.size();
                if(depthPile > resultDepthPile) {
                    contentResult = lines[l].trim();
                    resultDepthPile = depthPile;
                }
            }
        }
        return contentResult;
    }
}
