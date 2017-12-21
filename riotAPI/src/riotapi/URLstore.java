/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package riotapi;
import java.io.*;

/**
 *
 * @author Peter
 */
public class URLstore
{

    private String APIkey = "";
    

    public String summoner(String name, String region)
    {
        String url = "https://" + region + ".api.riotgames.com/lol/summoner/v3/summoners/by-name/" + name + "?api_key=" + APIkey;
        return url;
    }

    public String champion(long id, String region)
    {
        String url = "https://" + region + ".api.riotgames.com/lol/champion-mastery/v3/champion-masteries/by-summoner/" + id + "?api_key=" + APIkey;
        return url;
    }

    public void setKey(String key)
    {
        APIkey = key;
    }

}
