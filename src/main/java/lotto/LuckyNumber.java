package lotto;

import java.util.ArrayList;
import java.util.List;

public class LuckyNumber {

    List<Integer> luckyNumber = new ArrayList<Integer>();

    public void inputLuckyNumber() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String inputString = camp.nextstep.edu.missionutils.Console.readLine();

        luckyNumber = changeStringToInteger(inputString);

        if (luckyNumber.size() != Unit.LOTTO_NUMBER_UNIT.getUnit()) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 " + Unit.LOTTO_NUMBER_UNIT.getUnit() + "개의 숫자입니다.");
        }
    }

    public List<Integer> changeStringToInteger(String input) {
        List<Integer> inputIntegerList = new ArrayList<Integer>();

        for (String number : input.split(",")) {
            if (!Character.isDigit(number.charAt(0))) {
                throw new IllegalArgumentException("[ERROR] 당첨 번호는 숫자여야 합니다.");
            }
            inputIntegerList.add(Integer.parseInt(number));
        }

        return inputIntegerList;
    }

    public List<Integer> getLuckyNumber() {
        return luckyNumber;
    }
}
