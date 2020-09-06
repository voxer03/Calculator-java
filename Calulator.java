import java.util.Scanner;
import javax.swing.*;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;

class Calculator extends JFrame implements ActionListener{
	private JButton button[];
	private JButton clear;
	private JTextField field ;
	private JLabel label;
	private double num;
	private boolean isempty=true;
	private boolean isDecimal=false;
	private String operator;
	private String prvop;
	Calculator()
	{
		super("Calculator");
		field = new JTextField();
		field.setBounds(20,20,230,50);
		
		label=new JLabel();
		label.setBounds(20,75,230,40);
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		label.setForeground(new Color(255, 0, 0));
		label.setText("");
		add(label);
		
		field.setHorizontalAlignment(SwingConstants.RIGHT);
		field.setFont(new Font("Tunga", Font.BOLD,22));
		add(field);
		System.out.println("Ruuning1");
		button=new JButton[16];
		String a[]={"1","2","3","X","4","5","6","+","7","8","9","-",".","0","/","="};
		
		int i;	
		for(i=0;i<a.length;i++)
		{
			button[i]=new JButton(a[i]);
		}
		clear=new JButton("C");
		clear.setBounds(20,360,230,30);
		clear.addActionListener(this);
		clear.setFont(new Font("Tunga", Font.BOLD,22));
		clear.setBackground(Color.WHITE);
		clear.setFocusPainted(false);
		add(clear);
		
		int j,k;
		j=20;
		k=130;
		int si=50;
		int sil=30;
		for(i=1;i<=a.length;i++)
		{
			if(i==7) {
				button[i-1].setBounds(j+120,k,si,sil);
			}
			else if(i%4==0)
			{
				button[i-1].setBounds(j+180,k,si,sil);
				k=k+60;
			}
			else if(i%3==0&&i!=6)
			{
				button[i-1].setBounds(j+120,k,si,sil);
			}
			else if(i%2==0||i==6)
			{
				button[i-1].setBounds(j+60,k,si,sil);
			}
			else
			{
				button[i-1].setBounds(j,k,si,sil);
			}
			add(button[i-1]);
			button[i-1].addActionListener(this);
			button[i-1].setFont(new Font("Tunga", Font.BOLD,22));
			button[i-1].setBackground(Color.WHITE);
			button[i-1].setFocusPainted(false);
		}
		setSize(290,450);
		setLayout(null);
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		JButton b=(JButton) e.getSource();
		String st=b.getActionCommand();
		
		if(st=="X") {
			operator=st;
			if(isempty) {
				num=Double.parseDouble(field.getText());
			}
			else {
				pre(Double.parseDouble(field.getText()),prvop);
			}
			isempty=false;
			label.setText(Double.toString(num)+" "+st);
			field.setText("");
			prvop=st;
		}
		else if(st=="+"){
			operator=st;
			if(isempty) {
				num=Double.parseDouble(field.getText());
			}
			else {
				pre(Double.parseDouble(field.getText()),prvop);
			}
			isempty=false;
			label.setText(Double.toString(num)+" "+st);
			
			field.setText("");
			prvop=st;
		}
		else if(st=="-") {
			operator=st;
			if(isempty) {
				num=Double.parseDouble(field.getText());
			}
			else {
				pre(Double.parseDouble(field.getText()),prvop);
			}
			isempty=false;
			label.setText(Double.toString(num)+" "+st);
			field.setText("");
			prvop=st;
		}
		else if(st=="/") {
			operator=st;
			if(isempty) {
				num=Double.parseDouble(field.getText());
				label.setText(Double.toString(num)+" "+st);
				field.setText("");
			}
			else {
				double temp=Double.parseDouble(field.getText());
				if(temp!=0) {
					pre(Double.parseDouble(field.getText()),prvop);
					label.setText(Double.toString(num));
					field.setText("");
				}
				else {
					label.setText("Cannot Divide by 0");
					field.setText("Cannot Divide by 0");
				}
			}
			isempty=false;
			
			prvop=st;
		}
		else if(st=="=") {
			if(!isempty) {
				double r=Double.parseDouble(field.getText());
				switch(operator) {
					case "+" : 	num+=r;
								field.setText(Double.toString(num));
								break;
					case "-" :	num-=r;
								field.setText(Double.toString(num));
								break;
					case "X" :	num*=r;
								field.setText(Double.toString(num));
								break;
					case "/" :
						if(r!=0) {
							num/=r;
							field.setText(Double.toString(num));
						}
						else {
							label.setText("Cannot Divide by 0");
							field.setText("Cannot Divide by 0");
						}
				}


			}
			isempty=true;
		}
		else if(st==".") {
			if(!isDecimal) {
				label.setText(field.getText()+st);
				field.setText(field.getText()+st);
			}
			isDecimal=true;
		}
		else if(st=="C") {
			field.setText("");
			label.setText("");
			isempty=true;
		}
		else {
			label.setText(field.getText()+st);
			field.setText(field.getText()+st);
		}

	}
	
	private void pre(double data,String op) {
		
		switch(op) {
		case "+" : 	num+=data;
					break;
		case "-" :	num-=data;
					break;
		case "X" :	num*=data;
					break;
		case "/" :  num/=data;
					break;	
		}
	}
	
}