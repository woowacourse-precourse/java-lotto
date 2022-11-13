package lotto;


import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application {
    public static void main(String[] args) {

        System.out.println("구입금액을 입력해 주세요.");
        int userPrice = Integer.parseInt(Console.readLine()); // '.'의 개수가 많아 메소드를 생성하여 추가 수정 필요,

        Buy userBuy = new Buy(userPrice);
        userBuy.printRandomLotto();

        System.out.println("당첨 번호를 입력해 주세요.");
        String userSelecteNumbers = Console.readLine();
        String[] numbers = userSelecteNumbers.split(",");
        List<String> userNumbers = new ArrayList<String>(Arrays.asList(numbers));

        for(String a : userNumbers) System.out.println(a);

//        Lotto userLotto = new Lotto(userNumbers);
    }
}
