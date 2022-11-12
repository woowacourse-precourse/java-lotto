package lotto.function;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;
import lotto.display.Display;

import java.util.List;
import java.util.ArrayList;

class Constants {
    public static final int lower_bound = 1;
    public static final int upper_bound = 45;
    public static final int counts = 6;
    public static final List<Integer> winning = List.of(5000, 50000, 1500000, 30000000, 2000000000);
}

public class Function {
    public static List<Integer> generateLotto(){
        return Randoms.pickUniqueNumbersInRange(Constants.lower_bound, Constants.upper_bound, Constants.counts);
    }
    public static String getMoney(){
        Display.displayStart();
        return Console.readLine();
    }
    public static List<Lotto> purchaseLotto(int price){
        int number = price / 1000;
        List<Lotto> trial = new ArrayList<>();
        for (int i = 0; i < number; i++){
            Lotto lotto = new Lotto(generateLotto());
            trial.add(lotto);
        }
        return trial;
    }
    public static int validPrice(String price){
        try{
            int prices = Integer.parseInt(price);
            if (prices % 1000 != 0){
                throw new IllegalArgumentException("로또 구매 금액은 1,000원 단위여야 합니다.");
            }
            return prices;
        } catch (NumberFormatException e){
            String message = "로또 구매 금액은 1,000원 단위의 정수를 입력해 주세요.";
            Display.displayError(message);
        } catch (IllegalArgumentException e){
            Display.displayError(e.getMessage());
        }
        return 0;
    }
    public static List<Integer> getWinningNumber(){
        Display.displayGettingWinNumber();
        String winningNumber = Console.readLine();
        List<Integer> WinningNumber = new ArrayList<>();

        String[] splits = winningNumber.split(",");
        for (String split : splits) {
            WinningNumber.add(Integer.parseInt(split));
        }
        return WinningNumber;
    }
    public static void validWinningNumber(List<Integer> WinningNumber){
        try{
            if (WinningNumber.size() != 6){
                throw new IllegalArgumentException("당첨 번호는 6개의 숫자가 입력되어야 합니다.");
            }
        } catch (Exception e){
            Display.displayError(e.getMessage());
        }
    }
}
