package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

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

    @DisplayName("1등이 당첨됐을 때 정상동작 하는지 확인한다.")
    @Test
    void getPrizeMoney_정상동작_1등_당첨(){
        Lotto lotto = new Lotto(List.of(1,2,3,4,5,6));
        int prizeMoney = lotto.getPrizeMoney(Arrays.asList(Arrays.asList(1,2,3,4,5,6),Arrays.asList(7,8,9,10,11,12)), 7);
        assertThat(prizeMoney).isEqualTo(Rank.FIRST.getWinningsPrice());
    }
}
