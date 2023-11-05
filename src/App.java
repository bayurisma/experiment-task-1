import java.util.Random;
import program.Peeksort;
import program.RadixSort;

public class App {

    public static int[] generateSortedData(int n) {
        int[] data = new int[n];
        for (int i = 0; i < n; i++) {
            data[i] = i;
        }
        return data;
    }

    public static int[] generateRandomData(int n) {
        int[] data = new int[n];
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            data[i] = random.nextInt(n); // Ubah nilai maksimum sesuai kebutuhan Anda
        }
        return data;
    }

    public static int[] generateReversedData(int n) {
        int[] data = new int[n];
        for (int i = 0; i < n; i++) {
            data[i] = n - i - 1;
        }
        return data;
    }
    public static void main(String[] args) throws Exception {
        int[] sizes = {1000, 10000, 100000};
        RadixSort rs = new RadixSort();
        Peeksort ps = new Peeksort();

        for (int n : sizes) {
            int[] sortedData = generateSortedData(n);
            int[] randomData = generateRandomData(n);
            int[] reversedData = generateReversedData(n);

            if (n == 1000) {
                System.out.println("Small Dataset");
            } else if(n == 10000) {
                System.out.println("Medium Dataset");
            } else if(n == 100000) {
                System.out.println("Big Dataset");
            }

            for (int i=0; i<2; i++) {
                if (i == 0) {
                    long start1 = System.nanoTime();
                    ps.peeksort(sortedData, 0, sortedData.length-1);
                    long finish1 = System.nanoTime();
                    System.out.println("Time to sort sortedData with PeekSort: " + (finish1 - start1) + " nanosecond");

                    long start2 = System.nanoTime();
                    ps.peeksort(randomData, 0, randomData.length-1);
                    long finish2 = System.nanoTime();
                    System.out.println("Time to sort randomData with PeekSort: " + (finish2 - start2) + " nanosecond");

                    long start3 = System.nanoTime();
                    ps.peeksort(reversedData, 0, reversedData.length-1);
                    long finish3 = System.nanoTime();
                    System.out.println("Time to sort reversedData with PeekSort: " + (finish3 - start3) + " nanosecond");
                } else {
                    long start1 = System.nanoTime();
                    rs.radixSort(sortedData, sortedData.length);
                    long finish1 = System.nanoTime();
                    System.out.println("Time to sort sortedData with RadixSort: " + (finish1 - start1) + " nanosecond");

                    long start2 = System.nanoTime();
                    rs.radixSort(randomData, randomData.length);
                    long finish2 = System.nanoTime();
                    System.out.println("Time to sort randomData with RadixSort: " + (finish2 - start2) + " nanosecond");

                    long start3 = System.nanoTime();
                    rs.radixSort(reversedData, reversedData.length);
                    long finish3 = System.nanoTime();
                    System.out.println("Time to sort reversedData with RadixSort: " + (finish3 - start3) + " nanosecond");
                }
            }
        }

    }
}
