package dsaproject;
import javax.swing.*;
import java.awt.*;
import java.util.Collections;
import java.util.LinkedList;



public class StudentEmailGUI extends JFrame {


	
	
	 JTextArea studentTextArea =new JTextArea();

	 JLabel headingLabel =new JLabel("LINKEDLIST-GUI ");
	 JLabel idLabel =new JLabel("ID: ");
	 JTextField idTextField= new JTextField(10);
	 JLabel nameLabel =new JLabel("Name: ");
	 JTextField nameTextField= new JTextField(10);
	 
	 JButton add =new JButton ("Add");
	 JButton delete =new JButton ("Delete");
	 JButton displayall =new JButton ("Display All");
	 JButton clear=new JButton ("Clear");
	 JButton  exit=new JButton ("Exit");
	 
	 //Linked list Work
	 private LinkedList<StudentEmail> stLinkedList =new LinkedList<StudentEmail>();
	 
	 
	 public StudentEmailGUI()
	 {
		 
		
		JPanel flow1Panel= new JPanel(new FlowLayout (FlowLayout.CENTER));
		JPanel flow2Panel= new JPanel(new FlowLayout (FlowLayout.CENTER));
		JPanel gridpanel =new JPanel(new GridLayout(2,1));
		JPanel flow3Panel= new JPanel(new FlowLayout (FlowLayout.CENTER));
		JPanel grid3panel =new JPanel(new GridLayout(1,1));
		 studentTextArea.setEditable(false);
		
		
		
		flow1Panel.add(idLabel);
		flow1Panel.add(idTextField);
		flow1Panel.add(nameLabel);
		flow1Panel.add(nameTextField);
		
		flow2Panel.add(add);
		flow2Panel.add(delete);
		flow2Panel.add(displayall);
		flow2Panel.add(clear);
		flow2Panel.add(exit);
		
		flow3Panel.add(headingLabel);
		
		gridpanel.add(flow1Panel);
		gridpanel.add(flow2Panel);
		grid3panel.add(flow3Panel);
		
		
		
		add( studentTextArea,BorderLayout.CENTER);
		add (gridpanel,BorderLayout.SOUTH);
		add(grid3panel,BorderLayout.NORTH);
		
		
		add.addActionListener(event->addStudent());
		 displayall.addActionListener(event->displayallst());
		 exit.addActionListener(event->exitapp());
		 delete.addActionListener(event->delete());
		 clear.addActionListener(event->clear());
	 }
	 private void clear()
	 {
		 
		 stLinkedList.clear();
		 displayallst();
		 
		 
	 }
	 private void delete()
	 {
		 boolean inList=false;
		 for(StudentEmail stud:stLinkedList)
		    {
		      if(stud.getId().compareToIgnoreCase(idTextField.getText())==0)
		      {
		    	  
		    	  inList=true;
		      }
		    
		    }
		 if(inList==false)
		 {
			JOptionPane.showMessageDialog(null,"Error: student ID is not in the database");
		 }else {
		 
		 
			 for(int s=0;s<stLinkedList.size();s++)
			 {
				 String currId=stLinkedList.get(s).getId();
				 if(currId.compareToIgnoreCase(idTextField.getText())==0)
				 {
					 stLinkedList.remove(s);
				 }
			  }
			 displayallst();
		 }
			 
	 }
	 private void exitapp()
	 {
		 System.exit(0);
	 }
	 private void addStudent()
	 {
		 boolean isIDUnique=true;
		 for(StudentEmail stud:stLinkedList)
		    {
		      if(stud.getId().compareToIgnoreCase(idTextField.getText())==0)
		      {
		    	  
		    	  isIDUnique=false;
		      }
		    
		    }
		 if(isIDUnique==false)
		 {
			JOptionPane.showMessageDialog(null,"Error: student ID is already in the database");
		 }else {
		 
		 
		stLinkedList.add(new StudentEmail(nameTextField.getText(),idTextField.getText()));
	    studentTextArea.setText("");
	    for(StudentEmail stud:stLinkedList)
	    {
	    	studentTextArea.append(stud +"\n");
	    }
	    nameTextField.setText("");
	    idTextField.setText("");
	   
		 }
	 
	 }
	 private void displayallst()
	 {
		  
		  studentTextArea.setText("");
		    for(StudentEmail stud:stLinkedList)
		    {
		    	studentTextArea.append(stud +"\n");
		    }
		 
	 }
	 
	 public static void main(String[] args)
	 {
			
		 StudentEmailGUI app = new  StudentEmailGUI();
		 app.setVisible(true);
		 app.setSize(500,500);
		 app.setLocation(200,100);
		 app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	 }
}
