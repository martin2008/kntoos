package com.conant.order.vo;
// Generated 2008-11-16 19:21:15 by Hibernate Tools 3.2.1.GA


import java.util.HashSet;
import java.util.Set;

/**
 * OrsFrameModel generated by hbm2java
 */
public class FrameModel  implements java.io.Serializable {


     private Integer id;
     private String collection;
     private int rimless;
     private String framemodel;
     private Set<FrameDetail> framedetails = new HashSet<FrameDetail>(0);

    public FrameModel() {
    }

	
    public FrameModel(String collection, int rimless, String framemodel) {
        this.collection = collection;
        this.rimless = rimless;
        this.framemodel = framemodel;
    }
    public FrameModel(String collection, int rimless, String framemodel, Set<FrameDetail> framedetails) {
       this.collection = collection;
       this.rimless = rimless;
       this.framemodel = framemodel;
       this.framedetails = framedetails;
    }

    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    
    public String getCollection() {
        return this.collection;
    }
    
    public void setCollection(String collection) {
        this.collection = collection;
    }
    
    public int isRimless() {
        return this.rimless;
    }
    
    public void setRimless(int rimless) {
        this.rimless = rimless;
    }
    
    public String getFramemodel() {
        return this.framemodel;
    }
    
    public void setFramemodel(String framemodel) {
        this.framemodel = framemodel;
    }
    
    public Set<FrameDetail> getFramedetails() {
        return this.framedetails;
    }
    
    public void setFramedetails(Set<FrameDetail> framedetails) {
        this.framedetails = framedetails;
    }
}
