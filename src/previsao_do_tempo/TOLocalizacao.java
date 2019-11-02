/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package previsao_do_tempo;

/**
 *
 * @author guiwe
 */
public class TOLocalizacao
{

    private double latitude;
    private double longitude;
    private int cod_city;
    private String name;
    private String pais;

    public void SetLatitude(double latitude)
    {
        this.latitude = latitude;
    }

    public double GetLatitude()
    {
        return latitude;
    }

    public void SetLongitude(double longitude)
    {
        this.longitude = longitude;
    }

    public double GetLongitude()
    {
        return longitude;
    }

    public void SetCod_city(int cod_city)
    {
        this.cod_city = cod_city;
    }

    public int GetCod_city()
    {
        return cod_city;
    }

    public void SetName(String name)
    {
        this.name = name;
    }

    public String GetName()
    {
        return name;
    }

    public void SetPais(String pais)
    {
        this.pais = pais;
    }

    public String GetPais()
    {
        return pais;
    }

}
