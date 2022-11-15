package lotto.domain;

import lotto.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

public class LottoBundleTest {
    LottoBundle lottoBundle;

    @DisplayName("1개의 로또 발행이 정상적으로 되는지 확인")
    @Test
    void createOneLottoTest() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    lottoBundle = new LottoBundle(5);
                    Lotto lotto = new Lotto(List.of(8, 21, 23, 41, 42, 43));
                    assertThat(lottoBundle.createOneLotto().getNumbers()).isEqualTo(lotto.getNumbers());
                },
                List.of(8, 21, 23, 41, 42, 43)
        );
    }

    @DisplayName("LottoBundle 출력 확인")
    @Test
    void createLottoListTest() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    lottoBundle = new LottoBundle(5);
                    assertThat(lottoBundle.toString()).contains(
                            "[8, 21, 23, 41, 42, 43]",
                            "[3, 5, 11, 16, 32, 38]",
                            "[7, 11, 16, 35, 36, 44]",
                            "[1, 8, 11, 31, 41, 42]",
                            "[13, 14, 16, 38, 42, 45]"
                    );
                },
                List.of(8, 21, 23, 41, 42, 43),
                List.of(3, 5, 11, 16, 32, 38),
                List.of(7, 11, 16, 35, 36, 44),
                List.of(1, 8, 11, 31, 41, 42),
                List.of(13, 14, 16, 38, 42, 45)
        );
    }
}
