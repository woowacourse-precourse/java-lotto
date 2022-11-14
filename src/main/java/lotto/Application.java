package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int purchasePrice = getPurchasePrice(Console.readLine());
        List<Integer> winningLottoNumbers = getWinningLottoNumbers(Console.readLine());
    }

    public static int getPurchasePrice(String input){
        return Integer.parseInt(input);
    }

    public static List<Integer> getWinningLottoNumbers(String input){
        String[] inputNumbers = input.split(",");
        List<Integer> numbers = new ArrayList<>();
        for(String inputNumber : inputNumbers){
            numbers.add(Integer.parseInt(inputNumber));
        }
        return numbers;
    }
}
