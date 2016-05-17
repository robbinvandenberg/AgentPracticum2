package practicumagent;

/**
 * Created by martijn on 17-5-2016.
 */

import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.core.behaviours.OneShotBehaviour;
import jade.core.behaviours.TickerBehaviour;
import jade.lang.acl.ACLMessage;


public class PrisonerAgent extends Agent {

    private String type;

    protected void setup() {
        Object[] args =  getArguments();
        type = (String)args[0];

        addBehaviour(new TickerBehaviour(this,2000) {
            @Override
            public void onTick() {
                ACLMessage msg = myAgent.receive();
                if (msg != null) {
                    if (msg.getPerformative() == ACLMessage.PROPOSE) {
                        ACLMessage msg1 = new ACLMessage();
                        msg1.setPerformative(ACLMessage.ACCEPT_PROPOSAL);
                        //msg1.setContent("ik ben random");
                        msg1.setLanguage("meta");
                        msg1.addReceiver(msg.getSender());
                        send(msg1);
                    }
                    if(msg.getPerformative()==ACLMessage.ACCEPT_PROPOSAL){
                        PrisonersDilemma pris = new PrisonersDilemma();
                        double x = (int)Math.random();
                        if(x < 0.5){

                        }
                        else{

                        }
                    }
                }
            }
        });

        if(type.equals("random")) {
            addBehaviour(new CyclicBehaviour() {
                @Override
                public void action() {

                }
            });
        }

        if(type.equals("defect")){
            addBehaviour(new CyclicBehaviour() {
                @Override
                public void action() {

                }
            });
        }

        if(type.equals("coop")){
            addBehaviour(new CyclicBehaviour() {
                @Override
                public void action() {

                }
            });

        }

        if(type.equals("tft")) {
            addBehaviour(new CyclicBehaviour() {
                @Override
                public void action() {

                }
            });

        }
    }

}