# 기능 목록
- [ ] Lotto의 UI구현 => Application
    - [x] 구입금액 입력 후 로또구매 후 구입한 로또 리스트 출력
    - [x] 당첨번호 입력, 보너스번호 입력
    - [ ] 당첨에 대한 통계를 보여줌
    - [x] 잘못된 값을 입력할 경우 "[ERROR]" 로 시작하는 메세지 출력 후 종료
      - [x] 구입금액 확인
        - [x] 구입금액 입력 시 정수를 입력하지 않았을 경우
          - IllegalArgumentException, message="[ERROR] 구입금액은 정수여야 합니다"
        - [x] 구입금액 입력 시 1000으로 나누어 떨어지는 0이상의 정수를 입력하지 않았을 경우
          - IllegalArgumentException, message="[ERROR] ~"
          - 클래스 LottoUser에서 검증, LottoUser 설명 참고
      - [x] 당첨번호 확인
        - [x] 당첨번호 입력 시 정수가 아닌 경우
          - IllegalArgumentException, message="[ERROR] 당첨번호는 정수여야 합니다."
        - [x] 당첨번호 설정 시에 개수,범위,중복 확인
          - IllegalArgumentException, "[ERROR] ~"
          - 클래스 LottoSystem에서 검증, LottoSystem 설명 참고
      - [x] 보너스번호 확인       
        - [x] 보너스번호 입력 시 정수가 아닌 경우
          - IllegalArgumentException, message="[ERROR] 보너스번호는 정수여야 합니다."
        - [x] 보너스번호 설정 시에 범위 확인
          - IllegalArgumentException, message="[ERROR] ~"
          - 클래스 LottoSystem에서 검증, LottoSystem 설명 참고


- [x] 로또의 당첨번호,보너스번호를 가지고 당첨여부를 알려주는 클래스 => LottoSystem
    - [x] validation 추가
      - [x] 당첨 번호 설정 시에 개수,범위,중복 확인
        - IllegalArgumentException
        - 클래스 Lotto에서 검증, Lotto설명 참고
      - [x] 보너스번호 범위가 1~45사이인지
        - IllegalArgumentException, message="[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다."
    - [x] 당첨번호, 보너스번호 설정
    - [x] 입력받은 로또와 비교 후 WinInfo 반환
    - [x] 당첨번호 일치 개수 판단:
    - [x] 보너스 번호 일치 개수 판단

- [x] 당첨조건, 당첨금액의 정보를 가진 Enum => WinInfo 
  - [x] 당첨조건, 당첨금액, 순위 설정
  - [x] 당첨조건에 맞는지 검사
  - [x] 당첨조건에 맞는 WinInfo 반환
  - [x] 순위에 맞는 WinInfo 반환
  - [x] 당첨 금액 반환 가능
  - [x] WinInfo 리스트에 대한 당첨 통계 반환

- [x] 소유한 로또와 얻은 총 수익 정보를 담는 사용자 클래스 => LottoUser
    - [x] validation 추가
        - [x] 음수인 경우
            - IllegalArgumentException, message="[ERROR] 로또 구입 금액은 1000원 단위로 나누어 떨어져야 합니다."
        - [x] 1000으로 나누어 떨어지지 않는 경우
            - IllegalArgumentException, message="[ERROR] 로또 구입 금액은 0이상이여야 합니다"
    - [x] 로또를 구매할 돈의 양 설정
    - [x] 가진 돈의 양 만큼 로또를 구매
    - [x] 수익률 계산
    - [x] 로또 결과 반환
    - [x] 소유한 로또 반환
    - [x] 소유한 로또의 당첨 통계 반환

- [x] 로또의 번호정보를 담는 클래스 => Lotto
    - [x] 로또가격 정보를 상수로 구현
    - [x] validation 추가
      - [x] 로또 번호 개수가 적거나 많을 때
        - IllegalArgumentException, message="[ERROR] 로또 번호가 너무 많거나 적습니다."
      - [x] 범위를 벗어난 번호가 존재
        - IllegalArgumentException, message="[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."
      - [x] 중복된 숫자가 존재
        - IllegalArgumentException, message="[ERROR] 로또 번호에 중복된 숫자가 있으면 안됩니다."
    - [x] getter 추가
    

# 테스트
- [x] LottoSystem 테스트
  - [x] validation 테스트
  - [x] 당첨정보 반환 테스트

- [x] WinInfo 테스트
  - [x] match함수 테스트
    - (당첨 번호 일치 개수, 보너스번호 일치 여부)와 WinInfo의 조건이 동등한지 판단
  - [x] get함수 테스트
    - 당첨 번호 일치 개수, 보너스번호 일치 여부가 주어지면 알맞은 WinInfo를 반환하는지
  - [x] getByOrder 테스트
    - 순위에 맞는 WinInfo를 잘 반환하는지
  - [x] getStatistics 테스트
    - 주어진 WinInfo의 통계를 잘 반환하는지

- [x] LottoUser 테스트
  - [x] validation 테스트
  - [x] buyLotto 테스트
    - 돈의 양 만큼 로또를 샀는지, Lotto의 검증 형식에 맞춰서 번호를 생성했는지
  - [x] checkWin 테스트
    - 주어진 로또에 대해 알맞은 WinInfo를 가지게 되었는지, LottoSystem테스트의 테스트케이스 재활용
  - [x] getReturnRate 테스트
    - 주어진 WinInfo에 대해 수익률을 잘 계산하는지
  - [x] getStatistics 테스트
    - 자신의 로또의 당첨 통계를 잘 반환하는지

- [x] Lotto 테스트
  - [x] validation 테스트   