package lotto.model.database;

import lotto.model.Lotto;
import lotto.model.database.Ticket;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class TicketTest {
    @DisplayName("데이터를 삽입한다.")
    @Test
    void insert() {
        Ticket db = Ticket.newInstance();
        Lotto lotto = Lotto.fromRandomNumbers();

        assertThat(db.insert(lotto)).isTrue();
    }

    @DisplayName("모든 데이터를 가져온다.")
    @Test
    void getAll() {
        Ticket db = Ticket.newInstance();

        for(int count = 0; count < 10; count++) {
            db.insert(Lotto.fromRandomNumbers());
        }

        assertThat(db.getAll().size()).isEqualTo(10);
    }
}