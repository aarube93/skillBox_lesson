package Generics;

import java.util.List;

public class Calculator {

    public Double sum(List<? extends Number> numbers) {
        return numbers.stream()
                .map(n -> ((Number) n)
                        .doubleValue())
                .reduce((n1, n2) -> n1 + n2)
                .get();
    }

}
