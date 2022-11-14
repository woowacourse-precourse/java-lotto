package lotto;

import static org.assertj.core.api.Assertions.*;
import lotto.domain.LottoPaper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;


class LottoPaperTest {
    LottoPaper lottoPaper = new LottoPaper();
    @DisplayName("LottoPaper 에 랜던 번호가 잘 들어가는지 확인 하는 test")
    @Test
    void printLotto(){
        List<Integer> testNum = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6));
        lottoPaper.setLottoNumber(testNum);
        assertThat(lottoPaper.lottoNumber).isEqualTo(testNum);
    }
    @DisplayName("당첨번호와 랜덤번호와 비교해서 몇개 일치하는 지에 대한 test")
    @Test
    void getResult() {
        lottoPaper.lottoNumber = new ArrayList<>(List.of(1, 2, 10, 3, 4, 20));
        List<Integer> testLotto = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6));
        int bonus = 10;
        assertThat(lottoPaper.getResult(testLotto, bonus)).isEqualTo(4);
    }
}