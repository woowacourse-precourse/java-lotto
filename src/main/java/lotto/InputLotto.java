package lotto;

import camp.nextstep.edu.missionutils.Console;

public class InputLotto {

    public String inputValueOfUser() {
        String inputValue;
        inputValue = Console.readLine();
        return inputValue;
    }

    public int toInts(String value) {
        return Integer.parseInt(value);
    }

}
