package com.example.parseoxml2spinner;

import java.util.List;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

@Root(name = "consulta_Municipiero", strict = false)

public class Municipiero {

    @ElementList
    private List<Municipio> municipiero;

    public List<Municipio> getmunicipiero() {
        return municipiero;
    }

    public void setmunicipiero(List<Municipio> municipiero) {
        this.municipiero = municipiero;
    }

    @Override
    public String toString() {
        return  " " + municipiero ;
    }

}
