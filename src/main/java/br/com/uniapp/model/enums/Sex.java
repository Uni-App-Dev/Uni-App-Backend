package br.com.uniapp.model.enums;

public enum Sex {
    MASCULINO("M"),
    FEMININO("F");

    private final String sex;
    private Sex(String sex){
        this.sex = sex;
    }

    public String getSex(){
        return this.sex;
    }
}
