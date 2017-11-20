package chapter10;

import java.awt.event.*;
import javax.swing.*;

public class LeftKeyFrame extends JFrame 
{
    JPanel jp = new JPanel();
    JLabel jl = new JLabel("Love Java"); //키 입력에 따라 움직일 레이블 컴포넌트
    LeftKeyFrame()
    {
        this.setTitle("Left키로 문자열 한칸씩 이동");// <- 키 입력 
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(jp);
        jp.addKeyListener(new LeftListener());
        jp.add(jl);
        setSize(200, 100);
        setVisible(true); //스윙 프레임 출력
        jp.requestFocus(); // 레이블에 키 입력 포커스 서정
    }
     public static void main(String[] args)
    {
        new LeftKeyFrame();//레프트 프래임 생성 
    }
    public class LeftListener extends KeyAdapter
    {
        String str = jl.getText();
        int c = 0;
        public void keyPressed(KeyEvent e)
        {
            int keyCode = e.getKeyCode();
            if(keyCode == KeyEvent.VK_LEFT)c++; //왼쪽 화살표 키가 입력될때
            jl.setText(str.substring(c) + str.substring(0, c));
            if(c == str.length()) c = 0;//문자의 앞뒤을 바꾸고 반전 시킨다
            }}}
