
public class CourseDBElement implements Comparable{
	private String courseId;
	private int CRN;
	private int number_of_credits;
	private String room_number;
	private String instructor_name;
	

	public CourseDBElement(String courseId, int CRN,int number_of_credits,  String room_number, String instructor_name) {
		this.courseId=courseId;
		this.CRN=CRN;
		this.number_of_credits=number_of_credits;
		this.room_number=room_number;
		this.instructor_name=instructor_name;
	}
	public CourseDBElement() {
		// TODO Auto-generated constructor stub
	}
	public String getCourseId() {
		return courseId;
	}
	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}
	public int getCRN() {
		return CRN;
	}
	public void setCRN(int cRN) {
		CRN = cRN;
	}
	public int getNumber_of_credits() {
		return number_of_credits;
	}
	public void setNumber_of_credits(int number_of_credits) {
		this.number_of_credits = number_of_credits;
	}
	public String getRoom_number() {
		return room_number;
	}
	public void setRoom_number(String room_number) {
		this.room_number = room_number;
	}
	public String getInstructor_name() {
		return instructor_name;
	}
	public void setInstructor_name(String instructor_name) {
		this.instructor_name = instructor_name;
	}
	@Override
	public int hashCode() {
		String crnStr = this.CRN+"";
		return crnStr.hashCode();
	}
	
	@Override
	public int compareTo(CourseDBElement element) {
		String thisCRNStr = this.CRN+"";
		
		String otherCRNStr = element.getCRN()+"";
		
		return thisCRNStr.compareToIgnoreCase(otherCRNStr);
	}

	
	public String toString() {
		return "\nCourse:" + courseId + " CRN:" + CRN + " Credits:" + number_of_credits
				 + " Instructor:" + instructor_name + " Room:" + room_number;
	}
	
	

}
