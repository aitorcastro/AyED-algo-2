package aed;

public class Fecha {
    private int dia;
    private int mes;

    public Fecha(int dia, int mes) {
        this.dia = dia;
        this.mes = mes;
    }

    public Fecha(Fecha fecha) {
        this.dia = fecha.dia;
        this.mes = fecha.mes;
    }

    public Integer dia() {
        return dia;
    }

    public Integer mes() {
        return mes;
    }

    @Override
    public String toString() {
        String fechaString = dia + "/" + mes;
        return fechaString;
    }

    @Override
    public boolean equals(Object otra) {
        //chequeos
        boolean otraEsNull = (otra == null); //otra no es null
        boolean claseDistinta = otra.getClass() != this.getClass(); //otra no es de clase Fecha

        if (otraEsNull || claseDistinta) {
            return false;
        }

        Fecha otraFecha = (Fecha) otra; //como otra es object la convierto a fecha
        return dia == otraFecha.dia && mes == otraFecha.mes; //comparo si dia es igual a dia de otra y si mes es igual a mes de otra
    }

    public void incrementarDia() {
        if (dia < diasEnMes(mes)) {
            dia ++;
        }
        else {
            dia = 1;
            if (mes < 12) {
                mes ++;
            }
            else {
                mes = 1;
            }
        }
    }

    private int diasEnMes(int mes) {
        int dias[] = {
                // ene, feb, mar, abr, may, jun
                31, 28, 31, 30, 31, 30,
                // jul, ago, sep, oct, nov, dic
                31, 31, 30, 31, 30, 31
        };
        return dias[mes - 1];
    }

}
