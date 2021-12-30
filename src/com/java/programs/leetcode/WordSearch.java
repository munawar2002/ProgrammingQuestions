package com.java.programs.leetcode;

import java.util.List;

public class WordSearch {

    public boolean exist(char[][] board, String word) {

        if(board.length==0 || board[0].length==0 || word == null ||word.isEmpty()){
            return false;
        }

        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[i].length; j++){
                if(board[i][j] == word.charAt(0)){
                    if(search(board,i,j,word,0)){
                        return true;
                    }
                }
            }
        }

        return false;
    }

    private boolean search(char[][] board, int i, int j, String word, int matched) {

        if(matched == word.length()){
            return true;
        }

        if(i<0 || j<0 || i> board.length-1 || j > board[i].length -1 || board[i][j] != word.charAt(matched)){
            return false;
        }

        board[i][j] = '#';

        boolean result = search(board,i,j+1,word,matched+1) || // right
                         search(board,i,j-1,word,matched+1) || // left
                         search(board,i+1,j,word,matched+1) || // down
                         search(board,i-1,j,word,matched+1) ; // up

        board[i][j] = word.charAt(matched);
        return result;
    }

    public static void main(String[] args) {
        WordSearch wordSearch = new WordSearch();

        // case 1
        char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String word = "ABCCED";
        System.out.println(wordSearch.exist(board, word));

        // case 2
        String word2 = "SEE";
        System.out.println(wordSearch.exist(board, word2));

        // case 3
        String word3 = "ABCB";
        System.out.println(wordSearch.exist(board, word3));

    }

}
