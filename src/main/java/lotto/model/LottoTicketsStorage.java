package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class LottoTicketsStorage {

    private List<List<Integer>> lottoTickets = new ArrayList<>();

    public void setLottoTickets(List<List<Integer>> tickets) {
        this.lottoTickets = tickets;
    }

    public List<List<Integer>> getLottoTickets() {
        return this.lottoTickets;
    }
}
