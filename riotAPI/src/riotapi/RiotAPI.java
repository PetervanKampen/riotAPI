package riotapi;
import java.net.*;
import java.io.*;
import org.json.*;

/**
 *
 * @author Peter
 */
public class RiotAPI
{
    public static JSONObject raw;
    private static int id;
    private static int accountid;
    private static String name;
    private static int profileIconId;
    private static int revisionDate;
    private static int summonerlevel;

    public RiotAPI()
    {
        
    }

    public static void connect() throws Exception
    {
        URL yahoo = new URL("https://euw1.api.riotgames.com/lol/summoner/v3/summoners/by-name/petrovic258?api_key=RGAPI-1a087187-8932-4415-8e16-aa6f1406cf55");
        URLConnection yc = yahoo.openConnection();
        BufferedReader in = new BufferedReader(
                new InputStreamReader(
                        yc.getInputStream()));
        String inputLine;

        while ((inputLine = in.readLine()) != null)
        {
            raw = new JSONObject(inputLine);
        }
        in.close();     
        id = raw.getInt("id");
        accountid = raw.getInt("accountId");
        name = raw.getString("name");
        profileIconId = raw.getInt("profileIconId");
        revisionDate = raw.getInt("revisionDate");
        summonerlevel = raw.getInt("summonerLevel");
        System.out.println("Name: "+name+"\nID: "+id+"\nAccountID: "+accountid+"\nIcon ID: "+profileIconId+"\nrevisionDate: "+revisionDate+"\nLevel: "+summonerlevel);
        
    }

}
