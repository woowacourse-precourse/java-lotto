package lotto;

import org.junit.jupiter.api.*;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import camp.nextstep.edu.missionutils.test.NsTest;

import java.util.List;
import java.util.ArrayList;
import java.math.BigInteger;

class LottoBuyerTest extends NsTest{

    public static String ERROR_MESSAGE = "[ERROR]";
    private LottoBuyer lottoBuyerTest = new LottoBuyer();
    //성공했을때 확인 필요
    @Test
    @DisplayName("로또를 구매할 돈을 잘못 입력할 시 예외 확인")
    void 로또를_구매할_돈을_입력_테스트(){

        assertThatThrownBy(() ->run("8000j"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);

        assertThatThrownBy(() ->run("-8000"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);

        assertThatThrownBy(() ->run("1200"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);
    }

    @Test
    @DisplayName("로또의 번호를 잘못 입력 시 예외 발생 예외 확인")
    void 로또_번호_입력_테스트(){
        assertThatThrownBy(() -> run("1,2,3,4,5,6"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);
    }

    public void runMain() {
        //lottoBuyerTest.setMoney();
        lottoBuyerTest.setLottoNumbers();
    }
}