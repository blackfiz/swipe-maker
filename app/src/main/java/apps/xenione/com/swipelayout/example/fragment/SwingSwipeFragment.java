package apps.xenione.com.swipelayout.example.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import apps.xenione.com.swipelayout.R;
import apps.xenione.com.swipelayout.example.adapter.SwingSwipeAdapter;
import apps.xenione.com.swipelayout.example.data.Album;

/**
 * Created by Eugeni on 13/04/2016.
 */
public class SwingSwipeFragment extends Fragment implements SwingSwipeAdapter.OnItemDismissListener {

    public static final String TAG = "SwingSwipeFragment";

    public static Fragment newInstance() {
        return new SwingSwipeFragment();
    }

    private SwingSwipeAdapter mAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_swipe, container, false);
        initRecyclerView(view);
        return view;
    }

    private void initRecyclerView(View view) {
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.swipe_list);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        mAdapter = new SwingSwipeAdapter(Album.getAlbum());
        mAdapter.setOnItemDismissListener(this);
        recyclerView.setAdapter(mAdapter);
    }

    @Override
    public void onRightItemDismissed(Album album) {
        mAdapter.deleteItem(album);
        Toast.makeText(getContext(), "item swipe right with title :" + album.getName(), Toast.LENGTH_LONG).show();
    }

    @Override
    public void onLeftItemDismissed(Album album) {
        mAdapter.deleteItem(album);
        Toast.makeText(getContext(), "item swipe left at position :" + album.getName(), Toast.LENGTH_LONG).show();
    }
}
