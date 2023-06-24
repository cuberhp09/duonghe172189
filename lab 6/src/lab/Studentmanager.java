/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab;

/**
 *
 * @author Admin
 */
import java.util.ArrayList;
import java.util.*;
public class Studentmanager {
    public static void main(String[] args) {
        String[] options = {"Add new student", "Search a student", "Update name and mark", "Remove a student", "List all", "Quit"};
        int choice = 0;
        boolean count = false;
        Scanner sc=new Scanner(System.in);
        Studentlist list = new Studentlist();
        outer: do{
            try{
                System.out.println("\nStudent managing program");
                choice=menu.getChoice(options);
                System.out.println("");
                switch (choice){
                    case 1:
                        list.addStudent();
                        count = true;
                        break;
                    case 2:
                        list.searchStudent();
                        count = true;
                        break;
                    case 3:
                        list.updateStudent();
                        count = true;
                        break;
                    case 4:
                        list.removeStudent();
                        count = true;
                        break;
                    case 5:
                        list.printAll();
                        count = true;
                        break;
                    case 6: 
                        System.out.println("Bye!");
                        break outer;
                    default: 
                        throw new Exception();
                }
                count = false;
            }catch(Exception e){
                count=true;
            }
        }while(count = true);
    }
}