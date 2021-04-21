package in.welldoc.ui.home;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import in.welldoc.R;

public class CategoryViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    ImageView image;
    TextView heading;
    TextView subHeading;
    ConstraintLayout order_constraint;
    // WeakReference<OrderDetailsClickListener> weakReference;

    public CategoryViewHolder(@NonNull View itemView) {
        super(itemView);
        image = itemView.findViewById(R.id.image);
        heading = itemView.findViewById(R.id.name);
        subHeading = itemView.findViewById(R.id.description);
        order_constraint = itemView.findViewById(R.id.order_constraint);
        //  weakReference = new WeakReference<>(listener);
        //view.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

    }
}