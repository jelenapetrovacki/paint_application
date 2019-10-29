package shapes.rectangle;

import javax.swing.JDialog;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import javax.swing.SwingConstants;

import shapes.square.DlgAddSquare;

import java.awt.Insets;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Component;
import javax.swing.Box;
import java.awt.Dimension;

public class DlgAddRectangle extends JDialog{
	private JTextField txtLength;
	private JTextField txtWidth;
	
	private int lengthRectangle;
	private int widthRectangle;
	private boolean addCanceled;
	
	public static void main(String[] args) {
		try {
			DlgAddRectangle dialog = new DlgAddRectangle();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public DlgAddRectangle() {
		setTitle("Add rectangle");
		setModal(true);
		setBounds(100, 100, 400, 150);
		JPanel pnlAddRectangle = new JPanel();
		getContentPane().add(pnlAddRectangle, BorderLayout.CENTER);
		GridBagLayout gbl_pnlAddRectangle = new GridBagLayout();
		gbl_pnlAddRectangle.columnWidths = new int[]{160, 0, 47, 10, 0};
		gbl_pnlAddRectangle.rowHeights = new int[]{0, 0, 0, 0, 0};
		gbl_pnlAddRectangle.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_pnlAddRectangle.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		pnlAddRectangle.setLayout(gbl_pnlAddRectangle);
		
		JLabel lblSideLength = new JLabel("Side length:");
		GridBagConstraints gbc_lblSideLength = new GridBagConstraints();
		gbc_lblSideLength.anchor = GridBagConstraints.EAST;
		gbc_lblSideLength.insets = new Insets(0, 0, 5, 5);
		gbc_lblSideLength.gridx = 0;
		gbc_lblSideLength.gridy = 1;
		pnlAddRectangle.add(lblSideLength, gbc_lblSideLength);
		
		txtLength = new JTextField();
		GridBagConstraints gbc_txtLength = new GridBagConstraints();
		gbc_txtLength.gridwidth = 3;
		gbc_txtLength.insets = new Insets(0, 0, 5, 0);
		gbc_txtLength.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtLength.gridx = 1;
		gbc_txtLength.gridy = 1;
		pnlAddRectangle.add(txtLength, gbc_txtLength);
		txtLength.setColumns(10);
		
		JLabel lblSideWidth = new JLabel("Side width:");
		GridBagConstraints gbc_lblSideWidth = new GridBagConstraints();
		gbc_lblSideWidth.anchor = GridBagConstraints.EAST;
		gbc_lblSideWidth.insets = new Insets(0, 0, 5, 5);
		gbc_lblSideWidth.gridx = 0;
		gbc_lblSideWidth.gridy = 2;
		pnlAddRectangle.add(lblSideWidth, gbc_lblSideWidth);
		
		txtWidth = new JTextField();
		GridBagConstraints gbc_txtWidth = new GridBagConstraints();
		gbc_txtWidth.gridwidth = 3;
		gbc_txtWidth.insets = new Insets(0, 0, 5, 0);
		gbc_txtWidth.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtWidth.gridx = 1;
		gbc_txtWidth.gridy = 2;
		pnlAddRectangle.add(txtWidth, gbc_txtWidth);
		txtWidth.setColumns(10);
		
		JPanel pnlButtonsRectangle = new JPanel();
		getContentPane().add(pnlButtonsRectangle, BorderLayout.SOUTH);
		GridBagLayout gbl_pnlButtonsRectangle = new GridBagLayout();
		gbl_pnlButtonsRectangle.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_pnlButtonsRectangle.rowHeights = new int[]{0, 0};
		gbl_pnlButtonsRectangle.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_pnlButtonsRectangle.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		pnlButtonsRectangle.setLayout(gbl_pnlButtonsRectangle);
		
		JButton btnAddRectangle = new JButton("Add rectangle");
		btnAddRectangle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					lengthRectangle =Integer.parseInt(txtLength.getText());
					widthRectangle =Integer.parseInt(txtWidth.getText());
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
		gbc_rigidArea.gridx = 1;
		gbc_rigidArea.gridy = 0;
		pnlButtonsRectangle.add(rigidArea, gbc_rigidArea);
		
		Component rigidArea_1 = Box.createRigidArea(new Dimension(20, 20));
		GridBagConstraints gbc_rigidArea_1 = new GridBagConstraints();
		gbc_rigidArea_1.insets = new Insets(0, 0, 0, 5);
		gbc_rigidArea_1.gridx = 8;
		gbc_rigidArea_1.gridy = 0;
		pnlButtonsRectangle.add(rigidArea_1, gbc_rigidArea_1);
		btnAddRectangle.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_btnAddRectangle = new GridBagConstraints();
		gbc_btnAddRectangle.insets = new Insets(0, 0, 0, 5);
		gbc_btnAddRectangle.gridx = 9;
		gbc_btnAddRectangle.gridy = 0;
		pnlButtonsRectangle.add(btnAddRectangle, gbc_btnAddRectangle);
		btnAddRectangle.setActionCommand("OK");
		getRootPane().setDefaultButton(btnAddRectangle);
		
		JButton btnCancelRectangle = new JButton("Cancel");
		btnCancelRectangle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtLength.setText("");
				txtWidth.setText("");
				addCanceled=true;
				dispose();
			}
		});
		GridBagConstraints gbc_btnCancelRectangle = new GridBagConstraints();
		gbc_btnCancelRectangle.gridx = 10;
		gbc_btnCancelRectangle.gridy = 0;
		pnlButtonsRectangle.add(btnCancelRectangle, gbc_btnCancelRectangle);
		btnCancelRectangle.setActionCommand("Cancel");
	}

	public int getLengthRectangle() {
		return lengthRectangle;
	}

	public void setLengthRectangle(int lengthRectangle) {
		this.lengthRectangle = lengthRectangle;
	}

	public int getWidthRectangle() {
		return widthRectangle;
	}

	public void setWidthRectangle(int widthRectangle) {
		this.widthRectangle = widthRectangle;
	}

	public boolean isAddCanceled() {
		return addCanceled;
	}

	public void setAddCanceled(boolean addCanceled) {
		this.addCanceled = addCanceled;
	}
	

}
