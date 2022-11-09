package lotto;

import camp.nextstep.edu.missionutils.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class UserInterface {
    int getPurchasePrice(){
        System.out.println("구입금액을 입력해 주세요.");
        return Integer.parseInt(Console.readLine());
    }

    void printLottos(List<Lotto> lottos) {
        System.out.println(lottos.size() + "개를 구매했습니다.");
        lottos.forEach(System.out::println);
    }

    List<Integer> getWinningNumber(){
        System.out.println("구입금액을 입력해 주세요.");
        String userInput = Console.readLine();
        List<Integer> winningNumbers = Arrays.stream(userInput.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        System.out.println("보너스 볼을 입력해 주세요.");
        int bonus = Integer.parseInt(Console.readLine());
        winningNumbers.add(bonus);

        return winningNumbers;
    }

    void printResultRank(int first, int second, int thirth, int fourth, int fifth) {
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - "+fifth+"개");
        System.out.println("4개 일치 (50,000원) - "+fourth+"개");
        System.out.println("5개 일치 (1,500,000원) - "+thirth+"개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - "+second+"개");
        System.out.println("6개 일치 (2,000,000,000원) - "+first+"개");
    }

    void printRateReturn(double rateOfReturn){
        System.out.println("총 수익률은 "+rateOfReturn+"입니다.");
    }
}
