import jakarta.persistence.*;

@Entity
@Table(name = "fibonacci_numbers")
public class FibonacciNumber {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Long originalValue;
    private Long value;

    public FibonacciNumber() {
        id = 0;
        originalValue = null;
        value = null;
    }

    public FibonacciNumber(Long originalValue, Long value) {
        this.originalValue = originalValue;
        this.value = value;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getOriginalValue() {
        return originalValue;
    }

    public void setOriginalValue(Long originalValue) {
        this.originalValue = originalValue;
    }

    public Long getValue() {
        return value;
    }

    public void setValue(Long value) {
        this.value = value;
    }
}

