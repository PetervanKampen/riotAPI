/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package riotapi;
import java.net.*;
import java.io.*;

/**
 *
 * @author Peter
 */
public class RiotAPI
{
    public static String raw;
    private int id;
    private int accountid;
    private String name;
    private int profileIconId;
    private int revisionDate;
    private int summonerlevel;

    public RiotAPI()
    {
        
    }

    public static void initial() throws Exception
    {
        URL yahoo = new URL("https://euw1.api.riotgames.com/lol/summoner/v3/summoners/by-name/petrovic258?api_key=RGAPI-1a087187-8932-4415-8e16-aa6f1406cf55");
        URLConnection yc = yahoo.openConnection();
        BufferedReader in = new BufferedReader(
                new InputStreamReader(
                        yc.getInputStream()));
        String inputLine;

        while ((inputLine = in.readLine()) != null)
        {
            raw = inputLine;
        }
        in.close();
        System.out.append(raw);
    }

}
