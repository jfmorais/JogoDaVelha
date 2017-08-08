package com.jcury.tictactoe.model;

/**
 * Created by Android on 28/07/2017.
 */

public class TicTacToe {

    private String[][] tabuleiro = new String[3][3];

    public TicTacToe (){
        for (int i = 0;i<3;i++){
            for(int j=0;j<3;j++){
                this.tabuleiro[i][j] = "";
            }
        }
    }

    public void setValorXY(int x, int y, String valor){
        if(this.tabuleiro[x][y].isEmpty()) {
            this.tabuleiro[x][y] = valor;
        }
    }

    public String[][] getTabuleiro() {
        return tabuleiro;
    }

    public void setTabuleiro(String[][] tabuleiro) {
        this.tabuleiro = tabuleiro;
    }

    public void resetar(){
        for (int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                this.tabuleiro[i][j] = "";
            }
        }
    }

    public boolean isWinner(){

        if(tabuleiro[0][0].equalsIgnoreCase(tabuleiro[1][1]) && tabuleiro[0][0].equalsIgnoreCase(tabuleiro[2][2]) && tabuleiro[0][0] != ""){
            System.out.println("ganhou1");
            return true;
        }

        if(tabuleiro[0][2].equalsIgnoreCase(tabuleiro[1][1]) && tabuleiro[0][2].equalsIgnoreCase(tabuleiro[2][0]) && tabuleiro[0][2] != ""){
            System.out.println("ganhou2");
            return true;
        }

        for (int i = 0; i < 3; i++){
            if(tabuleiro[i][0].equalsIgnoreCase(tabuleiro[i][1]) && tabuleiro[i][0].equalsIgnoreCase(tabuleiro[i][2]) && tabuleiro[i][0] != ""){
                System.out.println("ganhou3");
                return true;
            }

            if(tabuleiro[0][i].equalsIgnoreCase(tabuleiro[1][i]) && tabuleiro[0][i].equalsIgnoreCase(tabuleiro[2][i]) && tabuleiro[0][i] != ""){
                System.out.println("ganhou4");
                return true;

            }
        }

        return false;
    }
}
