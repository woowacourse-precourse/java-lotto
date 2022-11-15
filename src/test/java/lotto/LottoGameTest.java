package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import lotto.domain.LottoGame;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;


class LottoGameTest {
    @DisplayName("입력된 6자리 당첨번호 중 중복값이 존재하면 예외처리")
    @Test
    void 당첨번호_입력값_중_중복값은_없는지_검증하는_기능_테스트() {
        //given
        List<Integer> case1 = List.of(1, 2, 3, 4, 5, 5);
        int testBonusNumber = 45;

        //when
        Throwable result1 = catchThrowable(() -> {
            new LottoGame(case1, testBonusNumber);
        });

        //then
        assertThat(result1).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력된 당첨번호가 6자리가 아니면 예외처리")
    @Test
    void 입력받은_당첨번호가_6자리인지_검증하는_기능_테스트() {
        //given
        List<Integer> case1 = List.of(1, 2, 3, 4, 5, 6, 7, 8);
        List<Integer> case2 = List.of(1, 2, 3, 4);
        int testBonusNumber = 45;

        //when
        Throwable result1 = catchThrowable(() -> {
            new LottoGame(case1, testBonusNumber);
        });
        Throwable result2 = catchThrowable(() -> {
            new LottoGame(case2, testBonusNumber);
        });

        //then
        assertThat(result1).isInstanceOf(IllegalArgumentException.class);
        assertThat(result2).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력된 보너스번호가 당첨번호 중 중복되는 값이라면 예외처리")
    @Test
    void 보너스번호와_당첨번호_간_중복이_없는지_검증하는_기능_테스트() {
        //given
        int case1 = 3;
        List<Integer> testWinningNumbers = List.of(1, 2, 3, 4, 5, 6);

        //when
        Throwable result1 = catchThrowable(() -> {
            new LottoGame(testWinningNumbers, case1);
        });

        //then
        assertThat(result1).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스번호가 1~45 범위 내 값이 아니라면 예외처리")
    @Test
    void 보너스번호가_올바른_범위를_가지는_자연수인지_검증하는_기능기능_테스트() {
        //given
        int case1 = 0;
        int case2 = 50;
        List<Integer> testWinningNumbers = List.of(1, 2, 3, 4, 5, 6);

        //when
        Throwable result1 = catchThrowable(() -> {
            new LottoGame(testWinningNumbers, case1);
        });
        Throwable result2 = catchThrowable(() -> {
            new LottoGame(testWinningNumbers, case2);
        });

        //then
        assertThat(result1).isInstanceOf(IllegalArgumentException.class);
        assertThat(result2).isInstanceOf(IllegalArgumentException.class);
    }

}