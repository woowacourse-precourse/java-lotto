package lotto.veiw;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.constants.ErrorCode;

public class InputHandler {

    public int inputMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        return stringToInt(readLine());
    }

    public List<Integer> inputLotto() {
        System.out.println("당첨 번호를 입력해 주세요.");
        return stringToList(readLine());
    }

    public int inputBonus() {
        System.out.println("보너스 번호를 입력해 주세요.");
        return stringToInt(readLine());
    }

    public List<Integer> stringToList(String readLine) {
        List<String> inputs = List.of(readLine.split(","));
        List<Integer> lottoNumbers = new ArrayList<>();
        for (String input : inputs) {
            try {
                lottoNumbers.add(Integer.valueOf(input));
            } catch (Exception e) {
                throw ErrorCode.NOT_NUMBER.getException();
            }
        }
        return lottoNumbers;
    }

    private int stringToInt(String input) {
        int inputNumber;
        try {
            inputNumber = Integer.valueOf(input);
        } catch (Exception e) {
            throw ErrorCode.NOT_NUMBER.getException();
        }
        return inputNumber;
    }
}
