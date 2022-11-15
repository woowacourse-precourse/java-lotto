package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.Player;
import lotto.domain.info.Rank;
import org.junit.jupiter.api.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;


class LottoMachineTest {

    @DisplayName("무작위 로또가 발행된다.")
    @Nested
    class publish {
        @DisplayName("6자리 로또가 발행된다.")
        @Test
        void lottoPublish1() {
            Lotto lotto = LottoMachine.publishLotto();

            assertThat(lotto.getNumbers().size()).isEqualTo(6);
        }

        @DisplayName("1~45 사이의 로또 번호가 발행된다.")
        @Test
        void lottoPublish2() {
            List<Integer> numbers = LottoMachine.publishLotto().getNumbers();

            for (Integer number : numbers) {
                assertThat(number >= 1 || number <= 45).isTrue();
            }
        }

        @RepeatedTest(value = 20, name = "중복된 번호가 발행되지 않는다.")
        void lottoPublish3() {
            Lotto lotto = LottoMachine.publishLotto();
            HashSet<Integer> integers = new HashSet<>(lotto.getNumbers());

            assertThat(integers.size()).isEqualTo(6);
        }


        @RepeatedTest(value = 20, name = "번호가 오름차순으로 정렬된다.")
        void lottoPublish4() {
            List<Integer> numbers = LottoMachine.publishLotto().getNumbers();

            int num = 0;
            for (Integer number : numbers) {
                assertThat(number > num).isTrue();
                num = number;
            }
        }
    }

    @DisplayName("로또 당첨 테스트")
    @Nested
    class ranks {
        private Lotto lotto;
        @BeforeEach
        void setUp() {
            List<Integer> numbers = List.of(18,32,37,43,15,9);
            lotto = new Lotto(numbers);
        }

        @DisplayName("보너스 볼을 맞출 경우 True 가 반환된다.")
        @Test
        void isBonusMatch1() {
            boolean bonusMatch = LottoMachine.isBonusMatch(18, lotto);

            assertThat(bonusMatch).isTrue();
        }

        @DisplayName("로또 번호를 맞춘 개수가 반환된다.")
        @Test
        void countMatchNumber() {
            Set<Integer> playersLottoNumber = Set.of(18, 13, 41, 15, 9, 23);
            int count = LottoMachine.countMatchNumber(playersLottoNumber, lotto);

            assertThat(count).isEqualTo(3);
        }

        @DisplayName("로또 등수가 반환된다.")
        @Test
        void getRank() {
            Set<Integer> playersLottoNumber = Set.of(18, 13, 43, 15, 9, 23);
            int bonus = 1;
            Rank rank = LottoMachine.getRank(playersLottoNumber, bonus, lotto);

            assertThat(rank).isEqualTo(Rank.FOURTH);
        }

        @DisplayName("로또 번호 5개를 맞추고 보너스볼을 맞추면 2등이 반환된다")
        @Test
        void getRank2() {
            Set<Integer> playersLottoNumber = Set.of(18,32,31,43,15,9);
            int bonus = 37;
            Rank rank = LottoMachine.getRank(playersLottoNumber, bonus, lotto);

            assertThat(rank).isEqualTo(Rank.SECOND);
        }

        @DisplayName("로또 번호 5개를 맞추고 보너스볼을 맞추지 못하면 3등이 반환된다")
        @Test
        void getRank3() {
            Set<Integer> playersLottoNumber = Set.of(18, 32, 31, 43, 15, 9);
            int bonus = 1;
            Rank rank = LottoMachine.getRank(playersLottoNumber, bonus, lotto);

            assertThat(rank).isEqualTo(Rank.THIRD);
        }
    }
}