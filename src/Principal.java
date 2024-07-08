import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner scanf = new Scanner(System.in);
        System.out.println("\tTRABALHO POLITICAS DE SELECAO\t");
        System.out.println("Marielly Deise Rodrigues Tiago");
        System.out.println("--------------------------------------------------------------------------");

        System.out.println("Insira a quantidade de KB:");
        int quant_KB = scanf.nextInt();
        scanf.nextLine(); // Consumir a nova linha

        Memoria memoria = new Memoria(quant_KB);

        System.out.println("Digite a instrucao 1 (para primeiro ajuste) \ninstrucao M (para melhor ajuste) \ninstrucao P (para pior ajuste)");
        char instrucao = scanf.next().charAt(0);

        switch (instrucao) {
            case '1':
                System.out.println("Primeiro ajuste selecionado.");
                break;
            case 'M':
                System.out.println("Melhor ajuste selecionado.");
                break;
            case 'P':
                System.out.println("Pior ajuste selecionado.");
                break;
            default:
                System.out.println("Erro: opcao inexistente");
                return; // Sai do programa se a instrução for inválida
        }

        char opcoes;
        do {
            System.out.println("Insira \nI (para inserir) \nL (para liberar) \nX (para sair)");
            opcoes = scanf.next().charAt(0);

            if (opcoes == 'I') {
                System.out.println("Digite a quantidade de KB:");
                int tamanho = scanf.nextInt();
                Instrucoes objeto = new Instrucoes(tamanho);
                boolean alocado = false;

                switch (instrucao) {
                    case '1':
                        alocado = memoria.alocarPrimeiroAjuste(objeto);
                        break;
                    case 'M':
                        alocado = memoria.alocarMelhorAjuste(objeto);
                        break;
                    case 'P':
                        alocado = memoria.alocarPiorAjuste(objeto);
                        break;
                }

                if (!alocado) {
                    System.out.println("Não foi possível alocar o objeto.");
                }
            } else if (opcoes == 'L') {
                System.out.println("Digite a quantidade de KB do objeto a ser liberado:");
                int tamanho = scanf.nextInt();
                boolean desalocado = memoria.desalocarPorTamanho(tamanho);
                if (!desalocado) {
                    System.out.println("Não foi possível desalocar o objeto.");
                }
            } else if (opcoes == 'X') {
                System.out.println("Saindo...");
            } else {
                System.out.println("Opcao inexistente");
            }

            System.out.println("Memória Atual:");
            memoria.mostrarMemoria();
            System.out.println("--------------------------------------------------------------------------");

        } while (opcoes != 'X');
    }
}