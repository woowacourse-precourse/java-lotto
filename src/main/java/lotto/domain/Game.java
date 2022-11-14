package lotto.domain;

import camp.nextstep.edu.missionutils.Console;
import jdk.swing.interop.SwingInterOpUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Game {

    // 로또 구입금액 입력
    public int insertMoney() {
        System.out.println("구입 금액을 입력해 주세요.");
        int money = Integer.parseInt(Console.readLine());
        return money;
    }

    // 로또 발행하기
    public List<Lotto> createLotto(int money) {
        int lottoCount = checkLottoCount(money);
        LottoAutoMachine lottoAutoMachine = new LottoAutoMachine();
        List<Lotto> lottoBought = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            Lotto lotto = new Lotto(lottoAutoMachine.pickNumbers());
            lottoBought.add(lotto);
        }
        return lottoBought;
    }

    // 로또 발행 개수 확인 및 예외 처리
    private int checkLottoCount(int money) {
        if (money % 1000 > 0) {  // 천원단위로 나누어 떨어지지 않을 경우 예외처리
            throw new IllegalArgumentException("[ERROR] 금액이 잘못되었습니다.");
        }
        int lottoCount = money / 1000;
        return lottoCount;
    }

    public void printLottoBought(List<Lotto> lottoBought) {
        int lottoCount = lottoBought.size();
        System.out.println(lottoCount + "개를 구매했습니다.");
        for (int i = 0; i < lottoCount; i++) {
            System.out.println(lottoBought.get(i).getNumbers());
        }
    }

    // 로또 당첨, 보너스 번호 전체 비교 *********리팩토링*******
    public void compareLotto(List<Lotto> lottoBought, List<Integer> luckyNumbers, int bonusNumber) {

        int matchingNumber = 0;
        for (int i = 0; i < lottoBought.size(); i++) {
            List<Integer> lottoNumbers = lottoBought.get(i).getNumbers();
            matchingNumber = compareLuckyNumber(lottoNumbers, luckyNumbers);
            boolean bonus = compareBonusNumber(lottoNumbers, bonusNumber);
            WinningResult.plusWinningResult(matchingNumber, bonus);
        }
    }

    // 로또 당첨번호와 부분 비교하기
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

    // 로또 보너스번호와 부분 비교하기
    private boolean compareBonusNumber(List<Integer> lottoNumbers, int bonusNumber) {
        boolean bonus = lottoNumbers.contains(bonusNumber);
        return bonus;
    }

    public void printResult(int insertMoney) {
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (" + WinningResult.THREE.getPrize() + "원) - " + WinningResult.THREE.getCount() + "개");
        System.out.println("4개 일치 (" + WinningResult.FOUR.getPrize() + "원) - " + WinningResult.FOUR.getCount() + "개");
        System.out.println("5개 일치 (" + WinningResult.FIVE.getPrize() + "원) - " + WinningResult.FIVE.getCount() + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (" + WinningResult.BONUS.getPrize() + "원) - " + WinningResult.BONUS.getCount() + "개");
        System.out.println("6개 일치 (" + WinningResult.SIX.getPrize() + "원) - " + WinningResult.SIX.getCount() + "개");
        System.out.println("총 수익률은 "+ getProfit(insertMoney) + "%입니다.");
    }

    private String getProfit(int insertMoney){
        double totalPrize = 0;
        for (WinningResult winningResult : WinningResult.values()){
            totalPrize += winningResult.getPrize() * winningResult.getCount();
        }
        double profit = (((double) insertMoney - totalPrize) / (double) insertMoney) * 100;
        String allProfit = String.format("%.1f", profit);
        return allProfit;
    }

}
