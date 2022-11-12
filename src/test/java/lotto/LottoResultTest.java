package lotto;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LottoResultTest {

    private static Collection<Arguments> param1() {
        return Arrays.asList(
            Arguments.of("구매금액 천원 1등 한개", 1000, Arrays.asList(1, 0, 0, 0, 0),
                  "3개 일치 (5,000원) - 0개\n"
                + "4개 일치 (50,000원) - 0개\n"
                + "5개 일치 (1,500,000원) - 0개\n"
                + "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개\n"
                + "6개 일치 (2,000,000,000원) - 1개\n"
                + "총 수익률은 200000000.0%입니다."),
            Arguments.of("구매금액 천원 5등 한개", 1000, Arrays.asList(0, 0, 0, 0, 1),
                "3개 일치 (5,000원) - 1개\n"
                    + "4개 일치 (50,000원) - 0개\n"
                    + "5개 일치 (1,500,000원) - 0개\n"
                    + "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개\n"
                    + "6개 일치 (2,000,000,000원) - 0개\n"
                    + "총 수익률은 500.0%입니다."),
            Arguments.of("구매금액 천원 5등 한개", 8000, Arrays.asList(0, 0, 0, 0, 1),
                "3개 일치 (5,000원) - 1개\n"
                    + "4개 일치 (50,000원) - 0개\n"
                    + "5개 일치 (1,500,000원) - 0개\n"
                    + "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개\n"
                    + "6개 일치 (2,000,000,000원) - 0개\n"
                    + "총 수익률은 62.5%입니다."),
            Arguments.of("구매금액 천원 5등 한개", 8000000, Arrays.asList(0, 2, 4, 23, 63),
                "3개 일치 (5,000원) - 63개\n"
                    + "4개 일치 (50,000원) - 23개\n"
                    + "5개 일치 (1,500,000원) - 4개\n"
                    + "5개 일치, 보너스 볼 일치 (30,000,000원) - 2개\n"
                    + "6개 일치 (2,000,000,000원) - 0개\n"
                    + "총 수익률은 843.3%입니다.")
        );
    }

    @ParameterizedTest(name = "{index}: {0}")
    @MethodSource("param1")
    @DisplayName("getResult 테스트")
    void test1(String description, int money, List<Integer> winResult, String expect) {
        LottoResult result = new LottoResult(money, winResult);
        String result1 = result.getResult();
        Assertions.assertEquals(expect, result1);
    }
}
