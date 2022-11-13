package lotto.dto;

import java.util.List;

public class LottoTicketDTO {
    private final List<List<Integer>> lottoTicket;

    public LottoTicketDTO(List<List<Integer>> lottoTicket) {
        this.lottoTicket = lottoTicket;
    }

    public List<List<Integer>> getLottoTicket() {
        return lottoTicket;
    }
}
