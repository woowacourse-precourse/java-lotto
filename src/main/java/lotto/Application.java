package lotto;

public class Application {
    public static ArrayList<List<Integer>> GET_MY_LOTTO_NUMBER(int Number_Of_Lotto){
        ArrayList<List<Integer>> result = new ArrayList<List<Integer>>();

        for (int i = 0; i < Number_Of_Lotto; i++){
            List<Integer> Tmp_Result = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            Collections.sort(Tmp_Result);
            result.add(Tmp_Result);
        }
        return result;
    }
    public static boolean CHECK_PAY_ERROR(String Input){
        boolean result = false;
        if (!Pattern.matches("^[0-9]+", Input)) {
            System.out.println("[ERROR] 구입 금액에 문자가 포함 되어 있습니다..\n");
            return true;
        }
        int Num = Integer.parseInt(Input);
        if(((Num % 1000) != 0) && (Num < 0)){
            System.out.println("[ERROR] 구입 금액이 1000원 단위가 아니거나 음수 값이 입력 되었습니다.\n");
            result = true;
        }
        return result;
    }
    public static int PRINT_REQUEST_PAY() throws IllegalArgumentException{
        System.out.println("구입금액을 입력해 주세요.");
        String result = Console.readLine();
        if(CHECK_PAY_ERROR(result)){
            throw new IllegalArgumentException();
        }
        return Integer.parseInt(result);
    }
    public static ArrayList<List<Integer>> PRINT_MY_LOTTO_NUMBER(int Amount){
        int Number_Of_Lotto = Amount / 1000;
        ArrayList<List<Integer>> My_Lotto_Number = new ArrayList<List<Integer>>();
        System.out.println(String.format("%d개를 구매했습니다.", Number_Of_Lotto));
        My_Lotto_Number = GET_MY_LOTTO_NUMBER(Number_Of_Lotto);
        for(int i = 0; i < Number_Of_Lotto; i++){
            System.out.println(My_Lotto_Number.get(i).toString());
        }
        return My_Lotto_Number;
    }
    public static void main(String[] args) {
        // TODO: 프로그램 구현
            int Amount = PRINT_REQUEST_PAY();
            ArrayList<List<Integer>> My_Lotto_Number = PRINT_MY_LOTTO_NUMBER(Amount);
    }
}
