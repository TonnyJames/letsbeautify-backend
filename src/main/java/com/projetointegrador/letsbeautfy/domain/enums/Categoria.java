package com.projetointegrador.letsbeautfy.domain.enums;

public enum Categoria {

    SALAO_DE_BELEZA(0, "ROLE_SALAO_DE_BELEZA"), BARBARIA(1, "ROLE_BARBEARIA"), ESTUDIO_DE_ESTETICA(2, "ROLE_ESTUDIO_DE_ESTETICA");

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
