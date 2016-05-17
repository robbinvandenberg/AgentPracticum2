package practicumagent;

import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.core.behaviours.OneShotBehaviour;
import jade.lang.acl.ACLMessage;
import org.apache.commons.lang.ObjectUtils;
import java.util.Arrays;

public class FifteenAgent extends Agent {

    private String[] names;

    protected void setup() {

        addBehaviour(new OneShotBehaviour(){
            public void action() {
                Object[] args = getArguments();
                names = new String[args.length];
                int index = 0;
                for (Object o : args){
                    names[index] = o.toString();
                    index++;
                }
                System.out.println(Arrays.toString(names));
            }
        });

        addBehaviour(new CyclicBehaviour() {
            public void action(){
                ACLMessage receivedMessage = receive();
                if (receivedMessage!= null){
//                    ACLMessage reply = receivedMessage.createReply();
//                    reply.setPerformative(ACLMessage.INFORM);
//                    reply.addReceiver(receivedMessage.getSender());
//                    reply.setContent("Hello!");
//                    send(reply);

                }
            }
        });

    }
}
