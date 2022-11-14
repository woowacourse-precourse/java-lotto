package model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import util.message.ErrorMessage;

class WinLottoTest {

    @Test
    @DisplayName("[WinLotto] 정상적인 WinLotto 객체 생성")
    void CorrectWinLotto() {
        //given
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int bonusNumber=7;
        //when
        //then
        assertDoesNotThrow(()-> new WinLotto(numbers, bonusNumber));
    }

    @Test
    @DisplayName("[WinLotto] 보너스번호가 6개의 당첨번호와 중복되는 경우")
    void DuplicateBonusNumber() {
        //given
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int duplicateBonusNumber=4;
        //when
        //then
        assertThatThrownBy(() -> new WinLotto(numbers, duplicateBonusNumber))
                .isInstanceOf(IllegalArgumentException.class).hasMessage(ErrorMessage.HAS_NOT_DUPLICATE_NUM);
    }

    @Test
    @DisplayName("[WinLotto] 보너스번호가 1~45 범위를 벗어나는 경우")
    void outOfRangeBonusNumber() {
        //given
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int outOfRangeBonusNumber=123;
        //when
        //then
        assertThatThrownBy(() -> new WinLotto(numbers, outOfRangeBonusNumber))
                .isInstanceOf(IllegalArgumentException.class).hasMessage(ErrorMessage.IS_NOT_LOTTO_RANGE_NUM);
    }
}