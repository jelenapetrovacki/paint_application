package shapes.hexagon;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import shapes.rectangle.DlgUpdateRectangle;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Component;
import javax.swing.Box;
import java.awt.Dimension;

public class DlgUpdateHexagon extends JDialog {
	private JTextField txtXpositon;
	private JTextField txtYposition;
	private int x;
	private int y;
	private int radius;
	private JTextField txtRadius;
	private boolean updateCanceled = false;
	private JButton btnAreaColor;
	private JButton btnBorderColor;
	private Color borderColor;
	private Color areaColor;
	
	public DlgUpdateHexagon() {
		setTitle("Update hexagon");
		setModal(true);
		setBounds(100, 100, 400, 200);
		JPanel pnlUpdateHexagon = new JPanel();
		getContentPane().add(pnlUpdateHexagon, BorderLayout.CENTER);
		GridBagLayout gbl_pnlUpdateHexagon = new GridBagLayout();
		gbl_pnlUpdateHexagon.columnWidths = new int[]{84};
		gbl_pnlUpdateHexagon.rowHeights = new int[]{0, 0, 0};
		gbl_pnlUpdateHexagon.columnWeights = new double[]{0.0};
		gbl_pnlUpdateHexagon.rowWeights = new double[]{0.0, 0.0, 0.0};
		pnlUpdateHexagon.setLayout(gbl_pnlUpdateHexagon);
		
		JLabel lblXposition = new JLabel("X position");
		GridBagConstraints gbc_lblXposition = new GridBagConstraints();
		gbc_lblXposition.fill = GridBagConstraints.VERTICAL;
		gbc_lblXposition.anchor = GridBagConstraints.EAST;
		gbc_lblXposition.insets = new Insets(0, 0, 5, 5);
		gbc_lblXposition.gridx = 0;
		gbc_lblXposition.gridy = 0;
		pnlUpdateHexagon.add(lblXposition, gbc_lblXposition);
		
		txtXpositon = new JTextField();
		GridBagConstraints gbc_txtXpositon = new GridBagConstraints();
		gbc_txtXpositon.insets = new Insets(0, 0, 5, 0);
		gbc_txtXpositon.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtXpositon.gridx = 1;
		gbc_txtXpositon.gridy = 0;
		pnlUpdateHexagon.add(txtXpositon, gbc_txtXpositon);
		txtXpositon.setColumns(10);
		
		JLabel lblYposition = new JLabel("Y position");
		GridBagConstraints gbc_lblYposition = new GridBagConstraints();
		gbc_lblYposition.anchor = GridBagConstraints.EAST;
		gbc_lblYposition.insets = new Insets(0, 0, 5, 5);
		gbc_lblYposition.gridx = 0;
		gbc_lblYposition.gridy = 1;
		pnlUpdateHexagon.add(lblYposition, gbc_lblYposition);
		
		txtYposition = new JTextField();
		GridBagConstraints gbc_txtYposition = new GridBagConstraints();
		gbc_txtYposition.insets = new Insets(0, 0, 5, 0);
		gbc_txtYposition.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtYposition.gridx = 1;
		gbc_txtYposition.gridy = 1;
		pnlUpdateHexagon.add(txtYposition, gbc_txtYposition);
		txtYposition.setColumns(10);
		
		JLabel lblRadius = new JLabel("Radius");
		GridBagConstraints gbc_lblRadius = new GridBagConstraints();
		gbc_lblRadius.anchor = GridBagConstraints.EAST;
		gbc_lblRadius.insets = new Insets(0, 0, 5, 5);
		gbc_lblRadius.gridx = 0;
		gbc_lblRadius.gridy = 2;
		pnlUpdateHexagon.add(lblRadius, gbc_lblRadius);
		gbc_txtYposition.insets = new Insets(0, 0, 5, 0);
		gbc_txtYposition.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtYposition.gridx = 1;
		gbc_txtYposition.gridy = 2;
		
		txtRadius = new JTextField();
		GridBagConstraints gbc_txtRadius = new GridBagConstraints();
		gbc_txtRadius.insets = new Insets(0, 0, 5, 0);
		gbc_txtRadius.gridx = 1;
		gbc_txtRadius.gridy = 2;
		pnlUpdateHexagon.add(txtRadius, gbc_txtRadius);
		txtRadius.setColumns(10);
		
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
		pnlUpdateHexagon.add(btnBorderColor, gbc_btnBorderColor);
		
		btnAreaColor = new JButton("AreaColor");
		btnAreaColor.setBackground(Color.WHITE);
		btnAreaColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnAreaColor.setBackground(JColorChooser.showDialog(null, "Choose color", btnAreaColor.getBackground()));
			}
		});
		GridBagConstraints gbc_btnAreaColor = new GridBagConstraints();
		gbc_btnAreaColor.gridx = 1;
		gbc_btnAreaColor.gridy = 4;
		pnlUpdateHexagon.add(btnAreaColor, gbc_btnAreaColor);
		
		JPanel pnlButtons = new JPanel();
		getContentPane().add(pnlButtons, BorderLayout.SOUTH);
		GridBagLayout gbl_pnlButtons = new GridBagLayout();
		gbl_pnlButtons.columnWidths = new int[]{0};
		gbl_pnlButtons.rowHeights = new int[]{0};
		gbl_pnlButtons.columnWeights = new double[]{Double.MIN_VALUE};
		gbl_pnlButtons.rowWeights = new double[]{Double.MIN_VALUE};
		pnlButtons.setLayout(gbl_pnlButtons);
		
		JButton btnUpdateHexagon = new JButton("Update Hexagon");
		btnUpdateHexagon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					x = Integer.parseInt(txtXpositon.getText());
					y = Integer.parseInt(txtYposition.getText());
					radius=Integer.parseInt( txtRadius.getText());
					borderColor = btnBorderColor.getBackground();
					areaColor = btnAreaColor.getBackground();
					
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
		gbc_rigidArea_1.gridx = 8;
		gbc_rigidArea_1.gridy = 0;
		pnlButtons.add(rigidArea_1, gbc_rigidArea_1);
		GridBagConstraints gbc_btnUpdateHexagon = new GridBagConstraints();
		gbc_btnUpdateHexagon.insets = new Insets(0, 0, 0, 5);
		gbc_btnUpdateHexagon.gridx = 9;
		gbc_btnUpdateHexagon.gridy = 0;
		pnlButtons.add(btnUpdateHexagon, gbc_btnUpdateHexagon);
		btnUpdateHexagon.setActionCommand("OK");
		
		getRootPane().setDefaultButton(btnUpdateHexagon);
		
		JButton btnCancelHexagon = new JButton("Cancel");
		btnCancelHexagon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateCanceled = true;
				dispose();
			}
		});
		GridBagConstraints gbc_btnCancelHexagon = new GridBagConstraints();
		gbc_btnCancelHexagon.gridx = 10;
		gbc_btnCancelHexagon.gridy = 0;
		pnlButtons.add(btnCancelHexagon, gbc_btnCancelHexagon);
		btnCancelHexagon.setActionCommand("Cancel");
	}
	public static void main(String[] args) {
		try {
			DlgUpdateHexagon dialog = new DlgUpdateHexagon();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
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
}
