import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
class Chamada {
    private GregorianCalendar data;
    private int duracaoEmMinutos;
    private String numeroDiscado;
    public Chamada(GregorianCalendar data, int duracaoEmMinutos, String numeroDiscado) {
        this.data = data;
        this.duracaoEmMinutos = duracaoEmMinutos;
        this.numeroDiscado = numeroDiscado;
    }
    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        return "Data: " + sdf.format(data.getTime()) + ", Duração: " + duracaoEmMinutos + " minutos, Número discado: " + numeroDiscado;
    }
    public int getDuracaoEmMinutos() {
        return duracaoEmMinutos;
    }
}