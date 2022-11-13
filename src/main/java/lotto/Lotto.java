package lotto;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;
    private static User user;
    public static int lotto;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    public void buyer(User user){
        this.user = user;
    }

    private void printLotto(){
        int lottoPrice = user.getLottoPrice();
        this.lotto = lottoPrice / 1000;
        System.out.println(lotto + "개를 구매했습니다.");
    }
}
