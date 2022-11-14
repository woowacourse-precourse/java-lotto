package lotto.lotterymachine.controller;

import java.util.EnumMap;
import java.util.Map;
import lotto.lotterymachine.domain.LotteryMachine;
import lotto.lotterymachine.repository.LotteryMachineRepository;
import lotto.lotterymachine.service.LotteryMachineService;
import lotto.user.domain.User;
import lotto.user.repository.UserRepository;
import lotto.util.Score;

public class LotteryMachineController {
    private final LotteryMachineRepository lotteryMachineRepository;
    private final User user;
    private final LotteryMachine lotteryMachine;
    private final LotteryMachineService lotteryMachineService;
    public Map<Score, Integer> ScoreBoard;

    public LotteryMachineController() {
        this.lotteryMachine = new LotteryMachine();
        this.lotteryMachineRepository = new LotteryMachineRepository();
        this.lotteryMachineService = new LotteryMachineService();
        this.user = new User();
        this.ScoreBoard = new EnumMap<>(Score.class);
    }

    public boolean startGame() {
        System.out.println("구입금액을 입력해 주세요.");
        if(initUser() == 0) return false;
        if(!initLotteryMachine()) return false;
        checkNumbers();
        getStaticsResult();
        return true;
    }
    private void checkNumbers(){
        ScoreBoard = lotteryMachineService.checkNumbers(user,lotteryMachine);
        // 결과판 출력
        System.out.println(ScoreBoard);
    }
    private void getStaticsResult(){
        // 수익률 출력
        float incomeRatio = lotteryMachineService.getIncome(user.getInputMoney());
        System.out.println("수익률:");
        System.out.println(String.format("%.1f%%",incomeRatio));
    }
    public int initUser() {
        int userInput = UserRepository.inputMoney();
        if(userInput == 0 ) {
            return 0;
        }
        user.setInputMoney(userInput);
        UserRepository.buyLotteryTickets(user);
        UserRepository.setUserTicketsToLottery(user, user.getTicketAmount());
        System.out.println(user.getLottos());
        return userInput;
    }

    public boolean initLotteryMachine() {
        if(!lotteryMachineRepository.setTargetNumbers(lotteryMachine))
            return false;
        System.out.println(lotteryMachine.getTargetNumbers());
        if(!lotteryMachineRepository.setTargetBonusNumber(lotteryMachine))
            return false;
        System.out.println(lotteryMachine.getTargetBonusNumber());
        return true;//ok
    }

}
