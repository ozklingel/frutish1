package com.selab.volunteer;


import android.widget.ArrayAdapter;

import java.util.ArrayList;

public class EventOneSchema {

    public String type;

    public String location;

    public int price;
    public String eventph;
  //  public ArrayList<String> ApprovedId = new ArrayList<>();
  //  public ArrayList<String> UnApprovedId = new ArrayList<>();



    public EventOneSchema( String name, String location, int price,String eventph) {
        this.type = name;
        this.price = price;
        this.location = location;
        this.eventph=eventph;

    }






}
