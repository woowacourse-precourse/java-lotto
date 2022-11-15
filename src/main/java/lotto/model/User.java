package lotto.model;

import camp.nextstep.edu.missionutils.Console;
import lotto.validation.InputValidation;

import java.util.ArrayList;
import java.util.List;

public class User {
    private final InputValidation inputValidation = new InputValidation();
    private int countLotto;
    private final List<Lotto> lottos = new ArrayList<>();

    public int getCountLotto() {
        return countLotto;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public void inputPrice() {
        String price = Console.readLine();
        inputValidation.validatePrice(price);
        countLotto = calculateCountLotto(price);
    }

    private int calculateCountLotto(String line) {
        return Integer.parseInt(line) / 1000;
    }

    public void addLotto(Lotto lotto) {
        lottos.add(lotto);
    }
}
