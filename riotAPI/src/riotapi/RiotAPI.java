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
    private static URLstore store = new URLstore();
    private static String region;
    private static String inputname;

    public RiotAPI()
    {
        
    }

    public static String summonerData() throws Exception
    {
        URL api = new URL(store.summoner(inputname, region));
        URLConnection yc = api.openConnection();
        BufferedReader in = new BufferedReader(
                new InputStreamReader(
                        yc.getInputStream()));
        String inputLine;

        while ((inputLine = in.readLine()) != null)
        {
            raw = new JSONObject(inputLine);
        }
        in.close();
        summonerParse(raw);
        return ("Name: " + name + "\nID: " + id + "\nAccountID: " + accountid + "\nIcon ID: " + profileIconId + "\nRevisionDate: " + revisionDate + "\nLevel: " + summonerlevel);

    }

    private static void summonerParse(JSONObject raw)
    {
        id = raw.getInt("id");
        accountid = raw.getInt("accountId");
        name = raw.getString("name");
        profileIconId = raw.getInt("profileIconId");
        revisionDate = raw.getInt("revisionDate");
        summonerlevel = raw.getInt("summonerLevel");
    }
    
    public static void setRegion(String region_)
    {
        region = region_;
    }
    public static void setInputname(String name)
    {
        inputname = name;
    }
}
