package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import static lotto.validation.*;
import static lotto.calculation.*;

public class Application {

    public static void main(String[] args) {
        System.out.println("구입금액을 입력해 주세요.");
        int lottoCount = validateBudget(Console.readLine());
        List<Lotto> lottoArray = generateLottoNumbers(lottoCount);
        System.out.println("당첨 번호를 입력해 주세요.");
        Lotto lottoAnswer = validateLottoAnswers(Console.readLine());
        System.out.println("보너스 번호를 입력해 주세요.");
        int bonusNumber = validateBonusNumber(lottoAnswer.getNumbers(), Console.readLine());
        printLottoResult(lottoCount, lottoArray, lottoAnswer.getNumbers(), bonusNumber);
    }

    public static void printLottoResult(int budget, List<Lotto> lottoArray, List<Integer> lottoAnswer, int bonusNumber){
        List<WinningType> result = calculateResultAll(lottoArray, lottoAnswer, bonusNumber);
        double returnRate = calculateReturnRate((budget*1000), result);
        System.out.println("당첨 통계\n---");
        for(WinningType wt : WinningType.values()) System.out.println(wt.printMessage());
        System.out.println("총 수익률은 " + returnRate + "%입니다.");
    }

    public static List<Lotto> generateLottoNumbers(int count){
        List<Lotto> lottoArray = new ArrayList<>();
        for(int i=0; i<count; i++){
            List<Integer> numberList = Randoms.pickUniqueNumbersInRange(1,45,6);
            Lotto lotto = new Lotto(numberList);
            lottoArray.add(lotto);
            System.out.println(lotto.getNumbers());
        }
        return lottoArray;
    }

    public static boolean isUniqueList(List<Integer> numberList){
        for(int i=0; i<numberList.size(); i++){
            int elem = numberList.get(i);
            if(numberList.indexOf(elem) != numberList.lastIndexOf(elem)) return false;
        }
        return true;
    }

    public static void throwException(String message){
        System.out.println("[ERROR] " + message);
        throw new NoSuchElementException("[ERROR] " + message);
    }

}
