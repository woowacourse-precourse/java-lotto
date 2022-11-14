package lotto;

import java.util.List;
import java.util.Map;

import lotto.machine.LottoChecker;
import lotto.machine.LottoKiosk;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class LottoCheckerTest {

    private final List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
    private final int bonusNumber = 34;

    @DisplayName("투입한 모든 로또의 등수별 갯수를 저장")
    @Test
    void checkLottos() {
        //given
        LottoChecker lottoChecker = new LottoChecker(winningNumbers, bonusNumber);
        LottoKiosk lottoKiosk = new LottoKiosk();
        List<Lotto> lottos = List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(1, 2, 3, 4, 5, 34)),
                new Lotto(List.of(1, 2, 3, 4, 5, 7))
        );
        lottoChecker.insertLottos(lottos);
        lottoChecker.saveAllResult();
        //when
        Map<Prize, Integer> result = lottoChecker.showResult();
        //then
        assertThat(result.get(Prize.FIRST)).isEqualTo(1);
        assertThat(result.get(Prize.SECOND)).isEqualTo(1);
        assertThat(result.get(Prize.THIRD)).isEqualTo(1);
        assertThat(result.get(Prize.FOURTH)).isEqualTo(0);
        assertThat(result.get(Prize.FIFTH)).isEqualTo(0);
        assertThat(result.get(Prize.NONE)).isEqualTo(0);
    }

    @DisplayName("당첨번호와 일치하는 숫자 구하기")
    @Test
    void howManyMatches() {
        //given
        LottoChecker lottoChecker = new LottoChecker(winningNumbers, bonusNumber);
        //when
        int matches = lottoChecker.howManyMatches(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        //then
        assertThat(matches).isEqualTo(6);
    }

    @DisplayName("보너스 숫자 포함 여부 구하기")
    @Test
    void checkBonusNumber() {
        //given
        LottoChecker lottoChecker = new LottoChecker(winningNumbers, bonusNumber);
        //when
        boolean hasBonusNumber = lottoChecker.checkBonusNumber(new Lotto(List.of(1, 2, 3, 4, 5, 34)));
        boolean noBonusNumber = lottoChecker.checkBonusNumber(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        //then
        assertThat(hasBonusNumber).isTrue();
        assertThat(noBonusNumber).isFalse();
    }


    @DisplayName("일치하는 숫자의 갯수, 보너스 숫자 체크 여부로 등수 구하기")
    @Test
    void getPrize() {
        //given
        LottoChecker lottoChecker = new LottoChecker(winningNumbers, bonusNumber);
        //when
        Prize first = lottoChecker.getPrize(6, false);
        Prize second = lottoChecker.getPrize(5, true);
        Prize third = lottoChecker.getPrize(5, false);
        Prize fourth = lottoChecker.getPrize(4, false);
        Prize fifth = lottoChecker.getPrize(3, false);
        //then
        assertThat(first).isEqualTo(Prize.FIRST);
        assertThat(second).isEqualTo(Prize.SECOND);
        assertThat(third).isEqualTo(Prize.THIRD);
        assertThat(fourth).isEqualTo(Prize.FOURTH);
        assertThat(fifth).isEqualTo(Prize.FIFTH);
    }

    @DisplayName("총 당첨된 금액 구하기")
    @Test
    void getTotalPrizeMoney() {
        //given
        LottoChecker lottoChecker = new LottoChecker(winningNumbers, bonusNumber);
        List<Lotto> lottos = List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(1, 2, 3, 4, 5, 34)),
                new Lotto(List.of(1, 2, 3, 4, 5, 17)),
                new Lotto(List.of(1, 2, 3, 4, 22, 23))
        );
        //when
        lottoChecker.insertLottos(lottos);
        lottoChecker.saveAllResult();
        long totalPrizeMoney = lottoChecker.getTotalPrizeMoney();
        //then
        long expected = Prize.FIRST.money + Prize.SECOND.money + Prize.THIRD.money + Prize.FOURTH.money;
        assertThat(totalPrizeMoney).isEqualTo(expected);
    }

    @DisplayName("총 수익률 구하기")
    @Test
    void getProfitRate() {
        LottoChecker lottoChecker = new LottoChecker(winningNumbers, bonusNumber);
        List<Lotto> lottos = List.of(
                new Lotto(List.of(11, 12, 13, 14, 15, 16)),
                new Lotto(List.of(11, 12, 13, 14, 15, 16)),
                new Lotto(List.of(11, 12, 13, 14, 15, 16)),
                new Lotto(List.of(11, 12, 13, 14, 15, 16)),
                new Lotto(List.of(11, 12, 13, 14, 15, 16)),
                new Lotto(List.of(11, 12, 13, 14, 15, 16)),
                new Lotto(List.of(11, 12, 13, 14, 15, 16)),
                new Lotto(List.of(1, 2, 3, 20, 21, 23))
        );
        lottoChecker.insertLottos(lottos);
        lottoChecker.saveAllResult();
        String profitRate = lottoChecker.getProfitRate(lottoChecker.getTotalPrizeMoney());
        assertThat(profitRate).isEqualTo("62.5");
    }
}