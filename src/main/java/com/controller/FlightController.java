package main.java.com.controller;

import main.java.com.model.*;

public class FlightController{
    private Flight[] filghts;

    public FlightController(){
	setFlights();
    }

    public void setFlight(){
	this.filghts = new Flight;
    }

    public Flight[] getFlight(){
	return filghts;
    }

    public void addFlight(Fligth f){
	int fL = this.filghts.lenght();
	Flight[] nF = new Flight[fL+1];

	for(i = 0; i < fL; i++){
	    nF[i] = this.filgths[i];
	}

	nF[fL] = f;
	this.fligths = nf;
    }

    public void delFlight(Fligth f){
	if(int i = findFlight() != -1){
	    int fL = this.filghts.lenght();
	    int k = 0;
	    Flight[] nF = new Flight[fL-1];
	    
     	    for(j = 0; j < fL-1; j++){
		if(j != i){
		    nF[j] = this.filgths[k];
		    k++;
		}
		else{
		    k++;
		    nF[j] = this.filgths[k];
		    k++;
		}
       	    }
	    this.flight = nF;
       	}
    }

    public int findFligt(Flight f){
	if(!this.filghts.isEmpty()){
	    int fL = this.filghts.lenght();
	    int i = 0;
	    for(i;i < fL;i++){
		if(filghts[i] = f){
		    return i;
		}
	    }
	}
	return -1;
    }
}
