package lotto;

import java.util.List;
import java.util.regex.Pattern;

public class User {
    private final Integer money;
    private final List<Lotto> lottos;

    public User(String userInput, List<Lotto> lottos) {
        validate(userInput);
        Integer money = userInputToMoney(userInput);
        this.money = money;
        this.lottos = lottos;
    }

    private void validate(String userInput) {
        String form = "[-+]?\\d*\\.?\\d+";

        if(userInput.matches(form)==false) {
            throw new IllegalArgumentException("[ERROR] 숫자가 아닌 값 입력");
        }

        if(Integer.parseInt(userInput)%1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 1000으로 나눠지지 않는 수 입력");
        }
    }

    private Integer userInputToMoney(String userInput) {
        return Integer.parseInt(userInput);
    }

    public Integer getMoney() {
        return money;
    }

    public void printLottoNumbers() {
        for(Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }
}
