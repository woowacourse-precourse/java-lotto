package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ApplicationTest extends NsTest {
    private static final String ERROR_MESSAGE = "[ERROR]";

    @Test
    void 기능_테스트() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("8000", "1,2,3,4,5,6", "7");
                    assertThat(output()).contains(
                            "8개를 구매했습니다.",
                            "[8, 21, 23, 41, 42, 43]",
                            "[3, 5, 11, 16, 32, 38]",
                            "[7, 11, 16, 35, 36, 44]",
                            "[1, 8, 11, 31, 41, 42]",
                            "[13, 14, 16, 38, 42, 45]",
                            "[7, 11, 30, 40, 42, 43]",
                            "[2, 13, 22, 32, 38, 45]",
                            "[1, 3, 5, 14, 22, 45]",
                            "3개 일치 (5,000원) - 1개",
                            "4개 일치 (50,000원) - 0개",
                            "5개 일치 (1,500,000원) - 0개",
                            "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개",
                            "6개 일치 (2,000,000,000원) - 0개",
                            "총 수익률은 62.5%입니다."
                    );
                },
                List.of(8, 21, 23, 41, 42, 43),
                List.of(3, 5, 11, 16, 32, 38),
                List.of(7, 11, 16, 35, 36, 44),
                List.of(1, 8, 11, 31, 41, 42),
                List.of(13, 14, 16, 38, 42, 45),
                List.of(7, 11, 30, 40, 42, 43),
                List.of(2, 13, 22, 32, 38, 45),
                List.of(1, 3, 5, 14, 22, 45)
        );
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() -> {
            runException("1000j");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    void 당첨번호_테스트() {
        //given
        String number = "1,2,3,4,5,6";

        List<Integer> winningNumbers = lotto.Buy.makeWinningNumbers(number);

        List<Integer> test =  List.of(1, 2, 3, 4, 5, 6);

        assertThat(winningNumbers).isEqualTo(test);


    }

    @Test
    void 당첨번호_중복_예외_테스트() {
        //given
        String number = "1,2,3,4,6, 6";

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            lotto.Buy.makeWinningNumbers(number);
        });



    }

    @Test
    @DisplayName("천원단위가 아니면 예외 발생")
    void 주문_테스트() {
        Long money = 11010L;

        Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
            validate.Check.countLottoTicket(money);
        });

        assertEquals("[ERROR] 올바른 금액이 아닙니다. (지폐만 가능)", exception.getMessage());

    }

    @Test
    void 당첨번호_숫자_크기_테스트() {
        String number = "1,2,3,4,5";

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            lotto.Buy.makeWinningNumbers(number);
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
