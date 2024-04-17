package main.java.com.controller;

import main.java.com.data.TicketTable;
import main.java.com.model.*;
import main.java.com.tables.*;

public class TicketController{
    private Ticket[]
    tickets;
        private TicketTable 
        db; 
        public TicketController() throws 
        Exception {
            setTickets();
        }
        public void 
        setTickets() throws
        Exception{
            this.tickets =
            db.getTickets();
        }
        public Ticket[]
        getTicket(){ 
            return tickets;
        }

        public void
        addTicket(Ticket t)
        throws Exception{
            db.add(t);
            setTickets();
        }
        public void 
        delTicket(Ticket t)
        throws Exception{
            db.del(t);
            setTickets();
        }
        public Ticket
        findTicket(String id, String depart, String departT)
        throws Exception{ return db.find(id,depart,departT);

}

public void update(String id, Sting depart, String departT, Ticket nf)
throws Exception{ Ticket f = findTicket(id, depart, departT); 
if (t != null) {if(nf !=null)
{db.update(t,nf);}
else{
    db.del(t);
}
setTickets();}
else{
    if(nf !=null){
        db.add(f);
        setTickets();
    }
}
}
