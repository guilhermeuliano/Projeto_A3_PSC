import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Aqui é o caminho do arquivo a ser lido pode ser usado "\\" ou "/" dependendo da IDE.
        String caminhoArquivo = "D:\\Downloads\\Java\\Numeros.txt";
        // Aqui é feito a leitura do arquivo .txt e salvo em uma variável
        List<Long> numeros = lerNumerosArquivo(caminhoArquivo);

        // Possíveis erros nesse if;
            // Se não tiver números
            // Se não for um arquivo que a IDE entenda como de leitura.
        if (numeros.isEmpty()) {
            System.out.println("Não foram encontrados números no arquivo.");
            return;
        }

        // Um Scanner básico só pra fazer a inserção da operação que o usuário escolher.
            // A escolha será salva na variável "escolhaOrdenacao".
        Scanner scanner = new Scanner(System.in);
        System.out.println("Escolha o método de Ordenação:\n1. InsertionSort\n2. QuickSort\n3. BubbleSort");
        int escolhaOrdenacao = scanner.nextInt();

        // Aqui vai ser feito a inicialização do Array;
        long[] arr = numeros.stream().mapToLong(Long::valueOf).toArray();

        // Uma estrutura de control para fazer a operação que o usuário escolheu.
        switch (escolhaOrdenacao) {
            case 1:
                InsertionSort.sort(arr);
                break;
            case 2:
                QuickSort.sort(arr, 0, arr.length - 1);
                break;
            case 3:
                BubbleSort.bubbleSort(arr);
                break;
            default:
                System.out.println("Escolha inválida.");
                scanner.close();
                return;
        }

        // Depois da operação de ordenação a variável numero é salva com os números ordenados e escrito na tela.
        System.out.println("Números ordenados:");
        for (long numero : arr) {
            System.out.println(numero);
        }

        // Após a variável salva o procedimento passa para o método de pesquisa que o usuário vai escolher.
            // A escolha será salva na variável "escolhaPesquisa".
        System.out.println("\nEscolha o método de Pesquisa:\n1. Pesquisa Linear\n2. Pesquisa Binária");
        int escolhaPesquisa = scanner.nextInt();

        switch (escolhaPesquisa) {
            case 1:
                System.out.println("Digite o número a ser pesquisado: ");
                long target = scanner.nextLong();
                int binaryResult = PesquisaBinaria.binarySearch(arr, target);
                if (binaryResult == -1) {
                    System.out.println("Número não encontrado!");
                } else {
                    System.out.println("Número encontrado na linha: " + (binaryResult + 1));
                }
                break;
            case 2:
                System.out.println("Digite o número a ser pesquisado: ");
                long target2 = scanner.nextLong();
                int linearResult = PesquisaLinear.linearSearch(arr, target2);
                if (linearResult == -1) {
                    System.out.println("Número não encontrado!");
                } else {
                    System.out.println("Número encontrado na linha: " + (linearResult + 1));
                }
                break;
            default:
                System.out.println("Escolha inválida.");
                break;
            }
        }

        private static List<Long> lerNumerosArquivo (String caminhoArquivo){
            List<Long> numeros = new ArrayList<>();

            try (BufferedReader br = new BufferedReader(new FileReader(caminhoArquivo))) {
                String linha;
                while ((linha = br.readLine()) != null) {
                    try {
                        long numero = Long.parseLong(linha);
                        numeros.add(numero);
                    } catch (NumberFormatException e) {
                        // Aqui ele vai ignorar as linhas que não são números.
                    }
                }
            } catch (IOException e) {
                System.out.println("Não foi possível ler o arquivo!");
                e.printStackTrace();
            }

            return numeros;
        }
    }