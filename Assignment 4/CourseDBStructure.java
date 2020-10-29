import java.io.IOException;
import java.util.LinkedList;

public class CourseDBStructure implements CourseDBStructureInterface {

	String testStr;
	LinkedList<CourseDBElement>[] hashTable;
	int array_size;

	public CourseDBStructure(String testStr, int tableSize) {
		// TODO Auto-generated constructor stub
		hashTable = new LinkedList[tableSize];
		for (int i = 0; i < tableSize; i++) {
			hashTable[i] = null;
		}
		this.testStr = testStr;
		this.array_size=tableSize;
	}

	public CourseDBStructure(int tableSize) {
		// TODO Auto-generated constructor stub
		hashTable = new LinkedList[tableSize];
		for (int i = 0; i < tableSize; i++) {
			hashTable[i] = null;
		}
		this.array_size=tableSize;

	}

	@Override
	public void add(CourseDBElement element) {
		  String crnStr = element.getCRN()+"";
		  int index = crnStr.hashCode() % this.array_size;
	      LinkedList<CourseDBElement> items = hashTable[index];

	       if(items == null) {
	            items = new LinkedList<CourseDBElement>();
	            items.add(element);

	            hashTable[index] = items;
	        }
	        else {
	            for(CourseDBElement item : items) {
	                
	            	 if(item.getCRN()==element.getCRN()) {
	                    item  = element;
	                    return;
	                }
	            }


	            items.add(element);
	        }

	}

	@Override
	public CourseDBElement get(int crn) throws IOException {
	
		String crnStr = crn+"";
		int index = crnStr.hashCode() % this.array_size;
	    LinkedList<CourseDBElement> items = hashTable[index];

	        if(items == null)
	            return null;

	        for(CourseDBElement item : items) {
	            if(item.getCRN()==crn)
	                return item;
	        }

	        return null;
	}

	@Override
	public int getTableSize() {
		// TODO Auto-generated method stub
		return this.hashTable.length;
	}



}
