package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static lotto.domain.WinningCheck.getPrizes;
import static lotto.domain.WinningCheck.getReturnRatio;
import static org.assertj.core.api.Assertions.assertThat;

class WinningCheckTest {
	@Test
	void 당첨_여부_및_등수_테스트() {
		List<Lotto> lotteries = new ArrayList<>();
		lotteries.add(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
		lotteries.add(new Lotto(List.of(1, 2, 3, 4, 5, 7)));
		lotteries.add(new Lotto(List.of(1, 2, 3, 4, 5, 8)));
		lotteries.add(new Lotto(List.of(1, 2, 3, 4, 7, 8)));
		lotteries.add(new Lotto(List.of(1, 2, 3, 7, 8, 9)));
		lotteries.add(new Lotto(List.of(1, 2, 7, 8, 9, 10)));
		lotteries.add(new Lotto(List.of(1, 7, 8, 9, 10, 11)));
		lotteries.add(new Lotto(List.of(7, 8, 9, 10, 11, 12)));

		WinningNumbersIncludingBonus winnings = new WinningNumbersIncludingBonus(
				new Lotto(List.of(1, 2, 3, 4, 5, 6)), 7);

		assertThat(getPrizes(lotteries, winnings)).isEqualTo(List.of(
				Prize.FIRST, Prize.SECOND, Prize.THIRD, Prize.FOURTH,
				Prize.FIFTH, Prize.NONE, Prize.NONE, Prize.NONE));
	}

	@DisplayName("소수점이 없는 값을 변환하면 1234.0 형태를 리턴한다.")
	@Test
	void getReturnRatioThatNoHaveDecimalPoint() {
		List<Prize> prizes = List.of(Prize.FIFTH);
		int purchasePrice = 5_000; //소수점이 안생기는 나눗셈을 위한 구매 금액

		assertThat(getReturnRatio(prizes, purchasePrice)).isEqualTo("100.0");

	}

	@DisplayName("소수점이 있는 값을 변환하면 소수점 둘째 자리에서 반올림하여 1234.5 형태를 리턴한다.")
	@Test
	void getReturnRatioByRounding() {
		List<Prize> prizes = List.of(Prize.FOURTH, Prize.FIFTH);
		int purchasePrice1 = 17_000; //소수점이 생겨, 내림을 실행하기 위한 구매 금액
		int purchasePrice2 = 15_000; //소수점이 생겨, 올림을 실행하기 위한 구매 금액

		//55,000 / 17,000 * 100 = 323.5294~~ => 323.5 (반올림하여 내림)
		assertThat(getReturnRatio(prizes, purchasePrice1)).isEqualTo("323.5");

		//55,000 / 15,000 * 100 = 366.6666~~ => 366.7 (반올림하여 올림)
		assertThat(getReturnRatio(prizes, purchasePrice2)).isEqualTo("366.7");
	}

	@DisplayName("수익률이 세 자리가 넘을 경우 콤마(,)를 붙인다.")
	@Test
	void getReturnRatioOverThousand() {
		List<Prize> prizes = List.of(Prize.FIRST);
		int purchasePrice = 10_000;

		//2,000,000,000 / 10,000 * 100 = 20,000,000 => 20,000,000.0
		assertThat(getReturnRatio(prizes, purchasePrice)).isEqualTo("20,000,000.0");
	}
}
