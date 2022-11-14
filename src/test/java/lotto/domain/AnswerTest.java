package lotto.domain;

import lotto.exception.LottoError;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class AnswerTest {

    @Test
    void 당첨_번호_입력_받기() throws Exception {
        //given
        Answer answer = new Answer();

        //when

        //then
        assertDoesNotThrow(() -> answer.inputAnswerLotto("1,2,5,34,6,3"));
        assertThat(answer.getAnswer().sorted()).isSorted();
    }

    @Test
    void 당첨_번호_잘못_입력시_예외() throws Exception {
        //given
        Answer answer = new Answer();

        //when
        String withBlank = "1,2, 3,4,5,6";
        String distinct = "1,2,3,4,1,6";
        String trash = "trash";

        //then
        assertThrows(IllegalArgumentException.class,
                () -> answer.inputAnswerLotto(withBlank))
                .getMessage().equals(LottoError.NOT_NUMERIC.getErrorMessage());

        assertThrows(IllegalArgumentException.class,
                () -> answer.inputAnswerLotto(distinct))
                .getMessage().equals(LottoError.DISTINCT_NUMBERS.getErrorMessage());

        assertThrows(IllegalArgumentException.class,
                () -> answer.inputAnswerLotto(trash))
                .getMessage().equals(LottoError.NOT_NUMERIC.getErrorMessage());
    }

    @Test
    void 보너스_번호_입력_받기() throws Exception {
        //given
        Answer answer = new Answer();
        answer.inputAnswerLotto("1,2,3,4,5,6");

        //when
        String bonusNumber = "7";

        //then
        assertDoesNotThrow(() -> answer.inputBonusNumber(bonusNumber));
    }

    @Test
    void 보너스_번호_예외_발생() throws Exception {
        //given
        Answer answer = new Answer();
        answer.inputAnswerLotto("1,2,3,4,5,6");

        //when
        String distinct = "3";
        String notNumber = "I'm hungry";

        //then
        assertThrows(IllegalArgumentException.class,
                () -> answer.inputBonusNumber(distinct))
                .getMessage().equals(LottoError.DISTINCT_NUMBERS.getErrorMessage());

        assertThrows(IllegalArgumentException.class,
                () -> answer.inputBonusNumber(notNumber))
                .getMessage().equals(LottoError.NOT_NUMERIC.getErrorMessage());
    }
}