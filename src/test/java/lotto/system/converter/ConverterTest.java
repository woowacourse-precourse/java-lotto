package lotto.system.converter;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.system.holder.ConverterHolder;
import lotto.system.holder.ValidationHolder;
import lotto.vo.LottoAmount;

class ConverterTest {
	@BeforeEach
	void setup() {
		ConverterHolder.initializeConverters(List.of(new StringToLottoAmountConverter()));
		ValidationHolder.initializeValidators(List.of(new MockValidator()));
	}

	@AfterEach
	void runAfter() {
		ConverterHolder.clearHolder();
		ValidationHolder.clearHolder();
	}

	@Test
	@DisplayName("String 입력값을 LottoAmount 객체로 변환할 수 있다.")
	void givenString_whenConvertingToLottoAmount_thenReturnsLottoAmount() {
		//given
		String money = "14000";

		//when
		LottoAmount target = ConverterHolder.convert(money, LottoAmount.class);

		//then
		assertThat(target.getAmount()).isEqualTo(14);
	}
}