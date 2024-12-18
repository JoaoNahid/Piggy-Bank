package moeda;

import java.util.List;

abstract public class Moeda {
    public String m_Nome;
    public String m_Simbolo;
    protected double m_Valor;
    public double m_Conversao;
//    protected double m_Conversao;
    public abstract List<Double> getMoedasPossiveis();

    // métodos  construtores
    public Moeda() {}

    public Moeda(double p_Conversao, String p_Nome, String p_Simbolo) {
        this.m_Conversao = p_Conversao;
        this.m_Nome = p_Nome;
        this.m_Simbolo = p_Simbolo;
    }

    // métodos abstratos
    public abstract String info();

    public abstract double converter();

    // Getters & Setters
    public double getM_Valor() {
        return m_Valor;
    }

    public void setM_Valor(double p_Valor) {
        this.m_Valor = p_Valor;
    }
}
