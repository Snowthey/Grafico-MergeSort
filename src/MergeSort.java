public class MergeSort {
    public int mergeSort(int[] arr) {
        int n = arr.length;
        int[] temp = new int[n];
        int operacoes = 0;

        for(int tamanho = 1; tamanho < n; tamanho *= 2) {
            for (int inicioEsquerda = 0; inicioEsquerda < n - 1; inicioEsquerda += 2 * tamanho){
                int meio = Math.min(inicioEsquerda + tamanho - 1, n - 1);
                int fimDireita = Math.min(inicioEsquerda + 2 * tamanho, n - 1);

                operacoes += merge(arr, temp, inicioEsquerda, meio, fimDireita);
            }
        }

        return operacoes;
    }


    public static int merge(int[] arr, int[] temp, int inicioEsquerda, int meio, int fimDireita){
        int fimEsquerda = meio;
        int inicioDireita = meio + 1;
        int tamanho = fimDireita - inicioEsquerda + 1;
        int operacoes = 0;

        int esquerda = inicioEsquerda;
        int direita = inicioDireita;
        int indice = inicioEsquerda;

        while(esquerda <= fimDireita && direita <= fimDireita){
            if(arr[esquerda] <= arr[direita]){
                temp[indice++] = arr[esquerda++];
            } else{
                temp[indice++] = arr[direita++];
            }
            operacoes++;
        }

        while(esquerda <= fimDireita){
            temp[indice++] = arr[esquerda++];
            operacoes++;
        }

        while(direita <= fimDireita){
            temp[indice++] = arr[direita++];
            operacoes++;
        }

        System.arraycopy(temp, inicioEsquerda, arr, inicioDireita, tamanho);
        operacoes += tamanho;
        return operacoes;
    }
}
