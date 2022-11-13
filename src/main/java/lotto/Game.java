package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Game {
    public void Jackpot(){
        System.out.println("당첨 번호를 입력해 주세요.");
        String str1 = Console.readLine();
        String[] words = str1.split(",");

        List<Integer> numbers = new ArrayList<>();

        for (String wo : words ){
            numbers.add(Integer.parseInt(wo));
        }
        Lotto lotto = new Lotto(numbers);
        System.out.println(lotto.getNumbers());
    }
}
