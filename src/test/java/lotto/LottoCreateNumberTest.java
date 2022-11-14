package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class LottoCreateNumberTest extends NsTest {
    private static final String ERROR_MESSAGE = "[ERROR]";


    @DisplayName("오름 차순으로 정렬되는가?")
    @Test
    void 오름_차순() {
        String testNumber = "21,1,34,45,11,8";
        LottoCreateNumber lottoCreateNumber = new LottoCreateNumber(testNumber);
        List<Integer> result = new ArrayList<>(Arrays.asList(1, 8, 11, 21, 34, 45));
        assertThat(lottoCreateNumber.getCreateNumber()).isEqualTo(result);
    }


    @DisplayName("숫자의 범위는 1-45 입니다.")
    @Test
    void 숫자_범위() {
        assertThatThrownBy(() -> {
            String testNumber = "46,1,34,45,11,8";
            LottoCreateNumber lottoCreateNumber = new LottoCreateNumber(testNumber);
        }).hasMessageContaining(ERROR_MESSAGE)
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> {
            String testNumber = "0,1,2,3,4,5";
            LottoCreateNumber lottoCreateNumber = new LottoCreateNumber(testNumber);
        }).hasMessageContaining(ERROR_MESSAGE)
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("숫자만 입력 가능합니다.")
    @Test
    void 숫자만_입력하였는가() {
        assertThatThrownBy(() -> {
            String testNumber = "a,1,34,45,11,8";
            LottoCreateNumber lottoCreateNumber = new LottoCreateNumber(testNumber);
        }).hasMessageContaining(ERROR_MESSAGE)
                .isInstanceOf(IllegalArgumentException.class);


    }

    @Override
    protected void runMain() {

    }
}