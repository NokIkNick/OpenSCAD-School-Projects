package org.example;

import org.abstractica.javacsg.JavaCSG;
import org.abstractica.javacsg.JavaCSGFactory;

public class Main {
    public static void main(String[] args) {

        JavaCSG csg = JavaCSGFactory.createNoCaching();
        SkateboardFactory skateboardFactory = new SkateboardFactory(csg);

        WheelFactory wheelFactory = new WheelFactory(csg);



        //VIEWS
        csg.view(skateboardFactory.createBoard(),0);
        csg.view(wheelFactory.createWheel(),1);
    }
}