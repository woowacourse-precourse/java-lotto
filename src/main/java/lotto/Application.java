package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) { //main
        List<Integer> numbers = new ArrayList<>();
        System.out.println("구입금액을 입력해 주세요.");
        Lotto lotto_num = new Lotto(numbers); // 로또번호
    }
}