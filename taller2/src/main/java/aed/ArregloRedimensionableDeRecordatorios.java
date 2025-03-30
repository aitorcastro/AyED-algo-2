package aed;

class ArregloRedimensionableDeRecordatorios {
    private Recordatorio[] arreglo;
    private int longitud;

    public ArregloRedimensionableDeRecordatorios() {
        this.arreglo = new Recordatorio[0];
        this.longitud = 0;
    }

    public int longitud() {
        return this.longitud;
    }

    public void agregarAtras(Recordatorio i) {
        // si el arreglo esta lleno redimensionar
        if (this.longitud == this.arreglo.length) {
            // creo unarreglo nuevo mas grande
            int nuevaLength = this.arreglo.length + 1;
            Recordatorio[] nuevoArreglo = new Recordatorio[nuevaLength];

            // copio todo al nuevo arreglo
            for (int j = 0; j < this.arreglo.length; j++) {
                nuevoArreglo[j] = new Recordatorio(
                    this.arreglo[j].mensaje(),
                     this.arreglo[j].fecha(),
                     this.arreglo[j].horario()
                     );
            }

            // reemplazo el arreglo viejo por el nuevo
            this.arreglo = nuevoArreglo;
        }

        // Agrego el nuevo elemento
        this.arreglo[this.longitud] = new Recordatorio(
            i.mensaje(),
            i.fecha(),
            i.horario()
        );
        this.longitud++;
    }

    public Recordatorio obtener(int i) {
        Recordatorio nuevoRecordatorio = new Recordatorio(
            this.arreglo[i].mensaje(),
            this.arreglo[i].fecha(),
            this.arreglo[i].horario()
        );
        return nuevoRecordatorio;
    }

    public void quitarAtras() {
        this.arreglo[this.longitud - 1] = null;
        this.longitud--;
    }

    public void modificarPosicion(int indice, Recordatorio valor) {
        this.arreglo[indice] = new Recordatorio(
            valor.mensaje(),
            valor.fecha(),
            valor.horario()
        );
    }
    // //opcion 1
    // public ArregloRedimensionableDeRecordatorios(ArregloRedimensionableDeRecordatorios vector) {
    //     arreglo = vector.arreglo.clone();
    //     longitud = vector.longitud;
    // }

    //opcion2
    public ArregloRedimensionableDeRecordatorios(ArregloRedimensionableDeRecordatorios vector) {
        //copio la longitud
        longitud = vector.longitud;
        //creo un nuevo arreglo con la misma capacidad que vector
        arreglo = new Recordatorio[vector.arreglo.length];

        //copio cada elemento
        for (int i = 0; i < vector.longitud; i++){
            //guardo en "original" el recordatorio actual que estoy indexando de vector
            Recordatorio original = vector.arreglo[i];
            //copio el recordatorio i de vector a rreglo
            arreglo[i] = new Recordatorio(
                original.mensaje(),
                original.fecha(),
                original.horario()
            );
        }
    }

    public ArregloRedimensionableDeRecordatorios copiar() {
        ArregloRedimensionableDeRecordatorios copia = new ArregloRedimensionableDeRecordatorios(this);
        return copia;
    }
}
