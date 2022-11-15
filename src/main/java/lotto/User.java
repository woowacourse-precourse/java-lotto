package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class User {
    static final int LOTTO_PRICE = 1000;

    public User(){

    }

    public int lotteryPurchaseAmount(){
        System.out.println("구입금액을 입력해 주세요.");
        String input = Console.readLine();
        int lotteryPurchaseAmount = Integer.parseInt(input);
        if (lotteryPurchaseAmount % 1000 != 0){
            throw new IllegalArgumentException("1000원 단위로 입력해주세요");
        }
        return (lotteryPurchaseAmount);
    }

    public List<Integer> winningNumber(){
        System.out.println("당첨 번호를 입력해 주세요.");
        String input = Console.readLine();
        String[] splitInput = input.split(",");
        List<Integer> winningNumber = new ArrayList<Integer>();
        for (String number : splitInput) {
            int lottoNumber = Integer.parseInt(number);
            if (lottoNumber < 1 || lottoNumber > 45){
                throw new IllegalArgumentException("1~45 범위 안으로 입력해주세요");
            }
            winningNumber.add(lottoNumber);
        }
        return winningNumber;
    }

    int bonusNumber(){
        System.out.println("보너스 번호를 입력해 주세요.");
        String input = Console.readLine();
        int bonusNumber = Integer.parseInt(input);
        if (bonusNumber < 1 || bonusNumber > 45){
            throw new IllegalArgumentException("1~45 범위 안으로 입력해주세요");
        }
        return (bonusNumber);
    }

}
