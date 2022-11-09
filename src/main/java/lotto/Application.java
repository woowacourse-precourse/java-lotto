package lotto;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application {
    static final int LOTTO_PRICE = 1000;
    static final String ENTER_WINNING_NUMBER = "당첨 번호를 입력해 주세요.";
    public static void main(String[] args) {
        generateSixNumbers();
    }

    public static int enterTheAmount(){
        System.out.println("구입금액을 입력해 주세요.");
        int amount = Integer.parseInt(Console.readLine());
        if(amount%LOTTO_PRICE!=0) throw new IllegalArgumentException();
        return amount/LOTTO_PRICE;
    }

    public static Lotto generateSixNumbers(){
        System.out.println(ENTER_WINNING_NUMBER);
        String inputNumbers = Console.readLine();
        String[] winningNumbersAsString = inputNumbers.split(",");
        List<Integer> winningNumbers = new ArrayList<>();
        for (String number: winningNumbersAsString) winningNumbers.add(Integer.parseInt(number));
        return new Lotto(winningNumbers);
    }

}
