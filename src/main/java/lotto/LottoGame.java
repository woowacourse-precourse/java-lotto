package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoGame {

    public void start() {
        User user = new User();
        user.buyLotto();
        System.out.println("");

        inputWinningNumber();
    }

    public void inputWinningNumber() {
        Lotto mainNumber = new Lotto(inputMainNumber());
        LottoNumber bonusNumber = new LottoNumber(bonusNumber());
        compareMainWithBouns(mainNumber.getNumbers(),bonusNumber.getNumber());
    }

    public List<Integer> inputMainNumber() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String[] splitInputValue = Console.readLine().split(",");
        List<String> rawMainNumber = Arrays.asList(splitInputValue);
        List<Integer> mainNumbers = convertToNumber(rawMainNumber);
        for (int oneNumber : mainNumbers) {
            LottoNumber lottoMain = new LottoNumber(oneNumber);
        }

        return mainNumbers;
    }

    public List<Integer> convertToNumber(List<String> winningNumber) {
        List<Integer> winningNumbers = winningNumber.stream()
                .map(s -> Integer.parseInt(s))
                .collect(Collectors.toList());
        return winningNumbers;
    }

    public int bonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        int inputBonusNumber = Integer.parseInt(Console.readLine());
        return inputBonusNumber;
    }

    public void compareMainWithBouns(List<Integer> winningNumbers, int inputBonusNumber) {
        if (winningNumbers.contains(inputBonusNumber)) {
            throw new IllegalArgumentException("보너스 번호가 당첨 번호에 포함되어 있습니다.");
        }
    }

}
