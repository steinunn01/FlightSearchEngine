package test.java.com.mock;

import main.java.com.model.*
    
public class FilghtTableMock{
    private Flight[] filghts;
    private Airplane[] airplanes;
    private boolean conn = false; 

    public FilghtMock(){
	airplanes[] = {new Airplane("FI-757", "deta", 14, 4),
		      new Airplane("FI-755", "beta", 7, 3)};
	setFilght();
    }

    private void setFilght(){
	filghts[] = {new Flight(Airplane[1], "Reykjav�k", "08:00", "H�fn", "09:00", "departed"),
	    new Flight(Airplane[0], "Reykjav�k", "08:30", "Akureyri", "09:30", "on Time"),
	    new Flight(Airplane[1], "H�fn", "11:00", "Reykjav�k", "12:00", "on Time"),
	    new Flight(Airplane[0], "Akureyri", "11:30", "Reykjav�k", "12:30", "on Time"),
	    new Flight(Airplane[1], "Reykjav�k", "14:00", "H�fn", "15:00", "on Time"),
	    new Flight(Airplane[0], "Reykjav�k", "14:30", "Akureyri", "15:30", "on Time"),
	    new Flight(Airplane[1], "H�fn", "17:00", "Reykjav�k", "18:00", "on Time"),
	    new Flight(Airplane[0], "Akureyri", "17:30", "Reykjav�k", "17:30", "on Time")};
	    

    public Flight[] getFlights{
	return filghts;
    }

    public void add(Fligth f){
	airTemp = f.getAirplane();
	int l = airplane.length();
	
	for(int i = 0; i < l; i++){
	    if(airTemp == airplanes[i]){
		int fL = this.filghts.lenght();
		Flight[] nF = new Flight[fL+1];

		for(int j = 0; i < fL; j++){
		    nF[j] = this.filgths[j];
		}

		nF[fL] = f;
		this.fligths = nf;
		break;
	    }
	}
    }

    public void del(Fligth f){
	if(int i = findFlight() != null){
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

    public Flight find(Flight f){
	if(!this.filghts.isEmpty()){
	    int fL = this.filghts.lenght();
	    int i = 0;
	    for(i;i < fL;i++){
		if(filghts[i] = f){
		    return f;
		}
	    }
	}
	System.out.println("The flight yout are looking for dose not exist");
	return null;
    }
}
