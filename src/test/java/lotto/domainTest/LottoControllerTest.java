package lotto.domainTest;

import lotto.domain.LottoController;
import lotto.ui.Messages;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;


public class LottoControllerTest {
    private static LottoController controller = new LottoController();

    @Test
    @DisplayName("Lotto 입력이 숫자가 아닌 경우 예외반환")
    void numericTest() {
        //given(준비)
        String input = "a,b,c,d,e,f";
        InputStream in = new ByteArrayInputStream(input.getBytes());

        //when(실행)
        System.setIn(in);

        //then(검증)
        try {
            controller.initLotto();
        } catch (Exception e) {
            Assertions.assertThat(e.getMessage()).isEqualTo(Messages.ERROR_LIST_NUMERIC.getMessage());
        }
    }

    @Test
    @DisplayName("Lotto 입력이 중복된 경우 예외반환")
    void duplicateTest() {
        //given(준비)
        String input = "1,1,1,2,3,4";
        InputStream in = new ByteArrayInputStream(input.getBytes());

        //when(실행)
        System.setIn(in);

        //then(검증)
        try {
            controller.initLotto();
        } catch (Exception e) {
            Assertions.assertThat(e.getMessage()).isEqualTo(Messages.ERROR_LOTTO_DUPLICATE.getMessage());
        }
    }

    @Test
    @DisplayName("Lotto 입력 범위가 벗어난 경우 예외 반환")
    void outOfRangeTest() {
        //given(준비)
        String input = "0,1,2,3,4,56";
        InputStream in = new ByteArrayInputStream(input.getBytes());

        //when(실행)
        System.setIn(in);

        //then(검증)
        try {
            controller.initLotto();
        } catch (Exception e) {
            Assertions.assertThat(e.getMessage()).isEqualTo(Messages.ERROR_LOTTO_NUMBER_RANGE.getMessage());
        }
    }

    @Test
    @DisplayName("Lotto 입력 개수가 초과한 경우 예외 반환")
    void outOfSizeTest() {
        //given(준비)
        String input = "1,2,3,4,5,6,7,8";
        InputStream in = new ByteArrayInputStream(input.getBytes());

        //when(실행)
        System.setIn(in);

        //then(검증)
        try {
            controller.initLotto();
        } catch (Exception e) {
            Assertions.assertThat(e.getMessage()).isEqualTo(Messages.ERROR_LOTTO_SIZE.getMessage());
        }
    }

    @Test
    @DisplayName("구매 금액이 1000단위가 아닌 경우 예외 반환")
    void unitTest() {
        //given(준비)
        String input = "1050";
        InputStream in = new ByteArrayInputStream(input.getBytes());

        //when(실행)
        System.setIn(in);

        //then(검증)
        try {
            controller.initUserLotto();
        } catch (Exception e) {
            Assertions.assertThat(e.getMessage()).isEqualTo(Messages.ERROR_MONEY_UNIT.getMessage());
        }
    }

    @Test
    @DisplayName("구매 금액이 1000보다 작을경우 예외 반환")
    void underPriceTest() {
        //given(준비)
        String input = "900";
        InputStream in = new ByteArrayInputStream(input.getBytes());

        //when(실행)
        System.setIn(in);

        //then(검증)
        try {
            controller.initUserLotto();
        } catch (Exception e) {
            Assertions.assertThat(e.getMessage()).isEqualTo(Messages.ERROR_MONEY_MIN.getMessage());
        }
    }

    @Test
    @DisplayName("보너스 번호가 당첨번호와 중복되는 경우 예외 반환")
    void bonusNumberDuplicateTest() {
        //given(준비)
        String input = "6";
        initLotto();

        InputStream in = new ByteArrayInputStream(input.getBytes());

        //when(실행)
        System.setIn(in);

        //then(검증)
        try {
            controller.initBonusNumber();
        } catch (Exception e) {
            Assertions.assertThat(e.getMessage()).isEqualTo(Messages.ERROR_BONUS_DUPLICATE.getMessage());
        }
    }

    @Test
    @DisplayName("보너스 번호의 범위가 초과한 경우 예외 반환")
    void bonusNumberRangeTest() {
        //given(준비)
        String input = "46";

        InputStream in = new ByteArrayInputStream(input.getBytes());
        initLotto();

        //when(실행)
        System.setIn(in);

        //then(검증)
        try {
            controller.initBonusNumber();
        } catch (Exception e) {
            Assertions.assertThat(e.getMessage()).isEqualTo(Messages.ERROR_LOTTO_NUMBER_RANGE.getMessage());
        }
    }

    @Test
    @DisplayName("입력한 보너스 번호가 숫자가 아닌 경우 예외 반환")
    void bonusNumericTest() {
        //given(준비)
        String input = "a,2";

        InputStream in = new ByteArrayInputStream(input.getBytes());
        initLotto();

        //when(실행)
        System.setIn(in);

        //then(검증)
        try {
            controller.initBonusNumber();
        } catch (Exception e) {
            Assertions.assertThat(e.getMessage()).isEqualTo(Messages.ERROR_NUMERIC.getMessage());
        }
    }

    public static void initLotto() {
        String input = "1,2,3,4,5,6";

        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        controller.initLotto();
    }
}
