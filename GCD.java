public class GCD {
    static int EuclideanGDC(int a, int b) {
        if(a < 0 || b < 0 ) throw new IllegalArgumentException("Only positive numbers!");
        if(b == 0) return a;

        int remainder = a % b;
        return EuclideanGDC(b,remainder);

    }
    public static void main(String [] args) {
        System.out.println(EuclideanGDC(28851538,1183019));

    }
}
