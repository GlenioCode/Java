import java.util.Scanner;

public class CalculoMediaNEAD {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("===== CÁLCULO DE MÉDIA NEAD =====");
        System.out.println("Escolha uma opção:");
        System.out.println("1 - Calcular média final (MP)");
        System.out.println("2 - Saber quanto precisa tirar na unidade 3 (N3)");
        System.out.print("Opção: ");
        int opcao = scanner.nextInt();

        // Entrada comum: N1 e atividades (N2)
        System.out.print("Digite a nota da avaliação online (N1): ");
        double n1 = scanner.nextDouble();

        System.out.print("Quantas atividades você fez? ");
        int numAtividades = scanner.nextInt();

        double somaAtividades = 0;
        for (int i = 1; i <= numAtividades; i++) {
            System.out.print("Nota da atividade " + i + ": ");
            somaAtividades += scanner.nextDouble();
        }

        double n2 = (numAtividades > 0) ? (somaAtividades / numAtividades) : 0;

        if (opcao == 1) {
            // Modo 1: calcular a média final
            System.out.print("Digite a nota da avaliação presencial (N3): ");
            double n3 = scanner.nextDouble();

            double media = (2 * n1 + 3 * n2 + 4 * n3) / 9;
            System.out.printf("Sua média final (MP) é: %.2f\n", media);

            if (media >= 7) {
                System.out.println("Parabéns, você passou!");
            } else {
                System.out.println("Você não alcançou a média suficiente.");
            }

        } else if (opcao == 2) {
            // Modo 2: calcular quanto precisa tirar na N3
            final double mediaDesejada = 7.0;

            double somaParcial = 2 * n1 + 3 * n2;
            double n3Necessaria = (mediaDesejada * 9 - somaParcial) / 4;

            System.out.printf("Você precisa tirar pelo menos %.2f na avaliação presencial (N3) para passar com média 7.\n", n3Necessaria);

            if (n3Necessaria > 10) {
                System.out.println("Atenção: essa nota é maior que 10, portanto não é possível atingir média 7 com essas notas.");
            } else if (n3Necessaria < 0) {
                System.out.println("Você já garantiu média 7 mesmo sem fazer a prova presencial.");
            }
        } else {
            System.out.println("Opção inválida.");
        }

        scanner.close();
    }
}
