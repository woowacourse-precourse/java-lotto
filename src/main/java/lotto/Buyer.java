package lotto;

import java.util.ArrayList;
import java.util.List;

public class Buyer {


    private static final int LOTTO_PRICE = 1000;


    public List<List<Integer>> buyLotto(int amount) {
        int count = amount / LOTTO_PRICE;

        List<List<Integer>> lottos = new ArrayList<>();

        Generator generator = new Generator();
        for(int i = 0 ; i < count; ++i) {
            lottos.add(generator.createLotto());
        }

      return lottos;
    }

}
