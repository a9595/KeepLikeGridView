package edu.tieorange.keeplikegridview;

import android.content.Context;
import android.graphics.drawable.Drawable;

/**
 * Created by tieorange on 02/04/16.
 */
public class Place {
    public String name;
    public String imageName;
    public boolean isFav;

    public Drawable getImageResourceId(Context context) {
        return context.getResources().getDrawable(R.drawable.image);
//        return context.getResources().getIdentifier(this.imageName, "drawable", context.getPackageName());
    }
}
