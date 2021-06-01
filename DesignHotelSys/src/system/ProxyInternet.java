/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package system;

import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author HP
 */
public class ProxyInternet implements Login {
    private Login login = new Realaccount();
    private static List<String> notallowLogin;
    
    static{
        notallowLogin = new ArrayList<String>();
        notallowLogin.add("abc.com");
        notallowLogin.add("fake.com");
        notallowLogin.add("xxx.com");
    }

@Override
    public void connectTo(String authen) throws Exception
    {
        if(notallowLogin.contains(authen.toLowerCase()))
        {
            throw new Exception("Can't login via this method");
        }
          
        login.connectTo(authen);
    }
  
}

