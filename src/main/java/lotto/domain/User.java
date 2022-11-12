package lotto.domain;

import lotto.Lotto;

import java.util.List;

public class User {
    private int id;
    private Integer amount;

    private List<Lotto> lottos;

    public User(String amount) {
        validate(amount);
        this.amount= toInt(amount);
    }

    private void validate(String userInput) {
        try {
            int amount = toInt(userInput);
            if(amount%1000!=0) throw new IllegalArgumentException("1000원 단위 숫자를 입력해주세요");
        }catch (NumberFormatException e){
            throw new IllegalArgumentException("숫자를 입력해주세요");
        }
    }

    private static int toInt(String amount) {
        return Integer.parseInt(amount);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setLottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
