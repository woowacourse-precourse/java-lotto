package lotto.domain;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public  class askPlayer {
    public static int askLottoPurchase(){
        System.out.println("구입금액을 입력해 주세요.");
        String input = Console.readLine();
        int number = Integer.parseInt(input);

        return number/1000;
    }

    public static List<Integer> askLottoNum(){
        List<Integer> result = new ArrayList<>();
        System.out.println("당첨 번호를 입력해 주세요.");
        String input = Console.readLine();
        for(String number : input.split(",")){
            result.add(Integer.valueOf(number));
        }
        return result;
    }

    public static int askBonusNum(){
        System.out.println("보너스 번호를 입력해 주세요.");
        String input = Console.readLine();
        return Integer.valueOf(input);
    }
}
