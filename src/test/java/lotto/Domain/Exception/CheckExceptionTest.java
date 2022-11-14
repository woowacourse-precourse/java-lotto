package lotto.Domain.Exception;

import lotto.Input.LottoValue;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class CheckExceptionTest {
    SoftAssertions softAssertions = new SoftAssertions();
    CheckException checkException = new CheckException();
    @DisplayName("int로 잘 변환하는가, 문자가 있으면 예외 발생하는가")
    @Test
    void createIntValue() {
        String strNoraml = "5";
        String strError = "as11";

        softAssertions
                .assertThat(checkException.check_HaveChar_And_Convert(strNoraml))
                .isEqualTo(5);
        softAssertions
                .assertThatThrownBy(() -> checkException.check_HaveChar_And_Convert(strError))
                .isInstanceOf(IllegalArgumentException.class);

        softAssertions.assertAll();
    }

    @DisplayName("1에서 45 밖의 숫자를 입력하면 예외 발생하는가")
    @Test
    void createOutOfRange() {
        int normal = 35;
        int outOfMax = 47;
        int outOfMin = 0;

        softAssertions
                .assertThat(checkException.check_OutOfRange(normal))
                .isEqualTo(normal);
        softAssertions
                .assertThatThrownBy(() -> checkException.check_OutOfRange(outOfMax))
                .isInstanceOf(IllegalArgumentException.class);
        softAssertions
                .assertThatThrownBy(() -> checkException.check_OutOfRange(outOfMin))
                .isInstanceOf(IllegalArgumentException.class);

        softAssertions.assertAll();
    }

    @DisplayName("1000으로 나누어 떨어지지 않으면 예외 발생하는가")
    @Test
    void createDivideError() {
        int normal = 10000;
        int thousandError = 1001;

        softAssertions
                .assertThat(checkException.check_Thousand(normal))
                .isEqualTo(normal);
        softAssertions
                .assertThatThrownBy(() -> checkException.check_Thousand(thousandError))
                .isInstanceOf(IllegalArgumentException.class);

        softAssertions.assertAll();
    }

    @DisplayName("로또 발행 수량이 맞지 않으면 예외 발생하는가")
    @Test
    void createSizeError() {
        int normal = LottoValue.SIZE_No_Bonus.getNum();
        int sizeError = LottoValue.SIZE_YES_BONUS.getNum();

        softAssertions
                .assertThat(checkException.check_LottoSize(normal))
                .isEqualTo(normal);
        softAssertions.
                assertThatThrownBy(() -> checkException.check_LottoSize(sizeError))
                .isInstanceOf(IllegalArgumentException.class);

        softAssertions.assertAll();
    }

    @DisplayName("리스트에 추가된 숫자가 기존 리스트 숫자와 중복되면 예외 발생")
    @Test
    void createAddedNumIsOverlaped() {
        List<Integer> compareNumsNormal = List.of(1,2,3,4,5,6,7);
        List<Integer> compareNumsError = List.of(1,2,3,4,5,6,6);

        softAssertions
                .assertThat(checkException.check_ListWithBonusNumSizeIsSeven(compareNumsNormal))
                .as("정상")
                .isEqualTo(LottoValue.SIZE_YES_BONUS.getNum());

        softAssertions.
                assertThatThrownBy(() -> checkException.check_ListWithBonusNumSizeIsSeven(compareNumsError))
                .as("에러")
                .isInstanceOf(IllegalArgumentException.class);

        softAssertions.assertAll();
    }

    @DisplayName("리스트 안에 중복된 숫자가 있는가")
    @Test
    void createOverlapErrorInList() {
        List<Integer> normal = List.of(1,2,3,4,5,6);
        List<Integer> error = List.of(1,2,3,4,5,5);

        softAssertions
                .assertThat(checkException.check_ListHaveNoOverlapNum(normal))
                .isEqualTo(normal.size());

        softAssertions.
                assertThatThrownBy(() -> checkException.check_ListHaveNoOverlapNum(error))
                .isInstanceOf(IllegalArgumentException.class);

        softAssertions.assertAll();
    }
}
