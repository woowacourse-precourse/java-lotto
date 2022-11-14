package lotto.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class WinningNumberTest {

	@ParameterizedTest
	@ValueSource(strings = {"1,2,3,4,6,6", "1,2,3,4", "1,2,3,4,5,6,7"})
	@DisplayName("예외 로직 테스트")
	void winNumsTest(String input) {
		List<Integer> userInput = Arrays.stream(input.split(","))
			.map(Integer::parseInt).collect(Collectors.toList());
		assertThrows(IllegalArgumentException.class, () -> new WinningNumber(userInput));
	}

	@ParameterizedTest
	@ValueSource(strings = {"1,2,3,4,5,6", "9,8,7,6,5,4"})
	@DisplayName("로또 랭킹을 잘 계산하는지 테스트")
	void winNumsCalculate(String input) {
		List<Integer> userInput = Arrays.stream(input.split(","))
			.map(Integer::parseInt).collect(Collectors.toList());
		Lotto lotto = new Lotto(List.of(6, 5, 4, 12, 23, 10));
		WinningNumber winningNumber = new WinningNumber(userInput);
		BonusNumber bonusNumber = new BonusNumber(11, winningNumber.getWinningNumber());
		LottoRanking lottoRanking = winningNumber.calculateMatchCount(lotto, bonusNumber.getBonusNumber());
		LottoRanking expect = LottoRanking.findLottoRank(3, false);

		assertEquals(expect, lottoRanking);
	}
}
