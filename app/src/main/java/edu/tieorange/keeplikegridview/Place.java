package edu.tieorange.keeplikegridview;

import android.content.Context;
import android.graphics.drawable.Drawable;

import java.util.Random;

/**
 * Created by tieorange on 02/04/16.
 */
public class Place {
    public String name;
    public String imageName;
    public boolean isFav;


    public Drawable getImageResourceId(Context context) {
        if (!isFav)
            return context.getResources().getDrawable(R.drawable.image);
        else
            return context.getResources().getDrawable(R.drawable.clients);
//        return context.getResources().getIdentifier(this.imageName, "drawable", context.getPackageName());
    }
}
