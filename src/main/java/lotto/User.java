package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class User {
    int price;
    public int inputPrice() {
        Message.requestPurchase();
        String amount = Console.readLine();
        if(!Validator.isNumeric(amount) || !Validator.isThousands(amount)) {
           return -1;
        }
        price = Integer.parseInt(amount);
        return price / 1000;
    }

    public Lotto inputWinningNumbers() {
        Message.requestLottoNumbers();
        String numbers = Console.readLine();
        //todo 중복 불가 validation 추가
        try {
            List<String> winningNumbers = Arrays.asList(numbers.split(","));
            for(String input : winningNumbers) {
                validate(Integer.parseInt(input));
            }
            return new Lotto(winningNumbers.stream()
                    .map(Integer::parseInt)
                    .collect(Collectors.toList()));
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("[ERROR] 입력은 ',' 로 구분되며 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    public int inputBonusNumbers() {
        Message.requestBonusNumber();
        //todo validation 추가
        return Integer.parseInt(Console.readLine());
    }

    public void validate(int num) {
        if(num < 1 || num > 45) {
            throw new IllegalArgumentException("[ERROR] 숫자의 범위를 확인해주세요.(1 ~ 45)");
        }
    }
}
