public class FibonacciCalculator {

    public static Long getFibonacciNumber(Long index){
        if (index < 1) throw new IllegalArgumentException("Index need to be greater or = 1");
        if (index == 1 || index == 2){
            return 1L;
        }
        return getFibonacciNumber(index - 1) + getFibonacciNumber(index - 2);
    }
}
