package com.example.landmarkbook;

import android.graphics.Bitmap;

public class Singleton { //Resimlerin DetailActivityi'de kullanılabilmesi için gerekli Class

    private Bitmap chosenImage;
    private static Singleton singleton;

    private Singleton(){


    }

    public Bitmap getChosenImage() {
        return chosenImage;
    }

    public void setChosenImage(Bitmap chosenImage) {
        this.chosenImage = chosenImage;
    }

    public static Singleton getInstance(){
        if (singleton == null){
            singleton = new Singleton();
        }

        return singleton;
    }

}
