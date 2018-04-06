import akka.actor.Actor;
import akka.actor.ActorRef;
import akka.actor.ActorSystem;

import java.io.IOException;
import java.util.Date;

import model.CassandraWriter;
import model.Collector;
import model.Streamer;
import model.Tweet;

import static java.lang.Thread.sleep;

public class Main {
    public static void main(String[] args) {
        final ActorSystem system = ActorSystem.create("System");

        //#create-actors

        final ActorRef writerActor =
                system.actorOf(CassandraWriter.props(), "writerActor");
        final ActorRef streamerActor =
                system.actorOf(Streamer.props(writerActor), "streamerActor");
        //#create-actors

        //#main-send-messages
        streamerActor.tell(new Streamer.StreamByKeyword("beer"), ActorRef.noSender());
        //#main-send-messages

        try {
            System.in.read();
//            writerActor.tell(tweet, ActorRef.noSender());
        } catch (IOException ioe) {
            system.stop(streamerActor);
        } finally {
            system.terminate();
        }
    }
}
