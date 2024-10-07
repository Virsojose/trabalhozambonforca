import java.util.Scanner;

public class ContaBar {

    public static void maimn(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // leitura dos dados do cliente
        System.out.print("Sexo (F ou M): ");
        char sexo = scanner.next().charAt(0);
        System.out.print("Quantidade de cervejas: ");
        int qtdCervejas = scanner.nextInt();
        System.out.print("Quantidade de refrigerantes: ");
        int qtdRefrigerantes = scanner.nextInt();
        System.out.print("Quantidade de espetinhos: ");
        int qtdEspetinhos = scanner.nextInt();

        // calculo dos valores
        double valorCerveja = qtdCervejas * 5.0;
        double valorRefrigerante = qtdRefrigerantes * 3.0;
        double valorEspetinho = qtdEspetinhos * 7.0;
        double consumo = valorCerveja + valorRefrigerante + valorEspetinho;

        // calculo do ingresso
        double ingresso = (sexo == 'M') ? 10.0 : 8.0;

        // calculo do couvert
        double couvert = (consumo > 30) ? 0 : 4;

        // calculo total a pagar
        double valorTotal = consumo + ingresso + couvert;

        // exibindo o relatório
        System.out.println("RELATÓRIO:");
        System.out.printf("Consumo = R$ %.2f\n", consumo);
        if (couvert == 0) {
            System.out.println("Isento de Couvert");
        } else {
            System.out.printf("Couvert = R$ %.2f\n", couvert);
        }
        System.out.printf("Ingresso = R$ %.2f\n", ingresso);
        System.out.printf("Valor a pagar = R$ %.2f\n", valorTotal);

        scanner.close();
    }
}
