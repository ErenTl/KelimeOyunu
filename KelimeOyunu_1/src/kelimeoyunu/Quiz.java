package kelimeoyunu;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class Quiz implements ActionListener{
    
    
    private Questions[] qList;
    
    
    char guess;
    char answer;
    int index=-1;
    int total_questions = 14;
    int result;
    int seconds=240;
    int digit;
    int remainingDigit;
    int totalScore=0;
    int score;
    
    
    JFrame frame = new JFrame();
    JTextField textField = new JTextField();
    JTextArea textArea = new JTextArea();
    JButton buttonA = new JButton();
    JButton buttonB = new JButton();
    JButton buttonC = new JButton();
    JButton buttonD = new JButton();
    JLabel timeLabel = new JLabel();
    JLabel secondsLeft = new JLabel();
    JTextField numberRight = new JTextField();
    JTextField percentage = new JTextField();
    JTextField answerField = new JTextField();
    JLabel tsLabel = new JLabel();
    JLabel scoreLabel = new JLabel();
    JLabel finalScore = new JLabel();
    
    JLabel questionGaps[] = new JLabel[10];
    
    Timer timer = new Timer(1000,new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            seconds--;
            secondsLeft.setText(String.valueOf(seconds));
            if(seconds<=0) {
                results();
            }
        }
    });
    
    public Quiz(Questions[] qList) {
        this.qList = qList;
        timer.start();
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(650, 650);
        frame.getContentPane().setBackground(Color.CYAN);
        frame.setLayout(null);
        frame.setResizable(false);
        
        textField.setBounds(0, 0, 650, 50);
        textField.setBackground(Color.red);
        textField.setForeground(Color.BLACK);
        textField.setFont(new Font("",Font.ITALIC, 30));
        textField.setBorder(BorderFactory.createBevelBorder(1));
        textField.setHorizontalAlignment(JTextField.CENTER);
        textField.setEditable(false);
        
        textArea.setBounds(0, 50, 650, 80);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setBackground(Color.red);
        textArea.setForeground(Color.BLACK);
        textArea.setFont(new Font("",Font.ITALIC, 25));
        textArea.setBorder(BorderFactory.createBevelBorder(1));
        textArea.setEditable(false);
        textArea.setText("SAMPLE TEXT"); 
        
        answerField.setBounds(0, 375, 250, 50);
        answerField.setBackground(Color.red);
        answerField.setForeground(Color.BLACK);
        answerField.setFont(new Font("",Font.ITALIC, 25));
        answerField.setBorder(BorderFactory.createLineBorder(Color.yellow,1));
        
        buttonA.setBounds(0, 250, 100, 100);
        buttonA.setFont(new Font("",Font.ITALIC, 35));
        buttonA.setFocusable(false);
        buttonA.addActionListener(this);
        buttonA.setText("Harf");
        
        buttonB.setBounds(260, 375, 200, 50);
        buttonB.setFont(new Font("",Font.ITALIC, 35));
        buttonB.setFocusable(false);
        buttonB.addActionListener(this);
        buttonB.setEnabled(false);
        buttonB.setText("Cevap");
        
        
       
        buttonC.setBounds(110, 250, 150, 100);
        buttonC.setFont(new Font("",Font.ITALIC, 30));
        buttonC.setFocusable(false);
        buttonC.addActionListener(this);
        buttonC.setText("Durdur");
        
        buttonD.setBounds(270, 250, 100, 100);
        buttonD.setFont(new Font("",Font.ITALIC, 35));
        buttonD.setFocusable(false);
        buttonD.addActionListener(this);
        buttonD.setText("Pas");
        
        
        
        secondsLeft.setBounds(535, 510, 100, 100);
        secondsLeft.setBackground(Color.BLACK);
        secondsLeft.setForeground(Color.RED);
        secondsLeft.setFont(new Font("",Font.BOLD,50));
        secondsLeft.setBorder(BorderFactory.createLineBorder(Color.red, 3));
        secondsLeft.setOpaque(true);
        secondsLeft.setHorizontalAlignment(JTextField.CENTER);
        secondsLeft.setText(String.valueOf(seconds));
        
        tsLabel.setBounds(0, 450, 200, 75);
        tsLabel.setBackground(Color.BLACK);
        tsLabel.setForeground(Color.yellow);
        tsLabel.setFont(new Font("",Font.ITALIC,20));
        tsLabel.setBorder(BorderFactory.createLineBorder(Color.yellow, 3));
        tsLabel.setOpaque(true);
        tsLabel.setHorizontalAlignment(JTextField.LEFT);
        tsLabel.setText("Toplam Puan: "+0);
        
        scoreLabel.setBounds(0, 525, 200, 75);
        scoreLabel.setBackground(Color.BLACK);
        scoreLabel.setForeground(Color.yellow);
        scoreLabel.setFont(new Font("",Font.ITALIC,20));
        scoreLabel.setBorder(BorderFactory.createLineBorder(Color.yellow, 3));
        scoreLabel.setOpaque(true);
        scoreLabel.setHorizontalAlignment(JTextField.LEFT);
        scoreLabel.setText("Sorunun Puanı: ");
        
        for (int i = 0; i < 10; i++) {
            questionGaps[i] = new JLabel();
            questionGaps[i].setBounds((10+(i*62)), 150, 60, 60);
            questionGaps[i].setFont(new Font("",Font.BOLD,50));
            questionGaps[i].setHorizontalAlignment(JTextField.CENTER);
            frame.add(questionGaps[i]);
        }
        
        
        
        frame.add(secondsLeft);
        frame.add(buttonA);
        frame.add(buttonB);
        frame.add(buttonC);
        frame.add(buttonD);
        frame.add(textArea);
        frame.add(textField);
        frame.add(answerField);
        frame.add(tsLabel);
        frame.add(scoreLabel);
        frame.setVisible(true);
        
        
        
        nextQuestion();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == buttonA) {
            appearDigit(false);
            score-=100;
            scoreLabel.setText("Sorunun Puanı: "+score);
        }
        if(e.getSource() == buttonB) {
            if(answerField.getText().equals(qList[index].getAnswer())) {
                System.out.println("WUHUUUUUUUUU");
                appearDigit(true);
                //waitToNext();
                buttonA.setEnabled(false);
                buttonB.setEnabled(false);
                buttonC.setEnabled(false);
                buttonD.setEnabled(false);
            }
        }
        
        if(e.getSource() == buttonC) {
            buttonA.setEnabled(false);
            buttonB.setEnabled(true);
            buttonC.setEnabled(false);
            timer.stop();
        }
        
        if(e.getSource() == buttonD) {
            
            appearDigit(true);
            score=0;
            buttonA.setEnabled(false);
            buttonB.setEnabled(false);
            buttonC.setEnabled(false);
            buttonD.setEnabled(false);
            //waitToNext();
        }
        
        
    }
    
    public void nextQuestion() {
        
        System.out.println("score: "+score+" index: "+index);
        totalScore+=score;
        timer.start();
        index++;
        if(index==14) {
            results();
        }
        System.out.println("score: "+score+" index: "+index);
        clearDigit();
        digit = qList[index].getDigit();
        score = 100*digit;
        System.out.println("score: "+score+" index: "+index);
        remainingDigit = digit;
        
        
        
        answerField.setText("");
        tsLabel.setText("Toplam Puan: "+totalScore);
        scoreLabel.setText("Sorunun Puanı: "+score);
        buttonA.setEnabled(true);
        buttonB.setEnabled(false);
        buttonC.setEnabled(true);
        buttonD.setEnabled(true);
        questionGap();
        if(index>=total_questions) {
            results();
        }else{
            textField.setText("Soru "+(index+1));
            textArea.setText(qList[index].getQuestion());
        }
    }
    
    public void results() {
        clearDigit();
        for (int i = 0; i < 10; i++) {
            questionGaps[i].setBorder(BorderFactory.createLineBorder(Color.cyan, 4));
        }
        buttonA.setVisible(false);
        buttonB.setVisible(false);
        buttonC.setVisible(false);
        buttonD.setVisible(false);
        answerField.setVisible(false);
        scoreLabel.setVisible(false);
        tsLabel.setVisible(false);
        secondsLeft.setVisible(false);
        textArea.setVisible(false);
        textField.setVisible(false);
        
        finalScore.setBounds(0, 200, 600, 200);
        finalScore.setBackground(Color.BLACK);
        finalScore.setForeground(Color.red);
        finalScore.setFont(new Font("",Font.BOLD,50));
        finalScore.setBorder(BorderFactory.createLineBorder(Color.red, 3));
        finalScore.setOpaque(true);
        finalScore.setHorizontalAlignment(JTextField.CENTER);
        finalScore.setText("Final Puanınız: "+totalScore);
        finalScore.setVisible(true);
        frame.add(finalScore);
    }
    
    public void questionGap() {
        
        for (int i = 0; i < 10; i++) {
            if(i<digit) {
                questionGaps[i].setBorder(BorderFactory.createLineBorder(Color.red, 4));
                
            }
        }
    }
    
    public void appearDigit(boolean appearAll) {
        if(appearAll) {
            for (int i = 0; i < digit; i++) {
                questionGaps[i].setText(String.valueOf(qList[index].StToChar()[i]).toUpperCase());
                remainingDigit = 0;
            }
        }else{
            int ran;
            do {                
                ran= randomNum(0, (digit-1));
            } while (!(questionGaps[ran].getText()==""));
            questionGaps[ran].setText(String.valueOf(qList[index].StToChar()[ran]).toUpperCase());
            remainingDigit--;
        }
        
        if(remainingDigit==0) {
            buttonA.setEnabled(false);
            
            waitToNext();
        }
        
    }
    
    public void clearDigit() {
        for (int i = 0; i < digit; i++) {
            questionGaps[i].setText("");
        }
    }
    
    public void waitToNext() {
        System.out.println("kelimeoyunu.Quiz.waitToNext()");
        Timer pause = new Timer(2000, new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                nextQuestion();
                System.out.println(".actionPerformed()");
            }
        });
        pause.setRepeats(false);
	pause.start();
    }
    
    public static int randomNum(int min, int max) {
		int range = (max - min) + 1;
		return (int)(Math.random() * range) + min;
    }
    
}
