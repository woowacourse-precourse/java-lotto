package lotto;

import lotto.domain.Lotto;
import lotto.logic.LottoVerifier;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class LottoVerifierTest {
    @Test
    void 입력을_숫자로_변환() {
        String input = "1";
        assertThat(LottoVerifier.getInputToInt(input)).isEqualTo(1);
    }

    @Test
    void 입력을_숫자로_변환_예외_처리() {
        String input = "46";
        assertThatThrownBy(() -> LottoVerifier.getInputToInt(input)).hasMessage("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
    }

    @Test
    void 입력_로또문자열을_리스트로_변환() {
        String input = "1,2,3,4,5,6";
        List<Integer> answer = List.of(1, 2, 3, 4, 5, 6);
        assertThat(LottoVerifier.getWinningNumber(input)).isEqualTo(answer);
    }


    @Test
    void 입력_숫자_예외_처리_테스트_숫자가_아닌_문자() {
        String s = "1,2,3,4,5,z";
        assertThatThrownBy(() -> LottoVerifier.getWinningNumber(s))
                .isInstanceOf(IllegalArgumentException.class).hasMessage("[ERROR] 로또 번호 문자열에 숫자가 아닌 문자가 있습니다.");




    }

    @Test
    void 입력_숫자_예외_처리_테스트_1부터_45사이가_아닌_숫자() {
        String s = "123,1,2,3,4,5";
        assertThatThrownBy(() -> LottoVerifier.getWinningNumber(s))
                .isInstanceOf(IllegalArgumentException.class).hasMessage("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
    }

    @Test
    void 입력_숫자_예외_처리_테스트_6개가_아닌_숫자() {
        String s = "1,2,3,4,5";
        assertThatThrownBy(() -> LottoVerifier.getWinningNumber(s))
                .isInstanceOf(IllegalArgumentException.class).hasMessage("[ERROR] 로또 번호의 숫자가 6개가 아닙니다.");
    }
    @Test
    void 입력_숫자_예외_처리_테스트_입력_숫자_중복() {
        String s = "1,2,3,4,5,5";
        assertThatThrownBy(() -> new Lotto(LottoVerifier.getWinningNumber(s)))
                .isInstanceOf(IllegalArgumentException.class).hasMessage("[ERROR] 입력 숫자가 중복되었습니다.");
    }
    @Test
    void 입력_숫자_예외_처리_이미_로또에_들어있는_보너스() {
        String s = "1,2,3,4,5,6";
        int bonus = 6;
        Lotto lotto = new Lotto(LottoVerifier.getWinningNumber(s));
        assertThatThrownBy(() -> lotto.bonusNotIncludeWinningNumbers(bonus))
                .isInstanceOf(IllegalArgumentException.class).hasMessage("[ERROR] 보너스 번호가 이미 로또번호에 포함되어 있습니다.");
    }

}
