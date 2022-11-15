package lotto;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.util.List;
import org.junit.jupiter.api.Test;

public class ValidatorTest {

    @Test
    void 숫자_중복_테스트() {
        List<Integer> expectedLotto = List.of(1, 2, 3, 4, 5, 5);
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
            () -> Validator.isDuplicated(expectedLotto));
        assertThat(e.getMessage()).isEqualTo("[ERROR] 숫자가 중복되었습니다.");
    }

    @Test
    void 숫자_길이_테스트() {
        List<Integer> expectedLotto = List.of(1, 2, 3, 4);
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
            () -> Validator.isValidateNumberLength(expectedLotto));
        assertThat(e.getMessage()).isEqualTo("[ERROR] 숫자 개수가 적습니다.");
    }

    @Test
    void 숫자_길이2_테스트() {
        List<Integer> expectedLotto = List.of(1, 2, 3, 4,5,6,7);
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
            () -> Validator.isValidateNumberLength(expectedLotto));
        assertThat(e.getMessage()).isEqualTo("[ERROR] 숫자 개수가 많습니다.");
    }

    @Test
    void 숫자_범위_테스트() {
        int num = 47;
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
            () -> Validator.isValidateNumberRange(num));
        assertThat(e.getMessage()).isEqualTo("[ERROR] 숫자 범위가 유효하지 않습니다.");
    }

    @Test
    void 숫자_공백_테스트() {
        String input ="";
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
            () -> Validator.checkEmpty(input));
        assertThat(e.getMessage()).isEqualTo("[ERROR] 입력한 값이 공백입니다.");
    }

    @Test
    void 숫자_나누기_테스트() {
        String input ="3500";
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
            () -> Validator.checkThousandsDivided(input));
        assertThat(e.getMessage()).isEqualTo("[ERROR] 로또 구입 금액이 1000으로 나누어 떨어지지 않습니다");
    }

}
