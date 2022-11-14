package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTicketTest {

    @DisplayName("당첨된 로또 번호와 내 로또 번호 저장하는 카운트 배열 크기 정상 출력")
    @Test
    void countSameLottoNumbers(){
        LottoTicket tickets = new LottoTicket(4);
        Lotto lottoNumbers = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        List<Integer> count = tickets.countSameLottoNumbers(lottoNumbers);
        assertThat(count.size()).isEqualTo(4);
    }

    @DisplayName("보너스 번호와 내 로또 번호 비교 후 결과 배열 크기 정상 출력")
    @Test
    void checkSameLottoBonus(){
        LottoTicket tickets = new LottoTicket(3);
        List<Boolean> result = tickets.checkSameLottoBonus(10);
        assertThat(result.size()).isEqualTo(3);
    }
}