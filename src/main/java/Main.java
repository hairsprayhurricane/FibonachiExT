public class Main {
    public static void main(String[] args) {
        // Task 1 & Task 3 (Расчет данных & Добавление или извлечение из базы)
        FibonacciController.serve(20L); // Передали обычное число, возвращает число фибоначи
        FibonacciController.serve(1L); // Операция не сработает
        FibonacciController.serve(2L); // Операция не сработает
        // Task 2
        System.out.println(FibonacciController.getValue(20L)); // Число есть в базе, выведет его фибоначи версию
        System.out.println(FibonacciController.getValue(3L)); // нет в базе
        System.out.println(FibonacciController.getValue(-1L));

    }

}