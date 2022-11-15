package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.*;
import java.io.*;

import static java.lang.Integer.parseInt;

public class InputView {
    public static int inputLottoAmount() {

        OutputView.printInputAmount();
        String money = Console.readLine();
        if(!money.matches("^[0-9]+$")) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.s");
        }

        int amount = parseInt(money);

        if(amount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 1000원 단위로 구입해야 합니다.");
        }
        return amount;
    }

    public static List<Integer> inputWinningNumbers() {
        OutputView.printWinningNumbers();
        String numberInput = Console.readLine();
        System.out.println(numberInput);
        String[] numbers = numberInput.split(",");
        List<String> numberList = new ArrayList<>(List.of(numbers));

        List<Integer> winningNumbers = numberList.stream()
                .map(number -> parseInt(number))
                .collect(Collectors.toList());

        return winningNumbers;
    }

    public static int inputBonusNumber() {
        OutputView.printBonusNumber();
        String bonusNumber = Console.readLine();
        System.out.println(bonusNumber);
        return parseInt(bonusNumber);
    }
}
// 필요한 부분 validate 추가
