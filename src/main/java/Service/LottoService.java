package Service;

import domain.*;
import lotto.Lotto;
import utils.RandomNumberLottoGenerator;
import view.RequestUser;
import camp.nextstep.edu.missionutils.Console;
import view.SystemMessage;

import java.util.*;

public class LottoService {

    BonusNumber bonusNumber = new BonusNumber();
    WinningNumber winningNumber = new WinningNumber();
    Reward reward = new Reward();
    UserMoneyValidate userMoneyValidate = new UserMoneyValidate();
    SystemMessage systemMessage = new SystemMessage();

    public void lottoGame() {
        int userMoney = getUserMoney();
        systemMessage.requestTotalMoney(userMoney);
        Ticket ticket = new Ticket();
        int ticketNum = ticket.getTicketNum(userMoney);
        systemMessage.ticketsMessage(ticketNum);
        List<List<Integer>> allTickets = getAllLotto(ticketNum);

        List<Integer> winningNumbers = getWinningNumbers();
        int bonus = getBonusNumbers();
        List<Integer> allWinningNumbers = totalWinningNumbers(winningNumbers, bonus);

        Map<Rank, Integer> map = new HashMap<>();
        Map<Rank, Integer> rankMap = calculation(allWinningNumbers, allTickets, map);
        systemMessage.countMessage(rankMap);

        Long sum = reward.totalReward(rankMap);
        double profit = reward.percentage(sum, userMoney);
        systemMessage.getProfit(profit);
    }

//    public void set_winning(){
//        List<Integer> winningNumbers = getWinningNumbers();
//        int bonus = getBonusNumbers();
//        List<Integer> allWinningNumbers = totalWinningNumbers(winningNumbers, bonus);
//    }

    public List<Integer> getWinningNumbers(){
        RequestUser.requestLottoNum();
        String input = Console.readLine();
        List<Integer> winningNumbers = winningNumber.validateWinningNumbers(input);
        systemMessage.winningNumbersMessage(input);

        return winningNumbers;
    }

    public int getBonusNumbers(){
        RequestUser.requestBonusNum();
        String input = Console.readLine();
        int bonus = bonusNumber.getBonusNumber(input);
        systemMessage.bonusNumberMessage(input);

        return bonus;
    }

    public List<Integer> totalWinningNumbers(List<Integer> winningNumbers, int bonus){
        winningNumbers.add(bonus);
        return winningNumbers;
    }

    public int getUserMoney() throws IllegalArgumentException{
        RequestUser.requestMoney();
        String userInput = Console.readLine();
        return userMoneyValidate.validateGetMoney(userInput);
    }

    public List<List<Integer>> getAllLotto(int tickets){
        List<List<Integer>> allTicket = new ArrayList<>();
        for (int i = 0; i < tickets; i++) {
            RandomNumberLottoGenerator randomNumberLottoGenerator = new RandomNumberLottoGenerator();
            Set<Integer> generate = randomNumberLottoGenerator.generate();
            List<Integer> randomNum = randomNumberLottoGenerator.convertSetToList(generate);
            allTicket.add(randomNum);
            Lotto lotto = new Lotto(randomNum);
            lotto.numbersAscending(randomNum);
            systemMessage.ticketNumberMessage(randomNum);
        }
        return allTicket;
    }

    public Map<Rank, Integer> calculation(List<Integer> allWinningNumbers, List<List<Integer>> allTicket, Map<Rank, Integer> map){
        systemMessage.mapSetting(map);
        for(List<Integer> list : allTicket){
            Rank rank = Rank.winningCondition(allWinningNumbers, list);
            systemMessage.getCount(rank, map);
        }

        return map;
    }

    public Map<Rank, Integer> initialMap(Map<Rank, Integer> map){
        systemMessage.mapSetting(map);
        return map;
    }
}
