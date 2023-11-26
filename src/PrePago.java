import java.util.GregorianCalendar;
class PrePago extends Assinante {
    private Recarga[] recargas;
    private int numRecargas;
    private float creditos;
    public PrePago(long cpf, String nome, String numero, int maxChamadas, int maxRecargas) {
        super(cpf, nome, numero, maxChamadas);
        this.recargas = new Recarga[maxRecargas];
        this.numRecargas = 0;
        this.creditos = 0;
    }
    public float getCreditos() {
        return creditos;
    }
    public void recarregar(float valor) {
        GregorianCalendar dataAtual = new GregorianCalendar();
        Recarga recarga = new Recarga(dataAtual, valor);
        creditos += valor;
        if (numRecargas < recargas.length) {
            recargas[numRecargas] = recarga;
            numRecargas++;
        }
    }
    @Override
    public void fazerChamada(Chamada chamada) {
        if (podeFazerChamada()) {
            super.fazerChamada(chamada);
            creditos -= 1.45 * chamada.getDuracaoEmMinutos(); // Deduz o custo da chamada por minuto
            // Não permitir créditos negativos após a chamada
            if (creditos < 0) {
                creditos += 1.45 * chamada.getDuracaoEmMinutos(); // Desfaz a última dedução
                System.out.println("Saldo insuficiente para fazer chamada. A chamada não foi realizada.");
            }
        } else {
            System.out.println("Saldo insuficiente para fazer chamada. A chamada não foi realizada.");
        }
    }
    @Override
    public void imprimirFatura(int mes, int ano) {
        System.out.println("Fatura do assinante " + getNome() + " - " + getNumero());
        System.out.println("Mês/Ano: " + mes + "/" + ano);
        System.out.println("Créditos disponíveis: R$ " + creditos);
        System.out.println("Chamadas realizadas:");
        for (Chamada chamada : getChamadas()) {
            System.out.println(chamada);
        }
        System.out.println("Recargas realizadas:");
        for (Recarga recarga : recargas) {
            if (recarga != null && recarga.getData().get(GregorianCalendar.MONTH) == mes - 1 && recarga.getData().get(GregorianCalendar.YEAR) == ano) {
                System.out.println(recarga);
            }
        }
        System.out.println("----------------------------");
    }
    @Override
    public boolean podeFazerChamada() {
        return creditos > 0;
    }
}