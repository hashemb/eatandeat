package com.example.hashem.eatandeat;


import android.app.Activity;
import android.app.ListFragment;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;


/**
 * A simple {@link Fragment} subclass.
 */
public class ReviewsListFragment extends ListFragment {
static interface ReviewListListener{
    void itemClicked(long id);
}

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.listener = (ReviewListListener) activity;
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        if(listener != null){
            listener.itemClicked(id);
        }
    }
private ReviewListListener listener;
    public ReviewsListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        String[] names = new String[Review.reviews.length];
        for(int i=0; i<names.length; i++){
            names[i] = Review.reviews[i].getName();
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(inflater.getContext(), android.R.layout.simple_list_item_1, names);
        setListAdapter(adapter);




        return super.onCreateView(inflater,container,savedInstanceState);
    }

}
