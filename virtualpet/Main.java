package Programacion.src.Proyecto.virtualpet;

public class Main {

    public static void main(String[] args) {

        System.out.println("================================");
        System.out.println("      MASCOTA VIRTUAL");
        System.out.println("================================");

        // --- 1. Triar tipus de mascota ---
        int opcioTipus;
        do {
            System.out.println("\nQuin tipus de mascota vols?");
            System.out.println("  1. Gos");
            System.out.println("  2. Gat");
            System.out.print("Opcio: ");
            opcioTipus = Teclat.llegirInt();
            if (opcioTipus != 1 && opcioTipus != 2) {
                System.out.println("Has de triar 1 o 2!");
            }
        } while (opcioTipus != 1 && opcioTipus != 2);

        String tipus = (opcioTipus == 1) ? "gos" : "gat";

        // --- 2. Demanar nom ---
        System.out.print("Quin nom li poses? ");
        String nom = Teclat.llegirString();

        // --- 3. Crear mascota del jugador + dummy per als atacs ---
        Mascota mascota = new Mascota(nom, tipus);
        Mascota dummy   = new Mascota();  // tots els atributs a 100

        System.out.println("\n" + nom + " ha nascut!");

        // --- 4. Bucle principal del joc ---
        boolean sortir = false;

        while (!sortir) {
            // Mostrar estadistiques abans de cada torn
            System.out.println();
            mascota.mostrarEstats();

            // Mostrar menu
            System.out.println("\n--- MENU ---");
            System.out.println("1. Dormir");
            System.out.println("2. Jugar");
            System.out.println("3. Menjar");
            System.out.println("4. Netejar");
            System.out.println("5. Atacar");
            System.out.println("0. Sortir");
            System.out.print("Opcio: ");
            int opcio = Teclat.llegirInt();

            switch (opcio) {
                case 1:
                    mascota.dormir();
                    System.out.println(nom + " ha dormit.");
                    break;

                case 2:
                    mascota.jugar();
                    System.out.println(nom + " ha jugat!");
                    break;

                case 3:
                    mascota.menjar();
                    System.out.println(nom + " ha menjat.");
                    break;

                case 4:
                    mascota.netejar();
                    System.out.println(nom + " s'ha netejat.");
                    break;

                case 5:
                    if (dummy.esMorta()) {
                        System.out.println("El dummy ja esta mort, no pots atacar!");
                        break;
                    }
                    System.out.print("Quantes vegades vols atacar? ");
                    int n = Teclat.llegirInt();
                    if (n <= 0) {
                        System.out.println("Has d'atacar almenys 1 vegada!");
                        break;
                    }
                    for (int i = 0; i < n; i++) {
                        mascota.rebreAtac();
                        dummy.rebreAtac();
                        if (mascota.esMorta()) {
                            break;
                        }
                        if (dummy.esMorta()) {
                            System.out.println("El dummy ha mort a l'atac " + (i + 1) + "!");
                            break;
                        }
                    }
                    if (!dummy.esMorta()) {
                        System.out.println("\nEstat del dummy despres de l'atac:");
                        dummy.mostrarEstats();
                    }
                    break;

                case 0:
                    sortir = true;
                    System.out.println("\nAdeu! Gracies per cuidar de " + nom + "!");
                    break;

                default:
                    System.out.println("Opcio no valida!");
                    break;
            }

            // --- 5. Comprovar si la mascota ha mort ---
            if (!sortir && mascota.esMorta()) {
                System.out.println("\n" + nom + " ha mort! El joc s'ha acabat.");
                mascota.mostrarEstats();
                sortir = true;
            }
        }
    }
}
