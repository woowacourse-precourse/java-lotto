package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import type.Rank;
import java.util.HashMap;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ApplicationTest extends NsTest {
    private static final String ERROR_MESSAGE = "[ERROR]";

    @ParameterizedTest
    @CsvSource({"a123", ")234", "3h4i"})
    void 숫자_이외의_값_입력할_경우_예외_테스트(String input) {
        assertSimpleTest(() -> {
            runException(input);
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @ParameterizedTest
    @CsvSource({"1^2^3^4^5^6", "123456"})
    void 당첨_번호를_쉼표로_구분하지_않았을_경우_예외_테스트(String input) {
        assertSimpleTest(() -> {
            runException("2000", input);
            assertThat(output()).contains(ERROR_MESSAGE, "당첨 번호는 숫자 6개와 ,(쉼표)로만 작성해야 합니다.");
        });
    }

    @DisplayName("로또를 금액에 맞는 개수만큼 발행한다.")
    @Test
    void createLottos() {
        Money money = new Money(5000);
        List<Lotto> lottos = Application.createLottos(money.getNumberToPublishLottos());
        assertEquals(5, lottos.size());
    }

    @DisplayName("수익금을 더한다.")
    @Test
    void sumOfProceeds() {
        Map<Rank, Integer> numbersOfRanks = new HashMap<>();
        numbersOfRanks.put(Rank.FIFTH, 2);
        numbersOfRanks.put(Rank.FOURTH, 2);
        numbersOfRanks.put(Rank.THIRD, 0);
        numbersOfRanks.put(Rank.SECOND, 0);
        numbersOfRanks.put(Rank.FIRST, 0);

        assertThat(Application.sumOfProceeds(numbersOfRanks)).isEqualTo(110000);
    }


    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
