package lotto.dto;

import java.util.List;

public class LottoInformationDto {
    private List<List<Integer>> lottoTicket;
    private Integer size;

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
