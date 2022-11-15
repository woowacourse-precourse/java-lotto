package lotto.app;

import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Money;

public class InputService {
    private Validation validation = new Validation();

    public int setMoney(){

        String money;

        System.out.println("구입금액을 입력해 주세요.");
        money = Console.readLine();
        validation.isInteger(money);

        return Integer.valueOf(money);
    }

    public List<Integer> setWinningNumbers(){
        List<Integer> winningNumbers = new ArrayList<>();

        System.out.println("당첨 번호를 입력해 주세요.");
        String[] lawWinningNumbers = Console.readLine().split(",");
        for(int i = 0; i < 6; i++){
            validation.isInteger(lawWinningNumbers[i]);
            winningNumbers.add(Integer.valueOf(lawWinningNumbers[i]));
        }

        return winningNumbers;
    }

    public int setBonusNumber(){
        int bonusNumber;

        System.out.println("보너스 번호를 입력해 주세요.");
        bonusNumber = Integer.valueOf(Console.readLine());

        return bonusNumber;
    }
}
