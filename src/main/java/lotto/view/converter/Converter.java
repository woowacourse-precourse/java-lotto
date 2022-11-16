package lotto.view.converter;

public interface Converter<String, T> {

    T toNumbers(String input);
}
