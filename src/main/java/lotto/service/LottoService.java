package lotto.service;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.Customer;
import lotto.domain.Lotto;
import lotto.domain.LottoGenerator;

public class LottoService {

    private final Customer customer;
    private final LottoGenerator lottoGenerator;

    public LottoService() {
        this.customer = new Customer();
        this.lottoGenerator = new LottoGenerator();
    }

    public void generateByAmount(int amount) {
        int count = amount / 1000;
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            List<Integer> numbers = lottoGenerator.generateNumbers();
            Lotto lotto = new Lotto(numbers);
            lottos.add(lotto);
        }

        customer.buyLottos(lottos);
    }

    public String showLottos() {
        List<Lotto> lottos = customer.showLottos();
        StringBuilder sb = new StringBuilder();

        lottos.forEach(lotto -> sb.append(lotto.getNumbers() + "\n"));

        return sb.toString();
    }
}
