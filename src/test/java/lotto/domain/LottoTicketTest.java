package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

class LottoTicketTest {
    @Test
    void 로또_티켓_정상_생성_테스트() {
        List<Lotto> lottoTicket = List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)), new Lotto(List.of(2, 3, 4, 5, 10, 20)));

        assertThat(new LottoTicket(lottoTicket)).isInstanceOf(LottoTicket.class);
    }

    @Test
    void 로또_티켓_문자열_반환_테스트() {
        List<Lotto> lottoTicket = List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)), new Lotto(List.of(2, 3, 4, 5, 10, 20)));

        List<String> issuedLottoTicket = new LottoTicket(lottoTicket).convertString();

        assertThat(issuedLottoTicket).isEqualTo(
                new ArrayList<>(Arrays.asList("[1, 2, 3, 4, 5, 6]", "[2, 3, 4, 5, 10, 20]")));
    }
}