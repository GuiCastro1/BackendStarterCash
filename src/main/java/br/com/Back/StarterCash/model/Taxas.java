package br.com.Back.StarterCash.model;

public enum Taxas {

    POUPANCA(
            "Poupança",
            0.005,
            "Baixo risco e baixo rendimento."
    ),

    CDB(
            "CDB",
            0.009,
            "Mais rendimento que a poupança com segurança."
    ),

    IPCA(
            "Tesouro IPCA+",
            0.012,
            "Protege contra a inflação."
    ),

    FII(
            "Fundo Imobiliário",
            0.010,
            "Renda mensal com imóveis."
    ),

    BTC(
            "Bitcoin",
            0.025,
            "Alta volatilidade."
    ),

    ETH(
            "Ethereum",
            0.021,
            "Cripto com grande potencial."
    );

    private final String nome;
    private final double taxa;
    private final String descricao;

    Taxas(String nome, double taxa, String descricao) {
        this.nome = nome;
        this.taxa = taxa;
        this.descricao = descricao;
    }

    public String getNome() {
        return nome;
    }

    public double getTaxa() {
        return taxa;
    }

    public String getDescricao() {
        return descricao;
    }
}
