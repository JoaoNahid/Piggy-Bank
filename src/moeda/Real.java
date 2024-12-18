package moeda;

import java.util.List;

public class Real extends Moeda {

    static final String m_Moeda = "Real";
    static final String m_Simbolo = "R$";

    // O valor do real em relacao ao real é 1
    public Real() {
        super(1, m_Moeda, m_Simbolo);
    }

    public List<Double> getMoedasPossiveis() {
        return List.of(0.05, 0.10, 0.25, 0.50, 1.00);
    }

    public String info() {
        return m_Simbolo + " " + this.m_Valor;
    }

    public double converter() {
        return this.getM_Valor() * this.m_Conversao;
    }
}
