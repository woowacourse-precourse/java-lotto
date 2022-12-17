package lotto;

import static camp.nextstep.edu.missionutils.test.Assertions.*;
import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import camp.nextstep.edu.missionutils.test.NsTest;

public class LottoTest extends NsTest {

	@DisplayName("알맞은 금액의 로또를 샀는지 테스트")
	@Test
	void payForLotto_메서드_테스트() {
		assertRandomUniqueNumbersInRangeTest(
			() -> {
				run("4000", "1,2,3,4,5,6", "7");
				assertThat(output()).contains(
					"4개를 구매했습니다."
				);
			},
			List.of(1, 2, 3, 4, 5, 6),
			List.of(7, 8, 9, 10, 11, 12),
			List.of(13, 14, 15, 16, 17, 18),
			List.of(19, 20, 21, 22, 23, 24)
		);
	}

	@Override
	public void runMain() {
		Application.main(new String[] {});
	}
}
