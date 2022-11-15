package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.controller.LottoBonusGenerator;

class LottoBonusTest {
	@DisplayName("보너스 번호에 정상적인 입력")
	@Test
	void createLottoBonusByRightWay() {
		assertThat(new LottoBonus(LottoBonusGenerator.generate("1")).getBonusNumber()).isEqualTo(1);
	}

	@DisplayName("보너스 번호가 1에서 45까지의 범위가 아닐때 예외가 발생한다.")
	@Test
	void createLottoBonusByExceedRange() {
		assertThatThrownBy(() -> new LottoBonus(LottoBonusGenerator.generate("0")))
			.isInstanceOf(IllegalArgumentException.class);
		assertThatThrownBy(() -> new LottoBonus(LottoBonusGenerator.generate("-0")))
			.isInstanceOf(IllegalArgumentException.class);
		assertThatThrownBy(() -> new LottoBonus(LottoBonusGenerator.generate("-1")))
			.isInstanceOf(IllegalArgumentException.class);
		assertThatThrownBy(() -> new LottoBonus(LottoBonusGenerator.generate("46")))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("보너스 번호가 숫자가 아닐때 예외가 발생한다..")
	@Test
	void createLottoBonusByInvalidCharacter() {
		assertThatThrownBy(() -> new LottoBonus(LottoBonusGenerator.generate("a")))
			.isInstanceOf(IllegalArgumentException.class);
		assertThatThrownBy(() -> new LottoBonus(LottoBonusGenerator.generate("=")))
			.isInstanceOf(IllegalArgumentException.class);
		assertThatThrownBy(() -> new LottoBonus(LottoBonusGenerator.generate("-")))
			.isInstanceOf(IllegalArgumentException.class);
	}
}