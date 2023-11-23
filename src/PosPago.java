class PosPago extends Assinante {
    private float assinatura;

    public PosPago(long cpf, String nome, String numero, int maxChamadas, float assinatura) {
        super(cpf, nome, numero, maxChamadas);
        this.assinatura = assinatura;
    }

    @Override
    public void fazerChamada(Chamada chamada) {
        super.fazerChamada(chamada);
    }

    @Override
    public void imprimirFatura(int mes, int ano) {
        System.out.println("Fatura do assinante " + getNome() + " - " + getNumero());
        System.out.println("Mês/Ano: " + mes + "/" + ano);
        System.out.println("Assinatura: R$ " + assinatura);
        System.out.println("Chamadas realizadas:");
        for (Chamada chamada : getChamadas()) {
            System.out.println(chamada);
        }
        System.out.println("----------------------------");
    }

    // Pode ser adicionado outros métodos conforme necessário
}