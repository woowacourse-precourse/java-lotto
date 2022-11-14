package lotto.dto;

import java.util.List;

public class LottoInformationDto {
    private final List<List<Integer>> lottoTicket;
    private final Integer size;

    public LottoInformationDto(List<List<Integer>> lottoTicket) {
        this.lottoTicket = lottoTicket;
        this.size = lottoTicket.size();
    }

    public List<List<Integer>> getLottoTicket() {
        return lottoTicket;
    }

    public Integer getSize() {
        return size;
    }
}
