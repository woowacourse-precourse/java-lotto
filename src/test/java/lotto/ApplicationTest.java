package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    private static final String ERROR_MESSAGE = "[ERROR]";
    List<Lotto> userLotto = new ArrayList<>();
    Map<WINNING, Integer> result;

    Lotto winningLotto = new Lotto(List.of(1,2,3,10,11,12));
    int bonusNumber = 6;

    @BeforeEach
    void 유저_로또_초기화(){
        userLotto.add(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        userLotto.add(new Lotto(List.of(7, 8, 9, 10, 11, 12)));
        result = Application.initResultMap();
    }

    @AfterEach
    void 유저_로또_삭제(){
        userLotto.clear();
        result.clear();
    }

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
    void 로또_구매_테스트(){
        List<Lotto> newUserLotto = new ArrayList<>();
        Application.purchaseLotto(newUserLotto, 3);
        assertThat(newUserLotto.size()).isEqualTo(3);
        assertThat(newUserLotto.get(0).getNumbers().size()).isEqualTo(6);
    }

    @Test
    void 로또_당첨_테스트(){
        Application.checkAllUserLottoWinning(result, userLotto, winningLotto, bonusNumber, userLotto.size() * 1000);
        assertThat(result.get(WINNING.FIFTH)).isEqualTo(2);
    }

    @Test
    void 잘못된_타입_로또금액_입력_예외_테스트() {
        assertSimpleTest(() -> {
            runException("1000j");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    void 자연수_로또_구매금액_테스트(){
        assertSimpleTest(() -> {
            runException("3000");
            assertThat(output()).contains("3");
        });
    }

    @Test
    void 자연수_아닌_로또_구매금액_예외_테스트(){
        assertSimpleTest(() -> {
            runException("-5000");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    void 나누어지지_않는_로또_구매금액_예외_테스트(){
        assertSimpleTest(() -> {
            runException("3200");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    void 중복된_당첨로또_입력_오류_테스트(){
        assertSimpleTest(() -> {
            runException("3000","1,2,3,4,5,5");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    void 길이_다른_당첨로또_입력_오류_테스트() {
        assertSimpleTest(() -> {
            runException("3000","1,2,3,4,5,6,7");
            assertThat(output()).contains(ERROR_MESSAGE);
        });

        assertSimpleTest(() -> {
            runException("3000","1,2,3,4,5");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
