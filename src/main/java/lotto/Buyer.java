package lotto;

import java.util.ArrayList;
import java.util.List;

public class Buyer {
    private static final int LOTTO_PRICE = 1000;

    public static List<Lotto> buyLotto(int money){

        int count = money / LOTTO_PRICE;

        List<Lotto> lottos = new ArrayList<>();
        LottoRandomGenerator lottoMachine = new LottoRandomGenerator();
        for(int i=0; i<count; i++){
            lottos.add(lottoMachine.createLottoNumber());
        }
        return lottos;

    }
}
