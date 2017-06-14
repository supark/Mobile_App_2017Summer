package edu.gsu.httpcs.a2017summer.fragment;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.constraint.solver.ArrayLinkedVariables;
import android.support.v4.app.Fragment;
import android.support.v4.widget.ListViewAutoScrollHelper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

import edu.gsu.httpcs.a2017summer.LaunchModeActivity;
import edu.gsu.httpcs.a2017summer.R;
import edu.gsu.httpcs.a2017summer.ScaleTypeActivity;
import edu.gsu.httpcs.a2017summer.ViewPagerActivity;
import edu.gsu.httpcs.a2017summer.adapter.ListNormalAdapter;


import static android.icu.lang.UCharacter.GraphemeClusterBreak.V;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DemoFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DemoFragment extends Fragment {

    private final ArrayList<String> contentList;
    private ListView listView;
    private final Context context;

    public DemoFragment() {  //constructor
        context = getContext();
        // Required empty public constructor
        contentList = new ArrayList<String>();
        contentList.add("ViewPager");
        contentList.add("ImageScaleType");
        contentList.add("9Patch");
        contentList.add("A");
        contentList.add("B");
        contentList.add("C");
        contentList.add("LaunchMode");
        contentList.add("E");
        contentList.add("F");
        contentList.add("G");
        contentList.add("H");
        contentList.add("I");
        contentList.add("J");
        contentList.add("K");

    }


//    public static DemoFragment newInstance(String param1, String param2) {
//        DemoFragment fragment = new DemoFragment();
//        Bundle args = new Bundle();
//        fragment.setArguments(args);
//        return fragment;
//    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_demo, container, false);
        listView = (ListView)view.findViewById(R.id.fragment_demo_lv);
        ListNormalAdapter adapter = new ListNormalAdapter(this.getContext(), contentList);
        listView.setAdapter(adapter);
        // Inflate the layout for this fragment

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        Intent intent = new Intent(getActivity(), ViewPagerActivity.class);
                        startActivity(intent);   //query, to go to activity, to store startActivity method, this is for first listView
                        break;
                    case 1:
                        Intent intent1 = new Intent(getActivity(), ScaleTypeActivity.class);
                        startActivity(intent1);
                        break;
                    case 6:
                        Intent intent6 = new Intent(getActivity(), LaunchModeActivity.class);
                        startActivity(intent6);

                    default:
                }
            }
        });
        return view;
    }

}
