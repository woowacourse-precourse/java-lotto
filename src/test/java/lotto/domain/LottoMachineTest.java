package lotto.domain;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInListTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyList;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import lotto.Application;
import lotto.domain.constants.ErrorCode;
import lotto.domain.vo.Lotto;
import lotto.domain.vo.Money;
import lotto.veiw.InputHandler;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


class LottoMachineTest extends NsTest {


    @DisplayName("Normal BuyLottoList Test")
    @ParameterizedTest(name = "[{index}] input [{0}] ")
    @ValueSource(strings = {"1,2,3,4,5,6", "1,10,20,30,40,45", "40,41,42,43,44,45"})
    void LottoVendingMachine_Test(String inputString) {
        InputHandler inputHandler = new InputHandler();

        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    LottoMachine lottoMachine = new LottoMachine(new Money(1000));
                    for (Lotto lotto : lottoMachine.getBuyLottoList()) {
                        assertThat(lotto.getLottoNumbers()).isEqualTo(
                                inputHandler.stringToList(inputString));
                        System.out.println(lotto.getLottoNumbers());
                    }
                },
                inputHandler.stringToList(inputString)
        );
    }

    @DisplayName("Unvalidated Bill")
    @ParameterizedTest(name = "[{index}] input {0} ")
    @ValueSource(ints = {500, 1234, 1001, 999})
    public void validateRange_0or46_NOTINRANGE(int input) {
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
            new LottoMachine(new Money(input));
        });
        assertEquals(ErrorCode.NOT_BILL.getErrorMessage(), exception.getMessage());
    }

    @Override
    public void runMain() {
    }
}