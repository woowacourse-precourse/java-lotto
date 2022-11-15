package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayNameGeneration(
	DisplayNameGenerator.ReplaceUnderscores.class
)
public class LottoTest {

	static Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

	@DisplayName("당첨번호와 로또번호를 비교하여 몇 개가 일치하는지 알 수 있다.")
	@Test
	void getMatchingNumbers_당첨번호와_로또번호_일치하는_개수_반환() {
		assertThat(
			lotto.getMatchingNumbers(List.of(1, 10, 11, 12, 13, 14))
		).isEqualTo(1);
		assertThat(
			lotto.getMatchingNumbers(List.of(1, 10, 6, 5, 3, 14))
		).isEqualTo(4);
		assertThat(
			lotto.getMatchingNumbers(List.of(11, 12, 13, 14, 15, 16))
		).isEqualTo(0);
	}


}
