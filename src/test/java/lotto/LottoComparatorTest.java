package lotto;

import static camp.nextstep.edu.missionutils.test.Assertions.*;
import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import camp.nextstep.edu.missionutils.test.NsTest;
import lotto.domain.Lotto;

public class LottoComparatorTest extends NsTest {

	@DisplayName("당첨 번호와 몇 개의 번호가 같은지 계산")
	@Test
	void calculateCountMatchNumber_메서드_테스트() {
		Set<Integer> numbers = new TreeSet<>(List.of(1, 2, 3, 4, 5, 6));
		List<String> winningNumber = new ArrayList<>(List.of("1", "2", "3", "4", "11", "13"));
		String bonusNumber = "33";

		int matchNumberCount = LottoComparator.calculateCountMatchNumber(new Lotto(numbers), 0, winningNumber,
			bonusNumber);

		Assertions.assertEquals(matchNumberCount, 4);

	}

	@DisplayName("당첨 번호 5개와 일치하고 보너스 번호까지 일치한다면 isMatchBonusNumber true로 바꿈")
	@Test
	void checkMatchBonusNumber_메서드_테스트() {
		Set<Integer> numbers = new TreeSet<>(List.of(1, 2, 3, 4, 5, 6));
		String bonusNumber = "6";

		Lotto lotto = new Lotto(numbers);
		LottoComparator.checkMatchBonusNumber(lotto, bonusNumber, 5);

		Assertions.assertTrue(lotto.getIsMatchBonusNumber());
	}


	@DisplayName("PrizeCount 계산(등수별로 당첨된 로또의 개수)")
	@Test
	void calculatePrizeCount_메서드_테스트() {
		assertRandomUniqueNumbersInRangeTest(
			() -> {
				run("5000", "7,18,19,20,22,26", "43");
				assertThat(output()).contains(
					"3개 일치 (5,000원) - 1개",
					"4개 일치 (50,000원) - 1개",
					"5개 일치 (1,500,000원) - 0개",
					"5개 일치, 보너스 볼 일치 (30,000,000원) - 0개",
					"6개 일치 (2,000,000,000원) - 0개"
				);
			},
			List.of(7, 18, 19, 22, 33, 34),
			List.of(20, 22, 26, 27, 31, 38),
			List.of(1, 4, 9, 26, 33, 42),
			List.of(1, 8, 21, 32, 37, 38),
			List.of(6, 8, 26, 27, 32, 43)
		);
	}

	@DisplayName("총 상금 계산")
	@Test
	void calculateTotalPrize_메서드_테스트() {
		assertRandomUniqueNumbersInRangeTest(
			() -> {
				run("5000", "7,18,19,20,22,26", "43");
				assertThat(output()).contains(
					"총 수익률은 1100.0%입니다."
				);
			},
			List.of(7, 18, 19, 22, 33, 34),
			List.of(20, 22, 26, 27, 31, 38),
			List.of(1, 4, 9, 26, 33, 42),
			List.of(1, 8, 21, 32, 37, 38),
			List.of(6, 8, 26, 27, 32, 43)
		);
	}

	@Override
	public void runMain() {
		Application.main(new String[] {});
	}
}
