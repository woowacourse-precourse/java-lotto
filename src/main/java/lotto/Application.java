package lotto;

import java.util.List;

public class Application {

    private static final String ERROR_MESSAGE = "[ERROR]";

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        runProcess();
    }

    static void messageProcess_1(){
        try {
            Process.purchaseMessage();
        }catch (Exception e){
            System.out.println(ERROR_MESSAGE+e.getMessage());
        }
    }
    static void messageProcess_2(){
        try {
            Process.lottoCountMessage();
        }catch (Exception e){
            System.out.println(ERROR_MESSAGE+e.getMessage());
        }
    }

    static void messageProcess_3(){
        try {
            Process.purchaseNumberMessage();
        }catch (Exception e){
            System.out.println(ERROR_MESSAGE+e.getMessage());
        }
    }
    static void messageProcess_4(){
        try {
            Process.bonusNumberMessage();
        }catch (Exception e){
            System.out.println(ERROR_MESSAGE+e.getMessage());
        }
    }

    static void setRankingProcess(List<List<Integer>> lottoes){
        Process.initialRanking();
        Process.settingRank(lottoes);
        Process.resultMessage();
    }

    static void runProcess(){
        messageProcess_1();
        messageProcess_2();
        List<List<Integer>> lottes = Process.outputLotto();
        Process.printBuyLotto(lottes);
        messageProcess_3();
        messageProcess_4();
        setRankingProcess(lottes);
    }
}
