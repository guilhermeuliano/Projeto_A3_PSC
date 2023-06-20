import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String caminhoArquivo = "D:\\Downloads\\Java\\Numeros.txt";
        List<Long> numeros = lerNumerosArquivo(caminhoArquivo);

        if (numeros.isEmpty()) {
            System.out.println("Não foram encontrados números no arquivo.");
            return;
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("Escolha o método de Ordenação:\n1. InsertionSort\n2. QuickSort\n3. BubbleSort");
        int escolhaOrdenacao = scanner.nextInt();

        long[] arr = numeros.stream().mapToLong(Long::valueOf).toArray();

        switch (escolhaOrdenacao) {
            case 1:
                InsertionSort.sort(arr);
                break;
            case 2:
                QuickSort.sort(arr, 0, arr.length - 1);
                break;
            case 3:
                BubbleSort.sort(arr);
                break;
            default:
                System.out.println("Escolha inválida.");
                scanner.close();
                return;
        }

        System.out.println("Números ordenados:");
        for (long numero : arr) {
            System.out.println(numero);
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
                }
            }
        } catch (IOException e) {
            System.out.println("Não foi possível ler o arquivo!");
            e.printStackTrace();
        }

        return numeros;
    }
}
