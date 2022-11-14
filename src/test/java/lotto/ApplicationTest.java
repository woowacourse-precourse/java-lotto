package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

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

    @DisplayName("로또를 생성한 번호가 중복이 있는지 확인한다.")
    @Test
    void createLottoByDistinctNumber() {
        Application application = new Application();
        List<Integer> number = application.createLotto();
        Set<Integer> result = new HashSet<>(number);

        assertThat(number.size()).isEqualTo(result.size());
    }

    @DisplayName("로또 번호 발급 금액이 1000원 단위가 아니면 예외가 발생한다.")
    @Test
    void saveLottoByWrongMoneyUnit() {
        Application application = new Application();
        int money = 12345;

        assertThatThrownBy(() -> application.saveLotto(money))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호 발급 개수가 금액의 개수와 같은지 확인한다.")
    @Test
    void saveLottoByLottoCount() {
        Application application = new Application();
        int money = 3000;
        int result = 3;

        assertThat(application.saveLotto(money).size()).isEqualTo(result);
    }

    @DisplayName("로또 번호 결과와 예상 결과 같은지 확인한다. ")
    @Test
    void getLottoResultByLottoCount() {
        Application application = new Application();
        List<LottoNumber> buyList = new ArrayList<>();
        buyList.add(new LottoNumber(Arrays.asList(6, 5, 4, 3, 2, 0)));
        List<Integer> winningLotto = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;

        assertThat(application.getLottoResult(buyList, winningLotto, bonusNumber)).containsExactly(0, 0, 1, 0, 0);
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
