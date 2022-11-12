package lotto;

import static lotto.LottoOperator.FIVE;
import static lotto.LottoOperator.FIVE_BONUS;
import static lotto.LottoOperator.FOUR;
import static lotto.LottoOperator.NO_LUCK;
import static lotto.LottoOperator.SIX;
import static lotto.LottoOperator.THREE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottosTest {

    @Test
    @DisplayName("로또 리스트 사이즈가 1 미만일 때 예외")
    void validList() {
        assertThatThrownBy(() -> new Lottos(new ArrayList<>()))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("발행한 로또와 당첨 번호 일치하는 카운트 리스트 확인")
    void getCounts() {
        Lotto user1 = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto user2 = new Lotto(List.of(1, 2, 3, 4, 5, 7));
        Lotto user3 = new Lotto(List.of(1, 2, 3, 4, 7, 8));
        Lotto user4 = new Lotto(List.of(1, 2, 3, 7, 8, 9));
        Lotto user5 = new Lotto(List.of(1, 2, 7, 8, 9, 10));
        Lotto user6 = new Lotto(List.of(1, 7, 8, 9, 10, 11));
        Lotto user7 = new Lotto(List.of(7, 8, 9, 10, 11, 12));
        Lotto user8 = new Lotto(List.of(1, 2, 3, 4, 5, 13));

        Lottos lottos = new Lottos(List.of(
                user1, user2, user3, user4, user5, user6, user7, user8
        ));

        int bonus = 13;
        BonusLotto bonusLotto = new BonusLotto(user1, bonus);

        List<LottoOperator> ranks = List.of(SIX, FIVE, FOUR, THREE, NO_LUCK, NO_LUCK, NO_LUCK, FIVE_BONUS);

        assertThat(lottos.result(bonusLotto)).isEqualTo(ranks);
    }
}
