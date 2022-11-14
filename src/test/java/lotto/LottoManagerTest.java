package lotto;


import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

class LottoManagerTest extends NsTest {
    private static final String ERROR_MESSAGE = "[ERROR]";

    @Test
    @DisplayName("숫자 이외의 값 입력시 예외 반환")
    public void throwExceptionWithIllegalAmount(){
        assertSimpleTest(()->{
            runException("asdf");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    @DisplayName("올바른 구매금액 입력 시 구매 메시지 출력")
    public void printAmountOfLotto(){
        assertSimpleTest(()->{
            run("3000");
            assertThat(output()).contains("3개를 구매했습니다.");
        });
    }


    @Override
    public void runMain() {
        LottoManager lottoManager = new LottoManager();
        lottoManager.buyLotto();
        lottoManager.generateAnswerNumbers();
    }
}