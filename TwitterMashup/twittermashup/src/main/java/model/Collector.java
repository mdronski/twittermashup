package model;

import akka.actor.AbstractActor;
import akka.actor.Props;

public class Collector extends AbstractActor {

    static public Props props() {
        return Props.create(Collector.class, () -> new Collector());
    }

    //#collector-messages
    static public class Greeting {
        public Greeting(){}
    }
    //#printer-messages



    public Collector() { }

    @Override
    public AbstractActor.Receive createReceive() {
        return receiveBuilder()
                .match(Greeting.class, greeting -> {

                })
                .build();
    }

}

