package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.Enums.ErrorMessage;

import java.util.ArrayList;
import java.util.List;

public class Buyer {

    private final int purchase;
    private int reward;

    private List<Lotto> purchasedLottos;
    private List<Integer> results;

    public Buyer(int purchase){
        validate(purchase);
        this.purchase = purchase;
        this.purchasedLottos = buyLottos(purchase/1000);
    }

    private void validate(int purchase){
        if(purchase%1000 != 0) {
            throw new IllegalArgumentException(ErrorMessage.PRICE_MOD.getMessage());
        }
    }

    private List<Lotto> buyLottos(int cnt){
        List<Lotto> purchasedLottos = new ArrayList<>();

        for(int i=0;i<cnt;i++){
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            purchasedLottos.add(new Lotto(numbers));
        }
        return purchasedLottos;
    }

    public void getResult(){

    }

    private int compare(){
        return 0;
    }

    private int countMatchingNum(){
        return 0;
    }

    private void calReward(){
        this.reward = 0;
    }

}
