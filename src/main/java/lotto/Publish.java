package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Publish {



    public static List<Lotto> makeLottoNums(int lotto_cnt) {
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i<lotto_cnt; i++){
            List<Integer> nums = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            nums = OrderASC(nums);
            Print.printNumbers(nums);
            Lotto lotto = new Lotto(nums);
            lottos.add(lotto);

        }


        return lottos;
    }

    public static Lotto publishLotto(List<Integer> winningNums){

        return new Lotto(winningNums);

    }

    public static int getBonusNum(List<Integer> winningNums){
        int bonus = InputNum.askBonusNum();

        winningNums.add(bonus);
        Validate.validateDuplication(winningNums);

        return bonus;
    }


    public static List<Integer> OrderASC(List<Integer> nums){
        Collections.sort(nums);
        return nums;
    }



}
