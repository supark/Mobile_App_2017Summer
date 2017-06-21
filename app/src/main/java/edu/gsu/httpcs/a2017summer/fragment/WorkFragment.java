package edu.gsu.httpcs.a2017summer.fragment;


import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Optional;
import butterknife.Unbinder;
import edu.gsu.httpcs.a2017summer.ActivityA;
import edu.gsu.httpcs.a2017summer.AdvanceListViewActivity;
import edu.gsu.httpcs.a2017summer.AdvancedViewPagerActivity;
import edu.gsu.httpcs.a2017summer.MainActivity;
import edu.gsu.httpcs.a2017summer.NotificationActivity;
import edu.gsu.httpcs.a2017summer.PatchActivity;
import edu.gsu.httpcs.a2017summer.R;
import edu.gsu.httpcs.a2017summer.ScaleTypeActivity;
import edu.gsu.httpcs.a2017summer.ViewPagerActivity;
import edu.gsu.httpcs.a2017summer.adapter.ListNormalAdapter;
import static android.R.attr.button;
import static android.icu.lang.UCharacter.GraphemeClusterBreak.L;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link WorkFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class WorkFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private Unbinder unbinder;


    public WorkFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment WorkFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static WorkFragment newInstance(String param1, String param2) {
        WorkFragment fragment = new WorkFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
        View view = inflater.inflate(R.layout.fragment_work, container, false);
        unbinder = ButterKnife.bind(this, view);

        return view;
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick(R.id.showMsgIdClicked)
    public void showMsg(){
        Toast.makeText(WorkFragment.this.getContext(), "Submitted successfully", Toast.LENGTH_SHORT).show();
    }

}