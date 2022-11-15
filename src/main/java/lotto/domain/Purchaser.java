package lotto.domain;

import lotto.exception.ErrorMessage;
import lotto.utils.LottoGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Purchaser {
    private int money;
    private int numberOfLotto;
    private List<Lotto> lottos;

    public Purchaser(String money) {
        this.money = convertInteger(money);
        validateMoney(this.money);
        this.numberOfLotto = computeNumberOfLotto(this.money);
        lottos = new ArrayList<>();
    }

    public void generateLotto() {
        for (int i = 0; i < numberOfLotto; i++) {
            lottos.add(new Lotto(LottoGenerator.getLottoNumbers()));
        }
    }

    public List<List<Integer>> getLottos() {
        return lottos.stream()
                .map(lotto -> lotto.getNumbers())
                .collect(Collectors.toList());
    }

    public int getMoney() {
        return money;
    }

    private int computeNumberOfLotto(int money) {
        return money / 1000;
    }

    private int convertInteger(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.NOT_NUMBER.getMessage());
        }
    }

    private void validateMoney(int money) {
        if (isLessThan1000(money)) {
            throw new IllegalArgumentException(ErrorMessage.SMALL_NUMBER.getMessage());
        }

        if (!(isDivideBy1000(money))) {
            throw new IllegalArgumentException(ErrorMessage.NOT_DIVIDED.getMessage());
        }
    }

    private boolean isLessThan1000(int money) {
        return money < 1000;
    }

    private boolean isDivideBy1000(int money) {
        if (money % 1000 == 0) {
            return true;
        }
        return false;
    }

}