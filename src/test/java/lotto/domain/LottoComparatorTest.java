package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.constant.WinningRating;

class LottoComparatorTest {

	@DisplayName("당첨 번호와 보너스 번호로 2등 당첨 여부를 구한다.")
	@Test
	void getSecondRating() {
		WinningNumbers winningNumbers;
		winningNumbers = new WinningNumbers("4,12,16,26,32,45");
		BonusNumber bonusNumber = new BonusNumber(2, winningNumbers);
		LottoComparator lottoComparator = new LottoComparator(winningNumbers, bonusNumber);
		lottoComparator.compare(new Lotto(List.of(2, 4, 12, 26, 32, 45)));
		assertThat(lottoComparator.getWinningRating()).isEqualTo(WinningRating.SECOND);
	}

	@DisplayName("당첨 번호로 1등 당첨 여부를 구한다.")
	@Test
	void getFirstRating() {
		WinningNumbers winningNumbers;
		winningNumbers = new WinningNumbers("4,12,16,26,32,45");
		BonusNumber bonusNumber = new BonusNumber(2, winningNumbers);
		LottoComparator lottoComparator = new LottoComparator(winningNumbers, bonusNumber);
		lottoComparator.compare(new Lotto(List.of(4, 12, 16, 26, 32, 45)));
		assertThat(lottoComparator.getWinningRating()).isEqualTo(WinningRating.FIRST);
	}
}