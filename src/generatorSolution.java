public class generatorSolution {

    private String solutionText;
    private String hintText;
    private Boolean innitRight = false;

    public String generateSolutionText(Integer difficulty, Integer knotGrade, Integer length){
        return solutionText;
    }

    public String generateHintText(Integer difficulty, Integer knotGrade, Integer length){
        return hintText;
    }

    public Boolean compareSolution(String solutionText, String answerText){
        if(answerText == solutionText){
            innitRight = true;
        }
        return innitRight;
    }
}
