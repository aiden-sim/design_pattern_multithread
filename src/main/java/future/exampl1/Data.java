package future.exampl1;

/**
 * VirtualData(가상 데이터) 역할
 * VirtualData 역할은 Future 역할과 RealData 역할을 동일시하는 역할이다.
 * 데이터에 대한 액세스 방법을 표현한 인터페이스, FutureData와 RealData가 구현한다.
 */
public interface Data {
    public abstract String getContent();
}
