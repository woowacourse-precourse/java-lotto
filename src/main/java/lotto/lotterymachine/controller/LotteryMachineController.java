package lotto.lotterymachine.controller;

import lotto.lotterymachine.domain.LotteryMachine;
import lotto.lotterymachine.repository.LotteryMachineRepository;
import lotto.lotterymachine.service.LotteryMachineService;
import lotto.user.domain.User;
import lotto.user.repository.UserRepository;

public class LotteryMachineController {
    private final LotteryMachineRepository lotteryMachineRepository;
    private final User user;
    private final LotteryMachine lotteryMachine;
    private final LotteryMachineService lotteryMachineService;

    public LotteryMachineController() {
        this.lotteryMachine = new LotteryMachine();
        this.lotteryMachineRepository = new LotteryMachineRepository();
        this.lotteryMachineService = new LotteryMachineService();
        this.user = new User();
    }

    public boolean startGame() {
        System.out.println("구입금액을 입력해 주세요.");
        if(initUser() == 0) return false;
        if(!initLotteryMachine()) return false;
        lotteryMachineService.matchNumber(user,lotteryMachine);
        return true;
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
