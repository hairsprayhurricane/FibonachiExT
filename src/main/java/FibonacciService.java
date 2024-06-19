import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public  class FibonacciService {

    public static void serve(Long originalValue){
        FibonacciRepository repository = new FibonacciRepository();
        Long originalNumber = FibonacciController.getOriginalValue(originalValue);
        Long number = FibonacciController.getValue(originalValue);
        try{
            if (originalNumber == 0L){
                Long value = Long.valueOf(FibonacciCalculator.getFibonacciNumber(originalValue));

                if (value == 1L){
                    System.out.println(originalValue + " слишком низкое число.");
                    return;
                }

                StandardServiceRegistry standardServiceRegistry = new StandardServiceRegistryBuilder()
                        .configure("hibernate.cfg.xml").build();
                Metadata metadata = new MetadataSources(standardServiceRegistry)
                        .getMetadataBuilder()
                        .build();
                SessionFactory sessionFactory = metadata.getSessionFactoryBuilder()
                        .build();
                Session session = sessionFactory.openSession();
                Transaction transaction = session.beginTransaction();

                session.save(new FibonacciNumber(originalValue, value));

                transaction.commit();
                sessionFactory.close();
                System.out.print("Числа были добавлены в базу: Переданное число: " + originalValue + " Его версия в фибоначи: " + value);
            } else {
                System.out.println("Число " + originalNumber + " есть в базе. Его фибоначи версия: " + number);
            }
        } catch (IllegalArgumentException e){
            System.out.println("Ошибка: " + e);
        }
    }

//    public static Long getOriginalValue(Long originalValue){
//        FibonacciRepository base = new FibonacciRepository();
//        base.getData();
//        List<FibonacciNumber>list = base.getList();
//        for (FibonacciNumber number : list){
//            if (Objects.equals(number.getOriginalValue(), originalValue)){
//                return number.getOriginalValue();
//            }
//        }
//        return 0L;
//    }
//
//    public static Long getValue(Long originalValue){
//        if (originalValue < 1){
//            System.out.print("Слишком низкое число. " );
//            return 0L;
//        }
//        FibonacciRepository base = new FibonacciRepository();
//        base.getData();
//        List<FibonacciNumber>list = base.getList();
//        for (FibonacciNumber number : list){
//            if (Objects.equals(number.getValue(), FibonacciCalculator.getFibonacciNumber(originalValue))){
//                System.out.print(originalValue + " есть в базе. Его фибоначи версия: " );
//                return number.getValue();
//            }
//        }
//        System.out.print("Данного числа нет в базе. ");
//        return 0L;
//    }
}
