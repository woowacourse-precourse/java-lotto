package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import lotto.domain.Lotto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

class ApplicationTest extends NsTest {
    private static final String ERROR_MESSAGE = "[ERROR]";

    @Test
    void 로또_번호_만드는_메서드의_리턴_길이_확인() {
        int lottoNumCount = 6;

        assertThat(Lotto.createSortedLottoNumbers(lottoNumCount).size()).isEqualTo(lottoNumCount);
    }

    @ParameterizedTest
    @CsvSource({"0,1","1,2","2,3","3,4","4,5"})
    void 로또_번호가_오름차순_정렬이_맞는지_확인(int smallIdx, int bigIdx) {
        int lottoNumCount = 6;

        List<Integer> lottos = Lotto.createSortedLottoNumbers(lottoNumCount);

        assertThat(lottos.get(smallIdx) < lottos.get(bigIdx)).isEqualTo(true);
    }

    @ParameterizedTest
    @CsvSource({"1","10","100","1001","'1,000'","-10000000000","qwer","ㅁㄴㅇㅂㅈㄱ","100ㅂ","100a","5a0a","10000000000000000000000000000000000000"})
    void 로또_구매_금액_예외_입력_확인(String purchaseMoney) {
        assertSimpleTest(() -> {
            runException(purchaseMoney);
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @ParameterizedTest
    @CsvSource({"1000,1개를 구매했습니다.","6000,6개를 구매했습니다.","9000,9개를 구매했습니다.","15000,15개를 구매했습니다."})
    void 로또_구입금액에_맞춰서_구매가_되는지_확인(String purchaseMoney, String msg) {
        assertSimpleTest(() -> {
            runException(purchaseMoney);
            assertThat(output()).contains(msg);
        });
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
    void 예외_테스트() {
        assertSimpleTest(() -> {
            runException("1000j");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
