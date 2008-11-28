package com.conant.order.vo;
// Generated 2008-11-16 19:21:15 by Hibernate Tools 3.2.1.GA

/**
 * OrsTintcolor generated by hbm2java
 */
public class TintColor  implements java.io.Serializable {
     private Integer id;
     private String code;
     private Integer transparencyrate;

    public TintColor() {
    }

    public TintColor(String code) {
        this.code = code;
    }
    public TintColor(String code, Integer transparencyrate) {
       this.code = code;
       this.transparencyrate = transparencyrate;
    }
    
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    
    public String getCode() {
        return this.code;
    }
    
    public void setCode(String code) {
        this.code = code;
    }
    
    public Integer getTransparencyrate() {
        return this.transparencyrate;
    }
    
    public void setTransparencyrate(Integer transparencyrate) {
        this.transparencyrate = transparencyrate;
    }
}
