import java.text.SimpleDateFormat;
import java.util.Calendar;

class Chamada {
    private Calendar data;
    private int duracaoEmMinutos;
    private String numeroDiscado;

    public Chamada(Calendar data, int duracaoEmMinutos, String numeroDiscado) {
        this.data = data;
        this.duracaoEmMinutos = duracaoEmMinutos;
        this.numeroDiscado = numeroDiscado;
    }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("DD/MM/YYYY HH:MM:SS");
        return "Data: " + sdf.format(data.getTime()) + ", Duração: " + duracaoEmMinutos + " minutos, Número discado: " + numeroDiscado;
    }
}