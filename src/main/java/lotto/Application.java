package lotto;

/*
 * [필요 기능 명세]
 * [O] 랜덤 로또 번호 생성
 * [O] 당첨금 enum class 생성
 * [O] 당첨 로또 번호 입력
 * [O] 당첨 확인 로직
 * [O] 당첨 통계 계산
 * [O] 총 수익률 계산
 * [O/O] 입력 예외 처리(로또 구매 갯수 / 당첨 로또번호 입력)
 * [X] 단위 테스트 생성
 * [X] 테스트 확인
 */

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;
import java.util.stream.Collectors;

public class Application {
    private static final String ERROR_MESSAGE = "[ERROR]";
    private static final int LOTTO_PRICE = 1000;

    /*
     *  input :
     *      > 로또 구매 금액(1000의 배수) ex) 3000
     *      > 당첨 번호 6개(쉼표로 구분) ex) 1,2,3,4,5,6
     *      > 보너스 번호 입력(한자리) ex) 7
     */
    public static void main(String[] args) {
        List<Lotto> userLotto = new ArrayList<>();

        try {
            int purchaseLottoPrice= inputTotalPurchaseLottoPrice();
            int purchaseLottoAmount = purchaseLottoPrice / LOTTO_PRICE;

            validateLottoPrice(purchaseLottoPrice); // 입력 검증
            purchaseLotto(userLotto, purchaseLottoAmount); // 로또 구매

            Lotto winningLotto = Lotto.inputWinningLottoNumber();
            int bonusNumber = Lotto.inputBonusNumber();

            Map<WINNING, Integer> result = initResultMap(); // 결과 초기화
            checkAllUserLottoWinning(result, userLotto, winningLotto, bonusNumber, purchaseLottoPrice); // 유저 로또 당첨 확인
        } catch(IllegalArgumentException e){
            System.out.println(ERROR_MESSAGE + " " + e.getMessage());
        }
    }

    public static Map<WINNING, Integer> initResultMap(){
        // 각 enum type이 sortOrder를 기준으로 정렬하여, 출력 기준 지정
        Map<WINNING, Integer> result = new TreeMap<>(Comparator.comparingInt(WINNING::getSortOrder));

        for(WINNING WINNING : WINNING.values())
            result.put(WINNING, 0);

        return result;
    }

    public static void checkAllUserLottoWinning(Map<WINNING, Integer> result, List<Lotto> userLotto, Lotto winningLotto, int bonusNumber, int purchaseLottoPrice) {
        for (Lotto lotto : userLotto) {
            // 단일 로또 당첨 확인
            WINNING curWinning = Lotto.checkUserLottoWinning(winningLotto, lotto, bonusNumber);

            if(curWinning == WINNING.BOOM)
                continue;

            int winningCount = result.get(curWinning);
            result.put(curWinning, winningCount + 1);
        }

        printUserAllWinningInfo(result, purchaseLottoPrice);
    }

    private static void printUserAllWinningInfo(Map<WINNING, Integer> result, int purchaseLottoPrice) {
        double totalSumOfWinning = 0;

        for (WINNING WINNING : result.keySet()) {
            int winningCount = result.get(WINNING);
            int curWinning = Integer.parseInt(WINNING.getValue().replace(",", "")) * winningCount;

            totalSumOfWinning += curWinning;
            WINNING.printWinningInfo(WINNING, winningCount);
        }

        System.out.println("총 수익률은 " + totalSumOfWinning / purchaseLottoPrice * 100 + "%입니다.");
    }

    private static int inputTotalPurchaseLottoPrice() {
        System.out.println("구입금액을 입력해주세요.");
        return Integer.parseInt(Console.readLine());
    }

    public static void purchaseLotto(List<Lotto> userLotto, int purchaseLottoAmount) {
        for(int i = 0; i < purchaseLottoAmount; i++)
            userLotto.add(createRandomLottoList());
        printUserLottoList(userLotto, purchaseLottoAmount);
    }

    private static void printUserLottoList(List<Lotto> userLotto, int purchaseLottoAmount) {
        System.out.println(purchaseLottoAmount + "개를 구매했습니다.");

        for (Lotto lotto : userLotto)
            lotto.printLottoNumbers();
    }

    private static void validateLottoPrice(int purchaseLottoPrice) {
        if(purchaseLottoPrice < LOTTO_PRICE)
            throw new IllegalArgumentException("1개 이상 구매해야 합니다.");
        if(purchaseLottoPrice % LOTTO_PRICE != 0)
            throw new IllegalArgumentException(LOTTO_PRICE + "단위로 입력하여야 합니다.");
    }

    private static Lotto createRandomLottoList() {
        // 랜덤 번호를 생성하고 정렬하여 반환
        return new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6)
                .stream().sorted()
                .collect(Collectors.toList()));
    }
}
