package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class User {
    int lottoCount;


    public int inputPrice() {
        String amount = Console.readLine();
        if(!Validator.isNumeric(amount) || !Validator.isThousands(amount)) {
           return -1;
        }
        lottoCount = Integer.parseInt(amount) / 1000;
        return lottoCount;
    }

    public List<Integer> inputLottoNumbers() {
        Message.requestLottoNumbers();
        String numbers = Console.readLine();
        //todo 중복 불가, 범위 확인 validation 추가
        List<String> winningNumbers = Arrays.asList(numbers.split(","));
        return winningNumbers.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public int inputBonusNumbers() {
        Message.requestBonusNumber();
        //todo validation 추가
        return Integer.parseInt(Console.readLine());

    }
}
