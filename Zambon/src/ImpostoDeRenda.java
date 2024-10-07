import java.util.Scanner;

public class ImpostoDeRenda {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // leitura das rendas e gastos
        System.out.print("Renda anual com salário: ");
        double rendaSalario = scanner.nextDouble();
        System.out.print("Renda anual com prestação de serviço: ");
        double rendaServicos = scanner.nextDouble();
        System.out.print("Renda anual com ganho de capital: ");
        double rendaGanhoCapital = scanner.nextDouble();
        System.out.print("Gastos médicos: ");
        double gastosMedicos = scanner.nextDouble();
        System.out.print("Gastos educacionais: ");
        double gastosEducacionais = scanner.nextDouble();

        // calculo do imposto sobre o salário
        double salarioMensal = rendaSalario / 12;
        double impostoSalario = calcularImpostoSalario(salarioMensal);

        // calculo do imposto sobre prestação de serviços
        double impostoServicos = rendaServicos * 0.15;

        // calculo do imposto sobre ganho de capital
        double impostoGanhoCapital = rendaGanhoCapital * 0.20;

        // calculo do imposto bruto total
        double impostoBrutoTotal = impostoSalario + impostoServicos + impostoGanhoCapital;

        // calculo do máximo dedutível
        double maximoDedutivel = impostoBrutoTotal * 0.30;
        double gastosDedutiveis = Math.min(gastosMedicos + gastosEducacionais, maximoDedutivel);

        // calculo do imposto devido
        double impostoDevido = impostoBrutoTotal - gastosDedutiveis;

        // exibindo o relatório
        System.out.println("### RELATÓRIO DE IMPOSTO DE RENDA ###");
        System.out.println("* CONSOLIDADO DE RENDA:");
        System.out.printf("Imposto sobre salário: %.2f\n", impostoSalario);
        System.out.printf("Imposto sobre serviços: %.2f\n", impostoServicos);
        System.out.printf("Imposto sobre ganho de capital: %.2f\n", impostoGanhoCapital);
        System.out.println("* DEDUÇÕES:");
        System.out.printf("Máximo dedutível: %.2f\n", maximoDedutivel);
        System.out.printf("Gastos dedutíveis: %.2f\n", gastosDedutiveis);
        System.out.println("* RESUMO:");
        System.out.printf("Imposto bruto total: %.2f\n", impostoBrutoTotal);
        System.out.printf("Abatimento: %.2f\n", gastosDedutiveis);
        System.out.printf("Imposto devido: %.2f\n", impostoDevido);

        scanner.close();
    }

    // método para calcular imposto sobre salário
    private static double calcularImpostoSalario(double salarioMensal) {
        if (salarioMensal < 3000) {
            return 0;
        } else if (salarioMensal < 5000) {
            return salarioMensal * 0.10 * 12; // imposto de 10% sobre 12 meses
        } else {
            return salarioMensal * 0.20 * 12; // imposto de 20% sobre 12 meses
        }
    }
}
