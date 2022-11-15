package lotto.controller;

import lotto.Model.*;
import lotto.View.InputView;
import lotto.View.OutputView;

public class LottoController {
        private InputView inputView;
        private OutputView outputView;
        private Purchase purchase;
        private Issue issue;
        private Draw draw;
        private Lotto lotto;
        private Bonus bonus;
        private Yeild yeild;

        public LottoController(){
            this.inputView = new InputView();
            this.outputView = new OutputView();
        }

        public void run(){
            buyLotto();
            if(purchase.getLottoCount() != 0){
                issueLottoes();
                printLottoes();
                drawWinningNumber();
                drawBonusNumber();
                checkDraw();
                printStatistic();
            }
        }

        void buyLotto(){
            purchase = new Purchase(inputView.inputMoney());
        }

        void issueLottoes(){
            issue = new Issue(purchase.getLottoCount());
        }

        void printLottoes(){
            outputView.printLottoCount(purchase.getLottoCount());
            outputView.printLottoList(issue.getLottoes());
        }

        void drawWinningNumber(){
            lotto = new Lotto(inputView.inputDraw());
        }

        void drawBonusNumber(){
            bonus = new Bonus(inputView.inputBonus(), lotto.getLotto());
        }

        void checkDraw(){
            draw = new Draw(lotto.getLotto(), bonus.getBonus(), issue.getLottoes());
        }

        void printStatistic(){
            yeild = new Yeild(purchase.getCost());
            yeild.createStatistic();
            outputView.printStatistic(yeild.getYeild());
        }
}
