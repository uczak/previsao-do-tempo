/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package previsao_do_tempo;

import java.util.ArrayList;
import java.util.List;
import static previsao_do_tempo.S.controle;

/**
 *
 * @author guiwe
 */
public class W
{

    public List<TOPrevisaoDoTempo> buscarPdt(String nome_cidade, String tp_previsao)
    {
        try
        {
            List<TOPrevisaoDoTempo> ListaToPrevisaoDoTempo = new ArrayList<>();
            String cod_cidade = "";
            cod_cidade = cidades(nome_cidade);
            if ("".equals(cod_cidade))
            {
                TOPrevisaoDoTempo toPrevisaoDoTempo = new TOPrevisaoDoTempo();
                toPrevisaoDoTempo.SetToErro("Método: buscarPdt.", "Mensagem: codigo da cidade vazio.");
                ListaToPrevisaoDoTempo.add(toPrevisaoDoTempo);
                return ListaToPrevisaoDoTempo;
            }
            ListaToPrevisaoDoTempo = controle(cod_cidade, tp_previsao);
            return ListaToPrevisaoDoTempo;
        }
        catch (Exception ex)
        {
            throw ex;
        }
    }

    private String cidades(String nome_cidade)
    {
        String cod_cidade = "";
        switch (nome_cidade.toUpperCase())
        {
            case "PORTO ALEGRE":
                cod_cidade = "3452925";
                break;
            case "SÃO PAULO":
                cod_cidade = "3448439";
                break;
            case "GRAVATAÍ":
                cod_cidade = "3462089";
                break;
            case "CANOAS":
                cod_cidade = "3467467";
                break;
            case "CACHOEIRINHA":
                cod_cidade = "3468403";
                break;
            case "FLORIANOPOLIS":
                //cod_cidade = "3463237";
                cod_cidade = "00000";
                break;
        }
        return cod_cidade;
    }
}
