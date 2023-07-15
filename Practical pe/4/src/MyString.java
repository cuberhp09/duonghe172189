/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Admin
 */
public class MyString implements IString {

    @Override
    public int f1(String str) {
        char[] charArr = str.toCharArray();
        int count = 0;
        for (char c : charArr) {
            if (c == '2' || c == '3' || c == '5' || c == '7') {
                count++;

            }
        }
        return count;
    }

    @Override
    public String f2(String str) {
        String[] words = str.split(" ");
        String output = "";
        
        for (int i =words.length-1;i>=0;i--){
            output += words[i] + " ";
        }
        
        return output.trim();
    }

}
