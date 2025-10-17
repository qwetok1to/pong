package com.example.demo;

import org.springframework.stereotype.Service;


import java.util.ArrayList;


@Service
public class Servision {
    private int sx=3;
    private int sy=3;




    public ArrayList generate(int lastX,int lastY){
        ArrayList<vector> vectors = new ArrayList<>();
        vector vector=new vector();
        vector.x1=lastX;
        vector.x2=vector.x1+sx;
        vector.y1=lastY;
        vector.y2=vector.y2+sy;
        vectors.add(vector);
        for(int i=1;i<10;i++){
            vector.x1=vectors.get(i-1).x2;
            vector.x2=vector.x1+sx;
            vector.y1=vectors.get(i-1).y2;
            vector.y2=vector.y2+sy;
            vectors.add(vector);

        }
        return vectors;

    }
}

