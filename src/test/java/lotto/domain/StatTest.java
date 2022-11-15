package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

class StatTest {

	@Test
	void getStat() {
		Stat stat = new Stat(
			List.of(LottoType.FIRST, LottoType.SECOND, LottoType.SECOND, LottoType.THIRD, LottoType.FOURTH,
				LottoType.FIFTH, LottoType.FAIL, LottoType.FAIL, LottoType.SECOND, LottoType.THIRD, LottoType.FOURTH));

		assertThat(stat.getStat().get(LottoType.FIRST)).isEqualTo(1);
		assertThat(stat.getStat().get(LottoType.SECOND)).isEqualTo(3);
		assertThat(stat.getStat().get(LottoType.THIRD)).isEqualTo(2);
		assertThat(stat.getStat().get(LottoType.FOURTH)).isEqualTo(2);
		assertThat(stat.getStat().get(LottoType.FIFTH)).isEqualTo(1);
		assertThat(stat.getStat().get(LottoType.FAIL)).isEqualTo(2);
	}
}