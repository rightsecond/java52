package com.ch6;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
/*
 * A is a B관계에 있다면 서로 상속처리한다.
 * 상속받을 땐 하위클래스를 상속받는 것이 더 많은 걸 누릴 수 있다.
 * ActionListener는 이벤트 처리를 담당하는 인터페이스
 * 인터페이지는 추상메소드만 가지고 있다.-왜냐면 기능을 결정할 수 없어서....
 * 구현하는 클래스가 각각 다르기 때문에....
 * 어플리케이션이 배포되는 디바이스가 다르니깐....
 * ActionListener를 implements한 클래스가 구현체 클래스이다.
 */
public class P170 extends JFrame implements ActionListener {
	//this.setTitle(title);에서 title변수가 선언되지 않았다.
	//선언이 먼저 사용이 다음
	String title = null;
	JButton jbtn = new JButton("전송");
	public P170() {
		initDisplay();
	}//디폴트 생성자
	public P170(String title) {
		this.title = title;
		//주의 : title을 먼저 초기화하고 화면을 출력해야 함.
		initDisplay();
	}
	public void initDisplay() {
		//이벤트소스(버튼)->감지(JVM)->Callback호출-actionPerformed(ActionEvent e)
		//e.getSource();->이벤트소스의 주소번지
		jbtn.addActionListener(this);
		this.add("North",jbtn);
		this.setTitle(title);
		this.setSize(400, 500);
		this.setVisible(true);
	}
	public static void main(String[] args) {
		P170 p = new P170("this의 활용기");
		//p.initDisplay();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String label = e.getActionCommand();//전송
		if("전송".equals(label)) {
			System.out.println("전송 버튼 클릭");
		}
	}

}
