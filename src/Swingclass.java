import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Frame;
import java.awt.Image;
import java.awt.Label;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.plaf.basic.BasicSplitPaneUI.BasicHorizontalLayoutManager;

import org.json.JSONObject;

public class Swingclass extends JFrame implements ActionListener{
    JLabel heading;
    JPanel mainpanel;
 	JLabel namelable,imagelabel;
 	JTextField textfield,textfield1;	

 	JButton button;
 		Swingclass() throws IOException
	{
		super.setTitle("WeatherApplicatoin");
		super.setSize(600,500);
		super.setLocation(50, 50);
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	 	
		    mainpanel=new JPanel();
			mainpanel.setLayout(null);
			//mainpanel.add(textfield);
 

	  //  this.getMeushow();
		 heading=new JLabel("Welcome to the weather Api Develop by Sanjay");
 	    
 	     namelable=new JLabel("enter the city");
 	
 		 button=new JButton("search");
 		textfield=new JTextField();
 		textfield1=new JTextField();
 	
 		 BufferedImage img = ImageIO. read(new File("/home/sanjay/Desktop/images.jpeg"));
 		 imagelabel = new JLabel(new ImageIcon(img)); 
 		 this.setheading();   
         this.namelable();
         this.textfield();
         this.imagelabel();
 	    this.addtextfield1();
 		 this.setbutton();
 		 super.setVisible(true);
 		
 		 this.add(mainpanel);
    	}
 			private void textfield() {
		
			 textfield.setFont(new Font("Verdana", Font.ITALIC, 20));
			 textfield.setBounds(200,115,200,40);
			    mainpanel.add(textfield);
		}
		private void setheading() {
 			// TODO Auto-generated method stub
 			heading.setFont(new Font("Verdana", Font.ITALIC, 20));
 			heading.setAlignmentX(CENTER_ALIGNMENT);
 		 	heading.setBounds(30, 30, 500, 70);
 		    mainpanel.add(heading);
 		}

	private void namelable() {
		// TODO Auto-generated method stub
		
		namelable.setFont(new Font("Verdana", Font.ITALIC, 20));
	    namelable.setBounds(20, 100, 200, 70);
	    mainpanel.add(namelable);
	   
	   
	}
		
	private void setbutton() {
		
	    button.setBounds(420,115,100,40);
	    button.setFont(new Font("Verdana", Font.ITALIC, 20));
		button.setForeground(Color.CYAN);
	    button.setBackground(Color.darkGray);
		Cursor cur=new Cursor(Cursor.HAND_CURSOR);
		button.setCursor(cur);
		mainpanel.add(button);
		button.addActionListener(this);
			}
	public  void addtextfield1() 
	{
		
		textfield1.setFont(new Font("Verdana", Font.ITALIC, 20));
		textfield1.setBounds(250,250,200,80);
		
	   	mainpanel.add(textfield1);
		textfield1.addActionListener(this);
		
		

			// TODO Auto-generated method stub
			
		}

	
	public void actionPerformed(ActionEvent e) 
	{
		// TODO Auto-generated method stub
		
		apigetting(textfield.getText().toString());
		String s,s1;
		s = e.getActionCommand();
		if (s.equals("search"))
		{
			String str=textfield.getText().toString();
            // set the text of the label to the text of the field
		    textfield1.setText(str);
  
            // set the text of field to blank
            textfield.setText("  ");
        }
		
	    System.out.print(textfield1.getText().toString());
        
	}
		private void imagelabel()
{
	// TODO Auto-generated method stub
	imagelabel.setBounds(50,200,150,150);
 
	 mainpanel.add(imagelabel);
}


public String apigetting(String name)
{
		try 
	{
	 var url ="http://api.weatherapi.com/v1/current.json?key=e3ac81bc8fd84b7cb4461201210308&q="+name+"&aqi=no";
     var request=HttpRequest.newBuilder().GET().uri(URI.create(url)).build();
     var client = HttpClient.newBuilder().build();
     var response=client.send(request, HttpResponse.BodyHandlers.ofString());
     var store=response.body();
  //    System.out.println(" Information regarding your request is----");
      JSONObject jsnobj=new JSONObject(store).getJSONObject("location");
      String s1=jsnobj.getString("name");
     
      //System.out.println("name  :  "+ s1);
     
     }
		
	catch(Exception e)
	{
		e.printStackTrace();
	}
		return name;
   }
		
	}
	
