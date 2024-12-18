package moeda;

import java.util.List;

public class Euro extends Moeda {
    static final String m_Moeda = "Euro";
    static final String m_Simbolo = "€";

    // Define um valor inicial para o euro em relação ao Real
    public Euro() {
        super(6.09, m_Moeda, m_Simbolo);
    }

    // o euro também poderá ser instanciado com outro valor
    public Euro(double p_Conversao) {
        super(p_Conversao, m_Moeda, m_Simbolo);
    }

    public List<Double> getMoedasPossiveis() {
        return List.of(0.01, 0.02, 0.05, 0.10, 0.20, 0.50, 1.00, 2.00);
    }

    public String info() {
        return m_Simbolo + " " + this.m_Valor;
    }

    public double converter() {
        return this.getM_Valor() * this.m_Conversao;
    }
}
