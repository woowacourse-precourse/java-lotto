package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoMachine {
    public void inputWinningNumber() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String inputNumber = Console.readLine();
        List<Integer> winningNumber = splitNumber(inputNumber);

    }

    public List<Integer> splitNumber(String number) {
        List<String> winningNumber = Arrays.asList(number.split(","));

        //String형 리스트를 int형 리스트로 변경
        return winningNumber.stream()
                .map(s -> Integer.parseInt(s))
                .collect(Collectors.toList());
    }

    public void inputBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        String bonusNumber = Console.readLine();
    }
}
