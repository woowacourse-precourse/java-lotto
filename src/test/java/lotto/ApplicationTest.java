package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import lotto.domain.Buyer;
import lotto.domain.Lotto;
import lotto.domain.WinningNumbers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.*;

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

    @Nested
    @DisplayName("주요 로직")
    class LottoTest {
        Lotto lotto = new Lotto(new ArrayList<>(Arrays.asList(1,2,3,4,5,6)));

        List<List<Integer>> correctWinningNumberTest = new ArrayList<>(Arrays.asList(
                new ArrayList<Integer>(Arrays.asList(1,2,3,4,5,6))
                , new ArrayList<Integer>(Arrays.asList(2,45,1,13,17,5))
                , new ArrayList<Integer>(Arrays.asList(34,41,32,4,35,16))
        ));

        List<List<Integer>> wrongWinningNumberTest = new ArrayList<>(Arrays.asList(
                new ArrayList<Integer>(Arrays.asList(1,23,12,42,25,16,31,19))
                , new ArrayList<Integer>(Arrays.asList(115,2,3,4,5,6))
                , new ArrayList<Integer>(Arrays.asList(1,2,3,-43,5,6))
                , new ArrayList<Integer>(Arrays.asList(1,2,2,2,5,6))
        ));

        @ParameterizedTest
        @CsvSource({"0", "1", "2"})
        void correctValidateTest(int testIndex) {
            List<Integer> tmp = correctWinningNumberTest.get(testIndex);
            try {
                lotto.validate(tmp);
            } catch (Exception anyException) {
                assertEquals(true,false);
            }
        }

        @ParameterizedTest
        @CsvSource({"0,[ERROR] 숫자의 갯수는 6개만 가능합니다.", "1,[ERROR] 숫자의 범위는 1~45까지만 가능합니다."
                , "2,[ERROR] 숫자의 범위는 1~45까지만 가능합니다.", "3,[ERROR] 중복된 숫자 입력은 불가능 합니다."})
        void wrongValidateTest(int testIndex, String exceptionMessage) {
            List<Integer> tmp = wrongWinningNumberTest.get(testIndex);
            try {
                lotto.validate(tmp);
                assertEquals(true,false);
            } catch (IllegalArgumentException illegalArgumentException) {
                assertEquals(exceptionMessage,illegalArgumentException.getMessage());

                Assertions.assertThrows(IllegalArgumentException.class, () -> {
                    lotto.validate(tmp);
                });
            }
        }

        @ParameterizedTest
        @CsvSource({"8", "41", "13"})
        void correctValidateBonusTest(int bonusNumber) {
            try {
                lotto.validateBonus(bonusNumber);
            } catch (Exception anyException) {
                assertEquals(true,false);
            }
        }

        @ParameterizedTest
        @CsvSource({"47,[ERROR] 숫자의 범위는 1~45까지만 가능합니다.", "-46132,[ERROR] 숫자의 범위는 1~45까지만 가능합니다."
                , "0,[ERROR] 숫자의 범위는 1~45까지만 가능합니다.", "4,[ERROR] 이미 있던 숫자와 중복 할 수 없습니다."
                , "6,[ERROR] 이미 있던 숫자와 중복 할 수 없습니다."})
        void wrongValidateBonusTest(int bonusNumberTest, String exceptionMessage){
            try {
                lotto.validateBonus(bonusNumberTest);
                assertEquals(true,false);
            } catch (IllegalArgumentException illegalArgumentException) {
                assertEquals(exceptionMessage,illegalArgumentException.getMessage());

                Assertions.assertThrows(IllegalArgumentException.class, () -> {
                    lotto.validateBonus(bonusNumberTest);
                });
            }
        }

        @Test
        void countMatchesTest() {
            List<Integer> matchTest = new ArrayList<>(Arrays.asList(6,3,1));

            assertEquals(lotto.countMatches(correctWinningNumberTest), matchTest);
        }

        @ParameterizedTest
        @CsvSource({"13,false,true,false", "35,false,false,true", "7,false,false,false", "44,false,false,false"})
        void matchBonusTest(int bonusNumberTest, boolean correctOne, boolean correctTwo, boolean correctThree) {
            List<Boolean> answerBooleansTest = new ArrayList<>(Arrays.asList(correctOne, correctTwo, correctThree));

            assertEquals(lotto.matchBonus(bonusNumberTest, correctWinningNumberTest), answerBooleansTest);
        }

        List<List<Integer>> winningNumberCasesTest = new ArrayList<>(Arrays.asList(
                new ArrayList<Integer>(Arrays.asList(1,2,3,4,5,6)) // 2000000000
                , new ArrayList<Integer>(Arrays.asList(2,45,1,13,17,5)) // 5000
                , new ArrayList<Integer>(Arrays.asList(34,41,32,4,35,16)) // 0
                , new ArrayList<Integer>(Arrays.asList(3,5,7,4,1,2)) // 30000000
                , new ArrayList<Integer>(Arrays.asList(1,3,2,4,35,16)) // 50000
        ));

        @Test
        void calculateRewardRateTest() {
            double expectedRatio = 40601100;
            double testResult = lotto.calculateRewardRate(7, winningNumberCasesTest, 5000);

            assertEquals(expectedRatio, testResult);
        }

        @Test
        void countWinningCaseTest() {
            Map<WinningNumbers, Long> correctAnswer = new EnumMap<WinningNumbers, Long>(WinningNumbers.class);
            correctAnswer.put(WinningNumbers.THREE,1L);
            correctAnswer.put(WinningNumbers.FOUR,1L);
            correctAnswer.put(WinningNumbers.FIVE_BONUS,1L);
            correctAnswer.put(WinningNumbers.SIX,1L);
            correctAnswer.put(WinningNumbers.NOTHING,1L);

            assertEquals(correctAnswer, lotto.countWinningCase(7,winningNumberCasesTest));
        }
    }
}
