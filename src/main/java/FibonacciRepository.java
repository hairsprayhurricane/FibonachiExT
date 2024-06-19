import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
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

public class FibonacciRepository {

    private static List<FibonacciNumber> list = new ArrayList<>();

    public FibonacciRepository() {
        list = null;
    }

    public void getData(){

        StandardServiceRegistry standardServiceRegistry = new StandardServiceRegistryBuilder()
                .configure("hibernate.cfg.xml").build();
        Metadata metadata = new MetadataSources(standardServiceRegistry)
                .getMetadataBuilder()
                .build();
        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder()
                .build();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<FibonacciNumber> courseCriteriaQuery = criteriaBuilder.createQuery(FibonacciNumber.class);
        Root<FibonacciNumber> root = courseCriteriaQuery.from(FibonacciNumber.class);
        List<FibonacciNumber> baselist = session.createQuery(courseCriteriaQuery).getResultList();

        list = baselist;
    }

    public static List<FibonacciNumber> getList(){
        //getData();
        return list;
    }


    public Long getOriginalValue(Long originalValue){
        getData();
        for (FibonacciNumber number : list){
            if (Objects.equals(number.getOriginalValue(), originalValue)){
                return number.getOriginalValue();
            }
        }
        return 0L;
    }

    public Long getValue(Long originalValue){
        if (originalValue < 1){
            System.out.print("Слишком низкое число. " );
            return 0L;
        }
        getData();
        for (FibonacciNumber number : list){
            if (Objects.equals(number.getValue(), FibonacciCalculator.getFibonacciNumber(originalValue))){
                return number.getValue();
            }
        }
        System.out.print(originalValue + " нет в базе. ");
        return 0L;
    }

}
