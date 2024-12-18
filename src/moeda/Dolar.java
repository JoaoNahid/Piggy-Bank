package moeda;

import java.util.List;

public class Dolar extends Moeda{
    static final String m_Moeda = "Dolar";
    static final String m_Simbolo = "$";

    // Define um valor inicial para o dolar em relação ao Real
    public Dolar() {
        super(5.81, m_Moeda, m_Simbolo);
    }

    // o Dólar também poderá ser instanciado com outro valor
    public Dolar(double p_Conversao) {
        super(p_Conversao, m_Moeda, m_Simbolo);
    }

    public List<Double> getMoedasPossiveis() {
        return List.of(0.01, 0.05, 0.10, 0.25, 0.50, 1.00);
    }

    public String info() {
        return m_Simbolo + " " + this.m_Valor;
    }

    public double converter() {
        return this.getM_Valor() * this.m_Conversao;
    }
}
