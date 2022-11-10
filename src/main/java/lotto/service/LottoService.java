package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.Lotto;
import lotto.common.Error;

public class LottoService {

    private static final Map<Integer, Integer> placeMap = new HashMap<>();

    void init() {
        placeMap.put(60, 0);
        placeMap.put(51, 0);
        placeMap.put(50, 0);
        placeMap.put(40, 0);
        placeMap.put(30, 0);
    }

    public List<Lotto> buy(String in) {
        isNumber(in, Error.NUMBER);
        require(Integer.parseInt(in) < 1000, Error.MINUS);
        require(Integer.parseInt(in) % 1000 != 0, Error.THOUSAND);
        int money = getMoney(in);
        return getLottos(money);
    }

    private int getMoney(String in) {
        return Integer.parseInt(in);
    }

    private List<Lotto> getLottos(int money) {
        int numberOfLotto = money / 1000;
        return IntStream.range(0, numberOfLotto)
            .mapToObj(i -> Randoms.pickUniqueNumbersInRange(1, 45, 6)).map(Lotto::new)
            .collect(Collectors.toList());
    }

    private void require(final boolean condition, final Error error) {
        if (condition) {
            throw new IllegalArgumentException(error.getMsg());
        }
    }

    private void isNumber(String in, Error error) {
        try {
            Integer.parseInt(in);
        } catch (Exception e) {
            throw new IllegalArgumentException(error.getMsg());
        }
    }

    public List<Integer> getResult(List<Lotto> lottos, List<Integer> winns, int bonus) {
        for (Lotto lotto : lottos) {
            List<Integer> numbers = lotto.getNumbers();
            int ranking = lotto.getRanking(winns, bonus);
            Integer integer = placeMap.get(ranking);
            if (integer == null) continue;
            placeMap.put(ranking, integer+1);
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 60; i >= 30; i-=10) {
            if (i==50) {
                Integer integer2 = placeMap.get(i+1);
                result.add(integer2);
            }
            Integer integer = placeMap.get(i);
            result.add(integer);
        }
        return result;
    }
}
