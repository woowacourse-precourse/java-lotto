package lotto;

import java.util.ArrayList;
import java.util.List;

public class Customer {

    private Integer money;
    private List<Lotto> lottos = new ArrayList<>();

    public Customer(int money) {
        this.money = money;
    }

    public Customer(Customer customer) {
        this.money = customer.money;
        this.lottos = new ArrayList<>(customer.lottos);
    }

    public void changeMoney(int money) {
        this.money = money;
    }

    public void changeLottos(List<Lotto> lottos){
        this.lottos = new ArrayList<>(lottos);
    }

    public int getCntOfLottos(){
        return lottos.size();
    }

    public List<Lotto> getLottos(){
        return new ArrayList<>(lottos);
    }
}
