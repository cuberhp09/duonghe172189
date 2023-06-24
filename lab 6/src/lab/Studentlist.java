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
public class Studentlist extends ArrayList<student>{
    public Studentlist(){
        super();
    }
    public student search(String code){
        code = code.trim().toUpperCase();
        for(int i=0; i<this.size();i++){
            if(this.get(i).getCode().equals(code)){
                return (this.get(i));
            }
        }
        return null;
    }
    private boolean isCodeDupplicated(String code){
        code = code.trim().toUpperCase();
        return search(code)!=null;
    }
    public void addStudent(){
        String newCode, newName;
        int newMark;
        boolean codeDupplicated=false;
        do{
            newCode = inputter.inputPattern("St. code s000: ", "[sS][\\d]{3}");
            newCode = newCode.trim().toUpperCase();
            codeDupplicated = isCodeDupplicated(newCode);
            if(codeDupplicated)System.out.println("Code is dupplicated!");
        }
        while(codeDupplicated==true);
        newName = inputter.inputNonBlankStr("Name of new student: ");
        newName = newName.toUpperCase();
        newMark = inputter.inputInt("Mark: ", 0, 10);
        if(newMark*10%10!=0)
        {
            System.out.println("Reenter mark: ");
            newMark = inputter.inputInt("Mark: ", 0, 10);
        }
        student st = new student(newCode, newName, newMark);
        this.add(st);
        System.out.println("Student "+newCode+" has been added.");
    }
    public void searchStudent(){
        if(this.isEmpty()){
            System.out.println("Empty list. No search can be performed!");
            //goto outer;
        }
        else{
            String sCode = inputter.inputStr("Input student code for search: ");
            student st = this.search(sCode);
            if(st == null)
                System.out.println("sudent "+sCode+" doesn't existed!");
            else
                System.out.println("Found: "+st);
        }
    }
    public void updateStudent(){
        if(this.isEmpty())
            System.out.println("Empty list. No update can be performed!");
        else{
            String uCode = inputter.inputStr("Input code of updated student: ");
            student st = this.search(uCode);
            if(st == null)
                System.out.println("Sudent " + uCode + " doesn't existed!");
            else{
                String oldName = st.getName();
                String msg = "Old name: " + oldName + ", new name: ";
                String newName = inputter.inputNonBlankStr(msg);
                st.setName(newName);
                
                int oldMark = st.getMark();
                msg = "Old mark: " +oldMark+", new mark: ";
                int newMark = inputter.inputInt(msg, 0, 10);
                st.setMark(newMark);
                System.out.println("Student "+uCode+" has been updated.");
            }
        }
    }
    public void removeStudent(){
        if(this.isEmpty())
            System.out.println("Empty list. No remove can be performed!");
        else{
            String rCode = inputter.inputStr("Input code of removed student: ");
            student st = this.search(rCode);
            if(st == null)
                System.out.println("Sudent "+rCode+" doesn't existed!");
            else{
                this.remove(st);
                System.out.println("Student "+rCode+" has been removed.");
            }
        }
    }
    public void printAll(){
        if(this.isEmpty())
            System.out.println("Empty list!");
        else{
            System.out.println("Student list: ");
            for(student st: this)System.out.println(st);
            System.out.println("Total: "+this.size()+" student(s).");
        }
    }
}
