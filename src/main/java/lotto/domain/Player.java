package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Player {
    public static int money;
    public static int numberOfLottos;
    public static List<Integer> winNumbers;
    public static int bonusNumber;

    public static int getMoney() {
        String playerInput = Console.readLine();
        validateNumbers(playerInput);
        money = Integer.parseInt(playerInput);
        validate(money);
        numberOfLottos = money/1000;
        return money;
    }

    public static List<Integer> getWinNumbers(){
        String playerInput = Console.readLine();
        toMakeWinNumbers(playerInput);
        validateWinNumbers(winNumbers);
        return winNumbers;
    }

    public static int getBonusNumber() {
        String playerInput = Console.readLine();
        validateNumbers(playerInput);
        bonusNumber = Integer.parseInt(playerInput);
        duplicateBonusNumber(bonusNumber);
        return bonusNumber;
    }

    private static void duplicateBonusNumber(int bonusNumber) {
        if(winNumbers.contains(bonusNumber)){
            throw new IllegalArgumentException("[ERROR]보너스 숫자와 이미 입력한 당첨번호는 중복될 수 없습니다.");
        }
    }

    private static void toMakeWinNumbers(String playerInput) {
        List<String> beforeCheck = Arrays.asList(playerInput.split(","));
        winNumbers = new ArrayList<>();
        for (int i = 0; i < beforeCheck.size(); i++) {
            validateNumbers(beforeCheck.get(i));
            winNumbers.add(Integer.parseInt(beforeCheck.get(i)));
        }
    }

    private static void validateWinNumbers(List<Integer> winNumbers) {
        for (int i = 0; i < winNumbers.size(); i++) {
            int duplicate = i;
            if(duplicate !=i && winNumbers.contains(winNumbers.get(duplicate))){
                throw new IllegalArgumentException("[ERROR]중복된 숫자를 입력할 수 없습니다.");
            }

            if(winNumbers.get(i)<0 || winNumbers.get(i)>45){
                throw new IllegalArgumentException("[ERROR]1~45 사이의 숫자만 입력할 수 있습니다.");
            }
        }
    }

    private static void validate(int money) {
        if (money % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR]구입 금액은 1,000원 단위로 나누어 떨어져야 합니다.");
        }
    }

    private static boolean validateNumbers(String playerInput){
        try {
            Integer.parseInt(playerInput);
            return true;
        } catch (Exception ex) {
            throw new IllegalArgumentException("[ERROR]숫자가 아닌 값을 포함하고 있습니다.");
        }
    }
}
