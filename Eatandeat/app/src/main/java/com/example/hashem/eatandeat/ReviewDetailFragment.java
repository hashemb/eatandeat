package com.example.hashem.eatandeat;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class ReviewDetailFragment extends Fragment {

private long reviewId;

    public void setReviewId(long reviewId) {
        this.reviewId = reviewId;
    }

    public ReviewDetailFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        if(savedInstanceState != null) {
reviewId = savedInstanceState.getLong("reviewId");

        }
        return inflater.inflate(R.layout.fragment_review_detail, container, false);


    }


    @Override
    public void onStart() {
        super.onStart();
        View v = getView();
        if(v!=null){
            TextView tvTitle = (TextView) v.findViewById(R.id.nameView);
            TextView tvDescription = (TextView) v.findViewById(R.id.descView);

            Review r = Review.reviews[(int) reviewId];
            tvTitle.setText(r.getName());
            tvDescription.setText(r.getDesc());
        }
    }

public void onSaveInstanceState(Bundle savedInstanceState){
        savedInstanceState.putLong("reviewId",reviewId);

}
}

