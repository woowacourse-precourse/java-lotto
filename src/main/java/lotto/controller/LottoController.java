package lotto.controller;

import java.util.HashMap;
import lotto.data.dto.BonusNumberDto;
import lotto.data.dto.LottoBundleDto;
import lotto.data.dto.LottoBundleResponseDto;
import lotto.data.dto.LottoQueryDto;
import lotto.data.dto.LottoQueryResponseDto;
import lotto.data.dto.WinNumberDto;
import lotto.service.AdminService;
import lotto.type.MessageType;
import lotto.type.StepType;
import lotto.service.UserService;
import lotto.service.AccountService;
import lotto.view.LottoBundleResponseView;
import lotto.view.LottoQueryResponseView;
import utils.InputReader;
import utils.Logger;

public class LottoController {

    private StepType currentStep;
    private final AccountService accountService;
    private final UserService userService;
    private final AdminService adminService;
    private final LottoBundleResponseView lottoBundleResponseView;
    private final LottoQueryResponseView lottoQueryResponseView;
    private final HashMap<StepType, Runnable> stepMapper;
    private long userId;
    private long roundId;

    private LottoController() {
        currentStep = StepType.INIT;
        accountService = new AccountService();
        userService = new UserService();
        adminService = new AdminService();
        lottoBundleResponseView = new LottoBundleResponseView();
        lottoQueryResponseView = new LottoQueryResponseView();
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
        LottoBundleResponseDto lottoBundleResponseDto = userService.purchaseLottoBundle(lottoBundleDto);
        roundId = lottoBundleResponseDto.getRoundId();
        Logger.log(lottoBundleResponseView.stringify(lottoBundleResponseDto));
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
        LottoQueryDto lottoQueryDto = new LottoQueryDto(roundId, userId);
        LottoQueryResponseDto lottoQueryResponseDto = userService.getMyResult(lottoQueryDto);
        Logger.log(lottoQueryResponseView.stringify(lottoQueryResponseDto));
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
