package lotto;

import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.WinningNumber;
import lotto.util.LottoRank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.*;

class LottoTest {
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호를 입력하면 오름차순으로 정렬한다")
    @Test
    void sortLottoNumber() {
        List<Integer> result = List.of(7, 10, 24, 34, 40, 41);
        Lotto lotto = new Lotto(List.of(34, 24, 40, 41, 10, 7));

        List<Integer> sortedByAscend = lotto.getNumbersSortedByAscending();

        assertThat(sortedByAscend).isEqualTo(result);
    }

    @DisplayName("로또 번호가 당첨 번호에 일치하는 개수를 반환한다")
    @Test
    void getHitCount() {
        Lotto lotto = new Lotto(List.of(1, 10, 12, 24, 33, 43));
        WinningNumber winningNumber = new WinningNumber(List.of(3, 10, 12, 20, 33, 45), 2);
        int result = 3;

        long hitCount = lotto.getHitCount(winningNumber);

        assertThat(hitCount).isEqualTo(result);
    }

    @DisplayName("로또 번호에 보너스 번호가 포함되어 있으면 true를 반환한다")
    @Test
    void isHitBonusNumber() {
        Lotto lotto = new Lotto(List.of(1, 10, 12, 24, 33, 43));
        WinningNumber winningNumber = new WinningNumber(List.of(3, 10, 12, 20, 33, 45), 43);

        boolean hitBonusNumber = lotto.isHitBonusNumber(winningNumber);

        assertThat(hitBonusNumber).isEqualTo(true);
    }

    @DisplayName("로또 번호에 보너스 번호가 포함되어 있지 않으면 false를 반환한다")
    @Test
    void isNotHitBonusNumber() {
        Lotto lotto = new Lotto(List.of(1, 10, 12, 24, 33, 43));
        WinningNumber winningNumber = new WinningNumber(List.of(3, 10, 12, 20, 33, 45), 41);

        boolean hitBonusNumber = lotto.isHitBonusNumber(winningNumber);

        assertThat(hitBonusNumber).isEqualTo(false);
    }

    @DisplayName("5개 번호와 1개의 보너스 번호가 일치하면 2등을 반환한다")
    @Test
    void isSecondPlace() {
        Lotto lotto = new Lotto(List.of(1, 10, 12, 24, 33, 43));
        WinningNumber winningNumber = new WinningNumber(List.of(1, 10, 12, 24, 33, 45), 43);
        LottoRank result = LottoRank.SECOND_PLACE;

        LottoRank rank = lotto.getRank(winningNumber);

        assertThat(rank).isEqualTo(result);
    }

    @DisplayName("5개 번호가 일치하면 3등을 반환한다")
    @Test
    void isThirdPlace() {
        Lotto lotto = new Lotto(List.of(1, 10, 12, 24, 33, 43));
        WinningNumber winningNumber = new WinningNumber(List.of(1, 10, 12, 24, 33, 45), 42);
        LottoRank result = LottoRank.THIRD_PLACE;

        LottoRank rank = lotto.getRank(winningNumber);

        assertThat(rank).isEqualTo(result);
    }

    @DisplayName("4개 번호가 일치하면 4등을 반환한다")
    @Test
    void isFourthPlace() {
        Lotto lotto = new Lotto(List.of(1, 10, 12, 24, 32, 43));
        WinningNumber winningNumber = new WinningNumber(List.of(1, 10, 12, 24, 33, 45), 43);
        LottoRank result = LottoRank.FOURTH_PLACE;

        LottoRank rank = lotto.getRank(winningNumber);

        assertThat(rank).isEqualTo(result);
    }

    @DisplayName("2개 번호가 일치하면 낫싱을 반환한다")
    @Test
    void isNothing() {
        Lotto lotto = new Lotto(List.of(1, 10, 13, 25, 32, 43));
        WinningNumber winningNumber = new WinningNumber(List.of(1, 10, 12, 24, 33, 45), 43);
        LottoRank result = LottoRank.NOTHING;

        LottoRank rank = lotto.getRank(winningNumber);

        assertThat(rank).isEqualTo(result);
    }

    @DisplayName("랭크 결과 리스트를 입력하면 총 당첨금을 반환한다")
    @Test
    void getTotalPrizeMoneyByRanks() {
        Lottos lottos = new Lottos(List.of(new Lotto(List.of(1, 2, 3, 4, 5, 6))));
        Map<LottoRank, Integer> ranks = Map.of(LottoRank.SECOND_PLACE, 2, LottoRank.THIRD_PLACE, 1);
        int result = 61_500_000;

        long totalPrizeMoney = lottos.getTotalPrizeMoney(ranks);

        assertThat(totalPrizeMoney).isEqualTo(result);
    }

    @DisplayName("산 로또들과 랭크를 입력하면 수익률이 반환된다")
    @Test
    void getRateOfReturnByMoneyAndPrizeMoney() {
        Lottos lottos = new Lottos(List.of(new Lotto(List.of(1, 2, 3, 4, 5, 6))));
        Map<LottoRank, Integer> ranks = Map.of(LottoRank.SECOND_PLACE, 2, LottoRank.THIRD_PLACE, 1);
        double result = 6_150_000.0;

        double rateOfReturn = lottos.getRateOfReturn(lottos.getTotalPrizeMoney(ranks));

        assertThat(rateOfReturn).isEqualTo(result);
    }
}
