package googleurlshortner;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Guest
 */
public class GoogleUrlShortner {

    public static void main(String[] args) {
        try {
            // TODO code application logic here

            //get this key from google
            //this is long url parameter
            String json = "{\"longUrl\": \"http://www.facebook.com\"}";

            URL url = new URL("https://www.googleapis.com/urlshortener/v1/url?&key=<-API KEY->");
            HttpURLConnection urlConn = (HttpURLConnection) url.openConnection();
            urlConn.setDoOutput(true);
            urlConn.setRequestMethod("POST");
            urlConn.setRequestProperty("content-Type", "application/json");
            OutputStream os = urlConn.getOutputStream();
            os.write(json.getBytes());
            os.flush();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConn.getInputStream()));
            String shortUrl = "";
            while((shortUrl = bufferedReader.readLine() )!= null){
             
                System.out.println("result : " + shortUrl);
            }
            urlConn.disconnect();
         
        } catch (MalformedURLException ex) {
            Logger.getLogger(GoogleUrlShortner.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(GoogleUrlShortner.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}