package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;

public class Application {
    private static void CheckSmallMoney(int money){
        if(money % 1000 != 0){
            throw new IllegalArgumentException("[ERROR] 로또는 1000원 단위로 구매가 가능합니다.");
        }
    }
    public static int BuyLotto(int money){
        CheckSmallMoney(money);
        int paper = money / 1000;
        return paper;
    }
    public static ArrayList<Integer> GetWinningNumbers(){
        ArrayList<Integer> winningNumbers = new ArrayList<>();
        String[] input = Console.readLine().split(",");

        for(int i=0; i<6;i++){
            winningNumbers.add(i, Integer.valueOf(input[i]));
        }
        return winningNumbers;
    }

    public static int GetBounusNumber(){
        return Integer.parseInt(Console.readLine());
    }
    public static void main(String[] args) {
        int customerMoney = Integer.parseInt(Console.readLine());
        int numberOfLottos = BuyLotto(customerMoney);

        ArrayList<Integer> winningNumbers = GetWinningNumbers();
        int bounusNumber = GetBounusNumber();
    }
}
