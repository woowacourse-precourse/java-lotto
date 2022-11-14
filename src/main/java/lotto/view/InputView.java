package lotto.view;

import java.awt.*;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {

    private static final String DELIMITER = ",";

    private String readLine() {
        return camp.nextstep.edu.missionutils.Console.readLine();
    }

    private void printMessage(String message) {
        System.out.println(message);
    }

    public String requestMoney() {
        return readLine();
    }

    public String requestWinningNumbers() {
//        List<Integer> winningNumbers;
//        try {
//            winningNumbers = convertToLottoNumbers(readLine());
//        } catch (NumberFormatException exception) {
//            throw new IllegalArgumentException();
//        }
        return readLine();
    }

    private List<Integer> convertToLottoNumbers(String input) {
        List<Integer> lottoNumbers = new ArrayList<>();
        StringTokenizer tokenizer = new StringTokenizer(input, DELIMITER);
        while (tokenizer.hasMoreTokens()) {
            lottoNumbers.add(Integer.parseInt(tokenizer.nextToken()));
        }
        return lottoNumbers;
    }

    public String requestBonusNumber() {
        return readLine();
    }
}
