package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Process {
    private static final String BUY_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String LOTTO_BUY_CONFIRM_MESSAGE = "개를 구매했습니다.";
    private static final String ANSWER_NUMBER_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String BONUS_NuMBER_MESSAGE = "보너스 번호를 입력해 주세요.";
    private static final String WINNING_REPORT_MESSAGE = "당첨 통계";
    private static final String SECTION_MESSAGE = "---";

    private static String userMoney;
    private static int lottoPaper;
    private static int savelottoPaper;
    private static List<String> answerNumber;
    private static String bonus;

    static void purchaseMessage() {
        System.out.println(BUY_MESSAGE);
        userMoney = UserInput.money();
    }

    static void lottoCountMessage(){
        lottoPaper = UserInput.coin(userMoney);
        savelottoPaper = lottoPaper;
        System.out.println();
        System.out.println(lottoPaper + LOTTO_BUY_CONFIRM_MESSAGE);
    }

    static void purchaseNumberMessage() {
        System.out.println();
        System.out.println(ANSWER_NUMBER_MESSAGE);
        answerNumber = UserInput.userNumber();
        System.out.println();
    }
    static void bonusNumberMessage(){
        System.out.println(BONUS_NuMBER_MESSAGE);
        bonus = UserInput.userBonus();
        System.out.println();
    }

    static List<List<Integer>> outputLotto() {
        List<List<Integer>> lotto = new ArrayList<>();
        while (lottoPaper-- > 0) {
            List<Integer> oneLineLotto = Lotto.getLotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            oneLineLotto.sort(Comparator.naturalOrder());
            lotto.add(oneLineLotto);
        }
        return lotto;
    }

    static void printBuyLotto(List<List<Integer>> lotto){
        for (List<Integer> oneLotto : lotto){
            System.out.println(oneLotto);
        }
    }

    static void initialRanking() {
        Rank.settingRankMap();
    }

    static void settingRank(List<List<Integer>> lotto) {
        for (List<Integer> com : lotto) {
            int countAnswer = MatchPrize.matchNumber(com, UserInput.lottoNumber(answerNumber));
            Rank r = Rank.countCondition(countAnswer, MatchPrize.matchBonus(com, UserInput.lottoBonusNumber(bonus)));
            Rank.addRankCount(r);
        }
    }

    static void resultMessage() {
        System.out.println(WINNING_REPORT_MESSAGE);
        System.out.println(SECTION_MESSAGE);
        RewardMessage.prizeMessage(Rank.getRankCount());
        RewardMessage.yieldMessage(savelottoPaper * 1000, RewardMessage.lottoReward(Rank.getRankCount()));
    }
}
