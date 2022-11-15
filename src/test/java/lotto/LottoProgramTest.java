package lotto;

import lotto.domain.Lotto;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoProgramTest {

    private static LottoProgram lottoProgram;

    @BeforeAll
    static void init() {
        lottoProgram = new LottoProgram();
        lottoProgram.setWinningLotto(new Lotto(List.of(1,2,3,4,5,45)));
        lottoProgram.setBonusNumber(6);
    }

    @DisplayName("구입 가능한 로또 개수 계산 테스트")
    @Test
    void countLottoQuantityTest() {
        int count = lottoProgram.countLottoQuantity(14000);

        assertThat(count).isEqualTo(14);
    }

    @DisplayName("로또 순위 확인 테스트")
    @Test
    void checkLottoLank() {
        int[] result = lottoProgram.rankEachLotto(new Lotto(List.of(1,2,3,4,5,6)));
        assertThat(result[0]).isEqualTo(5);
        assertThat(result[1]).isEqualTo(1);
    }
}