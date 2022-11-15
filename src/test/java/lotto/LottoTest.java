package lotto;

import lotto.util.InputUtility;
import lotto.util.Type;
import org.assertj.core.api.AssertionsForClassTypes;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static lotto.util.ConsoleUtility.writeConsole;

class LottoTest {

    @DisplayName("Lotto input 확인- ,와 숫자이외의 다른 문자가 들어왔을 경우")
    @Test
    void lottoInputIsNotDigit(){
        writeConsole("1/2/3/4/5/6");
        AssertionsForClassTypes.assertThatThrownBy(() -> InputUtility.readLine(Type.LOTTO.getValue()))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("Lotto input 확인- 숫자가 6개가 아닌경우")
    @Test
    void lottoIsNotSix(){
        writeConsole("1,2,3,4,5,6,7");
        AssertionsForClassTypes.assertThatThrownBy(() -> InputUtility.readLine(Type.LOTTO.getValue()))
            .isInstanceOf(IllegalArgumentException.class);
    }
    @DisplayName("Lotto input 확인- 1-45이외의 숫자가 입력된 경우")
    @Test
    void lottoIsOutOfRange(){
        writeConsole("1,2,3,4,5,46");
        AssertionsForClassTypes.assertThatThrownBy(() -> InputUtility.readLine(Type.LOTTO.getValue()))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("Lotto input 확인- 중복된 숫자가 있을 경우 ")
    @Test
    void lottoIsDuplicated(){
        writeConsole("1,1,3,4,5,6");
        AssertionsForClassTypes.assertThatThrownBy(() -> InputUtility.readLine(Type.LOTTO.getValue()))
            .isInstanceOf(IllegalArgumentException.class);
    }
}
