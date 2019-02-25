## Thread
- 순차, 병렬, 병행
  - 순차(sequential) : 복수의 업무를 순서대로 처리
  - 병렬(parallel) : 복수의 업무를 동시에 처리
  - 병행(concurrent) : 순차, 병렬보다 추상도가 높은 표현. 한 개의 업무를 어떠한 순서로 처리하든 상관 없는 여러 개의 작업.(분할)
- 데이터 레이스(data race) or 레이스 컨디션(race condition)
  - 쓰레드 A와 쓰레드 B가 경쟁함으로써 예기치 않게 발생하는 상황
- 배타제어 or 상호배타
  - 쓰레드가 어느 부분을 실행하고 있으면 다른 쓰레드가 그 부분을 실행할 수 없게 만드는 것 (synchronized)
  - 쓰레드의 배타제어를 하는 구조를 모니터(monitor)라 하며 락을 취하고 있는 것을 모니터를 소유(own)한다. 혹은 락을 홀드(hold)한다고 표현한다.
- 쓰레드 협조
  - wait set (쓰레드 대합실)
    - 모든 인스턴스는 wait set을 가진다. 그 인스턴스의 wait 메소드를 실행한 후 동작을 정지하고 있는 쓰레드들의 집합이다.
    - 쓰레드는 wait 메소드를 실행하면 동작을 일시 정지하고 wait set에 들어간다.
    - 다음 한 상황이 발생하면 wait set에서 나올 수 있다.
      - 1) 다른 쓰레드에서 notifiy 메소드에 의해 깨어난다.
      - 2) 다른 쓰레드에서 notifyAll 메소드에 의해 깨어난다.
      - 3) 다른 쓰레드에서 interrupt 메소드에 의해 깨어난다.
      - 4) wait 메소드가 타임아웃 된다.
  - wait 메소드 (쓰레드를 wait set에 넣는다)
    - wait 메소드를 사용하면 쓰레드가 wait set에 들어간다. (쓰레드가 obj 상에서 wait 하고 있다.)
    - 메소드 안에 wait()가 있으면 this.wait()와 같은 의미이므로 실행한 쓰레드는 this의 wait set으로 들어간다.
    - wait 메소드를 실행하기 위해서 쓰레드가 락을 가지고 있어야 하는데(규칙) wait set에 들어갈 때는 락을 일단 해제한다.
  - notify 메소드 (쓰레드를 wait set에서 꺼낸다)
    - notify 메소드를 사용하면 wait set에 있는 쓰레드 한개를 꺼낸다.
    - notify 메소드를 실행하기 위해서는 wait 메소드와 마찬가지로 쓰레드가 락을 가지고 있어야 한다. (규칙)
    - notify 메소드를 실행했을 때 wait set에 대기중인 쓰레드가 여러개 있는 경우 어느 쓰레드가 선택될지는 정해져 있지 않다.
  - notifyAll 메소드 (모든 쓰레드를 wait set에서 꺼낸다)
    - notifyAll 메소드를 사용하면 wait set에 있는 모든 쓰레드를 꺼낸다.
    - notify가 한 개의 쓰레드를 깨우는데 반해 notifyAll은 모든 쓰레드를 깨운다.
    - notify보다 notifyAll을 사용하는 편이 낫다.
  - wait, notify, notifyAll은 Objectc 클래스의 메소드이다.
  - 주의점
    - 락을 가지지 못한 쓰레드가 wait, notify, notifyAll 메소드를 호출하면 IlegalMonitorStateException이 발생된다.
- 쓰레드의 상태 변화
  - NEW, RUNNABLE, TERMINATED, WAITING, TIMED_WAITING, BLOCKED
![state-machine-example-java-6-thread-states](https://user-images.githubusercontent.com/7076334/53339235-1a691180-3949-11e9-8e48-301c386e78ba.png)

## MultiThread 평가기준
- 안정성 (객체를 망가뜨리지 않을 것)
  - 객체가 설계자의 의도와는 다른 상태가 되는 것을 의미한다.
  - 복수의 쓰레드가 이용해도 안전성이 유지되는 클래스를 쓰레드 세이프(thread-safe) 한 클래스라 부른다.
- 생존성 (필요한 처리가 이뤄질 것)
  - 프로그램이 중간에 멈추면 상태가 변화하지 않지만 (안정성 확보) 작동하지 않으면 아무런 소용이 없다. 
  - 안정성과 생존성은 상반된다. 안전성만 중시하다가 생존성을 읽을 수 있다. ex) 데드락
- 재사용성 (클래스를 다시 사용할 수 있을 것)
  - 필수는 아니지만 프로그램 품질을 높이는데 필요한 조건이다.
  - 멀티 쓰레드 프로그램에서는 쓰레드 배타제어의 구조나 방침을 클래스 안에 잘 숨기면 재사용성이 높은 프로그램이 된다.
- 수행 능력 (고속, 대량으로 처리할 수 있을 것)
  - 필수는 아니지만 프로그램 품질을 높이는데 필요한 조건이다.
  - throughput(쓰루풋) : 단위 시간 당 처리 수. 많은 처리가 가능하면 작업 처리량이 높아진다.
  - responsiveness(응답성) : 요구를 한 뒤 반응이 나타날 때까지 걸리는 시간. 시간이 짧을수록 응답성이 좋은 것이다.
  - capacity(용량) : 동시에 처리할 수 있는 수.
  - 그 밖에 efficiency(효율), scalability(확장성), degradation(저하) 등이 있다.
- 평가기준의 정리
  - 안전성과 생존성을 지키는 것은 필수 이다.
  - 위 조건을 만족한 상태에서 재사용성과 수행 능력을 어떻게 높이느냐가 관건이다. (품질 향상)
  
## Single Threaded Execution (이 다리를 건널 수 있는 사람은 오직 한 명)
- Single Threaded Execution은 한 개의 쓰레드에 의한 실행
- Critical Section(위험 구역), Critical Region 이라고도 불린다.
- synchronized의 역할
  - synchronized 메소드는 동시에 한 개의 쓰레드에서만 실행되는 것을 보증한다.
- Single Threaded Execution 패턴의 등장인물
  - SharedResource(공유자원) 역할
    - safeMethod : 복수의 쓰레드에서 동시에 호출해도 아무런 문제가 없는 메소드
    - unsafeMethod : 복수의 쓰레드에서 동시에 호출하면 안 되기 때문에 가드가 필요한 메소드 (synchronized)
    - 크리티컬 세션(critical section) : 싱글 쓰레드로 동작시켜야 되는 범위

![main](https://user-images.githubusercontent.com/7076334/53351962-51e5b700-3965-11e9-9ecb-c1fd365ae22c.jpg)

- 언제 사용하면 좋을까?
  - 멀티 쓰레드
  - 복수의 쓰레드가 액세스할 가능성이 있을 때
  - 상태 변화할 가능성이 있을 때
  - 안정성 확보할 필요가 있을 때
- 생존성과 데드락
  - Single Threaded Execution 패턴을 사용하면 데드락(dead lock)을 일으킬 위험이 있다.
  - 데드락이란 2개의 쓰레드가 2개의 락을 차지하고서 서로 상대방 쓰레드가 락을 해제하기를 기다리는 현상이다. (생존성 상실)

