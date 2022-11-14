package lotto;

import java.util.ArrayList;
import java.util.List;

public class Buyer {
    private static final int LOTTO_PRICE = 1000;
    public static List<Lotto> buyLotto(int amount) {
        int count = amount / LOTTO_PRICE;

        List<Lotto> lottos = new ArrayList<>();

        Generator generator = new Generator();
        for(int i = 0 ; i < count; ++i) {
            lottos.add(generator.createLottoNumber());
        }

      return lottos;
    }

}
