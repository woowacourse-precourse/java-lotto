package lotto.lotterymachine.controller;

import lotto.lotterymachine.domain.LotteryMachine;
import lotto.lotterymachine.repository.LotteryMachineRepository;
import lotto.user.domain.User;
import lotto.user.repository.UserRepository;

public class LotteryMachineController {
    private final LotteryMachineRepository lotteryMachineRepository;
    private final User user;
    private final LotteryMachine lotteryMachine;

    public LotteryMachineController() {
        this.lotteryMachine = new LotteryMachine();
        this.lotteryMachineRepository = new LotteryMachineRepository();
        this.user = new User();
    }

    public void startGame() {
        User user = initUser();
        System.out.println(user.getLottos()); //  need view
        LotteryMachine lotteryMachine = initLotteryMachine();
    }

    public User initUser() {
        System.out.println("구입금액을 입력해 주세요.");
        user.setInputMoney(UserRepository.inputMoney());
        UserRepository.buyLotteryTickets(user);
        UserRepository.setUserTicketsToLottery(user, user.getTicketAmount());
        return user;
    }

    public LotteryMachine initLotteryMachine() {
        lotteryMachineRepository.setTargetNumbers(lotteryMachine);
        System.out.println(lotteryMachine.getTargetNumbers());
        lotteryMachineRepository.setTargetBonusNumber(lotteryMachine);
        System.out.println(lotteryMachine.getTargetBonusNumber());
        return lotteryMachine;
    }

}
