package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        LottoShop lottoShop = new LottoShop();
        System.out.println(lottoShop.buyLotto());

//        List<Lotto> total = new ArrayList<>();
//
//        total.add(new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6)));
//        total.add(new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6)));
//        total.add(new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6)));
//
//
//        System.out.println(total.get(0).getNumbers());
//        System.out.println(total.get(1).getNumbers());
//        System.out.println(total.get(2).getNumbers());
    }
}
