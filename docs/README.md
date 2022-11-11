## 🚀 기능 목록 구현 

- [X] 로또 구입 금액 입력 - inputMoney()
    - [X] (예외)입력값이 올바른지 확인, 출력(금액이 나눠떨어지는지, 입력에 문자가 오지 않았는지 - validateMoney()
    - [X] (예외) 예외일 경우 출력 - ExceptionInfo, ErrorMessage(Enum사용), ExceptionNumber(Enum사용)
- [X] 구입 금액만큼 로또 번호 리스트를 생성하고 출력한다. - putLottoNumberList()
    - [X] 로또 번호는 오름차순 출력 - setLottoNumberList()
    - [X] 출력은 담당 출력클래스에서 출력 - view PrintLotto()
- [X] 당첨 번호 입력(쉼표로 구분) - inputLottoNumber()
    - [X] (예외) 사용자 입력시 숫자와 쉼표가 아닌 이상한 값이 들어간 경우 - validateNotNumber
    - [X] (예외)입력시 범위에 맞는지 확인(1<=  n <= 45) - isOverRange
    - [X] (예외)입력시 입력된 숫자가 6개인지 - isOuntIndex
    - [X] (예외)입력시 중복되 숫자가 있는지 - isDuplicated
    
- [X] 보너스 번호 입력 - inputBonusNumber()
  - [X] (예외) 숫자가 아닌거 입력할 때
  - [X] (예외) 숫자 범위가 넘어갈때
  - [X] (예외) 기존에 있던 당첨번호에 추가 되면 안됨

- [X] 당첨번호와 각 로또 번호 리스트 당 같은 번호 몇개씩인지 확인 및 저장 - Game
    - [X] 로또 3개,4개,5개,5개 + 보너스, 6개 같은지 확인, 및 matching - matchCount
    - [X] 같은 것이 들어있는지에 대한 Count를 matchCountList 에 저장 - matchCountList
      - [X] 이 중 5개 + 보너스가 같은 것은 count를 7로 지정하여 별도로 판별
    - [X] 총 당첨금액을 계산하기 위한 작업
        - [X] 맞춘 갯수당 해당하는 금액을 곱하고 총합한 금액을 계산 
- [X] 수익률 계산
    - [X] 수익률에 대해 계산하는 작업 총 금액 / 구입한 금액 * 100
    
- [ ] 당첨통계와 함께 출력
    - [ ] 당첨통계할때 ENUM을 활용 하여 출력
    - [ ] 수익률 소수 2번째자리에서 반올림






