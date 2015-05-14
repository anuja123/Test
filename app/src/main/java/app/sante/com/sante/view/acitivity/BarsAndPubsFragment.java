package app.sante.com.sante.view.acitivity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

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

    public TextView info ;
    View myInflatedView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        myInflatedView = inflater.inflate(R.layout.fragment_bars_and_pubs, container, false);
        return myInflatedView;
    }

    public void UpdateTextView(String data) {
        Log.e("TextView", data);
        /*TextView t = (TextView) myInflatedView.findViewById(R.id.txtBars);
        t.setText(data);*/

    }

    private String tag;

    public void setCustomTag(String tag)
    {
        this.tag = tag;
    }

    public String getCustomTag()
    {
        return tag;
    }


}
