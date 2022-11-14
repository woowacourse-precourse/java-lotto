package lotto;

import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;

public class Controller {
    /**
     * 사용자가 입력한 로또 숫자의 유효성을 검증한다.
     * 1에서 45까지 서로 다른 임의의 수 7개인지 검증
     * @param playerNumbers 사용자가 입력한 로또 숫자
     */
    public static void ValidatePlayerNumber(HashSet<Integer> playerNumbers) {
        // 집합의 크기가 7이 아니거나 1에서 45까지의 숫자가 아닌 숫자를 포함하면 예외를 발생한다.
        if (playerNumbers.size() != 7 || Collections.min(playerNumbers) < 1 || Collections.max(playerNumbers) > 45) {
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
            throw new IllegalArgumentException("[ERROR] 구입 금액이 유효하지 않습니다.");
        }
        if (purchaseAmount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액이 유효하지 않습니다.");
        }
    }

    public static LinkedHashMap<Integer, Integer> AnalyzePlayerNumbers
            (List<Integer> numbers, List<List<Integer>> publishedLottoArray) {
        int size = 0;
        LinkedHashMap<Integer, Integer> result = new LinkedHashMap<>();
        result.put(0, 0);
        result.put(5, 0);
        result.put(4, 0);
        result.put(3, 0);
        result.put(2, 0);
        result.put(1, 0);

        Integer lottoBonusNumber = numbers.get(6);
        List<Integer> lottoNumbers = numbers;
        lottoNumbers.remove(6);

        HashSet<Integer> lottoNumbersSet = Model.MakeListToSet(lottoNumbers);

        for (List<Integer> list : publishedLottoArray) {
            HashSet<Integer> targetLottoNumbers = Model.MakeListToSet(list);
            HashSet<Integer> intersectionLottoNumbers = targetLottoNumbers;
            intersectionLottoNumbers.retainAll(lottoNumbersSet);
            size = intersectionLottoNumbers.size();

            if (size == 0) {
                result.put(0, result.get(0)+1);
            }
            if (size == 1) {
                result.put(0, result.get(0)+1);
            }
            if (size == 2) {
                result.put(0, result.get(0)+1);
            }
            if (size == 3) {
                result.put(5, result.get(5)+1);
            }
            if (size == 4) {
                result.put(4, result.get(4)+1);
            }
            if (size == 5) {
                if (targetLottoNumbers.contains(lottoBonusNumber)) {
                    result.put(2, result.get(2)+1);
                }
                if (!targetLottoNumbers.contains(lottoBonusNumber)) {
                    result.put(3, result.get(3)+1);
                }
            }
            if (size == 6) {
                result.put(1, result.get(1)+1);
            }
        }
    }

    public static void Solution() {
        // 구입 금액 입력
        View.Output("구입금액을 입력해 주세요.");
        String inputLottoAmount = View.Input();
        Integer lottoAmount = Model.MakeStringToInteger(inputLottoAmount);

        // 구입 금액 검증
        ValidatePurchaseAmount(lottoAmount);

        // 로또 개수 계산
        Integer lottoCount = Model.CountLottoAmount(lottoAmount);

        // 로또 발행
        final List<List<Integer>> publishedLottoArray = Model.PublishLotto(lottoCount);

        // 로또 발행 출력
        View.Output(lottoAmount+"개를 구매했습니다.");
        for (List<Integer> list : publishedLottoArray) {
            View.Output(list.toString());
        }

        // 당첨 번호 입력
        View.Output("당첨 번호를 입력해 주세요.");
        String inputRealLottoNumber = View.Input();
        String[] splittedRealLottoNumbers = Model.SplitInput(inputRealLottoNumber);
        List<Integer> realLottoNumbers = Model.MakeStringToListInteger(splittedRealLottoNumbers);

        // 보너스 번호 입력
        View.Output("보너스 번호를 입력해 주세요.");
        String inputRealLottoBonusNumber = View.Input();
        Integer realLottoBonusNumber = Model.MakeStringToInteger(inputRealLottoBonusNumber);

        // 보너스 번호 추가
        realLottoNumbers.add(realLottoBonusNumber);

        // Lotto 클래스 생성
        new Lotto(realLottoNumbers);
    }
}
