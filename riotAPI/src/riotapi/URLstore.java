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
    
    public URLstore()
    {
        APIkey = fileReader();
    }

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

    public static String fileReader()
    {
        StringBuilder sb = new StringBuilder();
        String strLine = "";
        try
        {
            BufferedReader br = new BufferedReader(new FileReader("C:/Users/peter/Desktop/RIOT API KET.txt"));
            while (strLine != null)
            {
                sb.append(strLine);
                sb.append(System.lineSeparator());
                strLine = br.readLine();
                return strLine;
            }
            br.close();
        } catch (FileNotFoundException e)
        {
            System.err.println("File not found");
        } catch (IOException e)
        {
            System.err.println("Unable to read the file.");
        }
        return "";
    }
}
