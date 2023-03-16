package Student_info;


// sperate object file 
// public only aceess into this class
public class Student {
    private String id;
    private String name;
    private double test1;
    private double midTermTest;
    private double test3;
    private double finalTest;
    private double presentation;
    private double codingProject;
    private double quiz;
    public String letterGrade;
    

    
   
    
    // here 1 is setting the value 
    //other is getting the value 
    public Student(){

    }

    public Student ( String id, String name ){
        this.id = id;
        this.name = name;
    }

    public void setId( String id ){
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTest1(double test1) {
        this.test1 = test1;
    }

    public void setMidTermTest(double midTermTest) {
        this.midTermTest = midTermTest;
    }

    public void setTest3(double test3) {
        this.test3 = test3;
    }

    public void setFinalTest(double finalTest) {
        this.finalTest = finalTest;
    }

    public void setPresentation(double presentation) {
        this.presentation = presentation;
    }

    public void setCodingProject(double codingProject) {
        this.codingProject = codingProject;
    }

    public void setQuiz(double quiz) {
        this.quiz = quiz;
    }

    public String getName() {
        return name;
    }

    public double getTest1() {
        return test1;
    }

    public double getMidTermTest() {
        return midTermTest;
    }

    public double getTest3() {
        return test3;
    }

    public double getFinalTest() {
        return finalTest;
    }

    public double getPresentation() {
        return presentation;
    }

    public double getCodingProject() {
        return codingProject;
    }

    public double getQuiz() {
        return quiz;
    }

    public String getId(){
        return this.id;
    }
    
    public String getletterGrade(){
        return this.letterGrade;
    }
    


    @Override
    //When a method is overriding a superclass,
    //Parent(superclass/child (subclass))

    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", test1=" + test1 +
                ", midTermTest=" + midTermTest +
                ", test3=" + test3 +
                ", finalTest=" + finalTest +
                ", presentation=" + presentation +
                ", codingProject=" + codingProject +
                ", quiz=" + quiz +
                ", grade=" + letterGrade +
                '}';

    }
}




