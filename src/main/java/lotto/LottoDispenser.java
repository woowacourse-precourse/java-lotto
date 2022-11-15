package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoDispenser {

    public Customer purchase(Customer customer, int money){
        customer = new Customer(customer);

        customer.changeMoney(money % 1000);
        int amount = money / 1000;

        List<Lotto> lottos = new ArrayList<>();
        for(int cnt = 0; cnt < amount; cnt++){
            lottos.add(LottoGenerator.generate());
        }

        customer.changeLottos(lottos);
        return customer;
    }

}
