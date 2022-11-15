package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Application {
    public static int lottoCount = 0;
    public static List<List<Integer>> userLotto = new ArrayList<>();
    public static List<Integer> winningNumber = new ArrayList<>();
    public static int bonusNumber = 0;

    public static void main(String[] args) {
        try{
        lottoBuy();
        lottoIssue();
        setWinningNumbers();
        Lotto lotto = new Lotto(winningNumber);
        setBonusNumber();
        lotto.lottoCheck(winningNumber, bonusNumber, userLotto);
    } catch(NumberFormatException e) {
        System.out.println("[ERROR] 숫자를 입력해 주세요.");
    }
}
    public static void lottoBuy() {
            System.out.println("구입금액을 입력해 주세요.");
            String inputLottoPrice = Console.readLine();
            int buyLottoPrice = Integer.parseInt(inputLottoPrice);
            if (buyLottoPrice % 1000 != 0) {
                throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위로 입력해 주세요.");
            }
            lottoCount = buyLottoPrice / 1000;
            System.out.println(lottoCount + "개를 구매했습니다.");
    }

    public static void lottoIssue() {
        for (int i = 0; i < lottoCount; i++) {
            List<Integer> numbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            Collections.sort(numbers);
            System.out.println(numbers);
            userLotto.add(numbers);
        }
    }

    public static void setWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String inputNum = Console.readLine();
        for (String Number : inputNum.split(",")) {
            winningNumber.add(Integer.parseInt(Number));
        }
    }

    public static void setBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        String inputNum = Console.readLine();
        int bonusNumberCheck = Integer.parseInt(inputNum);
        if (bonusNumberCheck < 1 || bonusNumberCheck > 45){
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1에서 45사이의 숫자를 입력해 주세요.");
        }
        if(winningNumber.contains(bonusNumberCheck)){
            throw new IllegalArgumentException("[ERROR] 당첨 번호와 중복되지 않는 보너스 번호를 입력해 주세요.");
        }
        bonusNumber =  bonusNumberCheck;
    }
}

