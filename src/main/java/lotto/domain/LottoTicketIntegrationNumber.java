package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoTicketIntegrationNumber {

    private final List<List<Integer>> lottoTicketIntegration;

    LottoTicketIntegrationNumber() {
        lottoTicketIntegration = new ArrayList<>();
    }

    public void addNumbersIntegration(List<Integer> randomNumbers) {
        lottoTicketIntegration.add(randomNumbers);
    }

    public List<List<Integer>> getNumbersIntegration() {
        return lottoTicketIntegration;
    }
}
