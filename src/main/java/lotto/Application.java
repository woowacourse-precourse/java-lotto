package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Application {

    public static boolean isMultipleThousands(int number) {
        return number % 1000 == 0;
    }

    public static void validateLottoPrice(String priceString) {
        int price;
        try {
            price = Integer.parseInt(priceString);
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }

        if (!isMultipleThousands(price)) {
            throw new IllegalArgumentException();
        }
    }

    public static int readLottoPrice() {
        String priceString = Console.readLine();
        validateLottoPrice(priceString);
        return Integer.parseInt(priceString);
    }

    public static List<Lotto> buyLottoList(int price) {
        int count = price / 1000;
        List<Lotto> lottoList = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            lottoList.add(new Lotto(numbers));
        }
        return lottoList;
    }

    public static List<Integer> readWinningNumbers() {
        String input = Console.readLine();
        String[] stringLotto = input.split(",");
        List<Integer> winningNumbers = new ArrayList<>();
        for (String number : stringLotto) {
            winningNumbers.add(Integer.parseInt(number));
        }
        return winningNumbers;
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int price;
        List<Lotto> lottoList;
        List<Integer> winningNumbers;

        try {
            price = readLottoPrice();
            lottoList = buyLottoList(price);
            winningNumbers = readWinningNumbers();

        } catch (Exception e) {
            System.out.println("[ERROR] 입력이 올바르지 않습니다.");
            return;
        }
    }
}
