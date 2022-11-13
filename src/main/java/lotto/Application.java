package lotto;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Lotto lo = new Lotto(MakeLotto.publishedLotto());
        List<Integer> lotto = lo.getNumbers();
        System.out.println(lotto);
    }
}
