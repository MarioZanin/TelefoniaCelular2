class PosPago extends Assinante {
    private float assinatura;
    private float saldo; // Adicionado para controlar o saldo
    public PosPago(long cpf, String nome, String numero, int maxChamadas, float assinatura) {
        super(cpf, nome, numero, maxChamadas);
        this.assinatura = assinatura;
        this.saldo = assinatura; // Inicia o saldo com o valor da assinatura
    }
    @Override
    public void fazerChamada(Chamada chamada) {
        super.fazerChamada(chamada);
        saldo -= 1.04 * chamada.getDuracaoEmMinutos(); // Deduz o custo da chamada por minuto
        // Permitir chamadas até o limite do valor da assinatura
        if (saldo < 0) {
            saldo += 1.04 * chamada.getDuracaoEmMinutos(); // Desfaz a última dedução
            System.out.println("Limite de assinatura atingido. Não é possível fazer mais chamadas.");
        }
    }
    @Override
    public void imprimirFatura(int mes, int ano) {
        System.out.println("Fatura do assinante " + getNome() + " - " + getNumero());
        System.out.println("Mês/Ano: " + mes + "/" + ano);
        System.out.println("Assinatura: R$ " + getAssinatura());
        System.out.println("Chamadas realizadas:");
        for (Chamada chamada : getChamadas()) {
            System.out.println(chamada);
        }
        System.out.println("Saldo atual: R$ " + saldo);
        System.out.println("----------------------------");
    }
    @Override
    public float getAssinatura() {
        return assinatura;
    }
    @Override
    public void adicionarSaldo(float valor) {
        saldo += valor;
    }
    @Override
    public boolean podeFazerChamada() {
        return saldo > 0;
    }
}