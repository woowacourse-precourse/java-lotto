package lotto;

import static lotto.printUI.*;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

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

    public static void bonusNumberValidationCheck(List<Integer> winningNumbers, Integer bonusNumber) throws IllegalArgumentException{
        try{
            if(winningNumbers.contains(bonusNumber)){
                throw new Exception();
            }
            if(bonusNumber < 1 || bonusNumber > 45){
                throw new Exception();
            }
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }

    public static void winningNumberValidationCheck(List<Integer> winningNumbers) throws IllegalArgumentException{
        try{
            Set<Integer> noDupWinningNumbers = new HashSet<>(winningNumbers);
            if(noDupWinningNumbers.size() != 6){
                throw new Exception();
            }
            for(Integer winningNumber : winningNumbers){
                if(winningNumber < 1 || winningNumber > 45){
                    throw new Exception();
                }
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
        System.out.println("\n" + Lottos.size() + "개를 구매했습니다.");
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
        return winningNumbers;
    }

    public static String getProfitRate(Map<String,Integer> allResult , int money) {
        int totalProfit = allResult.get("3") * 5000 +
                allResult.get("4") * 50000 +
                allResult.get("5") * 1500000 +
                allResult.get("7") * 30000000 +
                allResult.get("6") * 2000000000;

        return String.format("%.1f", ((double) totalProfit / money * 100));
    }

    public static void main(String[] args) {
        printMoneyInputMessage();
        String userMoney = Console.readLine();
        try{
            moneyValidationCheck(userMoney);
        } catch (IllegalArgumentException e){
            printMoneyErrorMessage();
            return;
        }
        int money = Integer.parseInt(userMoney);

        List<Lotto> Lottos = createLottos(money);
        printLottos(Lottos);

        printWinningNumberInputMessage();
        List<Integer> winningNumbers = getWinningNumbers();

        printBonusNumberInputMessage();
        Integer bonusNumber = Integer.parseInt(Console.readLine());

        try {
            winningNumberValidationCheck(winningNumbers);
            bonusNumberValidationCheck(winningNumbers, bonusNumber);
        } catch (IllegalArgumentException e){
            printInputErrorMessage();
            return;
        }

        List<String> counts = new ArrayList<>();
        for(Lotto lotto : Lottos){
            counts.add(compareMyLotto(lotto,winningNumbers,bonusNumber));
        }

        Map<String,Integer> allResult = getAllResult(counts);

        printAnalysisMessage();
        printResult(allResult);

        String totalProfitRate = getProfitRate(allResult, money);
        printProfitRate(totalProfitRate);
    }
}
