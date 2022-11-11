package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static lotto.Application.*;
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
    void validateCashIsIntegerTest() {
        assertThatThrownBy(() -> validateCashIsInteger("123A"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void validateCashIsDividedThousandTest() {
        assertThatThrownBy(() -> validateCashIsDividedThousand("1234"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void inputCashStringToIntegerTest() {

        assertThat(changeCashStringToInteger("12345")).isEqualTo(12345);
    }

    @Test
    void getUserCashTest() {

        assertThat(getUserCash("11000")).isEqualTo(11000);
    }

    @Test
    void validateNumbersBetweenCommaTest() {
        assertThatThrownBy(() -> validateNumbersBetweenComma('1', ','))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void validateWinningNumbersFormTest() {
        assertThatThrownBy(() -> validateWinningNumbersForm("1,2,3!,4,5"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void getWinningNumbersTest() {

        assertThat(List.of(1, 2, 3, 4, 5, 6)).isEqualTo(getWinningNumbers("1,2,3,4,5,6"));
    }

    @Test
    void validateBonusNumberIsIntegerTest() {
        assertThatThrownBy(() -> validateBonusNumberIsInteger("!"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void validateBonusNumberIsInRangeTest() {
        assertThatThrownBy(() -> validateBonusNumberIsInRange("46"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void validateBonusNumberIsDuplicateTest() {
        assertThatThrownBy(() -> validateBonusNumberIsDuplicate("33", List.of(1, 2, 5, 6, 33, 41)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void getBonusNumberTest() {

        assertThat(33).isEqualTo(getBonusNumber("33", List.of(1, 2, 3, 4, 5, 6)));
    }

    @Test
    void calculateSurplusTest() {

        assertThat(62.5).isEqualTo(calculateSurplus(0, 0, 0, 0, 1, 8000));
    }

    @Test
    void compareLottoNumbersAndWinningNumbersTest() {

        assertThat(1).isEqualTo(compareLottoNumbersAndWinningNumbers(new Lotto(List.of(1, 2, 3, 4, 5, 6)), List.of(6, 5, 4, 3, 2, 1), 6));
    }

    @Test
    void calculateFirstTest() {
        List<Lotto> lottoList = new ArrayList<>();

        lottoList.add(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        lottoList.add(new Lotto(List.of(4, 23, 43, 1, 7, 8)));
        lottoList.add(new Lotto(List.of(3, 14, 23, 31, 39, 17)));
        lottoList.add(new Lotto(List.of(3, 4, 1, 5, 2, 6)));

        assertThat(2).isEqualTo(calculateFirst(lottoList, List.of(6, 5, 4, 3, 2, 1)));
    }

    @Test
    void calculateSecondTest() {
        List<Lotto> lottoList = new ArrayList<>();

        lottoList.add(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        lottoList.add(new Lotto(List.of(4, 23, 43, 1, 7, 8)));
        lottoList.add(new Lotto(List.of(3, 14, 23, 31, 39, 17)));
        lottoList.add(new Lotto(List.of(3, 4, 1, 5, 2, 6)));

        assertThat(2).isEqualTo(calculateSecond(lottoList, List.of(17, 5, 4, 3, 2, 1), 6));
    }

    @Test
    void calculateThirdTest() {
        List<Lotto> lottoList = new ArrayList<>();

        lottoList.add(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        lottoList.add(new Lotto(List.of(1, 2, 3, 4, 5, 8)));

        assertThat(1).isEqualTo(calculateThird(lottoList, List.of(1, 2, 3, 4, 5, 7), 6));
    }

    @Override
    public void runMain() {
        main(new String[]{});
    }
}
