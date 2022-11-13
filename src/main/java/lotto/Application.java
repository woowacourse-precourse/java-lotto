package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static lotto.ErrorCheck.*;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        runLottoApp();
    }
    public static void runLottoApp(){

        int lottoCount = howMuchLottoBuy();

        List<Lotto> lotto = issueLotto(lottoCount);

        List<Integer> winningNumber = winningNumberInput();
        Integer bonusNumber = bonusNumberInput();
        checkBonusNumberIncludedWinningNumber(winningNumber, bonusNumber);

        List<Integer> lottoResult = resultWinningLottery(lotto, winningNumber, bonusNumber);
    }
    public static int howMuchLottoBuy(){
        System.out.println("구입금액을 입력해 주세요.");
        String money = readLine();

        moneyErrorCheck(money);

        return Integer.parseInt(money)/1000;
    }

    public static List<Lotto> issueLotto(int lottoCount){
        System.out.println("\n"+lottoCount+"개를 구매했습니다.");
        List<Lotto> lotto = new ArrayList<>();

        for(int i = 0 ; i < lottoCount ; i++){
            List<Integer> lottoNumber = Randoms.pickUniqueNumbersInRange(1,45,6);
            lottoNumber.sort(Comparator.naturalOrder());
            System.out.println(lottoNumber);
            lotto.add(new Lotto(lottoNumber));
        }

        return lotto;
    }
    public static List<Integer> winningNumberInput(){
        System.out.println("\n당첨 번호를 입력해 주세요.");

        String number = readLine();
        List<String> numbers = Arrays.asList(number.split(","));

        winningNumberErrorCheck(numbers);

        List<Integer> winningNumber = new ArrayList<>();

        for(int i = 0 ;  i < numbers.size() ;i++)
            winningNumber.add(Integer.valueOf(numbers.get(i)));

        return winningNumber;
    }
    public static Integer bonusNumberInput(){
        System.out.println("\n보너스 번호를 입력해 주세요.");

        String number = readLine();

        bonusNumberErrorCheck(number);

        Integer bonusNumber = Integer.valueOf(number);

        return bonusNumber;
    }
    public static void checkBonusNumberIncludedWinningNumber(List<Integer> winningNumber, Integer bonusNumber){
        if ( winningNumber.contains(bonusNumber))
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 달라야 합니다.");
    }
    public static List<Integer> resultWinningLottery(List<Lotto> lotto, List<Integer> winningNumber, Integer bonusNumber){
        List<Integer> lottoResult = Arrays.asList(0,0,0,0,0);

        int rank;
        for(int i = 0 ; i < lotto.size() ; i++) {
            rank = lotto.get(i).lottoRanking(winningNumber,bonusNumber);
            if( rank != 0 )
                lottoResult.set( rank-1 , lottoResult.get(rank-1) + 1 );
        }

        return lottoResult;
    }
}
