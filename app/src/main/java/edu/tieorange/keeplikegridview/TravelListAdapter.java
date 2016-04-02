package edu.tieorange.keeplikegridview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by tieorange on 02/04/16.
 */
public class TravelListAdapter extends RecyclerView.Adapter<TravelListAdapter.ViewHolder> {

    Context mContext;

    public TravelListAdapter(Context mContext) {
        this.mContext = mContext;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view =
                LayoutInflater.from(parent.getContext()).inflate(R.layout.row_places, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final Place place = new PlaceData().placeList().get(position);
        holder.placeName.setText(place.name);

        holder.placeImage.setImageDrawable(place.getImageResourceId(mContext));
    }

    @Override
    public int getItemCount() {
        return new PlaceData().placeList().size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public LinearLayout mUiPlaceHolder;
        public LinearLayout mUiPlaceNameHolder;
        public TextView placeName;
        public ImageView placeImage;

        public ViewHolder(View itemView) {
            super(itemView);
            mUiPlaceHolder = (LinearLayout) itemView.findViewById(R.id.row_main_holder);
            mUiPlaceNameHolder = (LinearLayout) itemView.findViewById(R.id.row_place_name_holder);
            placeName = (TextView) itemView.findViewById(R.id.row_place_name);
            placeImage = (ImageView) itemView.findViewById(R.id.row_place_image);
        }
    }
}
