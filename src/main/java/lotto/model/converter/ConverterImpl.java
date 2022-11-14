package lotto.model.converter;


import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ConverterImpl implements Converter{
    @Override
    public BigDecimal convertStringToMoney(String userInput) {
        return new BigDecimal(userInput);
    }

    @Override
    public Integer convertStringToNumber(String systemInput) {
        return Integer.parseInt(systemInput);
    }

    @Override
    public BigDecimal convertMoneyToCount(BigDecimal money) {
        return money.divide(BigDecimal.valueOf(1000));
    }

    @Override
    public List<Integer> convertStringToNumbers(String systemInput) {
        List<Integer> numbers = Stream.of(systemInput.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        validateDuplicatedNumbers(numbers);
        return numbers;
    }

    private void validateDuplicatedNumbers(List<Integer> numbers){
        long count = numbers.stream().distinct().count();
        if (count != 6){
            throw new IllegalArgumentException();
        }
    }
}
