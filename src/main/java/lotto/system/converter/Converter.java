package lotto.system.converter;

public interface Converter {
	boolean supports(Object target, Class<?> to);

	Object convert(Object target);
}
