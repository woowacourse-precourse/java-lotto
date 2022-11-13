package controller;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoCompanyService {

    public List<Integer> inputLottoWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String[] inputWinning = (Console.readLine()).split(",");
        List<Integer> inputWinningNumbers = Arrays.stream(inputWinning).map(Integer::parseInt).collect(Collectors.toList());
        return inputWinningNumbers;
    }

    public int inputBonusNumber(){
        System.out.println("보너스 번호를 입력해 주세요.");
        String inputUser = Console.readLine();
        return Integer.parseInt(inputUser);
    }
}
