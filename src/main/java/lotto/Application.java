package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class Application {


    public static void main(String[] args) {
        Notice notice = new Notice();
        User user = new User();

        notice.purchasePrice();
        user.setPurchasePrice();
        int purchaseNumber = user.getPurchaseNumber();
        notice.purchaseNumber(purchaseNumber);
        ArrayList<Lotto> lottos = getLottos(purchaseNumber);

//        for (Lotto lotto : lottos) {
//            System.out.println(lotto.getNumbers());
//        }
    }

    public static ArrayList<Lotto> getLottos(int purchaseNumber) {
        ArrayList<Lotto> lottos = new ArrayList<>();

        for (int index = 0; index < purchaseNumber; index++) {
            Lotto lotto = new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            lottos.add(lotto);
        }

        return lottos;
    }
}
