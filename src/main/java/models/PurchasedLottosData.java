package models;

import java.util.ArrayList;
import java.util.List;

public class PurchasedLottosData {

    private List<Lotto> purchasedLottos;

    public PurchasedLottosData(int amount){
        lottos = createLottos(amount);
    }

    private createLottos(int amount){

        List<Lotto> Lottos = new ArrayList<>();

        for(;Lottos.size() < amount;){
            Lottos.add(createLottoNumbers());
        }
        return Lottos;

    }



}
