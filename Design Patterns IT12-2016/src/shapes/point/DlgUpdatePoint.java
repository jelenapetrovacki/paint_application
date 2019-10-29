package shapes.point;

import javax.swing.JDialog;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import javax.swing.SwingConstants;

import controller.DrawingController;

import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JColorChooser;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;
import javax.swing.Box;
import java.awt.Dimension;



public class DlgUpdatePoint extends JDialog {
	private JTextField txtXposition;
	private JTextField txtYposition;
	private int Xposition;
	private int Yposition;
	private Point point;
	private boolean updateCanceled = false;
	private JButton btnBorderColor;
	
	private Color borderColor;
	
	public static void main(String[] args) {
		try {
			DlgUpdatePoint dialog = new DlgUpdatePoint();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public DlgUpdatePoint() {
		setTitle("Update point");
		setModal(true);
		setBounds(100, 100, 400, 150);
		JPanel pnlUpdatePoint = new JPanel();
		getContentPane().add(pnlUpdatePoint, BorderLayout.CENTER);
		GridBagLayout gbl_pnlUpdatePoint = new GridBagLayout();
		gbl_pnlUpdatePoint.columnWidths = new int[]{161, 129, 0};
		gbl_pnlUpdatePoint.rowHeights = new int[]{33, 0, 0, 0};
		gbl_pnlUpdatePoint.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_pnlUpdatePoint.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		pnlUpdatePoint.setLayout(gbl_pnlUpdatePoint);
		
		JLabel lblXkoor = new JLabel("X position:");
		lblXkoor.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblXkoor = new GridBagConstraints();
		gbc_lblXkoor.anchor = GridBagConstraints.EAST;
		gbc_lblXkoor.insets = new Insets(0, 0, 5, 5);
		gbc_lblXkoor.gridx = 0;
		gbc_lblXkoor.gridy = 0;
		pnlUpdatePoint.add(lblXkoor, gbc_lblXkoor);
		
		txtXposition = new JTextField();
		GridBagConstraints gbc_txtXposition = new GridBagConstraints();
		gbc_txtXposition.insets = new Insets(0, 0, 5, 0);
		gbc_txtXposition.gridx = 1;
		gbc_txtXposition.gridy = 0;
		pnlUpdatePoint.add(txtXposition, gbc_txtXposition);
		txtXposition.setColumns(10);
		
		JLabel lblYkoor = new JLabel("Y position:");
		GridBagConstraints gbc_lblYkoor = new GridBagConstraints();
		gbc_lblYkoor.anchor = GridBagConstraints.EAST;
		gbc_lblYkoor.insets = new Insets(0, 0, 5, 5);
		gbc_lblYkoor.gridx = 0;
		gbc_lblYkoor.gridy = 1;
		pnlUpdatePoint.add(lblYkoor, gbc_lblYkoor);
		
		txtYposition = new JTextField();
		GridBagConstraints gbc_txtYposition = new GridBagConstraints();
		gbc_txtYposition.insets = new Insets(0, 0, 5, 0);
		gbc_txtYposition.gridx = 1;
		gbc_txtYposition.gridy = 1;
		pnlUpdatePoint.add(txtYposition, gbc_txtYposition);
		txtYposition.setColumns(10);
		
		btnBorderColor = new JButton("Border Color");
		btnBorderColor.setForeground(Color.WHITE);
		btnBorderColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnBorderColor.setBackground(JColorChooser.showDialog(null, "Choose color", btnBorderColor.getBackground()));
			}
		});
		btnBorderColor.setBackground(Color.BLACK);
		GridBagConstraints gbc_btnBorderColor = new GridBagConstraints();
		gbc_btnBorderColor.gridx = 1;
		gbc_btnBorderColor.gridy = 2;
		pnlUpdatePoint.add(btnBorderColor, gbc_btnBorderColor);
		
		JPanel pnlButtonsPoint = new JPanel();
		getContentPane().add(pnlButtonsPoint, BorderLayout.SOUTH);
		GridBagLayout gbl_pnlButtonsPoint = new GridBagLayout();
		gbl_pnlButtonsPoint.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 76, 81, 0};
		gbl_pnlButtonsPoint.rowHeights = new int[]{0, 0};
		gbl_pnlButtonsPoint.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_pnlButtonsPoint.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		pnlButtonsPoint.setLayout(gbl_pnlButtonsPoint);
		
		JButton btnCancelPoint = new JButton("Cancel");
		btnCancelPoint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateCanceled = true;
				dispose();
			}
		});
		
		JButton btnUpdatePoint = new JButton("Update point");
		btnUpdatePoint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Xposition = Integer.parseInt(txtXposition.getText());
					Yposition = Integer.parseInt(txtYposition.getText());
					borderColor = btnBorderColor.getBackground();
					point = new Point(Xposition,Yposition,borderColor);
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
		
		Component rigidArea_7 = Box.createRigidArea(new Dimension(20, 20));
		GridBagConstraints gbc_rigidArea_7 = new GridBagConstraints();
		gbc_rigidArea_7.insets = new Insets(0, 0, 0, 5);
		gbc_rigidArea_7.gridx = 0;
		gbc_rigidArea_7.gridy = 0;
		pnlButtonsPoint.add(rigidArea_7, gbc_rigidArea_7);
		
		Component rigidArea = Box.createRigidArea(new Dimension(20, 20));
		GridBagConstraints gbc_rigidArea = new GridBagConstraints();
		gbc_rigidArea.insets = new Insets(0, 0, 0, 5);
		gbc_rigidArea.gridx = 1;
		gbc_rigidArea.gridy = 0;
		pnlButtonsPoint.add(rigidArea, gbc_rigidArea);
		
		Component rigidArea_1 = Box.createRigidArea(new Dimension(20, 20));
		GridBagConstraints gbc_rigidArea_1 = new GridBagConstraints();
		gbc_rigidArea_1.insets = new Insets(0, 0, 0, 5);
		gbc_rigidArea_1.gridx = 2;
		gbc_rigidArea_1.gridy = 0;
		pnlButtonsPoint.add(rigidArea_1, gbc_rigidArea_1);
		
		Component rigidArea_2 = Box.createRigidArea(new Dimension(20, 20));
		GridBagConstraints gbc_rigidArea_2 = new GridBagConstraints();
		gbc_rigidArea_2.insets = new Insets(0, 0, 0, 5);
		gbc_rigidArea_2.gridx = 3;
		gbc_rigidArea_2.gridy = 0;
		pnlButtonsPoint.add(rigidArea_2, gbc_rigidArea_2);
		
		Component rigidArea_3 = Box.createRigidArea(new Dimension(20, 20));
		GridBagConstraints gbc_rigidArea_3 = new GridBagConstraints();
		gbc_rigidArea_3.insets = new Insets(0, 0, 0, 5);
		gbc_rigidArea_3.gridx = 4;
		gbc_rigidArea_3.gridy = 0;
		pnlButtonsPoint.add(rigidArea_3, gbc_rigidArea_3);
		
		Component rigidArea_4 = Box.createRigidArea(new Dimension(20, 20));
		GridBagConstraints gbc_rigidArea_4 = new GridBagConstraints();
		gbc_rigidArea_4.insets = new Insets(0, 0, 0, 5);
		gbc_rigidArea_4.gridx = 5;
		gbc_rigidArea_4.gridy = 0;
		pnlButtonsPoint.add(rigidArea_4, gbc_rigidArea_4);
		
		Component rigidArea_5 = Box.createRigidArea(new Dimension(20, 20));
		GridBagConstraints gbc_rigidArea_5 = new GridBagConstraints();
		gbc_rigidArea_5.insets = new Insets(0, 0, 0, 5);
		gbc_rigidArea_5.gridx = 6;
		gbc_rigidArea_5.gridy = 0;
		pnlButtonsPoint.add(rigidArea_5, gbc_rigidArea_5);
		
		Component rigidArea_6 = Box.createRigidArea(new Dimension(20, 20));
		GridBagConstraints gbc_rigidArea_6 = new GridBagConstraints();
		gbc_rigidArea_6.insets = new Insets(0, 0, 0, 5);
		gbc_rigidArea_6.gridx = 7;
		gbc_rigidArea_6.gridy = 0;
		pnlButtonsPoint.add(rigidArea_6, gbc_rigidArea_6);
		GridBagConstraints gbc_btnUpdatePoint = new GridBagConstraints();
		gbc_btnUpdatePoint.insets = new Insets(0, 0, 0, 5);
		gbc_btnUpdatePoint.gridx = 8;
		gbc_btnUpdatePoint.gridy = 0;
		pnlButtonsPoint.add(btnUpdatePoint, gbc_btnUpdatePoint);
		btnUpdatePoint.setActionCommand("OK");
		getRootPane().setDefaultButton(btnUpdatePoint);
		GridBagConstraints gbc_btnCancelPoint = new GridBagConstraints();
		gbc_btnCancelPoint.gridx = 9;
		gbc_btnCancelPoint.gridy = 0;
		pnlButtonsPoint.add(btnCancelPoint, gbc_btnCancelPoint);
		btnCancelPoint.setActionCommand("Cancel");
		pnlButtonsPoint.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{btnUpdatePoint, btnCancelPoint}));
	}
	public int getXposition() {
		return Xposition;
	}
	public void setXposition(int xposition) {
		Xposition = xposition;
	}
	public int getYposition() {
		return Yposition;
	}
	public void setYposition(int yposition) {
		Yposition = yposition;
	}
	public Point getPoint() {
		return point;
	}
	public void setPoint(Point point) {
		this.point = point;
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
	public JButton getBtnBorderColor() {
		return btnBorderColor;
	}
	public void setBtnBorderColor(JButton btnBorderColor) {
		this.btnBorderColor = btnBorderColor;
	}

}
