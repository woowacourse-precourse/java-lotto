package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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

    @DisplayName("구입금액이 숫자가 아니면 예외가 발생한다.")
    @Test
    void inputNotNumber() {
        assertSimpleTest(() -> {
            runException("abcd");
            assertThat(output()).contains("입력값이 숫자가 아닙니다.");
        });
    }

    @DisplayName("구입금액이 범위를 벗어나면 예외가 발생한다.")
    @Test
    void inputOutOfScope() {
        assertSimpleTest(() -> {
            runException("0");
            assertThat(output()).contains("입력값이 범위를 벗어났습니다.");
        });
    }

    @DisplayName("구입금액이 1,000원으로 나누어 떨어지지 않으면 예외가 발생한다.")
    @Test
    void inputNotMultipleOf1000() {
        assertSimpleTest(() -> {
            runException("3003");
            assertThat(output()).contains("입력값이 1,000원으로 나누어 떨어지지 않습니다.");
        });
    }

    @Test
    void 오름차순_테스트() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("2000", "1,2,3,4,5,6", "7");
                    assertThat(output()).contains(
                            "[8, 21, 23, 41, 42, 43]",
                            "[3, 5, 11, 16, 32, 38]"
                    );
                },
                List.of(21, 23, 8, 43, 42, 41),
                List.of(32, 5, 16, 11, 3, 38)
        );
    }

    @DisplayName("보너스 번호가 1부터 45 사이의 숫자가 아니면 예외가 발생한다.")
    @Test
    void createBonusOutOfScope() {
        assertSimpleTest(() -> {
            runException("7000", "1,2,3,4,5,6", "47");
            assertThat(output()).contains("보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
        });
    }

    @DisplayName("보너스 번호가 당첨 번호와 중복된다면 예외가 발생한다.")
    @Test
    void createBonusByDuplicatedNumber() {
        assertSimpleTest(() -> {
            runException("1000", "1,2,3,4,5,6", "3");
            assertThat(output()).contains("로또 번호와 보너스 번호는 중복되지 않아야 합니다.");
        });
    }

    @Test
    void 일치하는_숫자_개수_테스트() {
        Lotto lotto=new Lotto(List.of(3,4,5,6,7,8));
        int result=Application.countSameNum(List.of(1,2,3,4,5,6),lotto,10);
        assertThat(result).isEqualTo(4);
    }

    @Test
    void 당첨_로또_개수_테스트() {
        Lotto lotto=new Lotto(List.of(3,4,5,6,7,8));
        List<List<Integer>> userNumber=new ArrayList<>();
        List<Integer> result;
        userNumber.add(List.of(1,5,6,8,23,30));
        userNumber.add(List.of(3,4,5,6,11,30));
        result=Application.getNumberOfWin(userNumber,lotto,10);
        assertThat(result).isEqualTo(List.of(0,0,0,1,1,0,0,0));
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
