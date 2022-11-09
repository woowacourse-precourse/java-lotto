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
}
