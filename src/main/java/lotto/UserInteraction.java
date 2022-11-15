package lotto;

import camp.nextstep.edu.missionutils.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.NoSuchElementException;

public class UserInteraction {

    private final String askText = " 입력해 주세요.";

    public void askInput(String askTarget) {
        System.out.println(askTarget + this.askText);
    }

    public String getInput() {
        String input = "";
        input = Console.readLine();
        return input;
    }

    public int tryParseInt(String input) {
        int changedInput = 0;
        input = input.trim();
        try {
            changedInput = Integer.parseInt(input);
        } catch (Exception e) {
            NoSuchElementException returnException = new NoSuchElementException();
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("[ERROR] 숫자를 입력해야만 합니다.");
            returnException.initCause(illegalArgumentException);
            System.out.println(returnException.getCause().getMessage());
            throw returnException;
        }
        return changedInput;
    }

    public List<Integer> tryParseIntegers(String input) {
        List<String> splitInput = List.of(input.split(","));
        List<Integer> resultNumbers = new ArrayList<>();
        for (String numStr : splitInput) {
            try {
                numStr = numStr.trim();
                resultNumbers.add(tryParseInt(numStr));
            } catch (Exception e) {
                NoSuchElementException returnException = new NoSuchElementException();
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException("[ERROR] 숫자를 입력해야만 합니다.");
                returnException.initCause(illegalArgumentException);
                System.out.println(returnException.getCause().getMessage());
                throw returnException;
            }
        }
        return resultNumbers;
    }

    public void checkNumbers(List<Integer> numbers) {
        HashSet<Integer> tempSet = new HashSet<>(numbers);
        NoSuchElementException returnException = new NoSuchElementException();
        if (tempSet.size() != 6) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("[ERROR] 서로 다른 6자리의 숫자를 입력해야 합니다.");
            returnException.initCause(illegalArgumentException);
            System.out.println(returnException.getCause().getMessage());
            throw returnException;
        }
        for (int number : tempSet) {
            if (number <= 0 && number > 45) {
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException("[ERROR] 1~45 사이의 숫자를 입력 해야만 합니다.");
                returnException.initCause(illegalArgumentException);
                System.out.println(returnException.getCause().getMessage());
                throw returnException;
            }
        }
    }

    public void checkBonusNumber(List<Integer> numbers, int bonusNumber) {
        if (numbers.contains(bonusNumber)) {
            NoSuchElementException returnException = new NoSuchElementException();
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("[ERROR] 보너스 번호는 당첨번호와 중복 될 수 없습니다.");
            returnException.initCause(illegalArgumentException);
            System.out.println(returnException.getCause().getMessage());
            throw returnException;
        }
    }

}
