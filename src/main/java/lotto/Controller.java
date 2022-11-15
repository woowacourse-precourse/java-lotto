package lotto;

import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;

public class Controller {
    /**
     * 사용자가 입력한 로또 번호의 유효성을 검증한다.
     * 1에서 45까지 서로 다른 임의의 수 6개인지 검증
     * @param playerNumbers 사용자가 입력한 로또 번호
     */
    public static void ValidatePlayerNumber(HashSet<Integer> playerNumbers) {
        // 집합의 크기가 6이 아니거나 1에서 45까지의 숫자가 아닌 숫자를 포함하면 예외를 발생한다.
        if (playerNumbers.size() != 6 || Collections.min(playerNumbers) < 1 || Collections.max(playerNumbers) > 45) {
            View.OutputString("[ERROR] 입력된 당첨 번호와 보너스 번호가 유효하지 않습니다.");
            throw new IllegalArgumentException("[ERROR] 입력된 당첨 번호와 보너스 번호가 유효하지 않습니다.");
        }
    }

    /**
     * 사용자가 입력한 로또 구입 금액을 검증한다.
     * 1000으로 나누었을 때 몫이 1 미만이거나 나머지가 0이 아니면 예외가 발생
     * @param purchaseAmount 사용자가 입력한 로또 구입 금액
     */
    public static void ValidatePurchaseAmount(Integer purchaseAmount) {
        if (purchaseAmount / 1000 < 1) {
            View.OutputString("[ERROR] 구입 금액이 유효하지 않습니다.");
            throw new IllegalArgumentException("[ERROR] 구입 금액이 유효하지 않습니다.");
        }
        if (purchaseAmount % 1000 != 0) {
            View.OutputString("[ERROR] 구입 금액이 유효하지 않습니다.");
            throw new IllegalArgumentException("[ERROR] 구입 금액이 유효하지 않습니다.");
        }
    }

    /**
     * 사용자가 구매한 로또 번호와 당첨 번호를 비교하여 당첨 내역을 분석한다.
     * @param numbers 사용자가 입력한 로또 번호
     * @param publishedLottoArray 발행된 로또 번호
     * @return 로또 분석 결과
     */
    public static LinkedHashMap<Integer, Integer> AnalyzePlayerNumbers
            (List<Integer> numbers, List<List<Integer>> publishedLottoArray) {
        // 로또 분석 결과를 담는 LinkedHashMap을 만든다.
        LinkedHashMap<Integer, Integer> result = Model.CreateAnalyzedResultLinkedHashMap();

        // 로또 보너스 번호와 로또 번호 집합을를 준비한다.
        Integer lottoBonusNumber = numbers.get(6);

        List<Integer> lottoNumbers = numbers;
        lottoNumbers.remove(6);
        HashSet<Integer> lottoNumbersSet = Model.MakeListToSet(lottoNumbers);

        // 발행된 로또들을 분석한다.
        for (List<Integer> list : publishedLottoArray) {
            HashSet<Integer> targetLottoNumbers = Model.MakeListToSet(list);

            // 로또 번호와 일치하는 개수를 구한다.
            int size = Model.CountIntersectionSize(lottoNumbersSet, targetLottoNumbers);

            // 로또 번호와 일치하는 개수에 따라 등수를 계산한다.
            Integer rank = Model.AnalyzeRank(size, list, lottoBonusNumber);

            // 등수에 따라 결과에 추가한다.
            result.put(rank, result.get(rank) + 1);
        }

        return result;
    }

    public static void Solution() {
        // 구입 금액 입력
        View.OutputString("구입금액을 입력해 주세요.");
        String inputLottoAmount = View.Input();
        Integer lottoAmount = Model.MakeStringToInteger(inputLottoAmount);

        // 구입 금액 검증
        ValidatePurchaseAmount(lottoAmount);

        // 로또 개수 계산
        Integer lottoCount = Model.CountLottoAmount(lottoAmount);

        // 로또 발행
        final List<List<Integer>> publishedLottoArray = Model.PublishLotto(lottoCount);

        // 로또 발행 출력
        View.OutputString(inputLottoAmount);
        View.OutputString(lottoCount+"개를 구매했습니다.");
        View.OutputListIntegerInList(publishedLottoArray);

        // 당첨 번호 입력
        View.OutputString("당첨 번호를 입력해 주세요.");
        String inputRealLottoNumber = View.Input();
        View.OutputString(inputRealLottoNumber);
        String[] splittedRealLottoNumbers = Model.SplitInput(inputRealLottoNumber);
        List<Integer> realLottoNumbers = Model.MakeStringToListInteger(splittedRealLottoNumbers);
        realLottoNumbers = Model.SortArrayList(realLottoNumbers);

        // 보너스 번호 입력
        View.OutputString("보너스 번호를 입력해 주세요.");
        String inputRealLottoBonusNumber = View.Input();
        View.OutputString(inputRealLottoBonusNumber);
        Integer realLottoBonusNumber = Model.MakeStringToInteger(inputRealLottoBonusNumber);

        // Lotto 클래스 생성
        Lotto lotto = new Lotto(realLottoNumbers);

        // 보너스 번호 추가
        realLottoNumbers.add(realLottoBonusNumber);

        // 로또 번호 분석
        LinkedHashMap<Integer, Integer> lottoResult = Controller.AnalyzePlayerNumbers
                (realLottoNumbers, publishedLottoArray);

        // 당첨 결과 통계 출력
        View.OutputString("당첨 통계");
        View.OutputString("---");
        View.PrintResult(lottoResult);

        // 총 수익률 출력
        Integer incomeSum = Model.CalculateEarningSum(lottoResult);
        String earningRate = Model.CalculateEarningRate(lottoAmount, incomeSum);
        View.OutputString("총 수익률은 "+earningRate+"%입니다.");
    }
}
