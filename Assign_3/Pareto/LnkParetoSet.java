package Pareto;

import java.io.*;

/*@Name: Hyejin Kim
 *@Student# 6823116
 *@Date: 3/6/2020   */


public class LnkParetoSet implements ParetoSet, Serializable {
  
  private double[]  readings;   // the readings
  private Node top;
  
  /*This constructor creates a new, empty stack.*/
  public LnkParetoSet(int nReadings){
    
    readings = new double[nReadings];
    top = null;
    
  };
  
  public int getSize(){
    
    return readings.length;  
    
  }//getSize
  
  private boolean dominate(Observation o1, Observation o2){
    
    if ( o1.getReading(0)<o2.getReading(0)&&
         o1.getReading(1)<o2.getReading(1)){
            return true;
         }      
    else {
            return false;
  }
    }//dominate
        
  
  
    
  public void add(Observation obs){
    
    Node p;
    Node q;
    
    q = null;
    p = top;
    
    while(p!=null){
      if(dominate(p.item, obs)){
        
        return;}
      q=p;
      p=p.next;
    }
    
    if(q==null){
      top = new Node(obs,p);
      
    }else{
      q.next = new Node(obs,p);
      
    }
  }//add
  
    public Observation getBestForIndex(int i){
      
      Observation result;
      Node p;      
      Node q;
      
      p = top;
      q = null;
      
      if(i<0||i>=readings.length){
        throw new DimensionalityException();}
      if(top==null){
        throw new UnderflowException();} 
      
      if(p==null){
        result = null;
      }else{
        result=p.item;
        if(p.item.getReading(0)<=p.item.getReading(1)){
          p.item.getReading(0);
        }else{
          p.item.getReading(1);
          }
      }
      return result;
        }//getBestForIndex
       
    public Observation[] getAll(){
      Observation[] result=null;
      Node p;
      Node q;
      
      p = top;
      q = null;
      if(p==null){
        result=null;
      }else{
        for(int i=0;i<readings.length;i++){
          p.item.getReading(i);
          
        }
      }
      return result;
      
    }//Observation
    
    public void clear(){
      
      top=null;
      
    }//clear
    
    public String toString(){
      Node p;
      Node q;
      String result = "";
      
      q=null;
      p=top;
      
      while(p!=null){
        result += p.item.getLabel();
        q=p;
        p=p.next;
      }
      result +=", ";
      return "[" + result +"]";
      
    }//toString
    
  }//LnkParetoSet
