/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameStage;

import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Circle;

/**
 * FXML Controller class
 *
 * @author notda
 */
public class MainGameStageController implements Initializable {

    @FXML
    private Button flodBtn, checkBtn, callBtn, raiseBtn, btn500, btn100, btn50, btn20, allInBtn, resetBtn, confirmBtn, mainMenuBtn, restartBtn;
    @FXML
    private Label comBalance, potBalance, playerName, playerBalance, playerOnHand, comOnHand, comPlay, playerPlay, playerRiseBalance;
    @FXML
    private Circle comButton, playerBtn;
    @FXML
    private ImageView player01, player02, flop01, flop02, flop03, turn, river, com01, com02;

    Random rand = new Random();
    private int[] suitPot = new int[5];
    private int[] numPot = new int[5];
    private int[] suitPlay = new int[2];
    private int[] numPlay = new int[2];
    private int[] suitCom = new int[2];
    private int[] numCom = new int[2];
    private int[][] recheck = new int[4][13];
    private int turnPlayed = 0;
    private int TURNPlayed = 0;
    private int playerLeftBalance = 0;
    private int comLeftBalance = 0;
    private int potLeftBalance = 0;
    private String playerHasPlay = "";
    private String comHasPlay = "";

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        turnPlayed = 0;
        TURNPlayed = 0;
        randCard();
        playerName.setText("Name");
        playerShowBalance(1500,0);
        comShowBalance(1500, 0);
        potShowBalance(0, 0);
        loadImageTurn(turnPlayed);
        showHandRank(turnPlayed, "player");
        comOnHand.setText("");
        setButton(TURNPlayed);
    }
    
    private void setButton (int TURNPlayed)
    {
        if(TURNPlayed % 2 == 0)
        {
            playerBtn.setVisible(true);
            comButton.setVisible(false);
        } else
        {
            playerBtn.setVisible(false);
            comButton.setVisible(true);
        }
    }
        
    private int checkHandRank(int turnPlayed,String who)
    {
        if(checkStraight(turnPlayed, who) == 2 && checkFlush(turnPlayed, who) == true)
        {
            return 10; //#1 Royal Straight Flush
        } else if (checkStraight(turnPlayed, who) == 1 && checkFlush(turnPlayed, who) == true)
        {
            return 9; //#2 Straight Flush
        } else if (checkFourOfKind(turnPlayed, who) == true)
        {
            return 8; //#3 Four Of Kind
        } else if (checkThreeOfKind(turnPlayed, who) == 2)
        {
            return 7; //#4 Full House (1 Three Of Kind and 1 Pair)
        } else if (checkThreeOfKind(turnPlayed, who) == 1 && checkPair(turnPlayed, who) >= 1)
        {
            return 7; //#4 Full House (1 Three Of Kind and 1 Pair)
        } else if (checkFlush(turnPlayed,who) == true)
        {
            return 6; //#5 Flush
        } else if (checkStraight(turnPlayed, who) == 1)
        {
            return 5; //#6 Straight
        } else if (checkThreeOfKind(turnPlayed, who) == 1)
        {
            return 4; //#7 Three Of Kind
        } else if (checkPair(turnPlayed, who) >= 2)
        {
            return 3; //#8 Two Pair
        } else if (checkPair(turnPlayed, who) == 1)
        {
            return 2; //#9 One Pair
        } else return 1; //High Card
    }
    
    private void showHandRank(int turnPlayed,String who)
    {
        String handRank;
        if(checkHandRank(turnPlayed, who) == 10)
        {
            handRank = "Royal Straight Flush";
        } else if(checkHandRank(turnPlayed, who) == 9)
        {
            handRank = "Straight Flush";
        } else if(checkHandRank(turnPlayed, who) == 8)
        {
            handRank = "Four Of Kind";
        } else if(checkHandRank(turnPlayed, who) == 7)
        {
            handRank = "Full House";
        }else if(checkHandRank(turnPlayed, who) == 6)
        {
            handRank = "Flush";
        }else if(checkHandRank(turnPlayed, who) == 5)
        {
            handRank = "Straight";
        }else if(checkHandRank(turnPlayed, who) == 4)
        {
            handRank = "Three Of Kind";
        }else if(checkHandRank(turnPlayed, who) == 3)
        {
            handRank = "Two Pair";
        }else if(checkHandRank(turnPlayed, who) == 2)
        {
            handRank = "One Pair";
        }else handRank = "High Card";
        
        if(who == "player")
        {
            playerOnHand.setText(handRank);
        } else comOnHand.setText(handRank);
    }
    
//    private void normalTurn (int turnPlayed , int TURNPlayed){
//    }
    
//    private void lastTurn (int TURNPlayed){
//    }
    
//    private String compareHandRank (){
//        return "winner";
//    }
    
//    private void comTurn (int turnPlayed, int TURNPlayed)
//    {
//    }
    
    
    
    @FXML
    private void flodBtnAction(ActionEvent event) {
    }

    @FXML
    private void checkBtnAction(ActionEvent event) {
    }

    @FXML
    private void callBtnAction(ActionEvent event) {
    }

    @FXML
    private void raiseBtnAction(ActionEvent event) {
    }

    @FXML
    private void btn500Action(ActionEvent event) {
    }

    @FXML
    private void btn100Action(ActionEvent event) {
    }

    @FXML
    private void btn50Action(ActionEvent event) {
    }

    @FXML
    private void btn20Action(ActionEvent event) {
    }

    @FXML
    private void allInBtnAction(ActionEvent event) {
    }

    @FXML
    private void resetBtnAction(ActionEvent event) {
        
    }

    @FXML
    private void confirmBtnAction(ActionEvent event) {
    }

    @FXML
    private void mainMenuBtnAction(ActionEvent event) {
        //return to mainMenu
    }

    @FXML
    private void restartBtnAction(ActionEvent event) {
    }
    
        private void playerShowBalance(int plus, int minus)
    {
        playerLeftBalance += plus;
        playerLeftBalance -= minus;
        playerBalance.setText(String.valueOf(playerLeftBalance));
    }
    
    private void comShowBalance(int plus, int minus)
    {
        comLeftBalance += plus;
        comLeftBalance -= minus;
        comBalance.setText(String.valueOf(comLeftBalance));
    }
    
    private void potShowBalance(int plus, int minus)
    {
        potLeftBalance += plus;
        potLeftBalance -= minus;
        potBalance.setText(String.valueOf(potLeftBalance));
    }

    private void randCard() { //random Card 
        for (int i = 0; i < 9; i++) {
            int suit;
            int num;
            do {
                suit = rand.nextInt(4); //Club = 0, Spade = 1, Heart = 2,Diamond = 3
                num = rand.nextInt(13) + 2; // 2 = 2, 3 = 3 ... J = 11, Q = 12, K = 13, A = 14 
                recheck[suit][num - 2]++; 
            } while (recheck[suit][num - 2] > 1); 
            if (i < 5) { //random card in POT
                suitPot[i] = suit;
                numPot[i] = num;
            } else if (i < 7) { //random card player
                suitPlay[i - 5] = suit;
                numPlay[i - 5] = num;
            } else { //random card Com
                suitCom[i - 7] = suit;
                numCom[i - 7] = num;
            }

        }
    }

    private void loadImage(ImageView imageView, int suit, int num) { //get Image from pic *00 is back Card
        Image image = new Image(getClass().getResourceAsStream("pic/" + suit + num + ".png"));
        imageView.setImage(image);
    }

    private void loadImageTurn(int turnPlayed)
    {
        if(turnPlayed >= 0)
        {
        loadImage(player01, suitPlay[0], numPlay[0]);
        loadImage(player02, suitPlay[1], numPlay[1]);
        loadImage(flop01, 0, 0);
        loadImage(flop02, 0, 0);
        loadImage(flop03, 0, 0);
        loadImage(turn, 0, 0);
        loadImage(river, 0, 0);
        loadImage(com01, 0, 0);
        loadImage(com02, 0, 0);
        }
        if(turnPlayed >= 1)
        {
        loadImage(flop01, suitPot[0], numPot[0]);
        loadImage(flop02, suitPot[1], numPot[1]);
        loadImage(flop03, suitPot[2], numPot[2]);
        }
        if(turnPlayed >= 2)
        {
        loadImage(turn, suitPot[3], numPot[3]);
        }
        if(turnPlayed >= 3)
        {
        loadImage(river, suitPot[4], numPot[4]);
        }
        if(turnPlayed >= 4)
        {
        loadImage(com01, suitCom[0], numCom[0]);
        loadImage(com02, suitCom[1], numCom[1]);
        }

    }
    
    private ArrayList collectCardPlayer(int turn, String type){ 
        
        ArrayList<Integer> collectCard = new ArrayList<>(); //CollectCard Pot-Player / turn
        if("num".equals(type))
        {
        for (int i = 0; i < 2; i++) {
            collectCard.add(numPlay[i]);
            }
        if (turn == 1 || turn == 2 || turn == 3) {
            for (int i = 0; i < 2 + turn; i++) {
                collectCard.add(numPot[i]);
                }
            }
        } else if (type == "suit")
        {
           for (int i = 0; i < 2; i++) {
            collectCard.add(suitPlay[i]);
            }
        if (turn == 1 || turn == 2 || turn == 3) {
            for (int i = 0; i < 2 + turn; i++) {
                collectCard.add(suitPot[i]);
                }
            } 
        }
        
        
        return collectCard;
    }
    
    private ArrayList collectCardCom(int turn, String type){
        
        ArrayList<Integer> collectCard = new ArrayList<>(); //CollectCard Pot-Com / turn
        if("num".equals(type))
        {
        for (int i = 0; i < 2; i++) {
            collectCard.add(numCom[i]);
            }
        if (turn == 1 || turn == 2 || turn == 3) {
            for (int i = 0; i < 2 + turn; i++) {
                collectCard.add(numPot[i]);
                }
            }
        } else if (type == "suit")
        {
           for (int i = 0; i < 2; i++) {
            collectCard.add(suitCom[i]);
            }
        if (turn == 1 || turn == 2 || turn == 3) {
            for (int i = 0; i < 2 + turn; i++) {
                collectCard.add(suitPot[i]);
                }
            } 
        }
        
        
        return collectCard;
    }    
    
    
    private int checkStraight(int turn ,String who) {
        int isStraight = 0;
        int check = 0;
        ArrayList<Integer> collectCard = new ArrayList<>();
        
        if(who == "player")
        { collectCard = collectCardPlayer(turn, "num"); //CollectCard Pot-Player / turn 
        } else collectCard = collectCardCom(turn, "num"); //CollectCard Pot-Com / turn 

        if (turn > 0) { //CheckStraight
            Collections.sort(collectCard);
            for (int i = 0; i < collectCard.size() - 1; i++) {
                while(Objects.equals(collectCard.get(i), collectCard.get(i + 1)) && i != collectCard.size())
                { i++; }
                if (Objects.equals(collectCard.get(i)+1, collectCard.get(i + 1))) {
                    check++;
                } else {
                    check = 0;
                }
                
                if(check == 4 && collectCard.get(collectCard.size()-1) == 14)
                {
                    isStraight = 2;
                } else if(check == 4)
                {
                    isStraight = 1;
                }
            }
        }

        return isStraight;

    }
    
    private boolean checkFlush(int turn , String who){
        boolean isFlush = false;
        int check = 0;
        ArrayList<Integer> collectCard = new ArrayList<>();
        
        if(who == "player")
        { collectCard = collectCardPlayer(turn, "suit"); //CollectCard Pot-Player / turn 
        } else collectCard = collectCardCom(turn, "suit"); //CollectCard Pot-Com / turn 

        if (turn > 0) { //CheckFlush
            Collections.sort(collectCard);
            for (int i = 0; i < collectCard.size() - 1; i++) {
                if (Objects.equals(collectCard.get(i), collectCard.get(i + 1))) {
                    check++;
                } else {
                    check = 0;
                }
                
                if(check == 4)
                {
                    isFlush = true;
                }
            }
        }

        return isFlush;
    }
    
    private boolean checkFourOfKind(int turn , String who)
    {
        boolean isFOK = false;
        int check = 0;
        ArrayList<Integer> collectCard = new ArrayList<>();
        
        if(who == "player")
        { collectCard = collectCardPlayer(turn, "num"); //CollectCard Pot-Player / turn 
        } else collectCard = collectCardCom(turn, "num"); //CollectCard Pot-Com / turn 

        if (turn > 0) { //CheckFourOfKind
            Collections.sort(collectCard);
            for (int i = 0; i < collectCard.size() - 1; i++) {
                if (Objects.equals(collectCard.get(i), collectCard.get(i + 1))) {
                    check++;
                } else {
                    check = 0;
                }
                
                if(check == 3)
                {
                    isFOK = true;
                }
            }
        }

        return isFOK;
    }
    
    private int checkThreeOfKind(int turn , String who)
    {
        int numOfTOK = 0;
        int check = 0;
        ArrayList<Integer> collectCard = new ArrayList<>();
        
        if(who == "player")
        { collectCard = collectCardPlayer(turn, "num"); //CollectCard Pot-Player / turn 
        } else collectCard = collectCardCom(turn, "num"); //CollectCard Pot-Com / turn 

        if (turn > 0) { //CheckThreeOfKind
            Collections.sort(collectCard);
            for (int i = 0; i < collectCard.size() - 1; i++) {
                if (Objects.equals(collectCard.get(i), collectCard.get(i + 1))) {
                    check++;
                } else {
                    check = 0;
                }
                
                if(check == 2)
                {
                    numOfTOK ++;
                }
            }
        }

        return numOfTOK;
    }
    
    private int checkPair(int turn , String who)
    {
        int numOfPair = 0;
        int check = 0;
        ArrayList<Integer> collectCard = new ArrayList<>();
        
        if(who == "player")
        { collectCard = collectCardPlayer(turn, "num"); //CollectCard Pot-Player / turn 
        } else collectCard = collectCardCom(turn, "num"); //CollectCard Pot-Com / turn 

        //CheckPair
        Collections.sort(collectCard);
            for (int i = 0; i < collectCard.size() - 1; i++) {
                if (Objects.equals(collectCard.get(i), collectCard.get(i + 1))) {
                    check++;
                } else {
                    check = 0;
                }
                
                if(check == 1)
                {
                    numOfPair++;
                }
                if(check > 1) //Do not collect ThreeOfKind Or FourOfKind
                {
                    numOfPair--;
                }

        }

        return numOfPair;
    }
}
