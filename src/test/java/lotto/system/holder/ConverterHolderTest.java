package lotto.system.holder;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.fail;

import java.lang.reflect.Field;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.system.converter.Converter;

class ConverterHolderTest {
	@AfterEach
	void doAfter() {
		ConverterHolder.clearHolder();
	}

	@Test
	@DisplayName("ConverterHolder 에 저장할 converter 리스트를 초기화할 수 있다.")
	void givenConverterHolder_whenInitializingList_thenSavesLists() {
		//given
		Converter mockConverter = getMockConverter();
		Converter mockConverter2 = getMockConverter();

		//when
		List<Converter> converters = List.of(mockConverter, mockConverter2);
		ConverterHolder.initializeConverters(converters);

		//then
		try {
			Field target = ConverterHolder.class.getDeclaredField("converters");
			target.setAccessible(true);

			ThreadLocal<List<Converter>> findConverters
				= (ThreadLocal<List<Converter>>)target.get(ConverterHolder.class);

			assertThat(findConverters.get()).hasSize(2);
			assertThat(findConverters.get()).isEqualTo(converters);
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}

	@Test
	@DisplayName("ConverterHolder 가 초기화된 이후에는 리스트 내용을 변경할 수 없다.")
	void givenAlreadyInitializedValidatorHolder_whenEditingHolder_thenThrowsException() {
		//given
		Converter mockConverter = getMockConverter();
		Converter mockConverter2 = getMockConverter();

		List<Converter> converters = List.of(mockConverter, mockConverter2);
		ConverterHolder.initializeConverters(converters);

		//when & then
		Converter mockConverter3 = getMockConverter();
		assertThatThrownBy(() -> ConverterHolder.initializeConverters(List.of(mockConverter3)))
			.isInstanceOf(IllegalStateException.class)
			.hasMessage(ConverterHolder.ILLEGAL_ACCESSING_TO_INITIALIZED_MESSAGE);
	}

	@Test
	@DisplayName("clearHolder() 를 호출하여 ValidatorHolder 의 리스트를 비울 수 있다.")
	void givenAlreadyInitializedValidatorHolder_whenClearingHolder_thenClearsHolder() {
		//given
		Converter mockConverter = getMockConverter();
		Converter mockConverter2 = getMockConverter();

		List<Converter> converters = List.of(mockConverter, mockConverter2);
		ConverterHolder.initializeConverters(converters);

		//when
		ConverterHolder.clearHolder();

		//then
		try {
			Field target = ConverterHolder.class.getDeclaredField("converters");
			target.setAccessible(true);

			ThreadLocal<List<Converter>> findValidators
				= (ThreadLocal<List<Converter>>)target.get(ConverterHolder.class);

			assertThat(findValidators.get()).isNull();
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}

	private Converter getMockConverter() {
		return new Converter() {
			@Override
			public boolean supports(Object target, Class<?> to) {
				return false;
			}

			@Override
			public Object convert(Object target) {
				return null;
			}
		};
	}

	// TODO: 입력값에 알맞는 converter 를 찾아 검증 작업을 실행한다.

	// TODO: 입력값에 알맞는 converter 를 찾지 못하면 예외가 발생한다.
}