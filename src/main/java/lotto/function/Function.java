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
    public static String getBonus(){
        Display.displayGettingBonus();
        return Console.readLine();
    }
    public static int validBonus(String bonus, List<Integer> winNumber){
        try{
            int bonusNumber = Integer.parseInt(bonus);
            if ((bonusNumber > Constants.upper_bound) || (bonusNumber < Constants.lower_bound)){
                throw new IllegalArgumentException("보너스 번호는 1~45사이로 입력해야 합니다.");
            }
            if (winNumber.contains(bonusNumber)){
                throw new IllegalArgumentException("보너스 번호는 당첨 번호와 달랴야 합니다.");
            }
            return bonusNumber;
        } catch(NumberFormatException e){
            String message = "보너스 번호로 숫자를 입력해 주세요.";
            Display.displayError(message);
        } catch(Exception e) {
            Display.displayError(e.getMessage());
        }
        return 0;
    }
    public static List<Integer> winLotto(Lotto lotto, List<Integer> winning, int bonus){
        List<Integer> result = new ArrayList<>(List.of(0, 0, 0, 0, 0));
        int count = 0;
        List<Integer> numbers = lotto.getNumbers();
        for (Integer number : numbers) {
            if (winning.contains(number)) {
                count += 1;
            }
        }
        if (count == 5){
            if (numbers.contains(bonus)){
                result.set(3, result.get(3) + 1);
                return result;
            }
        }
        if (count == 6){
            result.set(4, result.get(4) + 1);
            return result;
        }
        if (count > 2) {
            result.set(count - 3, result.get(count - 3) + 1);
        }
        return result;
    }
    public static int calculateWinning(List<Integer> result){
        int winningPrice = 0;
        for (int i = 0; i < 5; i++){
            winningPrice += Constants.winning.get(i) * result.get(i);
        }
        return winningPrice;
    }
    public static String calculateYield(int price, int winning){
        if (winning == 0){
            return String.valueOf(0.0);
        }
        return String.format("%.1f", (float)100 * price / winning);
    }
}
