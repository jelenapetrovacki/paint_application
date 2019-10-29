package shapes.line;

import javax.swing.JDialog;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import javax.swing.JColorChooser;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;



import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Component;
import javax.swing.Box;
import java.awt.Dimension;

public class DlgUpdateLine extends JDialog{
	private JTextField txtStartX;
	private JTextField txtStartY;
	private JTextField txtEndX;
	private JTextField txtEndY;
	private int startX;
	private int startY;
	private int endX;
	private int endY;
	private boolean updateCanceled = false;
	private Color borderColor;
	private JButton btnBorderColor;
	
	public static void main(String[] args) {
		try {
			DlgUpdateLine dialog = new DlgUpdateLine();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public DlgUpdateLine() {
		setTitle("Update line");
		setModal(true);
		setBounds(100, 100, 400, 200);
		JPanel pnlUpdateLine = new JPanel();
		getContentPane().add(pnlUpdateLine, BorderLayout.CENTER);
		GridBagLayout gbl_pnlUpdateLine = new GridBagLayout();
		gbl_pnlUpdateLine.columnWidths = new int[]{78, 70, 0, 0};
		gbl_pnlUpdateLine.rowHeights = new int[]{0, 0, 0, 0, 0, 13, 0, 0};
		gbl_pnlUpdateLine.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_pnlUpdateLine.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		pnlUpdateLine.setLayout(gbl_pnlUpdateLine);
		
		JLabel lblStartP = new JLabel("Start point");
		GridBagConstraints gbc_lblStartP = new GridBagConstraints();
		gbc_lblStartP.insets = new Insets(0, 0, 5, 5);
		gbc_lblStartP.gridx = 0;
		gbc_lblStartP.gridy = 1;
		pnlUpdateLine.add(lblStartP, gbc_lblStartP);
		
		JLabel lblStartX = new JLabel("X position:");
		GridBagConstraints gbc_lblStartX = new GridBagConstraints();
		gbc_lblStartX.anchor = GridBagConstraints.EAST;
		gbc_lblStartX.insets = new Insets(0, 0, 5, 5);
		gbc_lblStartX.gridx = 1;
		gbc_lblStartX.gridy = 1;
		pnlUpdateLine.add(lblStartX, gbc_lblStartX);
		
		txtStartX = new JTextField();
		GridBagConstraints gbc_txtStartX = new GridBagConstraints();
		gbc_txtStartX.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtStartX.insets = new Insets(0, 0, 5, 0);
		gbc_txtStartX.gridx = 2;
		gbc_txtStartX.gridy = 1;
		pnlUpdateLine.add(txtStartX, gbc_txtStartX);
		txtStartX.setColumns(10);
		
		JLabel lblStartY = new JLabel("Y position:");
		GridBagConstraints gbc_lblStartY = new GridBagConstraints();
		gbc_lblStartY.anchor = GridBagConstraints.EAST;
		gbc_lblStartY.insets = new Insets(0, 0, 5, 5);
		gbc_lblStartY.gridx = 1;
		gbc_lblStartY.gridy = 2;
		pnlUpdateLine.add(lblStartY, gbc_lblStartY);
		
		txtStartY = new JTextField();
		GridBagConstraints gbc_txtStartY = new GridBagConstraints();
		gbc_txtStartY.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtStartY.insets = new Insets(0, 0, 5, 0);
		gbc_txtStartY.gridx = 2;
		gbc_txtStartY.gridy = 2;
		pnlUpdateLine.add(txtStartY, gbc_txtStartY);
		txtStartY.setColumns(10);
		
		JLabel lblEndP = new JLabel("End point");
		GridBagConstraints gbc_lblEndP = new GridBagConstraints();
		gbc_lblEndP.insets = new Insets(0, 0, 5, 5);
		gbc_lblEndP.gridx = 0;
		gbc_lblEndP.gridy = 3;
		pnlUpdateLine.add(lblEndP, gbc_lblEndP);
		
		JLabel lblEndX = new JLabel("X position:");
		GridBagConstraints gbc_lblEndX = new GridBagConstraints();
		gbc_lblEndX.anchor = GridBagConstraints.EAST;
		gbc_lblEndX.insets = new Insets(0, 0, 5, 5);
		gbc_lblEndX.gridx = 1;
		gbc_lblEndX.gridy = 3;
		pnlUpdateLine.add(lblEndX, gbc_lblEndX);
		
		txtEndX = new JTextField();
		GridBagConstraints gbc_txtEndX = new GridBagConstraints();
		gbc_txtEndX.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtEndX.insets = new Insets(0, 0, 5, 0);
		gbc_txtEndX.gridx = 2;
		gbc_txtEndX.gridy = 3;
		pnlUpdateLine.add(txtEndX, gbc_txtEndX);
		txtEndX.setColumns(10);
		
		JLabel lblEndY = new JLabel("Y position:");
		GridBagConstraints gbc_lblEndY = new GridBagConstraints();
		gbc_lblEndY.anchor = GridBagConstraints.EAST;
		gbc_lblEndY.insets = new Insets(0, 0, 5, 5);
		gbc_lblEndY.gridx = 1;
		gbc_lblEndY.gridy = 4;
		pnlUpdateLine.add(lblEndY, gbc_lblEndY);
		
		txtEndY = new JTextField();
		GridBagConstraints gbc_txtEndY = new GridBagConstraints();
		gbc_txtEndY.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtEndY.insets = new Insets(0, 0, 5, 0);
		gbc_txtEndY.gridx = 2;
		gbc_txtEndY.gridy = 4;
		pnlUpdateLine.add(txtEndY, gbc_txtEndY);
		txtEndY.setColumns(10);
		
		btnBorderColor = new JButton("Border Color");
		btnBorderColor.setForeground(Color.WHITE);
		btnBorderColor.setBackground(Color.BLACK);
		btnBorderColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnBorderColor.setBackground(JColorChooser.showDialog(null, "Choose color", btnBorderColor.getBackground()));
			}
		});
		GridBagConstraints gbc_btnBorderColor = new GridBagConstraints();
		gbc_btnBorderColor.anchor = GridBagConstraints.WEST;
		gbc_btnBorderColor.insets = new Insets(0, 0, 5, 0);
		gbc_btnBorderColor.gridx = 2;
		gbc_btnBorderColor.gridy = 5;
		pnlUpdateLine.add(btnBorderColor, gbc_btnBorderColor);
		
		JPanel pnlButtonsLine = new JPanel();
		getContentPane().add(pnlButtonsLine, BorderLayout.SOUTH);
		GridBagLayout gbl_pnlButtonsLine = new GridBagLayout();
		gbl_pnlButtonsLine.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_pnlButtonsLine.rowHeights = new int[]{0, 0};
		gbl_pnlButtonsLine.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_pnlButtonsLine.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		pnlButtonsLine.setLayout(gbl_pnlButtonsLine);
		
		JButton btnUpdateLine = new JButton("Update Line");
		btnUpdateLine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					startX = Integer.parseInt(txtStartX.getText());
					startY = Integer.parseInt(txtStartY.getText());
					endX = Integer.parseInt(txtEndX.getText());
					endY = Integer.parseInt(txtEndY.getText());
					borderColor= btnBorderColor.getBackground();
					dispose();
				} catch (NumberFormatException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null,
							"Enter the appropriate values!",
						    "Warning",JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		
		Component rigidArea_8 = Box.createRigidArea(new Dimension(20, 20));
		GridBagConstraints gbc_rigidArea_8 = new GridBagConstraints();
		gbc_rigidArea_8.insets = new Insets(0, 0, 0, 5);
		gbc_rigidArea_8.gridx = 1;
		gbc_rigidArea_8.gridy = 0;
		pnlButtonsLine.add(rigidArea_8, gbc_rigidArea_8);
		
		Component rigidArea_7 = Box.createRigidArea(new Dimension(20, 20));
		GridBagConstraints gbc_rigidArea_7 = new GridBagConstraints();
		gbc_rigidArea_7.insets = new Insets(0, 0, 0, 5);
		gbc_rigidArea_7.gridx = 2;
		gbc_rigidArea_7.gridy = 0;
		pnlButtonsLine.add(rigidArea_7, gbc_rigidArea_7);
		
		Component rigidArea_6 = Box.createRigidArea(new Dimension(20, 20));
		GridBagConstraints gbc_rigidArea_6 = new GridBagConstraints();
		gbc_rigidArea_6.insets = new Insets(0, 0, 0, 5);
		gbc_rigidArea_6.gridx = 3;
		gbc_rigidArea_6.gridy = 0;
		pnlButtonsLine.add(rigidArea_6, gbc_rigidArea_6);
		
		Component rigidArea_5 = Box.createRigidArea(new Dimension(20, 20));
		GridBagConstraints gbc_rigidArea_5 = new GridBagConstraints();
		gbc_rigidArea_5.insets = new Insets(0, 0, 0, 5);
		gbc_rigidArea_5.gridx = 4;
		gbc_rigidArea_5.gridy = 0;
		pnlButtonsLine.add(rigidArea_5, gbc_rigidArea_5);
		
		Component rigidArea_4 = Box.createRigidArea(new Dimension(20, 20));
		GridBagConstraints gbc_rigidArea_4 = new GridBagConstraints();
		gbc_rigidArea_4.insets = new Insets(0, 0, 0, 5);
		gbc_rigidArea_4.gridx = 5;
		gbc_rigidArea_4.gridy = 0;
		pnlButtonsLine.add(rigidArea_4, gbc_rigidArea_4);
		
		Component rigidArea_3 = Box.createRigidArea(new Dimension(20, 20));
		GridBagConstraints gbc_rigidArea_3 = new GridBagConstraints();
		gbc_rigidArea_3.insets = new Insets(0, 0, 0, 5);
		gbc_rigidArea_3.gridx = 6;
		gbc_rigidArea_3.gridy = 0;
		pnlButtonsLine.add(rigidArea_3, gbc_rigidArea_3);
		
		Component rigidArea_2 = Box.createRigidArea(new Dimension(20, 20));
		GridBagConstraints gbc_rigidArea_2 = new GridBagConstraints();
		gbc_rigidArea_2.insets = new Insets(0, 0, 0, 5);
		gbc_rigidArea_2.gridx = 7;
		gbc_rigidArea_2.gridy = 0;
		pnlButtonsLine.add(rigidArea_2, gbc_rigidArea_2);
		
		Component rigidArea_1 = Box.createRigidArea(new Dimension(20, 20));
		GridBagConstraints gbc_rigidArea_1 = new GridBagConstraints();
		gbc_rigidArea_1.insets = new Insets(0, 0, 0, 5);
		gbc_rigidArea_1.gridx = 8;
		gbc_rigidArea_1.gridy = 0;
		pnlButtonsLine.add(rigidArea_1, gbc_rigidArea_1);
		GridBagConstraints gbc_btnUpdateLine = new GridBagConstraints();
		gbc_btnUpdateLine.insets = new Insets(0, 0, 0, 5);
		gbc_btnUpdateLine.gridx = 9;
		gbc_btnUpdateLine.gridy = 0;
		pnlButtonsLine.add(btnUpdateLine, gbc_btnUpdateLine);
	btnUpdateLine.setActionCommand("OK");
		
		getRootPane().setDefaultButton(btnUpdateLine);
		
		JButton btnCancelLine = new JButton("Cancel");
		btnCancelLine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateCanceled = true;
				dispose();
			}
		});
		GridBagConstraints gbc_btnCancelLine = new GridBagConstraints();
		gbc_btnCancelLine.insets = new Insets(0, 0, 0, 5);
		gbc_btnCancelLine.gridx = 10;
		gbc_btnCancelLine.gridy = 0;
		pnlButtonsLine.add(btnCancelLine, gbc_btnCancelLine);
		btnCancelLine.setActionCommand("Cancel");
	}
	public int getStartX() {
		return startX;
	}
	public void setStartX(int startX) {
		this.startX = startX;
	}
	public int getStartY() {
		return startY;
	}
	public void setStartY(int startY) {
		this.startY = startY;
	}
	public int getEndX() {
		return endX;
	}
	public void setEndX(int endX) {
		this.endX = endX;
	}
	public int getEndY() {
		return endY;
	}
	public void setEndY(int endY) {
		this.endY = endY;
	}
	public boolean isUpdateCanceled() {
		return updateCanceled;
	}
	public void setUpdateCanceled(boolean updateCanceled) {
		this.updateCanceled = updateCanceled;
	}
	public Color getBorderColor() {
		return borderColor;
	}
	public void setBorderColor(Color borderColor) {
		this.borderColor = borderColor;
	}
	public JTextField getTxtStartX() {
		return txtStartX;
	}
	public void setTxtStartX(JTextField txtStartX) {
		this.txtStartX = txtStartX;
	}
	public JTextField getTxtStartY() {
		return txtStartY;
	}
	public void setTxtStartY(JTextField txtStartY) {
		this.txtStartY = txtStartY;
	}
	public JTextField getTxtEndX() {
		return txtEndX;
	}
	public void setTxtEndX(JTextField txtEndX) {
		this.txtEndX = txtEndX;
	}
	public JTextField getTxtEndY() {
		return txtEndY;
	}
	public void setTxtEndY(JTextField txtEndY) {
		this.txtEndY = txtEndY;
	}
	public JButton getBtnBorderColor() {
		return btnBorderColor;
	}
	public void setBtnBorderColor(JButton btnBorderColor) {
		this.btnBorderColor = btnBorderColor;
	}

}
