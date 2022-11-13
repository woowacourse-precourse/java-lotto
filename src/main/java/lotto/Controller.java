package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class Controller {
    private final int MONEY_UNIT = 1000;
    private final Input input = new Input();
    private final Output output = new Output();

    public void generate() {
        // 1. 돈 입력 받기
        try {
            int money = input.getMoney();

            // 2. 금액에 해당하는 로또 생성 - 출력하기
            Set<Lotto> lottoSet = createLottos(money);
            output.printLottos(lottoSet);

            // 3. 당첨번호, 보너스 번호 입력 -> 당첨 로또 만들기
            List<Integer> winningNumbers = input.getWinningNumbers();  //로또 객체로 만들기
            Lotto winningLotto = new Lotto(input.getWinningNumbers()); //로또객체로 만드는 이유: INPUT이 유효한지 체크하기 위함.
            int bonusNumber = input.getBonusNumber();

            // 4. 당첨된 로또 개수 맵 만들기 {등수:개수} - 당첨 내역 출력하기
            Map<String, Integer> resultMap = createResultMap(lottoSet, winningNumbers, bonusNumber);
            printResult(money, resultMap);

            // 5. 수익률 계산하기 - 수익률 출력하기
            printYield(calculateYield(money, resultMap));

        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    public Set<Lotto> createLottos(int money) {
        int count = money / MONEY_UNIT;
        Set<Lotto> lottoSet = new HashSet<>();

        while (lottoSet.size() != count) {
            Lotto lotto = new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            lottoSet.add(lotto);
        }

        return lottoSet;
    }


    // 당첨된 로또 개수 맵 만들기 {등수:개수}
    public Map<String, Integer> createResultMap(Set<Lotto> lottoSet, List<Integer> winningLotto, int bonusNumber) {
        Map<String, Integer> resultMap = new HashMap<>();

        for (Lotto eachLotto : lottoSet) {
            eachLotto.setRank(winningLotto, bonusNumber);
            String rank = eachLotto.getRank(); //getRank로 한번에
            addToResultMap(resultMap, rank);
        }
        return resultMap;
    }

    //당첨 기준별 로또 개수 세기 기능.
    public void addToResultMap(Map<String, Integer> resultMap, String rank) {
        //putIfAbsent나 다른 것 사용해보기
        int winningCount = resultMap.getOrDefault(rank, 0);
        resultMap.put(rank, winningCount + 1);
    }


    //수익률 계산하기
    private final List<String> ranks = List.of("FIFTH","FOURTH","THIRD","SECOND","FIRST");
    public double calculateYield(double money, Map<String, Integer> resultMap) {
        int totalPrize = 0;
        for(String rank : ranks) {
            int count = resultMap.getOrDefault(rank,0);
            int prize = Rank.valueOf(rank).getPrize();
            totalPrize += count*prize;
        }
        return Math.round(totalPrize/money*1000)/10.0;
    }


    //당첨 내역 출력하기
    public void printResult(int money, Map<String, Integer> resultMap) {
        System.out.println("\n당첨 통계\n---");

        for(String rank : ranks) {
            int count = resultMap.getOrDefault(rank, 0);
            System.out.println(Rank.valueOf(rank).toString()+count+"개");
        }
    }

    //수익률 출력하기
    public void printYield(double yield) {
        System.out.println("총 수익률은 "+yield+"%입니다.");
    }

}
