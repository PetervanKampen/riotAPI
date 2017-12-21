package riotapi;

import java.net.*;
import java.io.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 *
 * @author Peter
 */
public class RiotAPI
{

    private static JSONObject raw;
    private static JSONParser parser = new JSONParser();
    private static long id;
    private static long accountid;
    private static String name;
    private static long profileIconId;
    private static long revisionDate;
    private static long summonerlevel;
    private static int champAmount = 3;
    public static String champMastery = "";
    private static URLstore store = new URLstore();
    private static champID champs = new champID();
    private static String region;
    private static String input;

    public RiotAPI()
    {

    }

    public static String summonerData() throws Exception
    {
        raw = new JSONObject();
        URL api = new URL(store.summoner(input, region));
        URLConnection yc = api.openConnection();
        BufferedReader in = new BufferedReader(
                new InputStreamReader(
                        yc.getInputStream()));
        String inputLine;
        while ((inputLine = in.readLine()) != null)
        {
            raw = (JSONObject) parser.parse(inputLine);
        }
        in.close();
        summonerParse(raw);
        return ("Name: " + name + "\nID: " + id + "\nAccountID: " + accountid + "\nIcon ID: " + profileIconId + "\nRevisionDate: " + revisionDate + "\nLevel: " + summonerlevel);

    }

    public static void championData() throws Exception
    {
        raw = new JSONObject();
        URL api = new URL(store.champion(id, region));
        URLConnection yc = api.openConnection();
        BufferedReader in = new BufferedReader(
                new InputStreamReader(
                        yc.getInputStream()));
        String inputLine;
        int counter = 0;
        
        while ((inputLine = in.readLine()) != null)
        {
            JSONArray a = (JSONArray) parser.parse(inputLine);
            for (Object o : a)
            {
                raw = (JSONObject) o;
                championParse(raw, counter);
                counter++;
                if(counter == champAmount) break;
            }
        }
        in.close();
    }

    private static void summonerParse(JSONObject raw)
    {
        id = (long) raw.get("id");
        accountid = (long) raw.get("accountId");
        name = (String) raw.get("name");
        profileIconId = (long) raw.get("profileIconId");
        revisionDate = (long) raw.get("revisionDate");
        summonerlevel = (long) raw.get("summonerLevel");
    }

    private static void championParse(JSONObject raw, int arrayid)
    {
        long champId = (long) raw.get("championId");
        long champLevel = (long) raw.get("championLevel");
        long champPoints = (long) raw.get("championPoints");
        String champName = champs.champID(champId);
        champMastery += "Name: "+champName+"\nChampion Level: "+champLevel+"\nMastery Points: "+champPoints +"\n\n";
    }

    public static void setRegion(String region_)
    {
        region = region_;
    }

    public static void setInputname(String name)
    {
        input = name;
    }
    
    public static void setChampAmount(String amount)
    {
        champAmount = Integer.parseInt(amount);
    }
}
