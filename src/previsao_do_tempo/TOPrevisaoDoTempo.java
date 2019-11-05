/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package previsao_do_tempo;

import java.text.DecimalFormat;
import org.json.JSONObject;

/**
 *
 * @author guiwe
 */
public class TOPrevisaoDoTempo extends TOLocalizacao
{

    private TOErro toErro;
    private String temperatura;
    private int pressao;
    private int umidade;
    private String temp_min;
    private String temp_max;
    private int visibilidade;
    private String velocidade_vento;
    private int nas_sol;
    private int por_sol;
    private String id0;//*
    private String descrisao;//*
    private String icone;//*
    private String base;//*
    private double deg;//descobrir significado
    private int all;//descobrir significado
    private long dt;//descobrir significado
    private int type;//descobrir significado
    private long id1;//descobrir significado
    private double timezone;//descobrir significado
    private long cod;//*
    DecimalFormat df = new DecimalFormat("###,##0.0");

    public void SetToErro(String metodo, String mensagem)
    {
        if (this.toErro == null)
        {
            this.toErro = new TOErro();
        }
        this.toErro.setMetodo(metodo);
        this.toErro.setMensagem(mensagem);
    }

    public TOErro GetToErro()
    {
        return toErro;
    }

    public void SetTemperatura(double temperatura)
    {
        temperatura = temperatura - 273;
        this.temperatura = df.format(temperatura) + "° C";
    }

    public String getTemperatura()
    {
        return temperatura;
    }

    public void SetPressao(int pressao)
    {
        this.pressao = pressao;
    }

    public int getPressao()
    {
        return pressao;
    }

    public void SetUmidade(int humidade)
    {
        this.umidade = humidade;
    }

    public int getUmidade()
    {
        return umidade;
    }

    public void SetTemp_min(double temp_min)
    {
        temp_min = temp_min - 273;
        this.temp_min = df.format(temp_min) + "° C";
    }

    public String getTemp_min()
    {
        return temp_min;
    }

    public void SetTemp_max(double temp_max)
    {
        temp_max = temp_max - 273;
        this.temp_max = df.format(temp_max) + "° C";
    }

    public String getTemp_max()
    {
        return temp_max;
    }

    public void SetVisibilidade(int visibilidade)
    {
        this.visibilidade = visibilidade;
    }

    public int getVisibilidade()
    {
        return visibilidade;
    }

    public void SetVelocidade_vento(double velocidade_vento)
    {
        velocidade_vento = velocidade_vento * 1.61;
        this.velocidade_vento = df.format(velocidade_vento) + " Km/h";
    }

    public String getVelocidade_vento()
    {
        return velocidade_vento;
    }

    public void SetNas_sol(int nas_sol)
    {
        this.nas_sol = nas_sol;
    }

    public int getNas_sol()
    {
        return nas_sol;
    }

    public void SetPor_sol(int por_sol)
    {
        this.por_sol = por_sol;
    }

    public int getPor_sol()
    {
        return por_sol;
    }

    public void SetDescrisao(String descrisao)
    {
        this.descrisao = descrisao;
    }

    public String getDescrisao()
    {
        return descrisao;
    }

    public static TOPrevisaoDoTempo PopularTOPrevisaoDoTempo(JSONObject Json)
    {
        try
        {
            // List<TOPrevisaoDoTempo> lista = new ArrayList<>();
            TOPrevisaoDoTempo toPrevisaoDoTempo = new TOPrevisaoDoTempo();

            //#region TOLocalizacao 
            if (Json.has("lat") && Json.get("lat") != null)
            {
                toPrevisaoDoTempo.SetLatitude((double) Json.get("lat"));
            }
            if (Json.has("lon") && Json.get("lon") != null)
            {
                toPrevisaoDoTempo.SetLongitude((double) Json.get("lon"));
            }
            if (Json.has("id1") && Json.get("id1") != null)
            {
                toPrevisaoDoTempo.SetCod_city((int) Json.get("id1"));
            }
            if (Json.has("name") && Json.get("name") != null)
            {
                toPrevisaoDoTempo.SetName((String) Json.get("name"));
            }
            if (Json.has("country") && Json.get("country") != null)
            {
                toPrevisaoDoTempo.SetPais((String) Json.get("country"));
            }
            //#endRegion
            if (Json.has("temp") && Json.get("temp") != null)
            {
                toPrevisaoDoTempo.SetTemperatura((double) Json.get("temp"));
            }
            if (Json.has("pressure") && Json.get("pressure") != null)
            {
                toPrevisaoDoTempo.SetPressao((int) Json.get("pressure"));
            }
            if (Json.has("humidity") && Json.get("humidity") != null)
            {
                toPrevisaoDoTempo.SetUmidade((int) Json.get("humidity"));
            }
            if (Json.has("temp_min") && Json.get("temp_min") != null)
            {
                toPrevisaoDoTempo.SetTemp_min((double) Json.get("temp_min"));
            }
            if (Json.has("temp_max") && Json.get("temp_max") != null)
            {
                toPrevisaoDoTempo.SetTemp_max((double) Json.get("temp_max"));
            }
            if (Json.has("visibility") && Json.get("visibility") != null)
            {
                toPrevisaoDoTempo.SetVisibilidade((int) Json.get("visibility"));
            }
            if (Json.has("speed") && Json.get("speed") != null)
            {
                toPrevisaoDoTempo.SetVelocidade_vento((double) Json.get("speed"));
            }
            if (Json.has("sunrise") && Json.get("sunrise") != null)
            {
                toPrevisaoDoTempo.SetNas_sol((int) Json.get("sunrise"));
            }
            if (Json.has("sunset") && Json.get("sunset") != null)
            {
                toPrevisaoDoTempo.SetPor_sol((int) Json.get("sunset"));
            }
            if (Json.has("description") && Json.get("description") != null)
            {
                toPrevisaoDoTempo.SetDescrisao((String) Json.get("description"));
            }
            // lista.add(toPrevisaoDoTempo);
            return toPrevisaoDoTempo;
        }
        catch (Exception ex)
        {
            throw ex;
        }
    }
}
