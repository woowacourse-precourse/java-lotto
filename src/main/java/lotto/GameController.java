package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class GameController {

    final String input_cost; //구입 금액 검증하기
    static Integer cost;    // 구입 금액

    static Integer numberOfTickets;    // 티켓 갯수

    static List<List<Integer>> ticketList;    // 티켓들의 목록

    final String input_number;

    static List<Integer> lottoNumber;    // 당첨 번호

    final String input_bonus;

    static Integer bonusNumber;    // 보너스 번호

    static List<Integer> scoreList; // 몇개 맞았는지 들어있는 리스트

    static List<Integer> rankList;    // 당첨 등수 리스트

    static Float profitRate ;    // 수익률


    public GameController(String input_cost,String input_number, String input_bonus){
        this.input_cost = input_cost;
        this.input_number = input_number;
        this.input_bonus = input_bonus;
        gameStarter();
    }

    private void gameStarter() {
        getCost();
        getTickets();
        getLotto();
        getBonus();
        getScoreList();
        getRankAndProfitRate();
    }

    private void getCost() {
//        String inputCost = Console.readLine();
        BuyPrice buyPrice = new BuyPrice(input_cost);
        cost = buyPrice.buyCost;
        numberOfTickets = buyPrice.numberOfTickets;
    }

    private void getTickets(){
        TicketNumbers ticketNumbers = new TicketNumbers(numberOfTickets);
        ticketList = ticketNumbers.collectTickets();

    }

    private void getLotto(){
//        String str = Console.readLine();
        MakeStrToIntList makeStrToIntList = new MakeStrToIntList(input_number);
        List<Integer> numbers = makeStrToIntList.numbers;
        Lotto lotto = new Lotto(numbers);
        lottoNumber = lotto.returnNumbers();
    }

    private void getBonus(){
//        String str = Console.readLine();
        int num = Integer.parseInt(input_bonus);
        BonusNumber bonus = new BonusNumber(num,lottoNumber);
        bonusNumber = bonus.bonusNumber;
    }

    private void getScoreList(){
        CheckScore checkScore = new CheckScore(lottoNumber,ticketList,bonusNumber);
        scoreList = checkScore.scoreList;
    }

    private void getRankAndProfitRate(){
        ProfitRate profit = new ProfitRate(cost,scoreList);
        rankList = profit.rankList;
        profitRate = profit.profitRate;
    }


}
