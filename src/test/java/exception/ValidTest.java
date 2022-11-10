package exception;


import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import util.exception.Valid;
import util.message.ErrorMessage;

class ValidTest {

    @Test
    @DisplayName("[Valid-isDigit]Input이 숫자가 아님을 유효성 테스트")
    public void isNotDigit() {
        //given
        String notDigit = "193in23put";
        //when
        boolean result = Valid.isDigit(notDigit);
        //then
        assertThat(result).isFalse();
    }

    @Test
    @DisplayName("[Valid-isDigit]Input이 숫자가 맞음을 유효성 테스트")
    public void isDigit() {
        //given
        String digit = "1932";
        //when
        boolean result = Valid.isDigit(digit);
        //then
        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("[Valid-hasDuplicateNum]Input list가 중복가지는지 유효성 테스트")
    public void hasDuplicate() {
        //given
        List<Integer> numbers= Arrays.asList(1,2,3,4,5,6,5);
        //when
        boolean result = Valid.hasDuplicateNum(numbers);
        //then
        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("[Valid-hasDuplicateNum]Input list가 중복가지지 않는지 유효성 테스트")
    public void hasNotDuplicate() {
        //given
        List<Integer> numbers= Arrays.asList(1,2,3,4,5,6,7,8);
        //when
        boolean result = Valid.hasDuplicateNum(numbers);
        //then
        assertThat(result).isFalse();
    }
}