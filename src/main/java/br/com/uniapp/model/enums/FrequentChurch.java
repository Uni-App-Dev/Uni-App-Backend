package br.com.uniapp.model.enums;

public enum FrequentChurch {
    SIM("Sim"),
    JA_FREQUENTOU("Não, mas já frequentou"),
    NUNCA_FREQUENTOU("Não, nunca frequentou");

    private final String desc;

    private FrequentChurch(String desc){
        this.desc = desc;
    }

    public String getDesc(){
        return this.desc;
    }
}
