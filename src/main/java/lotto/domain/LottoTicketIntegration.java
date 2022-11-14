package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoTicketIntegration {

    private final List<List<Integer>> lottoTicketIntegration;

    public LottoTicketIntegration() {
        lottoTicketIntegration = new ArrayList<>();
    }

    public void put(List<Integer> randomNumbers) {
        lottoTicketIntegration.add(randomNumbers);
    }

    public List<List<Integer>> getNumbersIntegration() {
        return lottoTicketIntegration;
    }
}
