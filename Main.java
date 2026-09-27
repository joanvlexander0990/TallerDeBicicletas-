public class Main {
    public static void main(String[] args) {
        GestorTallerBicicletas gestor = new GestorTallerBicicletas();

        try {
            // Instanciación según datos requeridos
            BicicletaElectrica e1 = new BicicletaElectrica(
                    "BIC-E01", 2023, 22.5, 60.0, false
            );

            BicicletaElectrica e2 = new BicicletaElectrica(
                    "BIC-E02", 2022, 24.0, 45.0, true
            );

            BicicletaMontana m1 = new BicicletaMontana(
                    "BIC-M01", 2021, 13.5, 2
            );

            BicicletaMontana m2 = new BicicletaMontana(
                    "BIC-M02", 2020, 12.0, 1
            );

            // Activar garantía extendida para BIC-E01
            e1.activarGarantiaExtendida();

            // Registro en el gestor
            gestor.registrarBicicleta(e1);
            gestor.registrarBicicleta(e2);
            gestor.registrarBicicleta(m1);
            gestor.registrarBicicleta(m2);

            System.out.println("\n=== BUSQUEDA POR CODIGO: \"BIC-E01\" ===");

            Bicicleta buscada = gestor.buscarPorCodigo("BIC-E01");

            if (buscada != null) {
                mostrarDetalleBusqueda(buscada);
            }

            System.out.println("---");

            System.out.println("\n=== LISTADO DE BICICLETAS ===");

            for (Bicicleta b : gestor.getBicicletas()) {
                System.out.println(b.toString());
            }

        } catch (IllegalArgumentException e) {
            System.err.println("Error de validación: " + e.getMessage());

        } catch (Exception e) {
            System.err.println("Ocurrió un error inesperado: " + e.getMessage());
        }
    }

    private static void mostrarDetalleBusqueda(Bicicleta b) {
        String tipo = b instanceof BicicletaElectrica
                ? "Bicicleta Eléctrica"
                : "Bicicleta de Montaña";

        StringBuilder sb = new StringBuilder();

        sb.append("Tipo: ").append(tipo)
                .append(" | Código: ").append(b.getCodigo())
                .append(" | Año: ").append(b.getAnioFabricacion())
                .append(" | Peso: ").append(b.getPeso()).append(" kg");

        if (b instanceof BicicletaElectrica) {
            BicicletaElectrica be = (BicicletaElectrica) b;

            sb.append(" | Autonomia: ").append((int) be.getAutonomia()).append(" km")
                    .append(" | Batería certificada: ")
                    .append(be.isBateriaCertificada() ? "Si" : "No")
                    .append("\n Garantia extendida: ")
                    .append(be.tieneGarantiaExtendida() ? "Si" : "No");
        }

        sb.append(" | Costo mantención: $")
                .append((long) b.calcularCostoMantencion());

        System.out.println(sb.toString());
    }
}
