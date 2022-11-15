package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Application {
    private static void CheckSmallMoney(int money){
        if(money % 1000 != 0){
            throw new IllegalArgumentException("[ERROR] 로또는 1000원 단위로 구매가 가능합니다.");
        }
    }
    public static int BuyLotto(int money){
        CheckSmallMoney(money);
        return money / 1000;
    }
    public static ArrayList<Integer> GetWinningNumbers(){
        ArrayList<Integer> winningNumbers = new ArrayList<>();
        String[] input = Console.readLine().split(",");

        for(int i=0; i<6;i++){
            winningNumbers.add(i, Integer.valueOf(input[i]));
        }
        return winningNumbers;
    }

    public static int GetBounusNumber(){
        return Integer.parseInt(Console.readLine());
    }
    public static void main(String[] args) {
        System.out.println("구입금액을 입력해 주세요.");
        int customerMoney = Integer.parseInt(Console.readLine());

        int numberOfLottos = BuyLotto(customerMoney);
        System.out.println(numberOfLottos+"개를 구매했습니다.");

        List<Lotto> lottos = LottoMachine.makeLotto(numberOfLottos);
        for(Lotto lotto: lottos){
            lotto.print();
        }

        System.out.println("당첨 번호를 입력해 주세요.");
        ArrayList<Integer> winningNumbers = GetWinningNumbers();

        System.out.println("보너스 번호를 입력해 주세요.");
        int customerBounusNumber = GetBounusNumber();

        List<String> result = new ArrayList<>();
        for(Lotto lotto: lottos){
            Prize prize = new Prize(winningNumbers, lotto, customerBounusNumber);
            String count = prize.print();
            result.add(count);
        }

        System.out.println("당첨 통계");
        System.out.println("---");
        printResults.total(result);
        double yeild = WinningRate.calculateYeild(result, customerMoney);
        System.out.println("총 수익률은 " + yeild +"%입니다.");
    }
}
