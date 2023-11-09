package org.example;

import org.abstractica.javacsg.Geometry3D;
import org.abstractica.javacsg.JavaCSG;

public class WheelFactory {

    private JavaCSG csg;

    public WheelFactory(JavaCSG csg){
        this.csg = csg;
    }


    public Geometry3D createWheel(){
        Geometry3D wheel = csg.hollowCylinder3D(5,2.5,5,20,false);
        return wheel;
    }

}
