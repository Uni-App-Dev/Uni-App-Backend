package br.com.uniapp.enums;

public enum SmallGroupRole {

    LIDER("Líder"),
    MEMBRO("Membro"),
    NAO_FREQUENTA("Não frequenta");

    private final String desc;

    private SmallGroupRole(String desc){
        this.desc = desc;
    }

    public String getDesc(){
        return this.desc;
    }
}
