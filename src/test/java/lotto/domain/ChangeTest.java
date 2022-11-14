package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class ChangeTest {
    @DisplayName("입력된 당첨 번호 문자열이 로또 번호로 정상적으로 변환되는지 확인한다.")
    @Test
    void lottoNumberTest_정상동작(){
        List<Integer> input = Change.lottoNumber("1,2,3,4,5,6");
        assertThat(input).isEqualTo(Arrays.asList(1,2,3,4,5,6));
    }

    @Test
    @DisplayName("숫자와 ','을 제외한 문자가 입력이 되었으면 예외가 발생한다.")
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

    @DisplayName("보너스 번호가 숫자로 변환이 되는지 확인한다.")
    @Test
    void bonusNumber_정상동작(){
        int input = Change.bonusNumber("7");
        assertThat(input).isEqualTo(7);
    }

    @DisplayName("보너스 번호에 문자가 입력이 되었으면 예외를 발생한다.")
    @Test
    void bonusNumber_문자입력(){
        assertThatThrownBy(() -> Change.bonusNumber("a"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 45를 넘으면 예외를 발생한다.")
    @Test
    void bonusNumber_범위초과(){
        assertThatThrownBy(() -> Change.bonusNumber("46"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 1보다 작으면 예외를 발생한다.")
    @Test
    void bonusNumber_범위미만(){
        assertThatThrownBy(() -> Change.bonusNumber("0"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}