package lotto;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import org.assertj.core.internal.Doubles;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        List<Lotto> lottos = new ArrayList<>();
        int numberOfLotto = getTheNumberOfLotto();

        for (int i = 0; i < numberOfLotto; i++) {
            lottos.add(new Lotto(createLottoNumbers()));
        }
        printLottos(lottos);

        List<Integer> myLotto = getMyBonusNumbers(getMyLottoNumbers());

    }

    public static int getTheNumberOfLotto() {
        String money = Console.readLine();
        moneyValidate(money);
        int numberOfLotto = Integer.parseInt(money) / 1000;

        return numberOfLotto;
    }

    public static void moneyValidate(String money) {
        if (validateMoneyType(money) || validateMoneyRange(money)) {
            System.out.println("[ERROR] 구매 금액은 1000원 단위로 입력해야 합니다.");
            throw new IllegalArgumentException();
        }
    }

    public static boolean validateMoneyType(String money) {
        // 오류가 있으면 true
        for (char c : money.toCharArray()) {
            if (!Character.isDigit(c)) {
                return true;
            }
        }

        return false;
    }

    public static boolean validateMoneyRange(String money) {
        // 오류가 있으면 true
        if(Integer.parseInt(money) % 1000 != 0) {
            return true;
        }

        return false;
    }

    public static List<Integer> createLottoNumbers() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);

        return numbers;
    }

    public static void printLottos(List<Lotto> lottos) {
        for (Lotto lotto: lottos) {
            lotto.printLotto();
        }
    }

    public static List<Integer> getMyLottoNumbers() {
        String[] lotto = Console.readLine().split(",");

        myLottoValidate(lotto);

        List<Integer> myLotto = new ArrayList();

        for (String l : lotto) {
            myLotto.add(Integer.parseInt(l));
        }

        return myLotto;
    }

    public static List<Integer> getMyBonusNumbers(List<Integer> myLotto) {
        String bonus = Console.readLine();

        bonusNumberValidate(bonus, myLotto);

        int bonusNumber = Integer.parseInt(bonus);

        myLotto.add(bonusNumber);

        return myLotto;
    }

    public static void myLottoValidate(String[] lotto) {
        if (validateMyLottoLength(lotto)
                || validateMyLottoElement(lotto)
                || validateMyLottoElementDuplication(lotto)
                || validateMyLottoElementRange(lotto)) {
            System.out.println("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            throw new IllegalArgumentException();
        }
    }

    public static boolean validateMyLottoLength(String[] lotto) {
        if (lotto.length != 6) {
            return true;
        }

        return false;
    }

    public static boolean validateMyLottoElement(String[] lotto) {
        for (String s : lotto) {
            if (!s.chars().allMatch(Character::isDigit)) {
                return true;
            }
        }

        return false;
    }

    public static boolean validateMyLottoElementDuplication(String[] lotto) {
        List<String> tempLotto = new ArrayList<>();

        for (String s: lotto) {
            if (tempLotto.contains(s)) {
                return true;
            }
            tempLotto.add(s);
        }

        return false;
    }

    public static boolean validateMyLottoElementRange(String[] lotto) {
        for (String l : lotto) {
            int n = Integer.parseInt(l);
            if (n > 45 || n < 1) {
                return true;
            }
        }

        return false;
    }

    public static void bonusNumberValidate(String bonusNumber, List<Integer> lotto) {
        if (validateBonusElement(bonusNumber)
                || validateBonusDuplication(bonusNumber, lotto)
                || validateBonusElementRange(bonusNumber)) {
            System.out.println("[ERROR] 보너스 번호는 로또 번호와 중복되지 않는, 1부터 45 사이의 숫자여야 합니다.");
            throw new IllegalArgumentException();
        }

    }

    public static boolean validateBonusElement(String bonusNumber) {

        if (!bonusNumber.chars().allMatch(Character::isDigit)) {
            return true;
        }

        return false;
    }

    public static boolean validateBonusDuplication(String bonusNumber, List<Integer> lotto) {
        int bonus = Integer.parseInt(bonusNumber);

        if (lotto.contains(bonus)) {
            return true;
        }

        return false;
    }

    public static boolean validateBonusElementRange(String bonusNumber) {
        int bonus = Integer.parseInt(bonusNumber);

        if (bonus > 45 || bonus < 1) {
            return true;
        }

        return false;
    }


}
