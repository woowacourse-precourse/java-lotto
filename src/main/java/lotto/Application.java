package lotto;

import java.util.*;

public class Application {
    public static void main(String[] args) {
        try {Function function = new Function();
            int amount = function.getAmount(); //돈입력
            int lottoCount = function.getNumberOfTimes(amount); //로또 몇개 살 수 있는지 숫자 계산
            System.out.println(lottoCount+"개를 구매했습니다.");
            List<ArrayList<Integer>> lottos = new ArrayList<>();
            for(int lotto = 0; lotto < lottoCount; lotto++) {
                lottos.add(function.makeLottoNumber());}
            String winnigNumber = function.getWinningNumber(); //로또 정답 받기.
            List<Integer> winningNumbers = function.stringToIntegerList(winnigNumber); // List<Integer>로 변환
            int bonusNum = function.getBonusNum();
            Map<Integer,Integer> separatedByRanking = function.analyzeLotto(lottos, winningNumbers,bonusNum); //당첨개수별로 분리한 map반환
            function.calculateProfitRate(separatedByRanking,amount); } //출석률 조회
        catch (Exception e) { System.out.println("[ERROR] " + e.getMessage()); }}
}
