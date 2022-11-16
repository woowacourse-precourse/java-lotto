package lotto;

import java.util.ArrayList;
import java.util.List;

public class PrintLotto {
    List<List<Integer>> lottoList = new ArrayList<>();
    private int issuanceCount = 0; // 발행 개수
    int[] winningTypeCount = {0, 0, 0, 0, 0}; // 당첨 종류 개수 3, 4, 5, 6, 5+보너스

    public enum winnigCashType // 당첨금 종류
    {
        losing(0, 0),
        winThree(3, 5_000), winFour(4, 50_000), winFive(5, 1_500_000),
        winSix(6, 2_000_000_000), winFiveAndBns(7, 30_000_000);

        private int winningCnt;
        private int winningMoney;

        winnigCashType(int winningCnt, int winningMoney) {
            this.winningCnt  = winningCnt;
            this.winningMoney = winningMoney;
        }

        public int getWinningCnt() {
            return winningCnt;
        }

    }

    public void startPrintList(int cash, List<Integer> winningLotto, int bounusNumber) {
        compormationWinning(winningLotto, bounusNumber);
        winningCountList(cash);
    }

    public void issuance(int cnt) { // 구매 개수만큼 복권 발행 출력
        issuanceCount = cnt;
        MakeLottoNumber makeLottoNumber = new MakeLottoNumber();
        System.out.println(issuanceCount+"개를 구매했습니다.");

        for (int i = 0; i < issuanceCount; i++) {
            List<Integer> tmp= makeLottoNumber.returnLottoNumber();
            lottoList.add(tmp);
            System.out.println(lottoList.get(i));
        }
    }

    public void compormationWinning(List<Integer> winningLotto, int bonusNumber) {  // 당첨 번호와 발행 로또 번호를 비교
        for(int i = 0; i<issuanceCount; i++) {
            winnigCashType tmp = inquiry(lottoList.get(i), winningLotto, bonusNumber);
            if(tmp.getWinningCnt() != 0){
                winningTypeCount[tmp.getWinningCnt() - 3]++;
            }
        }
    }

    public void winningCountList(int cash) {
        float prizeMoney = getPrizrMoney();
        float getPercent = (prizeMoney/cash)*100;

        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - "+winningTypeCount[0]+"개");
        System.out.println("4개 일치 (50,000원) - "+winningTypeCount[1]+"개");
        System.out.println("5개 일치 (1,500,000원) - "+winningTypeCount[2]+"개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - "+winningTypeCount[4]+"개");
        System.out.println("6개 일치 (2,000,000,000원) - "+winningTypeCount[3]+"개");
        System.out.println("총 수익률은 "+(Math.round(getPercent*100)/100.0)+"%입니다.");
    }

    public int getPrizrMoney() {
        int prizeMoney = winningTypeCount[0] * winnigCashType.winThree.winningMoney + winningTypeCount[1] * winnigCashType.winFour.winningMoney
                + winningTypeCount[2] * winnigCashType.winFive.winningMoney + winningTypeCount[4] * winnigCashType.winFiveAndBns.winningMoney
                + winningTypeCount[3] * winnigCashType.winSix.winningMoney;

        return prizeMoney;
    }

    public winnigCashType inquiry(List<Integer> lotto, List<Integer> winningLotto, int bonusNumber) { // 당첨 번호에 따른 당첨타입 enum 값을 리턴
        int winningCount = 0;
        for(int j = 0; j<winningLotto.size(); j++){
            if(lotto.contains(winningLotto.get(j))){
                winningCount++;
            }
        }
        if(winningCount == 5 && lottoList.contains(bonusNumber)){
            return winnigCashType.winFiveAndBns;
        }
        if(winningCount >= 3){
            return findCashType(winningCount);
        }
        return winnigCashType.losing;
    }

    public winnigCashType findCashType(int number) {
        if(number == 3) return winnigCashType.winThree;
        if(number == 4) return winnigCashType.winFour;
        if(number == 5) return winnigCashType.winFive;
        return winnigCashType.winSix;
    }
}
