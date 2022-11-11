//package lotto;
//
//
//
//public class CompareLotto {
//
//    private static int first, second, third, fourth, fifth;


//    public static void compareLotto() throws IOException {
//        for (int i = 0; i < theNumberOfLotto(); i++) {
//            if(myLottoList.contains(bonusNumberList)){
//                myLottoList.retainAll(winnerNumberList);
//                int checkLotto = myLottoList.size();
//                if(checkLotto == 3){
//                    fifth++;
//                }
//                if(checkLotto == 4){
//                    fourth++;
//                }
//                if(checkLotto == 5){
//                    second++;
//                }
//                if(checkLotto == 6){
//                    first++;
//                }
//            }
//            if(!myLottoList.contains(bonusNumberList)){
//                myLottoList.retainAll(winnerNumberList);
//                int checkLotto = myLottoList.size();
//                if(checkLotto == 3){
//                    fifth++;
//                }
//                if(checkLotto == 4){
//                    fourth++;
//                }
//                if(checkLotto == 5){
//                    third++;
//                }
//                if(checkLotto == 6){
//                    first++;
//                }
//            }
//
//        }
//    }

//    public static void printCompareLotto(){ // 구입한 로또와 1등 로또와 숫자 비교
//        System.out.println("당첨 통계");
//        System.out.println("---");
//        System.out.println("3개 일치 (5,000원) - " + fifth);
//        System.out.println("4개 일치 (50,000원) - " + fourth);
//        System.out.println("5개 일치 (1,500,000원) - " + third);
//        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) -" + second);
//        System.out.println("6개 일치 (2,000,000,000) - " + first);
//    }
//
//    public static void printRateOfReturn(){
//        double getReturn = (fifth * 5000) + (fourth * 50000) + (third * 1500000) + (second * 30000000) + (first * 2000000000);
//        double rateOfReturn = (getReturn / userInputMoney)*100;
//        System.out.println("총 수익률은 " + rateOfReturn + "%입니다.");
//
//    }
//
//    public double rateOfReturn(UserInputMoney, int earnedMoney){ // 소숫점 둘째자리에서 반올림 Math.floor Math.ceil 사용해야하나?
//
//        return inputMoney / earnedMoney;
//    }
//
//}

