package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LottoGameTest {
    private static final String ERROR_MESSAGE = "[ERROR]";
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outputStream));
    }

    @AfterEach
    void restoreStream() {
        System.setOut(standardOut);
        outputStream.reset();
    }

    @ParameterizedTest
    @CsvSource({"1000j", "999", "jjj", "9 9"})
    @DisplayName("구입 금액 유효성 확인")
    void validateMoneyTest(String inputMoney) {
        assertThatThrownBy(() -> { LottoGame.validateMoney(inputMoney);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);
    }

    @DisplayName("구매한 로또 리스트 출력 확인")
    @Test
    void printLottoListTest() {
        List<Lotto> lottoList = List.of(
                new Lotto(List.of(1,2,3,4,5,7)),
                new Lotto(List.of(4,5,6,7,8,9))
        );
        LottoGame.printLottoList(lottoList);
        String expected = "\n2개를 구매했습니다.\n"
                + "[1, 2, 3, 4, 5, 7]\n"
                + "[4, 5, 6, 7, 8, 9]\n";
        assertEquals(expected, outputStream.toString());
    }

    @DisplayName("로또 당첨 결과 출력 확인_1")
    @Test
    void printResultTest_1() {
        Map<Integer, Integer> result = new TreeMap<>(
                Map.of(3,2,6,1,7,1)
        );

        LottoGame.printResult(result);
        String expected = "\n당첨 통계\n---\n"
                + "3개 일치 (5,000원) - 2개\n"
                + "4개 일치 (50,000원) - 0개\n"
                + "5개 일치 (1,500,000원) - 0개\n"
                + "5개 일치, 보너스 볼 일치 (30,000,000원) - 1개\n"
                + "6개 일치 (2,000,000,000원) - 1개\n";
        assertEquals(expected, outputStream.toString());
    }

    @DisplayName("로또 당첨 결과 출력 확인_2")
    @Test
    void printResultTest_2() {
        Map<Integer, Integer> result = new TreeMap<>(
                Map.of(2,1,3,0,4,1,7,2)
        );

        LottoGame.printResult(result);
        String expected = "\n당첨 통계\n---\n"
                + "3개 일치 (5,000원) - 0개\n"
                + "4개 일치 (50,000원) - 1개\n"
                + "5개 일치 (1,500,000원) - 0개\n"
                + "5개 일치, 보너스 볼 일치 (30,000,000원) - 2개\n"
                + "6개 일치 (2,000,000,000원) - 0개\n";
        assertEquals(expected, outputStream.toString());
    }

    @DisplayName("수익률 계산 확인")
    @Test
    void getYieldTest() {
        int money = 2000;
        Map<Integer, Integer> result = new TreeMap<>(
                Map.of(2,1,4,1)
        );
        assertThat( LottoGame.getYield(money, result))
                .isEqualTo(2500.0);
    }
}