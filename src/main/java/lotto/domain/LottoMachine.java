package lotto.domain;

import camp.nextstep.edu.missionutils.Console;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class LottoMachine {

    // 로또 구입금액 입력
    public int insertMoney() {
        System.out.println("구입 금액을 입력해 주세요.");
        String money = Console.readLine();
        return validateMoney(money);
    }

    // 구입 금액 입력 방식 확인
    private int validateMoney(String money) {
        int confirmedMoney = 0;
        try {
            confirmedMoney = Integer.parseInt(money);
        } catch (Exception e) {
            throw new IllegalArgumentException(Error.ERROR_WRONG_MONEY.getMessage());
        }
        return confirmedMoney;
    }

    // 로또 발행 전체 과정
    public List<Lotto> createLotto(int money) {
        int lottoCount = checkLottoCount(money);
        NumberAutoMachine numberAutoMachine = new NumberAutoMachine();
        List<Lotto> lottoBought = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            Lotto lotto = new Lotto(numberAutoMachine.pickNumbers());
            lottoBought.add(lotto);
        }
        return lottoBought;
    }

    // 로또 발행 개수 확인
    private int checkLottoCount(int money) {
        if (money % 1000 > 0) {
            throw new IllegalArgumentException(Error.ERROR_WRONG_MONEY.getMessage());
        }
        int lottoCount = money / 1000;
        return lottoCount;
    }

    // 로또 발행 개수 및 각 로또 번호 출력
    public void printLottoBought(List<Lotto> lottoBought) {
        int lottoCount = lottoBought.size();
        System.out.println();
        System.out.println(lottoCount + "개를 구매했습니다.");
        for (int i = 0; i < lottoCount; i++) {
            List<Integer> lottoNumber = lottoBought.get(i).getNumbers();
            System.out.println(lottoNumber);
        }
    }

    // 로또 당첨, 보너스 번호 전체 비교 과정
    public void compareLotto(List<Lotto> lottoBought, List<Integer> luckyNumbers, int bonusNumber) {
        int matchingNumber = 0;
        for (int i = 0; i < lottoBought.size(); i++) {
            List<Integer> lottoNumbers = lottoBought.get(i).getNumbers();
            matchingNumber = compareLuckyNumber(lottoNumbers, luckyNumbers);
            boolean bonus = compareBonusNumber(lottoNumbers, bonusNumber);
            WinningResult.plusWinningResult(matchingNumber, bonus);
        }
    }

    // 로또 번호와 당첨번호와 비교
    private int compareLuckyNumber(List<Integer> lottoNumbers, List<Integer> luckyNumbers) {
        int count = 0;
        for (int i = 0; i < lottoNumbers.size(); i++) {
            boolean checkNum = luckyNumbers.contains(lottoNumbers.get(i));
            if (checkNum) {
                count++;
            }
        }
        return count;
    }

    // 로또 번호와 보너스번호 비교
    private boolean compareBonusNumber(List<Integer> lottoNumbers, int bonusNumber) {
        boolean bonus = lottoNumbers.contains(bonusNumber);
        return bonus;
    }

    // 전체 당첨 통계 출력 및 수익률 출력
    public void printResult(int insertMoney) {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---");
        int i = 3;
        for (WinningResult winningResult : WinningResult.values()) {
            if (winningResult.name() == "BONUS") {
                System.out.println("5개 일치, 보너스 볼 일치 (" + changePrizeFormat(winningResult.getPrize()) + "원) - " + winningResult.getCount() + "개");
                continue;
            }
            System.out.println(i + "개 일치 (" + changePrizeFormat(winningResult.getPrize()) + "원) - " + winningResult.getCount() + "개");
            i++;
        }
        System.out.println("총 수익률은 " + getProfit(insertMoney) + "%입니다.");
    }

    // 구입금액과 총 당첨금액에 따른 수익률 계산
    private String getProfit(int insertMoney) {
        double totalPrize = 0;
        for (WinningResult winningResult : WinningResult.values()) {
            totalPrize += winningResult.getPrize() * winningResult.getCount();
        }
        double profit = (totalPrize / (double) insertMoney) * 100;
        String allProfit = String.format("%.1f", profit);
        return allProfit;
    }

    // 상금 천단위 콤마찍기
    private String changePrizeFormat(int prize) {
        DecimalFormat df = new DecimalFormat("###,###");
        String newFormatPrize = df.format(prize);
        return newFormatPrize;
    }

}
