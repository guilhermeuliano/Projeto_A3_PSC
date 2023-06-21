public class PesquisaNumero {
    public static int pesquisarNumero(long[] numerosOrdenados, long numeroPesquisa) {
        int inicio = 0;
        int fim = numerosOrdenados.length - 1;

        while (inicio <= fim) {
            int meio = inicio + (fim - inicio) / 2;

            if (numerosOrdenados[meio] == numeroPesquisa) {
                return meio;
            }

            if (numerosOrdenados[meio] < numeroPesquisa) {
                inicio = meio + 1;
            } else {
                fim = meio - 1;
            }
        }

        return -1;
    }
}
