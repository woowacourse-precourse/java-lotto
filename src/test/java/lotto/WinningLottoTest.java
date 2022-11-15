package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;

public class WinningLottoTest {
    @Test
    @DisplayName("보너스 번호가 당첨 번호에 이미 있을 경우 예외 발생")
    void 보너스_번호_중복_예외_테스트(){
        List<Integer> lottoNums = Arrays.asList(1,2,3,4,5,6);
        Assertions.assertThatThrownBy(()->new WinningNumber(new Lotto(lottoNums),6)).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @DisplayName("보너스 번호가 1~45 사이의 수가 아닐 경우 예외 발생")
    @ValueSource(ints = {0,46})
    void 보너스_번호_범위_예외_테스트(int bonus){
        List<Integer> lottoNums = Arrays.asList(1,2,3,4,5,6);
        Assertions.assertThatThrownBy(()->new WinningNumber(new Lotto(lottoNums),bonus)).isInstanceOf(IllegalArgumentException.class);
    }
}
