import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class UsingJava {
    public static String returnResponse(String url){
        try{
            URL obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            // optional request header
            con.setRequestProperty("User-Agent", "Mozilla/5.0");
            int responseCode = con.getResponseCode();
            System.out.println("Response code: " + responseCode);
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            String html = response.toString();
            return html;
        }catch (IOException ie){
            ie.printStackTrace();
            return null;
        }
    }

    public static void main(String args[]) {
        String responseBody = returnResponse("https://sourceforge.net/projects/orangehrm/");
        Document doc = Jsoup.parse(responseBody);
        Elements links = doc.select("a[href]");
        for (Element link : links) {
            String href = link.attr("href");
            System.out.println(href);
        }
    }
}