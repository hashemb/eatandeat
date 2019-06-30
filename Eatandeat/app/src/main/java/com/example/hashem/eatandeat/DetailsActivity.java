package com.example.hashem.eatandeat;

import android.app.Activity;
import android.os.Bundle;

public class DetailsActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        ReviewDetailFragment ReviewDetailFragment = (ReviewDetailFragment)
                getFragmentManager().findFragmentById(R.id.detail_frag);
        int reviewId = (int) getIntent().getExtras().get("id");
        ReviewDetailFragment.setReviewId(reviewId);


    }
}
