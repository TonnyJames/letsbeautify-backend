package com.projetointegrador.letsbeautfy.domain.enums;

public enum Perfil {

    ADMIN(0, "ROLE_ADMIN"), CLIENTE(1, "ROLE_CLIENTE"), COLABORADOR(2, "ROLE_COLAB")/*, SERVICO(3, "ROLE_SERVICO")*/;

    private Integer codigo;
    private String descricao;


    Perfil(Integer codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public static Perfil toEnum(Integer cod){
        if(cod == null){
            return null;
        }
        for(Perfil x : Perfil.values()) {
            if(cod.equals(x.getCodigo())){
                return x;
            }
        }
        throw new IllegalArgumentException("Perfil inválido");
    }
}
