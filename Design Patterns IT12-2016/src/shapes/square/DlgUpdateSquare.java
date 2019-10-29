package shapes.square;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import shapes.circle.DlgUpdateCircle;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.SwingConstants;
import java.awt.Component;
import javax.swing.Box;
import java.awt.Dimension;

public class DlgUpdateSquare extends JDialog{
	private JTextField txtXposition;
	private JTextField txtYposition;
	private JTextField txtSide;
	
	private int Xposition;
	private int Yposition;
	private int Side;
	private boolean updateCanceled = false;
	private JButton btnAreaColor;
	private JButton btnBorderColor;
	private Color borderColorSq;
	private Color areaColorSq;
	
	public static void main(String[] args) {
		try {
			DlgUpdateSquare dialog = new DlgUpdateSquare();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public DlgUpdateSquare() {
		setTitle("Update square");
		setModal(true);
		setBounds(100, 100, 400, 220);
		JPanel pnlUpdateSquare = new JPanel();
		getContentPane().add(pnlUpdateSquare, BorderLayout.CENTER);
		GridBagLayout gbl_pnlUpdateSquare = new GridBagLayout();
		gbl_pnlUpdateSquare.columnWidths = new int[]{63};
		gbl_pnlUpdateSquare.rowHeights = new int[]{0, 32, 34, 32};
		gbl_pnlUpdateSquare.columnWeights = new double[]{0.0};
		gbl_pnlUpdateSquare.rowWeights = new double[]{Double.MIN_VALUE, 0.0, 0.0, 0.0};
		pnlUpdateSquare.setLayout(gbl_pnlUpdateSquare);
		
		JLabel lblXpos = new JLabel("X position:");
		lblXpos.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_lblXpos = new GridBagConstraints();
		gbc_lblXpos.anchor = GridBagConstraints.EAST;
		gbc_lblXpos.insets = new Insets(0, 0, 5, 5);
		gbc_lblXpos.gridx = 0;
		gbc_lblXpos.gridy = 1;
		pnlUpdateSquare.add(lblXpos, gbc_lblXpos);
		
		txtXposition = new JTextField();
		GridBagConstraints gbc_txtXposition = new GridBagConstraints();
		gbc_txtXposition.anchor = GridBagConstraints.WEST;
		gbc_txtXposition.insets = new Insets(0, 0, 5, 0);
		gbc_txtXposition.gridx = 1;
		gbc_txtXposition.gridy = 1;
		pnlUpdateSquare.add(txtXposition, gbc_txtXposition);
		txtXposition.setColumns(10);
		
		JLabel lblYpos = new JLabel("Y position:");
		GridBagConstraints gbc_lblYpos = new GridBagConstraints();
		gbc_lblYpos.anchor = GridBagConstraints.EAST;
		gbc_lblYpos.insets = new Insets(0, 0, 5, 5);
		gbc_lblYpos.gridx = 0;
		gbc_lblYpos.gridy = 2;
		pnlUpdateSquare.add(lblYpos, gbc_lblYpos);
		
		txtYposition = new JTextField();
		GridBagConstraints gbc_txtYposition = new GridBagConstraints();
		gbc_txtYposition.insets = new Insets(0, 0, 5, 0);
		gbc_txtYposition.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtYposition.gridx = 1;
		gbc_txtYposition.gridy = 2;
		pnlUpdateSquare.add(txtYposition, gbc_txtYposition);
		txtYposition.setColumns(10);
		
		JLabel lblSide = new JLabel("Side:");
		GridBagConstraints gbc_lblRadius = new GridBagConstraints();
		gbc_lblRadius.anchor = GridBagConstraints.EAST;
		gbc_lblRadius.insets = new Insets(0, 0, 5, 5);
		gbc_lblRadius.gridx = 0;
		gbc_lblRadius.gridy = 3;
		pnlUpdateSquare.add(lblSide, gbc_lblRadius);
		
		txtSide = new JTextField();
		GridBagConstraints gbc_txtRadius = new GridBagConstraints();
		gbc_txtRadius.insets = new Insets(0, 0, 5, 0);
		gbc_txtRadius.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtRadius.gridx = 1;
		gbc_txtRadius.gridy = 3;
		pnlUpdateSquare.add(txtSide, gbc_txtRadius);
		txtSide.setColumns(10);
		
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
		gbc_btnBorderColor.gridy = 4;
		pnlUpdateSquare.add(btnBorderColor, gbc_btnBorderColor);
		
		btnAreaColor = new JButton("AreaColor");
		btnAreaColor.setBackground(Color.WHITE);
		btnAreaColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnAreaColor.setBackground(JColorChooser.showDialog(null, "Choose color", btnAreaColor.getBackground()));
			}
		});
		GridBagConstraints gbc_btnAreaColor = new GridBagConstraints();
		gbc_btnAreaColor.gridx = 1;
		gbc_btnAreaColor.gridy = 5;
		pnlUpdateSquare.add(btnAreaColor, gbc_btnAreaColor);
		
		JPanel pnlButtons = new JPanel();
		getContentPane().add(pnlButtons, BorderLayout.SOUTH);
		GridBagLayout gbl_pnlButtons = new GridBagLayout();
		gbl_pnlButtons.columnWidths = new int[]{0, 0, 0};
		gbl_pnlButtons.rowHeights = new int[]{0};
		gbl_pnlButtons.columnWeights = new double[]{Double.MIN_VALUE, 0.0, 0.0};
		gbl_pnlButtons.rowWeights = new double[]{Double.MIN_VALUE};
		pnlButtons.setLayout(gbl_pnlButtons);
		
		JButton btnUpdateSquare = new JButton("Update Square");
		btnUpdateSquare.addActionListener(new ActionListener() {
			

			public void actionPerformed(ActionEvent e) {
				try {
					Xposition = Integer.parseInt(txtXposition.getText());
					Yposition = Integer.parseInt(txtYposition.getText());
					Side=Integer.parseInt(txtSide.getText());
					
					borderColorSq = btnBorderColor.getBackground();
					areaColorSq = btnAreaColor.getBackground();
					
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
		gbc_rigidArea.gridx = 2;
		gbc_rigidArea.gridy = 0;
		pnlButtons.add(rigidArea, gbc_rigidArea);
		
		Component rigidArea_1 = Box.createRigidArea(new Dimension(20, 20));
		GridBagConstraints gbc_rigidArea_1 = new GridBagConstraints();
		gbc_rigidArea_1.insets = new Insets(0, 0, 0, 5);
		gbc_rigidArea_1.gridx = 9;
		gbc_rigidArea_1.gridy = 0;
		pnlButtons.add(rigidArea_1, gbc_rigidArea_1);
		GridBagConstraints gbc_btnUpdateSquare = new GridBagConstraints();
		gbc_btnUpdateSquare.insets = new Insets(0, 0, 0, 5);
		gbc_btnUpdateSquare.gridx = 10;
		gbc_btnUpdateSquare.gridy = 0;
		pnlButtons.add(btnUpdateSquare, gbc_btnUpdateSquare);
		btnUpdateSquare.setActionCommand("OK");
		
		getRootPane().setDefaultButton(btnUpdateSquare);
		
		JButton btnCancelSquare = new JButton("Cancel");
		btnCancelSquare.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateCanceled = true;
				dispose();
			}
		});
		GridBagConstraints gbc_btnCancelSquare = new GridBagConstraints();
		gbc_btnCancelSquare.gridx = 11;
		gbc_btnCancelSquare.gridy = 0;
		pnlButtons.add(btnCancelSquare, gbc_btnCancelSquare);
		btnCancelSquare.setActionCommand("Cancel");
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
	public int getSide() {
		return Side;
	}
	public void setSide(int side) {
		Side = side;
	}
	public boolean isUpdateCanceled() {
		return updateCanceled;
	}
	public void setUpdateCanceled(boolean updateCanceled) {
		this.updateCanceled = updateCanceled;
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
	public JTextField getTxtSide() {
		return txtSide;
	}
	public void setTxtSide(JTextField txtSide) {
		this.txtSide = txtSide;
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
	public Color getBorderColorSq() {
		return borderColorSq;
	}
	public void setBorderColorSq(Color borderColorSq) {
		this.borderColorSq = borderColorSq;
	}
	public Color getAreaColorSq() {
		return areaColorSq;
	}
	public void setAreaColorSq(Color areaColorSq) {
		this.areaColorSq = areaColorSq;
	}

}
