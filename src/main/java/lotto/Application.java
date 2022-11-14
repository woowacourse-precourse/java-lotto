package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int money = inputMoney();
        Lotto lotto = inputLottoNumber();
        int bonus = inputBonusNumber(lotto);
    }


    public static int inputMoney() {
        String inputMoneyString = Console.readLine();
        int money;
        boolean inputMoneyError = false;

        try {
            money = checkInput(inputMoneyString);
        } catch (Exception e) {
            inputMoneyError = true;
            throw new IllegalArgumentException();
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

}
