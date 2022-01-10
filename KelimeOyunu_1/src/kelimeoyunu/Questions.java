package kelimeoyunu;

public class Questions {
    private String question, answer;
    private int digit;
    
    public Questions(String question, String answer) {
        this.question = question;
        this.answer = answer;
        digit = answer.length();
    }
    
    public String getQuestion() {
        return question;
    }
    
    public String getAnswer() {
        return answer;
    }
    
    public int getDigit() {
        return digit;
    }
    
    public char[] StToChar() {
        char words[] = new char[digit];
        for (int i = 0; i < digit; i++) {
            words[i] = getAnswer().charAt(i);
        }
        return words;
    }
    
}
