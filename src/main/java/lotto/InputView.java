package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {

    public static int inputPrice() {
        System.out.println("구입금액을 입력해 주세요.");
        int inputPrice = Integer.parseInt(Console.readLine());
        LottoPrice.checkPrice(inputPrice);

        return inputPrice;
    }

    public static WinNumber inputWinNumber() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String inputWinNumbers = Console.readLine();

        List<Integer> winNumbers = Arrays.stream(inputWinNumbers.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        return new WinNumber(winNumbers);
    }
}
