package com.projetointegrador.letsbeautfy.domain.enums;

public enum Horarios {

    H1(0, "09:00 às 10:00"), H2(1, "10:00 às 11:00"), H3(2, "11:00 às 12:00"), H4(3, "13:00 às 14:00"), H5(4, "14:00 às 15:00"), H6(5, "15:00 às 16:00");

    private Integer codigo;
    private String descricao;

    Horarios(Integer codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public static Horarios toEnum(Integer cod){
        if(cod == null){
            return null;
        }
        for(Horarios x : Horarios.values()) {
            if(cod.equals(x.getCodigo())){
                return x;
            }
        }
        throw new IllegalArgumentException("Horário inválido");
    }
}
