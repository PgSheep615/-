package Demo6;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyJFrame extends JFrame implements ActionListener {

    private JTextField jTextField = new JTextField();

    private JButton jButton0 = new JButton("0");
    private JButton jButton1 = new JButton("1");
    private JButton jButton2 = new JButton("2");
    private JButton jButton3 = new JButton("3");
    private JButton jButton4 = new JButton("4");
    private JButton jButton5 = new JButton("5");
    private JButton jButton6 = new JButton("6");
    private JButton jButton7 = new JButton("7");
    private JButton jButton8 = new JButton("8");
    private JButton jButton9 = new JButton("9");
    private JButton jButton14 = new JButton("/");
    private JButton jButton24 = new JButton("*");
    private JButton jButton34 = new JButton("+");
    private JButton jButton42 = new JButton(".");
    private JButton jButton43 = new JButton("=");
    private JButton jButton44 = new JButton("-");

    private double text1 = 0;
    private double text2 = 0;
    private double sum = 0;
    private int opflag = 0;     //1+; 2-; 3*; 4/  5=
    public MyJFrame() {
        initJFrame();

        this.setVisible(true);
    }

    public void initJFrame() {
        //设置界面的宽高
        this.setSize(350, 350);
        //界面标题
        this.setTitle("不考虑精度损失的计算机（doge）");
        //界面置顶
        this.setAlwaysOnTop(true);
        //界面居中
        this.setLocationRelativeTo(null);
        //游戏关闭模式
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);       //接口调用static常量final
        //取消默认居中方式，只有取消了才会按照XY轴的方式添加组件
        this.setLayout(null);
        this.getContentPane().setBackground(Color.pink);

        jTextField.setBounds(0, 0, 300, 30);
        this.getContentPane().add(jTextField);
        place();

    }

    public void place() {
        jButton7.setBounds(10, 40, 50, 50);
        jButton8.setBounds(80, 40, 50, 50);
        jButton9.setBounds(150, 40, 50, 50);
        jButton14.setBounds(220, 40, 50, 50);
        this.getContentPane().add(jButton7);
        this.getContentPane().add(jButton8);
        this.getContentPane().add(jButton9);
        this.getContentPane().add(jButton14);

        jButton4.setBounds(10, 100, 50, 50);
        jButton5.setBounds(80, 100, 50, 50);
        jButton6.setBounds(150, 100, 50, 50);
        jButton24.setBounds(220, 100, 50, 50);
        this.getContentPane().add(jButton4);
        this.getContentPane().add(jButton5);
        this.getContentPane().add(jButton6);
        this.getContentPane().add(jButton24);

        jButton1.setBounds(10, 160, 50, 50);
        jButton2.setBounds(80, 160, 50, 50);
        jButton3.setBounds(150, 160, 50, 50);
        jButton34.setBounds(220, 160, 50, 50);
        this.getContentPane().add(jButton1);
        this.getContentPane().add(jButton2);
        this.getContentPane().add(jButton3);
        this.getContentPane().add(jButton34);

        jButton0.setBounds(10, 220, 50, 50);
        jButton42.setBounds(80, 220, 50, 50);
        jButton43.setBounds(150, 220, 50, 50);
        jButton44.setBounds(220, 220, 50, 50);
        this.getContentPane().add(jButton0);
        this.getContentPane().add(jButton42);
        this.getContentPane().add(jButton43);
        this.getContentPane().add(jButton44);

        jButton0.addActionListener(this);
        jButton1.addActionListener(this);
        jButton2.addActionListener(this);
        jButton3.addActionListener(this);
        jButton4.addActionListener(this);
        jButton5.addActionListener(this);
        jButton6.addActionListener(this);
        jButton7.addActionListener(this);
        jButton8.addActionListener(this);
        jButton9.addActionListener(this);
        jButton14.addActionListener(this);
        jButton24.addActionListener(this);
        jButton34.addActionListener(this);
        jButton42.addActionListener(this);
        jButton43.addActionListener(this);
        jButton44.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(opflag == 5){
            jTextField.setText("");
            opflag = 0;
        }
        Object source = e.getSource();
        String str = jTextField.getText();
        if(source == jButton0){
            jTextField.setText(str + "0");
        }else if(source == jButton1){
            jTextField.setText(str + "1");
        }else if(source == jButton2){
            jTextField.setText(str + "2");
        }else if(source == jButton3){
            jTextField.setText(str + "3");
        }else if(source == jButton4){
            jTextField.setText(str + "4");
        }else if(source == jButton5){
            jTextField.setText(str + "5");
        }else if(source == jButton6){
            jTextField.setText(str + "6");
        }else if(source == jButton7){
            jTextField.setText(str + "7");
        }else if(source == jButton8){
            jTextField.setText(str + "8");
        }else if(source == jButton9){
            jTextField.setText(str + "9");
        }else if(source == jButton42){
            jTextField.setText(str + ".");
        } else if(source == jButton44){
            text1 = Double.parseDouble(str);
            jTextField.setText("");
            opflag = 2;
        }else if(source == jButton14){
            text1 = Double.parseDouble(str);
            jTextField.setText("");
            opflag = 4;
        }else if(source == jButton24){
            text1 = Double.parseDouble(str);
            jTextField.setText("");
            opflag = 3;
        }else if(source == jButton34){
            text1 = Double.parseDouble(str);
            jTextField.setText("");
            opflag = 1;
        }else if(source == jButton43){
            text2 = Double.parseDouble(str);
            switch (opflag){
                case 1:
                    sum = text1 + text2;
                    break;
                case 2:
                    sum = text1 - text2;
                    break;
                case 3:
                    sum = text1 * text2;
                    break;
                case 4:
                    sum = text1 / text2;
                    break;
                default:
                    break;
            }
            jTextField.setText(sum + "");
            text1 = 0;
            text2 = 0;
            sum = 0;
            opflag = 5;
        }
    }
}
