/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package system;

/**
 *
 * @author HP
 */
public class Realaccount implements Login{
    public void connectTo(String authen){
        System.out.println("Connecting to " + authen);
    }
}
