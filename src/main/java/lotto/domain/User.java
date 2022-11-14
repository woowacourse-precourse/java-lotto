package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class User {
    public int getMoneyInput() {
        String money = readLine();
        validateMoney(Integer.parseInt(money));
        return Integer.parseInt(money);
    }

    private void validateMoney(int money) {
        if (money % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 입력된 돈이 1000원 단위가 아닙니다.");
        }
    }

    public List<Integer> getLottoInput() {
        String lottoInput = readLine();
        String[] lotto = lottoInput.split(",");
        List<Integer> lottoNumber = new ArrayList<>();

        for (String s : lotto) {
            lottoNumber.add(Integer.parseInt(s));
        }
        validateLottoLength(lottoNumber);
        return lottoNumber;
    }

    private void validateLottoLength(List<Integer> lotto) {
        if (lotto.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 숫자 6개를 입력해주세요.");
        }
    }
}
