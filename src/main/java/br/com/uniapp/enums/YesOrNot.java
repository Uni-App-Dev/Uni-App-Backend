package br.com.uniapp.enums;

public enum YesOrNot {
    SIM("Sim",true),
    NAO("Não",false);

    private final boolean trueOrFalse;
    private final String desc;
    private YesOrNot(String desc, boolean trueOrFalse){
        this.trueOrFalse = trueOrFalse;
        this.desc = desc;
    }

    public boolean getTrueOrFalse(){
        return this.trueOrFalse;
    }

    public String getDesc(){
        return this.desc;
    }
}
