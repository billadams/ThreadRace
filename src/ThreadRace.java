import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JProgressBar;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.event.ActionEvent;
import java.util.Random;

public class ThreadRace extends JFrame
{

	private JPanel contentPane;
	private JLabel lblThreadTwoComplete;
	private JLabel lblThreadOneComplete;

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
		Timer timer1 = new Timer();
		Timer timer2 = new Timer();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 222);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JProgressBar progressBar1 = new JProgressBar();
		progressBar1.setBounds(139, 49, 146, 14);
		contentPane.add(progressBar1);
		
		JProgressBar progressBar2 = new JProgressBar();
		progressBar2.setBounds(139, 88, 146, 14);
		contentPane.add(progressBar2);
		
		JLabel lblNewLabel = new JLabel("Thread One");
		lblNewLabel.setBounds(66, 49, 73, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Thread Two");
		lblNewLabel_1.setBounds(66, 88, 73, 14);
		contentPane.add(lblNewLabel_1);
		
		JButton btnStart = new JButton("Start!");
		btnStart.setBounds(172, 128, 89, 23);
		btnStart.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				TimerTask task1 = new TimerTask()
				{
					int num = 0;
					int randomNum;
					
					@Override
					public void run()
					{
						while (num <= progressBar1.getMaximum())
						{	
							randomNum = randomInteger(0, 10);
							
							if (progressBar1.getValue() >= progressBar1.getMaximum())
							{
								lblThreadOneComplete.setText("Completed!");
							}
							
							try
							{
								Thread.sleep(1000);
							} catch (InterruptedException e)
							{
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							
							progressBar1.setValue(num);
							num += randomNum;
						}
						
					}
				};
				timer1.schedule(task1, 0, 1000);
				
				TimerTask task2 = new TimerTask()
				{
					int num = 0;
					int randomNum;
					
					@Override
					public void run()
					{
						while (num <= progressBar2.getMaximum())
						{
							randomNum = randomInteger(0, 10);
							
							if (progressBar2.getValue() >= progressBar2.getMaximum())
							{
								lblThreadTwoComplete.setText("Completed!");
							}
							
							try
							{
								Thread.sleep(1000);
							} catch (InterruptedException e)
							{
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							
							progressBar2.setValue(num);
							num += 4;
						}
						
					}
				};
				timer2.schedule(task2, 0, 1000);
			}
			
		});
		contentPane.add(btnStart);
		
		lblThreadOneComplete = new JLabel("");
		lblThreadOneComplete.setBounds(301, 49, 79, 14);
		contentPane.add(lblThreadOneComplete);
		
		lblThreadTwoComplete = new JLabel("");
		lblThreadTwoComplete.setBounds(301, 88, 79, 14);
		contentPane.add(lblThreadTwoComplete);
	}
	
	public static int randomInteger(int min, int max)
	{
		Random rand = new Random();	
		int randomNum = rand.nextInt(max - min + 1) + min;
		
		return randomNum;
	}
}
