package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        Integer numberOfLottoes =
                getTheNumberOfLottoesAsMuchThePurchaseAmount(
                        Integer.parseInt(Console.readLine())
                );
        List<Lotto> lottoes = createLottoes(numberOfLottoes);
    }

    public static Integer getTheNumberOfLottoesAsMuchThePurchaseAmount(Integer purchaseAmount) {
        validatePurchaseAmount(purchaseAmount);
        return purchaseAmount / 1000;

    }

    public static List<Lotto> createLottoes(Integer numberOfLottoes){
        List<Lotto> lottoes = new ArrayList<>();

        for(int i = 0 ; i < numberOfLottoes ; i++){
            lottoes.add(new Lotto(Randoms.pickUniqueNumbersInRange(1,45,6)));
        }
        return lottoes;
    }

    public static void validatePurchaseAmount(Integer purchaseAmount) {
        if (purchaseAmount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구매 금액이 1000의 배수가 아닙니다.");
        }
    }
}
