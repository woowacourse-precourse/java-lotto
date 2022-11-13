package lotto;

import java.util.*;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Lotto_num {

    private final List<Lotto_num> nums;

    public void Game() {
        String lotto_num = getUserInput();
        int lotto_nums = Integer.parseInt(lotto_num);
        if ((lotto_nums%1000) != 0) {
            throw new IllegalArgumentException("[ERROR]구매금액은 1천원 단위입니다.");
        }
        lotto_nums = lotto_nums/1000;


    }

    public String getUserInput() {
        System.out.println("구매금액을 입력해주세요");
        return readLine();
    }

}
