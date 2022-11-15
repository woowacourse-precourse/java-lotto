package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import static camp.nextstep.edu.missionutils.Console.readLine;
import java.util.*;

public class Application {
    public static void validateString(String inputText){
        try{
            Integer.parseInt(inputText);
        }catch(NumberFormatException e){
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    // 로또 자동번호 생성
    public static List<HashSet<Integer>> createAutoNumbers(int numberOfPurchases) {
        System.out.println(String.format("%d개를 구매했습니다.", numberOfPurchases));
        List<HashSet<Integer>> autoNumbers = new ArrayList<>();
        for (int i = 0; i < numberOfPurchases; i++) {
            autoNumbers.add(new HashSet<>(Randoms.pickUniqueNumbersInRange(1, 45, 6)));
            System.out.println(new TreeSet<>(autoNumbers.get(autoNumbers.size()-1)));
        }
        return autoNumbers;
    }
    // 당첨 번호 생성
    public static List<Integer> createLottoNumber(){
        List stringLottoNumber = List.of(readLine().split(","));
        List<Integer> LottoNumber = new ArrayList<>();
        for(Object str : stringLottoNumber){
            LottoNumber.add(Integer.valueOf((String) str));
        }
        return LottoNumber;
    }

    // 보너스 번호 생성
    public static int createBonusNumber(List<Integer> lottoNumber){
        int bonusNumber = Integer.valueOf(readLine());
        if (!(1<= bonusNumber && bonusNumber <= 45) || lottoNumber.contains(bonusNumber)){
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
        return bonusNumber;
    }

    // 당첨 통계 생성
    public static int[] createLottoStatistics(List<Integer> lottoNumber, int bonusNumber, List<HashSet<Integer>> autoNumbers){
        int[] lottoStatistics = new int[6];

        for(HashSet autoNumber: autoNumbers){
            boolean isMatchBonus = autoNumber.contains(bonusNumber);
            autoNumber.retainAll(lottoNumber);
            if (autoNumber.size() >= 3){
                int lottoRank = prize.findRankByMatch(autoNumber.size(), isMatchBonus);
                lottoStatistics[lottoRank] += 1;
            }
        }
        return lottoStatistics;
    }
    // 당첨 통계 정보 생성
    public enum prize {
        FIFTH_F(5, "3개 일치 (5,000원)", 3, false,5_000),
        FIFTH_T(5, "3개 일치 (5,000원)", 3, true,5_000),
        FOURTH_F(4, "4개 일치 (50,000원)", 4,false,50_000),
        FOURTH_T(4, "4개 일치 (50,000원)", 4,true,50_000),
        THIRD(3, "5개 일치 (1,500,000원)", 5,false,1_500_000),
        SECOND(2, "5개 일치, 보너스 볼 일치 (30,000,000원)", 5,true,30_000_000),
        FIRST(1, "6개 일치 (2,000,000,000원)", 6,false,2_000_000_000);

        private final int rank;
        private final String text;
        private final int matchCount;
        private final boolean matchBonus;
        private final long prizeValue;

        prize(int rank, String text, int matchCount, boolean matchBonus, long prizeValue){
            this.rank = rank;
            this.text = text;
            this.matchCount = matchCount;
            this.matchBonus = matchBonus;
            this.prizeValue = prizeValue;
        }

        public int getRank(){
            return this.rank;
        }

        public long getPrizeValue(){
            return this.prizeValue;
        }

        public String getText(){
            return this.text;
        }
        // 당첨숫자를 맞춘 개수와 보너스를 맞춘 여부를 통해 순위 찾기 기능
        public static int findRankByMatch(int matchCount, boolean matchBonus){
            return Arrays.stream(values())
                    .filter(find -> find.matchCount == matchCount && find.matchBonus == matchBonus)
                    .findAny().get().getRank();
        }
        // 쉰위를 통해 상금 찾기 기능
        public static long findPrizeByRank(int rank){
            return Arrays.stream(values())
                    .filter(find -> find.rank == rank)
                    .findAny().get().getPrizeValue();
        }

        public static String findTextByRank(int rank){
            return Arrays.stream(values())
                    .filter(find -> find.rank == rank)
                    .findAny().get().getText();
        }
    }

    // 통계값 출력
    public static void printLottoStatistics(int[] lottoStatistics, int numberOfPurchases){
        int totalPrize = 0;
        for(int i = lottoStatistics.length-1; i > 0; i--){
            long prizeMoney = prize.findPrizeByRank(i);
            String text = prize.findTextByRank(i);
            System.out.println(String.format("%s - %d개", text, lottoStatistics[i]));
            totalPrize += prizeMoney * lottoStatistics[i];
        }
        double earningRate =(double) totalPrize * 100 / ((double) numberOfPurchases * 1000);
        System.out.println(String.format("총 수익률은 %.1f%%입니다.", earningRate));
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        String purchaseMoney = readLine();
        validateString(purchaseMoney);
        int numberOfPurchases = Integer.parseInt(purchaseMoney)/1000;
        List<HashSet<Integer>> autoNumbers = createAutoNumbers(numberOfPurchases);
        List<Integer> lottoNumber = createLottoNumber();
        Lotto validateLottoNumber = new Lotto(lottoNumber);
        int bonusNumber = createBonusNumber(lottoNumber);
        int[] lottoStatistics = createLottoStatistics(lottoNumber, bonusNumber, autoNumbers);
        printLottoStatistics(lottoStatistics, numberOfPurchases);
    }
}
