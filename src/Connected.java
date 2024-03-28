import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

public class Connected {

    public static boolean isConnected(String urlBrowser) {
        try {
            URL url = new URL(urlBrowser);
            URLConnection connection = url.openConnection();
            connection.connect();
            return true;
        } catch (IOException e) {
//            e.printStackTrace();
            return false;
        }
    }

}
