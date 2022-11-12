package lotto.domain;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class User {
    public static final int lottoPrice = 1000;
    private int money;
    private List<Lotto> lottos;

    public User() {
    }

    public void buy() throws IllegalArgumentException {
        String amount = Console.readLine();
        validate(amount);
    }

    private void validate(String amount) throws IllegalArgumentException {
        isNumeric(amount);
        isCorrectPrice(amount);
    }

    private void isNumeric(String amount) throws IllegalArgumentException {
        if (!amount.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException();
        }
    }

    private void isCorrectPrice(String amount) throws IllegalArgumentException {
        if (Integer.parseInt(amount) % lottoPrice != 0) {
            throw new IllegalArgumentException();
        }
    }


    private void setMoney(int money) {
        this.money = money;
    }

    private void setLottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }
}
