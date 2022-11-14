package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int money = inputMoney();
        Lotto lotto = inputLottoNumber();
        int bonus = inputBonusNumber(lotto);

        List<Lotto> issuedLotto = issueLotto(money);
        printIssuedLotto(issuedLotto);
    }


    public static int inputMoney() {
        String inputMoneyString = Console.readLine();
        int money;
        boolean inputMoneyError = false;

        try {
            money = checkInput(inputMoneyString);
        } catch (Exception e) {
            inputMoneyError = true;
            throw new IllegalArgumentException("[ERROR] 잘못된 입력이 들어왔습니다.");
//            System.out.println("[ERROR] 잘못된 입력이 들어왔습니다.");
        } finally {
            if (inputMoneyError) {
                String errorMessage = "[ERROR] 잘못된 입력이 들어왔습니다.";
                System.out.println(errorMessage);
            }
        }

        return money;
    }

    public static int checkInput(String input) {

        int inputInteger = Integer.parseInt(input);
        if (inputInteger % 1000 != 0) {
            throw new IllegalArgumentException();
        }

        return Integer.parseInt(input);
    }

    public static Lotto inputLottoNumber() {
        String inputNumberString = Console.readLine();
        String[] numbers = inputNumberString.split(",");
        Lotto lotto;
        boolean inputLottoError = false;
        try {
            lotto = createLotto(numbers);
        } catch (Exception e) {
            inputLottoError = true;
            throw new IllegalArgumentException();
        } finally {
            if (inputLottoError) {
                System.out.println("[ERROR] 잘못된 로또번호 입력");
            }
        }
        return lotto;
    }

    public static Lotto createLotto(String[] numbers) throws IllegalArgumentException {
        List<Integer> lottoList = new ArrayList<>();
        Lotto lotto;
        try {
            for (String s : numbers) {
                lottoList.add(Integer.parseInt(s));
            }
            lottoList.sort(Comparator.naturalOrder());
            lotto = new Lotto(lottoList);
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
        return lotto;
    }

    public static int inputBonusNumber(Lotto lotto) {
        String inputBonus = Console.readLine();
        int bonus;
        boolean inputBonusError = false;
        try {
            bonus = Integer.parseInt(inputBonus);
            lotto.checkBonusExists(bonus);
        } catch (Exception e) {
            inputBonusError = true;
            throw new IllegalArgumentException();
        } finally {
            if (inputBonusError) {
                System.out.println("[ERROR] 잘못된 보너스 번호");
            }
        }
        return bonus;
    }

    public static List<Lotto> issueLotto(int money) {
        List<Lotto> issuedLotto = new ArrayList<>();
        int numberOfLotto = money / 1000;
        System.out.println(numberOfLotto + "개를 구매했습니다.");
        for (int i = 0; i < numberOfLotto; i++) {
            Lotto newLotto = createNewLotto();
            issuedLotto.add(newLotto);
        }
        return issuedLotto;
    }

    public static Lotto createNewLotto() {
        List<Integer> newLottoNumber = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        newLottoNumber.sort(Comparator.naturalOrder());
        return new Lotto(newLottoNumber);
    }

    public static void printIssuedLotto(List<Lotto> lottoList) {
        for (Lotto lotto : lottoList) {
            lotto.printLotto();
        }
    }

}
