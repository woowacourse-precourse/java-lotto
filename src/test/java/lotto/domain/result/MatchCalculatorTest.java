package lotto.domain.result;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class MatchCalculatorTest {
	MatchCalculator matchCalculator = new MatchCalculator();

	@DisplayName("컴퓨터 생성된 로또와 사용자 입력한 당첨 번호 간의 매칭 계수 기능을 검증한다")
	@Test
	void verifyGetLottoMatch() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {

		Method getLottoMatch = matchCalculator.getClass().getDeclaredMethod("getLottoMatch", List.class, List.class);
		getLottoMatch.setAccessible(true);

		List<Integer> lotto = List.of(1, 2, 3, 4, 5, 6);
		List<Integer> winningNumber = List.of(1, 2, 3, 10, 20, 30);

		getLottoMatch.invoke(matchCalculator, lotto, winningNumber);

		assertThat(MatchCalculator.lottoMatch).isEqualTo(3);
	}

	@DisplayName("컴퓨터 생성된 로또와 사용자 입력한 당첨 번호 간의 매칭 계수 기능을 검증한다")
	@Test
	void verifyGetBonusMatch() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
		Method getBonusMatch = matchCalculator.getClass().getDeclaredMethod("getBonusMatch", List.class, int.class, int.class);
		getBonusMatch.setAccessible(true);

		List<Integer> lotto = List.of(1, 2, 3, 4, 5, 6);
		int lottoMatch = 0;
		int bonusNumber = 1;

		getBonusMatch.invoke(matchCalculator, lotto, lottoMatch, bonusNumber);

		assertThat(MatchCalculator.bonusMatch).isEqualTo(1);
	}
}
