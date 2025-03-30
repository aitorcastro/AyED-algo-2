package aed;

public class Recordatorio {
    private String mensaje;
    private Fecha fecha;
    private Horario horario;

    public Recordatorio(String mensaje, Fecha fecha, Horario horario) {
        this.mensaje = mensaje;
        this.fecha = new Fecha(fecha);
        this.horario = horario;
    }

    public Horario horario() {
        return horario;
    }

    public Fecha fecha() {
        Fecha nuevaFecha = new Fecha(fecha);
        return nuevaFecha;
    }

    public String mensaje() {
        return mensaje;
    }

    @Override
    public String toString() {
        String recordatorioString = mensaje + " @ " + fecha.toString() + " " + horario.toString();
        return recordatorioString;
    }

    @Override
    public boolean equals(Object otro) {
        boolean otroEsNull = (otro == null);
        boolean claseDistinta = otro.getClass() != this.getClass();
        if (otroEsNull || claseDistinta) {
            return false;
        }

        Recordatorio otroRecordatorio = (Recordatorio) otro;
        return this.mensaje.equals(otroRecordatorio.mensaje) && 
        this.horario.equals(otroRecordatorio.horario) && 
        this.fecha.equals(otroRecordatorio.fecha);
    }

}
