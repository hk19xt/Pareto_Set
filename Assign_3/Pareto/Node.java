package Pareto;

import java.io.*;

class Node implements Serializable{

  Observation item;
  Node next;
  

  
 public Node(Observation i, Node n){
   
    item = i;
    next = n;
 
     };

}//Node