package lottomanager;

import lottomanager.LottoMaker;
import lotto.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoMakerTest {

    private final LottoMaker lottoMaker = new LottoMaker();
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void checkCompareLotto() {
        List<Integer> winningLotto = List.of(1, 2, 3, 4, 5, 6);
        List<Integer> payedLotto = List.of(1, 2, 3, 4, 5, 7);
        assertEquals(lottoMaker.compareLotto(winningLotto,payedLotto),5);
    }


}
