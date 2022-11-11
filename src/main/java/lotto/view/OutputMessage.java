package lotto.view;

import java.util.List;

public final class OutputMessage {
    public static void purchaseComplete(int count){
        System.out.printf("%d개를 구매했습니다.\n", count);
    }

    public static void lottoNumbers(List<Integer> numbers){
        System.out.println(numbers);
    }
}
