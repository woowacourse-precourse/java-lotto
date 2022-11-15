package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.NoSuchElementException;
import lotto.LottoEnum.LottoReward;

public class Model {
    /**
     * 1에서 45까지 서로 다른 임의의 수 6개의 로또 숫자를 생성한다.
     * @return 로또 숫자를 ArrayList로 return 한다.
     */
    private static List<Integer> CreateLottoNumber() {
        // 1에서 45까지 서로 다른 임의의 수 6개를 생성한다.
        List<Integer> randomNumber = Randoms.pickUniqueNumbersInRange(1, 45, 6);

        // 로또 번호는 오름차순으로 정렬한다.
        List<Integer> lottoNumber = new ArrayList<>(randomNumber);
        SortArrayList(lottoNumber);

        return lottoNumber;
    }

    /**
     * 1에서 45까지 수 중 로또 숫자와 중복되지 않는 보너스 번호 1개를 생성한다.
     * @return 로또 숫자를 Integer로 return 한다.
     */
    private static List<Integer> CreateLottoBonusNumber(List<Integer> lottoNumber) {
        // 1에서 45까지 로또 숫자와 중복되지 않는 보너스 번호 1개를 생성한다.
        List<Integer> randomNumber = Randoms.pickUniqueNumbersInRange(1, 45, 1);

        while (lottoNumber.contains(randomNumber)) {
            randomNumber = Randoms.pickUniqueNumbersInRange(1, 45, 1);
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
            View.OutputString("[ERROR] 입력된 값이 숫자가 아닙니다.");
            throw new NoSuchElementException();
        }
    }

    public static Integer CountLottoAmount(Integer purchaseAmount) {
        return purchaseAmount / 1000;
    }

    public static List<Integer> SortArrayList(List<Integer> arraylist) {
        Collections.sort(arraylist);
        return arraylist;
    }

    public static String[] SplitInput(String string) {
        return string.split(",");
    }

    public static List<Integer> MakeStringToListInteger(String[] strings) {
        try {
            List<Integer> result = new ArrayList<>();

            for (String str : strings) {
                result.add(Integer.parseInt(str));
            }

            return result;
        } catch (NumberFormatException e) {
            View.OutputString("[ERROR] 입력된 값이 숫자가 아닙니다.");
            throw new NoSuchElementException("[ERROR] 입력된 값이 숫자가 아닙니다.");
        }
    }

    public static List<List<Integer>> PublishLotto(Integer lottoAmount) {
        List<List<Integer>> lottoList = new ArrayList<>();

        for (int i = 1; i < lottoAmount+1; i++) {
            lottoList.add(CreateLottoNumber());
        }

        return lottoList;
    }

    /**
     * 총 수익률을 계산한다.
     * 소수점 둘째 자리에서 반올림
     * @param spending 지출
     * @param income 수입
     * @return 총 수익률
     */
    public static String CalculateEarningRate(Integer spending, Integer income) {
        Double incomeDouble= (double)income;
        Double spendingDouble= (double)spending;
        Double mathResult = incomeDouble / spendingDouble * 100;
        String printResult = String.format("%,.1f", mathResult);

        return printResult;
    }

    /**
     * 수익 총합을 계산한다.
     * @param analyzedResult 로또 분석 결과
     * @return 총 수익
     */
    public static Integer CalculateEarningSum(LinkedHashMap<Integer, Integer> analyzedResult) {
        Integer sum = 0;

        for (int i = 1; i < 6; i++) {
            sum = sum + LottoReward.GetRewardByRank(i) * analyzedResult.get(i);
        }

        return sum;
    }

    public static LinkedHashMap<Integer, Integer> CreateAnalyzedResultLinkedHashMap() {
        LinkedHashMap<Integer, Integer> result = new LinkedHashMap<>();

        for (LottoReward c : LottoReward.values()) {
            result.put(c.GetRank(), 0);
        }

        return result;
    }

    /**
     * 로또 당첨 번호와 일치하는 수의 개수를 계산한다.
     * @param lottoNumbersSet 로또 당첨 번호 집합
     * @param targetLottoNumbers 발행된 로또 번호
     * @return 로또 당첨 번호와 일치하는 수의 개수
     */
    public static int CountIntersectionSize
            (HashSet<Integer> lottoNumbersSet,
             HashSet<Integer> targetLottoNumbers) {
        HashSet<Integer> intersectionLottoNumbers = targetLottoNumbers;

        // 교집합의 개수를 구한다.
        intersectionLottoNumbers.retainAll(lottoNumbersSet);

        return intersectionLottoNumbers.size();
    }

    /**
     * 로또 당첨 번호와 일치하는 수의 개수에 따라 등수를 찾는다.
     * @param size 로또 당첨 번호와 일치하는 수
     * @param publishedLotto 발행된 로또 번호
     * @param lottoBonusNumber 로또 보너스 번호
     * @return 로또 등수
     */
    public static Integer AnalyzeRank(int size, List<Integer> publishedLotto, Integer lottoBonusNumber) {
        if (size == 3) {
            return 5;
        }
        if (size == 4) {
            return 4;
        }
        if (size == 5) {
            int bonusNumber = lottoBonusNumber;

            if (publishedLotto.contains(bonusNumber)) {
                return 2;
            }
            if (!publishedLotto.contains(bonusNumber)) {
                return 3;
            }
        }
        if (size == 6) {
            return 1;
        }

        return 0;
    }
}
