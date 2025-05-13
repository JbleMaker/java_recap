## 싱글톤 패턴(Singleton Pattern)
- 객체 지향 프로그래밍에서 특정 클래스가 단 하나만의 인스턴스를 생성하여 사용하기 위한 패턴.
- 커넥션 풀, 스레드 풀등과 같은 경우 인스턴스를 여러개 만들게 되면 불필요한 자원을 사용하게 되는데   
  객체를 필요할때마다 생성하는 것이 아닌 단 한번만 생성하여 전역에서 이를 공유 및 사용 할 수 있게 하기 위해 사용.

#### 장점
- 유일한 인스턴스 : 객체의 일관된 상태를 유지, 전역에서 접근이 가능하도록 한다.
- 메모리 절약 : 인스턴스가 단 하나 뿐이므로 메모리를 절약할 수 있다.
  새로운 인스턴스를 생성하지 않아 메모리 점유 및 해제에 대한 오버헤드를 줄인다.
- 지연 초기화 : 인스턴스가 실제로 사용되는 시점에 생성하여 초기 비용을 줄일 수 있다.

#### 단점
- 결함도 증가 : 전역에서 접근을 허용하기 때문에 해당 인스터스에 의존하는 경우 결합도 증가.   
  **결합도 : 하나의 프로그램 안에서 각 모듈들이 서로 관련되어 의존하고 있는 정도
- 테스트 복잡성 : 싱글톤 클래스를 의존하는 클래스는 결합도 증가로 인해 테스트가 어려울 수 있다.
- 상태 관리의 어려움 : 싱글톤클래스가 상태를 가지는 경우 전역에서 사용되어 상태관리가 어려워진다.
- 전역에서 접근 가능 : 무분별한 사용을 막기 힘들다.
  


### 기본 구현
- new 키워드를 사용할 수 없도록 생성자에 private을 지정해야 한다.
- 유일한 단일 객체를 반환할 수 있는 정적 메서드가 필요.
- 유일한 단일 객체를 참조할 정적 참조 변수가 필요.

### 주의사항 
- 단일 객체이기 때문에 공유 객체로 사용되는데 이때 상태값을 가지지 않는 것이 좋다.
- 상태 값이 아닌 읽 전용 속성을 가지거나 또 다른 단일 객체를 참조하는 속성을 가지는 경우 문제가 되지 않는다.
- 여러 스레드가 동시에 접근하는 경우 문제가 발생.(Thread Safe)

### Thread Safe Singleton
1. sychronized키워드를 사용하여 getInstance() 메서드에 하나의 스레드만 접근 가능하도록 하는 방법
   - 단, 여러 스레드가 getInstance()메서드를 동시에 접근하려 할 때 동기화 작업 때문에 성능 저하가 발생.
```java
public class Singleton {
    private static Singleton singletonObject;

    private Singleton() {
    }
    
    public static synchronized Singleton getInstance() {
        if (singletonObject == null) {
            singletonObject = new Singleton();
        }
        
        return singletonObject;
    }
}
```

2. 이른 초기화(eager initialization) 사용
   - 객체 생성 비용이 크지 않은 경우 이른 초기화 방법 사용.
   - 변수 선언과 동시에 초기화
   - 부가적으로 final키워드를 붙여 상수로써 사용하면 전역에서 공유하면서 변하지 않는 속성으로 사용.
   - 다만, 미리 생성하는 것 자체가 단점으로 작용할 수 있다. (미리 메모리를 점유하기 때문)
```java
public class Singleton {
    private static final Singleton SINGLETON_OBJECT = new Singleton();

    private Singleton() {
    }

    public static synchronized Singleton getInstance() {
        return SINGLETON_OBJECT;
    }
}
```

3. Double checked locking
   - getInstance() 메서드를 사용할 때마다 동기화 작업을 하는 것이 아닌 초기화 할 때만 동기화 작업을 수행하는 방법.
   - volatile 키워드와 더블체크를 통한 synchronized키워드 활용
   - 최초 메서드 호출시 두 스레드가 if문에 진입 하더라도, 이후에 진행되는 synchronized키워드로 인해 두번째 if문에서는
     lock이 걸린다.
```java
public class Singleton {
    // volatile 키워드 사용
    private static volatile Singleton singletonObject;

    private Singleton() {
    }

    public static Singleton getInstance() {
        if (singletonObject == null) {
            // if 문 진입 시에만 Singleton 클래스에 대한 동기화 작업 수행
            synchronized (Singleton.class) {
                if (singletonObject == null) {
                    singletonObject = new Singleton();
                }
            }
        }

        return singletonObject;
    }
}
```

4. Bill Pugh Solution 사용(권장)
   - JVM의 ClassLoader에 의해서 로드될 때 내부적으로 실행되는 synchronized키워드를 이용하는 방법.
   - Double checked locking보다 단순하면서 JVM버전에 제약 없이 지연초기화 가능
   - 자바 리플렉션과 직렬화를 통해 싱글톤이 파괴될 수 있다.
```java
public class Singleton {

    private Singleton() {
    }

    private static class SingletonHolder {
        private static final Singleton SINGLETON_OBJECT = new Singleton();
    }

    public static Singleton getInstance() {
        return SingletonHolder.SINGLETON_OBJECT;
    }
}
```

5. Enum(권장)
   - Enum 클래스는 생성자를 private으로 갖게 만들고, 상수만 갖는 클래스이기 때문에 싱글톤의 성질을 가진다.
   - 단순한 코드로 싱글톤 패턴을 구현할 수 있다.
   - 단, Enum외의 클래스는 상속 불가능한 문제점이 있다.
```java
public enum Singleton{
    SINGLETON_OBJECT
}
```


## 참고링크
- https://scshim.tistory.com/361
- https://ittrue.tistory.com/563 