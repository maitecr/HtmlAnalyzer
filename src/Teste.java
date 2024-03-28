import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Teste {
    public static void main(String[] args) throws Exception {
        //String url = "http://hiring.axreng.com/internship/example4.html";
        //Scanner insertUrl = new Scanner(System.in);
        //System.out.println("inserir-url-aqui");
        //String url = insertUrl.nextLine();

        ScanUrl scanUrl = new ScanUrl();
        String cacthUrl = scanUrl.scanUrl();

        URL website = new URL(cacthUrl);

        BufferedReader readUrlContent = new BufferedReader(new InputStreamReader(website.openStream()));
        StringBuilder htmlContent = new StringBuilder();
        String line;

        while ((line = readUrlContent.readLine()) != null) {
            htmlContent.append(line).append("\n");
        }

        String[] lines = htmlContent.toString().split("\\n");

        Pattern openTagPattern = Pattern.compile("<([a-zA-Z]+)>");
        Pattern closeTagPattern = Pattern.compile("<\\/([^>]+)>");

        Deque<String> pilha = new ArrayDeque<>();
        String result;
        String tagNameOpen;
        String tagNameClose;
        int resultDepth = 0;
        int depth = 0;

        for (int l = 0; l < lines.length; l++) {
            Matcher matchOpenTagPattern = openTagPattern.matcher(lines[l]);
            Matcher matchCloseTagPattern = closeTagPattern.matcher(lines[l]);

            // System.out.println(lines[l]);

            if (matchOpenTagPattern.find()) {
                System.out.println("Linha inserida");
                tagNameOpen = matchOpenTagPattern.group(1);
                System.out.println("tagOpen: " + tagNameOpen);
                pilha.push(tagNameOpen);
                System.out.println("-------------------------------");

            } else if (matchCloseTagPattern.find()) {
                tagNameClose = matchCloseTagPattern.group(1);
                if (!pilha.element().toString().equals((tagNameClose).toString())) {
                    System.out.println("elemento topo " + pilha.element());
                    System.out.println("Malformed HTML");
                }
                pilha.pop();
                System.out.println("Linha removida");
                System.out.println("close tag:" + tagNameClose);
                System.out.println("-------------------------------");
            } else if (!(lines[l].isEmpty())) {
                depth = pilha.size();
                if (depth > resultDepth) {
                    result = lines[l];
                    System.out.println("Conteúdo string");
                    System.out.println(result);
                    System.out.println("-------------------------------");
                }
            }



            readUrlContent.close();
        }

    }
}