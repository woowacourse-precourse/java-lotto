package lotto.domain;

import lotto.exception.LottoException;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LuckyNumberTest {
    @Test
    void 당첨번호_입력받기(){
        LuckyNumber luckyNumber=new LuckyNumber();

        String notDisit = "1,2,3,a,5,6";
        String notDisit2 = "1,2, 3,4,5,6";
        String invalidNumberCount = "1,2,3,4,5,6,7";
        String duplicated = "1,2,3,3,5,6";
        String good = "1,2,3,4,5,6";

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, ()-> luckyNumber.inputLuckyNumber(notDisit));
        assertThat(exception.getMessage()).isEqualTo(LottoException.NOT_DISIT.getErrorMessage());

        IllegalArgumentException exception1 = assertThrows(IllegalArgumentException.class, ()-> luckyNumber.inputLuckyNumber(notDisit2));
        assertThat(exception1.getMessage()).isEqualTo(LottoException.NOT_DISIT.getErrorMessage());

        IllegalArgumentException exception2 = assertThrows(IllegalArgumentException.class, ()-> luckyNumber.inputLuckyNumber(invalidNumberCount));
        assertThat(exception2.getMessage()).isEqualTo(LottoException.INVALID_NUMBER_COUNT.getErrorMessage());

        IllegalArgumentException exception3 = assertThrows(IllegalArgumentException.class, ()-> luckyNumber.inputLuckyNumber(duplicated));
        assertThat(exception3.getMessage()).isEqualTo(LottoException.DUPLICATED.getErrorMessage());

        luckyNumber.inputLuckyNumber(good);
        assertDoesNotThrow(() -> luckyNumber.inputLuckyNumber("1,2,5,34,6,3"));
    }

    @Test
    void 보너스숫자_입력받기(){
        LuckyNumber luckyNumber=new LuckyNumber();

        String notDisit = "a";
        String invalidNumberRange = "49";
        String good = "3";

        IllegalArgumentException exception1 = assertThrows(IllegalArgumentException.class, ()-> luckyNumber.inputBonusNumber(notDisit));
        assertThat(exception1.getMessage()).isEqualTo(LottoException.NOT_DISIT.getErrorMessage());

        IllegalArgumentException exception2 = assertThrows(IllegalArgumentException.class, ()-> luckyNumber.inputBonusNumber(invalidNumberRange));
        assertThat(exception2.getMessage()).isEqualTo(LottoException.INVALID_NUMBER_RANGE.getErrorMessage());

        luckyNumber.inputBonusNumber(good);
        assertThat(Integer.parseInt(good)).isEqualTo(luckyNumber.getBonusNumber());
    }
}