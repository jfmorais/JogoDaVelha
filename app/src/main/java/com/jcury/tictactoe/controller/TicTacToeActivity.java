package com.jcury.tictactoe.controller;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;

import com.jcury.tictactoe.R;
import com.jcury.tictactoe.model.TicTacToe;


/**
 * Created by Android on 28/07/2017.
 */

public class TicTacToeActivity extends AppCompatActivity {

    private int moveCount = 0, xloc = 0, yloc = 0;
    private String mark = "X", aiMark = "O";
    private boolean isOver = false;
//    private AI ai = null;

    private TicTacToe tabuleiro;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tic_tac_toe_view);

        tabuleiro = new TicTacToe();
        //TODO criar IA
    }

    public void reset(View v) {
        clear();
//        if (aiMark =="X") getAIMove(board);

    }

    public void cellClick(View v) {
//        Log.i("SPLASH",  findViewById(v.getId()).toString() );
        int x=0, y=0;
        TextView cell = (TextView) findViewById(v.getId());
        String content = (String) cell.getText();

        if (content == "" && !isOver) {
            switch (cell.getId()) {

                case R.id.celula_1_1:
                    x = 0;
                    y = 0;
                    break;
                case R.id.celula_1_2:
                    x = 0;
                    y = 1;
                    break;
                case R.id.celula_1_3:
                    x = 0;
                    y = 2;
                    break;
                case R.id.celula_2_1:
                    x = 1;
                    y = 0;
                    break;
                case R.id.celula_2_2:
                    x = 1;
                    y = 1;
                    break;
                case R.id.celula_2_3:
                    x = 1;
                    y = 2;
                    break;
                case R.id.celula_3_1:
                    x = 2;
                    y = 0;
                    break;
                case R.id.celula_3_2:
                    x = 2;
                    y = 1;
                    break;
                case R.id.celula_3_3:
                    x = 2;
                    y = 2;
                    break;

            }
            cell.setText(mark);
            tabuleiro.setValorXY(x,y,mark);

            moveCount++;
            isOver = tabuleiro.isWinner();

            if(!isOver){
                //TODO mover ia
            }

        }
    }

    public void onRadioButtonClicked(View view) {

        boolean checked = ((RadioButton) view).isChecked();
        switch (view.getId()) {

            case R.id.radio_X:
                if (checked) {
                    mark = "X";
                }
                aiMark = "O";
                clear();
                break;
            case R.id.radio_O:
                if (checked) {
                    mark = "O";
                }
                aiMark = "X";
                clear();
                //TODO mover IA
                break;
        }
    }

    private void clear() {

        int[] idList = { R.id.celula_1_1, R.id.celula_1_2, R.id.celula_1_3, R.id.celula_2_1, R.id.celula_2_2, R.id.celula_2_3, R.id.celula_3_1, R.id.celula_3_2, R.id.celula_3_3 };
        TextView cell;

        for (int item : idList) {

            cell = (TextView) findViewById(item);
            cell.setText("");

        }

        isOver = false;
        moveCount = 0;
        tabuleiro.resetar();

    }
}