package it.prova.prenotazioni.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum Tipo {
	
    @JsonProperty("camera_singola")
    CAMERA_SINGOLA,
    
    @JsonProperty("camera_doppia")
    CAMERA_DOPPIA,
    
    @JsonProperty("camera_matrimoniale")
    CAMERA_MATRIMONIALE,
    
    @JsonProperty("suite")
    SUITE,
    
    @JsonProperty("junior_suite")
    JUNIOR_SUITE,
    
    @JsonProperty("camera_tripla")
    CAMERA_TRIPLA,
    
    @JsonProperty("camera_quadrupla")
    CAMERA_QUADRUPLA,
    
    @JsonProperty("camera_familiare")
    CAMERA_FAMILIARE,
    
    @JsonProperty("camera_deluxe")
    CAMERA_DELUXE,
    
    @JsonProperty("camera_superior")
    CAMERA_SUPERIOR,
    
    @JsonProperty("camera_economica")
    CAMERA_ECONOMICA,
    
    @JsonProperty("camera_con_vista")
    CAMERA_CON_VISTA,
    
    @JsonProperty("camera_accessibile")
    CAMERA_ACCESSIBILE,
    
    @JsonProperty("camera_attico")
    CAMERA_ATTICO,
    
    @JsonProperty("camera_business")
    CAMERA_BUSINESS,
    
    @JsonProperty("camera_standard")
    CAMERA_STANDARD,
    
    @JsonProperty("camera_lusso")
    CAMERA_LUSSO,
    
    @JsonProperty("camera_con_balcone")
    CAMERA_CON_BALCONE,
    
    @JsonProperty("camera_con_terrazza")
    CAMERA_CON_TERRAZZA,
    
    @JsonProperty("camera_executive")
    CAMERA_EXECUTIVE;
}

	
//	@JsonCreator
//    public static Tipo fromValue(String value) {
//        for (Tipo tipo : values()) {
//            if (tipo.name().equalsIgnoreCase(value)) {
//                return tipo;
//            }
//        }
//        throw new IllegalArgumentException("Unknown enum type " + value);
//    }

