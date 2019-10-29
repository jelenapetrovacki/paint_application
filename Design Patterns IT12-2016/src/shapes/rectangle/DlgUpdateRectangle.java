package shapes.rectangle;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;

import shapes.point.Point;
import shapes.square.DlgUpdateSquare;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Component;
import javax.swing.Box;
import java.awt.Dimension;

public class DlgUpdateRectangle extends JDialog {
	private JTextField txtXpositon;
	private JTextField txtYposition;
	private JTextField txtSideLength;
	private JTextField txtSideWidth;
	private int Xposition;
	private int Yposition;
	private int sideLength;
	private int sideWidth;
	private boolean updateCanceled;
	private JButton btnAreaColor;
	private JButton btnBorderColor;
	private Color borderColor;
	private Color areaColor;
	
	public DlgUpdateRectangle() {
		setTitle("Update rectangle");
		setModal(true);
		setBounds(100, 100, 400, 220);
		JPanel pnlUpdateRec = new JPanel();
		getContentPane().add(pnlUpdateRec, BorderLayout.NORTH);
		GridBagLayout gbl_pnlUpdateRec = new GridBagLayout();
		gbl_pnlUpdateRec.columnWidths = new int[]{137, 109, 0};
		gbl_pnlUpdateRec.rowHeights = new int[]{14, 14, 14, 14, 14, 14, 0};
		gbl_pnlUpdateRec.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_pnlUpdateRec.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		pnlUpdateRec.setLayout(gbl_pnlUpdateRec);
		
		JLabel lblXposition = new JLabel("X position");
		GridBagConstraints gbc_lblXposition = new GridBagConstraints();
		gbc_lblXposition.anchor = GridBagConstraints.EAST;
		gbc_lblXposition.insets = new Insets(0, 0, 5, 5);
		gbc_lblXposition.gridx = 0;
		gbc_lblXposition.gridy = 0;
		pnlUpdateRec.add(lblXposition, gbc_lblXposition);
		
		txtXpositon = new JTextField();
		GridBagConstraints gbc_txtXpositon = new GridBagConstraints();
		gbc_txtXpositon.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtXpositon.insets = new Insets(0, 0, 5, 0);
		gbc_txtXpositon.gridx = 1;
		gbc_txtXpositon.gridy = 0;
		pnlUpdateRec.add(txtXpositon, gbc_txtXpositon);
		txtXpositon.setColumns(10);
		
		JLabel lblYposition = new JLabel("Y position");
		GridBagConstraints gbc_lblYposition = new GridBagConstraints();
		gbc_lblYposition.anchor = GridBagConstraints.EAST;
		gbc_lblYposition.insets = new Insets(0, 0, 5, 5);
		gbc_lblYposition.gridx = 0;
		gbc_lblYposition.gridy = 1;
		pnlUpdateRec.add(lblYposition, gbc_lblYposition);
		
		txtYposition = new JTextField();
		GridBagConstraints gbc_txtYposition = new GridBagConstraints();
		gbc_txtYposition.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtYposition.insets = new Insets(0, 0, 5, 0);
		gbc_txtYposition.gridx = 1;
		gbc_txtYposition.gridy = 1;
		pnlUpdateRec.add(txtYposition, gbc_txtYposition);
		txtYposition.setColumns(10);
		
		JLabel lblSideLength = new JLabel("Side length");
		GridBagConstraints gbc_lblSideLength = new GridBagConstraints();
		gbc_lblSideLength.anchor = GridBagConstraints.EAST;
		gbc_lblSideLength.insets = new Insets(0, 0, 5, 5);
		gbc_lblSideLength.gridx = 0;
		gbc_lblSideLength.gridy = 2;
		pnlUpdateRec.add(lblSideLength, gbc_lblSideLength);
		
		txtSideLength = new JTextField();
		GridBagConstraints gbc_txtSideLength = new GridBagConstraints();
		gbc_txtSideLength.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtSideLength.insets = new Insets(0, 0, 5, 0);
		gbc_txtSideLength.gridx = 1;
		gbc_txtSideLength.gridy = 2;
		pnlUpdateRec.add(txtSideLength, gbc_txtSideLength);
		txtSideLength.setColumns(10);
		
		JLabel lblSideWidth = new JLabel("Side width");
		GridBagConstraints gbc_lblSideWidth = new GridBagConstraints();
		gbc_lblSideWidth.anchor = GridBagConstraints.NORTHEAST;
		gbc_lblSideWidth.insets = new Insets(0, 0, 5, 5);
		gbc_lblSideWidth.gridx = 0;
		gbc_lblSideWidth.gridy = 3;
		pnlUpdateRec.add(lblSideWidth, gbc_lblSideWidth);
		
		txtSideWidth = new JTextField();
		GridBagConstraints gbc_txtSideWidth = new GridBagConstraints();
		gbc_txtSideWidth.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtSideWidth.insets = new Insets(0, 0, 5, 0);
		gbc_txtSideWidth.gridx = 1;
		gbc_txtSideWidth.gridy = 3;
		pnlUpdateRec.add(txtSideWidth, gbc_txtSideWidth);
		txtSideWidth.setColumns(10);
		
		btnBorderColor = new JButton("BorderColor");
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
		gbc_btnBorderColor.gridx = 1;
		gbc_btnBorderColor.gridy = 4;
		pnlUpdateRec.add(btnBorderColor, gbc_btnBorderColor);
		
		btnAreaColor = new JButton("AreaColor");
		btnAreaColor.setBackground(Color.WHITE);
		btnAreaColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnAreaColor.setBackground(JColorChooser.showDialog(null, "Choose color", btnAreaColor.getBackground()));
			}
		});
		GridBagConstraints gbc_btnAreaColor = new GridBagConstraints();
		gbc_btnAreaColor.anchor = GridBagConstraints.WEST;
		gbc_btnAreaColor.gridx = 1;
		gbc_btnAreaColor.gridy = 5;
		pnlUpdateRec.add(btnAreaColor, gbc_btnAreaColor);
		
		JPanel pnlButtons = new JPanel();
		getContentPane().add(pnlButtons, BorderLayout.SOUTH);
		GridBagLayout gbl_pnlButtons = new GridBagLayout();
		gbl_pnlButtons.columnWidths = new int[]{0, 0};
		gbl_pnlButtons.rowHeights = new int[]{0};
		gbl_pnlButtons.columnWeights = new double[]{Double.MIN_VALUE, 0.0};
		gbl_pnlButtons.rowWeights = new double[]{Double.MIN_VALUE};
		pnlButtons.setLayout(gbl_pnlButtons);
		
		
		JButton btnUpdateRec = new JButton("Update rectagle");
		btnUpdateRec.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Xposition = Integer.parseInt(txtXpositon.getText());
					Yposition = Integer.parseInt(txtYposition.getText());
					sideLength=Integer.parseInt(txtSideLength.getText());
					sideWidth=Integer.parseInt(txtSideWidth.getText());
					borderColor=btnBorderColor.getBackground();
					areaColor=btnAreaColor.getBackground();
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
		gbc_rigidArea_1.gridx = 7;
		gbc_rigidArea_1.gridy = 0;
		pnlButtons.add(rigidArea_1, gbc_rigidArea_1);
		GridBagConstraints gbc_btnUpdateRec = new GridBagConstraints();
		gbc_btnUpdateRec.insets = new Insets(0, 0, 0, 5);
		gbc_btnUpdateRec.gridx = 8;
		gbc_btnUpdateRec.gridy = 0;
		pnlButtons.add(btnUpdateRec, gbc_btnUpdateRec);
		btnUpdateRec.setActionCommand("OK");
		
		getRootPane().setDefaultButton(btnUpdateRec);
		
		JButton btnCancelRec = new JButton("Cancel");
		btnCancelRec.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateCanceled = true;
				dispose();
			}
		});
		GridBagConstraints gbc_btnCancelRec = new GridBagConstraints();
		gbc_btnCancelRec.gridx = 9;
		gbc_btnCancelRec.gridy = 0;
		pnlButtons.add(btnCancelRec, gbc_btnCancelRec);
		btnCancelRec.setActionCommand("Cancel");
	}

	public static void main(String[] args) {
		try {
			DlgUpdateRectangle dialog = new DlgUpdateRectangle();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
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

	public int getSideLength() {
		return sideLength;
	}

	public void setSideLength(int sideLength) {
		this.sideLength = sideLength;
	}

	public int getSideWidth() {
		return sideWidth;
	}

	public void setSideWidth(int sideWidth) {
		this.sideWidth = sideWidth;
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

	public JTextField getTxtXpositon() {
		return txtXpositon;
	}

	public void setTxtXpositon(JTextField txtXpositon) {
		this.txtXpositon = txtXpositon;
	}

	public JTextField getTxtYposition() {
		return txtYposition;
	}

	public void setTxtYposition(JTextField txtYposition) {
		this.txtYposition = txtYposition;
	}

	public JTextField getTxtSideLength() {
		return txtSideLength;
	}

	public void setTxtSideLength(JTextField txtSideLength) {
		this.txtSideLength = txtSideLength;
	}

	public JTextField getTxtSideWidth() {
		return txtSideWidth;
	}

	public void setTxtSideWidth(JTextField txtSideWidth) {
		this.txtSideWidth = txtSideWidth;
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
	
}
