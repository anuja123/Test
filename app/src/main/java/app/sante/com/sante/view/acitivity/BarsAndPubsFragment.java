package app.sante.com.sante.view.acitivity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import app.sante.com.sante.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link BarsAndPubsFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link BarsAndPubsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BarsAndPubsFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_bars_and_pubs, container, false);
    }



}
