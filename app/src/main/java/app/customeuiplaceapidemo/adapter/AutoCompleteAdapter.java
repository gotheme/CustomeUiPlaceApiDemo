package app.customeuiplaceapidemo.adapter;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.util.List;

import app.customeuiplaceapidemo.R;
import app.customeuiplaceapidemo.models.Results;


public class AutoCompleteAdapter extends ArrayAdapter<Results> {
    ViewHolder holder;
    Context context;
    List<Results> Places;
    private Activity mActivity;

    public AutoCompleteAdapter(Context context, List<Results> modelsArrayList, Activity activity) {
        super(context, R.layout.autocomplete_row, modelsArrayList);
        this.context = context;
        this.Places = modelsArrayList;
        this.mActivity = activity;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View rowView = convertView;
        ViewHolder holder;
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            rowView = inflater.inflate(R.layout.autocomplete_row, parent, false);
            holder = new ViewHolder();
            holder.name = (TextView) rowView.findViewById(R.id.place_name);
            holder.location = (TextView) rowView.findViewById(R.id.place_detail);
            rowView.setTag(holder);

        } else
            holder = (ViewHolder) rowView.getTag();
        /***** Get each Model object from ArrayList ********/
        holder.results = Places.get(position);
        holder.name.setText(holder.results.getName());
        holder.location.setText(holder.results.getFormattedAddress());
        return rowView;
    }

    class ViewHolder {
        Results results;
        TextView name, location;
    }

    @Override
    public int getCount(){
        return Places.size();
    }
}