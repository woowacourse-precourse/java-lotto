package lotto;

import static java.util.Arrays.asList;

import java.util.List;
import lotto.domain.Lotto;
public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        List<Integer> nums = asList(1,2,3,4,5,6);
        Lotto lottoTest = new Lotto(nums);
        System.out.println(lottoTest.getNumbers());
    }
}
