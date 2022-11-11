package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


class InputLottoNumberTest {
    @DisplayName("들어온 input값을 replaceAll을 통해 확인")
    @Test
    void replaceAll_기능테스트(){
        String input = "1,2,3,4,5,6";
        input = input.replaceAll("[^\\d+,+\\d+,+\\d+,+\\d+,+\\d+,+\\d]","");
        assertThat(input).isEqualTo("1,2,3,4,5,6");
        String input2 = "1,2,3,4,5,a";
        input2 = input2.replaceAll("[^\\d+,+\\d+,+\\d+,+\\d+,+\\d+,+\\d]","");
        assertThat(input2).isEqualTo("1,2,3,4,5,");
        String input3 = "1,2,3.4.5.6";
        input3 = input3.replaceAll("[^\\d+,+\\d+,+\\d+,+\\d+,+\\d+,+\\d]","");
        assertThat(input3).isEqualTo("1,2,3456");
        String input4 = "10,22,3,4,40,6";
        input4 = input4.replaceAll("[^\\d+,+\\d+,+\\d+,+\\d+,+\\d+,+\\d]","");
        assertThat(input4).isEqualTo("10,22,3,4,40,6");
    }
    @DisplayName("정상 입력시 기능 Test")
    @Test
    void 정상_입력_처리(){
        assertThat(InputLottoNumber.makeAnswerNumbers("1,2,3,4,5,6")).containsExactly(1,2,3,4,5,6);
        assertThat(InputLottoNumber.makeAnswerNumbers("1,2,11,4,5,10")).containsExactly(1,2,4,5,10,11);
        List<Integer> answer = InputLottoNumber.makeAnswerNumbers("1,2,11,4,5,10");
        InputLottoNumber.addBonusNumber(answer,"20");
        assertThat(answer).containsExactly(1,2,4,5,10,11,20);
    }

    @DisplayName("예외 처리 Test")
    @Test
    void 예외_입력처리_문자열(){
        assertThatThrownBy(() ->InputLottoNumber.makeAnswerNumbers("1,2,3,4,5,a"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 입력형식이 틀렸습니다.");
    }
    @Test
    void 예외_입력처리_숫자초과(){
        assertThatThrownBy(() ->InputLottoNumber.makeAnswerNumbers("1,2,3,4,5,6,7"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 숫자를 6개만 입력해주세요.");
    }
    @Test
    void 예외_입력처리_중복숫자(){
        assertThatThrownBy(() ->InputLottoNumber.makeAnswerNumbers("1,2,3,4,6,6"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 중복된 숫자가 있습니다.");
    }
    @Test
    void 예외_입력처리_숫자범위초과(){
        assertThatThrownBy(() ->InputLottoNumber.makeAnswerNumbers("1,2,3,4,5,55"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 45 이하의 숫자를 입력해주세요");
    }
    @Test
    void 예외_입력처리_숫자범위미만(){
        assertThatThrownBy(() ->InputLottoNumber.makeAnswerNumbers("1,2,3,4,5,0"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 1 이상의 숫자를 입력해주세요.");
    }
    @DisplayName("보너스 숫자 에외 Test")
    @Test
    void 숫자가아닌_다른형_입력(){
        List<Integer> answer = InputLottoNumber.makeAnswerNumbers("1,2,11,4,5,10");
        assertThatThrownBy(()->InputLottoNumber.addBonusNumber(answer,"hi"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 숫자를 입력해주세요.");
    }
    @Test
    void 중복된_숫자_입력(){
        List<Integer> answer = InputLottoNumber.makeAnswerNumbers("1,2,11,4,5,10");
        assertThatThrownBy(()->InputLottoNumber.addBonusNumber(answer,"1"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 기존 당첨번호와 중복입니다.");
    }
    @Test
    void 범위초과_숫자_입력(){
        List<Integer> answer = InputLottoNumber.makeAnswerNumbers("1,2,11,4,5,10");
        assertThatThrownBy(()->InputLottoNumber.addBonusNumber(answer,"55"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 1이상 45이하 숫자를 입력해주세요.");

    }
}