package lotto;


import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        int userPrice = inputUserPrice();

        Buy userBuy = new Buy(userPrice);
        userBuy.printRandomLotto();

        List<String> userNumbers = inputNumbers();

        for(String a : userNumbers) System.out.println(a);
//        System.out.println(userNumbers.get(2));
//        Lotto userLotto = new Lotto(userNumbers);
    }

    private static int inputUserPrice(){
        System.out.println("구입금액을 입력해 주세요.");
        String price = Console.readLine();
        int userPrice = Integer.parseInt(price);

        return userPrice;
    }
    private static List<String> inputNumbers(){
        System.out.println("당첨 번호를 입력해 주세요.");
        String userSelecteNumbers = Console.readLine();
        String[] numbers = userSelecteNumbers.split(",");
        List<String> userNumbers = new ArrayList<String>(Arrays.asList(numbers)); // 로또 클래스의 생성자의 매게변수가 List<String>이므로 정답을 비교할때 자료형을 변환한다.

        return userNumbers;
    }
}
