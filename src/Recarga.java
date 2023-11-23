import java.text.SimpleDateFormat;
import java.util.Calendar;

class Recarga {
    private Calendar data;
    private float valor;

    public Recarga(Calendar data, float valor) {
        this.data = data;
        this.valor = valor;
    }

    public Calendar getData() {
        return data;
    }

    public float getValor() {
        return valor;
    }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("DD/MM/YYYY HH:MM:SS");
        return "Data: " + sdf.format(data.getTime()) + ", Valor: R$ " + valor;
    }
}
