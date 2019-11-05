import java.util.Scanner;

public class JeuDePlateau {
    static String joueur; // Détermine le nom du joueur en fonction de son tour
    static String[][] tableau = { 
        { "1", "2", "3" }, 
        { "4", "5", "6" }, 
        { "7", "8", "9" } };
    static boolean tourJoueur = false;
    static boolean finDePartieD;
    static boolean finDePartieH;
    static boolean finDePartieV;
    static boolean finDePartieN;
    static int tourJoue = 1;
    static int choix;
    static boolean finDePartie = false;

    public static void Afficher() {
        String tableauVisuel = "|";

        for (int i = 0; i < tableau.length; i++) {
            for (int j = 0; j < tableau.length; j++) {
                tableauVisuel += tableau[i][j] + "|";
            }
            if (i != 2) {
                tableauVisuel += "\n|";
            }
        }

        System.out.println(tableauVisuel);

    }

    public static void main(String[] args) {
        Afficher();
        Scanner sc = new Scanner(System.in);
        jeu(sc);
    }
 /**
  * Verifie les jetons à l'horizontal
  */
    static boolean checkGagnantHorizontal() {
        
        boolean finDePartie = false;
        if (tableau[0][0].equals(joueur) && tableau[0][1].equals(joueur) && tableau[0][2].equals(joueur)) {
            System.out.println(joueur + " a gagné");
            finDePartie = true;
            return finDePartie;
        } else if (tableau[1][0].equals(joueur) && tableau[1][1].equals(joueur) && tableau[1][2].equals(joueur)) {
            System.out.println(joueur + " a gagné");
            finDePartie = true;
            return finDePartie;
        } else if (tableau[2][0].equals(joueur) && tableau[2][1].equals(joueur) && tableau[2][2].equals(joueur)) {
            System.out.println(joueur + " a gagné");
            finDePartie = true;
            return finDePartie;
        } else {
            return finDePartie;
        }
    }
/**
 * Verifie les jetons à la vertical
 */
    static boolean checkGagnantVertical() {
        boolean finDePartie = false;
        // test vertical
        if (tableau[0][0].equals(joueur) && tableau[1][0].equals(joueur) && tableau[2][0].equals(joueur)) {
            System.out.println(joueur + " a gagné");
            finDePartie = true;
            return finDePartie;
        } else if (tableau[0][1].equals(joueur) && tableau[1][1].equals(joueur) && tableau[2][1].equals(joueur)) {
            System.out.println(joueur + " a gagné");
            finDePartie = true;
            return finDePartie;
        } else if (tableau[0][2].equals(joueur) && tableau[1][2].equals(joueur) && tableau[2][2].equals(joueur)) {
            System.out.println(joueur + " a gagné");
            finDePartie = true;
            return finDePartie;
        } else {
            return finDePartie;
        }
    }
 /**
  * Verifie les jetons à la diagonale
  */
    static boolean checkGagnantDiagonal() {
        boolean finDePartie = false;
        // test diagonal
        if (tableau[0][0].equals(joueur) && tableau[1][1].equals(joueur) && tableau[2][2].equals(joueur)) {
            System.out.println(joueur + " a gagné");
            finDePartie = true;
            return finDePartie;
        } else if (tableau[2][0].equals(joueur) && tableau[1][1].equals(joueur) && tableau[0][2].equals(joueur)) {
            System.out.println(joueur + " a gagné");
            finDePartie = true;
            return finDePartie;

        } else {
            return finDePartie;
        }
    }
    /** 
     * Vérifie si la partie est nulle
     */
    static boolean checkNulle(int tourJoue) {
        boolean finDePartie = false;
        if (tourJoue>=9){
            System.out.println("~~~~~~~~\nPartie Nulle !\n~~~~~~~~");
            return finDePartie = true;
        }
        else{
            return finDePartie;
        }
        }
    static void jeu(Scanner sc) {
        while (finDePartieV == false && finDePartieH == false && finDePartieD == false && finDePartieN == false) {
            // change les valeurs du joueur en fonction du tour | X ou O |
            if (tourJoueur == false) {
                joueur = "X";
            } else if (tourJoueur == true) {
                joueur = "O";
            }
            System.out.println("Joueur '" + joueur + "' choisis ta case : ");
            choix = sc.nextInt() - 1;

            // le joueur garde la main tant que son coup n'a pas été "validé"
            if ((tableau[(int) (Math.floor(choix / 3))][((choix) % 3)]) != "X"
                    && (tableau[(int) (Math.floor(choix / 3))][((choix) % 3)]) != "O") {
                tableau[(int) (Math.floor(choix / 3))][((choix) % 3)] = joueur;
                tourJoueur = !tourJoueur;
            } else
                System.out.println(
                        "############################\nLa case est déjà prise, rejoues : \n############################");

            Afficher();
            finDePartieD = checkGagnantDiagonal();
            finDePartieH = checkGagnantHorizontal();
            finDePartieV = checkGagnantVertical();
            finDePartieN = checkNulle(tourJoue);
            tourJoue++;
        }    
    }
}
