package lotto;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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

    // 아래에 추가 테스트 작성 가능
    @DisplayName("맞은 개수와 보너스 정답 유무를 확인한다.")
    @Test
    void checkHitCountAndBonusHitCount1() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        List<Integer> winningNumbers = List.of(1,2,5,7,9,10);
        int bonus = 11;

        List<Integer> hitCountAndBonusHitCount = Application.checkLottery(lotto, winningNumbers, bonus);
        int hitCount = hitCountAndBonusHitCount.get(0);
        int bonusHitCount = hitCountAndBonusHitCount.get(1);

        assertThat(hitCount).isEqualTo(3);
        assertThat(bonusHitCount).isEqualTo(0);
    }

    @DisplayName("맞은 개수와 보너스 정답 유무를 확인한다.")
    @Test
    void checkHitCountAndBonusHitCount2() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        List<Integer> winningNumbers = List.of(1,2,5,7,9,10);
        int bonus = 6;

        List<Integer> hitCountAndBonusHitCount = Application.checkLottery(lotto, winningNumbers, bonus);
        int hitCount = hitCountAndBonusHitCount.get(0);
        int bonusHitCount = hitCountAndBonusHitCount.get(1);

        assertThat(hitCount).isEqualTo(3);
        assertThat(bonusHitCount).isEqualTo(1);
    }

    @DisplayName("등수 별 개수를 확인한다.")
    @Test
    void checkRankCount1() {
        List<Lotto> lotteries = new ArrayList<>();
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        lotteries.add(lotto);
        List<Integer> winningNumbers = List.of(1,2,5,7,9,10);
        int bonus = 6;

        List<Integer> rankCount = Application.getRankCount(lotteries, winningNumbers, bonus);
        assertThat(rankCount.toString()).isEqualTo("[0, 0, 0, 0, 0, 1]");
    }

    @DisplayName("등수 별 개수를 확인한다.")
    @Test
    void checkRankCount2() {
        List<Lotto> lotteries = new ArrayList<>();
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        lotteries.add(lotto);
        List<Integer> winningNumbers = List.of(1,2,5,6,9,10);
        int bonus = 11;

        List<Integer> rankCount = Application.getRankCount(lotteries, winningNumbers, bonus);
        assertThat(rankCount.toString()).isEqualTo("[0, 0, 0, 0, 1, 0 ]");
    }
}
