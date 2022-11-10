package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoTicketTest {


    @Test
    void 오름차순_된_문자열을_리턴한다() {
        //given
        LottoTicket lottoTicket = new LottoTicket(List.of(4, 2, 31, 35, 14, 23));
        String expect = "2, 4, 14, 23, 31, 35";

        //when
        String res = lottoTicket.toString();

        //then
        assertThat(res).isEqualTo(expect);
    }
}