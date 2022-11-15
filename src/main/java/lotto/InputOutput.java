package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;
import java.util.stream.Stream;

public class InputOutput {

    public int getMoneyInput() {
        String inputMoney = Console.readLine();
        return gameStringToInt(inputMoney);
    }

    private int gameStringToInt(String inputMoney) {
        int money = validateStringToInt(inputMoney);
        validateMoney(money);
        return money;
    }

    private int validateStringToInt(String string) {
        int interger = 0;
        try {
            interger = Integer.parseInt(string);
        } catch (Exception e) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해주세요.");
        }
        return interger;
    }

    private void validateMoney(int money) {
        if (money % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 1000원으로 떨어지는 숫자를 입력해주세요.");
        }
    }

    public void printLotto(List<Lotto> buyerLotto) {
        Stream<Lotto> stream = buyerLotto.stream();
        stream.forEach(Lotto::printLotto);
    }
}
