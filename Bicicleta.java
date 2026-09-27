/*
 * COMENTARIOS TEÓRICOS EVALUADOS EN LA PAUTA (IE 1.1.1 e IE 1.1.2):
 *
 * 1. Diferencia de Tipado y Detección Temprana de Errores:
 *    Java utiliza un tipado estático y fuerte a diferencia de lenguajes de tipado dinámico
 *    como Python o JavaScript. Esto permite que el compilador detecte errores de tipo
 *    e incompatibilidades en tiempo de compilación (antes de ejecutar la aplicación),
 *    minimizando errores graves en tiempo de ejecución.
 *
 * 2. Estructura y Ciclo de Ejecución:
 *    Java es un lenguaje orientado a objetos basado en clases compiladas a Bytecode
 *    que se ejecuta sobre la Máquina Virtual de Java (JVM). Lenguajes como C++ compilan
 *    directamente a código máquina, mientras que lenguajes como Python ejecutan mediante
 *    un intérprete línea por línea sin un paso de compilación previa explícito.
 */

public abstract class Bicicleta {
    private String codigo;
    private int anioFabricacion;
    private double peso;

    public Bicicleta(String codigo, int anioFabricacion, double peso) {
        // Delegación de asignación a setters para aplicar validaciones
        setCodigo(codigo);
        setAnioFabricacion(anioFabricacion);
        setPeso(peso);
    }

    // Sobrecarga de método (IE 1.2.3)
    public void actualizarDatos(double nuevoPeso) {
        setPeso(nuevoPeso);
    }

    public void actualizarDatos(int nuevoAnio, double nuevoPeso) {
        setAnioFabricacion(nuevoAnio);
        setPeso(nuevoPeso);
    }

    // Método abstracto que fuerza la implementación especializada
    public abstract double calcularCostoMantencion();

    // Getters y Setters con validaciones
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        if (codigo == null || codigo.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "El código de la bicicleta no puede ser nulo ni vacío."
            );
        }
        this.codigo = codigo;
    }

    public int getAnioFabricacion() {
        return anioFabricacion;
    }

    public void setAnioFabricacion(int anioFabricacion) {
        if (anioFabricacion < 2000 || anioFabricacion > 2026) {
            throw new IllegalArgumentException(
                    "El año de fabricación debe estar entre 2000 y 2026."
            );
        }
        this.anioFabricacion = anioFabricacion;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        if (peso <= 0) {
            throw new IllegalArgumentException(
                    "El peso debe ser mayor que cero."
            );
        }
        this.peso = peso;
    }

    @Override
    public String toString() {
        return "Código: " + codigo + " | Año: " + anioFabricacion;
    }
}