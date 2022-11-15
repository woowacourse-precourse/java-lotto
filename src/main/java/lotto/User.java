package lotto;

import java.util.ArrayList;
import java.util.List;

public class User {
    private static final int LOTTO_PRICE = 1000;

    public List<List<Integer>> buyLotto(int money){

        int count = money / LOTTO_PRICE;

        List<List<Integer>> lottos = new ArrayList<>();
        LottoMachine lottoMachine = new LottoMachine();
        for(int i=0; i<count; i++){
            lottos.add(lottoMachine.createLotto());
        }
        return lottos;

    }
}
