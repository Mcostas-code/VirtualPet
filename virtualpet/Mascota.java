package Programacion.src.Proyecto.virtualpet;

import java.util.Random;

public class Mascota {

    // --- Atributs ---
    private String nom;
    private String tipus;   // "gos", "gat" o "dummy"
    private int energia;
    private int higiene;
    private int pes;
    private int humor;

    // Constructor per a mascota normal (gos / gat)
    // Cada atribut s'inicialitza amb un valor aleatori entre 40 i 60
    public Mascota(String nom, String tipus) {
        this.nom   = nom;
        this.tipus = tipus;
        Random rand = new Random();
        this.energia = rand.nextInt(21) + 40;  // 40..60
        this.higiene = rand.nextInt(21) + 40;
        this.pes     = rand.nextInt(21) + 40;
        this.humor   = rand.nextInt(21) + 40;
    }

    // Constructor per al dummy: tots els atributs a 100
    public Mascota() {
        this.nom     = "Dummy";
        this.tipus   = "dummy";
        this.energia = 100;
        this.higiene = 100;
        this.pes     = 100;
        this.humor   = 100;
    }

    // --- Comprovacio de mort ---
    // La mascota mor si qualsevol atribut arriba a 0 (o menys) o supera 100
    public boolean esMorta() {
        return energia <= 0 || higiene <= 0 || pes <= 0 || humor <= 0
            || energia > 100 || higiene > 100 || pes > 100 || humor > 100;
    }

    // --- Accions ---

    // 1. Dormir: gos energia+25, gat energia+20; humor+10
    public void dormir() {
        if (tipus.equals("gos")) {
            energia += 25;
        } else if (tipus.equals("gat")) {
            energia += 20;
        }
        humor += 10;
    }

    // 2. Jugar: energia-20, humor+20, pes-10
    public void jugar() {
        energia -= 20;
        humor   += 20;
        pes     -= 10;
    }

    // 3. Menjar: energia+10, higiene-15, pes+10
    public void menjar() {
        energia += 10;
        higiene -= 15;
        pes     += 10;
    }

    // 4. Netejar: diferent segons gos o gat
    public void netejar() {
        if (tipus.equals("gos")) {
            energia -= 10;
            higiene += 25;
            humor   -= 15;
        } else if (tipus.equals("gat")) {
            energia -= 5;
            higiene += 25;
            humor   += 5;
        }
    }

    // 5. Rebre un impacte d'atac: -3 a energia, higiene i humor
    public void rebreAtac() {
        energia -= 3;
        higiene -= 3;
        humor   -= 3;
    }

    // --- Mostrar estadistiques ---
    public void mostrarEstats() {
        System.out.println("================================");
        System.out.println("  " + nom + " (" + tipus + ")");
        System.out.println("  Energia: " + energia);
        System.out.println("  Higiene: " + higiene);
        System.out.println("  Pes:     " + pes);
        System.out.println("  Humor:   " + humor);
        System.out.println("================================");
    }

    // --- Getters ---
    public String getNom()   { return nom; }
    public String getTipus() { return tipus; }
}
