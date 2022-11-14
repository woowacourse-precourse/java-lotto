package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.GameSet;
import lotto.service.LottoProperties;
import lotto.service.LottoService;
import lotto.service.LottoServiceImpl;
import lotto.utils.GenerateLottoNumbers;
import lotto.domain.Lotto;

import java.util.ArrayList;
import java.util.List;

import static lotto.utils.GetInput.getInput;
public class LottoController {
    private static final String message = "[ERROR] 입력";
    private GenerateLottoNumbers generateLottoNumbers = new GenerateLottoNumbers();
    private LottoService lottoService = new LottoServiceImpl();
    private final int SECOND_WINNER_COUNT = 7;
    private List<Lotto> generatedLotto = new ArrayList<>();
    private static int lottoCount;
    private GameSet gameSet;
    public void run(){
        init();
        generateLotto();
        generateAwardLotto();
        lottoService.play(generatedLotto,gameSet);
        printResult();
    }
    private void init() {
        System.out.println("구입금액을 입력해 주세요.");
        try{
            lottoCount=Integer.parseInt(Console.readLine());
        }catch (NumberFormatException n){
            System.out.println(message);
            //throw new IllegalArgumentException();
            lottoCount = 1000;
        }

        if(lottoCount%1000!=0){
            System.out.println(message);
            lottoCount=1000;
            //throw new IllegalArgumentException();
        }
        lottoCount/=1000;
        System.out.println(lottoCount+"개를 구매했습니다.");
    }
    private void generateLotto(){
        for(int i =0;i<lottoCount;i++) {
            generatedLotto.add(new Lotto(generateLottoNumbers.generateLottoNumber()));
            System.out.println(generatedLotto.get(i).getNumbers());
        }
    }
    private void generateAwardLotto(){
        System.out.println("당첨 번호를 입력해 주세요.");
        gameSet = new GameSet(new Lotto(getInput()),lottoCount);
        System.out.println("보너스 번호를 입력해 주세요.");
        gameSet.setBonusNumber(getInput());
    }
    private void printResult(){
        System.out.println("당첨 통계");
        System.out.println("---");
        int cnt = 0;
        int[] gameCount = gameSet.getGameCount();
        for(LottoProperties name:LottoProperties.values()){
            if (name.getOperator()==-1){
                break;
            }
            if (name.getOperator()==SECOND_WINNER_COUNT){
                System.out.println(name.getOperator()-2+"개 일치, 보너스 볼 일치 ("+name.getSprice()+") - "+gameCount[cnt++]+"개");
                continue;
            }
            System.out.println(name.getOperator()+"개 일치 ("+name.getSprice()+") - "+gameCount[cnt++]+"개");
        }
        double result = 0;
        if (gameSet.getTotalPrize()!=0) {
            result =  (double)gameSet.getTotalPrize()/((double)gameSet.getLottoCount()*1000);
        }
//        result = Math.round(result)/10;
        System.out.println("총 수익률은 "+ result*100+"%입니다.");
    }
}
