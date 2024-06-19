public class FibonacciController {

    //private static FibonacciService service;
    private static FibonacciRepository repository = new FibonacciRepository();

    public static Long getOriginalValue(Long originalValue) {
        return repository.getOriginalValue(originalValue);
    }
    public static Long getValue(Long originalValue) {
        return repository.getValue(originalValue);
    }
    public static void serve (Long originalValue){
        FibonacciService.serve(originalValue);

    }

}
