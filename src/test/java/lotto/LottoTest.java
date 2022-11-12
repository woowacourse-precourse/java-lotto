package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoUtil;
import lotto.lottopaper.LottoPaper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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

    @DisplayName("로또 숫자중 맞은 숫자 개수 확인")
    @Test
    void checkCorrectLottoNumberCount() {
        // given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Integer bonus = 6;
        List<Integer> userNumbers = List.of(1, 2, 3, 8, 9, 7);
        int answerNumbersCount = 3;
        int answerBonusCount = 1;

        // when
        int NumbersCount = lotto.getCorrectNumberCountInNumbers(userNumbers);
        int bonusCount = lotto.getCorrectBonusCount(bonus);

        // then
        assertThat(answerNumbersCount).isEqualTo(NumbersCount);
        assertThat(answerBonusCount).isEqualTo(bonusCount);
    }

    @DisplayName("등수 확인 util 메소드 테스트")
    @Test
    void checkRank() {
        // given
        int numberCount = 6;
        int bonusCount = 0;
        int answerRank = 1;

        // when
        int rank = LottoUtil.checkRank(numberCount, bonusCount);

        // then
        assertThat(rank).isEqualTo(answerRank);
    }

    @DisplayName("등수 확인 테스트")
    @Test
    void checkRealRank() {
        // given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Integer bonus = 7;
        List<Integer> userNumbers = List.of(1, 2, 3, 4, 5, 6);
        int answerRank = 1;

        // when
        int rank = lotto.getRank(userNumbers, bonus);

        // then
        assertThat(rank).isEqualTo(answerRank);
    }

    @DisplayName("로또 종이 결과 테스트")
    @Test
    void checkLottoPaperRank() {
        // given
        LottoPaper lottoPaper = generateTestLottos();
        Integer bonus = 7;
        List<Integer> userNumbers = List.of(8, 21, 23, 41, 42, 43);
        List<Integer> answerRanks = List.of(3, 1, 0, 0, 0, 1);

        // when
        List<Integer> ranks = lottoPaper.checkLottos(userNumbers, bonus);

        // then
        assertThat(ranks).isEqualTo(answerRanks);
    }

    private static LottoPaper generateTestLottos() {
        LottoPaper lottoPaper = new LottoPaper();
        lottoPaper.addLotto(new Lotto(List.of(8, 21, 23, 41, 42, 43)));
        lottoPaper.addLotto(new Lotto(List.of(3, 5, 11, 16, 32, 38)));
        lottoPaper.addLotto(new Lotto(List.of(7, 11, 16, 35, 36, 44)));
        lottoPaper.addLotto(new Lotto(List.of(1, 8, 11, 31, 41, 42)));
        lottoPaper.addLotto(new Lotto(List.of(13, 14, 16, 38, 42, 45)));
        return lottoPaper;
    }
}
