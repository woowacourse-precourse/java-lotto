package lotto.lotterymachine.controller;

import java.util.EnumMap;
import java.util.Map;
import lotto.lotterymachine.domain.LotteryMachine;
import lotto.lotterymachine.repository.LotteryMachineRepository;
import lotto.lotterymachine.service.LotteryMachineService;
import lotto.user.domain.User;
import lotto.user.repository.UserRepository;
import lotto.util.Score;
import lotto.view.InputView;
import lotto.view.OutPutView;

public class LotteryMachineController {
    private final LotteryMachineRepository lotteryMachineRepository;
    private final User user;
    private final LotteryMachine lotteryMachine;
    private final LotteryMachineService lotteryMachineService;
    private final InputView inputView;
    private final OutPutView outPutView;
    public Map<Score, Integer> ScoreBoard;


    public LotteryMachineController() {
        this.lotteryMachine = new LotteryMachine();
        this.lotteryMachineRepository = new LotteryMachineRepository();
        this.lotteryMachineService = new LotteryMachineService();
        this.user = new User();
        this.ScoreBoard = new EnumMap<>(Score.class);
        this.inputView = new InputView();
        this.outPutView = new OutPutView();
    }

    public boolean startGame() {
        inputView.printIntro();
        if(initUser() == 0) return false;
        if(!initLotteryMachine()) return false;
        getLotteryResult();
        getStaticsResult();
        return true;
    }
    private void getLotteryResult(){
        ScoreBoard = lotteryMachineService.checkNumbers(user,lotteryMachine);
        outPutView.printUserScoreResultIntro();
        outPutView.printUserScoreResult(ScoreBoard);
    }
    private void getStaticsResult(){
        float incomeRatio = lotteryMachineService.getIncome(user.getInputMoney());
        outPutView.printUserIncomePercentage(incomeRatio);
        outPutView.printSpace();
    }
    public int initUser() {
        int userInput = UserRepository.inputMoney();
        if(userInput == 0 ) {
            return 0;
        }
        user.setInputMoney(userInput);
        UserRepository.buyLotteryTickets(user);
        UserRepository.setUserTicketsToLottery(user, user.getTicketAmount());
        outPutView.printUserLottos(user.getLottos());
        return userInput;
    }

    public boolean initLotteryMachine() {
        inputView.printInputTargetMessageGide();
        if(!lotteryMachineRepository.setTargetNumbers(lotteryMachine))
            return false;


        //inputView.printInputTargetNumbers(lotteryMachine.getTargetNumbers());
        inputView.printInputBonusMessageGide();

        if(!lotteryMachineRepository.setTargetBonusNumber(lotteryMachine))
            return false;

        //System.out.println(lotteryMachine.getTargetBonusNumber());
        return true;//ok
    }

}
