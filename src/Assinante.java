import java.util.Arrays;
abstract class Assinante {
    private long cpf;
    private String nome;
    private String numero;
    private Chamada[] chamadas;
    private int numChamadas;
    public Assinante(long cpf, String nome, String numero, int maxChamadas) {
        this.cpf = cpf;
        this.nome = nome;
        this.numero = numero;
        this.chamadas = new Chamada[maxChamadas];
        this.numChamadas = 0;
    }
    public long getCpf() {
        return cpf;
    }
    public String getNome() {
        return nome;
    }
    public String getNumero() {
        return numero;
    }
    public Chamada[] getChamadas() {
        return Arrays.copyOf(chamadas, numChamadas);
    }
    public abstract float getAssinatura(); // Método para obter o valor da assinatura
    public abstract void adicionarSaldo(float valor); // Método para adicionar saldo
    @Override
    public String toString() {
        return "CPF: " + cpf + ", Nome: " + nome + ", Número: " + numero;
    }
    public void fazerChamada(Chamada chamada) {
        if (numChamadas < chamadas.length) {
            chamadas[numChamadas] = chamada;
            numChamadas++;
        }
    }
    public abstract void imprimirFatura(int mes, int ano);
    public abstract boolean podeFazerChamada();
}