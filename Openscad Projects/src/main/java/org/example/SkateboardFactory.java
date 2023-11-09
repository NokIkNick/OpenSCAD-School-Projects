package org.example;

import org.abstractica.javacsg.Geometry2D;
import org.abstractica.javacsg.Geometry3D;
import org.abstractica.javacsg.JavaCSG;

public class SkateboardFactory {

    private JavaCSG csg;

    public SkateboardFactory(JavaCSG csg){
        this.csg = csg;
    }

    public Geometry3D createBoard(){
        //Initial box in the middle of the board:
        Geometry3D initialBoard = csg.box3D(15,50,2.5,false);

        //Half circle 1 at the edge of the board:
        Geometry3D halfCircle1 = csg.cylinderSegment3D(15,2.5,csg.degrees(0),csg.degrees(180),10,false);
        halfCircle1 = csg.translate3DY(25).transform(halfCircle1);

        //Half circle 2 at the other edge of the board:
        Geometry3D halfCircle2 = csg.cylinderSegment3D(15,2.5,csg.degrees(0),csg.degrees(180),10,false);
        halfCircle2 = csg.rotate3DX(csg.degrees(180)).transform(halfCircle2);
        halfCircle2 = csg.translate3D(0,-25,2.5).transform(halfCircle2);

        //Squares to hold the holderbars:
        Geometry3D wheelHolderSquareBar1 = csg.box3D(5,5,2,false);
        wheelHolderSquareBar1 = csg.translate3D(0,20,-1).transform(wheelHolderSquareBar1);

        Geometry3D wheelHolderSquareBar2 = csg.box3D(5,5,2,false);
        wheelHolderSquareBar2 = csg.translate3D(0,-20,-1).transform(wheelHolderSquareBar2);

        //Wheel holderbars:
        Geometry3D wheelHolderBar1 = csg.cylinder3D(2,16,20,true);
        wheelHolderBar1 = csg.rotate3D(csg.degrees(90), csg.degrees(0), csg.degrees(90)).transform(wheelHolderBar1);
        wheelHolderBar1 = csg.translate3D(0,20,-1.5).transform(wheelHolderBar1);

        Geometry3D wheelHolderBar2 = csg.cylinder3D(2,16,20,true);
        wheelHolderBar2 = csg.rotate3D(csg.degrees(90), csg.degrees(0), csg.degrees(90)).transform(wheelHolderBar2);
        wheelHolderBar2 = csg.translate3D(0,-20,-1.5).transform(wheelHolderBar2);

        //Union of model:
        Geometry3D model = csg.union3D(initialBoard, halfCircle1, halfCircle2, wheelHolderSquareBar1, wheelHolderSquareBar2, wheelHolderBar1, wheelHolderBar2);
        return model;
    }


}
