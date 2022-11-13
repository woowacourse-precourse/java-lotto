package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Sample {
    public int stringToInt(String line){ // Lotto-valid-001
        try{
            int number = Integer.parseInt(line);
            if (number % 1000 != 0)
                throw new IllegalArgumentException();
            return number;
        } catch (NumberFormatException e){
            throw new IllegalArgumentException();
        }
    }

    public List<Lotto> getLottos(int numberPurchase){ // Lotto-create-001
        List<Lotto> lottos = new ArrayList<>();
        for (int nowPurchase = 0; nowPurchase < numberPurchase; nowPurchase++){
            List<Integer> lotto = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            lotto.sort(Comparator.naturalOrder());
            lottos.add(new Lotto(lotto));
        }
        return lottos;
    }
}
