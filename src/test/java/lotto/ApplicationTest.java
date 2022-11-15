package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import lotto.domain.Buyer;
import lotto.domain.WinningNumbers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

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

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }

    @Nested
    @DisplayName("구매 메서드")
    class BuyerTest {
        Buyer buyer = new Buyer();

        @ParameterizedTest
        @DisplayName("로또 구매 갯수 확인 성공 케이스")
        @CsvSource({"1000,1", "2000,2", "3000,3", "1000000,1000", "1000000000000000,1000000000000"})
        void countLottosSuccessTest(long money, long lottoNumber) {
            assertThat(buyer.countLottos(money)).isEqualTo(lottoNumber);
        }

        private final String unitFailMessage = "[ERROR] 구매 금액은 1000원 단위만 가능합니다";
        @ParameterizedTest
        @DisplayName("로또 구매 갯수 실패 케이스")
        @CsvSource({"1500,"+unitFailMessage, "2345,"+unitFailMessage, "500,"+unitFailMessage})
        void countLottosFailTest(long money, String exceptionMessage) {
            try {
                buyer.countLottos(money);
                assertThat(true).isFalse();
            } catch (Exception exception) {
                assertEquals(exceptionMessage,exception.getMessage());

                Assertions.assertThrows(IllegalArgumentException.class, () -> {
                    buyer.countLottos(money);
                });
            }
        }
    }

    @Nested
    @DisplayName("로또 발행 확인")
    class ReceiveLottosTest {
        Buyer buyer = new Buyer();

        @ParameterizedTest
        @CsvSource({"32000", "1000", "15000"})
        void receiveLottosTest(long money) {
            List<List<Integer>> bundleOfLottos = buyer.receiveLottos(money);

            assertThat(bundleOfLottos.size()).isEqualTo(money/1000);

            Set<Integer> comparer = new HashSet<>();
            for (int lottoNumber = 1; lottoNumber <= 45; lottoNumber++) {
                comparer.add(lottoNumber);
            }
            for (List<Integer> singleLotto : bundleOfLottos) {
                Set<Integer> tmp = new HashSet<>(singleLotto);
                tmp.retainAll(comparer);
                assertThat(tmp.size()).isEqualTo(6);
            }
        }
    }

    @Nested
    @DisplayName("일치에 따른 액수 계산")
    class WinningNumbersTest {

        @ParameterizedTest
        @CsvSource({"1,true,0","1,fasle,0", "2,false,0", "3,true,5000", "3,false,5000", "4,true,50000", "4,false,50000"
                , "5,true,30000000", "5,false,1500000", "6,true,2000000000", "6,false,2000000000"})
        void getMatchedRewardTest(int matches, boolean bonus, long answer) {
            assertThat(WinningNumbers.getMatchedReward(matches, bonus)).isEqualTo(answer);
        }

        @ParameterizedTest
        @CsvSource({"1,true,NOTHING","1,fasle,NOTHING", "2,false,NOTHING", "3,true,THREE", "3,false,THREE"
                , "4,true,FOUR", "4,false,FOUR", "5,true,FIVE_BONUS", "5,false,FIVE", "6,true,SIX", "6,false,SIX"})
        void getEnumTest(int matches, boolean bonus, String answer) {
            assertThat(WinningNumbers.getEnum(matches, bonus).toString()).isEqualTo(answer);
        }
    }
}
