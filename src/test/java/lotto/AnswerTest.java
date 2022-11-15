package lotto;

import lotto.domain.Answer;
import lotto.exception.LottoError;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class AnswerTest {

    @Test
    public void 당첨번호_입력받기() throws Exception {
        //given
        Answer answer = new Answer();

        //when

        //then
        assertDoesNotThrow(() -> answer.inputAnswerLotto("1,2,5,34,6,3"));
        assertThat(answer.getAnswer()
                .sorted()).isSorted();
    }

    @Test
    public void 잘못된_당첨번호_입력_예외() throws Exception {
        //given
        Answer answer = new Answer();

        //when
        String withBlank = "1,2, 3,4,5,6";
        String notDistinct = "1,1,2,3,4,5";
        String trash = "trash";

        //then
        assertThrows(IllegalArgumentException.class,
                () -> answer.inputAnswerLotto(withBlank))
                .getMessage()
                .equals(LottoError.NOT_NUMERIC.getErrorMessage());

        assertThrows(IllegalArgumentException.class,
                () -> answer.inputAnswerLotto(notDistinct))
                .getMessage()
                .equals(LottoError.DISTINCT_NUMBERS.getErrorMessage());
        assertThrows(IllegalArgumentException.class,
                () -> answer.inputAnswerLotto(trash))
                .getMessage()
                .equals(LottoError.NOT_NUMERIC.getErrorMessage());
    }

    @Test
    public void 보너스_번호_입력받기() throws Exception {
        //given
        Answer answer = new Answer();
        answer.inputAnswerLotto("1,2,3,4,5,6");

        //when
        String bonusNumber = "7";

        //then
        assertDoesNotThrow(() -> answer.inputBonusNumber(bonusNumber));
    }

    @Test
    public void 보너스_번호_예외() throws Exception {
        //given
        Answer answer = new Answer();
        answer.inputAnswerLotto("1,2,3,4,5,6");

        //when
        String notDistinct = "2";
        String notNumber = "Not number";

        //then
        assertThrows(IllegalArgumentException.class,
                () -> answer.inputAnswerLotto(notDistinct))
                .getMessage()
                .equals(LottoError.DISTINCT_NUMBERS.getErrorMessage());

        assertThrows(IllegalArgumentException.class,
                () -> answer.inputAnswerLotto(notNumber))
                .getMessage()
                .equals(LottoError.NOT_NUMERIC.getErrorMessage());
    }
}
