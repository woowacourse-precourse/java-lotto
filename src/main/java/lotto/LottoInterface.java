package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class LottoInterface {
    public static int getPurchasePrice(){
        int purchasePrice = 0;
        System.out.println("구입금액을 입력해 주세요.");

        String userInput = Console.readLine();
        if(ErrorCheck.isValidPrice(userInput)){
            purchasePrice = Integer.parseInt(userInput);
        }
        System.out.println(purchasePrice);

        return purchasePrice;
    }

    public static void purchasedLottosInformation(List<Lotto> purchaseLottos){
        System.out.println(purchaseLottos.size() + "개를 구매했습니다.");
        for(Lotto lottoNum : purchaseLottos){
            System.out.println(lottoNum.getNumber());
        }
    }

    public static List<Integer> winningLottoNum(){
        System.out.println("당첨 번호를 입력해 주세요.");
        String inputWinningNum = Console.readLine();
        List<Integer> winningLottoNums = Arrays.stream(inputWinningNum.split(",")).map(Integer::parseInt).collect(Collectors.toList());

        return winningLottoNums;
    }

    public static int getBonusNumber(){
        int bonus = 0;
        System.out.println("보너스 번호를 입력해 주세요.");
        String inputBonus = Console.readLine();

        if (ErrorCheck.isValidNumber(inputBonus)) {
            bonus = Integer.parseInt(inputBonus);
        }

        return bonus;
    }

    public static void winningStatistics(List<Lotto> purchaseLottos, Lotto winningLottoNum, int bonus){
        System.out.println("당첨 통계" );
        System.out.println("---");
        HashMap<WinningRank, Integer> ranking = LottoShop.confirmRank(purchaseLottos, winningLottoNum, bonus);
        Arrays.stream(WinningRank.values()).filter(rank -> rank != WinningRank.BANG).map(rank -> rank.getRightNumCnt() + "개 일치" + (rank == WinningRank.SECOND ? ", 보너스 볼 일치" : "")
                + " (" + rank.getRewardDecimalFormat() + "원) - " + ranking.get(rank) + "개").forEach(System.out::println);
    }

    public static void yield(){
        System.out.println("총 수익률은 " + LottoShop.totalYield() + "%입니다.");
    }
}
