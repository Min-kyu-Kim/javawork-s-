package test.main;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import test.mypac.DownloadTask;
import test.mypac.SubThread;

public class MainFrame05 extends JFrame implements ActionListener {
	//생성자
	public MainFrame05(String title) {
		super(title);
		setLayout(new BorderLayout());
		JButton btn=new JButton("알림 띄우기");
		btn.addActionListener(this);
		add(btn, BorderLayout.NORTH);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		JOptionPane.showMessageDialog(this, "알림 입니다. !!!");
		
		//Runnable 인터페이스 type의 참조값을 얻어내서
		Runnable downTask=new DownloadTask();
		Thread t=new Thread(downTask);
		t.start();
		
		System.out.println("actionPerformed() 메소드가 리턴 합니다."); //메인이 먼저 실행되고 다음에 스레드 작업이 나중에 실행됨
	}
	public static void main(String[] args) {
		MainFrame05 f=new MainFrame05("메인 프레임02");
		f.setBounds(100, 100, 500, 300);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
		
	}
}
