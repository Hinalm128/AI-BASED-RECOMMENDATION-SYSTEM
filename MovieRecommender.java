import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.impl.model.file.FileDataModel;
import org.apache.mahout.cf.taste.impl.neighborhood.NearestNUserNeighborhood;
import org.apache.mahout.cf.taste.impl.recommender.GenericUserBasedRecommender;
import org.apache.mahout.cf.taste.impl.similarity.LogLikelihoodSimilarity;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.neighborhood.UserNeighborhood;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.apache.mahout.cf.taste.recommender.UserBasedRecommender;

public class MovieRecommender implements ActionListener 
{
	//Creating Instances of Components.
	private JFrame f;
	private JLabel l1,mainHeading,recom_User,img1,img2,img3,img4,img5,m1,m2,m3,m4,m5,p1,p2,p3,p4,p5;
	private JComboBox<String> cb;
	private JButton b;
	private ImageIcon movie1,movie1_Resize,movie2,movie2_Resize,movie3,movie3_Resize,movie4,movie4_Resize,movie5,movie5_Resize;
	private Image movie1_resized,movie2_resized,movie3_resized,movie4_resized,movie5_resized;
	private List<String> preference = new ArrayList<String>();
	private List<String> recom_Movie_Id=new ArrayList<String>();
	
	
	private String[] movieNames= {
			"Jawan",
			"Pathaan",
			"3 Idiots",
			"Luka Chuppi",
			"Rowdy Rathore",
			"Raid",
			"Laapataa Ladies",
			"Kabir Singh",
			"A Thursday",
			"Raazi",
			"Ghajini",
			"Mimi",
			"Mardaani 2",
			"Chhichhore",
			"Dream Girl",
			"Dunki",
			"Gabbar Is Back",
			"Hichki",
			"Bhool Bhulaiyaa",
			"Shaitan",
	};
	
	private String[] moviesImage= {
			"jawan.jpg",
			"Pathaan.jpg",
			"3_Idiots.jpg",
			"Luka_Chuppi.jpg",
			"Rowdy_Rathore.jpg",
			"Raid.jpg",
			"Laapataa_Ladies.jpg",
			"Kabir_Singh.jpg",
			"A_Thursday.jpg",
			"Raazi.jpg",
			"Ghajini.jpg",
			"Mimi.jpg",
			"Mardaani_2.jpg",
			"Chhichhore.jpg",
			"Dream_Girl.jpg",
			"Dunki.jpg",
			"Gabbar_Is_Back.jpg",
			"Hichki.jpg",
			"Bhool_Bhulaiyaa.jpg",
			"Shaitan.jpg"
	};
	private String[] userName= {
			" Select User ...",
			  "Rohan" ,
			  "Ekta" ,
			  "Vihaan" ,
			  "Kabir" ,
			  "Divya" ,
			  "Aarav" ,
			  "Atharv" ,
			  "Reyansh" ,
			  "Eesha" ,
			  "Dhruv" ,
			  "Rohit" ,
			  "Amar" ,
			  "Aditya" ,
			  "Krishna" ,
			  "Ansh" ,
			  "Jiya" ,
			  "Sakshi" ,
			  "Arjun" ,
			  "Riya" ,
			  "Radhika"	
	};
	
	public MovieRecommender()
	{
		//Setting Components height , width,and color.
		f=new JFrame("Movie Recommender");
		
		mainHeading=new JLabel("Movie Recommender System");
		mainHeading.setFont(new Font("Arial Rounded MT Bold",Font.BOLD,48));
		mainHeading.setForeground(new Color(204,204,204));
		
		l1=new JLabel("Select User : ");
		l1.setFont(new Font("Calibri",Font.PLAIN,15));
		l1.setForeground(new Color(220,220,220));
		
		cb=new JComboBox<String>(userName);
		
		b=new JButton("Get Recommendation");
		b.addActionListener(this);
		b.setBackground(new Color(33,33,33));
		b.setForeground(new Color(220,220,220));
		
		//Adding Components to the Frame.
		mainHeading.setBounds(60, 10, 900, 60);
		f.add(mainHeading);
		
		l1.setBounds(60, 80, 100, 25);
		f.add(l1);
		
		cb.setBounds(60, 105, 940, 35);
		f.add(cb);
		
		b.setBounds(60, 150, 200, 30);
		f.add(b);
		
		f.getContentPane().setBackground(new Color(33,33,33));
		
		f.setSize(1070,230);
		f.setLayout(null);
		f.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		// Clear previously added recommendation components
		f.getContentPane().removeAll();

		// Re-add static components (header, labels, combo box, button)
		f.add(mainHeading);
		f.add(l1);
		f.add(cb);
		f.add(b);
		
		try 
		{
			//Creating a DataModel to store and Load the data.
			DataModel dm=new FileDataModel(new File("data/MoviesFinal.csv"));
			
			//Finding the similarity between 2 users by using LogLikelihoodSimilarity.
			LogLikelihoodSimilarity sim=new LogLikelihoodSimilarity(dm);
			
			//To find the Neighbor of the user.
			UserNeighborhood nei=new NearestNUserNeighborhood(5,sim,dm);
			
			//To recommend something i.e. books,movies,etc to the user based on the preference.
			UserBasedRecommender recommender=new GenericUserBasedRecommender(dm,nei,sim);
			
			//Creating a list of recommendation-item. Here it will generate 5 recommendation.
			List<RecommendedItem> recommendations = recommender.recommend(cb.getSelectedIndex(), 5);
			
			//Iterating through the RecommendedItem List.
			for (RecommendedItem i : recommendations)
			{	
				//Retrieving Ids & preference ratio and Adding them to their respective list.
				
		        int movieId = (int) i.getItemID();
		        recom_Movie_Id.add(""+movieId);
		            
		        float estimatedPref = recommender.estimatePreference(cb.getSelectedIndex(), movieId);
		        preference.add(""+estimatedPref);
		    }
		} 
		catch (IOException | TasteException e1) 
		{
			e1.printStackTrace();
		}
		
		//Setting Components height, width and color.
		
		recom_User =new JLabel("Recommendation for "+cb.getItemAt(cb.getSelectedIndex())+" are : ");
		recom_User.setFont(new Font("",Font.BOLD,16));
		recom_User.setForeground(new Color(204,204,204));
		
		
		//Retrieving the items from the List ... Converting them into int & parsing it as a index in Array and then printing it on the JLabel.
		// Subtracting 1 because Array Index begin from 0.
		
		m1=new JLabel(movieNames[Integer.parseInt(recom_Movie_Id.get(0))-1]);
		m1.setFont(new Font("",Font.PLAIN,14));
		m1.setForeground(new Color(204,204,204));
		  
		m2=new JLabel(movieNames[Integer.parseInt(recom_Movie_Id.get(1))-1]);
		m2.setFont(new Font("",Font.PLAIN,14));
		m2.setForeground(new Color(204,204,204));

		m3=new JLabel(movieNames[Integer.parseInt(recom_Movie_Id.get(2))-1]);
		m3.setFont(new Font("",Font.PLAIN,14));
		m3.setForeground(new Color(204,204,204)); 
		  
		m4=new JLabel(movieNames[Integer.parseInt(recom_Movie_Id.get(3))-1]);
		m4.setFont(new Font("",Font.PLAIN,14));
		m4.setForeground(new Color(204,204,204)); 
		  
		m5=new JLabel(movieNames[Integer.parseInt(recom_Movie_Id.get(4))-1]);
		m5.setFont(new Font("",Font.PLAIN,14));
		m5.setForeground(new Color(204,204,204)); 
		 
		movie1=new ImageIcon("img/"+moviesImage[Integer.parseInt(recom_Movie_Id.get(0))-1]);
		movie1_resized=movie1.getImage().getScaledInstance(175, 275, Image.SCALE_SMOOTH);
		movie1_Resize= new ImageIcon(movie1_resized);
		img1=new JLabel(movie1_Resize);
		
		movie2=new ImageIcon("img/"+moviesImage[Integer.parseInt(recom_Movie_Id.get(1))-1]);
		movie2_resized=movie2.getImage().getScaledInstance(175, 275, Image.SCALE_SMOOTH);
		movie2_Resize= new ImageIcon(movie2_resized);
		img2=new JLabel(movie2_Resize);
		
		
		movie3=new ImageIcon("img/"+moviesImage[Integer.parseInt(recom_Movie_Id.get(2))-1]);
		movie3_resized=movie3.getImage().getScaledInstance(175, 275, Image.SCALE_SMOOTH);
		movie3_Resize= new ImageIcon(movie3_resized);
		img3=new JLabel(movie3_Resize);
		
		movie4=new ImageIcon("img/"+moviesImage[Integer.parseInt(recom_Movie_Id.get(3))-1]);
		movie4_resized=movie4.getImage().getScaledInstance(175, 275, Image.SCALE_SMOOTH);
		movie4_Resize= new ImageIcon(movie4_resized);
		img4=new JLabel(movie4_Resize);
		
		movie5=new ImageIcon("img/"+moviesImage[Integer.parseInt(recom_Movie_Id.get(4))-1]);
		movie5_resized=movie5.getImage().getScaledInstance(175, 275, Image.SCALE_SMOOTH);
		movie5_Resize= new ImageIcon(movie5_resized);
		img5=new JLabel(movie5_Resize);
		
		p1=new JLabel("Preference : "+preference.get(0));
		p1.setFont(new Font("",Font.PLAIN,14));
		p1.setForeground(new Color(204,204,204));
		  
		p2=new JLabel("Preference : "+preference.get(1));
		p2.setFont(new Font("",Font.PLAIN,14));
		p2.setForeground(new Color(204,204,204));
		  
		p3=new JLabel("Preference : "+preference.get(2));
		p3.setFont(new Font("",Font.PLAIN,14));
		p3.setForeground(new Color(204,204,204)); 
		  
		p4=new JLabel("Preference : "+preference.get(3));
		p4.setFont(new Font("",Font.PLAIN,14));
		p4.setForeground(new Color(204,204,204)); 
		
		p5=new JLabel("Preference : "+preference.get(4));
		p5.setFont(new Font("",Font.PLAIN,14));
		p5.setForeground(new Color(204,204,204));

		//Setting the position of the components and Adding them to the JFrame.
		
		recom_User.setBounds(60, 195, 400, 25);
		f.add(recom_User);
		
		m1.setBounds(60,230, 180, 25);
		f.add(m1);
		
		m2.setBounds(255,230, 180, 25);
		f.add(m2);
		
		m3.setBounds(445,230, 180, 25);
		f.add(m3);
		
		m4.setBounds(635,230, 180, 25);
		f.add(m4);
		
		m5.setBounds(825,230, 180, 25);
		f.add(m5);
		
		img1.setBounds(60, 200, 180, 400);
		f.add(img1);
		
		img2.setBounds(250, 200, 180, 400);
		f.add(img2);
		
		img3.setBounds(440, 200, 180, 400);
		f.add(img3);
		
		img4.setBounds(630, 200, 180, 400);
		f.add(img4);
		
		img5.setBounds(820, 200, 180, 400);
		f.add(img5);
		
		p1.setBounds(60,545, 180, 25);
		f.add(p1);
		
		p2.setBounds(255,545, 180, 25);
		f.add(p2);
		
		p3.setBounds(445,545, 180, 25);
		f.add(p3);

		p4.setBounds(635,545, 180, 25);
		f.add(p4);
		
		p5.setBounds(825,545, 180, 25);
		f.add(p5);
		
		//Clearing the List.
		recom_Movie_Id.clear(); 
		preference.clear();
		 
		f.setSize(1070,650);
		f.repaint();
		f.revalidate(); //To Add Objects Dyanmically to the JFrame. 
		
	}
	public static void main(String[] args) 
	{
		new MovieRecommender();
	}

}
