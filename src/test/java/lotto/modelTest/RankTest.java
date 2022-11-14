package lotto.modelTest;

import lotto.model.Rank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class RankTest {

    @Test
    @DisplayName("로또 번호가 맞춘 추첨 번호의 상태를 보상표와 비교하여 같다면 true를 반환한다.")
    public void checkSameStateBetweenLottoAndRank_right_case(){
        List<Integer> lottoState = List.of(5,1);
        assertThat(Rank.isSame(Rank.SECOND, lottoState)).isTrue();
    }
    @Test
    @DisplayName("로또 번호가 맞춘 추첨 번호의 상태를 보상표와 비교하여 다르다면 false를 반환한다.")
    public void checkSameStateBetweenLottoAndRank_wrong_case(){
        List<Integer> lottoState = List.of(5,1);
        assertThat(Rank.isSame(Rank.THIRD, lottoState)).isFalse();
    }
}
