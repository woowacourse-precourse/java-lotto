package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class UserLottoTest {
    @DisplayName("로또 결과 리스트 반환")
    @Test
    void createLottoResult() {
        Lotto lotto1 = new Lotto(List.of(1, 2, 3, 4, 5, 6)); // 1등
        Lotto lotto2 = new Lotto(List.of(1, 3, 5, 7, 9, 11)); // 5등
        Lotto lotto3 = new Lotto(List.of(11, 12, 13, 14, 15, 16)); // 꽝
        Lotto lotto4 = new Lotto(List.of(1, 2, 3, 4, 5, 7)); // 2등
        Lotto lotto5 = new Lotto(List.of(1, 2, 3, 4, 5, 8)); // 3등

        List<Lotto> lottos = new ArrayList<Lotto>();
        List<Integer> winningNumbers = new ArrayList<Integer>(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 7;

        lottos.add(lotto1);
        lottos.add(lotto2);
        lottos.add(lotto3);
        lottos.add(lotto4);
        lottos.add(lotto5);

        assertThat(UserLotto.createLottoResult(lottos, winningNumbers, bonusNumber)).
                isEqualTo(new ArrayList<Integer>(List.of(1, 1, 1, 0, 1)));
    }
}