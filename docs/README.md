# 구현할 기능 목록

## 로또 게임
### 입력
- +[x] 로또 구입 금액을 입력받는 기능  
- +[x] 당첨번호를 입력받는 기능  
  - +[x] 입력된 당첨번호들을 파싱하는 기능  
- +[x] 보너스 번호를 입력받는 기능  
### 입력시 예외처리
- +[x] 금액 입력 시 예외처리  
  - +[x] 숫자가 아닐 경우 예외처리 - ValidationInController.checkNumericValue()  
  - +[x] 입력받은 숫자가 1000원 단위가 아닐 경우 예외처리 - ValidationInDomain.checkDividedByThousand()  
- +[x] 당첨번호/보너스번호 입력시 예외처리  
  - +[x] 숫자가 아닌 문자를 입력한 경우 예외처리 - ValidationInController.checkNumericValue(), ValidationInController.checkNumericValueList()  
  - +[x] 1~45가 아닌 번호를 입력한 경우 예외처리 - ValidationInDomain.checkNumberRange()  
  - +[x] 6개의 수 중 중복인 수가 있을 경우 예외처리 - ValidationInDomain.checkDuplicatedNumber()  
  - +[x] 보너스번호가 당첨번호와 중복될 경우 예외처리 - ValidationInDomain.checkBonusNumberDuplication()   
  - +[x] 입력받은 당첨번호가 6개가 아닐 경우 예외처리 - Lotto.validate()  

### 출력
- +[x] 구입 금액 입력 문구를 출력하는 기능  
- +[x] 당첨 번호 입력 문구를 출력하는 기능  
- +[x] 보너스 번호 입력 문구를 출력하는 기능  
- +[x] 발행한 로또 수량 및 번호를 출력하는 기능
- +[x] 당첨 내역을 출력하는 기능  
- +[x] 수익률을 출력하는 기능  

### 로또 발행 및 당첨여부 조사
- +[x] 구매금액에서 발행할 로또 개수를 계산하는 기능  
- +[x] 중복되지 않는 6개의 로또번호를 생성하는 기능  
- +[x] 로또 번호를 오름차순으로 정렬하는 기능  
- +[x] 당첨번호/보너스번호와 일치하는 번호 개수를 조사하는 기능  
- +[x] 각 당첨 등수별 개수를 계산하는 기능
- +[x] 당첨 금액을 계산하는 기능  
- +[x] 수익률을 계산하는 기능  
