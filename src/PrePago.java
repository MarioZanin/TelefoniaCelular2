import java.util.Calendar;

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
        Calendar dataAtual = Calendar.getInstance();
        Recarga recarga = new Recarga(dataAtual, valor);
        creditos += valor;
        if (numRecargas < recargas.length) {
            recargas[numRecargas] = recarga;
            numRecargas++;
        }
    }

    @Override
    public void fazerChamada(Chamada chamada) {
        if (creditos > 0) {
            super.fazerChamada(chamada);
            creditos -= 1; // Deduz 1 crédito por chamada
        } else {
            System.out.println("Saldo insuficiente para fazer chamada. Faça uma recarga.");
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
            if (recarga != null && recarga.getData().get(Calendar.MONTH) == mes - 1 && recarga.getData().get(Calendar.YEAR) == ano) {
                System.out.println(recarga);
            }
        }
        System.out.println("----------------------------");
    }
}