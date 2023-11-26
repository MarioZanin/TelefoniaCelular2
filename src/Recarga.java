import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
class Recarga {
    private GregorianCalendar data;
    private float valor;
    public Recarga(GregorianCalendar data, float valor) {
        this.data = data;
        this.valor = valor;
    }
    public GregorianCalendar getData() {
        return data;
    }
    public float getValor() {
        return valor;
    }
    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        return "Data: " + sdf.format(data.getTime()) + ", Valor: R$ " + valor;
    }
}