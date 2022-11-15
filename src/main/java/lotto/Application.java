package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;
import lotto.constant.Constant;

public class Application {
    private static Constant constant = new Constant();
    private static String Answer_Numbers = "당첨 번호를 입력해 주세요.";
    private static String Regex = ",";
    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }
    
    public static Lotto MakeAnswer() {
        List<String> winning = new ArrayList<>();
        List<Integer> WinningNumberSet = new ArrayList<>();

        System.out.println(Answer_Numbers);
        String Winning_Numbers;

        if((Winning_Numbers = Console.readLine()) != null){
            String[] split_number = Winning_Numbers.split(Regex);
            for(String s: split_number)
                winning.add(s);
        }

        if(winning.stream().distinct().count() != winning.size())
            throw new IllegalArgumentException(constant.Print_Duplicate_Numbers());
        System.out.println(winning);

        for(String number : winning)
            WinningNumberSet.add(Integer.parseInt(number));
        return new Lotto(WinningNumberSet);
    }
}
