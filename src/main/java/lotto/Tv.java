package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Tv {
    private static final String INPUT_WINNER_NUMBER_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";

    public List<Integer> inputWinnerNumber(List<Integer> winnerNumber) {
        System.out.println(INPUT_WINNER_NUMBER_MESSAGE);
        String input = Console.readLine();
        System.out.println();  // 출력형식에 맞도록 줄바꿈 삽입
        String[] splitString = input.split(",");
        List<String> number = new ArrayList<>();
        for (String s : splitString) {
            number.add(s);
        }

//        for(int i=0;i<number.size();i++){
//            winnerNumber.add(Integer.parseInt(number.get(i)));
//        }

        winnerNumber = number.stream().map(Integer::parseInt).collect(Collectors.toList());
        //유효성검사 필요
        return winnerNumber;
    }

    public int inputBonusNumber() {
        System.out.println(INPUT_BONUS_NUMBER_MESSAGE);
        String input = Console.readLine();
        System.out.println();  // 입력형식에 맞도록 줄바꿈 삽입
        //유효성 검사 필요
        int bonusNumber = Integer.parseInt(input);
        return bonusNumber;
    }

}
