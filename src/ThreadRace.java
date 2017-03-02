import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JProgressBar;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ThreadRace extends JFrame
{

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				try
				{
					ThreadRace frame = new ThreadRace();
					frame.setVisible(true);
				} catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ThreadRace()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 222);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JProgressBar progressBar = new JProgressBar();
		progressBar.setBounds(157, 49, 146, 14);
		contentPane.add(progressBar);
		
		JProgressBar progressBar_1 = new JProgressBar();
		progressBar_1.setBounds(157, 88, 146, 14);
		contentPane.add(progressBar_1);
		
		JLabel lblNewLabel = new JLabel("Thread One");
		lblNewLabel.setBounds(90, 49, 57, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Thread Two");
		lblNewLabel_1.setBounds(90, 88, 57, 14);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Start!");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton.setBounds(172, 128, 89, 23);
		contentPane.add(btnNewButton);
	}
}
