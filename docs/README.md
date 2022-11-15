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
    - ```LOTTO_PICK_NUMBER``` : 뽑는 로또 개수
    - ```LOTTO_PRICE_PER_ONE``` : 로또 한장 당 가격
  
### **WinningEnum 클래스**
- #### **로또 당첨 세팅**
    - ```FIRST``` ```SECOND``` ```THIRD``` ```FOURTH``` ```FIFTH```
    - 등수, 일치하는 번호 개수, 보너스볼 일치 여부, 당첨금
    - ```getWinning``` : 당첨 개수, 보너스볼 당첨 여부를 확인해 WinningEnum을 반환

### **Game 클래스(객체)**
- #### **로또 게임 시작**
    - ```start``` : 게임 시작
    - ```inputMoney``` : 돈 객체 생성
    - ```myLotto``` : 로또 객체 리스트로 생성
    - ```inputWinningLotto``` : 당첨 객체 생성
    - ```winningLottoNumbers``` : 당첨 객체 멤버변수인 LottoNumbers 입력
    - ```winningBonusNumber``` : 당첨 객체 몀버변수인 BonusNumber 입력 

### **Money 클래스(객체)**
- #### **로또 구입 금액**
    - ```getMoney``` : 입력한 돈 가져오기
    - ```boughtLottoCount``` : 구매한 로또 개수 반환

### **ValidateMoney 메서드 클래스**
- #### **로또 구입 금액 입력값 확인**
    - ```validate``` : 입력한 금액 검증 및 예외처리
      - ```validateInputMoneyIsAllNumber``` : 2의 63승 이하 숫자인지 검증
      - ```validateInputMoneyIsRightUnit``` : 단위에 맞게 입력했는지 검증
    - ```validatedMoneyToLong``` : 문자열 형태인 입력한 금액을 Long형으로 반환

### **Lotto 클래스(객체)**
- #### **구입한 로또**
    - ```getRank``` : 로또 당첨 등수 반환
    - ```countCorrectNumbers``` : 맞춘 로또 번호 개수 반환
    - ```isCorrectBonusNumber``` : 보너스 번호를 맞췄는지 확인
    - ```validate``` : 구입한 로또 입력값 검증
      - ```validateInputLottoNumberIsTotal``` : N개의 로또 번호 입력했는지 검증
      - ```validateInputNumberIsBetween``` : 올바른 로또 번호 사이의 값을 입력했는지 검증
      - ```validateInputNumberHaveSame``` : 중복된 숫자를 입력했는지 검증

### **WinningLotto 클래스(객체)**
- #### **로또 번호와 보너스 번호**
    - ```checkWinning``` : 당첨 등수 반환
    - ```statistics``` : 통계 확인
    - ```total``` : 수익률 확인

### **ValidateWinningLotto 메서드 클래스**
- #### **로또 번호와 보너스 번호 입력값 확인**
    - ```validateInputLottoNumber``` : 입력한 당첨 번호 검증 및 예외처리
    - ```validateBonusNumberIsRightNumber``` : 입력한 보너스 번호 검증 및 예외처리
      - ```validateInputLottoNumberIsTotal``` : N개의 로또 번호 입력했는지 검증
      - ```validateInputLottoNumberIsRightSeparator``` : 쉼표를 기준으로 숫자를 입력했는지 검증 
      - ```validateInputLottoNumberIsBetween``` : 로또 추첨 번호 사이의 숫자를 입력했는지 검증
      - ```validateInputNumberHaveSame``` : 중복된 숫자를 입력했는지 검증

### **Output 클래스**
- #### **출력 기능**
  - ```printInputMoney``` : 구입 금액 입력 멘트 출력
  - ```printBoughtLotto``` : 로또 구매 개수 멘트 출력
  - ```printBoughtLottoNumbers``` : 자동 구매된 로또 번호 출력
  - ```printInputWinningNumber``` : 당첨 번호 입력 멘트 출력
  - ```printBonusNumber``` : 보너스 번호 입력 멘트 출력
  - ```printWinningStatistics``` : 당첨 통계 멘트 출력
  - ```printYield``` : 총 수익률 멘트 출력
  - 
### **Exception 클래스**
- #### **IllegalArgumentException 상속**
    - 에러 출력 시, "[ERROR]" 접두사로 설정
    
