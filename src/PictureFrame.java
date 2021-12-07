
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

/**
 * Used to generate GUI components and display content to screen
 * 
 */
public class PictureFrame extends javax.swing.JFrame {

	private PictureDataReader reader;
	private PictureDataWriter writer;
	private PictureLoader loader;
	private List<PictureData> list;
	private int currentIndex;

	private PicturePanel pnlUpper;
	private JTextArea txtDescription;
	private JTextField txtDate;

	public PictureFrame() {
		initComponents();
	}

	public PictureFrame(PictureDataReader reader, PictureDataWriter writer, PictureLoader loader) {
		this();
		this.reader = reader;
		this.writer = writer;
		this.loader = loader;
		this.list = this.reader.readPictureDataFromFile();
		this.loader.loadImagesFromPictureData(list);
		this.currentIndex = 0;
		populateData();

	}

	/**
	 * Refreshes data shown on GUI
	 * 
	 */
	private void populateData() {
		int index = Math.abs(currentIndex % list.size());
		pnlUpper.setPicture(this.loader.getImages().get(index));
		txtDate.setText(list.get(index).getDate());
		String[] words = list.get(index).getDescription().split(" ");
		String desc = "";
		int count = 0;
		for (int i = 0; i < words.length; i = i + 1) {
			if (count + words[i].length() >= 30) {
				desc += "\n";
				count = 0;
			}
			desc += " " + words[i];
			count += words[i].length();
		}
		txtDescription.setText(desc);
		repaint();
	}

	/**
	 * Creates all necessary GUI objects and action listeners
	 * 
	 */
	private void initComponents() {
		JPanel pnlBottom;
		JPanel pnlButtons;
		JButton btnPrev;
		JButton btnSave;
		JButton btnNext;
		JMenu menuFile;
		JMenu menuHelp;
		JMenuBar menuBar;
		JMenuItem menuItemSave;
		JMenuItem menuItemExit;
		JMenuItem menuItemAbout;

		pnlUpper = new PicturePanel();
		txtDate = new JTextField();
		txtDescription = new JTextArea();
		btnPrev = new JButton();
		pnlBottom = new JPanel();
		pnlButtons = new JPanel();
		btnSave = new JButton();
		btnNext = new JButton();
		menuBar = new JMenuBar();
		menuFile = new JMenu();
		menuHelp = new JMenu();
		menuItemSave = new JMenuItem();
		menuItemExit = new JMenuItem();
		menuItemAbout = new JMenuItem();

		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setPreferredSize(new Dimension(290, 400));
		setSize(new Dimension(290, 400));

		setLayout(new BorderLayout());
		add(pnlUpper, BorderLayout.NORTH);
		add(pnlBottom, BorderLayout.CENTER);

		pnlBottom.setLayout(new BorderLayout());
		pnlBottom.add(txtDate, BorderLayout.NORTH);
		pnlBottom.add(txtDescription, BorderLayout.CENTER);
		pnlBottom.add(pnlButtons, BorderLayout.SOUTH);
		pnlButtons.add(btnPrev, BorderLayout.WEST);
		pnlButtons.add(btnSave, BorderLayout.CENTER);
		pnlButtons.add(btnNext, BorderLayout.EAST);
		setTitle("Picture Frame");

		btnPrev.setText("Prev");
		btnPrev.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				btnPrevActionPerformed(evt);
			}
		});

		btnSave.setText("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				btnSaveActionPerformed(evt);
			}
		});

		btnNext.setText("Next");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				btnNextActionPerformed(evt);
			}
		});

		menuFile.setText("File");
		menuBar.add(menuFile);

		menuHelp.setText("Help");
		menuBar.add(menuHelp);

		setJMenuBar(menuBar);

		menuItemSave.setText("Save");
		menuFile.add(menuItemSave);

		menuItemExit.setText("Exit");
		menuFile.add(menuItemExit);

		menuItemAbout.setText("About");
		menuHelp.add(menuItemAbout);

		menuItemSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				btnSaveActionPerformed(evt);
			}
		});

		menuItemExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				menuItemExitActionPerformed(evt);
			}

		});

		menuItemAbout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				menuItemAboutActionPerformed(evt);
			}
		});
		setLocationRelativeTo(null);
		pack();
	}

	private void btnPrevActionPerformed(ActionEvent evt) {
		currentIndex--;
		populateData();
	}

	private void btnSaveActionPerformed(ActionEvent evt) {
		int index = Math.abs(currentIndex % list.size());
		String date = txtDate.getText();
		String description = txtDescription.getText().replace("\n", "").trim();
		PictureData data = list.get(index);
		data.setDate(date);
		data.setDescription(description);
		writer.writePictureDataInFile(list);
	}

	private void btnNextActionPerformed(ActionEvent evt) {
		currentIndex++;
		populateData();
	}

	private void menuItemExitActionPerformed(ActionEvent evt) {
		dispose();
	}

	private void menuItemAboutActionPerformed(ActionEvent evt) {
		JOptionPane.showMessageDialog(this, "Created Margaret Sosnowska in November, 2021.");
	}

}
