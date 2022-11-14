package lotto.domain;

import camp.nextstep.edu.missionutils.Console;

public class UserNumberGenerator {
    private final int countingNumber = 1000;

    public int inputPrice(){
        int price = Integer.valueOf(Console.readLine());
        return price/countingNumber;
    }


}
