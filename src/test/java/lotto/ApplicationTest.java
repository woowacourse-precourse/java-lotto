package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.*;
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

    @DisplayName("로또 금액에 숫자가 아닌 값이 오면 예외를 발생시킨다")
    @Test
    void createLottoByNonInteger() {
        //given
        Application application = new Application();
        makeLottoPrice("test");
        //then
        assertThatThrownBy(application::insertPriceAndSaveNumber)
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 금액이 1000으로 나누어떨어지지 않으면 예외를 발생시킨다")
    @Test
    void createLottoByIntegerButNotMetCond() {
        //given
        Application application = new Application();
        makeLottoPrice("124200");
        //then
        assertThatThrownBy(application::insertPriceAndSaveNumber)
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 금액이 8000일때 8개의 randomLottos 배열이 만들어진다")
    @Test
    void createRandomLottosArrayByLottoPriceIsSet() {
        //given
        Application application = new Application();
        makeLottoPrice("8000");
        application.insertPriceAndSaveNumber();
        //when
        application.makeArray();
        //then
        assertThat(application.getRandomLottos().size()).isEqualTo(8);
    }

    @DisplayName("로또 금액의 각각의 배열에는 서로 다른 6개의 숫자가 저장된다")
    @Test
    void createRandomLottsWithSixOtherNumbers() {
        //given
        Application application = new Application();
        makeLottoPrice("8000");
        application.insertPriceAndSaveNumber();
        application.makeArray();
        //when
        application.makeEachArrays();
        //then
        assertThat(application.getRandomLottos().size()).isEqualTo(8);
        assertThat(application.getRandomLottos().get(0).size()).isEqualTo(6);
        assertThat(isNotDuplicated(application.getRandomLottos())).isEqualTo(true);
    }

    @DisplayName("로또 금액의 각각의 배열에는 1 ~ 45 범위의 숫자가 저장된다")
    @Test
    void createRandomLottsWithNumberWhichInRage() {
        //given
        Application application = new Application();
        makeLottoPrice("8000");
        application.insertPriceAndSaveNumber();
        application.makeArray();
        //when
        application.makeEachArrays();
        //then
        assertThat(inRange(application.getRandomLottos())).isEqualTo(true);
    }

    private boolean inRange(List<List<Integer>> randomLottos){
        for(List<Integer> lottos : randomLottos){
            for(Integer lotto : lottos){
                if(lotto < 0 || lotto > 45) return false;
            }
        }
        return true;
    }

    private boolean isNotDuplicated(List<List<Integer>> randomLottos){
        for(List<Integer> lottos : randomLottos){
            boolean [] check = new boolean[45];
            for(Integer lotto : lottos){
                if(check[lotto-1]) return false;
                check[lotto-1] = true;
            }
        }
        return true;
    }

    private void makeLottoPrice(String input) {
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
