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
        try {
            Validate.validateDuplication(winningNums);
        }catch (IllegalArgumentException e){
            System.out.println("[ERROR]입력된 로또번호와 중복되는 숫자 입니다.");
        }

        return bonus;
    }





}
