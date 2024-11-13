package pkg1.simplejava;

class TimeTable{
	String dayOfWeek="Mon";
    String branch;
    String classSection;
    int period;
    String roomNo;
    boolean isLab=false;
    String faculty1;
    String faculty2;
    String subject1;
    String subject2;
    
    TimeTable(String b1, String c, String r){
    	this.branch=b1;
    	this.classSection=c;
    	this.roomNo=r;
    }
    
    public void printTimeTable(){
    	System.out.println("This is time table for " +branch + "Section " +classSection + " at"+roomNo);
    }
}
public class S1{
	public static void main(String[] args){
		System.out.println("TimeTable");
		TimeTable ttA = new TimeTable(" CSE ","A", " A203 ");
		TimeTable ttB = new TimeTable(" CSE ","B", " A203 ");
		ttA.printTimeTable();
		ttB.printTimeTable();
        ttA.faculty1="Kuthyar";
        ttA.faculty2="Savitha";
        ttA.subject1="OOPJ";
        ttA.subject2="OS";
        System.out.println(ttA.faculty1 + " - "+ttA.subject1);
        System.out.println(ttA.faculty2 + " - "+ttA.subject2);
	}
}