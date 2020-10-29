import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class CourseDBManager implements CourseDBManagerInterface {

	private CourseDBStructure cdbs = new CourseDBStructure(60);
	
	@Override
	public void add(String id, int crn, int credits, String roomNum, String instructor) {
		// TODO Auto-generated method stub
		
		
		CourseDBElement element = new CourseDBElement(id,crn,credits,roomNum,instructor);
		cdbs.add(element);
	}    

	@Override
	public CourseDBElement get(int crn){
		try {
			return cdbs.get(crn);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			return null;
		}
	}

	@Override
	public void readFile(File input) throws FileNotFoundException {
		try{
	    int lineNumber=0;
	    Scanner attributes;
	    String line;
	    String attribute;
	    FileReader fr=new FileReader(input);   //reads the file  
	    BufferedReader br=new BufferedReader(fr); 

		while((line=br.readLine())!=null) {

			lineNumber++;
			System.out.println("overall line" + lineNumber);

			//line = scanner.nextLine();

			String [] words = line.split(" ", 5); 
			System.out.println("line length is: "+ words.length);
			String id= words[0];
			System.out.println(words[0]);
			int crn= Integer.parseInt(words[1]);System.out.println(words[1]);
			int number_of_credits= Integer.parseInt(words[2]);System.out.println(words[2]);
			String room_number = words[3];System.out.println(words[3]);
			String instructor_name =words[4];
			//System.out.println();
			
			CourseDBElement element = new CourseDBElement(id,crn,number_of_credits,room_number,instructor_name);
			cdbs.add(element);
			System.out.println("finished line" + lineNumber);
		
		}
		fr.close();
		}
		catch(IOException e)  
		{  
		e.printStackTrace();  
		}  
	}

	@Override
	public ArrayList<String> showAll() {
		ArrayList<String> orderedWords = new ArrayList<String>();
		for(LinkedList<CourseDBElement> temp: cdbs.hashTable) {

			if(temp != null) {

				for(CourseDBElement element: temp) {

					if(element !=null)

						orderedWords.add(element.toString());

				}

			}

		}

		Collections.sort(orderedWords);
		return orderedWords;
	}

	
}
