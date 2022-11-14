package lotto.controller;

import java.util.HashMap;
import lotto.data.dto.BonusNumberDto;
import lotto.data.dto.LottoBundleDto;
import lotto.data.dto.LottoQueryDto;
import lotto.data.dto.WinNumberDto;
import lotto.service.AdminService;
import lotto.type.LottoResultType;
import lotto.type.MessageType;
import lotto.type.StepType;
import lotto.service.UserService;
import lotto.service.AccountService;
import lotto.view.LottoBundleView;
import lotto.view.LottoResultView;
import utils.InputReader;
import utils.Logger;

public class LottoController {

    private StepType currentStep;
    private final AccountService accountService;
    private final UserService userService;
    private final AdminService adminService;
    private final LottoBundleView lottoBundleView;
    private final LottoResultView lottoResultView;
    private final HashMap<StepType, Runnable> stepMapper;
    private Long userId;
    private Long roundId;
    private LottoController() {
        currentStep = StepType.INIT;
        accountService = new AccountService();
        userService = new UserService();
        adminService = new AdminService();
        lottoBundleView = new LottoBundleView();
        lottoResultView = new LottoResultView();
        stepMapper = mapStepTypes();
    }

    private HashMap<StepType, Runnable> mapStepTypes() {
        HashMap<StepType, Runnable> stepMapper = new HashMap<>();
        stepMapper.put(StepType.INIT, this::init);
        stepMapper.put(StepType.BUY_LOTTO, this::buyLotto);
        stepMapper.put(StepType.DECIDE_WINNER, this::decideWinner);
        stepMapper.put(StepType.DECIDE_BONUS, this::decideBonus);
        stepMapper.put(StepType.GIVE_RESULT, this::giveResult);
        return stepMapper;
    }

    private void init() {
        userId = accountService.getNewId();
        currentStep = currentStep.getNextStep();
    }

    private void buyLotto() {
        Logger.log(MessageType.BUY.getMessage());
        LottoBundleDto lottoBundleDto = LottoBundleDto.createWithInput(InputReader.readLine());
        lottoBundleDto.setOwnerId(userId);
        userService.purchaseLottoBundle(lottoBundleDto);
        roundId = lottoBundleDto.getRoundId();
        Logger.log(lottoBundleView.stringify(lottoBundleDto));
        currentStep = currentStep.getNextStep();
    }

    private void decideWinner() {
        Logger.log(MessageType.WIN.getMessage());
        WinNumberDto winNumberDto = WinNumberDto.createWithInput(InputReader.readLine());
        adminService.setWinNumber(winNumberDto);
        currentStep = currentStep.getNextStep();
    }

    private void decideBonus() {
        Logger.log(MessageType.BONUS.getMessage());
        BonusNumberDto bonusNumberDto = BonusNumberDto.createWithInput(InputReader.readLine());
        adminService.setBonusNumber(bonusNumberDto);
        currentStep = currentStep.getNextStep();
    }

    private void giveResult() {
        adminService.finishRound();
        LottoQueryDto lottoQueryDto = LottoQueryDto.builder()
                .userId(userId)
                .roundId(roundId)
                .build();
        HashMap<LottoResultType, Integer> myResult = userService.getMyResult(lottoQueryDto);
        Logger.log(lottoResultView.stringify(myResult));
        currentStep = currentStep.getNextStep();
    }

    public static void run() {
        LottoController lottoController = new LottoController();
        try {
            lottoController.manipulate();
        } catch (Exception exception) {
            Logger.log(exception.getMessage());
        }
    }

    private void manipulate() {
        while(currentStep != StepType.FINISH) {
            stepMapper.get(currentStep).run();
        }
    }
}
