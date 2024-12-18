import moeda.Dolar;
import moeda.Euro;
import moeda.Moeda;
import moeda.Real;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Cofrinho {
    private ArrayList<Moeda> m_ListaMoedas = new ArrayList<Moeda>();

    // métodos requeridos
    /**
     * Metodo para adicionar a moeda ao cofrinho
     * @param p_Moeda
     * @return boolean
     */
    public boolean adicionar(Moeda p_Moeda) {
        double v_valor = (double)this.selecionarValor(false);
        if(!p_Moeda.getMoedasPossiveis().contains(v_valor)) {
            System.out.println("Esta moeda não existe no dólar");
            return false;
        }

        p_Moeda.setM_Valor(v_valor);
        return this.m_ListaMoedas.add(p_Moeda);
    }

    /**
     * Metodo para remover a moeda do cofrinho
     * @param p_Moeda
     * @return boolean
     */
    public boolean remover(Moeda p_Moeda) {
        try {
            this.m_ListaMoedas.remove(p_Moeda);
            return true;
        } catch (Exception p_Exception) {
            return false;
        }
    }

    /**
     * Metodo de listagem das moedas do cofrinho
     */
    public void listagemMoedas() {
        System.out.println("MOEDAS NO COFRINHO:");
        for (int c_Index = 0; c_Index < this.m_ListaMoedas.size(); c_Index++) {
            // pega a moeda em questao
            Moeda v_Moeda = this.m_ListaMoedas.get(c_Index);
            System.out.println((c_Index + 1) + ". " + v_Moeda.info());
        }
    }

    /**
     * Metodo para exibir valor total no cofrinho ja convertido
     */
    public double totalConvertido() {
        double v_Soma = 0;
        for (int c_Index = 0; c_Index < this.m_ListaMoedas.size(); c_Index++) {
            Moeda v_Moeda = this.m_ListaMoedas.get(c_Index);
            v_Soma += v_Moeda.converter();
        }

        return v_Soma;
    }


    // Metodos adicionais

    /**
     * Metodo que inicializa as ações do cofrinho
     */
    public void acessarCofrinho() {
        String v_Acao = "";
        while (v_Acao != "sair") {
            v_Acao = this.menuPrincipal();

            switch (v_Acao) {
                case "adicionar":
                    this.menuAdicao();
                    break;
                case "remover":
                    this.menuRemover();
                    break;
                case "listar":
                    this.listagemMoedas();
                    break;
                case "total":
                    System.out.printf("Você possui R$ %.2f ja convertido \n", this.totalConvertido());
                    break;
            }
        }
    }

    /**
     * Metodo para retornar um valor digitado pelo usuário
     * @return Number
     */
    protected Number selecionarValor(boolean p_Int) {
        Scanner v_Entrada = new Scanner(System.in);
        System.out.println("Digite um valor");
        if (p_Int) {
            return v_Entrada.nextInt();
        }
        return v_Entrada.nextDouble();
    }


    // Definição dos menus

    /**
     * Metodo para exibir interface de adição de moeda
     */
    public void menuAdicao() {
        String v_Opcao = "";

        while (v_Opcao != "voltar") {
            v_Opcao = this.menuTipoMoeda(false);
            switch (v_Opcao) {
                case "dolar":
                    this.adicionar(new Dolar());
                    break;
                case "euro":
                    this.adicionar(new Euro());
                    break;
                case "real":
                    this.adicionar(new Real());
                    break;
            }
        }
    }

    /**
     * Metodo para exibir interface de remoção de moeda
     */
    public void menuRemover() {
        this.listagemMoedas();
        System.out.println("Selecione o indíce de uma moeda para remover:");
        int v_Opcao = (int)this.selecionarValor(true) - 1; // subtrai 1 pois o index é acrescido 1 para ser exibido
        this.remover(this.m_ListaMoedas.get(v_Opcao));
    }

    /**
     * Metodo para exibir menu principal e retornar opção selecionada
     * @return String
     */
    public String menuPrincipal() {
        Scanner v_Entrada = new Scanner(System.in);

        // Define as opcoes do menu
        HashMap<Integer,String> v_Opcoes = new HashMap<Integer, String>();
        v_Opcoes.put(1, "adicionar");
        v_Opcoes.put(2, "remover");
        v_Opcoes.put(3, "listar");
        v_Opcoes.put(4, "total");
        v_Opcoes.put(5, "sair");
        // define a opcao selecionada como 0 inicialmente
        int v_OpcaoSelecionada = 0;

        while (v_OpcaoSelecionada < 1 || v_OpcaoSelecionada > 4) {
            System.out.println("Slecione uma opção:");
            System.out.println("1. Adicionar moeda");
            System.out.println("2. Remover moeda");
            System.out.println("3. Listar moedas");
            System.out.println("4. Total convertido");
            System.out.println("5. Sair");

            if (v_Entrada.hasNextInt()) {
                v_OpcaoSelecionada = v_Entrada.nextInt();
                if (v_OpcaoSelecionada < 1 || v_OpcaoSelecionada > 5) {
                    System.out.println("Selecione um dos números acima");
                }
            } else {
                System.out.println("Selecione um valor entre 1 e 4");
                v_Entrada.next();
            }
        }

        return v_Opcoes.get(v_OpcaoSelecionada);
    }

    /**
     * Metodo para exibir menu de tipos de moedas e retornar opção selecionada
     * @return String
     */
    protected String menuTipoMoeda(boolean p_Remover) {
        Scanner v_Entrada = new Scanner(System.in);
        // Define as opcoes disponíveis
        HashMap<Integer, String> v_Opcoes = new HashMap<Integer, String>();
        v_Opcoes.put(1, "dolar");
        v_Opcoes.put(2, "euro");
        v_Opcoes.put(3, "real");
        v_Opcoes.put(4, "voltar");
        int v_OpcaoSelecionada = 0;

        while (v_OpcaoSelecionada < 1 || v_OpcaoSelecionada > 4) {
            if (p_Remover) {
                System.out.println("Qual moeda gostaria de remover?");
            } else{
                System.out.println("Qual moeda gostaria de adicionar?");
            }
            System.out.println("1. Dólar");
            System.out.println("2. Euro");
            System.out.println("3. Real");
            System.out.println("4. Voltar");

            if (v_Entrada.hasNextInt()) {
                v_OpcaoSelecionada = v_Entrada.nextInt();
                if (v_OpcaoSelecionada < 1 || v_OpcaoSelecionada > 4) {
                    System.out.println("Selecione um dos números acima");
                }
            } else {
                System.out.println("Selecione um valor entre 1 e 3");
                v_Entrada.next();
            }
        }
        return v_Opcoes.get(v_OpcaoSelecionada);
    }
}
