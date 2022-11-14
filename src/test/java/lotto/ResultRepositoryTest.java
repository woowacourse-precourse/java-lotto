package lotto;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.EnumMap;
import lotto.domain.Rank;
import lotto.domain.ResultRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ResultRepositoryTest {

    @DisplayName("더해진 당첨 내역이 제대로 저장되는지 확인한다.")
    @Test
    void getResultAboutAddRank() {
        ResultRepository resultRepository = new ResultRepository();
        resultRepository.add(Rank.FIFTH);
        resultRepository.add(Rank.FIFTH);
        resultRepository.add(Rank.FIFTH);
        resultRepository.add(Rank.FIRST);
        EnumMap<Rank, Integer> result = resultRepository.getResult();
        assertThat(result.get(Rank.FIFTH)).isEqualTo(3);
        assertThat(result.get(Rank.FIRST)).isEqualTo(1);
    }

    @DisplayName("당첨 내역에 의해 계산된 총 당첨 금액이 정확한지 확인한다.")
    @Test
    void getTotalMoney() {
        ResultRepository resultRepository = new ResultRepository();
        resultRepository.add(Rank.FIFTH);
        resultRepository.add(Rank.FIFTH);
        resultRepository.add(Rank.FIFTH);
        resultRepository.add(Rank.FIRST);
        assertThat(resultRepository.getTotalMoney()).isEqualTo(2_000_015_000);
    }
}
