package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class GameController {

    static Integer cost;    // 구입 금액

    static Integer numberOfTickets;    // 티켓 갯수

    static List<List<Integer>> ticketList;    // 티켓들의 목록

    static List<Integer> lottoNumber;    // 당첨 번호

    static Integer bonusNumber;    // 보너스 번호

    static List<Integer> scoreList; // 몇개 맞았는지 들어있는 리스트

    static List<Integer> rankList;    // 당첨 등수 리스트

    static Float profitRate ;    // 수익률

    static String ERROR_MESSAGE = "[ERROR]";
    static Constant constant = new Constant();

    public GameController(){
        //gameStarter();
    }

    public void gameStarter() {
        getCost();
        getTickets();
        getLotto();
        getBonus();
        getScoreList();
        getRankAndProfitRate();

    }

    private void getCost() {
        System.out.println(constant.INPUT_COST);
        String inputCost = Console.readLine();
        BuyPrice buyPrice = new BuyPrice(inputCost);
        cost = buyPrice.buyCost;
        numberOfTickets = buyPrice.numberOfTickets;
    }

    private void getTickets(){
        System.out.println(numberOfTickets+constant.BUY_TICKET);
        TicketNumbers ticketNumbers = new TicketNumbers(numberOfTickets);
        ticketList = ticketNumbers.collectTickets();
        ticketNumbers.showTickets();
    }

    private void getLotto(){
        System.out.println(constant.INPUT_LOTTO);
        String str = Console.readLine();
        MakeStrToIntList makeStrToIntList = new MakeStrToIntList(str);
        List<Integer> numbers = makeStrToIntList.numbers;
        Lotto lotto = new Lotto(numbers);
        lottoNumber = lotto.returnNumbers();
    }

    private void getBonus(){
        System.out.println(constant.INPUT_BONUS);
        String str = Console.readLine();
        try {
            Integer.parseInt(str);
        }catch (NumberFormatException e){
            throw new IllegalArgumentException(ERROR_MESSAGE);
            //new Exceptions(" 숫자를 입력하세요");
        }
        int num = Integer.parseInt(str);
        BonusNumber bonus = new BonusNumber(num,lottoNumber);
        bonusNumber = bonus.bonusNumber;
    }

    private void getScoreList(){
        System.out.println(constant.SHOW_RESULT_STATIC1);
        System.out.println(constant.SHOW_RESULT_STATIC2);
        CheckScore checkScore = new CheckScore(lottoNumber,ticketList,bonusNumber);
        scoreList = checkScore.scoreList;


    }

    private void getRankAndProfitRate(){
        ProfitRate profit = new ProfitRate(cost,scoreList);
        rankList = profit.rankList;
        profitRate = profit.profitRate;
        showStatic();
        System.out.println(constant.TOTAL_RESULT1 + profitRate + constant.TOTAL_RESULT2);
    }

    private void showStatic(){
        System.out.println(constant.RANK5 + rankList.get(0) + constant.RANK_FINISH);
        System.out.println(constant.RANK4 + rankList.get(1) + constant.RANK_FINISH);
        System.out.println(constant.RANK3 + rankList.get(2) + constant.RANK_FINISH);
        System.out.println(constant.RANK2 + rankList.get(3) + constant.RANK_FINISH);
        System.out.println(constant.RANK1 + rankList.get(4) + constant.RANK_FINISH);
    }


}
