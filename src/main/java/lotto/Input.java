package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Input {
    private final int MONEY_UNIT = 1000;
    private final int LOTTO_NUMBER = 6;
    private final String INPUT_MESSAGE = "구입금액을 입력해 주세요.";

    public int getMoney() {
        System.out.println(INPUT_MESSAGE);
        String input = Console.readLine();

        if(!isValidMoney(input)){
            throw new IllegalArgumentException();
        }

        return Integer.parseInt(input);
    }

    public void createLottos(int money) {
        int count = money/MONEY_UNIT;
        Set<Lotto> lottoSet = new HashSet<>();

        while(lottoSet.size() == count) {
            Lotto lotto = new Lotto(Randoms.pickUniqueNumbersInRange(1,45,6));
            lottoSet.add(lotto);
        }
    }


    //Validator 클래스
    public boolean isNumber(String input) {
        return input.chars().allMatch(Character::isDigit);
    }

    public boolean isValidMoney(String input) {
        if (!isNumber(input)) {
            return false;
        }

        int money = Integer.parseInt(input);
        return money%MONEY_UNIT ==0;
    }

}
