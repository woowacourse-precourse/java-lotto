package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputLottoTest {
    static InputLotto inputLotto;

    @BeforeAll
    static void initAll() {
        inputLotto = new InputLotto();
    }

    @DisplayName("구매 금액 입력 시 숫자가 아닌 값을 넣으면 IllegalArgumentException 이 발생합니다.")
    @Test
    void inputMoneyTest1() {
        String input = "wrong";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertThatIllegalArgumentException().isThrownBy(() -> inputLotto.inputMoney());
    }

    @DisplayName("구매 금액 입력 시 1000단위 숫자가 아닌 값을 넣으면 IllegalArgumentException 이 발생합니다.")
    @Test
    void inputMoneyTest2() {
        String input = "12450";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertThatIllegalArgumentException().isThrownBy(() -> inputLotto.inputMoney());
    }

    @DisplayName("구매 금액 입력 시 정확한 값을 넣으면 그 값을 Integer 로 반환합니다.")
    @Test
    void inputMoneyTest3() {
        String input = "12000";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        inputLotto.inputMoney();
        assertThat(inputLotto.money).isEqualTo(12000);
    }

    @DisplayName("당첨 번호 입력 시 정확한 입력값은 List 로 변환해 반환합니다.")
    @Test
    void inputWinNumberTest1() {
        String input = "1,2,3,4,5,6";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        List<Integer> expect = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        inputLotto.inputWinNumber();
        assertThat(inputLotto.winNumbers).isEqualTo(expect);
    }

    @DisplayName("당첨 번호 입력시 숫자 구분시 ',' 이 아닌 다른것을 사용하면 IllegalArgumentException 이 발생합니다.")
    @Test
    void inputWinNumberTest2() {
        String input = "1.2,3,4,5,6";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertThatIllegalArgumentException().isThrownBy(() -> inputLotto.inputWinNumber());
    }

    @DisplayName("당첨 번호 입력시 1~45 사이 이외의 숫자를 넣으면 IllegalArgumentException 이 발생합니다.")
    @Test
    void inputWinNumberTest3() {
        String input = "123,2,3,4,5,6";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertThatIllegalArgumentException().isThrownBy(() -> inputLotto.inputWinNumber());
    }

    @DisplayName("당첨 번호 입력시 숫자 이외 다른것을 넣으면 IllegalArgumentException 이 발생합니다.")
    @Test
    void inputWinNumberTest4() {
        String input = "s,2,3,4,5,6";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertThatIllegalArgumentException().isThrownBy(() -> inputLotto.inputWinNumber());
    }

    @DisplayName("당첨 번호 입력시 6개 초과의 숫자를 넣으면 IllegalArgumentException 이 발생합니다.")
    @Test
    void inputWinNumberTest5() {
        String input = "1,2,3,4,5,6,7";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertThatIllegalArgumentException().isThrownBy(() -> inputLotto.inputWinNumber());
    }

    @DisplayName("당첨 번호 입력시 중복된 숫자를 넣으면 IllegalArgumentException 이 발생합니다.")
    @Test
    void inputWinNumberTest6() {
        String input = "1,1,3,4,5,6";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertThatIllegalArgumentException().isThrownBy(() -> inputLotto.inputWinNumber());
    }

    @DisplayName("보너스번호 입력시 정환한 값은 int 로 변환해 반환합니다.")
    @Test
    void inputBonusNumberTest1() {
        List<Integer> winNumbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        String input = "7";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        inputLotto.inputBonusNumber(winNumbers);
        assertThat(inputLotto.bonusNumber).isEqualTo(7);
    }

    @DisplayName("보너스 번호 입력 시 숫자 이외의 다른것을 넣으면 IllegalArgumentException 이 발생합니다.")
    @Test
    void inputBonusNumberTest2() {
        List<Integer> winNumbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        String input = "s";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertThatIllegalArgumentException().isThrownBy(() -> inputLotto.inputBonusNumber(winNumbers));
    }

    @DisplayName("보너스 번호 입력 시 숫자 이외의 다른것을 넣으면 IllegalArgumentException 이 발생합니다.")
    @Test
    void inputBonusNumberTest3() {
        List<Integer> winNumbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        String input = "23,";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertThatIllegalArgumentException().isThrownBy(() -> inputLotto.inputBonusNumber(winNumbers));
    }

    @DisplayName("보너스 번호 입력 시 1~45 범위 밖의 숫자를 넣으면 IllegalArgumentException 이 발생합니다.")
    @Test
    void inputBonusNumberTest4() {
        List<Integer> winNumbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        String input = "46";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertThatIllegalArgumentException().isThrownBy(() -> inputLotto.inputBonusNumber(winNumbers));
    }

    @DisplayName("보너스 번호 입력 시 1~45 범위 밖의 숫자를 넣으면 IllegalArgumentException 이 발생합니다.")
    @Test
    void inputBonusNumberTest5() {
        List<Integer> winNumbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        String input = "0";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertThatIllegalArgumentException().isThrownBy(() -> inputLotto.inputBonusNumber(winNumbers));
    }

    @DisplayName("보너스 번호 입력 시 당첨 번호와 중복되는 숫자를 넣으면 IllegalArgumentException 이 발생합니다.")
    @Test
    void inputBonusNumberTest6() {
        List<Integer> winNumbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        String input = "1";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertThatIllegalArgumentException().isThrownBy(() -> inputLotto.inputBonusNumber(winNumbers));
    }
}