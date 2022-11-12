## 구현 기능 목록
- 로또 구입 금액을 입력하기
- 구입 금액에 해당하는 로또를 발행하기
- 당첨 번호 입력받기
- 보너스 번호 입력받기
- 사용자가 구매한 로또 번호와 당첨 번호를 비교하기
- 당첨 내역 계산 및 출력하기
- 수익률 계산 및 출력하기
- 로또 게임 종료하기
- 예외 상황 시 IllegalArgumentException 발생 및 에러 문구 출력

##기능 명세
- --

### **Setting 클래스**
- #### **환경 세팅**
    - ```LOTTO_MIN_NUMBER``` : 로또 숫자 범위 최소
    - ```LOTTO_MAX_NUMBER``` : 로또 숫자 범위 최대
    - ```LOTTO_PRICE_PER_ONE``` : 로또 한장 당 가격
  
### **WinningEnum 클래스**
- #### **로또 당첨 세팅**
    - ```FIRST``` ```SECOND``` ```THIRD``` ```FOURTH``` ```FIFTH```
    - 등수, 일치하는 번호 개수, 보너스볼 일치 여부, 당첨금

### **Money 클래스**
- #### **로또 구입 금액**
    - ```inputMoney``` : 로또 구입할 금액 입력
    - ```validate``` : 입력한 금액 검증 및 예외처리
      - ```validateInputMoneyIsAllNumber``` : 2의 63승 이하 숫자인지 검증
      - ```validateInputMoneyIsRightUnit``` : 단위에 맞게 입력했는지 검증
    - ```boughtLottoCount``` : 구매한 로또 개수 반환

### **Output 클래스**
- #### **출력 기능**
    - ```printInputMoney``` : 구입 금액 입력 멘트 출력
    - ```printBoughtLotto``` : 로또 구매 개수 멘트 출력
    - ```printInputWinningNumber``` : 당첨 번호 입력 멘트 출력
    - ```printBonusNumber``` : 보너스 번호 입력 멘트 출력
    - ```printExceptionError``` : 예외 사항 멘트 출력
    - ```printWinningStatistics``` : 당첨 통계 멘트 출력

