## Lotto class
  - 생성자 
    - validate, checkRangeOfNumbers, checkDuplicatedNumber 메소드를 차례로 호출한다.
    - parameters인 numbers를 로컬 변수인 numbers에 저장한다.
  - validate 메소드
    - numbers의 길이가 6이 아니면 `IllegalArgumentException`를 발생시킨다.
  - checkRangeOfNumbers 메소드
    - numbers의 각 값이 1에서 45 사이의 값이 아니면 `IllegalArgumentException`를 발생시킨다.
  - checkDuplicatedNumber 메소드
    - numbers에 중복된 값이 있는지 확인한다.
    - 이때 numbers는 오름차순으로 정렬되어 있으므로 인접한 값만 확인하면 된다.
    - 이 과정에서 중복된 값이 발견되면 `IllegalArgumentException`를 발생시킨다.
  - checkBonusExists 메소드
    - 보너스 숫자가 members 변수에 이미 존재하면 `IllegalArgumentException`를 발생시킨다.
  - printLotto() 메소드
    - 로또 번호를 출력한다.
  - getNumbers() 메소드
    - 로또 번호를 반환한다.
---
## Features

- 로또 구입 금액을 입력 받는다.
  - inputMoney 메소드
      - 문자열을 입력을 받고 checkInput 메소드를 호출하여 올바른 입력인지 확인한다.
      - checkInput 메소드가 실행된 후 반환된 money 를 반환한다.
      - 이 과정에서 예외가 발생하면 `IllegalArgumentException`과 함께 에러메시지를 출력한다.
  - checkInput 메소드
      - 입력받은 문자열을 정수로 변환한다.
      - 변환된 정수가 1000으로 나누어 떨어지는지 확인한다.

- 당첨 번호를 입력받는다. 번호는 쉼표(,)를 기준으로 구분한다.
  - inputLottoNumber 메소드
    - 문자열을 입력받는다.
    - 입력받은 문자열을 쉼표(,) 기준으로 구분한 문자열배열로 저장한 뒤, `createLotto`메소드를 호출하여 로또를 생성한다.
    - 예외가 발생할 시 `IllegalArgumentException`과 함께 에러메시지를 출력한다.
  - createLotto 메소드
    - `inputLottonumber`메소드에서 생성된 문자열배열에서 순서대로 정수로 변환하여 lottoList에 저장한다.
    - lottoList를 오름차순으로 정렬시킨 뒤 Lotto객체를 생성하여 반환한다.
    - 이 과정에서 예외가 발생할 시 `IllegalArgumentException`를 발생시킨다.

- 보너스 번호를 입력 받는다.
  - inputBonusNumber 메소드
    - 문자열을 입력받는다.
    - 입력된 값을 정수로 변환한다.
    - `checkBonusNumber`메소드를 호출하여 입력된 정수가 적합한지 확인한다.
    - 예외가 발생할 시 `IllegalArgumentException`과 함께 에러메시지를 출력한다.

- 발행한 로또 수량 및 번호를 출력한다.
  - issueLotto 메소드
    - 사용자가 입력한 로또 구입 금액만큼 로또를 발행한다.
    - `createNewLotto` 메소드를 호출하여 로또 구입 금액만큼의 중복되지 않는 6개의 숫자를 가진 로또를 발행한다.
  - createNewLotto
    - 로또 구입 금액 만큼의 중복되지 않는 6개의 숫자를 가진 로또를 발행한다.

- 당첨 내역을 출력한다.
  - printWinnings 메소드
    - `checkWinnings`를 호출하여 당첨 정보를 담은 리스트를 저장한다.
    - 당첨 정보를 담은 리스트를 출력한다.
  - checkWinnings 메소드
    - 발행된 로또리스트에서 발행 정보를 확인한다.
    - `computeWinningIndex` 메소드를 호출하여 등수를 계산한다.
    - 5등부터 내림차순으로 당첨정보를 담은 winningInfo 를 반환한다.
  - computeWinningIndex 메소드
    - 발행된 로또가 몇개가 맞는지, 보너스도 맞췄는지 확인한다.
    - `generateWinningCount` 메소드를 호출하여 해당 인덱스가 몇번인지 반환한다.
  - generateWinningCount 메소드
    - 번호를 맞춘 개수와 보너스 여부에 따라 인덱스를 반환한다.
  - printYield 메소드
    - 최종적으로 수익률을 출력한다.
---
