package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class User {
    public static final int ONEGAMECOST = 1000;
    public static final int GAMEOVER = -1;
    public int gameMoney;

    public int inputMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        String inputMoney = Console.readLine();
        gameMoney = validate(inputMoney);
        if (gameMoney == GAMEOVER) {
            return GAMEOVER;
        }
        validate(gameMoney);
        return gameMoney;
    }

    public void validate(int gameMoney) {
        if (gameMoney % ONEGAMECOST != 0) {
            throw new IllegalArgumentException("[ERROR]금액이 잘못되었습니다. 1000 단위로 입력해주세요.");
        }
        if (gameMoney == 0) {
            throw new IllegalArgumentException("[ERROR]금액이 0 입니다.");
        }
    }

    public int validate(String inputMoney) {
        try {
            return Integer.parseInt(inputMoney);
        } catch (NumberFormatException e) {
            System.out.println("[ERROR]에러입니다 에러에요!!");
            return GAMEOVER;
        }
    }

    public List<List<Integer>> buyLotto() {
        List<List<Integer>> totalBuyLotto = new ArrayList<>();
        int lottoAmount = inputMoney() / 1000;
        for (int i = 0; i < lottoAmount; i++) {
            totalBuyLotto.add(Lotto.create());
        }
        System.out.println();
        System.out.println(totalBuyLotto.size() + "개를 구매했습니다.");
        for (List<Integer> eachLotto : totalBuyLotto) {
            System.out.println(eachLotto);
        }
        return totalBuyLotto;
    }

}
