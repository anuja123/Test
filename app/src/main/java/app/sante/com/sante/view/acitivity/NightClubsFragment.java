package app.sante.com.sante.view.acitivity;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import app.sante.com.sante.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link NightClubsFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link NightClubsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class NightClubsFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_night_clubs, container, false);
    }



}
