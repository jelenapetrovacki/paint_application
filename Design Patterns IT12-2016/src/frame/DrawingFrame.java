package frame;

import javax.swing.JFrame;
import javax.swing.JPanel;

import controller.DrawingController;


import view.DrawingView;

import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.GridBagLayout;
import javax.swing.JToggleButton;
import javax.swing.ScrollPaneConstants;

import java.awt.GridBagConstraints;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;

import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.SwingConstants;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JList;
import java.awt.Color;
import javax.swing.ImageIcon;


public class DrawingFrame extends JFrame {
	
	private DrawingView drawingview = new DrawingView();
	private DrawingController controller;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JPanel optionsview;
	private JButton btnDelete;
	private JButton btnUpdate;
	private JButton btnToFront;
	private JButton btnToBack;
	private JButton btnBringToFront;
	private JButton btnBringToBack;
	private JButton btnUndo;
	private JButton btnRedo;
	private JList logList;
	private JFileChooser chooser;
	private JFileChooser openChooser;
	private DefaultListModel <String> dlmLogList;
	private JButton btnBorderColor;
	private JButton btnAreaColor;
	private JButton btnGetLog;
	public DrawingView getView() {
		return drawingview;
	}

	public void setController(DrawingController controller) {
		this.controller = controller;

	}
	
	public DrawingFrame() {
		setTitle("Petrova\u010Dki Jelena IT12-2016");
		drawingview.setBackground(Color.WHITE);
		
		//DRAWING VIEW panel
		
		getContentPane().add(drawingview, BorderLayout.CENTER);
		
		JPanel buttonsview = new JPanel();
		getContentPane().add(buttonsview, BorderLayout.NORTH);
		GridBagLayout gbl_buttonsview = new GridBagLayout();
		gbl_buttonsview.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_buttonsview.rowHeights = new int[]{0, 0, 0};
		gbl_buttonsview.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_buttonsview.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		buttonsview.setLayout(gbl_buttonsview);
		
		JToggleButton tglbtnPoint = new JToggleButton("Point");
		tglbtnPoint.setIcon(new ImageIcon("C:\\Users\\user\\Downloads\\iconfinder_add_134224.png"));
		tglbtnPoint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.tglButtonClicked(tglbtnPoint.getActionCommand());
			}
			
		});
		buttonGroup.add(tglbtnPoint);
		GridBagConstraints gbc_tglbtnPoint = new GridBagConstraints();
		gbc_tglbtnPoint.insets = new Insets(0, 0, 5, 5);
		gbc_tglbtnPoint.gridx = 0;
		gbc_tglbtnPoint.gridy = 0;
		buttonsview.add(tglbtnPoint, gbc_tglbtnPoint);
		
		JToggleButton tglbtnLine = new JToggleButton("Line");
		tglbtnLine.setIcon(new ImageIcon("C:\\Users\\user\\Downloads\\iconfinder_button_shape_line_352900 (1).png"));
		tglbtnLine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.tglButtonClicked(tglbtnLine.getActionCommand());
			}
		});
		buttonGroup.add(tglbtnLine);
		GridBagConstraints gbc_tglbtnLine = new GridBagConstraints();
		gbc_tglbtnLine.insets = new Insets(0, 0, 5, 5);
		gbc_tglbtnLine.gridx = 1;
		gbc_tglbtnLine.gridy = 0;
		buttonsview.add(tglbtnLine, gbc_tglbtnLine);
		
		JToggleButton tglbtnSquare = new JToggleButton("Square");
		tglbtnSquare.setIcon(new ImageIcon("C:\\Users\\user\\Downloads\\iconfinder_ic_crop_square_48px_351984 (1).png"));
		tglbtnSquare.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.tglButtonClicked(tglbtnSquare.getActionCommand());
			}
		});
		buttonGroup.add(tglbtnSquare);
		GridBagConstraints gbc_tglbtnSquare = new GridBagConstraints();
		gbc_tglbtnSquare.insets = new Insets(0, 0, 5, 5);
		gbc_tglbtnSquare.gridx = 2;
		gbc_tglbtnSquare.gridy = 0;
		buttonsview.add(tglbtnSquare, gbc_tglbtnSquare);
		
		JToggleButton tglbtnRectangle = new JToggleButton("Rectangle");
		tglbtnRectangle.setIcon(new ImageIcon("C:\\Users\\user\\Downloads\\rectangle.png"));
		tglbtnRectangle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.tglButtonClicked(tglbtnRectangle.getActionCommand());
			}
		});
		buttonGroup.add(tglbtnRectangle);
		GridBagConstraints gbc_tglbtnRectangle = new GridBagConstraints();
		gbc_tglbtnRectangle.insets = new Insets(0, 0, 5, 5);
		gbc_tglbtnRectangle.gridx = 3;
		gbc_tglbtnRectangle.gridy = 0;
		buttonsview.add(tglbtnRectangle, gbc_tglbtnRectangle);
		
		JToggleButton tglbtnCircle = new JToggleButton("Circle");
		tglbtnCircle.setIcon(new ImageIcon("C:\\Users\\user\\Downloads\\iconfinder_check-circle-outline-blank_326565 (2).png"));
		tglbtnCircle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.tglButtonClicked(tglbtnCircle.getActionCommand());
			}
		});
		buttonGroup.add(tglbtnCircle);
		GridBagConstraints gbc_tglbtnCircle = new GridBagConstraints();
		gbc_tglbtnCircle.insets = new Insets(0, 0, 5, 5);
		gbc_tglbtnCircle.gridx = 4;
		gbc_tglbtnCircle.gridy = 0;
		buttonsview.add(tglbtnCircle, gbc_tglbtnCircle);
		
		JToggleButton tglbtnHexagon = new JToggleButton("Hexagon");
		tglbtnHexagon.setIcon(new ImageIcon("C:\\Users\\user\\Downloads\\iconfinder_hexagon-polygon-screw-block_2203531 (1).png"));
		tglbtnHexagon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.tglButtonClicked(tglbtnHexagon.getActionCommand());
			}
		});
		buttonGroup.add(tglbtnHexagon);
		GridBagConstraints gbc_tglbtnHexagon = new GridBagConstraints();
		gbc_tglbtnHexagon.insets = new Insets(0, 0, 5, 0);
		gbc_tglbtnHexagon.gridx = 5;
		gbc_tglbtnHexagon.gridy = 0;
		buttonsview.add(tglbtnHexagon, gbc_tglbtnHexagon);
		
		btnBorderColor = new JButton("Border Color");
		btnBorderColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnBorderColor.setBackground(controller.takeColor(btnBorderColor.getBackground()));
			}
		});
		btnBorderColor.setForeground(Color.WHITE);
		btnBorderColor.setBackground(Color.BLACK);
		GridBagConstraints gbc_btnBorderColor = new GridBagConstraints();
		gbc_btnBorderColor.insets = new Insets(0, 0, 0, 5);
		gbc_btnBorderColor.gridx = 2;
		gbc_btnBorderColor.gridy = 1;
		buttonsview.add(btnBorderColor, gbc_btnBorderColor);
		
		btnAreaColor = new JButton("Area Color");
		btnAreaColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnAreaColor.setBackground(controller.takeColor(btnAreaColor.getBackground()));
			}
		});
		btnAreaColor.setBackground(Color.WHITE);
		GridBagConstraints gbc_btnAreaColor = new GridBagConstraints();
		gbc_btnAreaColor.insets = new Insets(0, 0, 0, 5);
		gbc_btnAreaColor.gridx = 3;
		gbc_btnAreaColor.gridy = 1;
		buttonsview.add(btnAreaColor, gbc_btnAreaColor);
		
		// OPTIONS VIEW panel - delete,modify,select, bring to back,to back ...
		
		optionsview = new JPanel();
		getContentPane().add(optionsview, BorderLayout.WEST);
		GridBagLayout gbl_optionsview = new GridBagLayout();
		gbl_optionsview.columnWidths = new int[]{95, 0};
		gbl_optionsview.rowHeights = new int[]{23, 0, 0, 0, 0, 0, 0, 0};
		gbl_optionsview.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_optionsview.rowWeights = new double[]{0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		//optionsview.setSize(10, 300);
		optionsview.setLayout(gbl_optionsview);
		
		//DELETE
		btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.buttonClicked(btnDelete.getActionCommand());
			}
		});
		GridBagConstraints gbc_btnDelete = new GridBagConstraints();
		gbc_btnDelete.anchor = GridBagConstraints.NORTHWEST;
		gbc_btnDelete.insets = new Insets(0, 0, 5, 0);
		gbc_btnDelete.gridx = 0;
		gbc_btnDelete.gridy = 0;
		optionsview.add(btnDelete, gbc_btnDelete);
		btnDelete.setEnabled(false);
	
		
		
		
		//MODIFY
		btnUpdate = new JButton("Modify");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.buttonClicked(btnUpdate.getActionCommand());
			}
		});
		GridBagConstraints gbc_btnUpdate = new GridBagConstraints();
		gbc_btnUpdate.insets = new Insets(0, 0, 5, 0);
		gbc_btnUpdate.anchor = GridBagConstraints.NORTHWEST;
		gbc_btnUpdate.gridx = 0;
		gbc_btnUpdate.gridy = 1;
		optionsview.add(btnUpdate, gbc_btnUpdate);
		btnUpdate.setEnabled(false);
		//controller.addObserver(btnUpdate);
		
		JToggleButton tglbtnSelect = new JToggleButton("Select");
		tglbtnSelect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.tglButtonClicked(tglbtnSelect.getActionCommand());
			}
		});
		buttonGroup.add(tglbtnSelect);
		GridBagConstraints gbc_tglbtnSelect = new GridBagConstraints();
		gbc_tglbtnSelect.anchor = GridBagConstraints.WEST;
		gbc_tglbtnSelect.insets = new Insets(0, 0, 5, 0);
		gbc_tglbtnSelect.gridx = 0;
		gbc_tglbtnSelect.gridy = 2;
		optionsview.add(tglbtnSelect, gbc_tglbtnSelect);
		
		
		
		
		btnBringToBack = new JButton("Bring To Back");
		btnBringToBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.positionZ(btnBringToBack.getActionCommand());
			}
		});
		btnBringToBack.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_btnBringToBack = new GridBagConstraints();
		gbc_btnBringToBack.anchor = GridBagConstraints.WEST;
		gbc_btnBringToBack.insets = new Insets(0, 0, 5, 0);
		gbc_btnBringToBack.gridx = 0;
		gbc_btnBringToBack.gridy = 3;
		optionsview.add(btnBringToBack, gbc_btnBringToBack);
		btnBringToBack.setEnabled(false);
		
		btnBringToFront = new JButton("Bring To Front");
		btnBringToFront.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.positionZ(btnBringToFront.getActionCommand());
			}
		});
		GridBagConstraints gbc_btnBringToFront = new GridBagConstraints();
		gbc_btnBringToFront.anchor = GridBagConstraints.WEST;
		gbc_btnBringToFront.insets = new Insets(0, 0, 5, 0);
		gbc_btnBringToFront.gridx = 0;
		gbc_btnBringToFront.gridy = 4;
		optionsview.add(btnBringToFront, gbc_btnBringToFront);
		btnBringToFront.setEnabled(false);
		
		btnToBack = new JButton("To Back");
		btnToBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.positionZ(btnToBack.getActionCommand());
			}
		});
		GridBagConstraints gbc_btnToBack = new GridBagConstraints();
		gbc_btnToBack.anchor = GridBagConstraints.WEST;
		gbc_btnToBack.insets = new Insets(0, 0, 5, 0);
		gbc_btnToBack.gridx = 0;
		gbc_btnToBack.gridy = 5;
		optionsview.add(btnToBack, gbc_btnToBack);
		btnToBack.setEnabled(false);
		
		btnToFront = new JButton("To Front");
		btnToFront.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.positionZ(btnToFront.getActionCommand());
			}
		});
		GridBagConstraints gbc_btnToFront = new GridBagConstraints();
		gbc_btnToFront.anchor = GridBagConstraints.WEST;
		gbc_btnToFront.gridx = 0;
		gbc_btnToFront.gridy = 6;
		optionsview.add(btnToFront, gbc_btnToFront);
		btnToFront.setEnabled(false);
		
		//LOG VIEW panel
		
		JPanel logview = new JPanel();
		getContentPane().add(logview, BorderLayout.SOUTH);
		
		JScrollPane scrollPane = new JScrollPane();
		logview.add(scrollPane);
		
		dlmLogList = new DefaultListModel<String>();
		logList = new JList();
		logList.setVisibleRowCount(4);
		logList.setFixedCellWidth(600);
		scrollPane.setViewportView(logList);
		logList.setModel(dlmLogList);
		//COMMAND VIEW panel - undo,redo
		
		JPanel commandview = new JPanel();
		getContentPane().add(commandview, BorderLayout.EAST);
		GridBagLayout gbl_commandview = new GridBagLayout();
		gbl_commandview.columnWidths = new int[]{0, 0};
		gbl_commandview.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gbl_commandview.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_commandview.rowWeights = new double[]{0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		commandview.setLayout(gbl_commandview);
		
		btnUndo = new JButton("Undo");
		btnUndo.setIcon(new ImageIcon("C:\\Users\\user\\Downloads\\undo.png"));
		btnUndo.setEnabled(false);
		btnUndo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.UndoRedo(btnUndo.getActionCommand());
			}
		});
		GridBagConstraints gbc_btnUndo = new GridBagConstraints();
		gbc_btnUndo.insets = new Insets(0, 0, 5, 0);
		gbc_btnUndo.anchor = GridBagConstraints.SOUTH;
		gbc_btnUndo.gridx = 0;
		gbc_btnUndo.gridy = 0;
		commandview.add(btnUndo, gbc_btnUndo);
		
		btnRedo = new JButton("Redo");
		btnRedo.setIcon(new ImageIcon("C:\\Users\\user\\Downloads\\redo.png"));
		btnRedo.setEnabled(false);
		btnRedo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.UndoRedo(btnRedo.getActionCommand());
			}
		});
		GridBagConstraints gbc_btnRedo = new GridBagConstraints();
		gbc_btnRedo.insets = new Insets(0, 0, 5, 0);
		gbc_btnRedo.gridx = 0;
		gbc_btnRedo.gridy = 1;
		commandview.add(btnRedo, gbc_btnRedo);
		
		JButton btnSave = new JButton("");
		btnSave.setIcon(new ImageIcon("C:\\Users\\user\\Downloads\\save.png"));
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			    chooser = new JFileChooser();
				chooser.setFileSelectionMode(JFileChooser.SAVE_DIALOG);
			    chooser.setFileSelectionMode(JFileChooser.FILES_ONLY); 
				chooser.enableInputMethods(false);
				chooser.setMultiSelectionEnabled(false);
				chooser.setFileHidingEnabled(false);
				chooser.setEnabled(true);
				chooser.setDialogTitle("Save");
				chooser.setAcceptAllFileFilterUsed(false);
				
				controller.save();
			}
		});
		GridBagConstraints gbc_btnSave = new GridBagConstraints();
		gbc_btnSave.insets = new Insets(0, 0, 5, 0);
		gbc_btnSave.gridx = 0;
		gbc_btnSave.gridy = 2;
		commandview.add(btnSave, gbc_btnSave);
		
		JButton btnOpenFile = new JButton("");
		btnOpenFile.setIcon(new ImageIcon("C:\\Users\\user\\Downloads\\openfile.png"));
		btnOpenFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				openChooser = new JFileChooser();
				openChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
				openChooser.setFileSelectionMode(JFileChooser.OPEN_DIALOG);
				openChooser.enableInputMethods(true);
				openChooser.setMultiSelectionEnabled(false);
				openChooser.setFileHidingEnabled(false);
				openChooser.setEnabled(true);
				openChooser.setAcceptAllFileFilterUsed(false);
				
				openChooser.setFileFilter(new FileNameExtensionFilter("SerializeDraw", "ser"));
				openChooser.setFileFilter(new FileNameExtensionFilter("FileLog", "log"));
				controller.openFile();				
			}
		});
		GridBagConstraints gbc_btnOpenFile = new GridBagConstraints();
		gbc_btnOpenFile.insets = new Insets(0, 0, 5, 0);
		gbc_btnOpenFile.gridx = 0;
		gbc_btnOpenFile.gridy = 3;
		commandview.add(btnOpenFile, gbc_btnOpenFile);
		
		btnGetLog = new JButton("Get Log");
		btnGetLog.setEnabled(false);
		btnGetLog.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.readLine();
			}
		});
		GridBagConstraints gbc_btnGetLog = new GridBagConstraints();
		gbc_btnGetLog.gridx = 0;
		gbc_btnGetLog.gridy = 4;
		commandview.add(btnGetLog, gbc_btnGetLog);
		
		
		
		drawingview.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				controller.mouseClicked(arg0);
				
			}
		});
		
	}

	public JPanel getOptionsview() {
		return optionsview;
	}

	public void setOptionsview(JPanel optionsview) {
		this.optionsview = optionsview;
	}

	public JButton getBtnDelete() {
		return btnDelete;
	}

	public void setBtnDelete(JButton btnDelete) {
		this.btnDelete = btnDelete;
	}

	public JButton getBtnUpdate() {
		return btnUpdate;
	}

	public void setBtnUpdate(JButton btnUpdate) {
		this.btnUpdate = btnUpdate;
	}

	public JButton getBtnToFront() {
		return btnToFront;
	}

	public void setBtnToFront(JButton btnToFront) {
		this.btnToFront = btnToFront;
	}

	public JButton getBtnToBack() {
		return btnToBack;
	}

	public void setBtnToBack(JButton btnToBack) {
		this.btnToBack = btnToBack;
	}

	public JButton getBtnBringToFront() {
		return btnBringToFront;
	}

	public void setBtnBringToFront(JButton btnBringToFront) {
		this.btnBringToFront = btnBringToFront;
	}

	public JButton getBtnBringToBack() {
		return btnBringToBack;
	}

	public void setBtnBringToBack(JButton btnBringToBack) {
		this.btnBringToBack = btnBringToBack;
	}

	public DefaultListModel<String> getDlmLogList() {
		return dlmLogList;
	}

	public void setDlmLogList(DefaultListModel<String> dlmLogList) {
		this.dlmLogList = dlmLogList;
	}

	public JFileChooser getChooser() {
		return chooser;
	}

	public void setChooser(JFileChooser chooser) {
		this.chooser = chooser;
	}

	public JFileChooser getOpenChooser() {
		return openChooser;
	}

	public void setOpenChooser(JFileChooser openChooser) {
		this.openChooser = openChooser;
	}

	public JButton getBtnUndo() {
		return btnUndo;
	}

	public void setBtnUndo(JButton btnUndo) {
		this.btnUndo = btnUndo;
	}

	public JButton getBtnRedo() {
		return btnRedo;
	}

	public void setBtnRedo(JButton btnRedo) {
		this.btnRedo = btnRedo;
	}

	public DrawingView getDrawingview() {
		return drawingview;
	}

	public void setDrawingview(DrawingView drawingview) {
		this.drawingview = drawingview;
	}

	public JButton getBtnBorderColor() {
		return btnBorderColor;
	}

	public void setBtnBorderColor(JButton btnBorderColor) {
		this.btnBorderColor = btnBorderColor;
	}

	public JButton getBtnAreaColor() {
		return btnAreaColor;
	}

	public void setBtnAreaColor(JButton btnAreaColor) {
		this.btnAreaColor = btnAreaColor;
	}

	public JButton getBtnGetLog() {
		return btnGetLog;
	}

	public void setBtnGetLog(JButton btnGetLog) {
		this.btnGetLog = btnGetLog;
	}

	


}
