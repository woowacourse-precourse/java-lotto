package lotto;

import lotto.UI.OutputManager;
import org.junit.jupiter.api.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
import java.util.Map;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    // 아래에 추가 테스트 작성 가능
    @Nested
    @DisplayName("로또 생성 테스트")
    class LottoGenerateTest {
        @Test
        @DisplayName("로또 번호가 seed 대로 생성되지 않으면 예외가 발생한다.")
        void generateRandomLottoNumber() {
            assertRandomUniqueNumbersInRangeTest(
                    () -> {
                        assertThat(Lotto.generateRandomLottoNumbers()).isEqualTo(List.of(1, 2, 3, 4, 5, 6));
                    },
                    List.of(1, 2, 3, 4, 5, 6)
            );
        }

        @Test
        @DisplayName("생성된 로또 번호를 정렬한다.")
        void sortLottoNumberAsc() {
            assertRandomUniqueNumbersInRangeTest(
                    () -> {
                        assertThat(Lotto.generateRandomLottoNumbers()).isEqualTo(List.of(1, 2, 3, 4, 5, 6));
                    },
                    List.of(6, 5, 4, 3, 2, 1)
            );
        }
    }

    @Nested
    @DisplayName("로또 비교 테스트")
    class LottoCompareTest {
        @Test
        @DisplayName("1등 당첨 테스트")
        void compareWithAnswerZero() {
            Lotto myLotto = new Lotto(List.of(1,2,3,4,5,6));
            Lotto answer = new Lotto(List.of(1,2,3,4,5,6));
            int bonus = 45;

            assertThat(myLotto.compareWithAnswer(answer, bonus) == 0);
        }

        @Test
        @DisplayName("2등 당첨 테스트")
        void compareWithAnswerOne() {
            Lotto myLotto = new Lotto(List.of(1,2,3,4,5,6));
            Lotto answer = new Lotto(List.of(1,2,3,4,5,7));
            int bonus = 6;

            assertThat(myLotto.compareWithAnswer(answer, bonus) == 1);
        }

        @Test
        @DisplayName("3등 당첨 테스트")
        void compareWithAnswerTwo() {
            Lotto myLotto = new Lotto(List.of(1,2,3,4,5,6));
            Lotto answer = new Lotto(List.of(1,2,3,4,5,7));
            int bonus = 45;

            assertThat(myLotto.compareWithAnswer(answer, bonus) == 2);
        }

        @Test
        @DisplayName("4등 당첨 테스트")
        void compareWithAnswerThree() {
            Lotto myLotto = new Lotto(List.of(1,2,3,4,5,6));
            Lotto answer = new Lotto(List.of(1,2,3,4,7,8));
            int bonus = 45;

            assertThat(myLotto.compareWithAnswer(answer, bonus) == 3);
        }

        @Test
        @DisplayName("5등 당첨 테스트")
        void compareWithAnswerFour() {
            Lotto myLotto = new Lotto(List.of(1,2,3,4,5,6));
            Lotto answer = new Lotto(List.of(1,2,3,7,8,9));
            int bonus = 45;

            assertThat(myLotto.compareWithAnswer(answer, bonus) == 4);
        }

        @Test
        @DisplayName("미당첨 테스트1")
        void compareWithAnswerMinus1() {
            Lotto myLotto = new Lotto(List.of(1,2,3,4,5,6));
            Lotto answer = new Lotto(List.of(1,2,7,8,9,10));
            int bonus = 45;

            assertThat(myLotto.compareWithAnswer(answer, bonus) == -1);
        }

        @Test
        @DisplayName("미당첨 테스트2")
        void compareWithAnswerMinus2() {
            Lotto myLotto = new Lotto(List.of(1,2,3,4,5,6));
            Lotto answer = new Lotto(List.of(7,8,9,10,11,12));
            int bonus = 45;

            assertThat(myLotto.compareWithAnswer(answer, bonus) == -1);
        }
    }

    @Nested
    @DisplayName("출력 테스트")
    class OutputTest {
        // stdout 출력 비교하기
        // 참고 블로그 : https://eblo.tistory.com/123
        final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        final PrintStream standardOut = System.out;

        @BeforeEach
        void setUp() {
            System.setOut(new PrintStream(outputStreamCaptor));
        }

        @AfterEach
        void tearDown() {
            System.setOut(standardOut);
        }

        @Test
        @DisplayName("로또 리스트 출력")
        void printLottos() {
            List<Lotto> lottoList = List.of(
                    new Lotto(List.of(1,2,3,4,5,6)),
                    new Lotto(List.of(1,2,3,10,11,12)),
                    new Lotto(List.of(40,41,42,43,44,45))
            );

            OutputManager.printLottoList(lottoList);

            assertThat(outputStreamCaptor.toString().trim())
                    .contains("[1, 2, 3, 4, 5, 6]",
                            "[1, 2, 3, 10, 11, 12]",
                            "[40, 41, 42, 43, 44, 45]");
        }

        @Test
        @DisplayName("로또 리스트 출력")
        void printRank() {
            Map<Integer, Integer> lottoRank = Map.of(
                    0, 1,
                    3, 2
            );

            OutputManager.printRanks(lottoRank, 2000100000, 250000);

            assertThat(outputStreamCaptor.toString().trim())
                    .contains("3개 일치 (5,000원) - 0개",
                            "4개 일치 (50,000원) - 2개",
                            "5개 일치 (1,500,000원) - 0개",
                            "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개",
                            "6개 일치 (2,000,000,000원) - 1개",
                            "총 수익률은 800040.0%입니다."
                    );
        }
    }
}
