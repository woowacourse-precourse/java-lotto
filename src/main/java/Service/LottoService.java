package Service;

import domain.Ticket;
import domain.UserMoneyValidate;
import lotto.Lotto;
import utils.RandomNumberLottoGenerator;
import view.RequestUser;
import camp.nextstep.edu.missionutils.Console;
import view.SystemMessage;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class LottoService {

    UserMoneyValidate userMoneyValidate = new UserMoneyValidate();
    SystemMessage systemMessage = new SystemMessage();

    public void set_lotto(){
        int userMoney = getUserMoney();
        Ticket ticket = new Ticket();
        int ticketNum = ticket.getTicketNum(userMoney);
        getAllLotto(ticketNum);
    }

    private int getUserMoney() throws IllegalArgumentException{
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
}
