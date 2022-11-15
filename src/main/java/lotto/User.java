package lotto;

import java.util.List;

public class User {
    private final Integer money;
    private List<Lotto> lottos;

    public User(String userInput, List<Lotto> lottos) {
        validate(userInput);
        Integer money = userInputToMoney(userInput);
        this.money = money;
        this.lottos = lottos;
    }

    public User(String userInput) {
        validate(userInput);
        Integer money = userInputToMoney(userInput);
        this.money = money;
    }

    public void setLottos(List<Lotto> lottos) {
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

    public void printLottoNumbers() {
        for(Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public Integer getMoney() {
        return money;
    }
}
