package practicumagent; /**
 * Created by robbi on 19-4-2016.
 */

import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.core.behaviours.OneShotBehaviour;
import jade.lang.acl.ACLMessage;



public class FifteenAgent extends Agent {

    protected void setup() {
        Object[] args =  getArguments();
        if(args != null) {
            addBehaviour(new OneShotBehaviour() {
                @Override

                public void action() {
                    ACLMessage msg = new ACLMessage();
                    msg.setPerformative(ACLMessage.INFORM);
                    msg.setContent("ik ben nieuw");
                    msg.setLanguage("meta");
                    for (Object o : args) {
                        msg.addReceiver(new AID(o.toString(), AID.ISLOCALNAME));
                    }
                    send(msg);
                }
            });
        }
        addBehaviour(new CyclicBehaviour() {
            @Override
            public void action() {
                /*
                ACLMessage msg = receive();
                if(msg != null) {
                    ACLMessage reply = msg.createReply();
                    reply.setPerformative(ACLMessage.INFORM);
                    reply.setContent("Hello!");
                    reply.addReceiver( msg.getSender() );
                    send(reply);
                }
                */
            }

        });
    }

}
