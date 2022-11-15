package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;
import lotto.Calculation;

import static lotto.GenerateNumber.generateSixRandomNumbers;

public class Application {
    public static void main(String[] args) {
        List<List<Integer>> purchasedLottoes;
        GenerateNumber generatingNumber = new GenerateNumber();
        Calculation calculation = new Calculation();

        // 사용자에게 구입금액 입력 받기
        System.out.println("구입금액을 입력해 주세요.");
        int purchaseAmount = receivePurchaseAmount();
    }

    public static int receivePurchaseAmount(){
        String purchaseAmount = Console.readLine();
        validateInputMoney(purchaseAmount);
        int inputMoney = Integer.valueOf(purchaseAmount);
        return inputMoney;
    }

    private static void validateInputMoney(String Money){
        for (int index = 0; index < Money.length(); index++) {
            int number = Character.getNumericValue(Money.charAt(index));
            if (!Character.isDigit(Money.charAt(index))) {
                throw new IllegalArgumentException("[ERROR] 입력금액은 숫자여야 합니다.");
            }
        }
        int inputMoney = Integer.valueOf(Money);
        if (!(inputMoney % 1000 == 0)){
            throw new IllegalArgumentException("[ERROR] 1000원 단위의 금액만 입력이 가능합니다.");
        }
    }



}
