package com.example.parseoxml2spinner;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ServicioProvincia {

    @GET("ovcservweb/ovcswlocalizacionrc/ovccallejero.asmx/ConsultaProvincia")
    Call<Provinciero> listaProvincias();
}
