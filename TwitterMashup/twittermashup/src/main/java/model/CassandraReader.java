package model;

import akka.actor.AbstractActor;


public class CassandraReader extends AbstractActor {

    SparkConf conf = new SparkConf()
            .setAppName( "My application");
    SparkContext sc = new SparkContext(conf);


    @Override
    public Receive createReceive() {
        return null;
    }


}
