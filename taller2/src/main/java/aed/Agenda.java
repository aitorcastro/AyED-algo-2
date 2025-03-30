package aed;

public class Agenda {
    private Fecha fechaActual;
    private ArregloRedimensionableDeRecordatorios listaRecordatorios;

    public Agenda(Fecha fechaActual) {
        this.fechaActual = new Fecha(fechaActual);
        this.listaRecordatorios = new ArregloRedimensionableDeRecordatorios();
    }

    public void agregarRecordatorio(Recordatorio recordatorio) {
        Recordatorio nuevoRecordatorio = new Recordatorio(
            recordatorio.mensaje(), 
            recordatorio.fecha(),
            recordatorio.horario());
        listaRecordatorios.agregarAtras(nuevoRecordatorio);
    }

    @Override
    public String toString() {
        String resultado = fechaActual.toString() + "\n=====\n";
        for (int i = 0; i < listaRecordatorios.longitud(); i++){
            Recordatorio recordatorio = listaRecordatorios.obtener(i);
            if (recordatorio.fecha().equals(fechaActual)) {
                resultado = resultado + recordatorio.toString() + "\n";
            }
        }
        return resultado;
    }

    public void incrementarDia() {
        Fecha nuevaFecha = new Fecha(fechaActual);
        nuevaFecha.incrementarDia();
        fechaActual = nuevaFecha;
    }

    public Fecha fechaActual() {
        Fecha fecha = new Fecha(fechaActual);
        return fecha;
    }

}
