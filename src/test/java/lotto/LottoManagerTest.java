package lotto;


import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoManagerTest extends NsTest {

    @Test
    @DisplayName("숫자 이외의 값 입력시 예외 반환")
    public void throwExceptionWithIllegalAmount(){
            assertThatThrownBy(()->run("asdf")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("올바른 구매금액 입력 시 구매 메시지 출력")
    public void printAmountOfLotto(){
        assertSimpleTest(()->{
            run("3000", "2,3,4,5,6,7", "1");
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