package lotto;


import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class LottoService {

    private final List<Lotto> lottos = new ArrayList<>();

    public int getLottoCount(String input){
        int purchaseAmount = Integer.parseInt(input);
        return purchaseAmount / Money.THOUSAND.getAmount();
    }

    public void drawLottos(int lottoCount){
        for (int i=0; i<lottoCount; i++){
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Lotto lotto = new Lotto(numbers);
            lottos.add(lotto);
        }
    }

    public List<Lotto> getLottos(){
        return lottos;
    }
}
