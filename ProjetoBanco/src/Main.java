import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DecimalFormat formato = new DecimalFormat("###,###.00");

        System.out.println("""
                Dados Iniciais do cliente:
                
                """);
        String nome = "Marco Antonio";
        String tipoConta = "Corrente";
        double saldo = 3000.00;
        System.out.println("Nome:   " + nome);
        System.out.println("Tipo de conta:  " + tipoConta);
        System.out.println("Saldo:   " + "R$ " + formato.format(saldo));

        System.out.println("""
                
                ***********************************************
                
                """);

        int opcao;

        do {
            System.out.println("Escolha uma opção:");
            System.out.println("1. Visualizar saldo");
            System.out.println("2. Enviar valor");
            System.out.println("3. Receber valor");
            System.out.println("4. Encerrar");

            opcao = scanner.nextInt(); // Relê a opção aqui para continuar o loop

            switch (opcao) {
                case 1:
                    System.out.println("O saldo atual é: " + "R$ " + formato.format(saldo));
                    break;

                case 2:
                    System.out.println("Informe o valor a ser enviado: ");
                    double valorEnvio = scanner.nextDouble();
                    if (valorEnvio <= saldo) {
                        saldo -= valorEnvio;  // Deduzindo o valor enviado
                        System.out.println("Valor enviado: " + "R$: " + formato.format(valorEnvio));
                        System.out.println("Novo saldo: " + "R$: " + formato.format(saldo));
                    } else {
                        System.out.println("Saldo insuficiente para realizar a transferência.");
                    }
                    break;

                case 3:
                    System.out.println("Informe o valor a ser recebido: ");
                    double valorRecebido = scanner.nextDouble();
                     // Nessa parte eu tinha feito saldo += valorRecebido, porém eu comecei a testar para encontrar alguma falha e identifiquei que.
                    // Números negativos eram somados ao saldo, então decidi colocar dentro de uma estrutura de seleção para não acontecer esse erro.
                    if (valorRecebido <= 0) {
                        System.out.println("Valor inválido, tente novamente.");
                    } else {
                        saldo += valorRecebido;
                        System.out.println("Valor recebido: " + "R$ " + formato.format(valorRecebido));
                        System.out.println("Novo saldo: " + "R$: " + formato.format(saldo));
                    }
                    break;

                case 4:
                    System.out.println("Sistema encerrado.");
                    break;

                default:
                    System.out.println("Opção inválida.");
            }

        } while (opcao != 4); // O programa continuará pedindo uma nova opção até que o usuário escolha a opção 4 (encerrar)

        scanner.close();
    }
}