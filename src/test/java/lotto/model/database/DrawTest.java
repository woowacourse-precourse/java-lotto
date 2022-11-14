package lotto.model.database;

import lotto.model.Bonus;
import lotto.model.Lotto;
import lotto.model.Raffle;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DrawTest {
    @DisplayName("데이터를 삽입한다.")
    @Test
    void insert() {
        Draw db = Draw.newInstance();
        Raffle raffle = new Raffle(Lotto.fromRandomNumbers(), new Bonus(7));

        assertThat(db.insert(raffle)).isTrue();
    }

    @DisplayName("마지막 데이터를 가져온다.")
    @Test
    void getLatest() {
        Draw db = Draw.newInstance();
        Raffle raffle = new Raffle(Lotto.fromRandomNumbers(), new Bonus(7));

        db.insert(raffle);
        assertThat(db.getLatest()).isEqualTo(raffle);
    }
}