package lotto.system.converter;

import lotto.system.LottoApplication;
import lotto.system.holder.ConverterHolder;
import lotto.vo.LottoBuyingInfo;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ConverterTest {
	@BeforeEach
	void setup() {
		LottoApplication.initializeValidators();
		LottoApplication.initializeConverters();
	}

	@AfterEach
	void runAfter() {
		LottoApplication.doAfter();
	}

	@Test
	@DisplayName("String 입력값을 LottoAmount 객체로 변환할 수 있다.")
	void givenString_whenConvertingToLottoAmount_thenReturnsLottoAmount() {
		//given
		String money = "14000";

		//when
		LottoBuyingInfo target = ConverterHolder.convert(money, LottoBuyingInfo.class);

		//then
		assertThat(target.getAmount()).isEqualTo(14);
	}
}