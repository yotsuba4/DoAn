package cdio4.cots.foodoffer.database;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class RequestAPI {
    private String message;
    private String token;
    private StringBuilder contents;

    public RequestAPI(String message, String token) {
        this.message = message;
        this.token = token;
        contents = new StringBuilder();
    }

    public String GetRequest(String... requestUrl){
        try {
            URL url = new URL(requestUrl[0]);
            HttpsURLConnection conn =
                    (HttpsURLConnection) url.openConnection();
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setRequestProperty("Authorization", "Bearer " + token);
            conn.connect();

            InputStreamReader inputStreamReader = new InputStreamReader(conn.getInputStream());
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            String line = "";
            while ((line = bufferedReader.readLine())!= null){
                contents.append(line);
            }
            bufferedReader.close();
            conn.disconnect();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return contents.toString();
    }

    public String PostRequest(String... requestUrl){
        try {
            URL url = new URL(requestUrl[0]);
            HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setRequestProperty("Authorization", "Bearer " + token);
            conn.connect();

            DataOutputStream wr = new DataOutputStream(conn.getOutputStream());
            wr.writeBytes(message);
            wr.flush();
            wr.close();
//
            InputStream in = new BufferedInputStream(conn.getInputStream());
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            String line;
            while ((line = reader.readLine()) != null) {
                contents.append(line);
            }
            //
            conn.disconnect();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return contents.toString();
    }
}
