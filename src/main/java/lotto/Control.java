package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import static Comment.GameMessage.*;
import static Comment.ErrorMessage.*;
import static camp.nextstep.edu.missionutils.Console.readLine;
import static lotto.Validation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.regex.PatternSyntaxException;
import java.util.stream.Collectors;

public class Control {


    private int price;
    private double reward;
    private double rateOfReturn;
    private int first = 0;
    private int second = 0;
    private int third = 0;
    private int forth = 0;
    private int fifth = 0;

    private String winningNumber;
    private String bonusNumber;

    private List<Lotto> lotteries;
    private Lotto winningNumbers;

    public Control() {

    }

    /* 복권 진행 */
    public void play() {
        System.out.println(START_MESSAGE);
        String cost = readLine();

        buyLotto(cost);
        createLotto();

        printMyLotto();

        getWinningNumber();

        checkWinningNumber();

        printWinning();
    }

    /* 복권 구매 */
    private void buyLotto(String cost) {
        try {
            price = Integer.parseInt(cost);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자만 입력 가능합니다.");
        }

        buyValidation();
    }

    /* 지불한 금액만큼 로또 생성 */
    private void createLotto() {
        lotteries = new ArrayList<>();

        int item = price / 1_000;

        System.out.println();
        System.out.println(item + CONFIRM_MESSAGE);

        for (int i = 0; i < item; i++) {
            Lotto lotto = new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            lotteries.add(lotto);
        }
    }

    /* 구매한 로또 출력 */
    private void printMyLotto() {
        for (Lotto lotto : lotteries) {
            System.out.println(lotto.getNumbers());
        }
    }

    /* 당첨 번호 입력 */
    private void getWinningNumber() {
        System.out.println(INPUT_LOTTO);
        winningNumber = readLine();

        winningNumbers = new Lotto(stringToIntegerList(winningNumber));

        System.out.println(INPUT_BONUS);
        bonusNumber = readLine();
    }

    /* 당첨 통계 출력 */
    private void printWinning() {
        StringBuilder stringBuilder = new StringBuilder();
        rateOfReturn = (reward / price) * 100; // 문제

        System.out.println(WINNING_STATISTICS);
        stringBuilder.append(WINNING_LEVEL_5).append(fifth).append("개\n");
        stringBuilder.append(WINNING_LEVEL_4).append(forth).append("개\n");
        stringBuilder.append(WINNING_LEVEL_3).append(third).append("개\n");
        stringBuilder.append(WINNING_LEVEL_2).append(second).append("개\n");
        stringBuilder.append(WINNING_LEVEL_1).append(first).append("개\n");
        stringBuilder.append("총 수익률은 ").append(String.format("%.1f", rateOfReturn)).append("%입니다.");

        System.out.println(stringBuilder);
    }

    /* 당첨 확인 */
    private void checkWinningNumber() {
        List<Integer> matchingNumber;

        for (Lotto myLotto : lotteries) {
            matchingNumber = winningNumbers.getNumbers().stream()
                    .filter(old -> myLotto.getNumbers().stream()
                            .anyMatch(Predicate.isEqual(old)))
                    .collect(Collectors.toList());

            int matchingCount = matchingNumber.size();

            Rank rank = myLotto.getRank(matchingCount, Integer.parseInt(bonusNumber));

            countRank(rank);
        }
    }

    /* 통계 집계 */
    private void countRank(Rank rank) {
        if (rank.equals(Rank.FIRST)) {
            first++;
        }

        if (rank.equals(Rank.SECOND)) {
            second++;
        }

        if (rank.equals(Rank.THIRD)) {
            third++;
        }

        if (rank.equals(Rank.FOURTH)) {
            forth++;
        }

        if (rank.equals(Rank.FIFTH)) {
            fifth++;
        }

        reward += rank.getWinningMoney();
    }

    /* 구매 검증 */
    private void buyValidation() {
        minPriceValidation(price);

        maxPriceValidation(price);

        monetaryUnitValidation(price);
    }

    /* 문자열을 정수 리스트로 변환 */
    private List<Integer> stringToIntegerList(String lottoNumber) {
        try {
            String[] lottoNumbers = lottoNumber.split(",");
            return Arrays.stream(lottoNumbers)
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        } catch (PatternSyntaxException e) {
            throw new IllegalArgumentException(INPUT_LOTTO_ERROR);
        }
    }
}
