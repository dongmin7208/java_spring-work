package aop010;

public class Boy implements Person{
	public void runSomething(){
		System.out.println("컴퓨터로 게임을 한다.");
		throw new NumberFormatException("불남");
	}
}
