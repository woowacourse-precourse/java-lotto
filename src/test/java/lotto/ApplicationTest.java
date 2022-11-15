package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

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

    @DisplayName("플레이어가 입력한 6개의 숫자가 1~45범위밖이라면 에러메시지 프린트.")
    @Test
    void printErrorMessageIfNotInRange() {
        assertSimpleTest(() -> {
            Assertions.assertThrows(IllegalArgumentException.class, () -> {
                run("8000", "1,2,0,4,5,50", "10");
            });
        });
    }

    @DisplayName("보너스 숫자가 1~45범위밖이라면 IllegalArgumentException 발생.")
    @Test
    void validateBonusNumber() {
        assertSimpleTest(() -> {
            Assertions.assertThrows(IllegalArgumentException.class, () -> {
                run("8000", "1,2,3,4,5,6", "55");
            });
        });
    }

    @DisplayName("구입 금액이 로또 금액인 1000으로 나누어지지 않으면 예외 발생.")
    @Test
    void validateTheEnteredAmount() {
        final String INVALID_NUMBER = "1234";
        InputStream in = new ByteArrayInputStream(INVALID_NUMBER.getBytes());
        System.setIn(in);
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Application.setInitialNumber();
            Application.setNumberOfPurchasedLotto();
        });
    }

    @DisplayName("보너스 숫자가 1~45범위밖이라면 에러메시지 프린트.")
    @Test
    void bonusNumberNotInRange() {
        assertSimpleTest(() -> {
            try {
                run("3000", "1,2,3,4,5,6", "52");
            } catch (IllegalArgumentException e) {
                assertThat(output().contains(ERROR_MESSAGE));
            }
        });
    }

    @DisplayName("플레이어가 입력한 6개의 숫자가 1~45범위밖이라면 IllegalArgumentException 발생.")
    @Test
    void validateTheRangeOfEnteredNumbers() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    Assertions.assertThrows(IllegalArgumentException.class, () -> {
                        run("8000", "1,2,0,4,5,50", "10");
                    });
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

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
