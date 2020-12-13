package com.example.parseoxml2spinner;
import org.simpleframework.xml.Root;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ServicioMunicipiero {

    @GET("ConsultaMunicipio")
    Call<Municipiero> listaMunicipio(@Query(value="Provincia") String p,@Query(value="Municipio") String o );
}
