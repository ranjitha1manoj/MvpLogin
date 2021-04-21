package in.welldoc.ui.home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import in.welldoc.R;
import in.welldoc.data.remote.model.Datum;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryViewHolder> {
    private Context context;
    private List<Datum> list;
    private RecyclerItemClickListener recyclerItemClickListener;

    public CategoryAdapter(Context context, List<Datum> list) {
        this.context = context;
        this.list = list;
    }
    public CategoryAdapter(ArrayList<Datum> dataList , RecyclerItemClickListener recyclerItemClickListener) {
        this.list = dataList;
        this.recyclerItemClickListener = recyclerItemClickListener;
    }
    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.view_categories, parent, false);
        return new CategoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {
        holder.heading.setText(list.get(position).getName());
        holder.subHeading.setText(String.valueOf(list.get(position).getDescription()));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recyclerItemClickListener.onItemClick(list.get(position));
            }
        });
    }

    @Override
    public int getItemCount() {
        if (list == null) {
            return 0;
        } else {
            return list.size();
        }

    }
}
