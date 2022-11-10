package lotto.system.holder;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.fail;

import java.lang.reflect.Field;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.system.validator.Validator;

class ValidationHolderTest {
	@AfterEach
	void doAfter() {
		ValidationHolder.clearHolder();
	}

	@Test
	@SuppressWarnings("unchecked") // validators 필드가 ThreadLocal<List<Validator>> 임이 보장되므로 무점검 경고를 해제한다.
	@DisplayName("ValidationHolder 에 저장할 Validator 리스트를 초기화할 수 있다.")
	void givenValidatorHolder_whenInitializingList_thenSavesLists() {
	    //given
		Validator mockValidator = getMockValidator();
		Validator mockValidator2 = getMockValidator();

		//when
		List<Validator> validators = List.of(mockValidator, mockValidator2);
		ValidationHolder.initializeValidators(validators);

	    //then
		try {
			Field target = ValidationHolder.class.getDeclaredField("validators");
			target.setAccessible(true);

			ThreadLocal<List<Validator>> findValidators
				= (ThreadLocal<List<Validator>>)target.get(ValidationHolder.class);

			assertThat(findValidators.get()).hasSize(2);
			assertThat(findValidators.get()).isEqualTo(validators);
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}

	@Test
	@DisplayName("ValidatorHolder 가 초기화된 이후에는 리스트 내용을 변경할 수 없다.")
	void givenAlreadyInitializedValidatorHolder_whenEditingHolder_thenThrowsException() {
	    //given
		Validator mockValidator = getMockValidator();
		Validator mockValidator2 = getMockValidator();
		List<Validator> validators = List.of(mockValidator, mockValidator2);

		ValidationHolder.initializeValidators(validators);

	    //when & then
		Validator mockValidator3 = getMockValidator();
		assertThatThrownBy(() -> ValidationHolder.initializeValidators(List.of(mockValidator3)))
			.isInstanceOf(IllegalStateException.class)
			.hasMessage(ValidationHolder.ILLEGAL_ACCESSING_TO_INITIALIZED_MESSAGE);
	}

	@Test
	@SuppressWarnings("unchecked") // validators 필드가 ThreadLocal<List<Validator>> 임이 보장되므로 무점검 경고를 해제한다.
	@DisplayName("clearHolder() 를 호출하여 ValidatorHolder 의 리스트를 비울 수 있다.")
	void givenAlreadyInitializedValidatorHolder_whenClearingHolder_thenClearsHolder() {
	    //given
		Validator mockValidator = getMockValidator();
		Validator mockValidator2 = getMockValidator();
		List<Validator> validators = List.of(mockValidator, mockValidator2);

		ValidationHolder.initializeValidators(validators);

	    //when
		ValidationHolder.clearHolder();

	    //then
		try {
			Field target = ValidationHolder.class.getDeclaredField("validators");
			target.setAccessible(true);

			ThreadLocal<List<Validator>> findValidators
				= (ThreadLocal<List<Validator>>)target.get(ValidationHolder.class);

			assertThat(findValidators.get()).isNull();
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}

	private static Validator getMockValidator() {
		return new Validator() {
			@Override
			public boolean supports(Object target, Class<?> to) {
				return false;
			}

			@Override
			public void validate(Object target) {
			}
		};
	}

	// TODO: 입력값에 알맞는 validator 를 찾아 검증 작업을 실행한다.

	// TODO: 입력값에 알맞는 validator 를 찾지 못하면 예외가 발생한다.
}