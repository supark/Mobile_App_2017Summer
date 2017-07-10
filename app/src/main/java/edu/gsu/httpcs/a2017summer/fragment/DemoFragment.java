package edu.gsu.httpcs.a2017summer.fragment;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

import edu.gsu.httpcs.a2017summer.ActivityA;
import edu.gsu.httpcs.a2017summer.AdvanceListViewActivity;
import edu.gsu.httpcs.a2017summer.AdvancedViewPagerActivity;
import edu.gsu.httpcs.a2017summer.AnimationActivity;
import edu.gsu.httpcs.a2017summer.AnimatorActivity;
import edu.gsu.httpcs.a2017summer.CheckBoxActivity;
import edu.gsu.httpcs.a2017summer.DialogActivity;
import edu.gsu.httpcs.a2017summer.GestureActivity;
import edu.gsu.httpcs.a2017summer.HandlerActivity;
import edu.gsu.httpcs.a2017summer.NotificationActivity;
import edu.gsu.httpcs.a2017summer.PatchActivity;
import edu.gsu.httpcs.a2017summer.R;
import edu.gsu.httpcs.a2017summer.RadioGroupActivity;
import edu.gsu.httpcs.a2017summer.ResultActivity;
import edu.gsu.httpcs.a2017summer.RunableHandlerActivity;
import edu.gsu.httpcs.a2017summer.ScaleTypeActivity;
import edu.gsu.httpcs.a2017summer.ServiceActivity;
import edu.gsu.httpcs.a2017summer.SharedPreferenceActivity;
import edu.gsu.httpcs.a2017summer.TestAudioActivity;
import edu.gsu.httpcs.a2017summer.ViewPagerActivity;
import edu.gsu.httpcs.a2017summer.adapter.ListNormalAdapter;
import edu.gsu.httpcs.a2017summer.audio.BaseBean;


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
        contentList.add("Notification");
        contentList.add("AdvanceListView");
        contentList.add("AdvanceViewPager");
        contentList.add("LaunchMode");
        contentList.add("ActivityResult"); //
        contentList.add("RadioGroup");
        contentList.add("CheckBox");
        contentList.add("Dialog");
        contentList.add("Handler");
        contentList.add("RunableHandler");
        contentList.add("Animation");
        contentList.add("Animator");
        contentList.add("Gesture");
        contentList.add("SharedPreference");
        contentList.add("ServiceBroadCast");
        contentList.add("TestAudioPlayer");
        contentList.add("AudioPlayer");

    }


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
                    case 2:
                        Intent intent2 = new Intent(getActivity(), PatchActivity.class);
                        startActivity(intent2);
                        break;
                    case 3:
                        Intent intent3 = new Intent(getActivity(), NotificationActivity.class);
                        startActivity(intent3);
                        break;
                    case 4:
                        Intent intent4 = new Intent(getActivity(), AdvanceListViewActivity.class);
                        startActivity(intent4);
                        break;
                    case 5:
                        Intent intent5 = new Intent(getActivity(), AdvancedViewPagerActivity.class);
                        startActivity(intent5);
                        break;
                    case 6:
                        Intent intent6 = new Intent(getActivity(), ActivityA.class);
                        intent6.putExtra("StringInfo", "fromDemoFragment");  //intent carry some information
                        intent6.putExtra("IntegerInfo", 10); //It should be match "IntegerInfo" with ActivityA

                        Bundle bundle = new Bundle();  //

                        BaseBean bean = new BaseBean();
                        bean.setName("bean");

                        bundle.putString("StringBundle", "FromBundleDemo");
                        bundle.putInt("IntegerBundle", 101);

                        bundle.putSerializable("Object", bean);

                        intent6.putExtra("Bundle", bundle);
                        startActivity(intent6);
                        break;
                    case 7:
                        Intent intent7 = new Intent(getActivity(), ResultActivity.class);
                        startActivity(intent7);  //
                        break;
                    case 8:
                        Intent intent8 = new Intent(getActivity(), RadioGroupActivity.class);
                        startActivity(intent8);  //
                        break;
                    case 9:
                        Intent intent9 = new Intent(getActivity(), CheckBoxActivity.class);
                        startActivity(intent9);  //
                        break;
                    case 10:
                        Intent intent10 = new Intent(getActivity(), DialogActivity.class);
                        startActivity(intent10);  //
                        break;
                    case 11:
                        Intent intent11 = new Intent(getActivity(), HandlerActivity.class);
                        startActivity(intent11);  //
                        break;
                    case 12:
                        Intent intent12 = new Intent(getActivity(), RunableHandlerActivity.class);
                        startActivity(intent12);  //
                        break;
                    case 13:
                        Intent intent13 = new Intent(getActivity(), AnimationActivity.class);
                        startActivity(intent13);  //
                        break;
                    case 14:
                        Intent intent14 = new Intent(getActivity(), AnimatorActivity.class);
                        startActivity(intent14);  //
                        break;
                    case 15:
                        Intent intent15 = new Intent(getActivity(), GestureActivity.class);
                        startActivity(intent15);  //
                        break;
                    case 16:
                        Intent intent16 = new Intent(getActivity(), SharedPreferenceActivity.class);
                        startActivity(intent16);  //
                        break;
                    case 17:
                        Intent intent17 = new Intent(getActivity(), ServiceActivity.class);
                        startActivity(intent17);  //
                        break;
                    case 18:
                        Intent intent18 = new Intent(getActivity(), TestAudioActivity.class);
                        startActivity(intent18);  //
                        break;
//                    case 19:
//                        Intent intent19 = new Intent(getActivity(), AudioPlayerActivity.class);
//                        startActivity(intent19);  //
//                        break;

                    default:
                }
            }
        });
        return view;
    }

}
