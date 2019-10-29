package shapes.circle;

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
import java.awt.Component;
import javax.swing.Box;
import java.awt.Dimension;

public class DlgAddCircle extends JDialog{
	
	private JTextField txtRadiusCircle;
	private int radiusCircle;
	private boolean addCanceled;
	public DlgAddCircle() {
		setTitle("Add circle");
		setModal(true);
		setBounds(100, 100, 400, 150);
		JPanel pnlAddCircle = new JPanel();
		getContentPane().add(pnlAddCircle, BorderLayout.CENTER);
		GridBagLayout gbl_pnlAddCircle = new GridBagLayout();
		gbl_pnlAddCircle.columnWidths = new int[]{0, 110, 99, 0};
		gbl_pnlAddCircle.rowHeights = new int[]{0, 35, 0, 0};
		gbl_pnlAddCircle.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_pnlAddCircle.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		pnlAddCircle.setLayout(gbl_pnlAddCircle);
		
		Component rigidArea = Box.createRigidArea(new Dimension(20, 20));
		GridBagConstraints gbc_rigidArea = new GridBagConstraints();
		gbc_rigidArea.insets = new Insets(0, 0, 5, 5);
		gbc_rigidArea.gridx = 0;
		gbc_rigidArea.gridy = 1;
		pnlAddCircle.add(rigidArea, gbc_rigidArea);
		
		JLabel lblRadius = new JLabel("Insert radius:");
		GridBagConstraints gbc_lblRadius = new GridBagConstraints();
		gbc_lblRadius.insets = new Insets(0, 0, 5, 5);
		gbc_lblRadius.anchor = GridBagConstraints.EAST;
		gbc_lblRadius.gridx = 1;
		gbc_lblRadius.gridy = 1;
		pnlAddCircle.add(lblRadius, gbc_lblRadius);
		
		txtRadiusCircle = new JTextField();
		GridBagConstraints gbc_txtRadiusCircle = new GridBagConstraints();
		gbc_txtRadiusCircle.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtRadiusCircle.insets = new Insets(0, 0, 5, 0);
		gbc_txtRadiusCircle.gridx = 2;
		gbc_txtRadiusCircle.gridy = 1;
		pnlAddCircle.add(txtRadiusCircle, gbc_txtRadiusCircle);
		txtRadiusCircle.setColumns(10);
		
		JPanel pnlButtonsCircle = new JPanel();
		getContentPane().add(pnlButtonsCircle, BorderLayout.SOUTH);
		GridBagLayout gbl_pnlButtonsCircle = new GridBagLayout();
		gbl_pnlButtonsCircle.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 75, 76, 65, 0};
		gbl_pnlButtonsCircle.rowHeights = new int[]{0, 0};
		gbl_pnlButtonsCircle.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_pnlButtonsCircle.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		pnlButtonsCircle.setLayout(gbl_pnlButtonsCircle);
		
		JButton btnAddCircle = new JButton("Add circle");
		btnAddCircle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					radiusCircle =Integer.parseInt(txtRadiusCircle.getText());
					setVisible(false);
				} catch (NumberFormatException e1) {
					JOptionPane.showMessageDialog(rootPane, "Insert the right value!");
					e1.printStackTrace();
				}
			}
		});
		
		Component rigidArea_1 = Box.createRigidArea(new Dimension(20, 20));
		GridBagConstraints gbc_rigidArea_1 = new GridBagConstraints();
		gbc_rigidArea_1.insets = new Insets(0, 0, 0, 5);
		gbc_rigidArea_1.gridx = 0;
		gbc_rigidArea_1.gridy = 0;
		pnlButtonsCircle.add(rigidArea_1, gbc_rigidArea_1);
		
		Component rigidArea_2 = Box.createRigidArea(new Dimension(20, 20));
		GridBagConstraints gbc_rigidArea_2 = new GridBagConstraints();
		gbc_rigidArea_2.insets = new Insets(0, 0, 0, 5);
		gbc_rigidArea_2.gridx = 1;
		gbc_rigidArea_2.gridy = 0;
		pnlButtonsCircle.add(rigidArea_2, gbc_rigidArea_2);
		
		Component rigidArea_3 = Box.createRigidArea(new Dimension(20, 20));
		GridBagConstraints gbc_rigidArea_3 = new GridBagConstraints();
		gbc_rigidArea_3.insets = new Insets(0, 0, 0, 5);
		gbc_rigidArea_3.gridx = 2;
		gbc_rigidArea_3.gridy = 0;
		pnlButtonsCircle.add(rigidArea_3, gbc_rigidArea_3);
		
		Component rigidArea_4 = Box.createRigidArea(new Dimension(20, 20));
		GridBagConstraints gbc_rigidArea_4 = new GridBagConstraints();
		gbc_rigidArea_4.insets = new Insets(0, 0, 0, 5);
		gbc_rigidArea_4.gridx = 3;
		gbc_rigidArea_4.gridy = 0;
		pnlButtonsCircle.add(rigidArea_4, gbc_rigidArea_4);
		
		Component rigidArea_5 = Box.createRigidArea(new Dimension(20, 20));
		GridBagConstraints gbc_rigidArea_5 = new GridBagConstraints();
		gbc_rigidArea_5.insets = new Insets(0, 0, 0, 5);
		gbc_rigidArea_5.gridx = 4;
		gbc_rigidArea_5.gridy = 0;
		pnlButtonsCircle.add(rigidArea_5, gbc_rigidArea_5);
		
		Component rigidArea_6 = Box.createRigidArea(new Dimension(20, 20));
		GridBagConstraints gbc_rigidArea_6 = new GridBagConstraints();
		gbc_rigidArea_6.insets = new Insets(0, 0, 0, 5);
		gbc_rigidArea_6.gridx = 5;
		gbc_rigidArea_6.gridy = 0;
		pnlButtonsCircle.add(rigidArea_6, gbc_rigidArea_6);
		
		Component rigidArea_7 = Box.createRigidArea(new Dimension(20, 20));
		GridBagConstraints gbc_rigidArea_7 = new GridBagConstraints();
		gbc_rigidArea_7.insets = new Insets(0, 0, 0, 5);
		gbc_rigidArea_7.gridx = 6;
		gbc_rigidArea_7.gridy = 0;
		pnlButtonsCircle.add(rigidArea_7, gbc_rigidArea_7);
		GridBagConstraints gbc_btnAddCircle = new GridBagConstraints();
		gbc_btnAddCircle.insets = new Insets(0, 0, 0, 5);
		gbc_btnAddCircle.gridx = 7;
		gbc_btnAddCircle.gridy = 0;
		pnlButtonsCircle.add(btnAddCircle, gbc_btnAddCircle);
		btnAddCircle.setActionCommand("OK");
		getRootPane().setDefaultButton(btnAddCircle);
		
		JButton btnCancelCircle = new JButton("Cancel");
		btnCancelCircle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtRadiusCircle.setText("");
				addCanceled=true;
				dispose();
			}
		});
		GridBagConstraints gbc_btnCancelCircle = new GridBagConstraints();
		gbc_btnCancelCircle.gridx = 8;
		gbc_btnCancelCircle.gridy = 0;
		pnlButtonsCircle.add(btnCancelCircle, gbc_btnCancelCircle);
		btnCancelCircle.setActionCommand("Cancel");
	}

	public static void main(String[] args) {
		try {
			DlgAddCircle dialog = new DlgAddCircle();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public int getRadiusCircle() {
		return radiusCircle;
	}

	public void setRadiusCircle(int radiusCircle) {
		this.radiusCircle = radiusCircle;
	}

	public boolean isAddCanceled() {
		return addCanceled;
	}

	public void setAddCanceled(boolean addCanceled) {
		this.addCanceled = addCanceled;
	}

}
