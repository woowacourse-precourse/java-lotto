package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import lotto.Service.LottoNumberService;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;

public class LottoNumberTest extends NsTest{
    private static final String ERROR_MESSAGE = "[ERROR]";

    @Test
    void 구매금액_영어입력시_예외_테스트() {
        assertSimpleTest(() -> {
            runException("abc");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }
    @Test
    void 구매금액_한글입력시_예외_테스트() {
        assertSimpleTest(() -> {
            runException("가나다");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }
    @Test
    void 구매금액_영어숫자_혼합입력시_예외_테스트() {
        assertSimpleTest(() -> {
            runException("1a2b3c4");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }
    @Test
    void 구매금액_1000의배수_예외_테스트() {
        assertSimpleTest(() -> {
            runException("2500");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }
    @Test
    void 구매금액_성공_테스트() {
        //todo
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}



