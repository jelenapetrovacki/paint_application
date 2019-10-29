package shapes.square;

import javax.swing.JDialog;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import javax.swing.JTextField;

import java.awt.Insets;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import java.awt.Component;
import javax.swing.Box;
import java.awt.Dimension;

public class DlgAddSquare extends JDialog{
	
	private JTextField txtLength;
	private int sideLength;
	private boolean addCanceled;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgAddSquare dialog = new DlgAddSquare();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public DlgAddSquare() {
		setTitle("Add square ");
		setModal(true);
		setBounds(100, 100, 400, 150);
		JPanel pnlAddSquare = new JPanel();
		getContentPane().add(pnlAddSquare, BorderLayout.CENTER);
		GridBagLayout gbl_pnlAddSquare = new GridBagLayout();
		gbl_pnlAddSquare.columnWidths = new int[]{159, 98, 0};
		gbl_pnlAddSquare.rowHeights = new int[]{0, 0, 0, 0};
		gbl_pnlAddSquare.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_pnlAddSquare.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		pnlAddSquare.setLayout(gbl_pnlAddSquare);
		
		JLabel lblLength = new JLabel("Insert side length:");
		GridBagConstraints gbc_lblLength = new GridBagConstraints();
		gbc_lblLength.insets = new Insets(0, 0, 5, 5);
		gbc_lblLength.anchor = GridBagConstraints.EAST;
		gbc_lblLength.gridx = 0;
		gbc_lblLength.gridy = 1;
		pnlAddSquare.add(lblLength, gbc_lblLength);
		
		txtLength = new JTextField();
		GridBagConstraints gbc_txtLength = new GridBagConstraints();
		gbc_txtLength.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtLength.insets = new Insets(0, 0, 5, 0);
		gbc_txtLength.gridx = 1;
		gbc_txtLength.gridy = 1;
		pnlAddSquare.add(txtLength, gbc_txtLength);
		txtLength.setColumns(10);
		
		JPanel pnlButtons = new JPanel();
		getContentPane().add(pnlButtons, BorderLayout.SOUTH);
		GridBagLayout gbl_pnlButtons = new GridBagLayout();
		gbl_pnlButtons.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_pnlButtons.rowHeights = new int[]{0, 0};
		gbl_pnlButtons.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_pnlButtons.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		pnlButtons.setLayout(gbl_pnlButtons);
		
		JButton btnAddSquare = new JButton("Add square");
		btnAddSquare.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					sideLength =Integer.parseInt(txtLength.getText());
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
		pnlButtons.add(rigidArea, gbc_rigidArea);
		
		Component rigidArea_1 = Box.createRigidArea(new Dimension(20, 20));
		GridBagConstraints gbc_rigidArea_1 = new GridBagConstraints();
		gbc_rigidArea_1.insets = new Insets(0, 0, 0, 5);
		gbc_rigidArea_1.gridx = 1;
		gbc_rigidArea_1.gridy = 0;
		pnlButtons.add(rigidArea_1, gbc_rigidArea_1);
		
		Component rigidArea_2 = Box.createRigidArea(new Dimension(20, 20));
		GridBagConstraints gbc_rigidArea_2 = new GridBagConstraints();
		gbc_rigidArea_2.insets = new Insets(0, 0, 0, 5);
		gbc_rigidArea_2.gridx = 2;
		gbc_rigidArea_2.gridy = 0;
		pnlButtons.add(rigidArea_2, gbc_rigidArea_2);
		
		Component rigidArea_4 = Box.createRigidArea(new Dimension(20, 20));
		GridBagConstraints gbc_rigidArea_4 = new GridBagConstraints();
		gbc_rigidArea_4.insets = new Insets(0, 0, 0, 5);
		gbc_rigidArea_4.gridx = 6;
		gbc_rigidArea_4.gridy = 0;
		pnlButtons.add(rigidArea_4, gbc_rigidArea_4);
		
		Component rigidArea_3 = Box.createRigidArea(new Dimension(20, 20));
		GridBagConstraints gbc_rigidArea_3 = new GridBagConstraints();
		gbc_rigidArea_3.insets = new Insets(0, 0, 0, 5);
		gbc_rigidArea_3.gridx = 7;
		gbc_rigidArea_3.gridy = 0;
		pnlButtons.add(rigidArea_3, gbc_rigidArea_3);
		GridBagConstraints gbc_btnAddSquare = new GridBagConstraints();
		gbc_btnAddSquare.insets = new Insets(0, 0, 0, 5);
		gbc_btnAddSquare.gridx = 8;
		gbc_btnAddSquare.gridy = 0;
		pnlButtons.add(btnAddSquare, gbc_btnAddSquare);
		
		btnAddSquare.setActionCommand("OK");
		getRootPane().setDefaultButton(btnAddSquare);
		 
		
		
		JButton btnCancelSquare = new JButton("Cancel");
		btnCancelSquare.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtLength.setText("");
				addCanceled=true;
				dispose();
			}
		});
		GridBagConstraints gbc_btnCancelSquare = new GridBagConstraints();
		gbc_btnCancelSquare.gridx = 9;
		gbc_btnCancelSquare.gridy = 0;
		pnlButtons.add(btnCancelSquare, gbc_btnCancelSquare);
		btnCancelSquare.setActionCommand("Cancel");
	}


	public int getSideLength() {
		return sideLength;
	}


	public void setSideLength(int sideLength) {
		this.sideLength = sideLength;
	}


	public boolean isAddCanceled() {
		return addCanceled;
	}


	public void setAddCanceled(boolean addCanceled) {
		this.addCanceled = addCanceled;
	}
	
	

	
}
