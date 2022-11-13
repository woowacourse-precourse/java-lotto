package system.process;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import system.process.exception.IllegalArgument;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class WinningLottoRegisterTest extends NsTest {

    @DisplayName("당첨 번호 입력의 길이가 최대 길이인 17을 넘어 간다면 예외 발생.")
    @Test
    void inputOutOfLengthNumbers(){
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("11,12,13,14,15,161"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(IllegalArgument.OUT_OF_NUMBERS_LENGTH.getMessage())
        );
    }

    @DisplayName("당첨 번호의 입력 양식(번호와 쉼표를 번갈아가면서 씀)이 잘못 되었다면 예외 발생.")
    @Test
    void inputWrongWinningNumbers(){
        //중간에 쉼표가 2개
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("11,12,,13,14,15,6"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(IllegalArgument.WRONG_NUMBERS_INPUT.getMessage())
        );
        //중간에 쉼표가 3개
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("11,1,,,13,14,15,6"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(IllegalArgument.WRONG_NUMBERS_INPUT.getMessage())
        );
        //끝에 쉼표가 2개
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("11,12,13,14,15,,"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(IllegalArgument.WRONG_NUMBERS_INPUT.getMessage())
        );
        //처음에 쉼표가 2개
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(",,12,13,14,15,16"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(IllegalArgument.WRONG_NUMBERS_INPUT.getMessage())
        );
        //숫자가 5개로 부족
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("12,13,14,15,16"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(IllegalArgument.WRONG_NUMBERS_INPUT.getMessage())
        );
        //숫자 5개에 끝에 쉼표 1개
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("12,13,14,15,16,"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(IllegalArgument.WRONG_NUMBERS_INPUT.getMessage())
        );
    }

    @DisplayName("보너스 번호의 입력 양식(두 자리 숫자만 가능)이 잘못 되었다면 예외 발생.")
    @Test
    void inputWrongWinningBonusNumber(){
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("11,12,13,14,15,16","100"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(IllegalArgument.OUT_OF_BONUS_NUMBER_LENGTH.getMessage())
        );
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("11,12,13,14,15,16","1,"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(IllegalArgument.WRONG_NUMBERS_INPUT.getMessage())
        );
    }

    @Override
    protected void runMain(){
        WinningLottoRegister winningLottoRegister = new WinningLottoRegister();
    }
}
