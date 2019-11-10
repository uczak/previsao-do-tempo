/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package previsao_do_tempo;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author guiwe
 */
public class Infra extends TOPrevisaoDoTempo
{

    public String GravarLog(String msg) throws IOException
    {
        FileWriter fw = null;
        BufferedWriter bw = null;
        try
        {
            File arq = new File("arquivo_de_logs.txt");
            if (!arq.exists())
            {
                arq.createNewFile();
            }
            fw = new FileWriter(arq, true);
            bw = new BufferedWriter(fw);
            bw.write(msg);
            bw.newLine();

//            FileReader fr = new FileReader(arq);
//            BufferedReader br = new BufferedReader(fr);
//            while (br.ready())
//            {
//                String linha = br.readLine();
//                System.out.println(linha);
//            }
//            br.close();
//            fr.close();
            return "";
        }

        catch (Exception ex)
        {
            return "não foi possivel gravar o Log no arquivo. Exception:" + ex;
        }
        finally
        {
            bw.close();
            fw.close();
        }

    }
}
