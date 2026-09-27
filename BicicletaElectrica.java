public class BicicletaElectrica extends Bicicleta implements ConGarantiaExtendida {
    private double autonomia;
    private boolean bateriaCertificada;
    private boolean garantiaExtendidaActiva;

    public BicicletaElectrica(String codigo, int anioFabricacion, double peso,
                              double autonomia, boolean bateriaCertificada) {
        super(codigo, anioFabricacion, peso);
        setAutonomia(autonomia);
        setBateriaCertificada(bateriaCertificada);
        this.garantiaExtendidaActiva = false;
    }

    public double getAutonomia() {
        return autonomia;
    }

    public void setAutonomia(double autonomia) {
        if (autonomia <= 0) {
            throw new IllegalArgumentException(
                    "La autonomía debe ser mayor a 0 km."
            );
        }
        this.autonomia = autonomia;
    }

    public boolean isBateriaCertificada() {
        return bateriaCertificada;
    }

    public void setBateriaCertificada(boolean bateriaCertificada) {
        this.bateriaCertificada = bateriaCertificada;
    }

    @Override
    public double calcularCostoMantencion() {
        double costoBase = 45000.0;

        if (!bateriaCertificada) {
            costoBase += costoBase * 0.25;
        }

        return costoBase;
    }

    @Override
    public boolean tieneGarantiaExtendida() {
        return garantiaExtendidaActiva;
    }

    @Override
    public void activarGarantiaExtendida() {
        this.garantiaExtendidaActiva = true;
    }
}
