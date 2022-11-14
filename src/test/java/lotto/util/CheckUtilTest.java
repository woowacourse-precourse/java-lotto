package lotto.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static lotto.util.CheckUtil.*;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


class CheckUtilTest {
    @DisplayName("당첨 번호랑 보너스 번호 중복 테스트")
    @ParameterizedTest
    @CsvSource({"1 ,2, 3, 4, 5, 6, 6"})
    void 당첨_번호랑_보너스_번호_중복_테스트(int num1, int num2, int num3, int num4, int num5, int num6, int num7){
        assertThatThrownBy(() -> checkIsDuplicatedNumbers(Arrays.asList(num1,num2,num3,num4,num5,num6),num7))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("당첨 번호와 보너스 번호가 중복되었습니다.");
    }

    @DisplayName("숫자값만 입력했는지 테스트")
    @Test
    void 숫자값만_입력했는지_테스트(){
        assertThatThrownBy(() -> checkIsString("1000j"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("로또 금액은 숫자여야 합니다.");
    }

    @DisplayName("1000원 단위로 입력했는지 테스트")
    @Test
    void 천원_단위로_입력했는지_테스트(){
        assertThatThrownBy(() -> checkIsDivedByTHOUSAND(1234))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("1000원 단위로만 입력할 수 있습니다.");
    }

    @DisplayName("당첨 번호 범위 테스트")
    @ParameterizedTest
    @CsvSource({"1 ,2, 0","3, 4, -1","5, 6, 46"})
    void 당첨_번호_범위_테스트(int num1, int num2, int num3){
        List<Integer> winning = new ArrayList<>();
        winning.add(num1);
        winning.add(num2);
        winning.add(num3);

        assertThatThrownBy(() -> checkIsValidWinningNumber(winning))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("로또 번호는 1부터 45 사이의 숫자여야 합니다.");

    }

    @DisplayName("보너스 번호 범위 테스트")
    @Test
    void 보너스_번호_범위_테스트(){
        assertThatThrownBy(() -> checkIsValidBonusNumber(46))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("로또 번호는 1부터 45 사이의 숫자여야 합니다.");
    }
}