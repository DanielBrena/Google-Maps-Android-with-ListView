package ulsa.brena.com.maps.adapter;

import android.content.Context;

import android.content.Intent;
import android.graphics.Bitmap;
;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import android.widget.TextView;

import ulsa.brena.com.maps.Mapa;
import ulsa.brena.com.maps.R;
import java.util.ArrayList;

/**
 * Created by DanielBrena on 27/09/15.
 */
public class ListViewAdapter extends ArrayAdapter {
    private Context context;
    private int layoutResourceId;

    ViewHolder holder = null;
    private ArrayList data = new ArrayList();

    public ListViewAdapter(Context context, int layoutResourceId, ArrayList data) {
        super(context, layoutResourceId, data);
        this.layoutResourceId = layoutResourceId;
        this.context = context;
        this.data = data;
    }

    @Override
    public View getView(int position, final View convertView, ViewGroup parent) {
        View row = convertView;
        holder = null;

        if (row == null) {
            LayoutInflater inflater = LayoutInflater.from(context);// ((Activity) context).getLayoutInflater();

            row = inflater.inflate(layoutResourceId, parent, false);
            holder = new ViewHolder();

            holder.name = (TextView) row.findViewById(R.id.name);
            holder.lat = (TextView) row.findViewById(R.id.lat);
            holder.lng = (TextView) row.findViewById(R.id.lng);
            row.setTag(holder);
        } else {
            holder = (ViewHolder) row.getTag();
        }

        final Ubicacion item = (Ubicacion) data.get(position);




        row.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(context,Mapa.class);
                Bundle extras = new Bundle();
                extras.putString("name",item.getName());
                extras.putString("lat",item.getLat());
                extras.putString("lng",item.getLng());
                i.putExtras(extras);
                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(i);
            }
        });

        holder.name.setText(item.getName());
        holder.lat.setText(item.getLat());
        holder.lng.setText(item.getLng());
        return row;
    }

    static class ViewHolder {
        TextView name;
        TextView lat;
        TextView lng;
    }
}
