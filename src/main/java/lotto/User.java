package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class User {
    LotteryResult lotteryResult;

    public int inputPrice() {
        Message.requestPurchase();
        String amount = Console.readLine();
        if(!Validator.isNumeric(amount) || !Validator.isThousands(amount)) {
           return -1;
        }
        return Integer.parseInt(amount) / 1000;
    }

    public void inputWinningNumbers() {
        Message.requestLottoNumbers();
        String numbers = Console.readLine();
        //todo 중복 불가, 범위 확인 validation 추가
        List<String> winningNumbers = Arrays.asList(numbers.split(","));
        lotteryResult.winningNumbers = winningNumbers.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public void inputBonusNumbers() {
        Message.requestBonusNumber();
        //todo validation 추가
        lotteryResult.bonusNumber = Integer.parseInt(Console.readLine());
    }
}
