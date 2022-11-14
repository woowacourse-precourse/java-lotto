package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

class ChangeTest {
    @DisplayName("입력된 당첨 번호 문자열이 로또 번호로 정상적으로 변환되는지 확인한다.")
    @Test
    void lottoNumberTest_정상동작(){
        List<Integer> input = Change.lottoNumber("1,2,3,4,5,6");
        assertThat(input).isEqualTo(Arrays.asList(1,2,3,4,5,6));
    }

    @DisplayName("숫자와 ','을 제외한 문자가 입력이 되었으면 예외가 발생한다.")
    @Test
    void lottoNumberTest_다른문자가_입력(){
        assertThatThrownBy(() -> Change.lottoNumber("1,a,3,4,5,6"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("','가 2개 이상 입력이 되었으면 예외가 발생한다.")
    @Test
    void lottoNumberTest_콤마가_2개(){
        assertThatThrownBy(() -> Change.lottoNumber("1,,2,3,4,5,6"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("첫번째 자리에 문자가 입력되었으면 예외가 발생한다.")
    @Test
    void lottoNumberTest_첫번째_자리에_문자(){
        assertThatThrownBy(() -> Change.lottoNumber("a,2,3,4,5,6"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("마지막 자리에 문자가 입력되었으면 예외가 발생한다.")
    @Test
    void lottoNumberTest_마지막_자리에_문자(){
        assertThatThrownBy(() -> Change.lottoNumber("1,2,3,4,5,a"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력된 구입금액이 숫자로 변환되는지 확인한다.")
    @Test
    void number_정상동작(){
        int input = Change.number("1000");
        assertThat(input).isEqualTo(1000);
    }

    @DisplayName("숫자를 제외한 문자가 입력이 되었으면 예외를 발생한다.")
    @Test
    void number_문자입력(){
        assertThatThrownBy(() -> Change.number("1000b"))
                .isInstanceOf(IllegalArgumentException.class);
    }

}