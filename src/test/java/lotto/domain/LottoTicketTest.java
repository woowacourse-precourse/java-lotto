package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayName("LottoTicket 클래스")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class LottoTicketTest {

    @Test
    void value_메서드는_로또_번호_리스트들을_반환한다() {
        List<Lotto> lottos = List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(1, 2, 3, 7, 8, 9)),
                new Lotto(List.of(10, 20, 30, 40, 44, 45))
        );
        LottoTicket lottoTicket = new LottoTicket(lottos);

        assertThat(lottoTicket.value()).contains(
                List.of(1, 2, 3, 4, 5, 6),
                List.of(1, 2, 3, 7, 8, 9),
                List.of(10, 20, 30, 40, 44, 45)
        );
    }
}
