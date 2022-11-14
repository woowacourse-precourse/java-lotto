package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoFactoryTest {

    List<Integer> numbers;

    @DisplayName("로또 번호 생성")
    @BeforeEach
    void setUp() {
        numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
    }

    @Test
    void 당첨번호_생성_값_검증() {
        WinLotto winLotto = LottoFactory.createWinLotto(numbers, 7);
        assertThat(winLotto)
            .extracting("lotto")
            .extracting("lotto")
            .isEqualTo(numbers);
    }

    @Test
    void 당첨번호_생성_보너스_번호_검증() {
        WinLotto winLotto = LottoFactory.createWinLotto(numbers, 7);
        assertThat(winLotto)
            .extracting("bonus")
            .isEqualTo(7);
    }

    @Test
    void 랜덤로또_생성_검증() {
        int lottoCount = 3;
        Lottos lottos = LottoFactory.createRandomLottoByCnt(lottoCount);
        assertThat(lottos.get().size())
            .isEqualTo(3);
    }

}
