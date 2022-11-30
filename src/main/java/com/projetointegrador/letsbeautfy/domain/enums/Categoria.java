package com.projetointegrador.letsbeautfy.domain.enums;

public enum Categoria {

    BELEZA(0, "ROLE_BELEZA"), BARBEARIA(1, "ROLE_BARBEARIA"), ESTETICA(2, "ROLE_ESTETICA");

    private Integer codigo;
    private String descricao;

    Categoria (Integer codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public static Categoria toEnum(Integer cod){
        if (cod == null) {
            return null;
        }
        for (Categoria x : Categoria.values()) {
            if (cod.equals(x.getCodigo())){
                return x;
            }
        }
        throw new IllegalArgumentException("Categoria inválida");
    }
}
