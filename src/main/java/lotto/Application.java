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
        try {
            for (String s : numbers) {
                lottoList.add(Integer.parseInt(s));
            }
            lottoList.sort(Comparator.naturalOrder());
            checkValidityOfLotto(lottoList);
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }

        return new Lotto(lottoList);
    }

    public static void checkValidityOfLotto(List<Integer> lottoList) throws IllegalArgumentException {

        if (lottoList.size() != 6) {
            throw new IllegalArgumentException();
        }
        for (int i = 0; i < 5; i++) {
            int currentNumber = lottoList.get(i);
            int nextNumber = lottoList.get(i + 1);
            if (currentNumber == nextNumber) {
                throw new IllegalArgumentException();
            }
        }
    }
}
