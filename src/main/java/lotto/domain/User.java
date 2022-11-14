package lotto.domain;

import camp.nextstep.edu.missionutils.Console;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class User {
    public static final int ONEGAMECOST = 1000;
    public static final int GAMEOVER = -1;
    public static final int ZERO = 0;
    public static final String INPUT_FORMAT_ERROR = "[ERROR]금액이 잘못되었습니다. 1000 단위로 입력해주세요.";
    public static final String INPUT_MONEY_ZERO = "[ERROR]금액이 0 입니다.";
    public static final String INPUT_NOTNUMBER_ERROR = "[ERROR]입력금액은 문자열이 들어올 수 없습니다.";
    public int gameMoney;

    public int inputMoney() {
        InputView.gameStart();
        String inputMoney = Console.readLine();
        gameMoney = validate(inputMoney);
        if (gameMoney == GAMEOVER) {
            return GAMEOVER;
        }
        validate(gameMoney);
        return gameMoney;
    }

    public void validate(int gameMoney) {
        if (gameMoney % ONEGAMECOST != ZERO) {
            throw new IllegalArgumentException(INPUT_FORMAT_ERROR);
        }
        if (gameMoney == ZERO) {
            throw new IllegalArgumentException(INPUT_MONEY_ZERO);
        }
    }

    public int validate(String inputMoney) {
        try {
            return Integer.parseInt(inputMoney);
        } catch (NumberFormatException e) {
            System.out.println(INPUT_NOTNUMBER_ERROR);
            return GAMEOVER;
        }
    }

    public List<List<Integer>> buyLotto() {
        List<List<Integer>> totalBuyLotto = new ArrayList<>();
        int lottoAmount = inputMoney() / ONEGAMECOST;
        for (int i = 0; i < lottoAmount; i++) {
            totalBuyLotto.add(Lotto.create());
        }
        OutputView.blankLine();
        System.out.println(totalBuyLotto.size() + "개를 구매했습니다.");
        for (List<Integer> eachLotto : totalBuyLotto) {
            System.out.println(eachLotto);
        }
        return totalBuyLotto;
    }

}
