package lotto.validation;

import lotto.constants.Message;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

class SystemValidatorTest {

	@ParameterizedTest(name = "{0}는 적어도 로또를 1개 살 수 있는 가격입니다.")
	@ValueSource(strings = {"1000", "1001", "2000"})
	void checkPurchaseAmountCanBuyAtLeastOneLottoTest(String purchaseAmount) {
		boolean result = SystemValidator.canBuyAtLeastOne(purchaseAmount);

		assertThat(result).isTrue();
	}

	@ParameterizedTest(name = "{0}는 1개의 로또도 살 수 없는 가격입니다.")
	@ValueSource(strings = {"999", "0", "-1", "834", "998"})
	void checkPurchaseAmountCantBuyAtLeastOneLottoTest(String purchaseAmount) {
		boolean result = SystemValidator.canBuyAtLeastOne(purchaseAmount);

		assertThat(result).isFalse();
	}

	@DisplayName("구입금액이 빈 문자열이면 통과하는 테스트")
	@Test
	void checkPurchaseAmountIsEmptyTest() {
		final String purchaseAmount = "";

		boolean result = SystemValidator.hasNothing(purchaseAmount);

		assertThat(result).isTrue();
	}

	@ParameterizedTest(name = "구입금액이 공백과 개행문자로만 이뤄졌다면 통과하는 테스트")
	@ValueSource(strings = {" ", " \n "})
	void checkPurchaseAmountHasOnlyBlankTest(String purchaseAmount) {
		boolean result = SystemValidator.hasNothing(purchaseAmount);

		assertThat(result).isTrue();
	}

	@DisplayName("구입금액으로 들어온 입력이 최소 1개의 문자(공백, 개행문자 제외)를 가진다면 통과하는 테스트")
	@Test
	void checkPurchaseAmountHasAtLeastOneCharTest() {
		final String purchaseAmount = "  a ";

		boolean result = SystemValidator.hasNothing(purchaseAmount);

		assertThat(result).isFalse();
	}

	@DisplayName("구입금액의 첫번째 문자가 '0'인지 확인하는 테스트. '0'이면 테스트 통과")
	@Test
	void checkPurchaseAmountFirstCharacterIsZeroTest() {
		final String purchaseAmount = "0123";

		boolean result = SystemValidator.hasZeroValueAtFirstChar(purchaseAmount);

		assertThat(result).isTrue();
	}

	@DisplayName("구입금액이 로또 가격(1000원)으로 나눠 떨어지는지 확인하는 테스트. 나누어 떨어지면 테스트 통과")
	@Test
	void checkPurchaseAmountDividedByLottoPriceTest() {
		final String purchaseAmount = "12000";

		boolean result = SystemValidator.isDividedByLottoPrice(purchaseAmount);

		assertThat(result).isTrue();
	}

	@DisplayName("구입금액이 로또 가격(1000원)으로 나눠 떨어지는지 확인하는 테스트. 나누어 떨어지지 않으면 테스트 통과")
	@Test
	void checkPurchaseAmountNotDividedByLottoPriceTest() {
		final String purchaseAmount = "12200";

		boolean result = SystemValidator.isDividedByLottoPrice(purchaseAmount);

		assertThat(result).isFalse();
	}

	@DisplayName("구입금액 입력이 숫자만 가진다면 테스트 통과")
	@Test
	void checkPurchaseAmountHasOnlyNumericValuesTest() {
		final String purchaseAmount = "1234";

		assertThatNoException().isThrownBy(() ->
				SystemValidator.validateIsNumber(purchaseAmount));
	}

	@DisplayName("구입금액 입력 중 하나라도 숫자가 아니라면 테스트 통과")
	@Test
	void checkPurchaseAmountHasNotOnlyNumericValuesTest() {
		final String purchaseAmount = "12a3";

		assertThatThrownBy(() ->
				SystemValidator.validateIsNumber(purchaseAmount))
				.isInstanceOf(IllegalArgumentException.class)
				.hasMessageContaining(Message.ERROR_IS_NOT_NUMERIC_VALUE);
	}

	@ParameterizedTest(name = "{0} 는 모두 숫자로만 이뤄졌고, 맨 앞의 숫자가 0이 아니기에 테스트 통과")
	@ValueSource(strings = {"1000", "1234", "9999", "1"})
	void checkPurchaseAmountIsNumberTest(String purchaseAmount) {
		assertThatNoException().isThrownBy(() ->
				SystemValidator.validateIsNumber(purchaseAmount));
	}

	@ParameterizedTest(name = "{0} => 숫자가 아닌 문자가 존재하거나, 맨 앞의 문자가 '0'이면 예외 던짐")
	@ValueSource(strings = {"01000", "1a234", "99 99", "1\n1"})
	void checkPurchaseAmountIsNotNumberTest(String purchaseAmount) {
		assertThatThrownBy(() -> SystemValidator.validateIsNumber(purchaseAmount))
				.isInstanceOf(IllegalArgumentException.class)
				.hasMessageContaining(Message.ERROR_PREFIX);
	}

	@DisplayName("구입금액을 검증하는데 문자가 공백이나 개행문자만 존재하면 'ERROR_EMPTY_INPUT' 메세지를 예외로 던지는 테스트")
	@Test
	void checkPurchaseAmountInputIsBlankTest() {
		final String purchaseAmount = " ";

		assertThatThrownBy(() ->
				SystemValidator.validateUserPurchaseAmount(purchaseAmount))
				.isInstanceOf(IllegalArgumentException.class)
				.hasMessageContaining(Message.ERROR_EMPTY_INPUT);
	}

	@DisplayName("구입금액을 검증하는데 문자가 중간에 한 개라도 존재하면 " +
			"'ERROR_NOT_NUMERIC_PURCHASE_AMOUNT_INPUT' 메세지를 예외로 던지는 테스트")
	@Test
	void checkPurchaseAmountInputHasAtLeastOneNonNumericValueTest() {
		final String purchaseAmount = "1a2000";

		assertThatThrownBy(() ->
				SystemValidator.validateUserPurchaseAmount(purchaseAmount))
				.isInstanceOf(IllegalArgumentException.class)
				.hasMessageContaining(Message.ERROR_IS_NOT_NUMERIC_VALUE);
	}

	@DisplayName("구입금액을 검증하는데 맨 앞 문자가 '0'이라면 " +
			"'ERROR_FIRST_ZERO_PURCHASE_AMOUNT_INPUT' 메세지를 예외로 던지는 테스트")
	@Test
	void checkPurchaseAmountInputHasZeroAtFirstCharacterTest() {
		final String purchaseAmount = "02000";

		assertThatThrownBy(() ->
				SystemValidator.validateUserPurchaseAmount(purchaseAmount))
				.isInstanceOf(IllegalArgumentException.class)
				.hasMessageContaining(Message.ERROR_FIRST_CHAR_IS_ZERO);
	}

	@DisplayName("구입금액을 검증하는데 1개의 로또도 못사는 가격을 입력하면 " +
			"'ERROR_NOT_ENOUGH_PURCHASE_AMOUNT_INPUT' 메세지를 예외로 던지는 테스트")
	@Test
	void checkPurchaseAmountInputCantBuyAnyLottoTest() {
		final String purchaseAmount = "999";

		assertThatThrownBy(() ->
				SystemValidator.validateUserPurchaseAmount(purchaseAmount))
				.isInstanceOf(IllegalArgumentException.class)
				.hasMessageContaining(Message.ERROR_NOT_ENOUGH_PURCHASE_AMOUNT_INPUT);
	}

	@DisplayName("구입금액을 검증하는데 1000원으로 나눠떨어지지 않는 숫자를 입력하면 " +
			"'ERROR_DONT_DIVIDED_BY_LOTTO_PRICE' 메세지를 예외로 던지는 테스트")
	@Test
	void checkPurchaseAmountInputCantDividedByLottoPriceTest() {
		final String purchaseAmount = "1990";

		assertThatThrownBy(() ->
				SystemValidator.validateUserPurchaseAmount(purchaseAmount))
				.isInstanceOf(IllegalArgumentException.class)
				.hasMessageContaining(Message.ERROR_DONT_DIVIDED_BY_LOTTO_PRICE);
	}

	@ParameterizedTest(name = "''''{0}''''이 모두 적절한 숫자 원소를 갖는게 아니어서 [ERROR]로 시작하는 예외 메세지를 던진다.")
	@ValueSource(strings = {"1,2, , , ,4", "0,1,2,3,4,5", "a,b,c,d,e,f", " , , , , , ", "1,02,03,4,5,6", ""})
	void checkWinningLottoNumberIsNumber(String winningLottoNumber) {
		assertThatThrownBy(() ->
				SystemValidator.validateAllLottoNumberInputElementsIsNumber(winningLottoNumber))
				.isInstanceOf(IllegalArgumentException.class)
				.hasMessageContaining(Message.ERROR_PREFIX);
	}

	@DisplayName("',,,,,' 입력이 주어지면 빈 문자열 입력하면 안된다는 예외 메세지 던짐")
	@Test
	void checkWinningLottoNumberIsBlankTest() {
		final String input = ",,,,,";

		assertThatThrownBy(() ->
				SystemValidator.validateAllLottoNumberInputElementsIsNumber(input))
				.isInstanceOf(IllegalArgumentException.class)
				.hasMessageContaining(Message.ERROR_EMPTY_INPUT);
	}
}