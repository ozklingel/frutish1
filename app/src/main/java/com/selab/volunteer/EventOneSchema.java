package com.selab.volunteer;


public class EventOneSchema {

    public String type;

    public String location;

    public int price;
    public String eventemail;
  //  public ArrayList<String> ApprovedId = new ArrayList<>();
  //  public ArrayList<String> UnApprovedId = new ArrayList<>();



    public EventOneSchema( String name, String location, int price,String eventph) {
        this.type = name;
        this.price = price;
        this.location = location;
        this.eventemail=eventph;

    }






}
