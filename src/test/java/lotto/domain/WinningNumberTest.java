package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class WinningNumberTest {

    List<Integer> numbers = Arrays.asList(1,2,3,4,5,6);
    List<Integer> numbers1 = Arrays.asList(1,2,3,4,5,7);
    int bonusNumber =7;
    WinningNumber winningNumber = new WinningNumber("1,2,3,4,5,6",bonusNumber);
    @Test
    void 숫자_이미_존재(){
        assertThatThrownBy(() -> winningNumber.ifNumberAlreadyExist(numbers,6))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    void 숫자_범위_안에_존재(){
        assertThatThrownBy(() -> winningNumber.checkIfNumberInRange(46))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    void 숫자_총_테스트(){
        assertThatThrownBy(() -> winningNumber.numberValidate(numbers,6))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    void 숫자_0으로_시작_테스트(){
        assertThatThrownBy(() -> winningNumber.checkIfNumberStartsWithZero(0,'0'))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 보너스_넘버_포함_테스트(){
        assertThatThrownBy(() -> winningNumber.setBonusNumber(6))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 문자열_변환_테스트(){
        assertThatThrownBy(() -> winningNumber.StringToIntegerList("String"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> winningNumber.StringToIntegerList(",1,2,3,4,5,6"))
                .isInstanceOf(IllegalArgumentException.class);
    }


}