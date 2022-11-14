package lotto.domain.result;

import lotto.domain.lotto.Lotto;
import lotto.domain.player.BonusNumber;
import lotto.domain.player.WinningNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

import static java.util.Arrays.*;
import static org.assertj.core.api.Assertions.*;

public class MatchCalculatorTest {
	MatchCalculator matchCalculator = new MatchCalculator();

	@DisplayName("컴퓨터 생성된 로또와 사용자 입력한 당첨 번호 간의 매칭 계수 기능을 검증한다")
	@Test
	void verifyGetLottoMatch() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {

		Method getLottoMatch = matchCalculator.getClass().getDeclaredMethod("getLottoMatch", Lotto.class, WinningNumber.class);
		getLottoMatch.setAccessible(true);

		Lotto lotto = new Lotto(new ArrayList<>(asList(1, 2, 3, 4, 5, 6)));
		WinningNumber winningNumber = new WinningNumber("1,2,3,10,20,30");

		getLottoMatch.invoke(matchCalculator, lotto, winningNumber);

		assertThat(MatchCalculator.lottoMatch).isEqualTo(3);
	}

	@DisplayName("컴퓨터 생성된 로또와 사용자 입력한 당첨 번호 간의 매칭 계수 기능을 검증한다")
	@Test
	void verifyGetBonusMatch() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
		Method getBonusMatch = matchCalculator.getClass().getDeclaredMethod("getBonusMatch", Lotto.class, int.class, BonusNumber.class);
		getBonusMatch.setAccessible(true);

		Lotto lotto = new Lotto(new ArrayList<>(asList(1, 2, 3, 4, 5, 6)));
		int lottoMatch = 0;
		WinningNumber winningNumber = new WinningNumber("7,8,9,10,11,12");
		BonusNumber bonusNumber = new BonusNumber("1", winningNumber);

		getBonusMatch.invoke(matchCalculator, lotto, lottoMatch, bonusNumber);

		assertThat(MatchCalculator.bonusMatch).isEqualTo(1);
	}
}
