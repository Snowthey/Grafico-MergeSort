import java.util.Random;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class Principal {

   public static void main(String[] args) {
       MergeSort objOrdenacao = new MergeSort();
       Grafico objGrafico;

       XYSeries series = new XYSeries("Complexidade Algoritmo Merge Sort");

       for(int tamanho = 100; tamanho < 1000; tamanho = tamanho + 100){
           int vetor[] = new int[tamanho];

           for(int i = 0; i < tamanho; i++){
               vetor[i] = i;
           }

           int quantidade = objOrdenacao.mergeSort(vetor);

           series.add(tamanho, quantidade);
           System.out.println("Quantidade de buscas" + quantidade);
       }

       objGrafico = new Grafico(series);
       System.out.println("Grafico gerado com sucesso!");

   }
}
