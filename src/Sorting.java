import java.util.Random;

public class Sorting {


    public static void main(String[] args) {
        long startTime = System.nanoTime();

       int [] matrix =  fillMatrix();
        printMatrix(matrix);

        int [] newMatrix = selectionSort(matrix);
        printMatrix(newMatrix);
        long endTime = System.nanoTime();
        System.out.println("time: " + (endTime - startTime));

        matrix  = fillMatrix();
        printMatrix(matrix);
        int [] quickMatrix = quickSort(0, matrix.length-1, matrix);
        printMatrix(quickMatrix);
        long quickEndTime = System.nanoTime();
        System.out.println("time: " + (quickEndTime - startTime));


    }
       /* quick sort */
       private static int [] quickSort(int start, int stopp, int [] matrix) {
           if (start < stopp) {
               int i = start; //0 bei dem ersten Durchlauf
               int j = stopp; //matrix.lenght-2 beim ersten Durchlauf
               int pivot = matrix[matrix.length - 1];
               while (i <= j) {
                   while (matrix[i] < pivot) {
                       i++;
                   }
                   int temp = matrix[i];
                   while (matrix[j] > pivot & j >0) {
                       j--;
                   }
                   matrix[i] = matrix[j];
                   matrix[j] = temp;
                   i++;
                   j--;
               }
               System.out.println(i);
               int temp = matrix[i];
               matrix[i] = pivot;
               matrix[matrix.length - 1] = temp;

               quickSort(0, i-1, matrix);
               quickSort(i+1, matrix.length-2, matrix);
           }
           return matrix;
       }

        //selection sort
        private static int[] selectionSort (int[] matrix) {
            for (int i = 0; i < matrix.length; i++) {
                int smallsub = i;
                for (int j = i + 1; j < matrix.length; j++) {
                    if (matrix[j] < matrix[smallsub]) {
                        smallsub = j;
                    }
                }
                int temp = matrix[i];
                matrix[i] = matrix[smallsub];
                matrix[smallsub] = temp;
            }
            return matrix;
        }




    private static void printMatrix(int[] matrix){
        for (int i : matrix) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    private static int[] fillMatrix(){
        int[] matrix = new int[10];
        //fill the matrix
        for (int i = 0; i < matrix.length; i++) {
            // Values are smaller 100 (= bound)
            int numbern = new Random().nextInt(100);
            matrix[i] = numbern;
        }
        return matrix;
    }
}
