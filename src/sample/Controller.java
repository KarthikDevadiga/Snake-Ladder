package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;


import java.util.Random;

public class Controller {


    @FXML
    Circle circle1;
    @FXML
    Circle circle2;
    @FXML
    GridPane gridPane;

    @FXML
    Button button;

    @FXML
    ImageView imageView;

    @FXML
    Label label;

    int player = 1;



    int  cc = 0;
    int cr = 9;


    int  cc2 = 0;
    int cr2 = 9;

    boolean straight = true; //from 0-9
    boolean straight2 = true; //from 0-9

    int[] arr;



    public void onClick(ActionEvent e){
        if((cr == 0 && cc ==0) || (cr2 == 0 && cc2 ==0)){
            if(cr == 0 && cc ==0){
                button.setVisible(false);
                String result = "player 1 wins";
                label.setText(result);
                label.setTextFill(Color.color(0.92, 0.18, 0.39));

            }
            else{
                button.setVisible(false);
                String result = "player 2 wins";
                label.setText(result);
                label.setTextFill(Color.color(0.92, 0.18, 0.39));

            }
        }

        else{
            Random rn = new Random();
            int diceNo = rn.nextInt(6) + 1;
            String img = "images/dice" + diceNo + ".png";
            Image image = new Image(getClass().getResourceAsStream(img));
            imageView.setImage(image);



            if(player == 1){ ////////////////////////////////////// player 1
                label.setText("Player : 2");
                if(straight){
                    increment(diceNo);
                }else{
                    decrement(diceNo);
                }
                checkOurPosition(cr, cc);
                GridPane.setConstraints(circle1, cc, cr);
                if((cr == 0 && cc ==0) || (cr2 == 0 && cc2 ==0)){
                    if(cr == 0 && cc ==0){
                        button.setVisible(false);
                        String result = "player 1 wins";
                        label.setText(result);
                        label.setTextFill(Color.color(0.92, 0.18, 0.39));

                    }
                    else{
                        button.setVisible(false);
                        String result = "player 2 wins";
                        label.setText(result);
                        label.setTextFill(Color.color(0.92, 0.18, 0.39));

                    }
                }
//                player++;
            }else{ /////////////////////////////////////////// player 2
                label.setText("Player : 1");
                if(straight2){
                    increment2(diceNo);

                }else{
                    decrement2(diceNo);

                }
                checkOurPosition(cr2, cc2);
                GridPane.setConstraints(circle2, cc2, cr2);
                if((cr == 0 && cc ==0) || (cr2 == 0 && cc2 ==0)){
                    if(cr == 0 && cc ==0){
                        button.setVisible(false);
                        String result = "player 1 wins";
                        label.setText(result);
                        label.setTextFill(Color.color(0.92, 0.18, 0.39));

                    }
                    else{
                        button.setVisible(false);
                        String result = "player 2 wins";
                        label.setText(result);
                        label.setTextFill(Color.color(0.92, 0.18, 0.39));

                    }
                }
//                player--;
            }
        }






    }


    public void increment(int diceNo){
        int i = 9 - cc;
        int finalc;
        if(diceNo > i) {
            int k = cc + diceNo;
            finalc = k - 9;
            cr--;
            finalc = 10 - finalc;
            straight = false;
        }else{
            finalc = cc + diceNo;
            straight = true;
        }

        cc = finalc;
        System.out.println("dice value -> " +diceNo);
        System.out.println(cc);
    }

    public void decrement(int diceNo){
        int remainingBox = 10 - cc;
        int remainingBox1 = 10 - remainingBox;
        if(diceNo <= (remainingBox1)){
            cc -= diceNo;
            System.out.println(diceNo);
            System.out.println("revarse -> false -> " + cc);
        }
        else if((cr == 0) && (diceNo > remainingBox1)){
            System.out.println("reached");
            return;
        }
        else{
            System.out.println("current c -> " + cc);
            int remainingSpace = 10 - cc; //
            int remainingValue;
            if(diceNo > remainingBox1) {
                remainingValue = diceNo - remainingBox1;
            }
            else{
                remainingValue = remainingBox1 - diceNo;
            }
            if(((cr == 0) && (cc == 0)) || ((cr == 0) && (diceNo > remainingBox1))){
                if(diceNo > remainingBox1){
                    int i = diceNo - remainingBox1;
                    int j = diceNo - i;
                    cc -= j;
                    String result = "player 1 wins";
                    label.setText(result);
                    label.setTextFill(Color.color(0.92, 0.18, 0.39));
                    button.setVisible(false);
                    return;

                }
                String result = "player 1 wins";
                label.setText(result);
                label.setTextFill(Color.color(0.92, 0.18, 0.39));
                button.setVisible(false);
            }else{
                cr--;
                cc = remainingValue;
                cc = cc - 1;
                straight = true;
                System.out.println("dice value -> " +diceNo);
                System.out.println("revarse -> true -> " + cc);
            }

        }
    }





    /////////////////////////////////////////////////////////////
    public void increment2(int diceNo){
        int i = 9 - cc2;
        int finalc;
        if(diceNo > i) {
            int k = cc2 + diceNo;
            finalc = k - 9;
            cr2--;
            finalc = 10 - finalc;
            straight2 = false;
        }else{
            finalc = cc2 + diceNo;
            straight2 = true;
        }

        cc2 = finalc;
        System.out.println("dice value -> " +diceNo);
        System.out.println(cc2);
    }

    public void decrement2(int diceNo){
        int remainingBox = 10 - cc2;
        int remainingBox1 = 10 - remainingBox;
        if(diceNo <= (remainingBox1)){
            cc2 -= diceNo;
            System.out.println(diceNo);
            System.out.println("revarse -> false -> " + cc2);
        } else if((cr2 == 0) && (diceNo > remainingBox1)){
            System.out.println("reached");
            return;
        }
        else{
            System.out.println("current c -> " + cc2);
            int remainingSpace = 10 - cc2; // no use
            int remainingValue;
            if(diceNo > remainingBox1) {
                remainingValue = diceNo - remainingBox1;
            }
            else{
                remainingValue = remainingBox1 - diceNo;
            }
            if(((cr2 == 0) && (cc2 == 0)) || ((cr2 == 0) && (diceNo > remainingBox1))){
                if(diceNo > remainingBox1){
                    int i = diceNo - remainingBox1;
                    int j = diceNo - i;
                    cc2 -= j;
                    String result = "player 2 wins";
                    label.setText(result);
                    label.setTextFill(Color.color(0.92, 0.18, 0.39));
                    button.setVisible(false);
                    return;

                }
                String result = "player 2 wins";
                label.setText(result);
                label.setTextFill(Color.color(0.92, 0.18, 0.39));
                button.setVisible(false);
            }else{
                cr2--;
                cc2 = remainingValue;
                cc2 = cc2 - 1;
                straight2 = true;
                System.out.println("dice value -> " +diceNo);
                System.out.println("revarse -> true -> " + cc2);
            }

        }
    }

    public void checkOurPosition(int cur, int cuc){
        if((cur == 9) && (cuc == 3)){
//            arr = gotLadder(cur, cuc, 4, 4);
            if(player == 1){
                cr = 4;
                cc = 4;
                straight = false;
                label.setText("🎆 Player : 1 🎇");
            }else{
                cr2 = 4;
                cc2 = 4;
                straight2 = false;
                label.setText("🎆 Player : 2 🎇");
            }

        }
        else if((cur == 8) && (cuc == 8)){
//            arr = gotLadder(cur, cuc, 5, 9);
            if(player == 1){
                cr = 5;
                cc = 9;
                straight = true;
                label.setText("🎆 Player : 1 🎇");
            }else{
                cr2 = 5;
                cc2 = 9;
                straight2 = true;
                label.setText("🎆 Player : 2 🎇");
            }
        }
        else if((cur == 8) && (cuc == 6)){
//            arr = gotLadder(cur, cuc, 4, 5);
            if(player == 1){
                cr = 4;
                cc = 5;
                straight = false;
                label.setText("🎆 Player : 1 🎇");
            }else{
                cr2 = 4;
                cc2 = 5;
                straight2 = false;
                label.setText("🎆 Player : 2 🎇");
            }
        }
        else if((cur == 7) && (cuc == 1)){
//            arr = gotLadder(cur, cuc, 4, 5);
            if(player == 1){
                cr = 4;
                cc = 2;
                straight = false;
                label.setText("🎆 Player : 1 🎇");
            }else{
                cr2 = 4;
                cc2 = 2;
                straight2 = false;
                label.setText("🎆 Player : 2 🎇");
            }
        }
        else if((cur == 5) && (cuc == 0)){
//            arr = gotLadder(cur, cuc, 4, 5);
            if(player == 1){
                cr = 2;
                cc = 1;
                straight = false;
                label.setText("🎆 Player : 1 🎇");
            }else{
                cr2 = 2;
                cc2 = 1;
                straight2 = false;
                label.setText("🎆 Player : 2 🎇");
            }
        }
        else if((cur == 4) && (cuc == 6)){
//            arr = gotLadder(cur, cuc, 4, 5);
            if(player == 1){
                cr = 1;
                cc = 7;
                straight = true;
                label.setText("🎆 Player : 1 🎇");
            }else{
                cr2 = 1;
                cc2 = 7;
                straight2 = true;
                label.setText("🎆 Player : 2 🎇");
            }
        }
        // snake
        else if((cur == 7) && (cuc == 7)){
//            arr = gotLadder(cur, cuc, 4, 5);
            if(player == 1){
                cr = 9;
                cc = 9;
                straight = true;
                player++;
            }else{
                cr2 = 9;
                cc2 = 9;
                straight2 = true;
                player--;
            }
        }
        else if((cur == 6) && (cuc == 3)){
//            arr = gotLadder(cur, cuc, 4, 5);
            if(player == 1){
                cr = 9;
                cc = 2;
                straight = true;
                player++;
            }else{
                cr2 = 9;
                cc2 = 2;
                straight2 = true;
                player--;
            }
        }
        else if((cur == 5) && (cuc == 6)){
//            arr = gotLadder(cur, cuc, 4, 5);
            if(player == 1){
                cr = 8;
                cc = 4;
                straight = false;
                player++;
            }else{
                cr2 = 8;
                cc2 = 4;
                straight2 = false;
                player--;
            }
        }
        else if((cur == 2) && (cuc == 5)){
//            arr = gotLadder(cur, cuc, 4, 5);
            if(player == 1){
                cr = 6;
                cc = 8;
                straight = false;
                player++;
            }else{
                cr2 = 6;
                cc2 = 8;
                straight2 = false;
                player--;
            }
        }
        else if((cur == 0) && (cuc == 6)){
//            arr = gotLadder(cur, cuc, 4, 5);
            if(player == 1){
                cr = 2;
                cc = 9;
                straight = false;
                player++;
            }else{
                cr2 = 2;
                cc2 = 9;
                straight2 = false;
                player--;
            }
        }
        else if((cur == 0) && (cuc == 4)){
//            arr = gotLadder(cur, cuc, 4, 5);
            if(player == 1){
                cr = 5;
                cc = 1;
                straight = true;
                player++;
            }else{
                cr2 = 5;
                cc2 = 1;
                straight2 = true;
                player--;
            }
        }
        else{
            if(player == 1){
                player++;
            }else{
                player--;
            }
        }
    }

    public int[] gotLadder(int cr, int cc, int dr, int dc){
        return new int[]{dr, dc};
    }


}
