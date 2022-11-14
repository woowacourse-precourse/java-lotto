package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class GameManager {

    public void start() {
        UserMoney userMoney = new UserMoney();
        int totalMoney = userMoney.getUserMoney();
        CreateLotto createLotto = new CreateLotto(totalMoney/1000);

        System.out.println(createLotto);
        Lotto winnerLotto = winLotto();
        int bonusNumber = bonusLotto();

        Result result = new Result(createLotto, winnerLotto, bonusNumber);
        System.out.println(result);
    }



    private Lotto winLotto() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String answer = Console.readLine();

        List<Integer> winner = new ArrayList<>();

        String temp[] = answer.split(",");
        for (int i = 0; i < temp.length; i++) {
            winner.add(transInt(temp[i]));
        }

        Lotto lotto = new Lotto(winner);
        return lotto;
    }

    private int transInt(String num) {
        try {
            return Integer.parseInt(num);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    private int bonusLotto() {
        System.out.println("보너스 번호를 입력해 주세요.");

        return transInt(Console.readLine());
    }
}
