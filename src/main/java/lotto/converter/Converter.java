package lotto.converter;

public interface Converter<String, T> {

    T toNumbers(String input);
}
