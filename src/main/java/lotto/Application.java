package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import org.assertj.core.internal.Doubles;

import java.util.*;

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

        HashMap<String, List<Integer>> result = new HashMap<>();
        List<Integer> myLottoPriceList = new ArrayList<>(Arrays.asList(0, 0, 0, 0, 0));
        List<Integer> prize = new ArrayList<>(Arrays.asList(0));

        result.put("myLotto", myLotto);
        result.put("myLottoPriceList", myLottoPriceList);
        result.put("prize", prize);

        for (Lotto l : lottos) {
            l.checkWinLotto(result);
        }

        List<Integer> lottoResult = result.get("myLottoPriceList");
        List<Integer> prizeResult = result.get("prize");

        printResult(lottoResult);
        printYield(prizeResult, numberOfLotto);

    }

    public static int getTheNumberOfLotto() {
        System.out.println("구입금액을 입력해 주세요.");
        String money = Console.readLine();
        try {
            moneyValidate(money);
        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.println("[ERROR] 구매 금액은 1000원 단위로 입력해야 합니다.");
            return 0;
        }
        int numberOfLotto = Integer.parseInt(money) / 1000;

        return numberOfLotto;
    }

    public static void moneyValidate(String money) {
        if (validateMoneyType(money) || validateMoneyRange(money)) {
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
        if (Integer.parseInt(money) % 1000 != 0) {
            return true;
        }

        return false;
    }

    public static List<Integer> createLottoNumbers() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);

        return numbers;
    }

    public static void printLottos(List<Lotto> lottos) {
        System.out.println();
        System.out.println(String.format("%d개를 구매했습니다.", lottos.size()));
        for (Lotto lotto : lottos) {
            lotto.printLotto();
        }
    }

    public static List<Integer> getMyLottoNumbers() {
        System.out.println();
        System.out.println("당첨 번호를 입력해 주세요.");
        String[] lotto = Console.readLine().split(",");

        myLottoValidate(lotto);

        List<Integer> myLotto = new ArrayList();

        for (String l : lotto) {
            myLotto.add(Integer.parseInt(l));
        }

        return myLotto;
    }

    public static List<Integer> getMyBonusNumbers(List<Integer> myLotto) {
        System.out.println();
        System.out.println("보너스 번호를 입력해 주세요.");
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

        for (String s : lotto) {
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

    public static void printResult(List<Integer> lottoResult) {
        System.out.println();
        System.out.println(String.format(
                "당첨 통계" + "\n"
                        + "---" + "\n"
                        + "3개 일치 (5,000원) - %d개" + "\n"
                        + "4개 일치 (50,000원) - %d개" + "\n"
                        + "5개 일치 (1,500,000원) - %d개" + "\n"
                        + "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개" + "\n"
                        + "6개 일치 (2,000,000,000원) - %d개"
                , lottoResult.get(0),
                lottoResult.get(1),
                lottoResult.get(2),
                lottoResult.get(4),
                lottoResult.get(3))
        );
    }

    public static void printYield(List<Integer> prizeResult, int numberOfLotto) {
        double prize = (double) prizeResult.get(0);
        int totalUseMoney = numberOfLotto * 1000;

        double yield = (prize / totalUseMoney);
        double yieldRate = yield * 100;
        System.out.println(String.format("총 수익률은 %.1f", yieldRate) + "%입니다.");
    }


}
