package lotto.system.holder;

import java.util.List;

import lotto.system.converter.Converter;
import lotto.system.exception.ConverterNotFoundException;

public class ConverterHolder {
	public static final String ILLEGAL_ACCESSING_TO_INITIALIZED_MESSAGE = "이미 초기화된 converters 를 변경할 수 없습니다.";
	private static final ThreadLocal<List<Converter>> converters = new ThreadLocal<>();

	public static void initializeConverters(List<Converter> target) {
		if (converters.get() == null) {
			converters.set(target);
			return;
		}
		throw new IllegalStateException(ILLEGAL_ACCESSING_TO_INITIALIZED_MESSAGE);
	}

	@SuppressWarnings("unchecked")
	public static <T> T convert(Object target, Class<?> to) {
		return (T) converters.get()
			.stream().filter(converter -> converter.supports(target, to))
			.findAny()
			.orElseThrow(ConverterNotFoundException::new)
			.convert(target);
	}

	public static void clearHolder() {
		converters.remove();
	}
}
