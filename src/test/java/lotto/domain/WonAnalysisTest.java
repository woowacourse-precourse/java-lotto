package lotto.domain;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WonAnalysisTest {
    WonAnalysis lottoService = new WonAnalysis();

    @Test
    @DisplayName("당첨번호와 사용자 로또번호의 같은 숫자갯수 반환")
    void cntMatchTest() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        List<Integer> userLotto = List.of(3, 4, 5, 6, 7, 8);
        int count = lottoService.countMatchNumber(lotto.getNumbers(), userLotto);
        Assertions.assertThat(count).isEqualTo(4);
    }

    @Test
    @DisplayName("보너스 번호가 당첨되었고 로또 등수가 2등일때만 true 반환")
    void checkBonusNumberTest() {
        List<Integer> userLotto = List.of(1, 2, 3, 4, 5, 7);
        int matchNumberCount = 5;
        BonusNumber.BONUS_NUMBER.setNumber(7);
        boolean bonusFlag = lottoService.checkBonusNumber(matchNumberCount, userLotto);
        Assertions.assertThat(bonusFlag).isTrue();
    }

    @Test
    @DisplayName("구입한 로또에 대한 등수 반환")
    void createLottoResultTest() {

        List<Integer> lotto = List.of(1, 2, 3, 4, 5, 6);
        BonusNumber.BONUS_NUMBER.setNumber(7);
        List<List<Integer>> userLotto = List.of(List.of(1, 2, 3, 4, 5, 6),
                List.of(1, 2, 3, 40, 41, 42),
                List.of(1, 2, 3, 4, 40, 41),
                List.of(1, 2, 3, 4, 5, 40),
                List.of(1, 2, 3, 4, 5, 7),
                List.of(40, 41, 42, 43, 44, 45));

        List<Rank> lottoResult = lottoService.createLottoResult(lotto, userLotto);
        Assertions.assertThat(lottoResult).contains(Rank.FIRST, Rank.SECOND, Rank.THIRD,
                Rank.FOURTH, Rank.FIFTH, Rank.BLANK);
    }

    @Test
    @DisplayName("로또 당첨 결과를 통해 수익률 계산")
    void calculatePercent() {
        List<Rank> lottoResult = List.of(Rank.FIFTH, Rank.BLANK, Rank.BLANK, Rank.BLANK);
        String percent = lottoService.calculatePercent(lottoResult);
        Assertions.assertThat(percent).isEqualTo("125.0");
    }
}
