package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import domain.Lotto;
import domain.LottoGrade;
import domain.LottoPocket;
import domain.LottoPublisher;
import domain.WinningLotto;
import dto.ScratchResult;
import java.util.List;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class LottoPocketTest {

    static List<Lotto> lottos;
    static LottoPocket pocket;
    static WinningLotto winningLotto;
    ScratchResult info;
    double totalEarning;


    @BeforeAll
    static void initialize() {
        Lotto lottoA = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto lottoB = new Lotto(List.of(2, 4, 6, 8, 10, 11));
        Lotto lottoC = new Lotto(List.of(13, 14, 15, 16, 17, 18));
        Lotto lottoD = new Lotto(List.of(5, 2, 11, 8, 9, 10));

        System.out.println(lottoD.getCountOfMatchNumber(new Lotto(List.of(1, 2, 3, 4, 5, 8))));
        System.out.println(lottoB.getCountOfMatchNumber(new Lotto(List.of(1, 2, 3, 4, 5, 8))));

        lottos = List.of(lottoA, lottoB, lottoC, lottoD);
        pocket = new LottoPocket(lottos);

        winningLotto = new WinningLotto(new Lotto(List.of(1, 2, 3, 4, 5, 8)), 6);
    }

    @Nested
    @DisplayName("getScratchResult 메서드는")
    class describe_getScratchResult {

        @Nested
        @DisplayName("당첨 로또 객체를 입력받아")
        class describe_its_parameter {

            @Test
            @DisplayName("스크래치 결과를 반환합니다.")
            void describe_its_return() {
                info = pocket.getScratchResult(winningLotto);

                long expectedTotalEarning = LottoGrade.SECOND.prize + LottoGrade.FIFTH.prize * 2;

                assertThat(info.getTotalEarning()).isEqualTo(expectedTotalEarning);
                assertThat(info.getEarningRate()).isEqualTo(
                        (double) expectedTotalEarning * 100 / lottos.size() / LottoPublisher.LOTTO_COST);

                assertThat(info.getCountOfGrade(LottoGrade.FIRST)).isEqualTo(0);
                assertThat(info.getCountOfGrade(LottoGrade.SECOND)).isEqualTo(1);
                assertThat(info.getCountOfGrade(LottoGrade.THIRD)).isEqualTo(0);
                assertThat(info.getCountOfGrade(LottoGrade.FOURTH)).isEqualTo(0);
                assertThat(info.getCountOfGrade(LottoGrade.FIFTH)).isEqualTo(2);
            }
        }
    }
}
