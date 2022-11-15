package lotto.domain;

import camp.nextstep.edu.missionutils.Console;
import lotto.exception.InvalidUserInputException;

import java.util.ArrayList;
import java.util.List;

public class User {

    private int amount = 0; // 구입 금액
    private List<Lotto> buyLottos = new ArrayList<>();

    public void enterLottoBuyAmount() {
        try {
            amount = Integer.valueOf(Console.readLine());

            if (amount % 1000 != 0) {
                throw new InvalidUserInputException("[ERROR] 1000원 단위로 입력하셔야 합니다.");
            }
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] 숫자로 입력해 주세요");
            //throw new InvalidUserInputException("[ERROR] 숫자로 입력해 주세요");
        }
    }

    public void setBuyLottos(List<Lotto> lottos) {
        this.buyLottos = lottos;
    }

    public int getGameCount() {
        return amount / 1000;
    }

    public List<Lotto> getUserLottos() {
        return this.buyLottos;
    }

}
