package lotto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.Lotto;

public class Application {
    public static void main(String[] args) {

        Lotto lotto = new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));

        List<Integer> lottoNumbers = lotto.numbers();
        System.out.println(lottoNumbers);

        Collection<Integer> regularLotto = new ArrayList(lottoNumbers);

        List<Integer> bonusNum = new ArrayList<>();
        while (bonusNum.size()<1){
            int bonus = Randoms.pickNumberInRange(1,45);
            if(!bonusNum.contains(lottoNumbers)){
                bonusNum.add(bonus);
            }
        }
        System.out.println(bonusNum);




    }
//        lotto.getNumbers();
//        System.out.println(lotto.getNumbers());
////        while (bonus.getBonusNum().contains(lotto)) {
////            bonus.getBonusNum();
////        }
//        System.out.println(lotto.getNumbers());
////        System.out.println(bonus.getBonusNum());
////
////        if (lotto.getNewNumbers().contains(bonus.getBonusNum())) {
////            System.out.println("Redundant");
////        } else {
////            System.out.println("Independent");
////        }
//
//    }
}
