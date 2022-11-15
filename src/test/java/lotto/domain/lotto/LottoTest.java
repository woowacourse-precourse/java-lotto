package lotto.domain.lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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

    @DisplayName("맞은_개수에_따라_결과가_정해진다")
    @Test
    void checkResultAccordingToSameCount() {
        Lotto lotteryForFirstPrize = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto lotteryForSecondPrize = new Lotto(List.of(2, 3, 4, 5, 6, 7));
        Lotto lotteryForThirdPrize = new Lotto(List.of(2, 3, 4, 5, 6, 8));
        Lotto lotteryForFourthPrize = new Lotto(List.of(3, 4, 5, 6, 7, 8));
        Lotto lotteryForFifthPrize = new Lotto(List.of(1, 2, 3, 7, 8, 9));
        List<Integer> answer = List.of(1, 2, 3, 4, 5, 6, 7); // 보너스 넘버 포함

        LottoPrize firstPrize = lotteryForFirstPrize.play(answer);
        LottoPrize secondPrize = lotteryForSecondPrize.play(answer);
        LottoPrize thirdPrize = lotteryForThirdPrize.play(answer);
        LottoPrize fourthPrize = lotteryForFourthPrize.play(answer);
        LottoPrize fifthPrize = lotteryForFifthPrize.play(answer);

        assertThat(firstPrize).isEqualTo(LottoPrize.FIRST);
        assertThat(secondPrize).isEqualTo(LottoPrize.SECOND);
        assertThat(thirdPrize).isEqualTo(LottoPrize.THIRD);
        assertThat(fourthPrize).isEqualTo(LottoPrize.FOURTH);
        assertThat(fifthPrize).isEqualTo(LottoPrize.FIFTH);
    }
}
