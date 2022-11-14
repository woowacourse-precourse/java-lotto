package lotto.util.converter;

public class StringToIntConverter implements Converter<String, Integer> {

    @Override
    public Integer operate(final String input) {
        return Integer.valueOf(input);
    }
}
