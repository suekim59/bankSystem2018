package bankSystem;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.*;

class GUI2 {
	JFrame frame;
	JLabel[] label;
	JButton[] button;
	JButton button2, button3;
	JPanel[] panel, panel2;
	JTextField[] textfield;
	JTextField textfield2;
	JTextArea textarea;
	public int i = 0;

	String userId = "";
	String pass = "";
	int age = 0;
	int balance = 0;
	String id2 = "";
	String pass2 = "";
	int index, p, index2 = 0;
	ArrayList<Bank> users = new ArrayList<Bank>();

	public GUI2() {
		frame = new JFrame("은행 거래 시스템(Bank Transactions System)");
		button = new JButton[6];
		String[] put = { "<html>1.추가<br/>(Join)</html>", 
						"<html>2.조회<br/>(Search)</html>",
						"<html>3.입금<br/>(Deposit)</html>", 
						"<html>4.출금<br/>(Withdrawal)<html>",
						"<html>5.삭제<br/>(Delete)</html>", 
						"<html>6.종료<br/>(Exit)</html>" };
		for (i = 0; i < button.length; i++) {
			button[i] = new JButton(put[i]);
			button[i].setBackground(Color.PINK);
			button[i].setForeground(Color.white);
			button[i].setFont(new Font(null, Font.BOLD, 20));
		}
	}

	public void Graphic() {

		frame.setLayout(new GridLayout(3, 2));
		frame.setSize(400, 400);
		frame.setVisible(true);
		for (i = 0; i < button.length; i++) {
			frame.add(button[i]);
		}
		for (i = 0; i < button.length; i++) {
			button[i].addActionListener((ActionListener) this);
		}
	}

	public void custom_add() {

		JFrame frame = new JFrame("추가(JOIN)");
		panel = new JPanel[5];
		label = new JLabel[4];
		textfield = new JTextField[4];
		button2 = new JButton("추가(JOIN)");

		String[] put = { "ID ", "PASS", "AGE", "BALANCE" };
		for (i = 0; i < label.length; i++) {
			label[i] = new JLabel(put[i], JLabel.CENTER);
			label[i].setForeground(Color.black);
		}
		for (i = 0; i < textfield.length; i++) {
			textfield[i] = new JTextField();
		}
		for (i = 0; i < panel.length; i++) {
			panel[i] = new JPanel(new GridLayout());
			panel[i].setBackground(Color.lightGray);
		}
		for (i = 0; i < panel.length - 1; i++) {
			panel[i].add(label[i]);
			panel[i].add(textfield[i]);
		}
		panel[4].add(button2);

		frame.setVisible(true);
		frame.setLayout(new GridLayout(5, 2));
		frame.setSize(400, 400);
		for (i = 0; i < panel.length; i++) {
			frame.add(panel[i]);
		}
		button2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource().equals(button2)) {
					try {
						userId = textfield[0].getText();
						pass = textfield[1].getText();
						age = Integer.parseInt(textfield[2].getText());
						balance = Integer.parseInt(textfield[3].getText());
						frame.setVisible(false);
						p = 2;
						for (i = 0; i < users.size(); i++) {
							if (users.get(i).userAuth2(userId)) {
								JOptionPane.showMessageDialog(null, "There is the same user ID.");
								p = 0;
								break;
							} // if
						} // for

						if (p == 2) {
							users.add(new Bank(userId, pass, age, balance));
							JOptionPane.showMessageDialog(null, "Your Info is saved successfuly.");
						}
					} catch (Exception ex) {
						JOptionPane.showMessageDialog(null, "Please check again.");
					}
				}

			}
		});

	}// custom_add

	public int custom_search(int num) {

		JFrame frame = new JFrame("조회(Search)");
		panel = new JPanel[3];
		label = new JLabel[2];
		textfield = new JTextField[2];
		button2 = new JButton("조회(Search)");

		String[] put = { "ID ", "PASS" };
		for (i = 0; i < label.length; i++) {
			label[i] = new JLabel(put[i], JLabel.CENTER);
			label[i].setForeground(Color.BLACK);
			textfield[i] = new JTextField();
		}
		for (i = 0; i < panel.length; i++) {
			panel[i] = new JPanel(new GridLayout());
		}
		for (i = 0; i < panel.length - 1; i++) {
			panel[i].add(label[i]);
			panel[i].add(textfield[i]);
		}
		panel[2].add(button2);
		frame.setVisible(true);
		frame.setLayout(new GridLayout(3, 2));
		frame.setSize(400, 400);
		for (i = 0; i < panel.length; i++) {
			frame.add(panel[i]);
		}
		button2.setBackground(Color.pink);
		button2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource().equals(button2)) {

					id2 = textfield[0].getText();
					pass2 = textfield[1].getText();

					Iterator<Bank> it = users.iterator();
					while (it.hasNext()) {
						Bank find = it.next();
						if (find.userAuth(id2, pass2)) {
							JOptionPane.showMessageDialog(null, "Your query is successful.");
							JOptionPane.showMessageDialog(null, find.show());
							frame.dispose();
						
							 if(num==1) { 
								 custom_deposit(); 
							 }else if(num==2) { 
								 custom_withdraw(); 
						     }
						     
							
							p = 1;
							break;
						}
						p = 0;
						index++;
					} 
					if (p == 0) {
						JOptionPane.showMessageDialog(null, "You failed to find your Info.");
						frame.dispose();
					}
				}
			}
		});
		if (p == 1) {
			return index;
		} else {
			return -1;
		}

	}// custon_search()

	public int custom_search2() {

		id2 = textfield[0].getText();
		pass2 = textfield[1].getText();

		for (i = 0; i < users.size(); i++) {
			if (users.get(i).userAuth(id2, pass2)) {
				return i;
			}
		} 
		JOptionPane.showMessageDialog(null, "You failed to find your Info.");
		return -1;
	}
	public void custom_deposit() {

		JFrame frame2 = new JFrame("입금(DEPOSIT)");
		panel = new JPanel[2];
		label = new JLabel[1];
		textfield2 = new JTextField();
		button3 = new JButton();
		button3 = new JButton("입금(Deposit)");

		label[0] = new JLabel("Amount", JLabel.CENTER);
		label[0].setForeground(Color.BLACK);
		button3.setBackground(Color.pink);
		for (i = 0; i < panel.length; i++) {
			panel[i] = new JPanel(new GridLayout());
			panel[i].setBackground(Color.gray);
		}
		panel[0].add(label[0]);
		panel[0].add(textfield2);
		panel[1].add(button3);

		frame2.setVisible(true);
		frame2.setLayout(new GridLayout(2, 2));
		frame2.setSize(400, 400);
		for (i = 0; i < panel.length; i++) {
			frame2.add(panel[i]);
		}
		button3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource().equals(button3)) {
					try {
						balance = Integer.parseInt(textfield2.getText());
						if (balance <= 0) {
							JOptionPane.showMessageDialog(null, "Please check again the amount.");
							
						} else {
							Bank find = users.get(custom_search2());
							find.deposit(balance);
							JOptionPane.showMessageDialog(null, "Deposit Completed!\nBalance : " + find.getBalance());
							frame2.dispose();
						} 
					} catch (Exception e2) {
						JOptionPane.showMessageDialog(null, "Please insert numbers.");
					}
				}

			}
			
		});

	}

	void custom_withdraw() {
		JFrame frame2 = new JFrame("출금(Withdrawl)");
		panel = new JPanel[2];
		label = new JLabel[1];
		textfield2 = new JTextField();
		button3 = new JButton();
		button3 = new JButton("출금(Withdrawal)");

		label[0] = new JLabel("금액", JLabel.CENTER);
		label[0].setForeground(Color.BLACK);
		button2.setBackground(Color.pink);
		for (i = 0; i < panel.length; i++) {
			panel[i] = new JPanel(new GridLayout());
			panel[i].setBackground(Color.gray);
		}
		panel[0].add(label[0]);
		panel[0].add(textfield2);
		panel[1].add(button3);

		frame2.setVisible(true);
		frame2.setLayout(new GridLayout(2, 2));
		frame2.setSize(400, 400);
		for (i = 0; i < panel.length; i++) {
			frame2.add(panel[i]);
		}
		button3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource().equals(button3)) {
					try {
					balance = Integer.parseInt(textfield2.getText());
					Bank find = users.get(custom_search2());
					if (balance > find.getBalance()) {
						JOptionPane.showMessageDialog(null, "Insufficient funds in the account.");				
					} else if (balance <= 0) {
						JOptionPane.showMessageDialog(null, "Please check again the amount.");
					} else {
						find.withdraw(balance);
						JOptionPane.showMessageDialog(null, "Withdrawal completed!\nBalance : " + find.getBalance());
						frame2.dispose();
					}
					}catch(Exception e2) {
						JOptionPane.showMessageDialog(null, "Please insert numbers.");
					}
				}
			}
		});
	}

	void custom_delete() {

		JFrame frame = new JFrame("삭제(Delete)");
		panel = new JPanel[3];
		label = new JLabel[2];
		textfield = new JTextField[2];
		button2 = new JButton("삭제(Delete)");

		String[] put = { "ID ", "PASS" };
		for (i = 0; i < label.length; i++) {
			label[i] = new JLabel(put[i], JLabel.CENTER);
			label[i].setForeground(Color.BLACK);
			textfield[i] = new JTextField();
		}
		for (i = 0; i < panel.length; i++) {
			panel[i] = new JPanel(new GridLayout());
		}
		for (i = 0; i < panel.length - 1; i++) {
			panel[i].add(label[i]);
			panel[i].add(textfield[i]);
		}
		panel[2].add(button2);
		frame.setVisible(true);
		frame.setLayout(new GridLayout(3, 2));
		frame.setSize(400, 400);
		for (i = 0; i < panel.length; i++) {
			frame.add(panel[i]);
		}
		button2.setBackground(Color.pink);
		button2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource().equals(button2)) {

					id2 = textfield[0].getText();
					pass2 = textfield[1].getText();

					Iterator<Bank> it = users.iterator();
					while (it.hasNext()) {
						Bank find = it.next();

						if (find.userAuth(id2, pass2)) {
							JOptionPane.showMessageDialog(null, "Your query is successful.");
							JOptionPane.showMessageDialog(null, find.show());
							frame.dispose();
							users.remove(custom_search2());
							JOptionPane.showMessageDialog(null, "Your account is successfully deleted.");
							p = 1;
							break;
						} 
						p = 0;
						index++;
					} 

					if (p == 0) {
						JOptionPane.showMessageDialog(null, "You failed to find your Info.");
						frame.dispose();
					} 
				}
			}
		});
	}

}



public class BankGraphic extends GUI2 implements ActionListener {
	
	

	public static void main(String[] args) {
		try {
			BankGraphic start = new BankGraphic();
			start.Graphic();
		} catch (Exception e) {
			System.out.println("Please insert the values correctly.");
			
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(button[0])) {
			custom_add();
		} else if (e.getSource().equals(button[1])) {
			custom_search(0);
		} else if (e.getSource().equals(button[2])) {
			custom_search(1);
		} else if (e.getSource().equals(button[3])) {
			custom_search(2);
		} else if (e.getSource().equals(button[4])) {
			custom_delete();
		} else if (e.getSource().equals(button[5])) {
			int result = JOptionPane.showConfirmDialog(null, "Do you want to exit?", "Confirmation", JOptionPane.YES_NO_OPTION);
			if (result == JOptionPane.YES_OPTION) {
				JOptionPane.showMessageDialog(null, "The system terminates.");
				System.exit(0);
			} else if (result == JOptionPane.NO_OPTION) {
				JOptionPane.showMessageDialog(null, "The system does not close.");
			}
		}

	}
}
	
