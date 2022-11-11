package lotto;

import camp.nextstep.edu.missionutils.*;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class UserInterface {
    int getPurchasePrice(){
        System.out.println("구입금액을 입력해 주세요.");
        try {
            return Integer.parseInt(Console.readLine());
        }catch(Exception e) {
            throw new IllegalArgumentException("[ERROR]");
        }
    }

    void printLottos(List<Lotto> lottos) {
        System.out.println(lottos.size() + "개를 구매했습니다.");
        for(Lotto lotto : lottos){
            System.out.println(lotto.getNumbers());
        }
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

    void printResultRank(Map<Rank, Integer> rankCount) {
        System.out.println("당첨 통계");
        System.out.println("---");
        Arrays.stream(Rank.values())
                .sorted(Comparator.reverseOrder())
                .filter(rank -> rank != Rank.NOTHING)
                .map(rank -> rank.getNumberOfRight() + "개 일치" + (rank == Rank.SECOND ? ", 보너스 볼 일치" : "") + " (" + rank.getFormatPrizeMoney() + "원) - " + rankCount.get(rank) + "개")
                .forEach(System.out::println);
    }

    int getBonusNumber(){
        System.out.println("보너스 볼을 입력해 주세요.");
        int bonus = Integer.parseInt(Console.readLine());

        return bonus;
    }

    void printRateReturn(double rateOfReturn){
        System.out.println("총 수익률은 "+rateOfReturn+"입니다.");
    }
}
