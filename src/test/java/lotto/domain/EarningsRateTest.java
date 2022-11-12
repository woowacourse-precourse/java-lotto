package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.utils.LottoType;

public class EarningsRateTest {
	@DisplayName("3000원으로 10000원 벌었을 때.")
	@Test
	void firstWin() {
		assertThat(EarningsRate.getEarningsRate(3000, 10000)).isEqualTo(333.0);
	}
}
