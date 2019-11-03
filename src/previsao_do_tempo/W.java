/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package previsao_do_tempo;

import java.util.ArrayList;
import java.util.List;
import previsao_do_tempo.S;
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
            ListaToPrevisaoDoTempo = Controle("3468403", tp_previsao);
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
                cod_cidade = "";
                break;
            case "SAO PAULO":
                cod_cidade = "";
                break;
            case "GRAVATAI":
                cod_cidade = "";
                break;
            case "CANOAS":
                cod_cidade = "";
                break;
            case "CACHOEIRINHA":
                cod_cidade = "";
                break;
            case "FLORIANOPOLIS":
                cod_cidade = "";
                break;
        }
        return cod_cidade;
    }
}
