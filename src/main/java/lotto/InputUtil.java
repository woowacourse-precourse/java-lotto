package  lotto;

import java.util.ArrayList;
import java.util.List;
import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputUtil {
    public String inputMoney() {
        String money = readLine();
        return money;
    }
    public String inputLottoNumber() {
        String inputNumbers = readLine();
        return inputNumbers;
    }

    public String[] splitLottoNumber() {
        String numbers = inputLottoNumber();
        String[] arrayNumbers = numbers.split(",");
        return arrayNumbers;
    }

    public List<Integer> lottoNumber() {
        String[] arrayNumbers = splitLottoNumber();
        List<Integer> numbers = new ArrayList<>();
        for (int i=0;i<arrayNumbers.length;++i)
            numbers.add(i);
        return numbers;
    }
}