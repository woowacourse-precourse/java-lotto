package data;

public enum PrintData {
    INPUT_MONEY("구입금액을 입력해 주세요."),
    BUY_LOTTO("개를 구매했습니다."),
    INPUT_NUMBER("당첨 번호를 입력해 주세요."),
    INPUT_BONUS("보너스 번호를 입력해 주세요."),
    RESULT("당첨 통계"),
    LINE("---");

    private String printData;

    PrintData(String printData){
        this.printData = printData;
    }

    public static void printData(String label){
        String enumField;
        for(PrintData dataField : PrintData.values()){
            enumField = dataField.toString();
            if(enumField.equals(label)){
                System.out.print(dataField.printData);
            }
        }
    }
}
