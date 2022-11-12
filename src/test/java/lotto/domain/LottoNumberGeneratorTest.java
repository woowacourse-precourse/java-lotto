package lotto.domain;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import static org.assertj.core.api.Assertions.assertThat;

public class LottoNumberGeneratorTest {

    @RepeatedTest(100)
    @DisplayName("로또 번호는 1부터 45 사이의 숫자여야 한다.")
    void 랜덤숫자_1부터_45까지_서로_다른_숫자_6개_생성() {
	List<Integer> result = LottoNumberGenerator.createRandomNumbers();
	for (int randomNumber: result) {
	    assertThat(randomNumber).isBetween(1, 45);
	}
    }
}
