package lotto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
        validateLottoDuplication(numbers);
    }

    // TODO: 추가 기능 구현
    private void validateLottoDuplication(List<Integer> numbers) {
        List<Integer> tempLotto = new ArrayList<>();

        for (Integer i : numbers) {
            if (tempLotto.contains(i)) {
                throw new IllegalArgumentException();
            }
            tempLotto.add(i);
        }
    }

    public void printLotto() {
        String lotto = "[";
        for (int i = 0; i < numbers.size(); i++) {
            lotto += Integer.toString(numbers.get(i));

            if (i < numbers.size()-1) {
                lotto += ", ";
            }
        }
        lotto += "]";

        System.out.println(lotto);
    }

    public HashMap<String, List<Integer>> checkWinLotto(HashMap<String, List<Integer>> result) {
        List<Integer> myLottoPriceList = result.get("myLottoPriceList");
        List<Integer> myLotto = result.get("myLotto");
        List<Integer> prize = result.get("prize");
        List<Integer> myLottoWithoutBonus = getMyLottoWithoutBonus(myLotto);
        int bonusNumber = getBonusNumber(myLotto);

        return updateResult(result, myLottoPriceList, prize, bonusNumber, getContainCount(myLottoWithoutBonus));
    }

    private List<Integer> getMyLottoWithoutBonus(List<Integer> myLotto) {
        List<Integer> myLottoWithoutBonus = new ArrayList<>(myLotto.subList(0, myLotto.size()-1));
        return myLottoWithoutBonus;
    }

    private int getBonusNumber(List<Integer> myLotto) {
        return myLotto.get(myLotto.size()-1);
    }

    private int getContainCount(List<Integer> myLottoWithoutBonus) {
        int count = 0;
        for (Integer myNumber : myLottoWithoutBonus) {
            if (this.numbers.contains(myNumber)) {
                count += 1;
            }
        }
        return count;
    }

    private boolean checkBonus(int bonus) {
        if (this.numbers.contains(bonus)) {
            return true;
        }
        return false;
    }

    private HashMap<String, List<Integer>> updateResult(HashMap<String, List<Integer>> result
            , List<Integer> myLottoPriceList
            , List<Integer> prize
            , int bonus
            , int count) {
        if (count < 3) {
            return result;
        }

        if (count == 5) {
            if (checkBonus(bonus)) {
                count += 2;
            }
        }
        myLottoPriceList.set(count-3, myLottoPriceList.get(count-3) + 1);
        prize.set(0, prize.get(0) + getPrizeMoney(count-3));
        result.put("myLottoPriceList", myLottoPriceList);
        result.put("prize", prize);

        return result;
    }

    private int getPrizeMoney(int count) {
        PrizeMoney prizeMoney;
        if (count == 0) {
            return PrizeMoney.ONE.getPrize();
        }
        if (count == 1) {
            return PrizeMoney.TWO.getPrize();
        }
        if (count == 2) {
            return PrizeMoney.THREE.getPrize();
        }
        if (count == 3) {
            return PrizeMoney.FOUR.getPrize();
        }
        return PrizeMoney.FIVE.getPrize();
    }

}