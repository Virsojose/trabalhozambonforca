
import java.util.ArrayList;
import java.util.Scanner;

public class JogoDaForca {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String palavraSecreta = "PROFESSOR";
        String tema = "Linguagens de Programação";
        int tentativasMaximas = 6;

        ArrayList<Character> letrasUsadas = new ArrayList<>();
        int tentativasFeitas = 0;
        char[] palavraOculta = new char[palavraSecreta.length()];
        for (int i = 0; i < palavraOculta.length; i++) {
            palavraOculta[i] = '_';
        }

        System.out.println("Tema: " + tema);
        while (tentativasFeitas < tentativasMaximas && String.valueOf(palavraOculta).contains("_")) {
            System.out.println("\nPalavra: " + String.valueOf(palavraOculta));
            System.out.println("Letras usadas: " + letrasUsadas);
            System.out.println("Tentativas restantes: " + (tentativasMaximas - tentativasFeitas));
            System.out.print("Digite uma letra: ");
            char letra = scanner.nextLine().toUpperCase().charAt(0);


            if (letrasUsadas.contains(letra)) {
                System.out.println("Você já usou essa letra. Tente outra!");
                continue;
            }

            letrasUsadas.add(letra);
            boolean acertou = false;


            for (int i = 0; i < palavraSecreta.length(); i++) {
                if (palavraSecreta.charAt(i) == letra) {
                    palavraOculta[i] = letra;
                    acertou = true;
                }
            }

            if (!acertou) {
                tentativasFeitas++;
                desenharForca(tentativasFeitas);
            }
        }


        if (!String.valueOf(palavraOculta).contains("_")) {
            System.out.println("\nParabéns! Você acertou a palavra: " + palavraSecreta);
        } else {
            System.out.println("\nVocê foi enforcado! A palavra era: " + palavraSecreta);
        }

        scanner.close();
    }

  
    public static void desenharForca(int erros) {
        System.out.println("\n+-------+");
        switch (erros) {
            case 1 -> {
                System.out.println("|       O ");
                System.out.println("|");
                System.out.println("|");
                System.out.println("|");
            }
            case 2 -> {
                System.out.println("|       O ");
                System.out.println("|       | ");
                System.out.println("|");
                System.out.println("|");
            }
            case 3 -> {
                System.out.println("|       O ");
                System.out.println("|      /| ");
                System.out.println("|");
                System.out.println("|");
            }
            case 4 -> {
                System.out.println("|       O ");
                System.out.println("|      /|\ ");
                System.out.println("|");
                System.out.println("|");
            }
            case 5 -> {
                System.out.println("|       O ");
                System.out.println("|      /|\ ");
                System.out.println("|      / ");
                System.out.println("|");
            }
            case 6 -> {
                System.out.println("|       O ");
                System.out.println("|      /|\ ");
                System.out.println("|      / \\");
                System.out.println("|");
            }
        }
        System.out.println("+-------+");
    }
}
