package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;
import java.util.Map;

public class UserInterface {

    public static int inputMoney(){
        String input;
        int money = 0;

        System.out.println("구입 금액을 입력해 주세요.");
        input = Console.readLine();
        money = onlyNumberInput(input);
        checkDividedOneThousand(money);

        return money;
    }

    public static void checkDividedOneThousand(int money){
        if(money % 1000 != 0){
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1000으로 나누어 떨어져야 합니다.");
        }
    }

    public static int onlyNumberInput(String input){
        try{
            int money;
            money = Integer.parseInt(input);
            return money;
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] 구입 금액은 숫자를 입력해야 합니다.");
            return 0;
        }
    }

    public static void printNumberOfLotto(List<List<Integer>> userLottoNumbers,int inputMoney){
        int games = BuyLotto.numberOfLottoGames(inputMoney);
        System.out.println(games + "개를 구매했습니다.");
        for(int i = 0; i < games; i++){
            System.out.println
                    (BuyLotto.makeLotto(userLottoNumbers));
        }
    }

    public static void inputWinNumbers(List<Integer> inputNumbers){
        System.out.println("\n당첨 번호를 입력해 주세요.");
        String winNumbers = Console.readLine();
        String[] onlyNumbersOfWinNumbers = winNumbers.split(",");

        for(int i = 0 ; i < onlyNumbersOfWinNumbers.length; i++){
            inputNumbers.add(Integer.parseInt(onlyNumbersOfWinNumbers[i]));
        }
    }

    public static void checkWinNumbersContainBonusNumber(List <Integer> inputNumbers, int bonusNumber){
        if(inputNumbers.contains(bonusNumber)){
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복되면 안됩니다.");
        }
    }

    public static int inputBonusNumber(List<Integer> lottoNumbers){
        int bonusNumber = 0;

        System.out.println("\n보너스 번호를 입력해 주세요.");
        bonusNumber = Integer.parseInt(Console.readLine());
        checkWinNumbersContainBonusNumber(lottoNumbers,bonusNumber);

        return bonusNumber;
    }

    private static String messageWinStatstic(int index,int numberOfLotto){
        List<String> eachMessageWinStatistic = List.of
                ("3개 일치 (5,000원) - " + numberOfLotto + "개",
                        "4개 일치 (50,000원) - " + numberOfLotto + "개",
                        "5개 일치 (1,500,000원) - " + numberOfLotto + "개",
                        "5개 일치, 보너스 볼 일치 (30,000,000원) - " + numberOfLotto + "개",
                        "6개 일치 (2,000,000,000원) - " + numberOfLotto + "개");

        return eachMessageWinStatistic.get(index);
    }

    public static void printWinStatics(Map<Integer,Integer> winStatistics){
        int noPrice = 4;
        int numberOfMessage = 5;

        System.out.println("\n당첨 통계\n---");
        for(int i = winStatistics.size()-noPrice ; i > 0 ;i--){
            System.out.println(messageWinStatstic(numberOfMessage-i,winStatistics.get(i)));
        }
    }

    public static void printYield(int inputMoney,Map <Integer,Integer> winStatistics){
        double yeild = BuyLotto.yieldOfLotto(inputMoney,winStatistics);
        System.out.println("총 수익률은 " + yeild + "%입니다.");
    }
}
