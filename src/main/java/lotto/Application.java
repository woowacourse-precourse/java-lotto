package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import lotto.Calculation;

import static lotto.GenerateNumber.generateSixRandomNumbers;

public class Application {
    public static void main(String[] args) {
        //GenerateNumber generatingNumber = new GenerateNumber();
        //Calculation calculation = new Calculation();

        // 사용자에게 구입금액 입력 받기
        System.out.println("구입금액을 입력해 주세요.");
        int purchaseAmount = receivePurchaseAmount();
        List<Lotto> purchasedLotties = generatePurchasedLottoBundle(purchaseAmount);
        printPurchasedLotties(purchasedLotties);
        // 당첨번호 입력받기
        System.out.println("당첨 번호를 입력해 주세요.");
        List<Integer> winningNumber = receiveWinningNumber();
        // 보너스 번호 입력받기
        System.out.println("보너스 번호를 입력해 주세요.");
        int bonusNumber = receiveBonusNumber();
        System.out.println(winningNumber);
        System.out.println(bonusNumber);

    }

    public static int receivePurchaseAmount(){
        String purchaseAmount = Console.readLine();
        System.out.printf("\n");
        validateInputMoney(purchaseAmount);
        int inputMoney = Integer.valueOf(purchaseAmount);
        return inputMoney;
    }

    public static void validateInputMoney(String Money){
        for (int index = 0; index < Money.length(); index++) {
            int number = Character.getNumericValue(Money.charAt(index));
            if (!Character.isDigit(Money.charAt(index))) {
                throw new IllegalArgumentException("[ERROR] 입력금액은 숫자여야 합니다.");
            }
        }
        int inputMoney = Integer.valueOf(Money);
        if (!(inputMoney % 1000 == 0)){
            throw new IllegalArgumentException("[ERROR] 1000원 단위의 금액만 입력이 가능합니다.");
        }
    }

    public static List<Lotto> generatePurchasedLottoBundle(int inputMoney){ // 아니면 객체가 아니라 Lotto의 멤버변수 담아도 되지 않을까
        int numberOfLotto = Calculation.calculateNumberOfLottoes(inputMoney);
        GenerateNumber generatingNumber = new GenerateNumber();
        List<Lotto> bunchOfLotto = new ArrayList<>();
        for (int turn = 0; turn < numberOfLotto; turn++){
            List<Integer> sixNumber = generatingNumber.generateSixRandomNumbers();
            Lotto oneLotto = new Lotto(sixNumber);
            bunchOfLotto.add(oneLotto);
        }
        return bunchOfLotto;
    }

    public static void printPurchasedLotties(List<Lotto> bunchOfLotto){
        System.out.printf("%d개를 구매했습니다.\n",bunchOfLotto.size());
        for (int index = 0; index < bunchOfLotto.size(); index++){
            bunchOfLotto.get(index).printOneLotto();
        }
        System.out.printf("\n");
    }

    public static List<Integer> receiveWinningNumber(){
        String winningNumber = Console.readLine();
        System.out.printf("\n");
        //validateWinningNumber(winningNumber);
        List<String> winningNumbers = Arrays.asList(winningNumber.split(","));
        List<Integer> finalWinningNumbers = new ArrayList<>();
        for (int index = 0; index < winningNumbers.size(); index++){
            finalWinningNumbers.add(Integer.valueOf(winningNumbers.get(index)));
        }
        Collections.sort(finalWinningNumbers);
        return finalWinningNumbers;
    }

    public static void validateWinningNumber(List<String> winningNumber){
        for (int index = 0; index < winningNumber.size(); index++) {
            if (index % 2 == 0) {
                if (!(winningNumber.get(index).equals(","))) {
                    throw new IllegalArgumentException("[ERROR] 쉼표로 구분하여 숫자를 하나씩 입력해주세요.");
                }
            }
            if (index % 2 != 0) {
                validIsComposedOfNumber(winningNumber.get(index));
                int Number = Integer.valueOf(winningNumber.get(index));
                if (!(Number >= 1 && Number <= 45)) {
                    throw new IllegalArgumentException("[ERROR] 1~45 범위의 숫자만 입력해주세요.");
                }
            }
        }
    }

    public static void validIsComposedOfNumber(String number){
        for (int position = 0; position < number.length(); position++) {
            if (!Character.isDigit(number.charAt(position))) {
                throw new IllegalArgumentException("[ERROR] 숫자가 아닌 것이 존재합니다.");
            }
        }
    }


    public static int receiveBonusNumber(){
        String bonusNumber = Console.readLine();
        System.out.printf("\n");
        validateBonusNumber(bonusNumber);
        Integer finalBonusNumber = Integer.valueOf(bonusNumber);
        return finalBonusNumber;
    }

    public static void validateBonusNumber(String number){
        validIsComposedOfNumber(number);
        int numbers = Integer.valueOf(number);
        if (!(numbers >= 1 && numbers <= 45)){
            throw new IllegalArgumentException("[ERROR] 1~45 범위의 하나의 숫자만 입력해주세요.");
        }
    }

}
