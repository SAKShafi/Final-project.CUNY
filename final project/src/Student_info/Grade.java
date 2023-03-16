package Student_info;

public class Grade {
	static double total;
	
        public static double  grade(double quiz , double test1, double midterm, double test3, double finalTest, double Presentation, double coding) {
		
        	
        
        //regular calculation  for each student 	
        	/*
             *   
             *  ID Name	    quiz /2%	Test-1 / 50/10% |	Mid-Term / 50/30% | Test-3 /30/10%	Final / 50/40%	Presentation 2%	Coding Project/ 6%
        	* */
        	
        	
		quiz = (0.02*quiz);	
		test1 = ( test1 / 50 ) * 10;
		midterm = ( midterm / 50 ) * 30;
		test3 =  ( test3/30 ) * 10;
		finalTest= ( finalTest / 50 ) * 40;
	    Presentation=( Presentation / 2 ) * 2 ;
	    coding=  ( coding/6 ) * 6;
	    
		
		
		
	 total= quiz+test1+midterm+ test3+finalTest+Presentation+coding;
		
		return total;
		
		
		
		
		
 }
	
	
	
	
	
	
}

