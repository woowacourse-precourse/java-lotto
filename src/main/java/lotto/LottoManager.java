package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class LottoManager {
    public static final int thirdPrice = 5000;
    public static final int fourthPrice = 50000;
    public static final int fifthPrice = 1500000;
    public static final int fifthBonusPrice = 30000000;
    public static final int sixthPrice = 2000000000;
    private final String ALLOWED_STRING =  "[0-9]{1,2},[0-9]{1,2},[0-9]{1,2},[0-9]{1,2},[0-9]{1,2},[0-9]{1,2}";
    private final Pattern pattern = Pattern.compile("("+ALLOWED_STRING+")");
    private List<Integer> winningNumber;
    private Integer bonusNumber;
    private static final String WINNING_STATUS_MESSAGE = "%d개 일치 (%s원) - %d개";
    private static final String WINNING_STATUS_SECOND_RANK_CASE_MESSAGE = "%d개 일치, 보너스 볼 일치 (%s원) - %d개";
    private static final String MONEY_PATTERN = "###,###";
    private Map<Rank, Integer> rankMap =  new TreeMap<>();
    public LottoManager() {
    }

    public void askWinningNumber(){
        System.out.println("당첨 번호를 입력해 주세요.");
        String winningNumber = Console.readLine();
        String checkWinningNum = checkWinningNum(winningNumber);
        List<Integer> winningNum = Arrays.stream(checkWinningNum.split(","))
                .map(number -> Integer.parseInt(number))
                .collect(Collectors.toList());
        winningNum.stream().forEach(num -> checkLottoNum(num));
        this.winningNumber = winningNum;
    }

    public void askBonusNumber(){
        try{
            System.out.println("보너스 번호를 입력해 주세요.");
            String bonusNum = Console.readLine();
            checkBonusNum(bonusNum);
            this.bonusNumber = Integer.parseInt(bonusNum);
        }catch (Exception e){
            Message.printErrorMessage(e);
            throw new IllegalArgumentException(e);
        }
    }

    private String checkWinningNum(String winningNum){
        String stripNum = winningNum.replaceAll("\\s","");
        if(!pattern.matcher(stripNum).matches()){
            throw new IllegalArgumentException("쉼표(,)로 구분 된 6자리 숫자를 입력해주세요");
        }
        return stripNum;
    }

    private void checkBonusNum(String bonusNum){
        try{
            Integer bonusNumber = Integer.parseInt(bonusNum);
            checkLottoNum(bonusNumber);
        }catch (Exception e){
            Message.printErrorMessage(e);
            throw new IllegalArgumentException(e);
        }

    }

    private void checkLottoNum(Integer num){
        if(num < LottoPublisher.startNum || num > LottoPublisher.lastNum){
            throw new IllegalArgumentException("로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    public void reportResult(Customer customer) {
        System.out.println("당첨 통계");
        System.out.println("---");
        List<Lotto> userLotto = customer.getUserLotto();
        int rewards = confirm(userLotto);
        System.out.println("총 수익률은 "+rewards/(double)customer.getAsset()*100+"%입니다.");

    }

    private int confirm(List<Lotto> userLotto){
        int sum = 0;
        initRankMap();
        for(Lotto lotto : userLotto){
            Rank rank = Rank.calculateRank(lotto, winningNumber, bonusNumber);
            rankMap.put(rank, rankMap.get(rank) + 1);
            sum += rank.getPrize();
        }
        for(Rank rank : rankMap.keySet()){
            if(rank.equals(Rank.LOSING_PRICE))continue;
            System.out.println(String.format(createMatchNum(rank),
                    rank.getMatch(),
                    convertPrize(rank.getPrize()),
                    rankMap.get(rank)));
        }
        return sum;
    }

    private String convertPrize(int prize) {
        return new DecimalFormat(MONEY_PATTERN).format(prize);
    }

    private String createMatchNum(Rank rank) {
        if(rank.equals(Rank.SECOND_PRICE)){
            return WINNING_STATUS_SECOND_RANK_CASE_MESSAGE;
        }
        return WINNING_STATUS_MESSAGE;
    }

    private void initRankMap(){
        for(Rank rank : Rank.values()){
            rankMap.put(rank, 0);
        }
    }
//    private int confirmOfWinning(List<Lotto> userLotto) {
//        //7번째 인덱스를 1등 당첨 인덱스로 생각한다.
//        int[] cnt = new int[LottoPublisher.lottoNum + 2];
//        for(Lotto number : userLotto){
//            int index = calculateWinningNum(number);
//            cnt[index]++;
//        }
//        int sum = 0;
//        for(int i=3; i<LottoPublisher.lottoNum+2; i++){
//            System.out.println(i + "개 일치 = " + cnt[i]);
//            if(cnt[i] != 0){
//                if(i==3){
//                    sum += thirdPrice;
//                }
//                if(i==4){
//                    sum+=fourthPrice;
//                }
//                if(i==LottoPublisher.lottoNum-1){
//                    System.out.println("5개 일치 = "+cnt[i]);
//                    sum+=fifthPrice;
//                }
//                if(i==LottoPublisher.lottoNum){
//                    System.out.println("5개 일치(보너스) = " + cnt[i]);
//                    sum+=fifthBonusPrice;
//                    continue;
//                } else if (i == LottoPublisher.lottoNum+1) {
//                    System.out.println("6개 일치 = " + cnt[i]);
//                    sum+=sixthPrice;
//                    continue;
//                }
//            }
//        }
//        System.out.println("sum = " + sum);
//        return sum;
//    }

//    private int calculateWinningNum(Lotto number) {
//        int ret = 0;
//        for(Integer winningNum : winningNumber){
//            if(number.getNumbers().contains(winningNum)){
//                ret++;
//            }
//        }
//        //보너스
//        if(ret == 5){
//            if(number.getNumbers().contains(bonusNumber)){
//                ret = bonusIndex;
//            }
//        }
//        //당첨
//        if(ret == 6){
//            ret++;
//        }
//        return ret;
//    }
}
