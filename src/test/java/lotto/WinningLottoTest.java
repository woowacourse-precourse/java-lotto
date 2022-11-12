package lotto;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.domain.WinningLotto;

public class WinningLottoTest {

	@DisplayName("split(,)으로 나눠서 winningNumber 만들기")
	@Test
	void createWinningNumber_메서드_테스트() {
		String userInput = "1,2,3,4,5,6";
		List<String> winningNumber = List.of("1", "2", "3", "4", "5", "6");
		WinningLotto.createWinningNumber(userInput);
		Assertions.assertThat(WinningLotto.getWinningNumber()).containsAll(winningNumber);
	}

	@DisplayName("split(,)으로 나눠서 bonusNumber 만들기")
	@Test
	void createBonusNumber_메서드_테스트() {
		String userInput = "1";
		List<String> bonusNumber = List.of("1");
		WinningLotto.createBonusNumber(userInput);
		Assertions.assertThat(WinningLotto.getBonusNumber()).containsAll(bonusNumber);

	}
}
