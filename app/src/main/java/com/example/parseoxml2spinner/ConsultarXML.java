package com.example.parseoxml2spinner;
import android.util.Log;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;

public class ConsultarXML {

    public static void pedirProvincias(Comunicacion c) {
        Retrofit r = new Retrofit.Builder().baseUrl("http://ovc.catastro.meh.es/").addConverterFactory(SimpleXmlConverterFactory.create()).build();
        ServicioProvincia servicio=r.create(ServicioProvincia.class);
        Call<Provinciero> llamada=servicio.listaProvincias();
        llamada.enqueue(new Callback<Provinciero>() {
            @Override
            public void onResponse(Call<Provinciero> call, Response<Provinciero> response) {
                Provinciero p = response.body();
                c.mostrarDatos(p);

            }

            @Override
            public void onFailure(Call<Provinciero> call, Throwable t) {
                Log.d("Respuesta",t.getLocalizedMessage());
            }
        });
    }

    public static void pedirMunicipio(Comunicacion c, String prov) {
        String base = "http://ovc.catastro.meh.es/ovcservweb/ovcswlocalizacionrc/ovccallejero.asmx/";

        Retrofit retrofit = new Retrofit.Builder().baseUrl(base).addConverterFactory(SimpleXmlConverterFactory.create())
                .build();
        ServicioMunicipiero servicio = retrofit.create(ServicioMunicipiero.class);
        Call<Municipiero> llamada = servicio.listaMunicipio(prov,"");
        llamada.enqueue(new Callback<Municipiero>() {
            @Override
            public void onResponse(Call<Municipiero> call, Response<Municipiero> response) {
                Municipiero m = response.body();
                c.mostrarDatos2(m);

            }

            @Override
            public void onFailure(Call<Municipiero> call, Throwable t) {
                Log.d("Respuesta",t.getLocalizedMessage());
            }
        });
    }

    public interface Comunicacion{
        public void mostrarDatos(Provinciero r);
        public void mostrarDatos2(Municipiero r);
    }
}
