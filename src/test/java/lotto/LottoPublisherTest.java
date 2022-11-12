package lotto;

import camp.nextstep.edu.missionutils.test.Assertions;
import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

public class LottoPublisherTest extends NsTest {

    @Nested
    @DisplayName("publishLotto 메서드는")
    class describe_publishLotto {

        @Test
        @DisplayName("무작위로 새로운 로또를 반환한다.")
        void publish_random_Lotto() {
            assertRandomUniqueNumbersInRangeTest(() -> {
                assertThat(LottoPublisher.publishLotto()
                        .getCountOfMatchNumber(new Lotto(List.of(1, 2, 3, 4, 5, 6)))).isEqualTo(6);

                assertThat(LottoPublisher.publishLotto()
                        .getCountOfMatchNumber(new Lotto(List.of(6, 7, 8, 9, 10, 11)))).isEqualTo(6);
            }, List.of(1, 2, 3, 4, 5, 6), List.of(6, 7, 8, 9, 10, 11));
        }
    }

    @Nested
    @DisplayName("publishLottos 메서드는")
    class describe_publishLottos {

        @Test
        @DisplayName("무작위로 생성된 여러개의 로또를 반환한다.")
        void publish_random_Lotto() {
            assertRandomUniqueNumbersInRangeTest(() -> {
                List<Lotto> lottos = LottoPublisher.publishLottos(Lotto.LOTTO_COST * 2);
                List<Lotto> wantLottos = List.of(
                        new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                        new Lotto(List.of(6, 7, 8, 9, 10, 11)),
                        new Lotto(List.of(1, 3, 5, 6, 9, 11)));

                for (int i = 0; i < lottos.size(); i++) {
                    assertThat(lottos.get(i).getCountOfMatchNumber(wantLottos.get(i))).isEqualTo(6);
                }

            }, List.of(1, 2, 3, 4, 5, 6), List.of(6, 7, 8, 9, 10, 11),List.of(1, 3, 5, 6, 9, 11));
        }
    }


    @Override
    protected void runMain() {
    }
}
