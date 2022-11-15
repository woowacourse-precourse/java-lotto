package view;

import camp.nextstep.edu.missionutils.Console;
import lotto.Lotto;
import lotto.Buyer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

import static view.Error.*;
import static lotto.Winning.*;

public class UI {

    public void printMessage(Comment comment) {
        System.out.println(comment.getMessage());
    }

    // 금액 입력
    public int inputCoin() {
        try {
            return Integer.parseInt(Console.readLine());
        } catch (IllegalStateException | NumberFormatException e) {
            System.out.println(e.getMessage());
            System.out.println(ERROR_NOT_NUMBER.getMessage());
            System.out.println(Arrays.toString(e.getStackTrace()));
            throw new NoSuchElementException();
        }
    }

    // 발행 로또 출력
    public int lottoCount(int purchaseAmount) {
        int lottoCount = 0;
        // 1,000원 단위로 나눈다.
        if (purchaseAmount % 1000 == 0) {
            return purchaseAmount / 1000;
        }

        if (purchaseAmount % 1000 != 0) {
            throw new IllegalArgumentException(ERROR_AMOUNT_IS_NOT_RIGHT.getMessage());
        }
        return lottoCount;
    }

    // 로또 번호 출력
    public void printLottoInfo(int lottoCount, List<Buyer> userLottoList) {
        System.out.println(lottoCount + "개를 구매했습니다.");
        // 갯수만큼 로또 초기화
        inputUserLottoNumber(lottoCount, userLottoList);
        // 로또 번호 출력
        printLottoNumbers(lottoCount, userLottoList);
    }

    public void printLottoNumbers(int lottoCount, List<Buyer> userLottos) {
        for (int i = 0; i < lottoCount; i++) {
            System.out.println(userLottos.get(i).getUserNumber());
        }
    }

    public void inputUserLottoNumber(int lottoCount, List<Buyer> userLottoList) {
        for (int i = 0; i < lottoCount; i++) {
            userLottoList.add(new Buyer());
        }
    }

    public Lotto getWinningNumbers() {
        //Lotto lottoNumber = new Lotto(lottoNums);
        return getLottoNums();
    }

    public Lotto getLottoNums() {
        String[] lottoNumString = Console.readLine().split(",");
        return convertInteger(lottoNumString);
    }

    public Lotto convertInteger(String[] lottoNumString) {
        List<Integer> lottoNums = new ArrayList<>();
        for (String s : lottoNumString) {
            lottoNums.add(Integer.parseInt(s));
        }
        lottoNums.sort(Integer::compareTo);
        return new Lotto(lottoNums);
    }

    public int getBonusNumber() {
        int bonusNumber = 0;
        try {
            bonusNumber = Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(Arrays.toString(e.getStackTrace()));
        }
        return bonusNumber;
    }

    public void printWinningStats(int money) {
        System.out.println("당첨 통계\n---");
        printMatch();
        printYield(money);
    }

    public void printMatch() {
        System.out.println(FIFTH_PLACE.getDESCRIPTION() + " " + FIFTH_PLACE.getSRING_PRICE() + " - " + FIFTH_PLACE.getCount() + "개");
        System.out.println(FOURTH_PLACE.getDESCRIPTION() + " " + FOURTH_PLACE.getSRING_PRICE() + " - " + FOURTH_PLACE.getCount() + "개");
        System.out.println(THIRD_PLACE.getDESCRIPTION() + " " + THIRD_PLACE.getSRING_PRICE() + " - " + THIRD_PLACE.getCount() + "개");
        System.out.println(SECOND_PLACE.getDESCRIPTION() + " " + SECOND_PLACE.getSRING_PRICE() + " - " + SECOND_PLACE.getCount() + "개");
        System.out.println(FIRST_PLACE.getDESCRIPTION() + " " + FIRST_PLACE.getSRING_PRICE() + " - " + FIRST_PLACE.getCount() + "개");
    }

    public void printYield(int money) {
        int earnings = getPrizeMoney();
        System.out.printf("총 수익률은 %.1f%%입니다.", (double) earnings / money * 100);
    }

    public int getPrizeMoney() {
        return (FIFTH_PLACE.getCount() * FIFTH_PLACE.getPRICE())
                + (FOURTH_PLACE.getCount() * FOURTH_PLACE.getPRICE())
                + (THIRD_PLACE.getCount() * THIRD_PLACE.getPRICE())
                + (SECOND_PLACE.getCount() * SECOND_PLACE.getPRICE())
                + (FIRST_PLACE.getCount() * FIRST_PLACE.getPRICE());
    }
}
