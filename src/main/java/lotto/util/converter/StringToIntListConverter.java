package lotto.util.converter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringToIntListConverter implements Converter<String, List<Integer>> {

    private final String delimeter;

    public StringToIntListConverter(final String delimeter) {
        this.delimeter = delimeter;
    }
    
    @Override
    public List<Integer> operate(final String input) {
        return Arrays.stream(input.split(delimeter))
                .map(Integer::valueOf)
                .collect(Collectors.toList());
    }
}
