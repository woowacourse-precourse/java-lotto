package lotto.controller;

import java.util.HashMap;
import lotto.data.dto.BonusNumberDto;
import lotto.data.dto.LottoBundleDto;
import lotto.data.dto.WinNumberDto;
import lotto.service.AdminService;
import lotto.type.LottoResultType;
import lotto.type.MessageType;
import lotto.type.StepType;
import lotto.service.UserService;
import lotto.service.LogInService;
import lotto.view.LottoBundleView;
import lotto.view.LottoResultView;
import utils.InputReader;
import utils.Logger;

/**
 * 컨트롤러는 DTO를 조작하고, 실행 단계에 따라 필요한 서비스를 불러옵니다.
 */
public class LottoController {

    private StepType currentStep;
    private final LogInService logInService;
    private final UserService userService;
    private final AdminService adminService;
    private final LottoBundleView lottoBundleView;
    private final LottoResultView lottoResultView;
    private final HashMap<StepType, Runnable> stepMapper;
    private Long userId;
    private LottoController() {
        currentStep = StepType.INIT;
        logInService = new LogInService();
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
        userId = logInService.getNewId();
        currentStep = currentStep.getNextStep();
    }

    private void buyLotto() {
        Logger.log(MessageType.BUY.getMessage());
        LottoBundleDto lottoBundleDto = LottoBundleDto.createWithInput(InputReader.readLine());
        lottoBundleDto.setOwnerId(userId);
        userService.purchaseLottoBundle(lottoBundleDto);
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
        adminService.confirmWinNumber();
        HashMap<LottoResultType, Integer> myResult = userService.getMyResult(userId);
        Logger.log(myResult.toString());
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
