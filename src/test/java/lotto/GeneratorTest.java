package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import lotto.model.Lotto;
import lotto.model.LottoGenerator;
import org.junit.jupiter.api.Test;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class GeneratorTest extends NsTest {
    @Test
    void 로또_자동_생성() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    List<Lotto> lotto = LottoGenerator.automatic(2);
                    assertThat(lotto.get(0).getNumbers()).isEqualTo(new Lotto(List.of(8, 21, 23, 41, 42, 43)).getNumbers());
                    assertThat(lotto.get(1).getNumbers()).isEqualTo(new Lotto(List.of(1, 2, 3, 4, 5, 6)).getNumbers());
                },
                List.of(8, 21, 23, 41, 42, 43),
                List.of(1, 2, 3, 4, 5, 6)
        );
    }

    @Test
    void 구매_가능_한_로또_최대_에러() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> LottoGenerator.maximum(1500))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 구매_가능_한_로또_최대_성공() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThat(LottoGenerator.maximum(2000))
                .isEqualTo(2);
    }

    @Override
    protected void runMain() {
    }
}
