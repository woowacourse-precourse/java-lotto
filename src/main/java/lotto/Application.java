package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

import static lotto.Grade.*;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }

    public static void printLottoQuantity(int quantity) {

        System.out.println(quantity + "개를 구매했습니다.");
    }

    public static void printLottoNumbers(List<Integer> lottoNumberList) {

        System.out.print("[");

        for (int i = 0; i < lottoNumberList.size() - 1; i++) {
            System.out.print(lottoNumberList.get(i) + ", ");
        }

        System.out.println(lottoNumberList.get(lottoNumberList.size() - 1) + "]");
    }

    public static void printWinningNumbersInputBox() {

        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public static void printBonusNumberInputBox() {

        System.out.println("보너스 번호를 입력해 주세요.");
    }

    public static void printCashInputBox() {

        System.out.println("구입 금액을 입력해 주세요.");
    }

    public static void printErrorAboutRange() {

        System.out.println("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
    }

    public static void printErrorAboutInteger() {

        System.out.println("[ERROR] 입력된 값이 숫자가 아닙니다.");
    }

    public static void printErrorAboutDuplicate() {

        System.out.println("[ERROR] 중복된 번호가 존재합니다.");
    }

    public static void printErrorAboutDivisionByThousand() {

        System.out.println("[ERROR] 입력된 값이 1,000으로 나누어 떨어지지 않습니다.");
    }

    public static void printErrorAboutForm() {

        System.out.println("[ERROR] 올바른 형식으로 입력해야 합니다.");
    }

    public static void printErrorAboutSize() {

        System.out.println("[ERROR] 알맞은 개수의 숫자를 입력해야 합니다.");
    }

    public static void validateCashIsInteger(String input) {

        for (int i = 0; i < input.length(); i++) {

            if (input.charAt(i) < 48 || input.charAt(i) > 57) {

                printErrorAboutInteger();
                throw new IllegalArgumentException();
            }
        }
    }

    public static void validateCashIsDividedThousand(String input) {

        if (input.length() < 4) {

            printErrorAboutDivisionByThousand();
            throw new IllegalArgumentException();
        }

        for (int i = input.length() - 3; i < input.length(); i++) {

            if (input.charAt(i) != 48) {

                printErrorAboutDivisionByThousand();
                throw new IllegalArgumentException();
            }
        }
    }

    public static Integer changeCashStringToInteger(String input) {
        int inputCash = 0;

        for (int i = 0; i < input.length(); i++) {

            int number = input.length() - i;
            inputCash += Math.pow(10, number - 1) * (input.charAt(i) - 48);
        }

        return inputCash;

    }

    public static String inputUserCash() {

        return Console.readLine();
    }

    public static Integer getUserCash(String input) {

        validateCashIsInteger(input);
        validateCashIsDividedThousand(input);

        return changeCashStringToInteger(input);
    }

    public static String inputWinningNumbers() {

        return Console.readLine();
    }

    public static void validateNumbersBetweenComma(char character1, char character2) {

        if ((character1 < 48 || character1 > 57) || (character2 < 48 || character2 > 57)) {

            printErrorAboutForm();
            throw new IllegalArgumentException();
        }

    }

    public static void validateWinningNumbersForm(String input) {

        for (int i = 0; i < input.length(); i++) {

            if (input.charAt(i) != ',' && (input.charAt(i) < 48 || input.charAt(i) > 57)) {

                printErrorAboutForm();
                throw new IllegalArgumentException();
            }

            if (input.charAt(i) == ',') {

                validateNumbersBetweenComma(input.charAt(i - 1), input.charAt(i + 1));
            }
        }

    }

    public static List<Integer> getWinningNumbers(String input) {

        validateWinningNumbersForm(input);

        List<Integer> winningNumberList = new ArrayList<>();

        int number = 0;

        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == ',') {

                winningNumberList.add(number);
                number = 0;
                continue;
            }

            number = number * 10 + input.charAt(i) - 48;

            if (i == input.length() - 1) {

                winningNumberList.add(number);
            }
        }

        return winningNumberList;
    }

    public static String inputBonusNumber() {

        return Console.readLine();
    }

    public static void validateBonusNumberIsInteger(String input) {

        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) < 48 || input.charAt(i) > 57) {

                printErrorAboutInteger();
                throw new IllegalArgumentException();
            }
        }
    }

    public static void validateBonusNumberIsInRange(String input) {
        int bonusNumber = 0;

        for (int i = 0; i < input.length(); i++) {
            bonusNumber = bonusNumber * 10 + input.charAt(i) - 48;
        }

        if (bonusNumber < 1 || bonusNumber > 45) {

            printErrorAboutRange();
            throw new IllegalArgumentException();
        }
    }

    public static void validateBonusNumberIsDuplicate(String input, List<Integer> winningNumberList) {

        int bonusNumber = 0;

        for (int i = 0; i < input.length(); i++) {
            bonusNumber = bonusNumber * 10 + input.charAt(i) - 48;
        }

        if (winningNumberList.contains(bonusNumber)) {

            printErrorAboutDuplicate();
            throw new IllegalArgumentException();
        }

    }

    public static Integer getBonusNumber(String input, List<Integer> winningNumberList) {

        validateBonusNumberIsInteger(input);
        validateBonusNumberIsInRange(input);
        validateBonusNumberIsDuplicate(input, winningNumberList);

        int bonusNumber = 0;

        for (int i = 0; i < input.length(); i++) {
            bonusNumber = bonusNumber * 10 + input.charAt(i) - 48;
        }

        return bonusNumber;
    }

    public static Double calculateSurplus(int first, int second, int third, int forth, int fifth, int cash) {

        int surplusSum = first * FIRST.getValue() + second * SECOND.getValue()
                + third * THIRD.getValue() + forth * FORTH.getValue() + fifth * FIFTH.getValue();

        double surplusRate = 100.0 * (double) surplusSum / (double) cash;

        return Math.round(surplusRate * 10) / 10.0;
    }

    public static Integer compareLottoNumbersAndWinningNumbers(Lotto lotto, List<Integer> winningNumberList, int equalNum) {

        int number = 0;

        for (int i = 0; i < winningNumberList.size(); i++) {

            if (lotto.checkWinningNumberIsInLottoNumbers(winningNumberList.get(i))) {

                number += 1;
            }
        }

        if (number == equalNum) return 1;

        return 0;
    }

    public static Integer calculateFirst(List<Lotto> lottoList, List<Integer> winningNumberList) {

        int number = 0;

        for (int i = 0; i < lottoList.size(); i++) {

            number += compareLottoNumbersAndWinningNumbers(lottoList.get(i), winningNumberList, 6);
        }

        return number;
    }

    public static Integer calculateSecond(List<Lotto> lottoList, List<Integer> winningNumberList, int bonusNumber) {

        int number = 0;

        for (int i = 0; i < lottoList.size(); i++) {

            if (!lottoList.get(i).checkWinningNumberIsInLottoNumbers(bonusNumber)) {

                continue;
            }

            number += compareLottoNumbersAndWinningNumbers(lottoList.get(i), winningNumberList, 5);
        }

        return number;
    }

    public static Integer calculateThird(List<Lotto> lottoList, List<Integer> winningNumberList, int bonusNumber) {

        int number = 0;

        for (Lotto lotto : lottoList) {

            if (lotto.checkWinningNumberIsInLottoNumbers(bonusNumber)) {

                continue;
            }

            number += compareLottoNumbersAndWinningNumbers(lotto, winningNumberList, 5);
        }

        return number;
    }
}
