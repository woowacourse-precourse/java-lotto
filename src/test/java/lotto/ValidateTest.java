package lotto;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

class ValidateTest {

	@Test
	void 로또_번호_갯수_검열(){
		assertThat(Validate.isInValidSize(List.of(1,2,3,4,5,6,7))).isEqualTo(true);
		assertThat(Validate.isInValidSize(List.of(1,2,3))).isEqualTo(true);
		assertThat(Validate.isInValidSize(List.of(1,2,3,4,5,6))).isEqualTo(false); // 올바른 입력
	}

	@Test
	void 로또_번호_중복_검열(){
		assertThat(Validate.isDuplicated(List.of(1,1,2,3,4,5))).isEqualTo(true);
		assertThat(Validate.isDuplicated(List.of(1,6,2,3,4,5))).isEqualTo(false); // 올바른 입력
	}

	@Test
	void 로또_번호_숫자_범위_검열(){
		assertThat(Validate.isOutOfRange(List.of(0,1,2,3,4,5))).isEqualTo(true);
		assertThat(Validate.isOutOfRange(List.of(46,1,2,3,4,5))).isEqualTo(true);
		assertThat(Validate.isOutOfRange(List.of(1,2,3,4,5,45))).isEqualTo(false);
	}

	@Test
	void 금액이_숫자가_아닐경우(){
		String invalidMoney = "123ab";
		String validMoney = "4000";
		assertThat(Validate.isNotNumeric(invalidMoney)).isEqualTo(true);
		assertThat(Validate.isNotNumeric(validMoney)).isEqualTo(false);
	}

	@Test
	void 금액이_부족한_경우(){
		String invalidMoney = "999";
		String validMoney = "1000";
		assertThat(Validate.isNotEnough(invalidMoney)).isEqualTo(true);
		assertThat(Validate.isNotEnough(validMoney)).isEqualTo(false);
	}

	@Test
	void 천원단위로_나누어_떨어지지_않을_때(){
		String invalidMoney = "3210";
		String validMoney = "5000";
		assertThat(Validate.isNotDivisible(invalidMoney)).isEqualTo(true);
		assertThat(Validate.isNotDivisible(validMoney)).isEqualTo(false);
	}

	@Test
	void 구매_금액_테스트(){
		String notNumeric = "123ab";
		assertThatThrownBy(() -> Validate.checkValidMoney(notNumeric))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining(Message.ERROR.getMessage() + Message.NOT_NUMERIC.getMessage());

		String notEnoughMoney = "486";
		assertThatThrownBy(() -> Validate.checkValidMoney(notEnoughMoney))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining(Message.ERROR.getMessage() + Message.NOT_ENOUGH_MONEY.getMessage());

		String notDivisible = "3589";
		assertThatThrownBy(() -> Validate.checkValidMoney(notDivisible))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining(Message.ERROR.getMessage() + Message.NOT_DIVISIBLE_MONEY.getMessage());
	}
}
