package view;


import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class Input {

    public static final int MINIMUM = 1;
    public static final int MAXIMUM = 45;
    public static final int LOTTO_SIZE = 6;

    public static String inputNumber() {
        String outputNumber = Console.readLine();
        return outputNumber;
    }

    public static List makeRandomNumber() {
        List<Integer> randomNumbers;
        randomNumbers = Randoms.pickUniqueNumbersInRange(MINIMUM, MAXIMUM, LOTTO_SIZE);
        return randomNumbers;
    }


}
