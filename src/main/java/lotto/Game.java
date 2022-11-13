package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;
import java.util.Set;

public class Game {
    
    public void play(Set<List<Integer>> lottoNumbers) {

        System.out.println("\n당첨 번호를 입력해주세요");
        String inputValue = Console.readLine();
        List<String> inputSplitValues = List.of(inputValue.trim().split(","));
        System.out.println(inputSplitValues);
    }
}
