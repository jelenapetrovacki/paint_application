package shapes.circle;

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

public class DlgUpdateCircle extends JDialog{
	private JTextField txtXposition;
	private JTextField txtYposition;
	private JTextField txtRadius;
	private int Xpositionc;
	private int Ypositionc;
	private int radius;
	private boolean updateCanceled = false;
	private JButton btnAreaColor;
	private JButton btnBorderColor;
	private Color borderColor;
	private Color areaColor;
	
	public static void main(String[] args) {
		try {
			DlgUpdateCircle dialog = new DlgUpdateCircle();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public DlgUpdateCircle() {
		setModal(true);
		setTitle("Update circle");
		setBounds(100, 100, 400, 220);
		JPanel pnlUpdateCircle = new JPanel();
		getContentPane().add(pnlUpdateCircle, BorderLayout.CENTER);
		GridBagLayout gbl_pnlUpdateCircle = new GridBagLayout();
		gbl_pnlUpdateCircle.columnWidths = new int[]{162, 0, 0};
		gbl_pnlUpdateCircle.rowHeights = new int[]{31, 25, 25, 28, 32, 0};
		gbl_pnlUpdateCircle.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_pnlUpdateCircle.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		pnlUpdateCircle.setLayout(gbl_pnlUpdateCircle);
		
		JLabel lblXpos = new JLabel("X position:");
		GridBagConstraints gbc_lblXpos = new GridBagConstraints();
		gbc_lblXpos.anchor = GridBagConstraints.EAST;
		gbc_lblXpos.insets = new Insets(0, 0, 5, 5);
		gbc_lblXpos.gridx = 0;
		gbc_lblXpos.gridy = 0;
		pnlUpdateCircle.add(lblXpos, gbc_lblXpos);
		
		txtXposition = new JTextField();
		GridBagConstraints gbc_txtXposition = new GridBagConstraints();
		gbc_txtXposition.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtXposition.insets = new Insets(0, 0, 5, 0);
		gbc_txtXposition.gridx = 1;
		gbc_txtXposition.gridy = 0;
		pnlUpdateCircle.add(txtXposition, gbc_txtXposition);
		txtXposition.setColumns(10);
		
		JLabel lblYpos = new JLabel("Y position:");
		GridBagConstraints gbc_lblYpos = new GridBagConstraints();
		gbc_lblYpos.anchor = GridBagConstraints.EAST;
		gbc_lblYpos.insets = new Insets(0, 0, 5, 5);
		gbc_lblYpos.gridx = 0;
		gbc_lblYpos.gridy = 1;
		pnlUpdateCircle.add(lblYpos, gbc_lblYpos);
		
		txtYposition = new JTextField();
		GridBagConstraints gbc_txtYposition = new GridBagConstraints();
		gbc_txtYposition.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtYposition.insets = new Insets(0, 0, 5, 0);
		gbc_txtYposition.gridx = 1;
		gbc_txtYposition.gridy = 1;
		pnlUpdateCircle.add(txtYposition, gbc_txtYposition);
		txtYposition.setColumns(10);
		
		JLabel lblRadius = new JLabel("Radius:");
		GridBagConstraints gbc_lblRadius = new GridBagConstraints();
		gbc_lblRadius.anchor = GridBagConstraints.EAST;
		gbc_lblRadius.insets = new Insets(0, 0, 5, 5);
		gbc_lblRadius.gridx = 0;
		gbc_lblRadius.gridy = 2;
		pnlUpdateCircle.add(lblRadius, gbc_lblRadius);
		
		txtRadius = new JTextField();
		GridBagConstraints gbc_txtRadius = new GridBagConstraints();
		gbc_txtRadius.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtRadius.insets = new Insets(0, 0, 5, 0);
		gbc_txtRadius.gridx = 1;
		gbc_txtRadius.gridy = 2;
		pnlUpdateCircle.add(txtRadius, gbc_txtRadius);
		txtRadius.setColumns(10);
		
		btnAreaColor = new JButton("AreaColor");
		btnAreaColor.setBackground(Color.WHITE);
		btnAreaColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnAreaColor.setBackground(JColorChooser.showDialog(null, "Choose color", btnAreaColor.getBackground()));
			}
			
		});
		
		btnBorderColor = new JButton("BorderColor");
		btnBorderColor.setForeground(Color.WHITE);
		btnBorderColor.setBackground(Color.BLACK);
		btnBorderColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnBorderColor.setBackground(JColorChooser.showDialog(null, "Choose color", btnBorderColor.getBackground()));
			}
		});
		GridBagConstraints gbc_btnBorderColor = new GridBagConstraints();
		gbc_btnBorderColor.insets = new Insets(0, 0, 5, 0);
		gbc_btnBorderColor.gridx = 1;
		gbc_btnBorderColor.gridy = 3;
		pnlUpdateCircle.add(btnBorderColor, gbc_btnBorderColor);
		GridBagConstraints gbc_btnAreaColor = new GridBagConstraints();
		gbc_btnAreaColor.gridx = 1;
		gbc_btnAreaColor.gridy = 4;
		pnlUpdateCircle.add(btnAreaColor, gbc_btnAreaColor);
		
		JPanel pnlButtons = new JPanel();
		getContentPane().add(pnlButtons, BorderLayout.SOUTH);
		GridBagLayout gbl_pnlButtons = new GridBagLayout();
		gbl_pnlButtons.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_pnlButtons.rowHeights = new int[]{0, 0};
		gbl_pnlButtons.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_pnlButtons.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		pnlButtons.setLayout(gbl_pnlButtons);
		
		JButton btnUpdateCircle = new JButton("Update circle");
		btnUpdateCircle.addActionListener(new ActionListener() {
			private int Xposition;
			private int Yposition;
			

			public void actionPerformed(ActionEvent e) {
				try {
					Xpositionc = Integer.parseInt(txtXposition.getText());
					Ypositionc = Integer.parseInt(txtYposition.getText());
					radius=Integer.parseInt( txtRadius.getText());
					borderColor = btnBorderColor.getBackground();
					areaColor = btnAreaColor.getBackground();
					System.out.println("KRug" + Xposition + Yposition);
					dispose();
				} catch (NumberFormatException err) {
					// TODO Auto-generated catch block
					err.printStackTrace();
					JOptionPane.showMessageDialog(null,
							"Enter the appropriate values!",
						    "Warning",JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		
		Component rigidArea = Box.createRigidArea(new Dimension(20, 20));
		GridBagConstraints gbc_rigidArea = new GridBagConstraints();
		gbc_rigidArea.insets = new Insets(0, 0, 0, 5);
		gbc_rigidArea.gridx = 1;
		gbc_rigidArea.gridy = 0;
		pnlButtons.add(rigidArea, gbc_rigidArea);
		
		Component rigidArea_1 = Box.createRigidArea(new Dimension(20, 20));
		GridBagConstraints gbc_rigidArea_1 = new GridBagConstraints();
		gbc_rigidArea_1.insets = new Insets(0, 0, 0, 5);
		gbc_rigidArea_1.gridx = 2;
		gbc_rigidArea_1.gridy = 0;
		pnlButtons.add(rigidArea_1, gbc_rigidArea_1);
		
		Component rigidArea_2 = Box.createRigidArea(new Dimension(20, 20));
		GridBagConstraints gbc_rigidArea_2 = new GridBagConstraints();
		gbc_rigidArea_2.insets = new Insets(0, 0, 0, 5);
		gbc_rigidArea_2.gridx = 3;
		gbc_rigidArea_2.gridy = 0;
		pnlButtons.add(rigidArea_2, gbc_rigidArea_2);
		
		Component rigidArea_3 = Box.createRigidArea(new Dimension(20, 20));
		GridBagConstraints gbc_rigidArea_3 = new GridBagConstraints();
		gbc_rigidArea_3.insets = new Insets(0, 0, 0, 5);
		gbc_rigidArea_3.gridx = 5;
		gbc_rigidArea_3.gridy = 0;
		pnlButtons.add(rigidArea_3, gbc_rigidArea_3);
		
		Component rigidArea_4 = Box.createRigidArea(new Dimension(20, 20));
		GridBagConstraints gbc_rigidArea_4 = new GridBagConstraints();
		gbc_rigidArea_4.insets = new Insets(0, 0, 0, 5);
		gbc_rigidArea_4.gridx = 7;
		gbc_rigidArea_4.gridy = 0;
		pnlButtons.add(rigidArea_4, gbc_rigidArea_4);
		
		Component rigidArea_5 = Box.createRigidArea(new Dimension(20, 20));
		GridBagConstraints gbc_rigidArea_5 = new GridBagConstraints();
		gbc_rigidArea_5.insets = new Insets(0, 0, 0, 5);
		gbc_rigidArea_5.gridx = 8;
		gbc_rigidArea_5.gridy = 0;
		pnlButtons.add(rigidArea_5, gbc_rigidArea_5);
		GridBagConstraints gbc_btnUpdateCircle = new GridBagConstraints();
		gbc_btnUpdateCircle.insets = new Insets(0, 0, 0, 5);
		gbc_btnUpdateCircle.gridx = 9;
		gbc_btnUpdateCircle.gridy = 0;
		pnlButtons.add(btnUpdateCircle, gbc_btnUpdateCircle);
		btnUpdateCircle.setActionCommand("OK");
		
		getRootPane().setDefaultButton(btnUpdateCircle);
		
		JButton btnCancelCircle = new JButton("Cancel");
		btnCancelCircle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateCanceled = true;
				dispose();
			}
		});
		GridBagConstraints gbc_btnCancelCircle = new GridBagConstraints();
		gbc_btnCancelCircle.gridx = 10;
		gbc_btnCancelCircle.gridy = 0;
		pnlButtons.add(btnCancelCircle, gbc_btnCancelCircle);
		btnCancelCircle.setActionCommand("Cancel");
	}

	public int getRadius() {
		return radius;
	}
	public void setRadius(int radius) {
		this.radius = radius;
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
	public Color getAreaColor() {
		return areaColor;
	}
	public void setAreaColor(Color areaColor) {
		this.areaColor = areaColor;
	}
	public JTextField getTxtXposition() {
		return txtXposition;
	}
	public void setTxtXposition(JTextField txtXposition) {
		this.txtXposition = txtXposition;
	}
	public JTextField getTxtYposition() {
		return txtYposition;
	}
	public void setTxtYposition(JTextField txtYposition) {
		this.txtYposition = txtYposition;
	}
	public JTextField getTxtRadius() {
		return txtRadius;
	}
	public void setTxtRadius(JTextField txtRadius) {
		this.txtRadius = txtRadius;
	}
	public JButton getBtnAreaColor() {
		return btnAreaColor;
	}
	public void setBtnAreaColor(JButton btnAreaColor) {
		this.btnAreaColor = btnAreaColor;
	}
	public JButton getBtnBorderColor() {
		return btnBorderColor;
	}
	public void setBtnBorderColor(JButton btnBorderColor) {
		this.btnBorderColor = btnBorderColor;
	}
	public int getXpositionc() {
		return Xpositionc;
	}
	public void setXpositionc(int xpositionc) {
		Xpositionc = xpositionc;
	}
	public int getYpositionc() {
		return Ypositionc;
	}
	public void setYpositionc(int ypositionc) {
		Ypositionc = ypositionc;
	}


}
