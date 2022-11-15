package lotto;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;
public class Game {

    private static Integer setBuyLottoCount(){
        System.out.println("구입 금액을 입력해주세요.");
        String count = camp.nextstep.edu.missionutils.Console.readLine();
        int buyLottoCount = Check.convertMoneytoCount(count);
        buyLottoCount = Check.divideThousand(buyLottoCount);
        System.out.println(buyLottoCount+"개를 구매했습니다.");
        return buyLottoCount;
    }
    private static List<Lotto> setLottoBuckets(int buyLottoCount){
        List<Lotto> lottoBuckets = new ArrayList<>();
        for (int i=0;i<buyLottoCount;i++) {
            List<Integer> numbers=new ArrayList<>();
            List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            numbers.addAll(randomNumbers);
            Collections.sort(numbers);
            Lotto lotto = new Lotto(numbers);
            lottoBuckets.add(lotto);
        }
        return lottoBuckets;
    }
    private static void printLottoBuckets(List<Lotto> lottoBuckets){
        for(Lotto lotto : lottoBuckets){
            lotto.printNumbers();
        }
    }

}
