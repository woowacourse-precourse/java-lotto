package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static lotto.Grade.*;

public class Application {

    private static ErrorMessage error;

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        playLottoGame();
    }

    public static void playLottoGame() {
        try {
            printCashInputBox();
            int cash = getUserCash(inputUserCash());
            List<Lotto> lottoTickets = new ArrayList<>();
            issueLottoTickets(cash, lottoTickets);
            printWinningNumbersInputBox();
            Lotto winningNumbers = new Lotto(getWinningNumbers(inputWinningNumbers()));
            printBonusNumberInputBox();
            int bonusNumber = getBonusNumber(inputBonusNumber(), winningNumbers.getNumbers());
            showStats(lottoTickets, winningNumbers.getNumbers(), bonusNumber, cash);
        } catch (IllegalArgumentException e) {
            System.out.println(error.getMessage());
        }
    }

    /*
     * 구입금액 관련
     */
    public static String inputUserCash() {

        return Console.readLine();
    }

    public static void validateCashIsInteger(String input) {

        for (int i = 0; i < input.length(); i++) {

            if (input.charAt(i) < 48 || input.charAt(i) > 57) {
                error = ErrorMessage.INTEGER;
                throw new IllegalArgumentException();
            }
        }
    }

    public static void validateCashIsDividedThousand(String input) {
        if (input.length() < 4) {
            error = ErrorMessage.DIVIDE;
            throw new IllegalArgumentException();
        }

        for (int i = input.length() - 3; i < input.length(); i++) {

            if (input.charAt(i) != 48) {
                error = ErrorMessage.DIVIDE;
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

    public static Integer getUserCash(String input) {

        validateCashIsInteger(input);
        validateCashIsDividedThousand(input);

        return changeCashStringToInteger(input);
    }


    /*
     * 로또 번호 발행 관련
     */
    public static void issueLottoTickets(int cash, List<Lotto> lottoTickets) {
        issueLottoNumbers(cash / 1000, lottoTickets);
        showLotto(cash, lottoTickets);
    }

    public static void issueLottoNumbers(int buyNumber, List<Lotto> lottoTickets) {

        for (int i = 0; i < buyNumber; i++) {
            lottoTickets.add(new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6)));
        }
    }

    public static void showLotto(int cash, List<Lotto> lottoTickets) {

        printLottoQuantity(cash / 1000);
        for (Lotto lotto : lottoTickets) {
            printLottoNumbers(lotto.getNumbers());
        }
    }

    /*
     * 당첨 번호 관련
     */
    public static String inputWinningNumbers() {

        return Console.readLine();
    }

    public static void validateNumbersBetweenComma(char character1, char character2) {

        if ((character1 < 48 || character1 > 57) || (character2 < 48 || character2 > 57)) {
            error = ErrorMessage.FORM;
            throw new IllegalArgumentException();
        }

    }

    public static void validateWinningNumbersForm(String input) {

        for (int i = 0; i < input.length(); i++) {

            if (input.charAt(i) != ',' && (input.charAt(i) < 48 || input.charAt(i) > 57)) {
                error = ErrorMessage.FORM;
                throw new IllegalArgumentException();
            }
            if (input.charAt(i) == ',') {
                validateNumbersBetweenComma(input.charAt(i - 1), input.charAt(i + 1));
            }
        }
    }

    public static List<Integer> changeWinningNumbersStringToList(String input) {
        List<Integer> winningNumbers = new ArrayList<>();
        int number = 0;
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == ',') {
                winningNumbers.add(number);
                number = 0;
                continue;
            }
            number = number * 10 + input.charAt(i) - 48;
        }
        winningNumbers.add(number);
        return winningNumbers;
    }

    public static List<Integer> getWinningNumbers(String input) {
        validateWinningNumbersForm(input);

        return changeWinningNumbersStringToList(input);
    }

    /*
     * 보너스 번호 관련
     */
    public static String inputBonusNumber() {

        return Console.readLine();
    }

    public static void validateBonusNumberIsInteger(String input) {

        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) < 48 || input.charAt(i) > 57) {
                error = ErrorMessage.INTEGER;
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
            error = ErrorMessage.RANGE;
            throw new IllegalArgumentException();
        }
    }

    public static void validateBonusNumberIsDuplicate(String input, List<Integer> winningNumbers) {
        int bonusNumber = 0;

        for (int i = 0; i < input.length(); i++) {
            bonusNumber = bonusNumber * 10 + input.charAt(i) - 48;
        }
        if (winningNumbers.contains(bonusNumber)) {
            error = ErrorMessage.DUPLICATE;
            throw new IllegalArgumentException();
        }
    }

    public static Integer changeBonusNumberStringToInteger(String input) {
        int bonusNumber = 0;
        for (int i = 0; i < input.length(); i++) {
            bonusNumber = bonusNumber * 10 + input.charAt(i) - 48;
        }
        return bonusNumber;
    }

    public static Integer getBonusNumber(String input, List<Integer> winningNumbers) {

        validateBonusNumberIsInteger(input);
        validateBonusNumberIsInRange(input);
        validateBonusNumberIsDuplicate(input, winningNumbers);

        return changeBonusNumberStringToInteger(input);
    }

    /*
     * 출력 관련
     */
    public static void showStats(List<Lotto> lottoTickets, List<Integer> winningNumbers, int bonusNumber, int cash) {

        printStatsPhrase();
        printGradeStats(lottoTickets, winningNumbers, bonusNumber, cash);
    }

    public static void printLottoQuantity(int quantity) {

        System.out.println();
        System.out.println(quantity + "개를 구매했습니다.");
    }

    public static void printLottoNumbers(List<Integer> lottoNumbers) {

        System.out.print("[");

        for (int i = 0; i < lottoNumbers.size() - 1; i++) {
            System.out.print(lottoNumbers.get(i) + ", ");
        }

        System.out.println(lottoNumbers.get(lottoNumbers.size() - 1) + "]");
    }

    public static void printWinningNumbersInputBox() {

        System.out.println();
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public static void printBonusNumberInputBox() {

        System.out.println();
        System.out.println("보너스 번호를 입력해 주세요.");
    }

    public static void printCashInputBox() {

        System.out.println("구입 금액을 입력해 주세요.");
    }

    public static void printStatsPhrase() {

        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---");
    }

    public static void printGradeStats(List<Lotto> lottoTickets, List<Integer> winningNumbers, int bonusNumber, int cash) {
        int first = calculateFirst(lottoTickets, winningNumbers);
        int second = calculateSecond(lottoTickets, winningNumbers, bonusNumber);
        int third = calculateThird(lottoTickets, winningNumbers, bonusNumber);
        int forth = calculateForth(lottoTickets, winningNumbers);
        int fifth = calculateFifth(lottoTickets, winningNumbers);
        double surplusRate = calculateSurplus(first, second, third, forth, fifth, cash);

        System.out.println("3개 일치 (5,000원) - " + fifth + "개");
        System.out.println("4개 일치 (50,000원) - " + forth + "개");
        System.out.println("5개 일치 (1,500,000원) - " + third + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + second + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + first + "개");
        System.out.println("총 수익률은 " + surplusRate + "%입니다.");
    }

    /*
     * 당첨 내역 계산 관련
     */
    public static Integer compareLottoNumbersAndWinningNumbers(Lotto lotto, List<Integer> winningNumbers, int equalNum) {

        int number = 0;

        for (int winningNumber : winningNumbers) {

            if (lotto.checkWinningNumberIsInLottoNumbers(winningNumber)) {

                number += 1;
            }
        }

        if (number == equalNum) return 1;

        return 0;
    }

    public static Integer calculateFirst(List<Lotto> lottoTickets, List<Integer> winningNumbers) {

        int number = 0;

        for (Lotto lotto : lottoTickets) {

            number += compareLottoNumbersAndWinningNumbers(lotto, winningNumbers, 6);
        }

        return number;
    }

    public static Integer calculateSecond(List<Lotto> lottoTickets, List<Integer> winningNumbers, int bonusNumber) {

        int number = 0;

        for (Lotto lotto : lottoTickets) {

            if (!lotto.checkWinningNumberIsInLottoNumbers(bonusNumber)) {

                continue;
            }
            number += compareLottoNumbersAndWinningNumbers(lotto, winningNumbers, 5);
        }
        return number;
    }

    public static Integer calculateThird(List<Lotto> lottoTickets, List<Integer> winningNumbers, int bonusNumber) {

        int number = 0;

        for (Lotto lotto : lottoTickets) {

            if (lotto.checkWinningNumberIsInLottoNumbers(bonusNumber)) {

                continue;
            }
            number += compareLottoNumbersAndWinningNumbers(lotto, winningNumbers, 5);
        }
        return number;
    }

    public static Integer calculateForth(List<Lotto> lottoTickets, List<Integer> winningNumbers) {

        int number = 0;

        for (Lotto lotto : lottoTickets) {

            number += compareLottoNumbersAndWinningNumbers(lotto, winningNumbers, 4);
        }

        return number;
    }

    public static Integer calculateFifth(List<Lotto> lottoTickets, List<Integer> winningNumbers) {

        int number = 0;

        for (Lotto lotto : lottoTickets) {

            number += compareLottoNumbersAndWinningNumbers(lotto, winningNumbers, 3);
        }

        return number;
    }

    public static Double calculateSurplus(int first, int second, int third, int forth, int fifth, int cash) {

        int surplusSum = first * FIRST.getValue() + second * SECOND.getValue()
                + third * THIRD.getValue() + forth * FORTH.getValue() + fifth * FIFTH.getValue();

        double surplusRate = 100.0 * (double) surplusSum / (double) cash;

        return Math.round(surplusRate * 10) / 10.0;
    }

    /*
     * 에러 메세지 관련
     */
    public static void setError(ErrorMessage errorMessage) {
        error = errorMessage;
    }
}
