# 로또 게임 주요 프로그래밍 요구 사항
- 함수(또는 메서드)의 길이가 15라인을 넘어가지 않도록 구현한다.
    - 함수(또는 메서드)가 한 가지 일만 잘 하도록 구현한다.
- else 예약어를 쓰지 않는다.
    - 힌트: if 조건절에서 값을 return하는 방식으로 구현하면 else를 사용하지 않아도 된다.
    - else를 쓰지 말라고 하니 switch/case로 구현하는 경우가 있는데 switch/case도 허용하지 않는다.
- Java Enum을 적용한다.
- 도메인 로직에 단위 테스트를 구현해야 한다. 단, UI(System.out, System.in, Scanner) 로직은 제외한다.
    - 핵심 로직을 구현하는 코드와 UI를 담당하는 로직을 분리해 구현한다.# 로또 게임 기능 목록

**Lotto class**
- 제공된 Lotto 클래스를 활용해 구현해야 한다.
- Lotto에 매개 변수가 없는 생성자를 추가할 수 없다.
- numbers의 접근 제어자인 private을 변경할 수 없다.
- Lotto에 필드(인스턴스 변수)를 추가할 수 없다.
- Lotto의 패키지 변경은 가능하다.

# 로또 게임 주요 기능 목록 작성
### 🟧 domain package
**Lotto**
>- [x] Lotto 생성자를 통해 로또 당첨 번호를 저장 ( Lotto 생성자 ) (보너스 번호 포함) 
>- [x] 로또 당첨 번호를 조회하는 기능 ( getLottoNumber )
>- [x] 로또 당첨 번호를 검증하는 기능 검증되지 않으면 에러를 발생 시킴 ( validate, checkOverLap ) (에러는 "[ERROR]" 로 시작하는 문구)

**User**
>- [x] 구입 금액을 입력받는 기능 ( User가 LottoSystem에게 지불할 금액 ) ( User 생성자 )
>- [x] 구입 금액을 조회하는 기능 ( getUserPayAmount )
>- [x] 구매한 랜덤 로또 번호를 기억하는 기능 ( User가 지불한 금액에 따른 랜덤 로또 번호 ) ( setUserLottoNumber )
>- [x] 구매한 랜덤 로또 번호를 조회하는 기능 ( getUserLottoNumber )

**LottoSystem**
>- [x] User에게 입력받은 금액이 1000원 단위로 나누어 떨어지는지 확인하는 기능 떨어지지 않으면 에러를 발생시킴 ( setDivisible ) (에러는 "[ERROR]" 로 시작하는 문구)
>- [x] User에게 입력받은 금액을 1000원 단위로 나누어 LottoSystem에 구매할 갯수를 저장하는 기능 ( setBuyCount )
>- [x] User에게 입력받은 금액을 1000원 단위로 나누어 LottoSystem에 구매할 갯수를 조회하는 기능 ( getBuyCount )


*****
### 🟧 service package
**UserService**
- [ ] Lotto System을 통해 당첨 통계를 조회하는 기능 ( getUserLottoResult ) ( Lotto System을 통해 구매한 로또 번호와 비교 )
- [ ] 총 수익률을 계산하는 기능 ( setRevenue )
- [ ] 총 수익률을 조회하는 기능 ( getRevenue )
- [ ] 랜덤 번호를 생성하는 기능 ( setRandomLottoNumbers )
- [ ] 금액을 입력받는 기능 ( setPayMent )

**LottoSystemService**
>- [ ] 당첨 통계를 계산하는 기능 ( setTotal )
>- [ ] 당첨 통계를 조회하는 기능 ( getTotal )
>- [ ] User에게 입력받은 금액으로 LottoSystem에 로또를 구매하는 기능 ( buyLotto )

*****
### 🟧 controller package
**LottoController**
>- [ ] 사용자가 로또를 구매하는 기능 ( inputUserMoney )
>- [ ] 구매된 로또 번호를 보여주는 기능 ( printLottoNumber )
>- [ ] 당첨번호를 입력하는 기능 ( inputWinningNumber )
>- [ ] 보너스 번호를 입력받는 기능 ( inputBonusNumber )
>- [ ] 당첨 통계를 보여주는 기능 ( printStatistics )
>- [ ] 총 수익률을 보여주는 기능 ( printRevenue )