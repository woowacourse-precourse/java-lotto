package lotto.controller;

import lotto.model.Lotto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Controller {

    public int getPrice() {
        String price = readLine();
        return Integer.parseInt(price);
    }

    public Lotto getWinningLotto() {
        String winningLotto = readLine();
        List<Integer> winningLottoNumbers = Arrays.stream(winningLotto.split(","))
                .map(w -> Integer.parseInt(w))
                .collect(Collectors.toList());
        return new Lotto(winningLottoNumbers);
    }

    public int getBonusNum() {
        String bonusNum = readLine();
        return Integer.parseInt(bonusNum);
    }
}
