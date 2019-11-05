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
    private double temp_min;
    private double temp_max;
    private int visibilidade;
    private double velocidade_vento;
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
//    public double formatar(double numero)
//    {
//        double retorno;
//        DecimalFormat formata =null;
//        formata = new DecimalFormat("###,##0.0");
//        retorno = formata.format(numero);
//        return retorno;
//    }

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
        this.temperatura = df.format(temperatura);
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
        this.temp_min = temp_min;
    }

    public double getTemp_min()
    {
        return temp_min;
    }

    public void SetTemp_max(double temp_max)
    {
        this.temp_max = temp_max;
    }

    public double getTemp_max()
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
        this.velocidade_vento = velocidade_vento;
    }

    public double getVelocidade_vento()
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
            if (Json.get("lat") != null)
            {
                toPrevisaoDoTempo.SetLatitude((double) Json.get("lat"));
            }
            if (Json.get("lon") != null)
            {
                toPrevisaoDoTempo.SetLongitude((double) Json.get("lon"));
            }
            if (Json.get("id1") != null)
            {
                toPrevisaoDoTempo.SetCod_city((int) Json.get("id1"));
            }
            if (Json.get("name") != null)
            {
                toPrevisaoDoTempo.SetName((String) Json.get("name"));
            }
            if (Json.get("country") != null)
            {
                toPrevisaoDoTempo.SetPais((String) Json.get("country"));
            }
            //#endRegion
            if (Json.get("temp") != null)
            {
                toPrevisaoDoTempo.SetTemperatura((double) Json.get("temp"));
            }
            if (Json.get("pressure") != null)
            {
                toPrevisaoDoTempo.SetPressao((int) Json.get("pressure"));
            }
            if (Json.get("humidity") != null)
            {
                toPrevisaoDoTempo.SetUmidade((int) Json.get("humidity"));
            }
            if (Json.get("temp_min") != null)
            {
                toPrevisaoDoTempo.SetTemp_min((double) Json.get("temp_min"));
            }
            if (Json.get("temp_max") != null)
            {
                toPrevisaoDoTempo.SetTemp_max((double) Json.get("temp_max"));
            }
            if (Json.get("visibility") != null)
            {
                toPrevisaoDoTempo.SetVisibilidade((int) Json.get("visibility"));
            }
            if (Json.get("speed") != null)
            {
                toPrevisaoDoTempo.SetVelocidade_vento((double) Json.get("speed"));
            }
            if (Json.get("sunrise") != null)
            {
                toPrevisaoDoTempo.SetNas_sol((int) Json.get("sunrise"));
            }
            if (Json.get("sunset") != null)
            {
                toPrevisaoDoTempo.SetPor_sol((int) Json.get("sunset"));
            }
            if (Json.get("description") != null)
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
