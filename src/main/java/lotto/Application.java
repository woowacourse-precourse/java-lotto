package lotto;

import static lotto.printUI.*;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Application {
    public static void moneyValidationCheck(String userMoney) throws IllegalArgumentException{
        try{
            Integer.parseInt(userMoney);
            if(Integer.parseInt(userMoney) % 1000 != 0){
                throw new Exception();
            }

        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }

    public static List<Lotto> createLottos(int money){
        int numberOfGames = money / 1000;
        List<Lotto> Lottos = new ArrayList<>();

        for(int i=0; i<numberOfGames; i++){
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Lotto lotto = new Lotto(numbers);
            Lottos.add(lotto);
        }
        return Lottos;
    }

    public static String compareMyLotto(Lotto lotto, List<Integer> winningNumbers, Integer bonusNumber){
        int count = 0;
        for(Integer eachNumber: lotto.asSortedList()){
            if(winningNumbers.contains(eachNumber)){
                count += 1;
            }
        }

        if(count == 5 && lotto.asSortedList().contains(bonusNumber)){
            count += 2;
        }
        return String.valueOf(count);
    }

    public static Map<String,Integer> getAllResult(List<String> counts){
        Map<String,Integer> allResult = new HashMap<>();
            allResult.put("0", 0);
            allResult.put("1", 0);
            allResult.put("2", 0);
            allResult.put("3", 0);
            allResult.put("4", 0);
            allResult.put("5", 0);
            allResult.put("6", 0);
            allResult.put("7", 0);

        for(String count : counts) {
            allResult.put(count, allResult.get(count) + 1);
        }
        return allResult;
    }

    public static List<Integer> getWinningNumbers(){
        String[] userInput = Console.readLine().split(",");
        List<Integer> winningNumbers = new ArrayList<>();

        for(String str : userInput){
            winningNumbers.add(Integer.parseInt(str));
        }

        if (winningNumbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR]잘못된 입력입니다.");
        }
        return winningNumbers;
    }

    public static void main(String[] args) {
        printMoneyInputMessage();
        String userMoney = Console.readLine();
        try{
            moneyValidationCheck(userMoney);
        } catch (Exception e){
            System.out.println("[ERROR]잘못된 입력입니다.");
            return;
        }

        int money = Integer.parseInt(userMoney);

        List<Lotto> Lottos = createLottos(money);

        System.out.println("\n" + Lottos.size() + "개를 구매했습니다.");
        for(Lotto lotto : Lottos){
            System.out.println(lotto.asSortedList());
        }

        printWinningNumberInputMessage();
        List<Integer> winningNumbers = getWinningNumbers();

        printBonusNumberInputMessage();
        Integer bonusNumber = Integer.parseInt(Console.readLine());

        if(winningNumbers.contains(bonusNumber)){
            throw new IllegalArgumentException("[ERROR]잘못된 입력입니다.");
        }

        List<String> counts = new ArrayList<>();
        for(Lotto lotto : Lottos){
            counts.add(compareMyLotto(lotto,winningNumbers,bonusNumber));
        }

        Map<String,Integer> allResult = getAllResult(counts);

        printAnalysisMessage();
        printResult(allResult);
        printProfitRate(allResult, money);
    }
}
