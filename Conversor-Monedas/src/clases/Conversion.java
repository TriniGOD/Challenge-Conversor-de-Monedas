package clases;

public record Conversion(String base_code, String target_code, double conversion_rate) {
    private static double monto;

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    @Override
    public  String toString() {
        return monto+"["+base_code+"] equivale a "+String.valueOf(conversion_rate*monto)+"["+target_code+"] \n" ;
    }
}
