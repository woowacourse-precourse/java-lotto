package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;
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
    }

}
