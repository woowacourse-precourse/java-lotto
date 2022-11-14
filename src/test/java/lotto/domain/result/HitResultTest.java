package lotto.domain.result;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.domain.generator.FixedNumberGenerator;
import lotto.domain.generator.NumberGenerator;
import lotto.domain.lottery.BonusNumber;
import lotto.domain.lottery.LottoGroup;
import lotto.domain.lottery.WinningLotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ResultTest {

    @Test
    @DisplayName("로또 번호들 중 당첨의 수를 카운트합니다")
    void calculateMatchResults() {
        NumberGenerator fixedNumberGenerator = new FixedNumberGenerator();
        LottoGroup lottoGroup = new LottoGroup(5, fixedNumberGenerator);
        WinningLotto winningLotto = new WinningLotto("1,2,3,5,10,12");
        BonusNumber bonusNumber = new BonusNumber("8", winningLotto);
        HitResult result = new HitResult(lottoGroup, winningLotto, bonusNumber);

        List<Integer> answer = List.of(0, 5, 0, 0, 0);

        List<Integer> matchResults = result.calculateMatchResults(lottoGroup, winningLotto,
                bonusNumber);

        assertThat(matchResults)
                .isEqualTo(answer);
    }

}