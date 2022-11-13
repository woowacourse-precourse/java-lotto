package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Stream;
import lotto.domain.Buyer;
import lotto.domain.Lotto;

public class LottoProgram {

    private static Buyer buyer = new Buyer();
    public static void init() throws IllegalArgumentException {
        System.out.println("구입금액을 입력해 주세요.");
        String purchaseAmout = Console.readLine();
        String purchaseRegex = "^[1-9]*000$";
        if (!Pattern.matches(purchaseRegex, purchaseAmout)) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해 주세요");
        }
        int purchaseAmoutCash = Integer.parseInt(purchaseAmout);

        buyer.setTotalPurchaseAmout(purchaseAmoutCash);

        int numbersOfLotto = purchaseAmoutCash / 1000;
        buyer.setLottoPurchasedCount(numbersOfLotto);
        System.out.println(buyer.getLottoPurchasedCount() + "개를 구매했습니다.");

        purchasedLottoSave();
        System.out.println("당첨 번호를 입력해주세요.");
        String winningNumbers = Console.readLine();

        String winningNumberRegex = "^([1-9]{1},{1}|[1-3]{1}[0-9]{1},{1}|4{1}[0-5]{1},{1}){5}"
                + "([1-9]{1}|[1-3]{1}[0-9]{1}|4{1}[0-5]{1})$";
        if (!Pattern.matches(winningNumberRegex, winningNumbers)) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 1-45사이의 숫자를 콤마로 구분하여 입력해주세요.");
        }


        Integer[] numberArray = convertToInteger(winningNumbers);
        HashSet<Integer> removeDuplicatedNumbers = new HashSet<Integer>(List.of(numberArray));
        if (removeDuplicatedNumbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 중복 숫자가 존재하지 않아야 합니다.");
        }


    }

    private static void purchasedLottoSave() {
        int count = buyer.getLottoPurchasedCount();
        for (int lottoCount = 0; lottoCount < count; lottoCount++) {
            List<Integer> purchasedLottoNumber = new ArrayList<Integer>(
                    Randoms.pickUniqueNumbersInRange(1, 45, 6));
            purchasedLottoNumber.sort(Comparator.naturalOrder());
            System.out.println(purchasedLottoNumber);
            buyer.setLottoPurchased(new Lotto(purchasedLottoNumber));
        }
    }

    private static Integer[] convertToInteger(String inputNumber) {
        return Stream.of(inputNumber.split(","))
                .mapToInt((number) -> {
                    try {
                        int parsedInt = Integer.parseInt(number);
                        return parsedInt;
                    } catch (NumberFormatException e) {
                        throw new IllegalArgumentException();
                    }
                })
                .boxed()
                .toArray(Integer[]::new);
    }
}
