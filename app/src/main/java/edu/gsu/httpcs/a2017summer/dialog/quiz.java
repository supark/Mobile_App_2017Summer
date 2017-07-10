package edu.gsu.httpcs.a2017summer.dialog;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.view.View;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import edu.gsu.httpcs.a2017summer.R;

import android.widget.RadioGroup;

import static edu.gsu.httpcs.a2017summer.R.id.quiz3_yes;
import static edu.gsu.httpcs.a2017summer.R.layout.quiz3;
import static edu.gsu.httpcs.a2017summer.R.style.dialog;

/**
 * Created by supark on 7/2/17.
 */

public class quiz extends Dialog {
    private final ICustomDialogListener listener ;
    private int checkedID = 0;

    @BindView(R.id.activity__quiz_dialog)
    RadioGroup radioGroup;


    public interface ICustomDialogListener {
        public void onOkClicked(String msg);  //interface only define abstract method(this line)

        public void onCancelClicked(Dialog dialog);

        public void systemExit(Dialog dialog);
    }


    @OnClick(R.id.activity_dialog_ok)
    public void submit(View view) {
        switch (checkedID) {
            case quiz3_yes:
                listener.onOkClicked("Yes");
                cancel();
                break;
            case R.id.quiz3_no:
                listener.onOkClicked("No");
                cancel();
                break;
            case R.id.quiz3_exit:
                listener.systemExit(this);
                break;

            default:
        }
    }

    @OnClick(R.id.activity_dialog_cancel)
    public void cancel() {
        listener.onCancelClicked(this);

    }



    public quiz(@NonNull Context context, ICustomDialogListener listener) {

        super(context, dialog);
        setContentView(quiz3);
        this.listener = listener;
        ButterKnife.bind(this);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                checkedID = checkedId;

            }
        });
    }


}
