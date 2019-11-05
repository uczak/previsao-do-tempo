/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package previsao_do_tempo;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import previsao_do_tempo.HttpExemplo;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author guiwe
 */
public class S extends Infra
{

    //busca json da previsao do tempo
    private static String getPrevisao(String idCity, String tpRequest) throws Exception
    {
        String sJson = "";
        String url = null;
        Gson gSon = new Gson();
        HttpExemplo request = new HttpExemplo();
        if (null != tpRequest)
        {
            switch (tpRequest)
            {
                case "Atual":
                    url = "http://api.openweathermap.org/data/2.5/weather?id=" + idCity + "&appid=4e6327bac3230a583079e31491060b85";
                    break;
                case "CincoDias":
                    url = "http://api.openweathermap.org/data/2.5/forecast?id=" + idCity + "&appid=4e6327bac3230a583079e31491060b85";
                    break;
                default:
                    url = "";
                    break;
            }
        }
        sJson = request.sendGet(url);
        //System.out.println("cru:" + sJson);
        return sJson;
        //sJson = formataJson(sJson);
        //sJson= "{\"lon\":-51.09,\"lat\":-29.95,\"id0\":500,\"description\":\"light rain\",\"icon\":\"10d\",\"base\":\"stations\",\"temp\":292.55,\"pressure\":1010,\"humidity\":88,\"temp_min\":289.26,\"temp_max\":294.26,\"visibility\":9000,\"speed\":5.7,\"deg\":350,\"all\":90,\"dt\":1572208512,\"type\":1,\"id1\":8467,\"country\":\"BR\",\"sunrise\":1572165255,\"sunset\":1572212521,\"timezone\":-10800,\"id2\":3468403,\"name\":\"Cachoeirinha\",\"cod\":200}";
        //PopulaPrevisao(sJson);
    }

    private static String formataJson(String sJson)
    {
        int id = 0;
        int indice;
        String a;
        String[] tagsJson =
        {
            "coord", "weather", "wind", "Clouds", "clouds", "sys", "Rain", "rain", "Clear", "main", "Mist"
        };
        //#region 
        indice = sJson.indexOf("weather");
        String parte1 = sJson.substring(0, indice);//recorta a string antes do array.

        indice = sJson.indexOf("base");
        String parte2 = sJson.substring(indice, sJson.length());//recorta a string depois do array.

        JSONObject oJson = new JSONObject(sJson.toString());//trasforma a string em objeto.
        JSONArray objetoWeather = oJson.getJSONArray("weather");//trasforma o objeto em um array.

        sJson = parte1 + parte2;//concatena.
        System.out.println("formatando:" + sJson);
        //#endregion

        for (String tagsJson1 : tagsJson)
        {
            if (sJson.contains(tagsJson1))
            {
                sJson = sJson.replace(tagsJson1, "");
            }
            if (sJson.contains("\"id\""))
            {
                indice = sJson.indexOf("\"id\":");
                a = sJson.substring(indice, sJson.length()).replaceFirst("id", ("id" + id));
                id++;
                sJson = sJson.substring(0, indice) + a;
            }

        }
        System.out.println("formatando:" + sJson);
        sJson += "," + objetoWeather.get(0).toString();//concatena.
        System.out.println("formatando:" + sJson);
        sJson = sJson.replace("{", "");
        sJson = sJson.replace("[", "");
        sJson = sJson.replace("]", "");
        sJson = sJson.replace("}", "");
        sJson = sJson.replace("\"\":", "");
        sJson = sJson.replace("\"\",", "");
        sJson = sJson.replace(",,", ",");
        sJson = "{" + sJson + "}";
        System.out.println("ja formatado:" + sJson);
        return sJson;
    }

    public static List<TOPrevisaoDoTempo> controle(String idCity, String tpRequest)
    {
        TOPrevisaoDoTempo toPrevisaoDoTempo = new TOPrevisaoDoTempo();
        String sJson = "";
        List<TOPrevisaoDoTempo> ListaToPrevisaoDoTempo = new ArrayList<>();
        try
        {
            sJson = getPrevisao(idCity, tpRequest);//busca a string com json.
            if ("".equals(sJson))
            {
                toPrevisaoDoTempo.SetToErro("Método: controle.", "Mensagem: string com json esta vazia.");
                ListaToPrevisaoDoTempo.add(toPrevisaoDoTempo);
                return ListaToPrevisaoDoTempo;
            }
            if ("CincoDias".equals(tpRequest))
            {
                int indice = sJson.indexOf("\"list\":[");
                sJson = "{" + sJson.substring(indice, sJson.length());
                JSONObject oJson = new JSONObject(sJson.toString());//trasforma a string em objeto.
                JSONArray objetoWeather = oJson.getJSONArray("list");//trasforma o objeto em um array.
                objetoWeather.getJSONObject(0);
                objetoWeather.getJSONObject(1);
                objetoWeather.getJSONObject(2);
            }
            else
            {
                sJson = formataJson(sJson);
                JSONObject Json = new JSONObject(sJson.toString());//trasforma a string em objeto.
                ListaToPrevisaoDoTempo.add(PopularTOPrevisaoDoTempo(Json));//adiciona o objeto na lista.
            }
            return ListaToPrevisaoDoTempo;
        }
        catch (Exception ex)
        {
            toPrevisaoDoTempo.SetToErro("Método: controle.", "Mensagem: Exception:: " + ex + ".");
            ListaToPrevisaoDoTempo.add(toPrevisaoDoTempo);
            return ListaToPrevisaoDoTempo;

        }
    }
}
