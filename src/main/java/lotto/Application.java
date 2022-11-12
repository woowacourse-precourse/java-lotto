package lotto;

import lotto.Lotto.Lotto;
import lotto.Lotto.LottoInfo;
import lotto.Lotto.WinningLotto;
import lotto.input.ConsoleInputManager;
import lotto.input.InputManager;
import lotto.output.ConsoleOutputManager;
import lotto.output.OutputManager;

import java.util.*;

public class Application {
    private EarningRateCalculator calculator;
    private LottoComparator lottoComparator;
    private LottoGenerator lottoGenerator;
    private OutputManager consoleOutputManager;
    private InputManager consoleInputManager;

    public Application()
    {
        calculator = EarningRateCalculator.getInstance();
        lottoComparator = LottoComparator.getInstance();
        lottoGenerator = LottoGenerator.getInstance();

        consoleInputManager = ConsoleInputManager.getInstance();
        consoleOutputManager = ConsoleOutputManager.getInstance();
    }

    private List<Lotto> purchaseLotties()
    {
        consoleOutputManager.write(Message.LOTTO_PURCHASE_REQUEST_MESSAGE);
        String userInputForPrice = consoleInputManager.readLine();

        while(true)
        {
            try
            {
                int price = Integer.parseInt(userInputForPrice);
                return lottoGenerator.generateLotties(price);
            }
            catch (NumberFormatException e) {
                consoleOutputManager.write(Message.LOTTO_PURCHASE_RETRY_MESSAGE);
            }
        }
    }

    private WinningLotto inputWinningLotto()
    {
        while(true)
        {
            try
            {
                List<Integer>winningNumbers = inputWinningLottoNumbers();
                consoleOutputManager.write(Message.BONUS_NUMBER_REQUEST_MESSAGE);
                int specialNumber = inputSpecialNumber();
                return new WinningLotto(winningNumbers,specialNumber);
            }
            catch (NumberFormatException e)
            {
                consoleOutputManager.write(Message.WINNING_LOTTO_NUMBERS_INPUT_RETRY_MESSAGE);
            }
        }
    }

    private List<Integer> inputWinningLottoNumbers()
    {
        consoleOutputManager.write(Message.WINNING_LOTTO_NUMBERS_INPUT_REQUEST_MESSAGE);
        String userInputForWinningNumbers = consoleInputManager.readLine();
        List<Integer> winningNumbers = new ArrayList<Integer>();

        for (String userInputForWinningNumber: userInputForWinningNumbers.split(","))
        {
            winningNumbers.add(Integer.parseInt(userInputForWinningNumber));
        }

        return winningNumbers;
    }

    private Integer inputSpecialNumber()
    {
        String userInputForSpecialNumber = consoleInputManager.readLine();
        return Integer.parseInt(userInputForSpecialNumber);
    }

    private List<Prize> getMyLottoPrize(List<Lotto> myLotties, WinningLotto winningLotto)
    {
        List<Prize> lottoPrizes = new ArrayList<>();

        for (Lotto lotto: myLotties)
        {
            Prize prize = lottoComparator.compare(lotto, winningLotto);
            if(prize == null) continue;
            lottoPrizes.add(prize);
        }

        return lottoPrizes;
    }

    private void displayStatisticsPrizes(List<Prize> prizes,int price)
    {
        consoleOutputManager.write(Message.STATISTICS_MESSAGE);
        consoleOutputManager.write(Message.getPrizeInfoMessage(prizes));

        double earnPercentage = calculator.calculate(prizes,price);
        consoleOutputManager.write(Message.getEarningMessage(earnPercentage));

    }

    public void run() {
        consoleOutputManager.write(Message.GAME_START_MESSAGE);
        try
        {
            List<Lotto> lotties = purchaseLotties();
            int price = lotties.size()*LottoInfo.LOTTO_PRICE;
            consoleOutputManager.write(Message.getLottiesNumberInfoMessage(lotties));

            WinningLotto winningLotto = inputWinningLotto();
            List<Prize> myLottoPrizes = getMyLottoPrize(lotties,winningLotto);

            displayStatisticsPrizes(myLottoPrizes,price);
        }
        catch (IllegalArgumentException e)
        {
            consoleOutputManager.write(e.getMessage());
        }
        consoleOutputManager.write(Message.GAME_END_MESSAGE);
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        new Application().run();

    }
}
