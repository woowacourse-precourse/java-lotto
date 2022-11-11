package lotto.model;

import java.util.List;
import java.util.stream.Collectors;

public class Customer {
    private final PurchasePrice money;
    private List<Lotto> lottos;

    public Customer(PurchasePrice money) {
        this.money = money;
    }

    public void buy(List<Lotto> lottos) {
        setLotto(lottos);
    }

    public PurchasePrice getMoney() {
        return money;
    }

    public List<Lotto> getLottos() {
        return lottos.stream().collect(Collectors.toList());
    }

    private void setLotto(List<Lotto> lottos) {
        this.lottos = lottos;
    }
}
