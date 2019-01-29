/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.slupski.shopping.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author sluski
 */
@ManagedBean
@ViewScoped
public class HomeView {
    private String hello = "Hello World";
    private String helloTemp = "";
    
    public void onHelloChange() {
        this.hello = this.helloTemp;
    }

    public String getHello() {
        return hello;
    }

    public void setHello(String hello) {
        this.hello = hello;
    }

    public String getHelloTemp() {
        return helloTemp;
    }

    public void setHelloTemp(String helloTemp) {
        this.helloTemp = helloTemp;
    }
    
    
    
    
}
