package lotto.domain;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WonAnalysisTest {
    WonAnalysis lottoService = new WonAnalysis();

    @Test
    @DisplayName("당첨번호와 입력숫자 일치하는 숫자 갯수 반환")
    void cntMatchTest() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        List<Integer> userLotto = List.of(1, 2, 3, 4, 7, 8);
        int count = lottoService.cntMatchNumber(lotto.getNumbers(), userLotto);
        Assertions.assertThat(count).isEqualTo(4);
    }

    @Test
    @DisplayName("보너스 번호가 당첨, 2등일때")
    void checkBonusNumberTest() {
        List<Integer> userLotto = List.of(1, 2, 3, 4, 5, 7);
        int matchNumberCount = 5;
        BonusNumber.BONUS_NUMBER.setNumber(7);
        boolean bonusFlag = lottoService.checkBonus(matchNumberCount, userLotto);
        Assertions.assertThat(bonusFlag).isTrue();
    }

    @Test
    @DisplayName("구매 로또 등수 반환")
    void createLottoResultTest() {

        List<Integer> lotto = List.of(1, 2, 3, 4, 5, 6);
        BonusNumber.BONUS_NUMBER.setNumber(7);
        List<List<Integer>> userLotto = List.of(List.of(1, 2, 3, 4, 5, 6),
                List.of(1, 2, 3, 40, 41, 42),
                List.of(1, 2, 3, 4, 40, 41),
                List.of(1, 2, 3, 4, 5, 40),
                List.of(1, 2, 3, 4, 5, 7),
                List.of(40, 41, 42, 43, 44, 45));

        List<Rank> lottoResult = lottoService.Result(lotto, userLotto);
        Assertions.assertThat(lottoResult).contains(Rank.FIRST, Rank.SECOND, Rank.THIRD,
                Rank.FOURTH, Rank.FIFTH, Rank.BLANK);
    }

    @Test
    @DisplayName("수익률 계산")
    void calculatePercent() {
        List<Rank> lottoResult = List.of(Rank.FIFTH, Rank.BLANK, Rank.BLANK, Rank.BLANK);
        String percent = lottoService.Percent(lottoResult);
        Assertions.assertThat(percent).isEqualTo("125.0");
    }
}
