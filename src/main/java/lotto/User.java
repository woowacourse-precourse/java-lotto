package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class User {
    List<List<Integer>> lottoList = new ArrayList<>();

    public int inputMoneyMsg() {
        System.out.println("구입금액을 입력해 주세요.");
        String answer = Console.readLine();
        isNum(answer);
        int money = Integer.parseInt(answer);
        return money;
    }

    public void isNum(String answer) {
        for (char c : answer.toCharArray()) {
            if (!Character.isDigit(c)) {
                throw new IllegalArgumentException("[ERROR] 숫자만 입력해야 합니다.");
            }
        }
    }

    public int moneyToAmount(int money) {
        int amount = money / 1000;
        isThousand(money);
        return amount;
    }

    public void isThousand(int input) {
        if (input % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 1000원 단위로 입력할 수 있습니다.");
        }
    }

    public List<List<Integer>> getLottoList() {
        return lottoList;
    }

    public void setLottoList(List<List<Integer>> lottoList) {
        this.lottoList = lottoList;
    }
}
