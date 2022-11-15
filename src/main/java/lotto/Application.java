package lotto;

import lotto.domain.Compare;
import lotto.domain.GenerateLotto;
import lotto.domain.WinningResult;
import java.util.*;
import static lotto.domain.askPlayer.*;

public class Application {
    public static void main(String[] args) {
        GenerateLotto generator =  new GenerateLotto();
        List<List<Integer>> lottoNumbers = new ArrayList<>();
        int buyLotto = askLottoPurchase();
        int maxCorrect = 0;
        int maxBonus = 0;
        WinningResult winningResult = new WinningResult();
        System.out.println(buyLotto+"개를 구매했습니다.");
        for (int i = 0; i < buyLotto; i++) {
            List<Integer> lottoNumber = generator.createLotto();
            lottoNumbers.add(lottoNumber);
        }
        for (int i = 0; i < lottoNumbers.size(); i++) {
            System.out.println(lottoNumbers.get(i));
        }
        List<Integer> askLottoNum = askLottoNum();
        int BonusNum = askBonusNum();
        Compare compare = new Compare();
        for (int i = 0; i < lottoNumbers.size(); i++) {
            int bonusBall = compare.bonusNumber(lottoNumbers.get(i), BonusNum);
            int result = compare.correctCount(lottoNumbers.get(i),askLottoNum);
            if(result > maxCorrect){
                maxCorrect = result;
                maxBonus = bonusBall;
            }
        }
        System.out.println(maxCorrect);
        System.out.println(maxBonus);
        int price = winningResult.WinningPrice(maxCorrect, maxBonus);
        double yield = (double)Math.round(price - (buyLotto*1000))/100;
        System.out.println("총 수익률은 "+ yield +"%입니다.");
    }


}
