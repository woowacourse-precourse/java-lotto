package lotto;

import java.util.*;

public class Application {
    public static void main(String[] args) {
        try {
            Function function = new Function();
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
        catch (Exception e) { System.out.println("[ERROR] " + e.getMessage()); }
    }
//
//    /* 돈 입력받는 메소드 */
//    public static int getAmount(){
//        System.out.println("구매금액을 입력해 주세요.");
//        int amount = 0;
//        try{
//            amount = Integer.parseInt(readLine());
//        }catch (Exception e){
//            throw new IllegalArgumentException();
//        }
//        return amount;
//    }
//
//    /* 몇개의 로또를 구입할 수 있는지 계산하는 메소드*/
//    public static int getNumberOfTimes(int amount){
//        if(amount % 1000 != 0)
//            throw new IllegalArgumentException();
//        int lottoCount = amount / 1000;
//        return lottoCount; //받에서 sout ~개를 구입하였습니다.
//    }
//
//    /*로또 번호 자동생성 메소드*/
//    public static ArrayList<Integer> makeLottoNumber(){
//        List<Integer> lottoNumbersTemp = Randoms.pickUniqueNumbersInRange(1, 45, 6);
//        ArrayList lottoNumbers = new ArrayList();
//        lottoNumbers.addAll(lottoNumbersTemp);
//        System.out.println(lottoNumbers);
//        return lottoNumbers;
//    }
//
//    /*당첨번호 입력 메소드*/
//    public static String getWinningNumber(){
//        System.out.println("당첨 번호를 입력해 주세요");
//        String winningNumber = null;
//        try{
//            winningNumber = readLine();
//        }catch (Exception e){
//            throw new IllegalArgumentException();
//        }
//        return winningNumber;
//    }
//
//    /*당첨번호를 list<Integer>로 바꾸는 메소드 */
//    public static List<Integer> StringToIntegerList(String winningNumber){
//        List<String> seperatedString = Arrays.asList(winningNumber.split(","));
//        List<Integer> winningNumbers = new ArrayList<>();
//        for(String character : seperatedString){
//            winningNumbers.add(Integer.parseInt(character));
//        }
//        return winningNumbers;
//    }
//
//
//
//    /*보너스 번호를 입력받는 메소드*/
//    public static int getBonusNum(){
//        System.out.println("보너스 번호를 입력해 주세요");
//        int bonusNum = Integer.parseInt(readLine());
//        return bonusNum;
//    }
//
//    /*당첨 번호로 분리된 Map을 반환하는 메소드*/
//    public static Map<Integer,Integer> analyzeLotto(List<ArrayList<Integer>> lottos, List<Integer> winningNumbers, int bonusNum){
//        Map<Integer,Integer> separatedByRanking = new HashMap<>();
//        for(ArrayList<Integer> lotto : lottos){
//            int matchingNum = countMatching(lotto, winningNumbers);
//            if(matchingNum == 4 && lotto.contains(bonusNum)){
//                matchingNum =7; //보너스인경우 7사용
//            }
//            separatedByRanking = insertSeparatedByRanking(separatedByRanking,matchingNum);
////            System.out.println("analze : " + separatedByRanking );
//        }
//        return separatedByRanking;
//    }
//
//    /*당첨된 로또 개수*/
//    private static int countMatching(List<Integer> lotto, List<Integer> winningNumbers){
//        Set<Integer> noDuplicableSet = new HashSet<>(lotto);
//        for(Integer winningNumber : winningNumbers){
//            noDuplicableSet.add(winningNumber);
//        }
//        int matchingNum = 12 - noDuplicableSet.size();
////        System.out.println("일치하는 번호 개수 : "+ matchingNum);
//        return matchingNum;
//    }
//
//    /* insertSeparatedByRanking, 당첨 개수 별로 맵에 분리하여 담음 */
//    private static Map<Integer,Integer> insertSeparatedByRanking(Map<Integer, Integer> separatedByRanking, int insertNum) {
//        int value = 0;
//        if(separatedByRanking.containsKey(insertNum))
//            value = separatedByRanking.get(insertNum);
//        separatedByRanking.put(insertNum, value+1);
//        return separatedByRanking;
//    }
//
//    /* 수익률 계산 메소드 */
//    public static void calculateProfitRate(Map<Integer, Integer> separatedByRanking, int initialAmount){
//        System.out.println("당첨 통계");
//        System.out.println("---");
//        int [] ranks = new int[]{3,4,5,7,6};
//        int total = 0;
//        for(int rank : ranks){
//            Statistic statistic = Statistic.of(rank);
//            if(separatedByRanking.get(rank) != null){
//                int count = separatedByRanking.get(rank);// 개수
//                total += statistic.getPrize() * count;
//                System.out.println(statistic.getMent()+" - "+count+"개");
//                continue;
//            }
//            System.out.println(statistic.getMent()+" - "+0+"개");
//        }
//        double profitRate = ((double)total / initialAmount) * 100;
//        System.out.println("총 수익률은 " + profitRate +"%입니다.");
//    }
}
