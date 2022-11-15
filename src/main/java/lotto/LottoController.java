package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LottoController {

    static int howManyLotto(int own_money){
        if(own_money % 1000 !=0) throw new IllegalArgumentException("[ERROR] 1000단위로 나누어 떨어져야합니다.");
        int lottosCount = own_money / 1000;
        System.out.println(lottosCount + "개를 구매했습니다.");
        return lottosCount;
    }
    static List<Integer> createLottoNumber(){
        List<Integer> lottoNumbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1,45,6));
        Collections.sort(lottoNumbers);
        return lottoNumbers;
    }
    static List<List<Integer>> buyLottery(int lottosCount){
        List<List<Integer>> ownLottos = new ArrayList<>();
        List<Integer> lottos;
        for (int i = 0;i<lottosCount;i++) {
            lottos = createLottoNumber();
            ownLottos.add(lottos);
            System.out.println(lottos);
        }
        return ownLottos;
    }


    public static void run() {
        // TODO: 프로그램 구현
        int money;
        int lottosCount;
        List<List<Integer>> lotto_nums;
        List<Integer> winningNumber;
        int bonus;

        try {
            money = input.ownMoney();
            lottosCount = howManyLotto(money);
            lotto_nums = buyLottery(lottosCount);
            winningNumber = input.checkWinningNumber();
            Lotto lotto = new Lotto(winningNumber);
            bonus = input.inputBonus();
            CheckNumber.checkBonusWinnerNumber(lotto,bonus);
            CheckNumber.viewResult(lotto, lotto_nums,bonus,money);
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }
}