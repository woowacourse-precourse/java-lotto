package lotto.utils;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Input {

    public static Integer inputPrice() {
        String price = readLine();

        //validate
        return Integer.parseInt(price);
    }

    public static List<Integer> inputWinningLotto() {
        List<Integer> winningLottos = new ArrayList<>();
        String inputLottoNumbers = readLine();
        for (String number : inputLottoNumbers.split(",")) {
            winningLottos.add(Integer.parseInt(number));
        }

        //validate
        return winningLottos;
    }

    public static Integer inputBonusNumber() {
        Integer bonusNumber = Integer.parseInt(readLine());

        //validate
        return bonusNumber;
    }
}
