/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package riotapi;

/**
 *
 * @author Peter
 */
public class URLstore
{
    private String APIkey = "RGAPI-1a087187-8932-4415-8e16-aa6f1406cf55";
    
    public String summoner(String name, String region)  
    {
        String url = "https://"+region+".api.riotgames.com/lol/summoner/v3/summoners/by-name/"+name+"?api_key="+APIkey;
        return url;
    }
    public void setKey(String key)
    {
        APIkey = key;
    }
    
}
