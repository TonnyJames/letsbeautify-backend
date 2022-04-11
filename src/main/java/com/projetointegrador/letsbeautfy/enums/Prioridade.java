package com.projetointegrador.letsbeautfy.enums;

public enum Prioridade {

    NORMAL(0, "ROLE_NORMAL"), ALTA(1, "ROLE_ALTA");

    private Integer codigo;
    private String descricao;

    Prioridade(Integer codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public static Prioridade toEnum(Integer cod){
        if(cod == null){
            return null;
        }
        for(Prioridade x : Prioridade.values()) {
            if(cod.equals(x.getCodigo())){
                return x;
            }
        }
        throw new IllegalArgumentException("Prioridade inválida");
    }
}
