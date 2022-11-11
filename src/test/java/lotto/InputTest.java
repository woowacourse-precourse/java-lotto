package lotto;

import lotto.domain.Input;
import org.assertj.core.api.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

/**
 * packageName : lotto
 * fileName : InputTest
 * author : gim-yeong-geun
 * date : 2022/11/10
 * description :
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022/11/10         gim-yeong-geun          최초 생성
 */
public class InputTest {
    @DisplayName("문자를 입력하면 오류가 발생한다")
    @Test
    void coinStringErrorTest(){
        assertThatThrownBy(() -> Input.coinStringError("1000j"))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @DisplayName("1000원 단위 미만의 금액을 입력시 오류가 발생한다")
    @Test
    void inputCoinTest(){
        assertThatThrownBy(() -> Input.coinError(11100))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호를 입력시 배열로 변환한다")
    @Test
    void inputWinningNumberToArrayTest(){
        String input_num = "1,2,3,4,5,6";
        InputStream in = new ByteArrayInputStream(input_num.getBytes());
        System.setIn(in);
        List<Integer> result = Input.inputWinningNumber();
        assertThat(result).contains(1,2,3,4,5,6);
    }

    @DisplayName("보너스 번호 입력 여부 테스트")
    @Test
    void inputBonusNumberInputTest(){
        String input_num = "1";
        InputStream in = new ByteArrayInputStream(input_num.getBytes());
        System.setIn(in);
        int result = Input.inputBonusNumber();
        assertThat(result).isEqualTo(1);
    }

    @DisplayName("보너스 범위에러가 생긴다")
    @Test
    void bonusRangeErrorTest(){
        assertThatThrownBy(() -> Input.bonusRangeError(46))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 당첨 번호와 중복 에러가 생긴다")
    @Test
    void bonusDupleErrorTest(){
        List<Integer> testList = Arrays.asList(1,2,3,4,5,6);
        assertThatThrownBy(() -> Input.bonusDupleError(testList,1))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
