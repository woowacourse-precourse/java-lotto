package lotto;

import lotto.domain.Compare;
import lotto.domain.GenerateLotto;
import camp.nextstep.edu.missionutils.Console;
import lotto.domain.WinningResult;

import java.util.*;

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
        winningResult.WinningPrice(maxCorrect, maxBonus);
    }

    public static int askLottoPurchase(){
        System.out.println("구입금액을 입력해 주세요.");
        String input = Console.readLine();
        int number = Integer.parseInt(input);

        return number/1000;
    }

    public static List<Integer> askLottoNum(){
        List<Integer> result = new ArrayList<>();
        System.out.println("당첨 번호를 입력해 주세요.");
        String input = Console.readLine();
        for(String number : input.split(",")){
            result.add(Integer.valueOf(number));
        }
        return result;
    }

    public static int askBonusNum(){
        System.out.println("보너스 번호를 입력해 주세요.");
        String input = Console.readLine();
        return Integer.valueOf(input);
    }
}
