import java.util.*;
import java.io.*;

public class MaxPairwiseProduct {
    static long getMaxPairwiseProductFast(long[] numbers) {
        int index1 = 0;
        if(numbers.length == 0)
            return 0;
        if(numbers.length == 1)
            return numbers[0];

        for(int i = 1; i < numbers.length; i++) {
            if(numbers[i] > numbers[index1])
                index1 = i;
        }

        int index2;
        if(index1 == 0)
            index2 = 1;
        else
            index2 = 0;

        for(int i = 0; i < numbers.length; i++) {
            if(i != index1 && numbers[i] > numbers[index2])
                index2 = i;
        }
        return numbers[index1] * numbers[index2];
    }
    static long getMaxPairwiseProduct3(long[] numbers) {
        int n = numbers.length;
        if(numbers.length == 0)
            return 0;
        if(numbers.length == 1)
            return numbers[0];

        int max1, max2;
        if(numbers[1] > numbers[0]) {
            max1 = 1;
            max2 = 0;
        }else {
            max2 = 1;
            max1 = 0;
        }

        for(int i = 2; i < n; i++) {
            if(numbers[i] > numbers[max1]){
                max2 = max1;
                max1 = i;
            }
            else if(numbers[i] > numbers[max2])
                max2 = i;
        }
        return numbers[max1] * numbers[max2];

    }

    static long getMaxPairwiseProduct(long[] numbers) {
        long product = 0;
        int n = numbers.length;
        if(numbers.length == 0)
            return 0;
        if(n == 1)
            return numbers[0];

        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                product = Math.max(product, numbers[i] * numbers[j]);
            }
        }
        return product;
    }

    public static void main(String [] args){
        FastScanner scanner = new FastScanner(System.in);
        StressTest();
        int n = scanner.nextInt();
        long [] numbers = new long[n];
        for (int i = 0; i < n; i++){
            numbers[i] = scanner.nextInt();
        }
        System.out.println(getMaxPairwiseProduct(numbers));

    }


    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream) {
            try {
                br = new BufferedReader(new InputStreamReader(stream));
            }catch (Exception e) {
                e.printStackTrace();
            }
        }
        String next() {
            while (st == null || !st.hasMoreTokens()){
                try{
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }

    public static void StressTest(){
        while(true) {
            int n =(int) (Math.random() * 100);
            System.out.println(n);
            long array[] = new long[n];
            for(int i = 0; i < array.length; i++)
                array[i] = (int) ( (Math.random() * 20000));
            for(long element : array) {
                System.out.print(element + " ");
            }
            long result1= getMaxPairwiseProduct(array);
            long result2 = getMaxPairwiseProductFast(array);

            if(result1 == result2)
                System.out.println("OK");
            else {
                System.out.println("Wrong answer " + result1 + "\n" + result2);
                return;
            }
        }

    }
}
