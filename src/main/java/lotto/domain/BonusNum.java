package lotto.domain;


import camp.nextstep.edu.missionutils.Console;

public class BonusNum {

    public int getNewBonusNum() {
        String inputString = Console.readLine();
        return Integer.parseInt(inputString);
    }
}
