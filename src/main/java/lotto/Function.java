package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Function {
    /* 돈 입력받는 메소드 */
    public int getAmount(){
        System.out.println("구매금액을 입력해 주세요.");
        int amount = 0;
        try{
            amount = Integer.parseInt(readLine());
        }catch (Exception e){
            throw new IllegalArgumentException();
        }
        return amount;
    }

    /* 몇개의 로또를 구입할 수 있는지 계산하는 메소드*/
    public int getNumberOfTimes(int amount){
        if(amount % 1000 != 0)
            throw new IllegalArgumentException();
        int lottoCount = amount / 1000;
        return lottoCount; //받에서 sout ~개를 구입하였습니다.
    }

    /*로또 번호 자동생성 메소드*/
    public ArrayList<Integer> makeLottoNumber(){
        List<Integer> lottoNumbersTemp = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        ArrayList lottoNumbers = new ArrayList();
        lottoNumbers.addAll(lottoNumbersTemp);
        System.out.println(lottoNumbers);
        return lottoNumbers;
    }

    /*당첨번호 입력 메소드*/
    public String getWinningNumber(){
        System.out.println("당첨 번호를 입력해 주세요");
        String winningNumber = readLine();
        return winningNumber;
    }

    /*당첨번호를 list<Integer>로 바꾸는 메소드 */
    public List<Integer> stringToIntegerList(String winningNumber){
        List<String> seperatedString = Arrays.asList(winningNumber.split(","));
        List<Integer> winningNumbers = new ArrayList<>();
        for(String character : seperatedString){
            winningNumbers.add(Integer.parseInt(character));
        }
        return winningNumbers;
    }

    /*보너스 번호를 입력받는 메소드*/
    public int getBonusNum(){
        System.out.println("보너스 번호를 입력해 주세요");
        int bonusNum = Integer.parseInt(readLine());
        return bonusNum;
    }

    /*당첨 번호로 분리된 Map을 반환하는 메소드*/
    public Map<Integer,Integer> analyzeLotto(List<ArrayList<Integer>> lottos, List<Integer> winningNumbers, int bonusNum){
        Map<Integer,Integer> separatedByRanking = new HashMap<>();
        for(ArrayList<Integer> lotto : lottos){
            int matchingNum = countMatching(lotto, winningNumbers);
            if(matchingNum == 4 && lotto.contains(bonusNum)){
                matchingNum =7; //보너스인경우 7사용
            }
            separatedByRanking = insertSeparatedByRanking(separatedByRanking,matchingNum);
        }
        return separatedByRanking;
    }

    /*당첨된 로또 개수*/
    private int countMatching(List<Integer> lotto, List<Integer> winningNumbers){
        Set<Integer> noDuplicableSet = new HashSet<>(lotto);
        for(Integer winningNumber : winningNumbers){
            noDuplicableSet.add(winningNumber);
        }
        int matchingNum = 12 - noDuplicableSet.size();
        return matchingNum;
    }

    /* insertSeparatedByRanking, 당첨 개수 별로 맵에 분리하여 담음 */
    private Map<Integer,Integer> insertSeparatedByRanking(Map<Integer, Integer> separatedByRanking, int insertNum) {
        int value = 0;
        if(separatedByRanking.containsKey(insertNum))
            value = separatedByRanking.get(insertNum);
        separatedByRanking.put(insertNum, value+1);
        return separatedByRanking;
    }

    /* 수익률 계산 메소드 */
    public double calculateProfitRate(Map<Integer, Integer> separatedByRanking, int initialAmount){
        System.out.println("당첨 통계");
        System.out.println("---");
        int total = getTotal(separatedByRanking);
        double profitRate = ((double)total / initialAmount) * 100;
        System.out.println("총 수익률은 " + profitRate +"%입니다.");
        return profitRate;
    }

    private static int getTotal(Map<Integer, Integer> separatedByRanking) {
        int [] ranks = new int[]{3,4,5,7,6};
        int total = 0;
        for(int rank : ranks){
            Statistic statistic = Statistic.of(rank);
            if(separatedByRanking.get(rank) != null){
                int count = separatedByRanking.get(rank);// 개수
                total += statistic.getPrize() * count;
                System.out.println(statistic.getMent()+" - "+count+"개");
                continue;}
            System.out.println(statistic.getMent()+" - "+0+"개");
        }
        return total;
    }
}
