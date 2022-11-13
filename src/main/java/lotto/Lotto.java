package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class Lotto {
    private static int number_of_lotto;
    private static List<List<Integer>> purchased_lotto_numbers;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현

    private void enterPriceOfLotto(){
        System.out.println("구입금액을 입력해주세요.");
        int price_of_lotto = Integer.parseInt(Console.readLine());
        calculateNumOfLotto(price_of_lotto);
    }

    private void calculateNumOfLotto(int price_of_lotto){
        number_of_lotto = price_of_lotto / 1000;
        System.out.println("\n" + number_of_lotto + "개를 구매했습니다.");
    }

    private void createRandomNumbers() {
        for (int count = 0; count < number_of_lotto; count++) {
            List<Integer> lotto = Randoms.pickUniqueNumbersInRange(1,45,6);
            purchased_lotto_numbers.add(lotto);
        }
    }

    private void printPurchasedLotto() {
        for (int lotto = 0; lotto < purchased_lotto_numbers.size(); lotto++){
            System.out.println(purchased_lotto_numbers.get(lotto));
        }
    }








}
