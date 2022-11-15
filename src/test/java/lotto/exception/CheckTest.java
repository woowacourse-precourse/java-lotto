package lotto.exception;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Check 테스트")
class CheckTest {
    private static final List<Integer> lotto = List.of(1, 2, 3, 4, 5, 6);
    private static final List<Integer> lotto2 = List.of(1, 2, 3, 4, 5, 5);
    private static final List<Integer> lotto3 = List.of(1, 2, 3, 4, 5, 55);
    private static final int number = 7;
    private static final int duplicateNumber = 1;
    private static final int rangeNumber = 55;
    private Check check;

    @BeforeEach
    void setUp() {
        check = new Check();
    }

    @DisplayName("true case: 로또 중복 번호 검사 테스트")
    @Test
    void lottoCheckDuplicate() {
        boolean checkDuplicate = check.checkDuplicate(lotto);
        assertThat(checkDuplicate).isEqualTo(true);
    }

    @DisplayName("false case: 로또 중복 번호 검사 테스트")
    @Test
    void lottoCheckDuplicate2() {
        boolean checkDuplicate = check.checkDuplicate(lotto2);
        assertThat(checkDuplicate).isEqualTo(false);
    }

    @DisplayName("true case: 보너스 번호 중복 검사 테스트")
    @Test
    void plusLottoCheckDuplicate() {
        boolean checkDuplicate = check.checkDuplicate(lotto, number);
        assertThat(checkDuplicate).isEqualTo(true);
    }

    @DisplayName("false case: 보너스 번호 중복 검사 테스트")
    @Test
    void plusLottoCheckDuplicate2() {
        boolean checkDuplicate = check.checkDuplicate(lotto, duplicateNumber);
        assertThat(checkDuplicate).isEqualTo(false);
    }

    @DisplayName("true case: 로또 범위 테스트")
    @Test
    void lottoCheckRange() {
        boolean checkRange = check.checkRange(lotto);
        assertThat(checkRange).isEqualTo(true);
    }

    @DisplayName("false case: 로또 범위 테스트")
    @Test
    void lottoCheckRange2() {
        boolean checkRange = check.checkRange(lotto3);
        assertThat(checkRange).isEqualTo(false);
    }

    @DisplayName("true case: 보너스 번호 범위 테스트")
    @Test
    void plusLottoCheckRange() {
        boolean checkRange = check.checkRange(number);
        assertThat(checkRange).isEqualTo(true);
    }

    @DisplayName("false case: 보너스 번호 범위 테스트")
    @Test
    void plusLottoCheckRange2() {
        boolean checkRange = check.checkRange(rangeNumber);
        assertThat(checkRange).isEqualTo(false);
    }

    @DisplayName("true case: 1000으로 나누었을때 나머지 존재 테스트")
    @Test
    void haveRest() {
        boolean haveRest = check.haveRest(1001);
        assertThat(haveRest).isEqualTo(true);
    }
}