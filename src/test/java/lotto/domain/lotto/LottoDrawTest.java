package lotto.domain.lotto;

import java.util.List;
import lotto.common.InputErrors;
import lotto.domain.winningresult.WinningType;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class LottoDrawTest {
    private static final String ERROR_PREFIX = "[ERROR]";

    @Test
    public void 보너스_번호는_당첨_번호와_중복_될_수_없다() {
        //given
        List<Integer> winNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 6;

        Assertions.assertThatThrownBy(() -> LottoDraw.of(winNumbers, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_PREFIX)
                .hasMessageContaining(InputErrors.BONUS_NUMBER_DUPLICATED_WIN_NUMBER.getMessage());
    }

    @Test
    public void 추첨_결과와_로또_번호_결과_확인_테스트_5등() {
        //given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        LottoDraw lottoDraw = LottoDraw.of(List.of(1, 3, 5, 7, 9, 11), 4);

        //when
        WinningType winningType = lottoDraw.match(lotto);

        //then
        Assertions.assertThat(winningType).isEqualTo(WinningType.FIFTH_PLACE);
    }

    @Test
    public void 추첨_결과와_로또_번호_결과_확인_테스트_3등() {
        //given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        LottoDraw lottoDraw = LottoDraw.of(List.of(1, 2, 3, 4, 5, 7), 8);

        //when
        WinningType winningType = lottoDraw.match(lotto);

        //then
        Assertions.assertThat(winningType).isEqualTo(WinningType.THIRD_PLACE);
    }

    @Test
    public void 추첨_결과와_로또_번호_결과_확인_테스트_2등() {
        //given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        LottoDraw lottoDraw = LottoDraw.of(List.of(1, 2, 3, 4, 5, 7), 6);

        //when
        WinningType winningType = lottoDraw.match(lotto);

        //then
        Assertions.assertThat(winningType).isEqualTo(WinningType.SECOND_PLACE);
    }



}