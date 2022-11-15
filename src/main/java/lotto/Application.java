package lotto;


import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        int userPrice = inputUserPrice();

        Buy userBuy = new Buy(userPrice);
        userBuy.printRandomLottos();

        List<Integer> userNumbers = inputNumbers();
        Lotto userLotto = new Lotto(userNumbers);

        int bonus = inputBouns();
        Bonus userBonus = new Bonus(bonus);
    }

    private static int inputUserPrice(){
        System.out.println("구입금액을 입력해 주세요.");
        String price = Console.readLine();
        int userPrice = Integer.parseInt(price);

        return userPrice;
    }

    private static List<Integer> inputNumbers(){
        System.out.println("\n당첨 번호를 입력해 주세요.");
        String userSelecteNumbers = Console.readLine();
        String[] numbers = userSelecteNumbers.split(",");
        List<Integer> userNumbers = new ArrayList<>();
        for(int i =0;i<numbers.length;i++){
            int tempnumber = Integer.valueOf(numbers[i]);
            userNumbers.add(tempnumber);
        }

        return userNumbers;
    }
    private static int inputBouns(){
        System.out.println("\n보너스 번호를 입력해 주세요.");
        String temp = Console.readLine();
        int bouns = Integer.valueOf(temp);

        return bouns;
    }
}
