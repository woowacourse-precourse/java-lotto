
package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Application {
    private static Integer lottoCount;
    private static Lotto winningLotto;
    private static Integer bonusBall;
    private static List<Lotto> lottos;
    private static Integer rankResult[] =new Integer[]{0,0,0,0,0,0};

    private static Integer prizeMoney = 0;

    private static void printLottoRankResult() {
        System.out.println(PrizeEnum.CORRECT_3.getPrizeName() + " - " + rankResult[5] + "개");
        prizeMoney += (PrizeEnum.CORRECT_3.getPrize()) * rankResult[5];
        System.out.println(PrizeEnum.CORRECT_4.getPrizeName() + " - " + rankResult[4] + "개");
        prizeMoney += (PrizeEnum.CORRECT_4.getPrize()) * rankResult[4];
        System.out.println(PrizeEnum.CORRECT_5.getPrizeName() + " - " + rankResult[3] + "개");
        prizeMoney += (PrizeEnum.CORRECT_5.getPrize()) * rankResult[3];
        System.out.println(PrizeEnum.CORRECT_5_bonus.getPrizeName() + " - " + rankResult[2] + "개");
        prizeMoney += (PrizeEnum.CORRECT_5_bonus.getPrize())  * rankResult[2];
        System.out.println(PrizeEnum.CORRECT_6.getPrizeName() + " - " + rankResult[1] + "개");
        prizeMoney += (PrizeEnum.CORRECT_6.getPrize()) * rankResult[1];
    }

    private static void printLottoProfitRateResult() {
        System.out.println("총 수익률은" +Math.round(prizeMoney * 1000 /(lottoCount * 1000) )/ 10.0 +"%입니다.");
    }

    private static void checkLottoResult() {
        for(Lotto lotto : lottos){
            rankResult[lotto.scoreLottoNumbers(winningLotto.getNumbers(), bonusBall)] ++;
        }
        printLottoRankResult();
        printLottoProfitRateResult();
    }


    private static void printPickedLottos(){
        System.out.println(lottoCount + "개를 구매했습니다.");
        for(Lotto lotto : lottos)
            System.out.println(lotto.getNumbers().toString());
    }

    private static List<Integer> pickLottoNums(){
        List<Integer> lottoNumbers = new ArrayList<>();
        lottoNumbers.addAll(Randoms.pickUniqueNumbersInRange(1,46,6));
        Collections.sort(lottoNumbers);
        return lottoNumbers;
    }

    private static void buyLottos(){
        lottos = new ArrayList<>();
        for(int i = 0 ; i < lottoCount ; i++){
            Lotto lotto = new Lotto(pickLottoNums());
            lottos.add(lotto);
        }
        printPickedLottos();
    }

    private static void getUserInput(){
        lottoCount = countLotto(Console.readLine());
        winningLotto = getWinningLotto(Console.readLine());
        bonusBall = getBonusBall(Console.readLine());
    }

    private static void checkIllegalNum(Integer num){
        if(num > 45 || num < 1)
            throw new IllegalArgumentException(ErrorEnum.BAD_REQUEST_NOT_VALID_NUM_EXCEPTION.getMessage());
    }

    public static Integer getBonusBall(String input){
        Integer num = Integer.parseInt(input);
        checkIllegalNum(num);
        if(winningLotto.getNumbers().contains(num))
            throw new IllegalArgumentException(ErrorEnum.BAD_REQUEST_NOT_VALID_NUM_EXCEPTION.getMessage());
        return num;
    }

    public static Lotto getWinningLotto(String input){
        List<Integer> numbers = new ArrayList<>();
        for(String s : input.split(",")){
            Integer num = Integer.parseInt(s);
            checkIllegalNum(num);
            numbers.add(num);
        }
        return new Lotto(numbers);
    }

    public static Integer countLotto(String input){
        Integer money;
        try {
            money = Integer.parseInt(input);
        }catch (Exception e){
            throw new IllegalArgumentException(ErrorEnum.BAD_REQUEST_MONEY_NOT_VALID_EXCEPTION.getMessage());
        }
        if(money%1000 != 0)
            throw new IllegalArgumentException(ErrorEnum.BAD_REQUEST_MONEY_NOT1000_EXCEPTION.getMessage());
        return money/1000;
    }

    public static void main(String[] args) {
        getUserInput();

        buyLottos();

        checkLottoResult();
    }

}

