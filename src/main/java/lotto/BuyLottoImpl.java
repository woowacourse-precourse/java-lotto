package lotto;

import java.util.ArrayList;

public class BuyLottoImpl implements BuyLotto{

    private final int lottoPrice;
    private final int money;
    public BuyLottoImpl(int lottoPrice, int money) {
        this.lottoPrice = lottoPrice;
        this.money = money;
    }

    @Override
    public int getLottoCount() {
        validate();

        return lottoPrice/money;
    }

    @Override
    public void validate() {
        if(money%lottoPrice!= 0){
            throw new IllegalArgumentException("[ERROR]제대로 된 값을 입력하십시오");
        }
    }

    @Override
    public ArrayList<Lotto> buyLotto() {
        return null;
    }

}
