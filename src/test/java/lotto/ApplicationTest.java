package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import validate.Check;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
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
    @DisplayName("천원단위가 아니면 예외 발생")
    void 주문_테스트() {
        Long money = 11010123456L;

        Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
            validate.Check.countLottoTicket(money);
        });

        assertEquals("[ERROR] 올바른 금액을 투입해 주세요 (지폐만 가능)", exception.getMessage());

    }

    @Test
    void 당첨번호_중복_테스트() {
        List<String> numbers = List.of("1", "2", "3", "4", "5", "5");

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Check.numberDuplicate(numbers);
        });
    }

    @Test
    @DisplayName("당첨번호가 6개가 아니면 예외 발생")
    void winningNumberCount() {
        List<String> numbers = List.of("1", "2", "3", "4", "5");

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Check.winningNumberCount(numbers);
        });
    }

    @Test
    @DisplayName("보너스번호가 1개가 아니면 예외 발생")
    void bonusNumberCount() {
        List<String> numbers = List.of("1", "2", "3", "4", "5");

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Check.bonusNumberCount(numbers);
        });
    }

    @Test
    @DisplayName("돈 입력값이 숫자가 아니면 오류 발생")
    void isNumber_money() {
        String numbers = "1000원";

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Check.isNumber(numbers);
        });
    }

    @Test
    @DisplayName("당첨번호 콤마 이외에 숫자가 아닌 문자가 들어오면 예외 발생")
    void isNumber_winning() {
        List<String> numbers = List.of("1", "2", "a", "4", "5");

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Check.isNumber(numbers);
        });
    }

    @Test
    @DisplayName("당첨번호 , 보너스번호가 1~45사이가 아니면 예외 발생")
    void rightRange() {
        List<String> numbers = List.of("0", "1", "2", "3", "4", "5");

        int startNumber = 1;
        int finishNumber = 45;

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Check.rightRange(numbers, startNumber, finishNumber);
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
