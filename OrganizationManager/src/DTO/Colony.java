/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author Admin
 */
public class Colony extends Organization{
protected String place;
public Colony(){
    super();
}

    public Colony(int size, String place) {
        super(size);
        this.place = place;
    }

    
    @Override
    public void communicateByTool() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public void grow(){
        System.out.println("an annual cycle of growth that begins in spring");
    }
    public void reproduce(){
        System.out.println("Colony can reproduce itself through a process");
    }

    @Override
    public String toString() {
        return "Colony{" + "place=" + place + '}';
    }
    
}
