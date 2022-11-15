package lotto.view;
public class InputPrintView {
    public static void initInput(){
        System.out.println("구입금액을 입력해 주세요.");
    }
    public static void buyView(int lottoCount){
        System.out.println(lottoCount+"개를 구매했습니다.\n");
    }
    public static void inputView_First(){
        System.out.println("당첨 번호를 입력해 주세요.\n");
    }
    public static void inputView_Second() {
        System.out.println("보너스 번호를 입력해 주세요.\n");
    }
}
