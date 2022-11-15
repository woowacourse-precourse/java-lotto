package lotto.domain;

import lotto.validator.Validator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.*;


class WinningNumsTest {

    @Test
    void 입력받은_당첨_번호의_패턴이_맞는지1() {
        WinningNums winningNums = new WinningNums("1,2,3,4,5,6", "7");
        assertThat(winningNums.getWinningNums()).isEqualTo(List.of(1,2,3,4,5,6));
    }

    @ParameterizedTest
    @ValueSource(strings = {"1, 2,,3, 4, 5, 6 ", "1,2,3,4,5,6,7", "1 2, 3, 4, 5, 6"})
    void 입력받은_당첨_번호의_패턴이_맞는지2(String winNums) {
        assertThatThrownBy(() -> new WinningNums(winNums, "7"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 입력하신 문자열의 패턴이 올바르지 않습니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"1, 2, 3, 4, 5, 6", "15, 13, 17, 14, 25, 6", "41, 42, 43, 44, 45, 46"})
    void 입력받은_당첨_번호가_중복되지_않는지1(String winNums) {
        WinningNums winningNums = new WinningNums(winNums, "7");
        assertThat(Validator.isNotDuplicate(winningNums.getWinningNums())).isEqualTo(true);
    }

    @ParameterizedTest
    @ValueSource(strings = {"2, 2, 3, 4, 5, 6", "13, 13, 17, 14, 25, 6", "42, 42, 43, 44, 45, 46"})
    void 입력받은_당첨_번호가_중복되지_않는지2(String winNums) {
        assertThatThrownBy(() -> new WinningNums(winNums, "7"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 중복된 숫자는 입력할 수 없습니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"1, 2, 3, 4, 5, 6", "1, 13, 17, 14, 25, 6", "1, 42, 43, 44, 45, 46"})
    void 당첨_번호와_보너스_번호가_중복되지_않는지1(String winNums) {
        WinningNums winningNums = new WinningNums(winNums, "7");
        assertThat(Validator.isNotContains(winningNums.getWinningNums(), winningNums.getBonusNum())).isEqualTo(true);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1, 2, 3, 4, 5, 6", "1, 13, 17, 14, 25, 6", "1, 42, 43, 44, 45, 46"})
    void 당첨_번호와_보너스_번호가_중복되지_않는지2(String winNums) {
        assertThatThrownBy(() -> new WinningNums(winNums, "1"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 당첨 숫자와 보너스 숫자가 중복됩니다.");
    }

    @Test
    void 당첨_번호가_범위에_있는지1() {
        WinningNums winningNums = new WinningNums("1, 2, 3, 4, 5, 6", "7");
        assertThat(Validator.isInRangeAll(winningNums.getWinningNums())).isEqualTo(true);
    }

    @ParameterizedTest
    @ValueSource(strings = {"0, 1, 2, 3, 4, 5", "51, 13, 17, 88, 251, 6", "100, 32, 413, 0, 45, 46"})
    void 당첨_번호가_범위에_있는지2(String winNums) {
        assertThatThrownBy(() -> new WinningNums(winNums, "7"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 1-45까지의 숫자만 입력해야 합니다.");
    }

    @Test
    void 보너스_번호가_범위에_있는지1() {
        WinningNums winningNums = new WinningNums("1, 2, 3, 4, 5, 6", "7");
        assertThat(Validator.isInRange(winningNums.getBonusNum())).isEqualTo(true);
    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "46", "100", "413"})
    void 보너스_번호가_범위에_있는지2(String bonusNum) {
        assertThatThrownBy(() -> new WinningNums("1, 2, 3, 4, 5, 6", bonusNum))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 1-45까지의 숫자만 입력해야 합니다.");
    }
}