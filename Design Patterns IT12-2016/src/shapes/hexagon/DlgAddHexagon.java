package shapes.hexagon;

import javax.swing.JDialog;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import shapes.square.DlgAddSquare;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Component;
import javax.swing.Box;
import java.awt.Dimension;

public class DlgAddHexagon extends JDialog {
	private JTextField txtRadiusHexagon;
	private int radiusHexagon;
	private boolean addCanceled;
	
	public DlgAddHexagon() {
		setModal(true);
		setTitle("Add hexagon");
		setBounds(100, 100, 400, 150);
		JPanel pnlAddHexagon = new JPanel();
		getContentPane().add(pnlAddHexagon, BorderLayout.CENTER);
		GridBagLayout gbl_pnlAddHexagon = new GridBagLayout();
		gbl_pnlAddHexagon.columnWidths = new int[]{160, 0, 0};
		gbl_pnlAddHexagon.rowHeights = new int[]{85, 0};
		gbl_pnlAddHexagon.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_pnlAddHexagon.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		pnlAddHexagon.setLayout(gbl_pnlAddHexagon);
		
		JLabel lblRadiusHexagon = new JLabel("Insert radus:");
		GridBagConstraints gbc_lblRadiusHexagon = new GridBagConstraints();
		gbc_lblRadiusHexagon.insets = new Insets(0, 0, 0, 5);
		gbc_lblRadiusHexagon.anchor = GridBagConstraints.EAST;
		gbc_lblRadiusHexagon.gridx = 0;
		gbc_lblRadiusHexagon.gridy = 0;
		pnlAddHexagon.add(lblRadiusHexagon, gbc_lblRadiusHexagon);
		
		txtRadiusHexagon = new JTextField();
		GridBagConstraints gbc_txtRadiusHexagon = new GridBagConstraints();
		gbc_txtRadiusHexagon.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtRadiusHexagon.gridx = 1;
		gbc_txtRadiusHexagon.gridy = 0;
		pnlAddHexagon.add(txtRadiusHexagon, gbc_txtRadiusHexagon);
		txtRadiusHexagon.setColumns(10);
		
		JPanel pnlButtonsHexagon = new JPanel();
		getContentPane().add(pnlButtonsHexagon, BorderLayout.SOUTH);
		GridBagLayout gbl_pnlButtonsHexagon = new GridBagLayout();
		gbl_pnlButtonsHexagon.columnWidths = new int[]{172, 89, 0, 0, 0, 0, 0};
		gbl_pnlButtonsHexagon.rowHeights = new int[]{23, 0};
		gbl_pnlButtonsHexagon.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_pnlButtonsHexagon.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		pnlButtonsHexagon.setLayout(gbl_pnlButtonsHexagon);
		
		JButton btnAddHexagon = new JButton("Add hexagon");
		btnAddHexagon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					radiusHexagon =Integer.parseInt(txtRadiusHexagon.getText());
					setVisible(false);
				} catch (NumberFormatException e1) {
					JOptionPane.showMessageDialog(rootPane, "Insert the right value!");
					e1.printStackTrace();
				}
			}
		});
		
		Component rigidArea = Box.createRigidArea(new Dimension(20, 20));
		GridBagConstraints gbc_rigidArea = new GridBagConstraints();
		gbc_rigidArea.insets = new Insets(0, 0, 0, 5);
		gbc_rigidArea.gridx = 0;
		gbc_rigidArea.gridy = 0;
		pnlButtonsHexagon.add(rigidArea, gbc_rigidArea);
		
		Component rigidArea_1 = Box.createRigidArea(new Dimension(20, 20));
		GridBagConstraints gbc_rigidArea_1 = new GridBagConstraints();
		gbc_rigidArea_1.insets = new Insets(0, 0, 0, 5);
		gbc_rigidArea_1.gridx = 2;
		gbc_rigidArea_1.gridy = 0;
		pnlButtonsHexagon.add(rigidArea_1, gbc_rigidArea_1);
		GridBagConstraints gbc_btnAddHexagon = new GridBagConstraints();
		gbc_btnAddHexagon.insets = new Insets(0, 0, 0, 5);
		gbc_btnAddHexagon.gridx = 3;
		gbc_btnAddHexagon.gridy = 0;
		pnlButtonsHexagon.add(btnAddHexagon, gbc_btnAddHexagon);
		btnAddHexagon.setActionCommand("OK");
		getRootPane().setDefaultButton(btnAddHexagon);
		
		JButton btnCancelHexagon = new JButton("Cancel");
		btnCancelHexagon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtRadiusHexagon.setText("");
				addCanceled = true;
				dispose();
			}
		});
		GridBagConstraints gbc_btnCancelHexagon = new GridBagConstraints();
		gbc_btnCancelHexagon.insets = new Insets(0, 0, 0, 5);
		gbc_btnCancelHexagon.anchor = GridBagConstraints.NORTHWEST;
		gbc_btnCancelHexagon.gridx = 4;
		gbc_btnCancelHexagon.gridy = 0;
		pnlButtonsHexagon.add(btnCancelHexagon, gbc_btnCancelHexagon);
		btnCancelHexagon.setActionCommand("Cancel");
	}

	public static void main(String[] args) {
		try {
			DlgAddHexagon dialog = new DlgAddHexagon();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public int getRadiusHexagon() {
		return radiusHexagon;
	}

	public void setRadiusHexagon(int radiusHexagon) {
		this.radiusHexagon = radiusHexagon;
	}

	public boolean isAddCanceled() {
		return addCanceled;
	}

	public void setAddCanceled(boolean addCanceled) {
		this.addCanceled = addCanceled;
	}

}
