package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import lotto.Lotto.LottoReward;

public class Model {
    /**
     * 1에서 45까지 서로 다른 임의의 수 6개의 로또 숫자를 생성한다.
     * @return 로또 숫자를 ArrayList로 return 한다.
     */
    private static ArrayList<Integer> CreateLottoNumber() {
        ArrayList<Integer> lottoNumber = new ArrayList<>();

        // 1에서 45까지 서로 다른 임의의 수 6개를 생성한다.
        while (lottoNumber.size() < 6) {
            int randomNumber = Randoms.pickNumberInRange(1, 45);
            if (!lottoNumber.contains(randomNumber)) {
                lottoNumber.add(randomNumber);
            }
        }

        return lottoNumber;
    }

    /**
     * 1에서 45까지 수 중 로또 숫자와 중복되지 않는 보너스 번호 1개를 생성한다.
     * @return 로또 숫자를 Integer로 return 한다.
     */
    private static Integer CreateLottoBonusNumber(ArrayList<Integer> lottoNumber) {
        // 1에서 45까지 로또 숫자와 중복되지 않는 보너스 번호 1개를 생성한다.
        Integer randomNumber = Randoms.pickNumberInRange(1, 45);

        while (lottoNumber.contains(randomNumber)) {
            randomNumber = Randoms.pickNumberInRange(1, 45);
        }

        return randomNumber;
    }

    /**
     * 집합에 사용자가가 입력한 숫자를 넣는다.
     * @param playerNumbers 사용자가가 입력한 숫자
     * @return 입력한 숫자를 HashSet로 return 한다.
     */
    public static HashSet<Integer> MakeListToSet(List<Integer> playerNumbers) {
        HashSet<Integer> playerNumber = new HashSet<>();

        // 집합에 사용자가가 입력한 숫자를 넣는다.
        for (Integer I : playerNumbers) {
            playerNumber.add(I);
        }

        return playerNumber;
    }

    public static Integer MakeStringToInteger(String string) {
        try {
            return Integer.parseInt(string);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 입력된 값이 숫자가 아닙니다.");
        }
    }

    public static Integer CountLottoAmount(Integer purchaseAmount) {
        return purchaseAmount / 1000;
    }

    public static ArrayList<Integer> SortArrayList(ArrayList<Integer> arraylist) {
        Collections.sort(arraylist);
        return arraylist;
    }

    public static String[] SplitInput(String string) {
        return string.split(",");
    }

    public static List<Integer> MakeStringToListInteger(String[] strings) {
        List<Integer> result = new ArrayList<>();

        for (String str : strings) {
            result.add(Integer.parseInt(str));
        }

        return result;
    }

    public static List<List<Integer>> PublishLotto(Integer lottoAmount) {
        List<List<Integer>> lottoList = new ArrayList<>();

        for (int i = 1; i < 6; i++) {
            lottoList.add(CreateLottoNumber());
        }

        return lottoList;
    }

    public static Double CalculateEarningRate(Integer spending, Integer income) {
        return Math.round(income / spending * 100 * 100) / 10.0;
    }

    public Integer CalculateEarningSum(LinkedHashMap<Integer, Integer> analyzedResult) {
        List<Integer> analyzedResultKeys = new ArrayList<>(analyzedResult.keySet());

        Integer sum = 0;

        for (int i = 0; i < 6; i++) {
            sum = sum + LottoReward.getRewardByRank(i) * analyzedResult.get(i);
        }

        return sum;
    }
}
