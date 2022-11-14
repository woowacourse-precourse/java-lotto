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

    @Test
    @DisplayName("구입금액이 1000으로 나누어 떨어지지 않으면 예외가 발생한다.")
    void inputNotDevidedBy1000() {
        int money = 1100;
        assertThatThrownBy(() -> Application.validate(money))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("구입금액만큼 로또를 구입한다.")
    void perchaseLottoByNumberOfLotto() {
        int numberOfLotto = 10;
        assertThat(Application.perchaseLotto(numberOfLotto).size())
                .isEqualTo(numberOfLotto);
    }

    @Test
    @DisplayName("입력받은 로또 번호로 리스트 생성")
    void createList() {
        String inputNumbers = "1, 2, 3, 4, 5, 6";
        assertThat(Application.stringToList(inputNumbers))
                .isEqualTo(List.of(1, 2, 3, 4, 5,6));
    }

    @Test
    @DisplayName("각 등수의 로또 개수 측정")
    void countRank() {
        Lotto winningLotto = new Lotto(List.of(5, 9, 14, 15, 35, 44));
        List<Lotto> lottos = new ArrayList<>(List.of(new Lotto(List.of(2, 10, 20, 26, 40, 43)),
                new Lotto(List.of(3, 13, 18, 32, 33, 39)),
                new Lotto(List.of(7, 9, 12, 15, 24, 44)),
                new Lotto(List.of(10, 11, 12, 24, 25, 39))));
        int bonusNumber = 10;

        assertThat(Application.rank(lottos, winningLotto, bonusNumber)).isEqualTo(List.of(0, 0, 0, 0, 1));
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
